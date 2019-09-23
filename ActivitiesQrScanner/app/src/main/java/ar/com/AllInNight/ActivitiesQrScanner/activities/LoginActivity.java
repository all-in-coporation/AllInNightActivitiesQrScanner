package ar.com.AllInNight.ActivitiesQrScanner.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ar.com.AllInNight.ActivitiesQrScanner.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button facebookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.facebookButton = this.findViewById(R.id.facebookButton);
        this.facebookButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
