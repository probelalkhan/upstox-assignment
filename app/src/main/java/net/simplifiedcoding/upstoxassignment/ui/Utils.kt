package net.simplifiedcoding.upstoxassignment.ui

import android.os.Build
import android.widget.TextView
import androidx.annotation.RequiresApi
import net.simplifiedcoding.upstoxassignment.R

fun Number.decimalFormattedString(): String {
    return String.format("%.2f", this)
}


fun TextView.setProfitOrLossValue(value: Double) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val color =
            if (value > 0) this.context.getColor(R.color.color_profit) else this.context.getColor(R.color.color_loss)
        this.setTextColor(color)
    }
    this.text = value.decimalFormattedString()
}