package com.mobgen.mobgentest.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.mobgen.mobgentest.domain.Category
import com.mobgen.mobgentest.repository.RepositoryMobgen
import com.mobgen.mobgentest.utils.Result
import com.mobgen.mobgentest.utils.SingleEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class SplashViewModel(private val repository: RepositoryMobgen) : ViewModel() {

    private val job = SupervisorJob()
    val categories = SingleEvent<Result<List<Category>>>()

    init {
        viewModelScope.launch(job + Dispatchers.IO)  {
            categories.postValue(repository.getCategories())
        }
    }

}