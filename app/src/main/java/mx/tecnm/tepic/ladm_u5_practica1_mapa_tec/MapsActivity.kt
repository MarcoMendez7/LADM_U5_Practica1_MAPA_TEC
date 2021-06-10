package mx.tecnm.tepic.ladm_u5_practica1_mapa_tec

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,GoogleMap.OnMarkerClickListener {
    private  lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var  lastLocation:Location
    // var markerOptions1: MarkerOptions?=null
    private lateinit var Map: GoogleMap

    companion object{
        private const val LOCATION_PERMISSION_REQUEST_CODE=1

    }
    override fun onMarkerClick(p0: Marker?)=false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        fusedLocationClient=LocationServices.getFusedLocationProviderClient(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        Map = googleMap
        // Add a marker in Sydney and move the camera
        Map.setOnMarkerClickListener(this)
        Map.uiSettings.isZoomControlsEnabled=true
        setUpMap()
    }
    private fun placeMarker(location: LatLng  ){
        //=============Coordenadas=========================
        var agos=LatLng(21.479380, -104.867260)
        var av=LatLng(21.476653, -104.865142)
        var tracera=LatLng(21.482680, -104.865682)
        var estacionamiento=LatLng(21.478850, -104.864264)
        var estacionamiento1=LatLng(21.478124, -104.865805)
        var canchas=LatLng(21.480889, -104.864234)
        var labc=LatLng(21.477933,-104.867141)
        var cb=LatLng(21.477637,-104.8672608)
        var biblio=LatLng(21.478553,-104.865147)
        var ud=LatLng(21.477772,-104.865929)
        var uvp=LatLng(21.4782221,-104.8677717)
        var licbi=LatLng(21.479595,-104.867022)
        var arqui=LatLng(21.478355,-104.864645)
        var domo=LatLng(21.4810571,-104.8652427)
        var x=LatLng(21.4788132,-104.8650777)
        var a=LatLng(21.479056,-104.864947)
        var g=LatLng(21.479354,-104.865101)
        var h=LatLng(21.4790469,-104.8661751)
        var n=LatLng(21.478754,-104.864780)
        var q=LatLng(21.4794852,-104.8649821)
        var labq=LatLng(21.4791693,-104.8646967)
        var labc_e=LatLng(21.478964,-104.866718)
        var maestrias=LatLng(21.4788687,-104.8674069)
        //================ Propiedades de los marcadores=====================
        val mlabc=MarkerOptions().position(labc).title("Laboratorio de computo").snippet("En este se encuentra sala CISCO y aulas de computo");
        val mcb=MarkerOptions().position(cb).title("Ciencias básicas").snippet("Edificio de aulas de ciencias básicas y oficinas de ing civil");
        val mbiblio=MarkerOptions().position(biblio).title("Biblioteca").snippet("Biblioteca y centro de información");
        val mud=MarkerOptions().position(ud).title("Edificio UD").snippet("Aulas,oficilas de desarrollo academico,industrial e isc");
        val muvp=MarkerOptions().position(uvp).title("Edificio UVP").snippet("Oficinas de servicio social,vinculación,ingles y aulas");
        val mlicbi=MarkerOptions().position(licbi).title("Edificio Licbi").snippet("Auditorio,laboratorios de mecatronica y electrica");
        val marqui=MarkerOptions().position(arqui).title("Talleres de arquitectura");
        val mdomo=MarkerOptions().position(domo).title("DOMO").snippet("Canchas y gradas");
        val mx=MarkerOptions().position(x).title("Edificio X");
        val ma=MarkerOptions().position(a).title("Edificio A");
        val mg=MarkerOptions().position(g).title("Edificio G");
        val mh=MarkerOptions().position(h).title("Edificio H");
        val mn=MarkerOptions().position(n).title("Edificio N");
        val mq=MarkerOptions().position(q).title("Edificio Q");
        val mago=MarkerOptions().position(agos).title("Entrada 2 de agosto");
        val mav=MarkerOptions().position(av).title("Entrada Principal av insurgente");
        val mtracera=MarkerOptions().position(tracera).title("Entrada tracera");
        val mestacionamiento=MarkerOptions().position(estacionamiento).title("Estacionamiento canchas");
        val mestacionamiento2=MarkerOptions().position(estacionamiento1).title("Estacionamiento Principal");
        val mcancha=MarkerOptions().position(canchas).title("Canchas deportivas");
        val mlabq=MarkerOptions().position(labq).title("Laboratorio de quimica").snippet("Laboratorios de quimica y bioquimica");
        val mlabc_e=MarkerOptions().position(labc_e).title("Taller electrica y civil");
        val mmaestrias=MarkerOptions().position(maestrias).title("Edificio de maestrias");
        val markerOptions=MarkerOptions().position(location)

        //===========Dibujar los marcadores con color
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
        mago.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
        mav.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
        mtracera.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
        mestacionamiento.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        mestacionamiento2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        mcancha.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        mlabc.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mcb.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mbiblio.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mud.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        muvp.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mlicbi.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        marqui.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mdomo.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mx.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        ma.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mg.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mh.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mn.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mq.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mlabq.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mlabc_e.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        mmaestrias.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
        //=======Agregar los Marcadores al mapa===========
        Map.addMarker(markerOptions) //Ubicación
        Map.addMarker(mago)
        Map.addMarker(mav)
        Map.addMarker(mtracera)
        Map.addMarker(mestacionamiento)
        Map.addMarker(mestacionamiento2)
        Map.addMarker(mcancha)
        Map.addMarker(mlabc)
        Map.addMarker(mcb)
        Map.addMarker(mbiblio)
        Map.addMarker(mud)
        Map.addMarker(muvp)
        Map.addMarker(mlicbi)
        Map.addMarker(marqui)
        Map.addMarker(mdomo)
        Map.addMarker(mx)
        Map.addMarker(ma)
        Map.addMarker(mg)
        Map.addMarker(mh)
        Map.addMarker(mn)
        Map.addMarker(mq)
        Map.addMarker(mlabq)
        Map.addMarker(mlabc_e)
        Map.addMarker(mmaestrias)
        // Toast.makeText(this,"aqui2", Toast.LENGTH_LONG).show()
    }
    private fun setUpMap(){
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),LOCATION_PERMISSION_REQUEST_CODE)
            return }

        Map.isMyLocationEnabled=true
        Map.mapType= GoogleMap.MAP_TYPE_NORMAL
        fusedLocationClient.lastLocation.addOnSuccessListener (this){ location ->

            if(location!= null){
                lastLocation=location
                val currentLatLong=LatLng(location.latitude,location.longitude)
                //Apuntar al tec
                placeMarker( currentLatLong )
                Map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong,19f))
                //  Toast.makeText(this,""+location.latitude+" : "+location.longitude, Toast.LENGTH_LONG).show()

            }
        }
    }
}
