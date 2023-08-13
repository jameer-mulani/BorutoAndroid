package com.example.borutoandroid.domain.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.borutoandroid.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.lang.Exception


val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = Constants.PREFERENCES_NAME)
class DataStoreOperationsImpl (context: Context) : DataStoreOperations {

    private object PrefsKeys{
        val setOnBoardingStateKey = booleanPreferencesKey(name = Constants.SET_ONBOARDING_STATE_KEY)
        //add more
    }

    private val dataStore = context.dataStore


    override suspend fun setOnBoardingState(completed: Boolean) {

        dataStore.edit {prefs->
            prefs[PrefsKeys.setOnBoardingStateKey] = completed
        }

    }

    override fun getOnboardingState(): Flow<Boolean> {
        return dataStore.data
            .catch {th->
                if(th is IOException){
                    emit(emptyPreferences())
                }else{
                    throw Exception("Failed to read preferences")
                }
            }
            .map {pref->
                val state = pref[PrefsKeys.setOnBoardingStateKey] ?: false
                state
            }
    }
}