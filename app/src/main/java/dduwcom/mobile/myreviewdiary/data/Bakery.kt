package dduwcom.mobile.myreviewdiary.data

import com.google.gson.annotations.SerializedName

data class BakeryRoot(
    val Data: DATA,
)
data class DATA(
    @SerializedName("x") val longitude: String?,
    @SerializedName("y") val latitude: String?,
    @SerializedName("rdnwhladdr") val roadAddress: String?,
    @SerializedName("bplcnm") val name: String?,
    @SerializedName("sitetel") val tel: String?,
    @SerializedName("dtlstatenm") val state: String?,
)
