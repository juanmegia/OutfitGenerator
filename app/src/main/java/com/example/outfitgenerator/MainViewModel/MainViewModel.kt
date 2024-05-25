package com.example.outfitgenerator.MainViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.outfitgenerator.apiFits.MainRepository
import com.example.outfitgenerator.models.Outfit
import com.example.outfitgenerator.models.Piece
import com.example.outfitgenerator.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var repository: MainRepository = MainRepository()

    fun getPieceList(userId: String?): MutableLiveData<List<Piece>> {
        val pieces = MutableLiveData<List<Piece>>()
        GlobalScope.launch(Dispatchers.Main) {
            pieces.value = repository.getPieceList(userId)
        }
        return pieces
    }
    fun createPiece(piece: Piece): MutableLiveData<Piece> {
        val createdPiece = MutableLiveData<Piece>()
        GlobalScope.launch(Dispatchers.Main) {
            createdPiece.value = repository.createPiece(piece)
        }
        return createdPiece
    }
    fun getPieceDetail(id: String): MutableLiveData<Piece> {
        val pieceDetail = MutableLiveData<Piece>()
        GlobalScope.launch(Dispatchers.Main) {
            pieceDetail.value = repository.getPieceDetail(id)
        }
        return pieceDetail
    }
    fun updatePiece(id: String, piece: Piece): MutableLiveData<Piece> {
        val updatedPiece = MutableLiveData<Piece>()
        GlobalScope.launch(Dispatchers.Main) {
            updatedPiece.value = repository.updatePiece(id, piece)
        }
        return updatedPiece
    }
    fun deletePiece(id: String): MutableLiveData<Boolean> {
        val isDeleted = MutableLiveData<Boolean>()
        GlobalScope.launch(Dispatchers.Main) {
            isDeleted.value = repository.deletePiece(id)
        }
        return isDeleted
    }
    fun getPieceCategory(category: String?, color: String?, size: String?, userId: String?): MutableLiveData<List<Piece>> {
        val filteredPieces = MutableLiveData<List<Piece>>()
        GlobalScope.launch(Dispatchers.Main) {
            filteredPieces.value = repository.getPieceCategory(category, color, size, userId)
        }
        return filteredPieces
    }
    fun getOutfitList(userId: String?): MutableLiveData<List<Outfit>> {
        val outfits = MutableLiveData<List<Outfit>>()
        GlobalScope.launch(Dispatchers.Main) {
            outfits.value = repository.getOutfitList(userId)
        }
        return outfits
    }
    fun createOutfit(outfit: Outfit): MutableLiveData<Outfit> {
        val createdOutfit = MutableLiveData<Outfit>()
        GlobalScope.launch(Dispatchers.Main) {
            createdOutfit.value = repository.createOutfit(outfit)
        }
        return createdOutfit
    }
    fun createUser(user: User): MutableLiveData<User> {
        val createdUser = MutableLiveData<User>()
        GlobalScope.launch(Dispatchers.Main) {
            createdUser.value = repository.createUser(user)
        }
        return createdUser
    }
    fun updateOutfit(outfitId: String, outfit: Outfit): MutableLiveData<Outfit> {
        val updatedOutfit = MutableLiveData<Outfit>()
        GlobalScope.launch(Dispatchers.Main) {
            updatedOutfit.value = repository.updateOutfit(outfitId, outfit)
        }
        return updatedOutfit
    }
    fun getUserByUsername(username: String): MutableLiveData<User> {
        val userResponse = MutableLiveData<User>()
        GlobalScope.launch(Dispatchers.Main) {
            userResponse.value = repository.getUserByUsername(username)
        }
        return userResponse
    }

}