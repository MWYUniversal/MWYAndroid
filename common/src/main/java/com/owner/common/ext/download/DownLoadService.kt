package com.owner.common.ext.download

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Streaming
import retrofit2.http.Url

/**
 * @date   : 2020/7/13
 *
 */
interface DownLoadService {
    @Streaming
    @GET
    suspend fun downloadFile(
        @Header("RANGE") start: String,
        @Url url: String
    ): Response<ResponseBody>
}