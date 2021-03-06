package com.example.bankline.data.remote

import com.example.bankline.domain.Movimentacao
import retrofit2.http.GET
import retrofit2.http.Path

interface BanklineApi {

    @GET("movimentacoes/{id}")
    suspend  fun findBankStantement(@Path("id") accountHolderId: Int): List<Movimentacao>

}