package dduwcom.mobile.myreviewdiary

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dduwcom.mobile.myreviewdiary.data.BakeryRoot
import dduwcom.mobile.myreviewdiary.databinding.ActivityMainBinding
import dduwcom.mobile.myreviewdiary.network.BakeryAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        mainBinding.btnMap.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

//        mainBinding.btnEdit.setOnClickListener {
//
//        }


        // openAPI 가져오는 retrofit 객체 생성 및 실행
        val retrofit = Retrofit.Builder()
            .baseUrl(resources.getString(R.string.bakery_url))
            .addConverterFactory(GsonConverterFactory.create()) // JSON -> DTO로 바꿔주는 converter 설정
            .build()

        // 인터페이스를 구현한 서비스 객체 반환
        val service = retrofit.create(BakeryAPIService::class.java)

        val apiCallback = object: Callback<BakeryRoot> {

            override fun onResponse(call: Call<BakeryRoot>, response: Response<BakeryRoot>) {
                if (response.isSuccessful) {
                    val root : BakeryRoot? = response.body()
                } else {
                    Log.d(TAG, "Unsuccessful Response")
                }
            }
            override fun onFailure(call: Call<BakeryRoot>, t: Throwable) {
                Log.d(TAG, "OpenAPI Call Failure ${t.message}")
            }

        }

        // 생성 서비스 객체
        val apiCall : Call<BakeryRoot>
        = service.getBakeryData(resources.getString(R.string.bakery_key), "json", 1, 10)

        // 비동기 처리 요청
        apiCall.enqueue(apiCallback)
    }
}