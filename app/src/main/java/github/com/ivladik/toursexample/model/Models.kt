package github.com.ivladik.toursexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Vladislav Falzan.
 */

data class FlightsResponse(
    @SerializedName("flights")
    @Expose
    val flights: List<Flight>
)

data class Flight(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("companyId")
    @Expose
    val companyId: Int,
    @SerializedName("departure")
    @Expose
    val departure: String,
    @SerializedName("arrival")
    @Expose
    val arrival: String,
    @SerializedName("price")
    @Expose
    val price: Int
)

data class HotelsResponse(
    @SerializedName("hotels")
    @Expose
    val hotels: List<Hotel>
)

data class Hotel(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("flights")
    @Expose
    val flightsIds: List<Int>,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("price")
    @Expose
    val price: Int
)

data class AirlinesResponse(
    @SerializedName("companies")
    @Expose
    val airlines: List<Airline>
)

data class Airline(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("name")
    @Expose
    val name: String
)

data class Tour(
    val hotelName: String,
    val possibleFlights: String,
    val minimalPrice: String
)