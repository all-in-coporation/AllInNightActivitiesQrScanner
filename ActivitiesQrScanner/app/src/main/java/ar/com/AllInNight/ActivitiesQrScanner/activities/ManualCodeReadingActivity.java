package ar.com.AllInNight.ActivitiesQrScanner.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ar.com.AllInNight.ActivitiesQrScanner.R;

public class ManualCodeReadingActivity extends AppCompatActivity {
    public static final String ARG_READING_TYPE = "ARG_READING_KIND";
    public static final Integer CHASIS_TIPYE = 0;
    public static final Integer PATENT_TYPE = 1;
    private Integer type = CHASIS_TIPYE;
    private EditText inputText;
    FloatingActionButton fab;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_code_reading);
        context = this;
        Intent intent = getIntent();
        if (intent.getExtras() != null){
            type = intent.getIntExtra(ARG_READING_TYPE, CHASIS_TIPYE);
        }

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });

        inputText = this.findViewById(R.id.inputText);
        if (PATENT_TYPE == this.type){
            String textoPatente = "Por favor ingrese el código de la compra";
            String ejemploPatente = "AB 123 CDD";
            TextView textView2 = this.findViewById(R.id.textView2);
            textView2.setText(textoPatente);
            inputText.setHint(ejemploPatente);
        }


        inputText = this.findViewById(R.id.inputText);

    }

}
