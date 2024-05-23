package com.example.outfitgenerator.apiFits

import com.example.outfitgenerator.models.Outfit
import com.example.outfitgenerator.models.Piece
import com.example.outfitgenerator.models.Respuesta
import com.example.outfitgenerator.models.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface FitsService {
    @GET("pieces/")
    suspend fun getPieceList(@Query("user_id") userId: String?): Deferred<Response<Respuesta>>

    @POST("pieces/")
    suspend fun createPiece(@Body piece: Piece): Deferred<Response<Respuesta>>

    @GET("pieces/{id}")
    suspend fun getPieceDetail(@Path("id") id: String): Deferred<Response<Respuesta>>

    @PUT("pieces/{id}")
    suspend fun updatePiece(@Path("id") id: String, @Body piece: Piece): Deferred<Response<Respuesta>>

    @DELETE("pieces/{id}")
    suspend fun deletePiece(@Path("id") id: String): Deferred<Response<Respuesta>>
    @GET("users/")
    suspend fun getUserByUsername(@Query("username") username: String): Response<Respuesta>

    @GET("piece_category/")
    suspend fun getPieceCategory(
        @Query("category") category: String?,
        @Query("color") color: String?,
        @Query("size") size: String?,
        @Query("user_id") userId: String?
    ): Deferred<Response<Respuesta>>

    @GET("outfit_list/")
    suspend fun getOutfitList(@Query("user_id") userId: String?): Deferred<Response<Respuesta>>

    @POST("create_outfit/")
    suspend fun createOutfit(@Body outfit: Outfit): Deferred<Response<Respuesta>>

    @PUT("update_outfit/{outfit_id}")
    suspend fun updateOutfit(@Path("outfit_id") outfitId: String, @Body outfit: Outfit): Deferred<Response<Respuesta>>

    @POST("create_user/")
    suspend fun createUser(@Body user: User): Deferred<Response<Respuesta>>

    @GET("generate_outfit_view/")
    suspend fun generateOutfit(
        @Query("user_id") userId: String,
        @Query("style") style: String?,
        @Query("weather") weather: String?,
        @Query("categories") categories: List<String>
    ): Deferred<Response<Respuesta>>
}