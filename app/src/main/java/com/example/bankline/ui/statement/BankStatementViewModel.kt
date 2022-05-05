package com.example.bankline.ui.statement

import androidx.lifecycle.ViewModel
import com.example.bankline.data.BanklineRepository

class BankStatementViewModel : ViewModel() {

    fun findBankStatement(accountHolder: Int) = BanklineRepository.findBankStatement(accountHolder)
}