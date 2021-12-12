package edu.neu.madcourse.forest_hunter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import Friend_list_and_scoreboard.Friends;
import authentication.login_Activity;
import user.Login_User;

public class MainActivity extends AppCompatActivity {

    Button new_game_button;
    Button select_stage_button;
    Button Character_customization_button;
    Button logout_button;
    ImageButton store_button;
    ImageButton setting_button;
    ImageButton friend_button;
    ImageButton scoreboard_button;
    int num_of_player;

    private DatabaseReference mDatabase;
    ArrayList<Integer> stage_1_highest_score_list = new ArrayList<Integer>();
    ArrayList<Integer> stage_2_highest_score_list = new ArrayList<Integer>();
    ArrayList<String> nickname_list = new ArrayList<String>();
    ArrayList<Integer> stage_1_top_score_list = new ArrayList<Integer>();
    ArrayList<Integer> stage_2_top_score_list = new ArrayList<Integer>();
    ArrayList<String> stage_1_nickname_list = new ArrayList<String>();
    ArrayList<String> stage_2_nickname_list = new ArrayList<String>();

    TextView top_1_player_card;
    TextView top_2_player_card;
    TextView top_3_player_card;
    TextView top_4_player_card;
    TextView top_5_player_card;
    ImageView stage_name;

    ImageButton music_1_button;
    ImageButton music_2_button;
    ImageButton music_3_button;
    ImageButton music_4_button;
    ImageButton music_5_button;
    ImageButton no_music_button;

