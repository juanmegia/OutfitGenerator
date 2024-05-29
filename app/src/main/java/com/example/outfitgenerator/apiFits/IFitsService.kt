package com.example.outfitgenerator.apiFits

import com.example.outfitgenerator.models.Outfit
import com.example.outfitgenerator.models.Piece
import com.example.outfitgenerator.models.Respuesta
import com.example.outfitgenerator.models.User
import com.example.outfitgenerator.models.UserResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface IFitsService {
    @GET("pieces/")
    suspend fun getPieceList(@Query("username") username: String): Deferred<Response<Respuesta>>

    @POST("pieces/")
    suspend fun createPiece(@Body piece: Piece): Deferred<Response<Respuesta>>

    @GET("pieces/{id}")
    suspend fun getPieceDetail(@Path("id") id: String): Deferred<Response<Respuesta>>

    @PUT("pieces/{id}")
    suspend fun updatePiece(@Path("id") id: String, @Body piece: Piece): Deferred<Response<Respuesta>>

    @DELETE("pieces/{id}")
    suspend fun deletePiece(@Path("id") id: String): Deferred<Response<Respuesta>>
    @GET("usuario/{username}")
    suspend fun getUserByUsername(@Path("username") username: String): Response<User>

    @GET("piece_category/")
    suspend fun getPieceCategory(
        @Query("category") category: String?,
        @Query("color") color: String?,
        @Query("size") size: String?,
        @Query("user_id") userId: String?
    ): Deferred<Response<Respuesta>>

    @GET("outfits/")
    suspend fun getOutfitList(@Query("user_id") userId: String?): Deferred<Response<Respuesta>>

    @POST("outfits/create/")
    suspend fun createOutfit(@Body outfit: Outfit): Deferred<Response<Respuesta>>

    @PUT("outfits/{outfit_id}")
    suspend fun updateOutfit(@Path("outfit_id") outfitId: String, @Body outfit: Outfit): Deferred<Response<Respuesta>>

    @POST("usuario/")
    suspend fun createUser(@Body user: User): Response<User>

    @GET("generate_outfit_view/")
    suspend fun generateOutfit(
        @Query("user_id") userId: String,
        @Query("style") style: String?,
        @Query("weather") weather: String?,
        @Query("categories") categories: List<String>
    ): Deferred<Response<Respuesta>>
    @POST("authenticate_or_create_user/")
    suspend fun authenticateOrCreateUser(@Body request: UserRequest): Response<UserResponse>
    data class UserRequest(
        val username: String,
        val password: String
    )
}