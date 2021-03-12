package co.spoonradio.recruit.data.entity


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("country")
    val country: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
) : Parcelable {
    @Parcelize
    data class Coord(
        @SerializedName("lat")
        val lat: Double,
        @SerializedName("lon")
        val lon: Double
    ) : Parcelable
}