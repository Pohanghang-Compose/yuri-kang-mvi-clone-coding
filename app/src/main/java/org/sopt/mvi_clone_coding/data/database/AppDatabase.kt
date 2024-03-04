package org.sopt.mvi_clone_coding.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.sopt.mvi_clone_coding.data.dao.ImageDao
import org.sopt.mvi_clone_coding.data.dao.MultiplierDao
import org.sopt.mvi_clone_coding.data.dao.NextEvolutionDao
import org.sopt.mvi_clone_coding.data.dao.PokemonDao
import org.sopt.mvi_clone_coding.data.dao.PrevEvolutionDao
import org.sopt.mvi_clone_coding.data.dao.TypeDao
import org.sopt.mvi_clone_coding.data.dao.WeaknessDao
import org.sopt.mvi_clone_coding.data.entity.ImageEntity
import org.sopt.mvi_clone_coding.data.entity.MultiplierEntity
import org.sopt.mvi_clone_coding.data.entity.NextEvolutionEntity
import org.sopt.mvi_clone_coding.data.entity.PokemonEntity
import org.sopt.mvi_clone_coding.data.entity.PrevEvolutionEntity
import org.sopt.mvi_clone_coding.data.entity.TypeEntity
import org.sopt.mvi_clone_coding.data.entity.WeaknessEntity
import javax.inject.Singleton

@Database(
    entities = [
        MultiplierEntity::class,
        NextEvolutionEntity::class,
        PrevEvolutionEntity::class,
        PokemonEntity::class,
        TypeEntity::class,
        WeaknessEntity::class,
        ImageEntity::class,
    ],
    version = 1,
)
@Singleton
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMultiplierDao(): MultiplierDao
    abstract fun getNextEvolutionDao(): NextEvolutionDao
    abstract fun getPrevEvolutionDao(): PrevEvolutionDao
    abstract fun getPokemonDao(): PokemonDao
    abstract fun getTypeDao(): TypeDao
    abstract fun getWeaknessDao(): WeaknessDao
    abstract fun getImageDao(): ImageDao
}
