package com.example.sistemas.karolproyectoandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import Datos.datos;
import Models.wifi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UbicacionFragment extends Fragment implements OnMapReadyCallback {
    Button btncero,btnuno,btndos,btntres,btncuatro,btncinco,btnseis,btnsiete,btn0cho,btnnueve,btnpunto,
            btnigual,btnsuma,btnresta,btnmulti,btndiv,grados,acercade;

    EditText elproceso,elconcatenar;
    private FragmentActivity myContext;
    private GoogleMap mMap;
    public double lat = 0.0;
    public double lon = 0.0;
    private TextView titulo_lugar1,titulo_n,titulo_c,hora_c;
    private Retrofit retrofit;
    public final static String TAG ="DATOS COLOMBIA";
    public UbicacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_ubicacion, container, false);
        btncero= (Button) view.findViewById(R.id.profesores);
        btntres= (Button) view.findViewById(R.id.ubicacion);
        btncuatro= (Button) view.findViewById(R.id.wifi);
        acercade= (Button) view.findViewById(R.id.acercade);
        grados= (Button) view.findViewById(R.id.grados);

        btncero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // elconcatenar =(EditText)view.findViewById(R.id.proceso);
                //elproceso.setText(elconcatenar.getText().toString()+"9");
                Fragment fragment = null;
                Class fragmentClass= SegundoFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


            }
        });


        btntres.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // elconcatenar =(EditText)view.findViewById(R.id.proceso);
                //elproceso.setText(elconcatenar.getText().toString()+"9");
                Fragment fragment = null;
                Class fragmentClass= InformacionFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


            }
        });

        btncuatro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // elconcatenar =(EditText)view.findViewById(R.id.proceso);
                //elproceso.setText(elconcatenar.getText().toString()+"9");
                Fragment fragment = null;
                Class fragmentClass= MapaFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


            }
        });

        acercade.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // elconcatenar =(EditText)view.findViewById(R.id.proceso);
                //elproceso.setText(elconcatenar.getText().toString()+"9");

                AlertDialog.Builder uBuilder2 = new AlertDialog.Builder(UbicacionFragment.super.getContext());
                View aView2 = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_acerca_dee, null);
                uBuilder2.setView(aView2);
                final AlertDialog dialog2 = uBuilder2.create();
                dialog2.show();
                Button close = (Button) aView2.findViewById(R.id.close);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog2.cancel();
                    }
                });


            }




        });

        grados.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // elconcatenar =(EditText)view.findViewById(R.id.proceso);
                //elproceso.setText(elconcatenar.getText().toString()+"9");

                //elproceso.setText(elconcatenar.getText().toString()+"9");
                Fragment fragment = null;
                Class fragmentClass= ProgramacionGradosFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


            }




        });
        return view;
    }
    SupportMapFragment mapFragment;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        retrofit=new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create()).build();



    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(1.3625542,-78.1810467);
        mMap.addMarker(new MarkerOptions().position(sydney).title("El Diviso").snippet(""+"").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 5));
    }
    @Override
    public void onAttach(Context context) {

        myContext=(FragmentActivity) context;
        super.onAttach(context);
    }
}