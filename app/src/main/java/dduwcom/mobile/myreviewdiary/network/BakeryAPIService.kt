package dduwcom.mobile.myreviewdiary.network

import dduwcom.mobile.myreviewdiary.data.BakeryRoot
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BakeryAPIService {
    @GET("{key}/{type}/LOCALDATA_072218_MP/{start_index}/{end_index}")
    fun getBakeryData(
        @Path("key") key : String,
        @Path("type") type : String,
        @Path("start_index") start : Int,
        @Path("end_index") end : Int,
    )
    :Call<BakeryRoot>
}