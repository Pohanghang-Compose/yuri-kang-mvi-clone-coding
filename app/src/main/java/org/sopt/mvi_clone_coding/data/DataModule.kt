package org.sopt.mvi_clone_coding.data

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.sopt.mvi_clone_coding.data.database.AppDatabase

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "pokemon-database").build()
    }
}