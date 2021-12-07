package edu.neu.madcourse.forest_hunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import Friend_list_and_scoreboard.Friends;
import authentication.login_Activity;

public class MainActivity extends AppCompatActivity {

    Button new_game_button;
    Button select_stage_button;
    Button Character_customization_button;
    Button exit_game_button;
    ImageButton store_button;
    ImageButton setting_button;
    ImageButton friend_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();


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

        friend_button = findViewById(R.id.friend_button);
        friend_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activate_friends_view_activity();
            }
        });
    }

    public void activate_game_view_activity() {
        Intent game_view_intent = new Intent(this, Game_view_Activity.class);
        startActivity(game_view_intent);

    }

    public void activate_friends_view_activity() {
        Intent friends_view_intent = new Intent(this, Friends.class);
        startActivity(friends_view_intent);

    }

    public void activate_character_customize_activity() {
        Intent character_customize_intent = new Intent(this, Character_customize_Activity.class);
        startActivity(character_customize_intent);

    }

}