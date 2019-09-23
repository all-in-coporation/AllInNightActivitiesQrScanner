package ar.com.AllInNight.ActivitiesQrScanner.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ar.com.AllInNight.ActivitiesQrScanner.R;

public class WellcomeChasisActivity extends AppCompatActivity {
    private Button escanearChasisButtton;
    private Button digitarChasisButton;
    private Button ingresarPatente;
    private Context context;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private static final int READ_CHASIS_OR_POTENT = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome_chasis);

        context = this;
        this.escanearChasisButtton = this.findViewById(R.id.escanearChasisButtton);

        this.escanearChasisButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });

        this.digitarChasisButton = this.findViewById(R.id.digitarChasisButton);
        this.digitarChasisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChasis();
            }
        });

        this.ingresarPatente = this.findViewById(R.id.ingresarPatente);
        this.ingresarPatente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPatent();
            }
        });
    }

    private void openPatent(){
        Intent intent = new Intent(this, ReadChasisOrPatentActivity.class);
        intent.putExtra(ReadChasisOrPatentActivity.ARG_READING_TYPE, ReadChasisOrPatentActivity.PATENT_TYPE);
        startActivity(intent);

    }

    private void openChasis(){
        Intent intent = new Intent(this, ReadChasisOrPatentActivity.class);
        intent.putExtra(ReadChasisOrPatentActivity.ARG_READING_TYPE, ReadChasisOrPatentActivity.CHASIS_TIPYE);
        startActivity(intent);
    }

    private void openCamera(){
        if (ContextCompat.checkSelfPermission( context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
