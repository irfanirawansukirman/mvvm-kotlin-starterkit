package id.ac.unpad.profolio.util

import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceUtil @Inject constructor(private val sharedPreferences: SharedPreferences){

    fun savePref(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun savePref(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun savePref(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    fun savePref(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    fun savePref(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    fun getPrefString(key: String) : String? {
        return sharedPreferences.getString(key, null) ?: null
    }

    fun getPrefBoolean(key: String) : Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun getPrefInt(key: String) : Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun getPrefLong(key: String) : Long {
        return sharedPreferences.getLong(key, 0)
    }

    fun getPrefFloat(key: String) : Float {
        return sharedPreferences.getFloat(key, 0f)
    }

    fun removePref(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

}