package com.sumit.coroutinewithflow.view.activity

import androidx.lifecycle.*
import com.sumit.coroutinewithflow.model.Resource
import com.sumit.coroutinewithflow.model.User
import com.sumit.coroutinewithflow.repository.UserRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _mutableUserLiveData: MutableLiveData<Resource<User>> = MutableLiveData()

    val userLiveData = _mutableUserLiveData

    private var fetchUserDetailJob: Job? = null

    fun fetchUserDetails(userId: String){

        // Cancel job if running

        fetchUserDetailJob?.cancel()

        // Launch with viewmodel scope, job will be cleared automatically if viewmodel is cleared

        fetchUserDetailJob = viewModelScope.launch {
            UserRepository.getUserDetail(userId).collect{ userDetailResponse ->
                _mutableUserLiveData.value = userDetailResponse
            }
        }

    }
}