package net.simplifiedcoding.upstoxassignment.data

data class HoldingsResponse(
    val client_id: String,
    val `data`: List<Data>,
    val error: Any,
    val response_type: String,
    val timestamp: Long
) {
    val current_value: Double
        get() {
            var sum = 0.0
            data.forEach {
                sum += it.current_value
            }
            return sum
        }
}