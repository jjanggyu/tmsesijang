package com.cau.a20160392.ui.myPage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cau.a20160392.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link child1_mywhere#newInstance} factory method to
 * create an instance of this fragment.
 */
public class child1_mywhere extends Fragment implements OnMapReadyCallback {
    MapView mapView2;
    public child1_mywhere(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View layout = inflater.inflate(R.layout.fragment_child1_mywhere,container,false);

        mapView2 = (MapView)layout.findViewById(R.id.map2);
        mapView2.getMapAsync(this);

        return layout;
    }



    @Override
    public void onStart() {
        super.onStart();
        mapView2.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView2.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView2.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView2.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView2.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView2.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView2.onDestroy();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(mapView2!=null)
            mapView2.onCreate(savedInstanceState);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng num6 = new LatLng(37.620379, 126.95339);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(num6);
        markerOptions.title("금선사");
        markerOptions.snippet("템플스테이");

        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.num6);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 200, 200, false);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));

        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(num6));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
    }

}


