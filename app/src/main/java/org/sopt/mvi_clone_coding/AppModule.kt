package org.sopt.mvi_clone_coding

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.sopt.mvi_clone_coding.components.pages.viewmodel.InitViewModel
import org.sopt.mvi_clone_coding.domain.usecase.FetchAllPokemonUseCase

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {
    @ViewModelScoped
    @Provides
    fun provideInitViewModel(
        fetchAllPokemonUseCase: FetchAllPokemonUseCase,
    ): InitViewModel {
        return InitViewModel(fetchAllPokemonUseCase)
    }
}
