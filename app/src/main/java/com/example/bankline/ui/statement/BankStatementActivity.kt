package com.example.bankline.ui.statement

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankline.data.State
import com.example.bankline.databinding.ActivityBankStatementBinding
import com.example.bankline.domain.Correntista
import com.google.android.material.snackbar.Snackbar

class BankStatementActivity : AppCompatActivity() {

    companion object{
        const  val EXTRA_ACCOUNT_HOLDER = "com.example.bankline.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private lateinit var binding: ActivityBankStatementBinding

    private val viewModel by viewModels<BankStatementViewModel>()

    private val accountHolder by lazy{
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBankStatementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findBankStatement()
        ouvinteSwipeRefreshLayout()
    }

    private fun ouvinteSwipeRefreshLayout() {
        binding.srlBankStatement.setOnRefreshListener {
            findBankStatement()
        }
    }

    private fun findBankStatement() {
        viewModel.findBankStatement(accountHolder.id).observe(this){
            state->

            when(state){
                is State.Success->{
                    binding.rvBankStatement.layoutManager = LinearLayoutManager(this)
                    binding.rvBankStatement.adapter = state.data?.let { BankStatementAdapter(it)}
                    binding.srlBankStatement.isRefreshing = false
                }
                is State.Error -> {
                    state.message?.let { Snackbar.make(binding.rvBankStatement, it, Snackbar.LENGTH_LONG).show() }
                    binding.srlBankStatement.isRefreshing = false
                }
                State.Wait -> {
                    binding.srlBankStatement.isRefreshing = true
                }
            }
        }
    }
}