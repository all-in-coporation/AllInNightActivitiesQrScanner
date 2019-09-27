package ar.com.AllInNight.ActivitiesQrScanner.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import ar.com.AllInNight.ActivitiesQrScanner.beans.Car;
import ar.com.AllInNight.ActivitiesQrScanner.fragments.HistoricReadingFragment;
import ar.com.AllInNight.ActivitiesQrScanner.fragments.ManualReadingFragment;
import ar.com.AllInNight.ActivitiesQrScanner.fragments.MerchandisingFragment;
import ar.com.AllInNight.ActivitiesQrScanner.fragments.MyCarTabFragment;
import ar.com.AllInNight.ActivitiesQrScanner.fragments.MyCarsAccesoriesFragment;
import ar.com.AllInNight.ActivitiesQrScanner.R;

public class MainActivity extends AppCompatActivity
                          implements HistoricReadingFragment.OnMyCarsFragmentInteractionListener,
                                     MyCarTabFragment.OnFragmentInteractionListener,
                                     MyCarsAccesoriesFragment.OnMyCarAccesoriesListener,
                                     MerchandisingFragment.OnMerchandisignListener,
    ManualReadingFragment.OnManualReadingFragmentInteractionListener
{
    private Context context;
    private FloatingActionButton fab;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private static final int READ_CHASIS_OR_POTENT = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this.onNavigationItemSelectedListener);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottonNavigation);
        navigation.setOnNavigationItemSelectedListener(this.onButtonNavigationViewItemSelectedListener);

        this.replaceFragment(ManualReadingFragment.newInstance(), ManualReadingFragment.TAG);

        fab = findViewById(R.id.fab_add_main_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
    }

    private void openCamera(){
        if (ContextCompat.checkSelfPermission( context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(this, ReadQrActivity.class);
            startActivityForResult(intent, MY_CAMERA_REQUEST_CODE);
        }
        else{
            checkPermissionCamera();
        }
    }

    private void checkPermissionCamera(){
        if (ContextCompat.checkSelfPermission( context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this
                    , new String[] {Manifest.permission.CAMERA}
                    , MY_CAMERA_REQUEST_CODE );
        }
    }

    protected void replaceFragment(Fragment fragment, String tag){
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contentFrameLayout, fragment, tag);
        transaction.commit();
    }

    //Esto es el mensaje para el Button Navigation Item
    private BottomNavigationView.OnNavigationItemSelectedListener onButtonNavigationViewItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.bottom_navigation_mis_autos:
                    replaceFragment(ManualReadingFragment.newInstance(), ManualReadingFragment.TAG);
                    fab.show();
                    return true;
                case R.id.bottom_navigation_store:
                    replaceFragment(HistoricReadingFragment.newInstance(), HistoricReadingFragment.TAG);
                    fab.hide();
                    return true;
            }
            return false;
        }
    };

    private NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new  NavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.navigation_read_qr_code) {
                replaceFragment(ManualReadingFragment.newInstance(), ManualReadingFragment.TAG);
            }
            else if (id == R.id.navigation_historic_qr) {
                replaceFragment(HistoricReadingFragment.newInstance(), HistoricReadingFragment.TAG);
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    };

    @Override
    public void onMyCarCardSelected(Car car) {
        this.replaceFragment(MyCarTabFragment.newInstance(car), MyCarTabFragment.TAG);
    }

    @Override
    public void onAccesorySelected(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onMerchandisignSeleceted(Uri uri) {

    }

    @Override
    public void onManualReadingClicked() {
        Intent intent = new Intent(this, ReadChasisOrPatentActivity.class);
        intent.putExtra(ReadChasisOrPatentActivity.ARG_READING_TYPE, ReadChasisOrPatentActivity.PATENT_TYPE);
        startActivity(intent);
    }
}
