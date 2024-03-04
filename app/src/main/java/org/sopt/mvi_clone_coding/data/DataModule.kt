package org.sopt.mvi_clone_coding.data

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.sopt.mvi_clone_coding.data.dao.ImageDao
import org.sopt.mvi_clone_coding.data.dao.MultiplierDao
import org.sopt.mvi_clone_coding.data.dao.NextEvolutionDao
import org.sopt.mvi_clone_coding.data.dao.PokemonDao
import org.sopt.mvi_clone_coding.data.dao.PrevEvolutionDao
import org.sopt.mvi_clone_coding.data.dao.TypeDao
import org.sopt.mvi_clone_coding.data.dao.WeaknessDao
import org.sopt.mvi_clone_coding.data.database.AppDatabase
import org.sopt.mvi_clone_coding.data.datasource.PokemonDatasource
import org.sopt.mvi_clone_coding.data.repository.ConfigRepository
import org.sopt.mvi_clone_coding.data.repository.PokemonRepository
import org.sopt.mvi_clone_coding.data.repository.PokemonRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
    ): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "pokemon-database")
            .build()
    }

    @Provides
    @Singleton
    fun provideConfigRepository(context: Context): ConfigRepository {
        return ConfigRepository(context)
    }

    @Provides
    @Singleton
    fun provideDatasource(context: Context): PokemonDatasource {
        return PokemonDatasource(context)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    @Singleton
    fun providePokemonRepository(
        pokemonDatasource: PokemonDatasource,
        pokemonDao: PokemonDao,
        multiplierDao: MultiplierDao,
        nextEvolutionDao: NextEvolutionDao,
        prevEvolutionDao: PrevEvolutionDao,
        typeDao: TypeDao,
        weaknessDao: WeaknessDao,
        imageDao: ImageDao,
        imageDirectory: String,
        imageClient: OkHttpClient,
        appDatabase: AppDatabase,
    ): PokemonRepository {
        return PokemonRepositoryImpl(
            pokemonDatasource,
            pokemonDao,
            multiplierDao,
            nextEvolutionDao,
            prevEvolutionDao,
            typeDao,
            weaknessDao,
            imageDao,
            imageDirectory,
            imageClient,
            appDatabase,
        )
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providePokemonDao(appDatabase: AppDatabase): PokemonDao {
        return appDatabase.getPokemonDao()
    }

    @Provides
    @Singleton
    fun provideMultiplierDao(appDatabase: AppDatabase): MultiplierDao {
        return appDatabase.getMultiplierDao()
    }

    @Provides
    @Singleton
    fun provideNextEvolutionDao(appDatabase: AppDatabase): NextEvolutionDao {
        return appDatabase.getNextEvolutionDao()
    }

    @Provides
    @Singleton
    fun providePrevEvolutionDao(appDatabase: AppDatabase): PrevEvolutionDao {
        return appDatabase.getPrevEvolutionDao()
    }

    @Provides
    @Singleton
    fun provideTypeDao(appDatabase: AppDatabase): TypeDao {
        return appDatabase.getTypeDao()
    }

    @Provides
    @Singleton
    fun provideWeaknessDao(appDatabase: AppDatabase): WeaknessDao {
        return appDatabase.getWeaknessDao()
    }

    @Provides
    @Singleton
    fun provideImageDao(appDatabase: AppDatabase): ImageDao {
        return appDatabase.getImageDao()
    }

    @Provides
    @Singleton
    fun provideImageDirectory(application: Application): String {
        return application.filesDir.toString()
    }
}
