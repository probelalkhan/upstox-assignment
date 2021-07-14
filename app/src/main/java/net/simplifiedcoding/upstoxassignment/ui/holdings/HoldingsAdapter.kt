package net.simplifiedcoding.upstoxassignment.ui.holdings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.simplifiedcoding.upstoxassignment.data.Data
import net.simplifiedcoding.upstoxassignment.databinding.ItemHoldingBinding
import net.simplifiedcoding.upstoxassignment.ui.setProfitOrLossValue

class HoldingsAdapter : RecyclerView.Adapter<HoldingsAdapter.HoldingsViewHolder>() {

    var items: List<Data> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HoldingsViewHolder(
        ItemHoldingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: HoldingsViewHolder, position: Int) {
        with(holder.binding) {
            textViewName.text = items[position].symbol
            textViewNetQty.text = items[position].quantity.toString()
            textViewLtpValue.text = items[position].ltp.toString()
            textViewPl.setProfitOrLossValue(items[position].pnl)
        }
    }

    override fun getItemCount() = items.size

    inner class HoldingsViewHolder(val binding: ItemHoldingBinding) :
        RecyclerView.ViewHolder(binding.root)
}