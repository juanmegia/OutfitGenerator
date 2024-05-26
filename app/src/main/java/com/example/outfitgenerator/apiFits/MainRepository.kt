package com.example.outfitgenerator.apiFits

import com.example.outfitgenerator.models.Outfit
import com.example.outfitgenerator.models.Piece
import com.example.outfitgenerator.models.Respuesta
import com.example.outfitgenerator.models.User

class MainRepository {
    private val fitsService = FitsAccess.fitsService;

    suspend fun getPieceList(userId: String?): List<Piece> {
        val webResponse = fitsService.getPieceList(userId).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.pieces ?: emptyList();
        } else {
            emptyList();
        }
    }
    suspend fun createPiece(piece: Piece): Piece? {
        val webResponse = fitsService.createPiece(piece).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.piece
        } else {
            null
        }
    }
    suspend fun createUser(username: String, password: String): User? {
        val webResponse = fitsService.createUser(username, password).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.usuario
        } else {
            null
        }
    }
    suspend fun getPieceDetail(id: String): Piece? {
        val webResponse = fitsService.getPieceDetail(id).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.piece
        } else {
            null
        }
    }
    suspend fun updatePiece(id: String, piece: Piece): Piece? {
        val webResponse = fitsService.updatePiece(id, piece).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.piece
        } else {
            null
        }
    }
    suspend fun deletePiece(id: String): Boolean {
        val webResponse = fitsService.deletePiece(id).await()
        return webResponse.isSuccessful
    }
    suspend fun getPieceCategory(
        category: String?,
        color: String?,
        size: String?,
        userId: String?
    ): List<Piece> {
        val webResponse = fitsService.getPieceCategory(category, color, size, userId).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.pieces ?: emptyList()
        } else {
            emptyList()
        }
    }
    suspend fun getOutfitList(userId: String?): List<Outfit> {
        val webResponse = fitsService.getOutfitList(userId).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.outfits ?: emptyList()
        } else {
            emptyList()
        }
    }
    suspend fun createOutfit(outfit: Outfit): Outfit? {
        val webResponse = fitsService.createOutfit(outfit).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.outfit
        } else {
            null
        }
    }
    suspend fun updateOutfit(outfitId: String, outfit: Outfit): Outfit? {
        val webResponse = fitsService.updateOutfit(outfitId, outfit).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.outfit
        } else {
            null
        }
    }
    suspend fun generateOutfit(userId: String, style: String?, weather: String?, categories: List<String>): Outfit? {
        val webResponse = fitsService.generateOutfit(userId, style, weather, categories).await()
        return if (webResponse.isSuccessful) {
            webResponse.body()?.outfit
        } else {
            null
        }
    }
    suspend fun getUserByUsername(username: String): User? {
        val response = fitsService.getUserByUsername(username)
        return if (response.isSuccessful) {
            response.body()!!.usuario
        } else {
            null
        }
    }
}