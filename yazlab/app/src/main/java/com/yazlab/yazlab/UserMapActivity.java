package com.yazlab.yazlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class UserMapActivity extends FragmentActivity implements OnMapReadyCallback {
    private  GoogleMap mMap;
    ArrayList<LatLng>arrayList=new ArrayList<LatLng>();
    LatLng Basiskele = new LatLng(40.69910136218416, 29.87909396155936);
    LatLng Cayirova = new LatLng(40.82431502610545, 29.372890705328967);
    LatLng Darica = new LatLng(40.77402961882041, 29.40116070818308);
    LatLng Derince = new LatLng(40.75607163155208, 29.831249476914408);
    LatLng Dilovasi = new LatLng(40.78729103434934, 29.544339402069387);
    LatLng Gebze = new LatLng(40.79958759713329, 29.443601431253384);
    LatLng Golcuk = new LatLng(40.716061052165685, 29.816816188361663);
    LatLng Kandira = new LatLng(41.06789190010285, 30.15824674957009);
    LatLng Karamursel = new LatLng(40.69095338060608, 29.61663208068928);
    LatLng Kartepe = new LatLng(40.75370684601201, 30.026490270274007);
    LatLng Korfez = new LatLng(40.77734768290061, 29.742856360131103);
    LatLng Izmit = new LatLng(40.763698103852896, 29.941023566378277);
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_map);
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        arrayList.add(Basiskele);
        arrayList.add(Cayirova);
        arrayList.add(Darica);
        arrayList.add(Derince);
        arrayList.add(Dilovasi);
        arrayList.add(Gebze);
        arrayList.add(Golcuk);
        arrayList.add(Kandira);
        arrayList.add(Karamursel);
        arrayList.add(Kartepe);
        arrayList.add(Korfez);
        arrayList.add(Izmit);



    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;
        for(int i=0;i<arrayList.size();i++){
            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }
    }
}