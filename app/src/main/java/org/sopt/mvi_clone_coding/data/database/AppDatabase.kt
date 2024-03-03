package org.sopt.mvi_clone_coding.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.sopt.mvi_clone_coding.data.entity.ImageEntity
import org.sopt.mvi_clone_coding.data.entity.MultiplierEntity
import org.sopt.mvi_clone_coding.data.entity.NextEvolutionEntity
import org.sopt.mvi_clone_coding.data.entity.PokemonEntity
import org.sopt.mvi_clone_coding.data.entity.PrevEvolutionEntity
import org.sopt.mvi_clone_coding.data.entity.TypeEntity
import org.sopt.mvi_clone_coding.data.entity.WeaknessEntity

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
abstract class AppDatabase : RoomDatabase()
