package edu.neu.madcourse.forest_hunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import Friend_list_and_scoreboard.Friends;
import authentication.login_Activity;

public class MainActivity extends AppCompatActivity {

    Button new_game_button;
    Button select_stage_button;
    Button Character_customization_button;
    Button logout_button;
    ImageButton store_button;
    ImageButton setting_button;
    ImageButton friend_button;
    ImageButton scoreboard_button;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();

        mDatabase = FirebaseDatabase.getInstance().getReference();

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

        logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Intent intent = new Intent(MainActivity.this, login_Activity.class);
                    startActivity(intent);
                } finally {
                    finish();
                }
            }
        });

        store_button = findViewById(R.id.store_button);
        store_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activate_store_activity();
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

        scoreboard_button = findViewById(R.id.score_board_button);
        scoreboard_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scoreboard_dialog(view);
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

    public void activate_store_activity() {
        Intent activate_store_intent = new Intent(this, Store_Activity.class);
        activate_store_intent.putExtra("username", getIntent().getStringExtra("username"));
        startActivity(activate_store_intent);
    }

    public void scoreboard_dialog(View view) {
        final AlertDialog.Builder dialog;
        Button change_stage_button;
        Button confirm_button;
        TextView top_1_player_card;
        TextView top_2_player_card;
        TextView top_3_player_card;
        TextView top_4_player_card;
        TextView top_5_player_card;
        final AlertDialog alert_dialog;

        dialog = new AlertDialog.Builder(MainActivity.this);
        View dialog_view = getLayoutInflater().inflate(R.layout.scoreboard, null);

        confirm_button = dialog_view.findViewById(R.id.scoreboard_confirm_button);
        change_stage_button = dialog_view.findViewById(R.id.change_stage_scoreboard);


        dialog.setView(dialog_view);
        alert_dialog = dialog.create();

        alert_dialog.setCanceledOnTouchOutside(false);


        HashMap<String, Integer> stage_1_highest_score_hashmap = new HashMap<String, Integer>();
        HashMap<String, Integer> stage_2_highest_score_hashmap = new HashMap<String, Integer>();


        DatabaseReference user_database = mDatabase.child("users");
        user_database.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.child("highest_score_list").exists()) {
                    for (DataSnapshot pss : snapshot.getChildren()) {
                        stage_1_highest_score_hashmap.put( pss.child("nickname").getValue().toString(), Integer.parseInt(pss.child("highest_score_list").child("0").getValue().toString()) );
                        stage_2_highest_score_hashmap.put(pss.child("nickname").getValue().toString(), Integer.parseInt(pss.child("highest_score_list").child("1").getValue().toString()) );

                    }
                }

                int num_of_player = stage_1_highest_score_hashmap.size();
                ArrayList<String> temp_nickname_list = new ArrayList<>();
                int num_card;
                if (num_of_player < 5)
                {
                    num_card = num_of_player;
                }
                else
                {
                    num_card = 5;
                }
                int i;
                int j;
                for (i = 0; i < num_card; i++)
                {
                    for (j = 0; j <num_of_player; j++)
                    {

                    }
                }

                //TODO

                alert_dialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_dialog.dismiss();
            }
        });

        change_stage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                alert_dialog.show();
            }
        });
    }
}
