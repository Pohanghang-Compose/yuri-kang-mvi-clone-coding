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

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "pokemon-database")
            .build()
    }

    @Provides
    fun provideConfigRepository(context: Context): ConfigRepository {
        return ConfigRepository(context)
    }

    @Provides
    fun provideDatasource(context: Context): PokemonDatasource {
        return PokemonDatasource(context)
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
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
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    fun providePokemonDao(appDatabase: AppDatabase): PokemonDao {
        return appDatabase.getPokemonDao()
    }

    @Provides
    fun provideMultiplierDao(appDatabase: AppDatabase): MultiplierDao {
        return appDatabase.getMultiplierDao()
    }

    @Provides
    fun provideNextEvolutionDao(appDatabase: AppDatabase): NextEvolutionDao {
        return appDatabase.getNextEvolutionDao()
    }

    @Provides
    fun providePrevEvolutionDao(appDatabase: AppDatabase): PrevEvolutionDao {
        return appDatabase.getPrevEvolutionDao()
    }

    @Provides
    fun provideTypeDao(appDatabase: AppDatabase): TypeDao {
        return appDatabase.getTypeDao()
    }

    @Provides
    fun provideWeaknessDao(appDatabase: AppDatabase): WeaknessDao {
        return appDatabase.getWeaknessDao()
    }

    @Provides
    fun provideImageDao(appDatabase: AppDatabase): ImageDao {
        return appDatabase.getImageDao()
    }

    @Provides
    fun provideImageDirectory(application: Application): String {
        return application.filesDir.toString()
    }
}
