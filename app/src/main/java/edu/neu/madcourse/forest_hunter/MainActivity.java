package edu.neu.madcourse.forest_hunter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button new_game_button;
    Button select_stage_button;
    Button Character_customization_button;
    Button exit_game_button;
    ImageButton store_button;
    ImageButton setting_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set clicker listener for buttons
        new_game_button = findViewById(R.id.new_game_button);
        new_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activate_game_view_activity();
            }
        });

        select_stage_button = findViewById(R.id.select_stage_button);
        select_stage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        Character_customization_button = findViewById(R.id.Character_customization_button);
        Character_customization_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activate_character_customize_activity();
            }
        });

        exit_game_button = findViewById(R.id.exit_game_button);
        exit_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        store_button = findViewById(R.id.store_button);
        store_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        setting_button = findViewById(R.id.setting_button);
        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });
    }

    public void activate_game_view_activity()
    {
        Intent locator_intent = new Intent(this, Game_view_Activity.class);
        startActivity(locator_intent);

    }

    public void activate_character_customize_activity()
    {
        Intent locator_intent = new Intent(this, Character_customize_Activity.class);
        startActivity(locator_intent);

    }

}