package com.example.bankline.ui.statement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankline.R
import com.example.bankline.databinding.BankStatementItemBinding
import com.example.bankline.domain.Movimentacao
import com.example.bankline.domain.TipoMovimentacao

class BankStatementAdapter (private val dataSet: List<Movimentacao>) : RecyclerView.Adapter<BankStatementAdapter.ViewHolder>(){

    class ViewHolder(val binding: BankStatementItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movimentacao) = with(binding) {
                tvDescription.text = item.descricao
                tvValue.text = item.valor.toString()
                tvDatetime.text = item.dataHora
                val typeIcon = if (TipoMovimentacao.RECEITA == item.tipo) R.drawable.ic_money_in else R.drawable.ic_money_out
                ivIcon.setImageResource(typeIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BankStatementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataSet.size


}