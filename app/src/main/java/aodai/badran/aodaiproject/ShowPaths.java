package aodai.badran.aodaiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ShowPaths extends AppCompatActivity implements View.OnClickListener {
    private ImageButton IMGBgobacktomap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_paths);
        IMGBgobacktomap=(ImageButton)findViewById(R.id.IMGBgobacktomap);
        IMGBgobacktomap.setOnClickListener(this);
    }

    public void onClick(View view){
        Intent i = new Intent(this,MapsActivity.class);
        startActivity(i);
    }
}


