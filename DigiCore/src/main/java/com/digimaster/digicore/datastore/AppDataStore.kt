package com.digimaster.digicore.datastore

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppDatastore(private val context: Context) {

    // buat Datastore
    private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "template_data_store")

    // Buat Preferences Key
    private val CONTENT_KEY = stringPreferencesKey(name = "content_key")

    // Buat Singleton
    companion object {

        @SuppressLint("StaticFieldLeak")
        var INSTANCE: AppDatastore? = null
        fun getInstance(base: Context): AppDatastore? {
            if (INSTANCE == null) {
                synchronized(AppDatastore::class.java) {
                    INSTANCE = AppDatastore(base.applicationContext)
                }
            }

            return INSTANCE
        }
    }

    // Method untuk mengupdate data
    suspend fun setText(s: String) {
        context.datastore.edit { preferences ->
            preferences[CONTENT_KEY] = s
        }
    }

    // Method untuk mengambil data
    val getText: Flow<String> = context.datastore.data.map { preferences ->
        preferences[CONTENT_KEY] ?: ""
    }
}