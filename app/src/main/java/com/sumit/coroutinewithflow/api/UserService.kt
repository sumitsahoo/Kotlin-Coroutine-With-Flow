package com.sumit.coroutinewithflow.api

import com.sumit.coroutinewithflow.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("/user")
    suspend fun getUsers(): List<User>

    @GET("/user/{userId}")
    suspend fun getUser(
        @Path("userId") userId: String
    ): User
}