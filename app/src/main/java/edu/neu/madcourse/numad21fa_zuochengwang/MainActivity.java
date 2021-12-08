package edu.neu.madcourse.numad21fa_zuochengwang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button about_button;
    Button clicky_clicky_button;
    Button Link_Collector_button;
    Button Locator_button;
    Button Web_service_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        about_button = findViewById(R.id.About_button);
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"My Name is\n Zuocheng Wang\n\nMy Email address is\n" +
                        "wang.zuo@northeastern.edu", Toast.LENGTH_SHORT).show();
            }
        });

        clicky_clicky_button = findViewById(R.id.clicky_clicky_button);
        clicky_clicky_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activate_clicky_activity();
            }
        });

        Link_Collector_button = findViewById(R.id.Link_Collector_button);
        Link_Collector_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activate_link_collector_activity();
            }
        });

        Locator_button = findViewById(R.id.Locator_button);
        Locator_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activate_locator_activity();
            }
        });


        Web_service_button = findViewById(R.id.web_service_button);
        Web_service_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activate_service_activity();
            }
        });

    }

    public void activate_clicky_activity()
    {
        Intent clicky_intent = new Intent(this, ClickyActivity.class);
        startActivity(clicky_intent);

    }

    public void activate_link_collector_activity()
    {
        Intent link_collector_intent = new Intent(this, LinkCollectorActivity.class);
        startActivity(link_collector_intent);

    }

    public void activate_locator_activity()
    {
        Intent locator_intent = new Intent(this, LocatorActivity.class);
        startActivity(locator_intent);

    }

    public void activate_service_activity()
    {
        Intent locator_intent = new Intent(this, ServiceActivity.class);
        startActivity(locator_intent);

    }
}