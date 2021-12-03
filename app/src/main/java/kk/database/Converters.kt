package kk.database

import androidx.room.TypeConverter
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import kk.model.*
import java.lang.reflect.Type


class Converters {


    @TypeConverter
    fun stringToBeanList(value: String?): List<ResultData?>? {
        val listType: Type = object : TypeToken<List<ResultData?>?>() {}.type
        return Gson().fromJson<List<ResultData?>>(value, listType)
    }

    @TypeConverter
    fun beanListToString(list: List<ResultData?>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanDob(value: String?): Dob? {
        val listType: Type = object : TypeToken<Dob?>() {}.type
        return Gson().fromJson<Dob>(value, listType)
    }

    @TypeConverter
    fun beanDobToString(list: Dob?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanId(value: String?): Id? {
        val listType: Type = object : TypeToken<Id?>() {}.type
        return Gson().fromJson<Id>(value, listType)
    }

    @TypeConverter
    fun beanIdToString(list: Id?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanLocation(value: String?): Location? {
        val listType: Type = object : TypeToken<Location?>() {}.type
        return Gson().fromJson<Location>(value, listType)
    }

    @TypeConverter
    fun beanLocationToString(list: Location?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanLogin(value: String?): Login? {
        val listType: Type = object : TypeToken<Login?>() {}.type
        return Gson().fromJson<Login>(value, listType)
    }

    @TypeConverter
    fun beanLoginToString(list: Login?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanName(value: String?): Name? {
        val listType: Type = object : TypeToken<Name?>() {}.type
        return Gson().fromJson<Name>(value, listType)
    }

    @TypeConverter
    fun beanNameToString(list: Name?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanPicture(value: String?): Picture? {
        val listType: Type = object : TypeToken<Picture?>() {}.type
        return Gson().fromJson<Picture>(value, listType)
    }

    @TypeConverter
    fun beanPictureToString(list: Picture?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanRegistered(value: String?): Registered? {
        val listType: Type = object : TypeToken<Registered?>() {}.type
        return Gson().fromJson<Registered>(value, listType)
    }

    @TypeConverter
    fun beanRegisteredToString(list: Registered?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanCoordinates(value: String?): Coordinates? {
        val listType: Type = object : TypeToken<Coordinates?>() {}.type
        return Gson().fromJson<Coordinates>(value, listType)
    }

    @TypeConverter
    fun beanCoordinatesToString(list: Coordinates?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanStreet(value: String?): Street? {
        val listType: Type = object : TypeToken<Street?>() {}.type
        return Gson().fromJson<Street>(value, listType)
    }

    @TypeConverter
    fun beanStreetToString(list: Street?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToBeanTimezone(value: String?): Timezone? {
        val listType: Type = object : TypeToken<Timezone?>() {}.type
        return Gson().fromJson<Timezone>(value, listType)
    }

    @TypeConverter
    fun beanTimezoneToString(list: Timezone?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}