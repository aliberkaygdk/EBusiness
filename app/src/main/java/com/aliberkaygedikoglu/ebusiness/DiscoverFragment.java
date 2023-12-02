package com.aliberkaygedikoglu.ebusiness;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aliberkaygedikoglu.ebusiness.databinding.FragmentDiscoverBinding;
import com.aliberkaygedikoglu.ebusiness.databinding.FragmentHomeBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;

public class DiscoverFragment extends Fragment implements OnMapReadyCallback {

   private FragmentDiscoverBinding binding;
   private Marker marker;
   private GoogleMap mMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDiscoverBinding.inflate(inflater, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                int position = (int) (marker.getTag());

                return false;
            }
        });






        return binding.getRoot();
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng myLoc = new LatLng(41.010431,28.979018);
        mMap.addMarker(new MarkerOptions().position(myLoc))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.myloc));


        LatLng myLoc1 = new LatLng(41.011467,28.978804);
        mMap.addMarker(new MarkerOptions().position(myLoc1))
                .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.person1));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLoc,17f));


    }
}