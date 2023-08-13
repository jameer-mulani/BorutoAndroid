package com.example.borutoandroid.data.local.typeconverters

import androidx.room.TypeConverter

class DatabaseTypeConverters {
    companion object {
        const val StringListSeparator = ","
    }


    @TypeConverter
    fun fromListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        for (string in list) {
            stringBuilder.append(string).append(StringListSeparator)
        }
        stringBuilder.setLength(stringBuilder.length - StringListSeparator.length)
        return stringBuilder.toString()
    }

    fun fromStringToList(string: String): List<String> {
        return string.split(StringListSeparator)
    }


}