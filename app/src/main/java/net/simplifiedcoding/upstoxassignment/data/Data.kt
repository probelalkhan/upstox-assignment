package net.simplifiedcoding.upstoxassignment.data

data class Data(
    val avg_price: String,
    val close: Double,
    val cnc_used_quantity: Double,
    val collateral_qty: Double,
    val collateral_type: String,
    val collateral_update_qty: Double,
    val company_name: String,
    val haircut: Double,
    val holdings_update_qty: Double,
    val isin: String,
    val ltp: Double,
    val product: String,
    val quantity: Double,
    val symbol: String,
    val t1_holding_qty: Double,
    val token_bse: String,
    val token_nse: String,
    val withheld_collateral_qty: Double,
    val withheld_holding_qty: Double
) {
    val pnl: Double
        get() = (close - ltp) * quantity

    val current_value: Double
        get() = ltp * quantity
}