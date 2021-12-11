package Friend_list_and_scoreboard;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import authentication.login_Activity;
import edu.neu.madcourse.forest_hunter.Appearance;
import edu.neu.madcourse.forest_hunter.R;
import message.Utils;
import user.Login_User;
import user.User;

public class Friends extends AppCompatActivity {

    private ImageView hair_view;
    private ImageView head_view;
    private ImageView eye_view;
    private ImageView nose_view;
    private ImageView mouth_view;
    private ImageView l_eyebrow_view;
    private ImageView r_eyebrow_view;
    private ImageView ear_view;
    private ImageView bottom_view_wear;

    Appearance ap;
    Appearance friend_ap;
    DatabaseReference mDatabase;
    String target_nick_username;
    String search_nick_username;
    TextView friend_nickname_view;
    TextView friend_stage_1_score_view;
    TextView friend_stage_2_score_view;
    ImageButton Search_friend_button;
    ImageButton go_back_button;

    String target_username;
    String self_username = Login_User.current_User.username;
    String targetToken = "";
    String CLIENT_REGISTRATION_TOKEN = login_Activity.CLIENT_REGISTRATION_TOKEN;
    String SERVER_KEY = "AIzaSyAMQQ9MJxTGqLdTx1avANgvaIutoyaw9qE";

    private int current_hair_index = Appearance.current_hair_index;
    private int current_head_index = Appearance.current_head_index;
    private int current_eye_index = Appearance.current_eye_index;
    private int current_nose_index = Appearance.current_nose_index;
    private int current_mouth_index = Appearance.current_mouth_index;
    private int current_l_eye_brow_index = Appearance.current_l_eye_brow_index;
    private int current_r_eye_brow_index = Appearance.current_r_eye_brow_index;
    private int current_ear_index = Appearance.current_ear_index;
    private int current_chest_wear_index = Appearance.current_chest_wear_index;
    private int current_arm_wear_index = Appearance.current_arm_wear_index;
    private int current_shoulder_wear_index = Appearance.current_shoulder_wear_index;
    private int current_leg_wear_index = Appearance.current_leg_wear_index;
    private int current_thigh_wear_index = Appearance.current_thigh_wear_index;
    private int current_bottom_wear_index = Appearance.current_bottom_wear_index;
    private int current_foot_wear_index = Appearance.current_foot_wear_index;
    private int current_chest_index = Appearance.current_chest_index;

    private ImageView chest_view;
    private ImageView r_arm_view;
    private ImageView l_arm_view;
    private ImageView r_shoulder_view;
    private ImageView l_shoulder_view;
    private ImageView r_hand_view;
    private ImageView l_hand_view;

    private ImageView chest_view_wear;
    private ImageView r_arm_view_wear;
    private ImageView l_arm_view_wear;
    private ImageView r_shoulder_view_wear;
    private ImageView l_shoulder_view_wear;

    private ImageView r_thigh_view;
    private ImageView l_thigh_view;
    private ImageView r_leg_view;
    private ImageView l_leg_view;
    private ImageView r_foot_view;
    private ImageView l_foot_view;

    private ImageView r_thigh_view_wear;
    private ImageView l_thigh_view_wear;
    private ImageView r_leg_view_wear;
    private ImageView l_leg_view_wear;
    private ImageView r_foot_view_wear;
    private ImageView l_foot_view_wear;

