package com.sunnyweather.android.ui.weather

import android.view.animation.Transformation
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.logic.model.Location

class WeatherViewModel : ViewModel() {
    private val locationLiveDate = MutableLiveData<Location>()
    var locationLng = ""
    var locationLat = ""
    var placeName = ""
    val weatherLiveData = Transformations.switchMap(locationLiveDate){location ->
        Repository.refreshWeather(location.lng,location.lat)
    }
    fun refreshWeather(lng : String,lat : String){
        locationLiveDate.value = Location(lng,lat)
    }
}