    ImageButton select_stage1_button;
    ImageButton select_stage2_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference user_database = mDatabase.child("users");
        user_database.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot pss : snapshot.getChildren()) {
                    if (pss.child("highest_score_list").exists()
                            && !pss.child("highest_score_list").child("0").getValue().toString().equals("")) {
                        stage_1_highest_score_list.add(Integer.parseInt(pss.child("highest_score_list").child("0").getValue().toString()));
                        stage_2_highest_score_list.add(Integer.parseInt(pss.child("highest_score_list").child("1").getValue().toString()));
                        nickname_list.add(pss.child("nickname").getValue().toString());
                    }
                }

                num_of_player = stage_1_highest_score_list.size();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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

                select_stage_dialog(view);
            }
        });

        Character_customization_button = findViewById(R.id.Character_customization_button);
        Character_customization_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task update_user = mDatabase.child("users").child(Login_User.current_User.username).setValue(Login_User.current_User);
                activate_character_customize_activity();
            }
        });

        logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
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

                setting_dialog(view);
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

        if (Music_controller.bgm == null) {
            Music_controller.bgm = new Music(this);
        }
        Music_controller.bgm.play_music(Music_controller.bgm.current_bgm_index);
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

    public void select_stage_dialog(View view) {

        final AlertDialog.Builder dialog;
        Button cancel_button;
        Button confirm_button;
        final AlertDialog alert_dialog;

        dialog = new AlertDialog.Builder(MainActivity.this);
        View dialog_view = getLayoutInflater().inflate(R.layout.select_stage_view, null);

        confirm_button = dialog_view.findViewById(R.id.select_stage_confirm_button);
        cancel_button = dialog_view.findViewById(R.id.select_stage_cancel_button);
        select_stage1_button = dialog_view.findViewById(R.id.select_stage1_button);
        select_stage2_button = dialog_view.findViewById(R.id.select_stage2_button);


        dialog.setView(dialog_view);
        alert_dialog = dialog.create();

        alert_dialog.setCanceledOnTouchOutside(false);

        select_stage1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stage.current_stage_index = 0;
                Toast.makeText(MainActivity.this, "You have selected Stage 1 Crazy Crocodile!", Toast.LENGTH_SHORT).show();
            }
        });

        select_stage2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stage.current_stage_index = 1;
                Toast.makeText(MainActivity.this, "You have selected Stage 2 Mad Lion!", Toast.LENGTH_SHORT).show();
            }
        });

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_dialog.dismiss();
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_dialog.dismiss();
            }
        });

        alert_dialog.show();
    }

    public void scoreboard_dialog(View view) {

        final int[] state_value = {0};
        final AlertDialog.Builder dialog;
        Button change_stage_button;
        Button confirm_button;
        final AlertDialog alert_dialog;

        dialog = new AlertDialog.Builder(MainActivity.this);
        View dialog_view = getLayoutInflater().inflate(R.layout.scoreboard, null);

        top_1_player_card = dialog_view.findViewById(R.id.music_1_button);
        top_2_player_card = dialog_view.findViewById(R.id.top_2_player);
        top_3_player_card = dialog_view.findViewById(R.id.top_3_player);
        top_4_player_card = dialog_view.findViewById(R.id.top_4_player);
        top_5_player_card = dialog_view.findViewById(R.id.top_5_player);
        stage_name = dialog_view.findViewById(R.id.stage_name);

        confirm_button = dialog_view.findViewById(R.id.scoreboard_confirm_button);
        change_stage_button = dialog_view.findViewById(R.id.change_stage_scoreboard);


        dialog.setView(dialog_view);
        alert_dialog = dialog.create();

        alert_dialog.setCanceledOnTouchOutside(false);

        show_stage_1_scoreboard(dialog_view);
        stage_name.setImageResource(R.drawable.crazy_crocodile_text);

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_dialog.dismiss();
            }
        });

        change_stage_button.setText("Mad Lion Scoreboard");
        change_stage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state_value[0] == 0) {
                    state_value[0] = 1;
                    show_stage_2_scoreboard(dialog_view);
                    change_stage_button.setText("Crazy Crocodile Scoreboard");
                    stage_name.setImageResource(R.drawable.mad_lion_text);
                } else if (state_value[0] == 1) {
                    state_value[0] = 0;
                    show_stage_1_scoreboard(dialog_view);
                    change_stage_button.setText("Mad Lion Scoreboard");
                    stage_name.setImageResource(R.drawable.crazy_crocodile_text);
                }

            }
        });

        alert_dialog.show();
    }

    public void setting_dialog(View view) {

        final AlertDialog.Builder dialog;
        Button cancel_button;
        Button confirm_button;
        final AlertDialog alert_dialog;

        dialog = new AlertDialog.Builder(MainActivity.this);
        View dialog_view = getLayoutInflater().inflate(R.layout.setting_view, null);

        music_1_button = dialog_view.findViewById(R.id.music_1_button);
        music_2_button = dialog_view.findViewById(R.id.music_2_button);
        music_3_button = dialog_view.findViewById(R.id.music_3_button);
        music_4_button = dialog_view.findViewById(R.id.music_4_button);
        music_5_button = dialog_view.findViewById(R.id.music_5_button);
        no_music_button = dialog_view.findViewById(R.id.no_music_button);
        confirm_button = dialog_view.findViewById(R.id.setting_confirm_button);


        dialog.setView(dialog_view);
        alert_dialog = dialog.create();

        alert_dialog.setCanceledOnTouchOutside(false);


        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_dialog.dismiss();
            }
        });


        music_1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Music_controller.bgm.stop();
                Music_controller.bgm.play_music(0);
                Music_controller.bgm.current_bgm_index = 0;
            }
        });

        music_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Music_controller.bgm.stop();
                Music_controller.bgm.play_music(1);
                Music_controller.bgm.current_bgm_index = 1;
            }
        });

        music_3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Music_controller.bgm.stop();
                Music_controller.bgm.play_music(2);
                Music_controller.bgm.current_bgm_index = 2;
            }
        });

        music_4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Music_controller.bgm.stop();
                Music_controller.bgm.play_music(3);
                Music_controller.bgm.current_bgm_index = 3;
            }
        });

        music_5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Music_controller.bgm.stop();
                Music_controller.bgm.play_music(4);
                Music_controller.bgm.current_bgm_index = 4;
            }
        });

        no_music_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Music_controller.bgm.stop();
                Music_controller.bgm.current_bgm_index = 0;
            }
        });

        alert_dialog.show();
    }

    public void show_stage_1_scoreboard(View dialog_view) {
        ArrayList<Integer> temp_stage_1_highest_score_list = new ArrayList<>(stage_1_highest_score_list);
        ArrayList<Integer> stage_1_top_score_list = new ArrayList<Integer>();
        ArrayList<String> stage_1_nickname_list = new ArrayList<String>();

        ArrayList<String> temp_nickname_list = new ArrayList<String>(nickname_list);

        int num_card;
        if (num_of_player <= 5) {
            num_card = num_of_player;
        } else {
            num_card = 5;
        }

        // sort stage 1 arraylist
        int i;
        int j;
        int temp_max = 0;
        int temp_top_score_index = 0;
        int temp = num_of_player;

        for (i = 0; i < num_card; i++) {
            for (j = 0; j < temp; j++) {
                if (temp_stage_1_highest_score_list.get(j) > temp_max) {
                    temp_top_score_index = j;
                    temp_max = temp_stage_1_highest_score_list.get(j);
                }
            }
            stage_1_nickname_list.add(temp_nickname_list.get(temp_top_score_index));
            stage_1_top_score_list.add(temp_stage_1_highest_score_list.get(temp_top_score_index));
            temp_stage_1_highest_score_list.remove(temp_top_score_index);
            temp_nickname_list.remove(temp_top_score_index);
            temp_max = 0;
            temp_top_score_index = 0;
            temp -= 1;
        }


        if (num_card == 1) {
            top_1_player_card.setText("No.1  " + stage_1_nickname_list.get(0) + " " + stage_1_top_score_list.get(0));
        } else if (num_card == 2) {
            top_1_player_card.setText("No.1  " + stage_1_nickname_list.get(0) + " " + stage_1_top_score_list.get(0));
            top_2_player_card.setText("No.2  " + stage_1_nickname_list.get(1) + " " + stage_1_top_score_list.get(1));
        } else if (num_card == 3) {
            top_1_player_card.setText("No.1  " + stage_1_nickname_list.get(0) + " " + stage_1_top_score_list.get(0));
            top_2_player_card.setText("No.2  " + stage_1_nickname_list.get(1) + " " + stage_1_top_score_list.get(1));
            top_3_player_card.setText("No.3  " + stage_1_nickname_list.get(2) + " " + stage_1_top_score_list.get(2));

        } else if (num_card == 4) {
            top_1_player_card.setText("No.1  " + stage_1_nickname_list.get(0) + " " + stage_1_top_score_list.get(0));
            top_2_player_card.setText("No.2  " + stage_1_nickname_list.get(1) + " " + stage_1_top_score_list.get(1));
            top_3_player_card.setText("No.3  " + stage_1_nickname_list.get(2) + " " + stage_1_top_score_list.get(2));
            top_4_player_card.setText("No.4  " + stage_1_nickname_list.get(3) + " " + stage_1_top_score_list.get(3));
        } else if (num_card == 5) {
            top_1_player_card.setText("No.1  " + stage_1_nickname_list.get(0) + " " + stage_1_top_score_list.get(0));
            top_2_player_card.setText("No.2  " + stage_1_nickname_list.get(1) + " " + stage_1_top_score_list.get(1));
            top_3_player_card.setText("No.3  " + stage_1_nickname_list.get(2) + " " + stage_1_top_score_list.get(2));
            top_4_player_card.setText("No.4  " + stage_1_nickname_list.get(3) + " " + stage_1_top_score_list.get(3));
            top_5_player_card.setText("No.5  " + stage_1_nickname_list.get(4) + " " + stage_1_top_score_list.get(3));
        }

    }


    public void show_stage_2_scoreboard(View dialog_view) {
        ArrayList<Integer> temp_stage_2_highest_score_list = new ArrayList<>(stage_2_highest_score_list);
        ArrayList<Integer> stage_2_top_score_list = new ArrayList<Integer>();
        ArrayList<String> stage_2_nickname_list = new ArrayList<String>();


        ArrayList<String> temp_nickname_list = new ArrayList<String>(nickname_list);

        int num_card;
        if (num_of_player <= 5) {
            num_card = num_of_player;
        } else {
            num_card = 5;
        }

        // sort stage 1 arraylist
        int i;
        int j;
        int temp_max = 0;
        int temp_top_score_index = 0;
        int temp = num_of_player;

        for (i = 0; i < num_card; i++) {
            for (j = 0; j < temp; j++) {
                if (temp_stage_2_highest_score_list.get(j) > temp_max) {
                    temp_top_score_index = j;
                    temp_max = temp_stage_2_highest_score_list.get(j);
                }
            }
            stage_2_nickname_list.add(temp_nickname_list.get(temp_top_score_index));
            stage_2_top_score_list.add(temp_stage_2_highest_score_list.get(temp_top_score_index));
            temp_stage_2_highest_score_list.remove(temp_top_score_index);
            temp_nickname_list.remove(temp_top_score_index);
            temp_max = 0;
            temp_top_score_index = 0;
            temp -= 1;
        }


        if (num_card == 1) {
            top_1_player_card.setText("No.1  " + stage_2_nickname_list.get(0) + " " + stage_2_top_score_list.get(0));
        } else if (num_card == 2) {
            top_1_player_card.setText("No.1  " + stage_2_nickname_list.get(0) + " " + stage_2_top_score_list.get(0));
            top_2_player_card.setText("No.2  " + stage_2_nickname_list.get(1) + " " + stage_2_top_score_list.get(1));
        } else if (num_card == 3) {
            top_1_player_card.setText("No.1  " + stage_2_nickname_list.get(0) + " " + stage_2_top_score_list.get(0));
            top_2_player_card.setText("No.2  " + stage_2_nickname_list.get(1) + " " + stage_2_top_score_list.get(1));
            top_3_player_card.setText("No.3  " + stage_2_nickname_list.get(2) + " " + stage_2_top_score_list.get(2));

        } else if (num_card == 4) {
            top_1_player_card.setText("No.1  " + stage_2_nickname_list.get(0) + " " + stage_2_top_score_list.get(0));
            top_2_player_card.setText("No.2  " + stage_2_nickname_list.get(1) + " " + stage_2_top_score_list.get(1));
            top_3_player_card.setText("No.3  " + stage_2_nickname_list.get(2) + " " + stage_2_top_score_list.get(2));
            top_4_player_card.setText("No.4  " + stage_2_nickname_list.get(3) + " " + stage_2_top_score_list.get(3));
        } else if (num_card == 5) {

            top_1_player_card.setText("No.1  " + stage_2_nickname_list.get(0) + " " + stage_2_top_score_list.get(0));
            top_2_player_card.setText("No.2  " + stage_2_nickname_list.get(1) + " " + stage_2_top_score_list.get(1));
            top_3_player_card.setText("No.3  " + stage_2_nickname_list.get(2) + " " + stage_2_top_score_list.get(2));
            top_4_player_card.setText("No.4  " + stage_2_nickname_list.get(3) + " " + stage_2_top_score_list.get(3));
            top_5_player_card.setText("No.5  " + stage_2_nickname_list.get(4) + " " + stage_2_top_score_list.get(3));
        }

    }

    @Override
    public void onBackPressed() {
        Task update_user = mDatabase.child("users").child(Login_User.current_User.username).setValue(Login_User.current_User);
        super.onBackPressed();
    }
}
