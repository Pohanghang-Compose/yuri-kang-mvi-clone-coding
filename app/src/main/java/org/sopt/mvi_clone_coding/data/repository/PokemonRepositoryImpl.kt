package org.sopt.mvi_clone_coding.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.sopt.mvi_clone_coding.data.dao.ImageDao
import org.sopt.mvi_clone_coding.data.dao.MultiplierDao
import org.sopt.mvi_clone_coding.data.dao.NextEvolutionDao
import org.sopt.mvi_clone_coding.data.dao.PokemonDao
import org.sopt.mvi_clone_coding.data.dao.PrevEvolutionDao
import org.sopt.mvi_clone_coding.data.dao.TypeDao
import org.sopt.mvi_clone_coding.data.dao.WeaknessDao
import org.sopt.mvi_clone_coding.data.database.AppDatabase
import org.sopt.mvi_clone_coding.data.datasource.PokemonDatasource
import org.sopt.mvi_clone_coding.data.entity.PokemonDetails
import org.sopt.mvi_clone_coding.data.mapper.toImageEntity
import org.sopt.mvi_clone_coding.data.mapper.toMultiplierEntities
import org.sopt.mvi_clone_coding.data.mapper.toNextEvolutionEntities
import org.sopt.mvi_clone_coding.data.mapper.toPokemonEntity
import org.sopt.mvi_clone_coding.data.mapper.toPrevEvolutionEntities
import org.sopt.mvi_clone_coding.data.mapper.toTypeEntities
import org.sopt.mvi_clone_coding.data.mapper.toWeaknessEntities
import java.io.File
import java.io.FileOutputStream

class PokemonRepositoryImpl(
    private val pokemonDataSource: PokemonDatasource,
    private val pokemonDao: PokemonDao,
    private val multiplierDao: MultiplierDao,
    private val nextEvolutionDao: NextEvolutionDao,
    private val prevEvolutionDao: PrevEvolutionDao,
    private val typeDao: TypeDao,
    private val weaknessDao: WeaknessDao,
    private val imageDao: ImageDao,
    private val imageDirectory: String,
    private val imageClient: OkHttpClient,
    private val appDatabase: AppDatabase,
) : PokemonRepository {

    // Pokemon 정보 fetch
    override suspend fun fetch(): Boolean {
        try {
            // dataSource 접근, JSON 파일 내 정보 Entity로 변환 후 DB에 저장
            pokemonDataSource.fetchData().forEach { pokemonDto ->

                pokemonDao.insert(pokemonDto.toPokemonEntity())
                multiplierDao.insertAll(pokemonDto.toMultiplierEntities())
                nextEvolutionDao.insertAll(pokemonDto.toNextEvolutionEntities())
                prevEvolutionDao.insertAll(pokemonDto.toPrevEvolutionEntities())
                typeDao.insertAll(pokemonDto.toTypeEntities())
                weaknessDao.insertAll(pokemonDto.toWeaknessEntities())

                // 이미지 다운로드 후 DB에 저장
                withContext(Dispatchers.IO) {
                    val localUrl = downloadImage(pokemonDto.id, pokemonDto.img)
                    if (localUrl != null) imageDao.insert(pokemonDto.toImageEntity(localUrl))
                }
            }
            return true
        } catch (e: Exception) {
            return false
        }
    }

    override fun clear() {
        // DB 내 모든 테이블 삭제
        appDatabase.clearAllTables()
    }

    override suspend fun getAll(): List<PokemonDetails> {

        // 모든 Pokemon Details 정보 반환
        return pokemonDao.getAll()
    }

    override suspend fun getById(id: Int): PokemonDetails? {

        // id에 해당하는 Pokemon Details 정보 반환
        return pokemonDao.getById(id)
    }

    override suspend fun getByNumbers(numbers: List<String>): List<PokemonDetails> {

        // numbers에 해당하는 Pokemon Details 정보 반환
        return pokemonDao.getByNumbers(numbers)
    }

    private suspend fun downloadImage(id: Int, remoteUrl: String?): String? {
        if (remoteUrl == null) return null

        val request = Request.Builder().url(remoteUrl).build()
        val response = imageClient.newCall(request).execute()
        val imageBytes = response.body?.bytes() ?: return null
        val file = File(imageDirectory, "$id.png")
        FileOutputStream(file).apply {
            write(imageBytes)
            close()
        }

        return file.absolutePath
    }
}
