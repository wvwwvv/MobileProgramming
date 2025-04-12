package com.example.eweek05a.uicomponents

import android.os.Parcelable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import kotlinx.parcelize.Parcelize

//interface 구현 필요 없이 직렬화 기능 사용 가능
@Parcelize
data class City(val name: String, val country: String) : Parcelable

@Composable
fun CityScreen(modifier: Modifier = Modifier) {
    var selectedCity by rememberSaveable {
        mutableStateOf(City("Madrid", "Spain"))
    }
    Text("${selectedCity.name} ${selectedCity.country}")
}

//직렬화기능이 없으므로 saver 만들어주는 내용 필요
data class City2(val name: String, val country: String) {
    companion object {
        val nameKey = "Name"
        val countryKey = "Country"

        val cityMapSaver = mapSaver(
            save = { mapOf(nameKey to it.name, countryKey to it.country) },
            restore = {
                City2(it[nameKey] as String, it[countryKey] as String)
            }
        )

        val cityListSaver = listSaver<City2, Any>(
            save = { listOf(it.name, it.country) },
            restore = {
                City2(it[0] as String, it[1] as String)
            }
        )

        //우리가 원하는 형태의 자료구조 사용
        val citySaver = Saver<City2, Any>(
            save = {
                listOf(it.name, it.country)
            },
            restore = {
                val list = it as List<Any>
                City2(list[0] as String, list[1] as String)
            }
        )
    }
}

@Composable
fun CityScreen2(modifier: Modifier = Modifier) {
    var selectedCity by rememberSaveable(
        stateSaver = City2.cityMapSaver
    ) {
        mutableStateOf(City2("Madrid", "Spain"))
    }

    Text("${selectedCity.name}\t${selectedCity.country}")
}

@Composable
fun CityScreen3(modifier: Modifier = Modifier) {
    var selectedCity by rememberSaveable(
        stateSaver = City2.cityListSaver
    ) {
        mutableStateOf(City2("Madrid", "Spain"))
    }

    Text("${selectedCity.name}\t${selectedCity.country}")
}

@Composable
fun CityScreen4(modifier: Modifier = Modifier) {
    var selectedCity by rememberSaveable(
        stateSaver = City2.citySaver
    ) {
        mutableStateOf(City2("Madrid", "Spain"))
    }

    Text("${selectedCity.name}\t${selectedCity.country}")
}

// list 안에 list 구조 피하기 위해 flatMap 사용 name, country, name ,,, 으로 저장 -> 2개씩 묶는 작업 필요
@Composable
fun CityScreen5(modifier: Modifier = Modifier) {
    val cityListSaver = listSaver<SnapshotStateList<City2>, Any>(
        save = { list ->
            list.flatMap { city ->
                listOf<Any>(
                    city.name, city.country
                )
            }
        },
        restore = { flat ->
            flat.chunked(2).map { (name, country) ->
                //2개씩 끊어서 city2
                City2(
                    name as String, country as String
                )
            }.toMutableStateList()
        }
    )
    val cityList = rememberSaveable(saver = cityListSaver) {
        mutableStateListOf<City2>(
            City2("Madrid", "Spain"), City2("ToKyo", "Japan"), City2("Seoul", "Korea")
        )
    }

    Column {
        cityList.forEach { city ->
            Text("${city.name}\t${city.country}")
        }
    }
}

@Composable
fun CityScreen6(modifier: Modifier = Modifier) {
    val cityMapSaver = mapSaver(
        save = { list ->
            mapOf(
                "names" to list.map { it.name },
                "countries" to list.map { it.country }
            )
        },
        //key에 대응되는 값을 리스트로
        restore = { map ->
            val names = map["names"] as List<String>
            val countries = map["countries"] as List<String>
            names.zip(countries) //2개를 묶는 함수 zip
                .map { (name, country) -> City2(name, country) }
                .toMutableStateList()
        }
    )

    val cityList = rememberSaveable(saver = cityMapSaver) {
        mutableStateListOf<City2>(
            City2("Madrid", "Spain"), City2("ToKyo", "Japan"), City2("Seoul", "Korea")
        )
    }

    Column {
        cityList.forEach { city ->
            Text("${city.name}\t${city.country}")
        }
    }

}
