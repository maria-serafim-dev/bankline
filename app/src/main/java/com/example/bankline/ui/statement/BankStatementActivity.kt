package com.example.bankline.ui.statement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bankline.R
import com.example.bankline.databinding.ActivityBankStatementBinding
import com.example.bankline.domain.Correntista
import java.lang.IllegalArgumentException

class BankStatementActivity : AppCompatActivity() {

    companion object{
        const  val EXTRA_ACCOUNT_HOLDER = "com.example.bankline.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private lateinit var binding: ActivityBankStatementBinding

    private val accountHolder by lazy{
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBankStatementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("ID", accountHolder.id.toString())
    }
}