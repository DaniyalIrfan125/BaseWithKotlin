package daniyal.android.basewithkotlin.data.models

import com.google.gson.annotations.SerializedName

data class CoinMarketPojo(

        @SerializedName("status")

        var status: Status,
        @SerializedName("data")
        var data: List<Datum>
) {

    data class Datum(@SerializedName("id")

                     var id: Int,
                     @SerializedName("name")

                     var name: String,
                     @SerializedName("symbol")
                     var symbol: String,
                     @SerializedName("slug")

                     var slug: String,
                     @SerializedName("num_market_pairs")

                     var numMarketPairs: Int,
                     @SerializedName("date_added")

                     var dateAdded: String,
                     @SerializedName("tags")
                     var tags: List<String>,
                     @SerializedName("max_supply")
                     var maxSupply: Any,
                     @SerializedName("circulating_supply")
                     var circulatingSupply: Double,
                     @SerializedName("total_supply")
                     var totalSupply: Double,
                     @SerializedName("platform")

                     var platform: Any,
                     @SerializedName("cmc_rank")

                     var cmcRank: Int,
                     @SerializedName("last_updated")

                     var lastUpdated: String,
                     @SerializedName("quote")

                     var quote: Quote)

    data class Status(
            @SerializedName("timestamp")

            var timestamp: String,
            @SerializedName("error_code")

            var errorCode: Int,
            @SerializedName("error_message")

            var errorMessage: Any,
            @SerializedName("elapsed")

            var elapsed: Int,
            @SerializedName("credit_count")
            var creditCount: Int,
            @SerializedName("notice")

            var notice: Any
    )

    data class Usd(
            @SerializedName("price")

            var price: Double,
            @SerializedName("volume_24h")

            var volume24h: Double,
            @SerializedName("percent_change_1h")

            var percentChange1h: Double,
            @SerializedName("percent_change_24h")

            var percentChange24h: Double,
            @SerializedName("percent_change_7d")

            var percentChange7d: Double,
            @SerializedName("market_cap")

            var marketCap: Double,
            @SerializedName("last_updated")

            var lastUpdated: String
    )

    data class Quote(
            @SerializedName("USD")
            var uSD: Usd
    )
}