    private Spinner friends_Spinner;
    List<String> friend_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_view);

        String current_user_name = Login_User.current_User.username;
        String current_user_nickname = Login_User.current_User.nickname;

        friend_nickname_view = findViewById(R.id.friend_nickname);
        friend_nickname_view.setText(current_user_nickname);

        target_nick_username = current_user_name;
        friend_nickname_view.setText(target_nick_username);

        friend_stage_1_score_view = findViewById(R.id.stage_1_best_score);
        friend_stage_1_score_view.setText(Login_User.current_User.highest_score_list.get(0));

        friend_stage_2_score_view = findViewById(R.id.stage_2_best_score);
        friend_stage_2_score_view.setText(Login_User.current_User.highest_score_list.get(1));


        Search_friend_button = findViewById(R.id.search_friend_button);
        Search_friend_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                search_friend_dialog();
            }
        });

        go_back_button = findViewById(R.id.friend_go_back_button);
        go_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").child(current_user_name).child("friend_list").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                friends_Spinner = findViewById(R.id.friend_spinner);
                friends_Spinner.setPrompt("Select your Friend");
                friend_list = new ArrayList<String>();
                friend_list.add(0, "Please select your friend:");
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String nick_name1 = dataSnapshot.getValue(String.class);
                    if (!nick_name1.equals("")) {
                        friend_list.add(nick_name1);
                    }
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Friends.this, android.R.layout.simple_spinner_item, friend_list);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                friends_Spinner.setAdapter(arrayAdapter);
                friends_Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i != 0) {
                            target_nick_username = adapterView.getItemAtPosition(i).toString();
                            friend_nickname_view.setText(target_nick_username);
                            update_based_on_nickname(target_nick_username);
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        update_based_on_nickname(target_nick_username);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        ap = new Appearance();

        hair_view = findViewById(R.id.hair_view);
        hair_view.setBackground(null);
        hair_view.setImageResource(ap.hair_image_id_list[Appearance.current_hair_index]);

        head_view = findViewById(R.id.head_view);
        head_view.setBackground(null);
        head_view.setImageResource(ap.head_image_id_list[Appearance.current_head_index]);

        eye_view = findViewById(R.id.eyes_view);
        eye_view.setBackground(null);
        eye_view.setImageResource(ap.eye_image_id_list[Appearance.current_eye_index]);


        nose_view = findViewById(R.id.nose_view);
        nose_view.setBackground(null);
        nose_view.setImageResource(ap.nose_image_id_list[Appearance.current_nose_index]);


        mouth_view = findViewById(R.id.mouth_view);
        mouth_view.setBackground(null);
        mouth_view.setImageResource(ap.mouth_image_id_list[Appearance.current_mouth_index]);

        l_eyebrow_view = findViewById(R.id.l_eyebrow_view);
        l_eyebrow_view.setBackground(null);
        l_eyebrow_view.setImageResource(ap.l_eye_brow_image_id_list[Appearance.current_l_eye_brow_index]);

        r_eyebrow_view = findViewById(R.id.r_eyebrow_view);
        r_eyebrow_view.setBackground(null);
        r_eyebrow_view.setImageResource(ap.r_eye_brow_image_id_list[Appearance.current_r_eye_brow_index]);

        ear_view = findViewById(R.id.ear_view);
        ear_view.setBackground(null);
        ear_view.setImageResource(ap.ear_image_id_list[Appearance.current_ear_index]);

        // TODO Step 1 setup image id list in Appearance.java
        // TODO step 2 set background to null and then set image resource based on current index

        chest_view = findViewById(R.id.chest_view);
        chest_view = findViewById(R.id.chest_view_wear);
        chest_view.setBackground(null);
        chest_view.setImageResource(ap.chest_image_id_list[Appearance.current_chest_index]);


        r_arm_view = findViewById(R.id.r_arm_view);
        l_arm_view = findViewById(R.id.l_arm_view);
        r_shoulder_view = findViewById(R.id.r_shoulder_view);
        l_shoulder_view = findViewById(R.id.l_shoulder_view);

        chest_view_wear = findViewById(R.id.chest_view_wear);
        if (current_chest_wear_index != 17) {
            chest_view_wear.setBackground(null);
            chest_view_wear.setImageResource(ap.chest_wear_image_id_list[Appearance.current_chest_wear_index]);

        }

        r_arm_view_wear = findViewById(R.id.r_arm_view_wear);
        l_arm_view_wear = findViewById(R.id.l_arm_view_wear);
        r_arm_view_wear.setBackground(null);
        r_arm_view_wear.setImageResource(ap.arm_r_l_wear_image_id_list[Appearance.current_arm_wear_index][0]);
        l_arm_view_wear.setBackground(null);
        l_arm_view_wear.setImageResource(ap.arm_r_l_wear_image_id_list[Appearance.current_arm_wear_index][1]);


        r_shoulder_view_wear = findViewById(R.id.r_shoulder_view_wear);
        l_shoulder_view_wear = findViewById(R.id.l_shoulder_view_wear);
        r_shoulder_view_wear.setBackground(null);
        r_shoulder_view_wear.setImageResource(ap.shoulder_r_l_wear_image_id_list[Appearance.current_shoulder_wear_index][0]);
        l_shoulder_view_wear.setBackground(null);
        l_shoulder_view_wear.setImageResource(ap.shoulder_r_l_wear_image_id_list[Appearance.current_shoulder_wear_index][1]);


        r_hand_view = findViewById(R.id.r_hand_view);
        l_hand_view = findViewById(R.id.l_hand_finger_view);

        r_thigh_view = findViewById(R.id.r_thigh_view);
        l_thigh_view = findViewById(R.id.l_thigh_view);
        r_leg_view = findViewById(R.id.r_leg_view);
        l_leg_view = findViewById(R.id.l_leg_view);
        r_foot_view = findViewById(R.id.r_foot_view);
        l_foot_view = findViewById(R.id.l_foot_view);

        r_thigh_view_wear = findViewById(R.id.r_thigh_view_wear);
        l_thigh_view_wear = findViewById(R.id.l_thigh_view_wear);
        r_thigh_view_wear.setBackground(null);
        r_thigh_view_wear.setImageResource(ap.thigh_r_l_wear_image_id_list[Appearance.current_thigh_wear_index][0]);
        l_thigh_view_wear.setBackground(null);
        l_thigh_view_wear.setImageResource(ap.thigh_r_l_wear_image_id_list[Appearance.current_thigh_wear_index][1]);

        r_leg_view_wear = findViewById(R.id.r_leg_view_wear);
        l_leg_view_wear = findViewById(R.id.l_leg_view_wear);
        r_leg_view_wear.setBackground(null);
        r_leg_view_wear.setImageResource(ap.leg_r_l_wear_image_id_list[Appearance.current_leg_wear_index][0]);
        l_leg_view_wear.setBackground(null);
        l_leg_view_wear.setImageResource(ap.leg_r_l_wear_image_id_list[Appearance.current_leg_wear_index][1]);


        r_foot_view_wear = findViewById(R.id.r_foot_view_wear);
        l_foot_view_wear = findViewById(R.id.l_foot_view_wear);
        r_foot_view_wear.setBackground(null);
        r_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[Appearance.current_foot_wear_index][0]);
        l_foot_view_wear.setBackground(null);
        l_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[Appearance.current_foot_wear_index][1]);

        bottom_view_wear = findViewById(R.id.bottom_view_wear);
        bottom_view_wear.setBackground(null);
        bottom_view_wear.setImageResource(ap.bottom_wear_image_id_list[Appearance.current_bottom_wear_index]);
    }

    public void search_friend_dialog() {

        final AlertDialog.Builder dialog;
        final EditText input_nickname;
        Button input_cancel_button;
        Button input_confirm_button;
        final AlertDialog alert_dialog;

        dialog = new AlertDialog.Builder(Friends.this);
        View dialog_view = getLayoutInflater().inflate(R.layout.search_friend_enter_nickname, null);

        input_nickname = dialog_view.findViewById(R.id.search_friend_enter_nickname_input_box);
        input_cancel_button = dialog_view.findViewById(R.id.search_friend_enter_nickname_cancel_button);
        input_confirm_button = dialog_view.findViewById(R.id.search_friend_enter_nickname_confirm_button);


        dialog.setView(dialog_view);
        alert_dialog = dialog.create();

        alert_dialog.setCanceledOnTouchOutside(false);

        input_cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alert_dialog.dismiss();
            }
        });

        input_confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                search_nick_username = input_nickname.getText().toString();

                DatabaseReference user_database = mDatabase.child("users");
                user_database.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        boolean find_friend_nickname = false;
                        for (DataSnapshot pss : snapshot.getChildren()) {

                            if (pss.child("nickname").exists()) {
                                String temp_nickname = pss.child("nickname").getValue().toString();
                                if (temp_nickname.equals(search_nick_username)) {
                                    if (!Login_User.current_User.friend_list.contains(search_nick_username) && !search_nick_username.equals(Login_User.current_User.nickname) ) {
                                        target_username = pss.child("username").getValue().toString();
                                        Login_User.current_User.friend_list.add(search_nick_username);
                                        Task update_user = mDatabase.child("users").child(Login_User.current_User.username).setValue(Login_User.current_User);
                                        find_friend_nickname = true;
                                        Toast.makeText(Friends.this, "Successfully add " + search_nick_username + " to your friend list.", Toast.LENGTH_SHORT).show();
                                        Toast.makeText(Friends.this, "Please enter this page again to check your new friend", Toast.LENGTH_SHORT).show();
                                        sendMessageToOtherUser(view);
                                    } else {
                                        find_friend_nickname = true;
                                        Toast.makeText(Friends.this, search_nick_username + " is already in your friend list", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }

                        if (find_friend_nickname == false) {
                            Toast.makeText(Friends.this, "This Nickname Does not Exist, please check your spell!", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                });


                alert_dialog.dismiss();

            }
        }
        );


        alert_dialog.show();
    }


    public void update_based_on_nickname(String target_nick_username) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot pss : snapshot.getChildren()) {
                    if (pss.child("nickname").exists()) {
                        if (pss.child("nickname").getValue().toString().equals(target_nick_username)) {

                            friend_stage_1_score_view.setText(pss.child("highest_score_list").child("0").getValue().toString());
                            friend_stage_2_score_view.setText(pss.child("highest_score_list").child("1").getValue().toString());
                            //TODO setup character features
                            current_hair_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_hair_index").getValue().toString());
                            current_head_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_head_index").getValue().toString());
                            current_eye_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_eye_index").getValue().toString());
                            current_nose_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_nose_index").getValue().toString());
                            current_mouth_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_mouth_index").getValue().toString());
                            current_l_eye_brow_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_l_eye_brow_index").getValue().toString());
                            current_r_eye_brow_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_r_eye_brow_index").getValue().toString());
                            current_ear_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_ear_index").getValue().toString());
                            current_chest_wear_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_chest_wear_index").getValue().toString());
                            current_arm_wear_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_arm_wear_index").getValue().toString());
                            current_shoulder_wear_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_shoulder_wear_index").getValue().toString());
                            current_leg_wear_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_leg_wear_index").getValue().toString());
                            current_thigh_wear_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_thigh_wear_index").getValue().toString());
                            current_bottom_wear_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_bottom_wear_index").getValue().toString());
                            current_foot_wear_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_foot_wear_index").getValue().toString());
                            current_chest_index = Integer.parseInt(pss.child("Character_setting").child("0").child("current_chest_index").getValue().toString());

                            hair_view.setBackground(null);
                            hair_view.setImageResource(ap.hair_image_id_list[current_hair_index]);

                            head_view.setBackground(null);
                            head_view.setImageResource(ap.head_image_id_list[current_head_index]);

                            eye_view.setBackground(null);
                            eye_view.setImageResource(ap.eye_image_id_list[current_eye_index]);

                            nose_view.setBackground(null);
                            nose_view.setImageResource(ap.nose_image_id_list[current_nose_index]);

                            mouth_view.setBackground(null);
                            mouth_view.setImageResource(ap.mouth_image_id_list[current_mouth_index]);

                            l_eyebrow_view.setBackground(null);
                            l_eyebrow_view.setImageResource(ap.l_eye_brow_image_id_list[current_l_eye_brow_index]);

                            r_eyebrow_view.setBackground(null);
                            r_eyebrow_view.setImageResource(ap.r_eye_brow_image_id_list[current_r_eye_brow_index]);

                            ear_view.setBackground(null);
                            ear_view.setImageResource(ap.ear_image_id_list[current_ear_index]);

                            chest_view.setBackground(null);
                            chest_view.setImageResource(ap.chest_image_id_list[current_chest_index]);

                            if (current_chest_wear_index != 17) {
                                chest_view_wear.setBackground(null);
                                chest_view_wear.setImageResource(ap.chest_wear_image_id_list[current_chest_wear_index]);

                            }

                            r_arm_view_wear.setBackground(null);
                            r_arm_view_wear.setImageResource(ap.arm_r_l_wear_image_id_list[current_arm_wear_index][0]);
                            l_arm_view_wear.setBackground(null);
                            l_arm_view_wear.setImageResource(ap.arm_r_l_wear_image_id_list[current_arm_wear_index][1]);


                            r_shoulder_view_wear.setBackground(null);
                            r_shoulder_view_wear.setImageResource(ap.shoulder_r_l_wear_image_id_list[current_shoulder_wear_index][0]);
                            l_shoulder_view_wear.setBackground(null);
                            l_shoulder_view_wear.setImageResource(ap.shoulder_r_l_wear_image_id_list[current_shoulder_wear_index][1]);

                            r_thigh_view_wear.setBackground(null);
                            r_thigh_view_wear.setImageResource(ap.thigh_r_l_wear_image_id_list[current_thigh_wear_index][0]);
                            l_thigh_view_wear.setBackground(null);
                            l_thigh_view_wear.setImageResource(ap.thigh_r_l_wear_image_id_list[current_thigh_wear_index][1]);

                            r_leg_view_wear.setBackground(null);
                            r_leg_view_wear.setImageResource(ap.leg_r_l_wear_image_id_list[current_leg_wear_index][0]);
                            l_leg_view_wear.setBackground(null);
                            l_leg_view_wear.setImageResource(ap.leg_r_l_wear_image_id_list[current_leg_wear_index][1]);

                            r_foot_view_wear.setBackground(null);
                            r_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[current_foot_wear_index][0]);
                            l_foot_view_wear.setBackground(null);
                            l_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[current_foot_wear_index][1]);

                            bottom_view_wear.setBackground(null);
                            bottom_view_wear.setImageResource(ap.bottom_wear_image_id_list[current_bottom_wear_index]);
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }


    //TODO

    public void sendMessageToOtherUser(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (target_username!=null) {
                    sendMessageToOtherUser(target_username);
                }
            }
        }).start();
    }



    private void sendMessageToOtherUser(String target_username) {

        JSONObject jPayload = new JSONObject();
        JSONObject jNotification = new JSONObject();
        JSONObject jdata = new JSONObject();
        try {
            jNotification.put("title", self_username + "just added you to his friend list");
            jNotification.put("body", "you want to add " +self_username + " as you friend? you can review his/her character.");
            jNotification.put("sound", "default");
            jNotification.put("click_action", "OPEN_ACTIVITY_1");


            jdata.put("title", self_username + "just added you to his friend list");
            jdata.put("content", "you want to add " +self_username + " as you friend? you can review his/her character.");


            // get target token
            DatabaseReference username_list_ref = mDatabase.child("users").child(target_username).child("CLIENT_REGISTRATION_TOKEN");
            username_list_ref.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    targetToken = (String)dataSnapshot.getValue();
                    Log.e("target_token", targetToken);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                @Override
                public void onComplete(@NonNull Task<String> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(Friends.this, "Something is wrong, please check your Internet connection!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (CLIENT_REGISTRATION_TOKEN.length() < 1) {
                            CLIENT_REGISTRATION_TOKEN = task.getResult();
                        }
                        Log.e("CLIENT_REGISTRATION_TOKEN", CLIENT_REGISTRATION_TOKEN);
                    }

                }
            });



            jPayload.put("to", targetToken);
            jPayload.put("priority", "high");
            jPayload.put("notification", jNotification);
            jPayload.put("data", jdata);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        final String resp = Utils.fcmHttpConnection(SERVER_KEY, jPayload);

    }


}
