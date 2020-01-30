package com.sumit.coroutinewithflow.repository

import androidx.lifecycle.LiveData
import com.sumit.coroutinewithflow.api.CustomRetrofitBuilder
import com.sumit.coroutinewithflow.model.Resource
import com.sumit.coroutinewithflow.model.User
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow

// Singleton repository class

object UserRepository {

    fun getUserDetail(userId: String) = flow {

        emit(Resource.Loading(null))

        try {

            val user = CustomRetrofitBuilder.userService.getUser(userId)
            emit(Resource.Success(user))

        } catch (e: Exception) {

            // Probably a network issue, handle gracefully :)

            emit(Resource.Error(e))

        }
    }

}