package com.mobgen.mobgentest.network

import com.mobgen.mobgentest.utils.Result
import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> resolveResponse(callback: suspend () -> Response<T>): Result<T> {
        try {
            val response = callback()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.Success(body)
            }
            return Result.Error(response.message(),null)
        } catch (ex: Exception) {
            return Result.Error(ex.message,ex)
        }
    }

}