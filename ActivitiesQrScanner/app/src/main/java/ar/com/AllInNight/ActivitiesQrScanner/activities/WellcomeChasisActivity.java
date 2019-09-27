package ar.com.AllInNight.ActivitiesQrScanner.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ar.com.AllInNight.ActivitiesQrScanner.R;

public class WellcomeChasisActivity extends AppCompatActivity {
    private Button escanearChasisButtton;
    private Button digitarChasisButton;
    private Button ingresarPatente;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome_chasis);

        context = this;
        this.escanearChasisButtton = this.findViewById(R.id.escanearChasisButtton);

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
        Intent intent = new Intent(this, ManualCodeReadingActivity.class);
        intent.putExtra(ManualCodeReadingActivity.ARG_READING_TYPE, ManualCodeReadingActivity.PATENT_TYPE);
        startActivity(intent);

    }

    private void openChasis(){
        Intent intent = new Intent(this, ManualCodeReadingActivity.class);
        intent.putExtra(ManualCodeReadingActivity.ARG_READING_TYPE, ManualCodeReadingActivity.CHASIS_TIPYE);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
