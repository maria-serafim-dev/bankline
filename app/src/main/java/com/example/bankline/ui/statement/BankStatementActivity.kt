package com.example.bankline.ui.statement

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankline.databinding.ActivityBankStatementBinding
import com.example.bankline.domain.Correntista
import com.example.bankline.domain.Movimentacao
import com.example.bankline.domain.TipoMovimentacao

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

        findBankStatement()
    }

    private fun findBankStatement() {
        val dataSet = ArrayList<Movimentacao>()
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Lorem Ipsum", 10000.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Lorem Ipsum", 10000.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Lorem Ipsum", 10000.0, TipoMovimentacao.DESPESA, 1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Lorem Ipsum", 10000.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:24:55", "Lorem Ipsum", 10000.0, TipoMovimentacao.DESPESA, 1))
        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)
        binding.rvBankStatement.adapter = BankStatementAdapter(dataSet)
    }
}