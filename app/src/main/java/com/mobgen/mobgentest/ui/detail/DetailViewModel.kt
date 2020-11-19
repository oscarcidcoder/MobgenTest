package com.mobgen.mobgentest.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mobgen.mobgentest.repository.RepositoryMobgen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class DetailViewModel(private val repository: RepositoryMobgen, private val categoryType: Int) : ViewModel()  {

    private val job = SupervisorJob()

    val details = liveData(job + Dispatchers.IO) {
        when (categoryType) {
            0 -> emit(repository.getBooks())
            1 -> emit(repository.getHouses())
            2 -> emit(repository.getCharacters())
            else -> emit(repository.getBooks())
        }
    }

}