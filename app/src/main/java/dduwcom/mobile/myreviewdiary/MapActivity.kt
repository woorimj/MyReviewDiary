package dduwcom.mobile.myreviewdiary

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import dduwcom.mobile.myreviewdiary.databinding.ActivityMapsBinding

class MapActivity : AppCompatActivity() {

    val mainBinding by lazy {
        ActivityMapsBinding.inflate(layoutInflater)
    }

    private lateinit var googleMap : GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        // 이게 맵의 지도 객체를 만든거
        val mapFragment: SupportMapFragment
                = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        // 비동기 동작으로..이제 map의 정보를 가져와야됨
        mapFragment.getMapAsync (mapReadyCallback)
    }

    /*GoogleMap 로딩이 완료될 경우 실행하는 Callback*/
    val mapReadyCallback = object: OnMapReadyCallback {
        override fun onMapReady(map: GoogleMap) {
            // 만들어 놓은 구글맵 객체 가져옴
            googleMap = map
            Log.d(TAG, "GoogleMap is ready")
        }
    }
}
