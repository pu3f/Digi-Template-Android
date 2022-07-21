package com.digimaster.digicore.pref

import io.easyprefs.Prefs

//import com.pixplicity.easyprefs.library.Prefs
class PrefUtils {
    companion object{
        fun saveString(key: String, value: String){
            Prefs.write().content(key, value).apply()
        }

        fun saveBoolean(key: String, value: Boolean){
            Prefs.write().content(key, value).commit()
        }

        fun saveInt(key: String, value: Int){
            Prefs.write().content(key, value).commit()
        }

        fun loadString(key: String, defaultValue: String): String{
            return Prefs.read().content(key, defaultValue)
        }

        fun loadBoolean(key: String, defaultValue: Boolean): Boolean{
            return Prefs.read().content(key, defaultValue)
        }

        fun loadInt(key: String, defaultValue: Int): Int{
            return Prefs.read().content(key, defaultValue)
        }
        fun logout(){
            Prefs.clear().all()
        }
    }
}