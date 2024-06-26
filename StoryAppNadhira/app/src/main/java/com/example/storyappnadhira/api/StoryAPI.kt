package com.example.storyappnadhira.api
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface StoryAPI {
    @POST("v1/register")
    fun register(@Body user: RegisterCredentials): Call<RegisterResponse>

    @POST("v1/login")
    fun login(@Body credentials: LoginCredentials): Call<LoginResponse>


    @GET("v1/stories")
    fun getAllStories(@Header("Authorization") token: String): Call<GetStoriesResponse>

    @GET("v1/stories/{id}")
    fun getStoryDetail(@Path("id") storyId: String, @Header("Authorization") token: String): Call<DetailStoryResponse>

    @Multipart
    @POST("v1/stories")
    fun uploadImage(
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
        @Header("Authorization") token: String
    ): Call<FileUploadResponse>
}