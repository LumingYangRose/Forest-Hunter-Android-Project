package edu.neu.madcourse.forest_hunter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Character_customize_Activity extends AppCompatActivity {

    private EditText User_name_Edit_Text;
    private TextView selection_title_textview1;
    private TextView selection_title_textview2;
    private TextView selection_title_textview3;
    private TextView selection_title_textview4;
    private TextView appearance_change_textview1;
    private TextView appearance_change_textview2;
    private TextView appearance_change_textview3;
    private TextView appearance_change_textview4;

    private ImageButton appearance_last_button1;
    private ImageButton appearance_next_button1;
    private ImageButton appearance_last_button2;
    private ImageButton appearance_next_button2;
    private ImageButton appearance_last_button3;
    private ImageButton appearance_next_button3;
    private ImageButton appearance_last_button4;
    private ImageButton appearance_next_button4;
    private ImageButton character_next_page_button;
    private ImageButton character_last_page_button;
    private ImageButton appearance_confirm_button;

    private ImageView hair_view;
    private ImageView head_view;
    private ImageView eye_view;
    private ImageView nose_view;
    private ImageView mouth_view;
    private ImageView l_eyebrow_view;
    private ImageView r_eyebrow_view;
    private ImageView ear_view;
    private ImageView bottom_view_wear;

    private int current_page_number;

    //TODO step 0 add current index for the new attribute
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

    Appearance ap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_view);

        appearance_change_textview1 = findViewById(R.id.appearance_change_textview1);
        appearance_change_textview2 = findViewById(R.id.appearance_change_textview2);
        appearance_change_textview3 = findViewById(R.id.appearance_change_textview3);
        appearance_change_textview4 = findViewById(R.id.appearance_change_textview4);


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
        //chest_view_wear.setBackground(null);
        //chest_view_wear.setImageResource(ap.chest_wear_image_id_list[Appearance.current_chest_wear_index]);

        if(current_chest_wear_index != 17)
        {
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

        current_page_number = 1;

        appearance_change_textview1.setText("Style 1");
        appearance_change_textview2.setText("Style 1");
        appearance_change_textview3.setText("Style 1");
        appearance_change_textview4.setText("Style 1");

        User_name_Edit_Text = findViewById(R.id.User_name_EditText);

        selection_title_textview1 = findViewById(R.id.selection_title_textview1);
        selection_title_textview2 = findViewById(R.id.selection_title_textview2);
        selection_title_textview3 = findViewById(R.id.selection_title_textview3);
        selection_title_textview4 = findViewById(R.id.selection_title_textview4);

        appearance_change_textview1 = findViewById(R.id.appearance_change_textview1);
        appearance_change_textview2 = findViewById(R.id.appearance_change_textview2);
        appearance_change_textview3 = findViewById(R.id.appearance_change_textview3);
        appearance_change_textview4 = findViewById(R.id.appearance_change_textview4);

        //TODO STEP 3 set the switch case for the page
        appearance_last_button1 = findViewById(R.id.appearance_last_button1);
        appearance_last_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (current_page_number) {
                    case 1:
                        current_hair_index--;

                        if (current_hair_index < 0)
                        {
                            current_hair_index = ap.hair_image_id_list.length - 1;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_hair_index + 1));
                        hair_view.setBackground(null);
                        hair_view.setImageResource(ap.hair_image_id_list[current_hair_index]);

                        Appearance.current_hair_index = current_hair_index;

                        break;

                    case 2:
                        current_mouth_index--;

                        if (current_mouth_index < 0)
                        {
                            current_mouth_index = ap.mouth_image_id_list.length - 1;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_mouth_index + 1));
                        mouth_view.setBackground(null);
                        mouth_view.setImageResource(ap.hair_image_id_list[current_mouth_index]);

                        Appearance.current_mouth_index = current_mouth_index;
                        break;

                    case 3:
                        current_chest_wear_index--;

                        if (current_chest_wear_index < 0)
                        {
                            current_chest_wear_index = ap.chest_wear_image_id_list.length - 1;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_chest_wear_index + 1));
                        chest_view_wear.setBackground(null);
                        chest_view_wear.setImageResource(ap.chest_wear_image_id_list[current_chest_wear_index]);

                        Appearance.current_chest_wear_index = current_chest_wear_index;
                        break;

                    case 4:
                        current_thigh_wear_index--;

                        if (current_thigh_wear_index < 0)
                        {
                            current_thigh_wear_index = ap.thigh_r_l_wear_image_id_list.length - 1;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_thigh_wear_index + 1));
                        r_thigh_view_wear.setBackground(null);
                        r_thigh_view_wear.setImageResource(ap.thigh_r_l_wear_image_id_list[current_thigh_wear_index][0]);

                        l_thigh_view_wear.setBackground(null);
                        l_thigh_view_wear.setImageResource(ap.thigh_r_l_wear_image_id_list[current_thigh_wear_index][1]);

                        Appearance.current_thigh_wear_index = current_thigh_wear_index;
                        break;
                }
            }
        });

        appearance_next_button1 = findViewById(R.id.appearance_next_button1);
        appearance_next_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (current_page_number) {
                    case 1:
                        current_hair_index++;

                        if (current_hair_index > ap.hair_image_id_list.length - 1)
                        {
                            current_hair_index = 0;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_hair_index + 1));
                        hair_view.setBackground(null);
                        hair_view.setImageResource(ap.hair_image_id_list[current_hair_index]);
                        Appearance.current_hair_index = current_hair_index;

                        break;

                    case 2:

                        current_mouth_index++;

                        if (current_mouth_index > ap.mouth_image_id_list.length - 1)
                        {
                            current_mouth_index = 0;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_mouth_index + 1));
                        mouth_view.setBackground(null);
                        mouth_view.setImageResource(ap.mouth_image_id_list[current_mouth_index]);
                        Appearance.current_mouth_index = current_mouth_index;
                        break;

                    case 3:
                        current_chest_wear_index++;

                        if (current_chest_wear_index > ap.chest_wear_image_id_list.length - 1)
                        {
                            current_chest_wear_index = 0;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_chest_wear_index + 1));
                        chest_view_wear.setBackground(null);
                        chest_view_wear.setImageResource(ap.chest_wear_image_id_list[current_chest_wear_index]);

                        Appearance.current_chest_wear_index = current_chest_wear_index;
                        break;

                    case 4:
                        current_thigh_wear_index++;

                        if (current_thigh_wear_index > ap.thigh_r_l_wear_image_id_list.length - 1)
                        {
                            current_thigh_wear_index = 0;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_thigh_wear_index + 1));
                        r_thigh_view_wear.setBackground(null);
                        r_thigh_view_wear.setImageResource(ap.thigh_r_l_wear_image_id_list[current_thigh_wear_index][0]);

                        l_thigh_view_wear.setBackground(null);
                        l_thigh_view_wear.setImageResource(ap.thigh_r_l_wear_image_id_list[current_thigh_wear_index][1]);

                        Appearance.current_thigh_wear_index = current_thigh_wear_index;
                        break;

                }
            }
        });

        appearance_last_button2 = findViewById(R.id.appearance_last_button2);
        appearance_last_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (current_page_number) {
                    case 1:
                        current_head_index--;

                        if (current_head_index < 0)
                        {
                            current_head_index = ap.head_image_id_list.length - 1;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_head_index + 1));
                        head_view.setBackground(null);
                        head_view.setImageResource(ap.head_image_id_list[current_head_index]);
                        Appearance.current_head_index = current_head_index;
                        break;

                    case 2:
                        current_l_eye_brow_index--;

                        if (current_l_eye_brow_index < 0)
                        {
                            current_l_eye_brow_index = ap.l_eye_brow_image_id_list.length - 1;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_l_eye_brow_index + 1));
                        l_eyebrow_view.setBackground(null);
                        l_eyebrow_view.setImageResource(ap.l_eye_brow_image_id_list[current_l_eye_brow_index]);
                        Appearance.current_l_eye_brow_index = current_l_eye_brow_index;
                        break;

                    case 3:
                        current_shoulder_wear_index--;

                        if (current_shoulder_wear_index < 0)
                        {
                            current_shoulder_wear_index = ap.shoulder_r_l_wear_image_id_list.length - 1;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_shoulder_wear_index + 1));
                        r_shoulder_view_wear.setBackground(null);
                        r_shoulder_view_wear.setImageResource(ap.shoulder_r_l_wear_image_id_list[current_shoulder_wear_index][0]);

                        l_shoulder_view_wear.setBackground(null);
                        l_shoulder_view_wear.setImageResource(ap.shoulder_r_l_wear_image_id_list[current_shoulder_wear_index][1]);

                        Appearance.current_shoulder_wear_index = current_shoulder_wear_index;
                        break;

                    case 4:
                        current_leg_wear_index--;

                        if (current_leg_wear_index < 0)
                        {
                            current_leg_wear_index = ap.leg_r_l_wear_image_id_list.length - 1;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_leg_wear_index + 1));
                        r_leg_view_wear.setBackground(null);
                        r_leg_view_wear.setImageResource(ap.leg_r_l_wear_image_id_list[current_leg_wear_index][0]);

                        l_leg_view_wear.setBackground(null);
                        l_leg_view_wear.setImageResource(ap.leg_r_l_wear_image_id_list[current_leg_wear_index][1]);

                        Appearance.current_leg_wear_index = current_leg_wear_index;
                        break;

                }
            }
        });

        appearance_next_button2 = findViewById(R.id.appearance_next_button2);
        appearance_next_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (current_page_number) {
                    case 1:
                        current_head_index++;

                        if (current_head_index > ap.head_image_id_list.length - 1)
                        {
                            current_head_index = 0;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_head_index + 1));
                        head_view.setBackground(null);
                        head_view.setImageResource(ap.head_image_id_list[current_head_index]);
                        Appearance.current_head_index = current_head_index;
                        break;

                    case 2:

                        current_l_eye_brow_index++;

                        if (current_l_eye_brow_index > ap.l_eye_brow_image_id_list.length - 1)
                        {
                            current_l_eye_brow_index = 0;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_l_eye_brow_index + 1));
                        l_eyebrow_view.setBackground(null);
                        l_eyebrow_view.setImageResource(ap.l_eye_brow_image_id_list[current_l_eye_brow_index]);
                        Appearance.current_l_eye_brow_index = current_l_eye_brow_index;
                        break;

                    case 3:
                        current_shoulder_wear_index++;

                        if (current_shoulder_wear_index > ap.shoulder_r_l_wear_image_id_list.length - 1)
                        {
                            current_shoulder_wear_index = 0;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_shoulder_wear_index + 1));
                        r_shoulder_view_wear.setBackground(null);
                        r_shoulder_view_wear.setImageResource(ap.shoulder_r_l_wear_image_id_list[current_shoulder_wear_index][0]);

                        l_shoulder_view_wear.setBackground(null);
                        l_shoulder_view_wear.setImageResource(ap.shoulder_r_l_wear_image_id_list[current_shoulder_wear_index][1]);

                        Appearance.current_shoulder_wear_index = current_shoulder_wear_index;
                        break;

                    case 4:
                        current_leg_wear_index++;

                        if (current_leg_wear_index > ap.leg_r_l_wear_image_id_list.length - 1)
                        {
                            current_leg_wear_index = 0;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_leg_wear_index + 1));
                        r_leg_view_wear.setBackground(null);
                        r_leg_view_wear.setImageResource(ap.leg_r_l_wear_image_id_list[current_leg_wear_index][0]);

                        l_leg_view_wear.setBackground(null);
                        l_leg_view_wear.setImageResource(ap.leg_r_l_wear_image_id_list[current_leg_wear_index][1]);

                        Appearance.current_leg_wear_index = current_leg_wear_index;
                        break;

                }
            }
        });

        appearance_last_button3 = findViewById(R.id.appearance_last_button3);
        appearance_last_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (current_page_number) {
                    case 1:
                        current_eye_index--;

                        if (current_eye_index < 0)
                        {
                            current_eye_index = ap.eye_image_id_list.length - 1;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_eye_index + 1));
                        eye_view.setBackground(null);
                        eye_view.setImageResource(ap.eye_image_id_list[current_eye_index]);
                        Appearance.current_eye_index = current_eye_index;
                        break;

                    case 2:
                        current_r_eye_brow_index--;

                        if (current_r_eye_brow_index < 0)
                        {
                            current_r_eye_brow_index = ap.r_eye_brow_image_id_list.length - 1;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_r_eye_brow_index + 1));
                        r_eyebrow_view.setBackground(null);
                        r_eyebrow_view.setImageResource(ap.r_eye_brow_image_id_list[current_r_eye_brow_index]);
                        Appearance.current_r_eye_brow_index = current_r_eye_brow_index;
                        break;

                    case 3:
                        current_arm_wear_index--;

                        if (current_arm_wear_index < 0)
                        {
                            current_arm_wear_index = ap.arm_r_l_wear_image_id_list.length - 1;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_arm_wear_index + 1));
                        r_arm_view_wear.setBackground(null);
                        r_arm_view_wear.setImageResource(ap.arm_r_l_wear_image_id_list[current_arm_wear_index][0]);

                        l_arm_view_wear.setBackground(null);
                        l_arm_view_wear.setImageResource(ap.arm_r_l_wear_image_id_list[current_arm_wear_index][1]);

                        Appearance.current_arm_wear_index = current_arm_wear_index;
                        break;

                    case 4:
                        current_foot_wear_index--;

                        if (current_foot_wear_index < 0)
                        {
                            current_foot_wear_index = ap.foot_r_l_wear_image_id_list.length - 1;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_foot_wear_index + 1));
                        r_foot_view_wear.setBackground(null);
                        r_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[current_foot_wear_index][0]);

                        l_foot_view_wear.setBackground(null);
                        l_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[current_foot_wear_index][1]);

                        Appearance.current_foot_wear_index = current_foot_wear_index;
                        break;

                }
            }
        });

        appearance_next_button3 = findViewById(R.id.appearance_next_button3);
        appearance_next_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (current_page_number) {
                    case 1:
                        current_eye_index++;

                        if (current_eye_index > ap.eye_image_id_list.length - 1)
                        {
                            current_eye_index = 0;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_eye_index + 1));
                        eye_view.setBackground(null);
                        eye_view.setImageResource(ap.eye_image_id_list[current_eye_index]);
                        Appearance.current_eye_index = current_eye_index;
                        break;

                    case 2:

                        current_r_eye_brow_index++;

                        if (current_r_eye_brow_index > ap.r_eye_brow_image_id_list.length - 1)
                        {
                            current_r_eye_brow_index = 0;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_r_eye_brow_index + 1));
                        r_eyebrow_view.setBackground(null);
                        r_eyebrow_view.setImageResource(ap.r_eye_brow_image_id_list[current_r_eye_brow_index]);
                        Appearance.current_r_eye_brow_index = current_r_eye_brow_index;
                        break;

                    case 3:
                        current_arm_wear_index++;

                        if (current_arm_wear_index > ap.arm_r_l_wear_image_id_list.length - 1)
                        {
                            current_arm_wear_index = 0;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_arm_wear_index + 1));
                        r_arm_view_wear.setBackground(null);
                        r_arm_view_wear.setImageResource(ap.arm_r_l_wear_image_id_list[current_arm_wear_index][0]);

                        l_arm_view_wear.setBackground(null);
                        l_arm_view_wear.setImageResource(ap.arm_r_l_wear_image_id_list[current_arm_wear_index][1]);

                        Appearance.current_arm_wear_index = current_arm_wear_index;
                        break;

                    case 4:
                        current_foot_wear_index++;

                        if (current_foot_wear_index > ap.foot_r_l_wear_image_id_list.length - 1)
                        {
                            current_foot_wear_index = 0;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_foot_wear_index + 1));
                        r_foot_view_wear.setBackground(null);
                        r_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[current_foot_wear_index][0]);

                        l_foot_view_wear.setBackground(null);
                        l_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[current_foot_wear_index][1]);

                        Appearance.current_foot_wear_index = current_foot_wear_index;
                        break;

                }
            }
        });

        appearance_last_button4 = findViewById(R.id.appearance_last_button4);
        appearance_last_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (current_page_number) {
                    case 1:
                        current_nose_index--;

                        if (current_nose_index < 0)
                        {
                            current_nose_index = ap.nose_image_id_list.length - 1;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_nose_index + 1));
                        nose_view.setBackground(null);
                        nose_view.setImageResource(ap.nose_image_id_list[current_nose_index]);
                        Appearance.current_nose_index = current_nose_index;
                        break;

                    case 2:
                        current_ear_index--;

                        if (current_ear_index < 0)
                        {
                            current_ear_index = ap.ear_image_id_list.length - 1;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_ear_index + 1));
                        ear_view.setBackground(null);
                        ear_view.setImageResource(ap.ear_image_id_list[current_ear_index]);
                        Appearance.current_ear_index = current_ear_index;
                        break;

                    case 3:
                        current_bottom_wear_index--;

                        if (current_bottom_wear_index < 0)
                        {
                            current_bottom_wear_index = ap.bottom_wear_image_id_list.length - 1;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_bottom_wear_index + 1));
                        bottom_view_wear.setBackground(null);
                        bottom_view_wear.setImageResource(ap.bottom_wear_image_id_list[current_bottom_wear_index]);

                        Appearance.current_bottom_wear_index = current_bottom_wear_index;
                        break;

                    case 4:
                        current_chest_index--;

                        if (current_chest_index < 0)
                        {
                            current_chest_index = ap.chest_image_id_list.length - 1;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_chest_index + 1));
                        chest_view.setBackground(null);
                        chest_view.setImageResource(ap.chest_image_id_list[current_chest_index]);

                        if (current_chest_wear_index != 17)
                        {
                            chest_view_wear.setBackground(null);
                            chest_view_wear.setImageResource(ap.chest_wear_image_id_list[Appearance.current_chest_wear_index]);
                        }

                        Appearance.current_chest_index = current_chest_index;
                        break;

                }
            }
        });

        appearance_next_button4 = findViewById(R.id.appearance_next_button4);
        appearance_next_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (current_page_number) {
                    case 1:

                        current_nose_index++;

                        if (current_nose_index > ap.nose_image_id_list.length - 1)
                        {
                            current_nose_index = 0;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_nose_index + 1));
                        nose_view.setBackground(null);
                        nose_view.setImageResource(ap.nose_image_id_list[current_nose_index]);
                        Appearance.current_nose_index = current_nose_index;
                        break;

                    case 2:

                        current_ear_index++;

                        if (current_ear_index > ap.ear_image_id_list.length - 1)
                        {
                            current_ear_index = 0;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_ear_index + 1));
                        ear_view.setBackground(null);
                        ear_view.setImageResource(ap.ear_image_id_list[current_ear_index]);
                        Appearance.current_ear_index = current_ear_index;
                        break;

                    case 3:
                        current_bottom_wear_index++;

                        if (current_bottom_wear_index > ap.bottom_wear_image_id_list.length - 1)
                        {
                            current_bottom_wear_index = 0;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_bottom_wear_index + 1));
                        bottom_view_wear.setBackground(null);
                        bottom_view_wear.setImageResource(ap.bottom_wear_image_id_list[current_bottom_wear_index]);

                        Appearance.current_bottom_wear_index = current_bottom_wear_index;
                        break;

                    case 4:
                        current_chest_index++;

                        if (current_chest_index > ap.chest_image_id_list.length - 1)
                        {
                            current_chest_index = 0;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_chest_index + 1));
                        chest_view.setBackground(null);
                        chest_view.setImageResource(ap.chest_image_id_list[current_chest_index]);

                        if (current_chest_wear_index != 17)
                        {
                            chest_view_wear.setBackground(null);
                            chest_view_wear.setImageResource(ap.chest_wear_image_id_list[Appearance.current_chest_wear_index]);
                        }


                        Appearance.current_chest_index = current_chest_index;
                        break;

                }
            }
        });

        character_next_page_button = findViewById(R.id.character_next_page_button);
        character_next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current_page_number++;

                if (current_page_number > 4)
                {
                    current_page_number = 1;
                }

                switch (current_page_number) {

                    case 1:
                        selection_title_textview1.setText("Hair");
                        selection_title_textview2.setText("Head");
                        selection_title_textview3.setText("Eye");
                        selection_title_textview4.setText("Nose");
                        break;
                    case 2:
                        selection_title_textview1.setText("Mouth");
                        selection_title_textview2.setText("Left Eyebrow");
                        selection_title_textview3.setText("Right Eyebrow");
                        selection_title_textview4.setText("Ear");
                        break;
                    case 3:
                        selection_title_textview1.setText("Chest Wear");
                        selection_title_textview2.setText("Shoulder Wear");
                        selection_title_textview3.setText("Arm Wear");
                        selection_title_textview4.setText("bottom Wear");
                        break;
                    case 4:
                        selection_title_textview1.setText("Thigh Wear");
                        selection_title_textview2.setText("Leg Wear");
                        selection_title_textview3.setText("foot Wear");
                        selection_title_textview4.setText("Chest");
                        break;


                }

                //TODO
            }
        });

        character_last_page_button = findViewById(R.id.character_last_page_button);
        character_last_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current_page_number--;

                if (current_page_number < 1)
                {
                    current_page_number = 4;
                }

                switch (current_page_number) {

                    case 1:
                        selection_title_textview1.setText("Hair");
                        selection_title_textview2.setText("Head");
                        selection_title_textview3.setText("Eye");
                        selection_title_textview4.setText("Nose");
                        break;
                    case 2:
                        selection_title_textview1.setText("Mouth");
                        selection_title_textview2.setText("Left Eyebrow");
                        selection_title_textview3.setText("Right Eyebrow");
                        selection_title_textview4.setText("Ear");
                        break;

                    case 3:
                        selection_title_textview1.setText("Chest Wear");
                        selection_title_textview2.setText("Shoulder Wear");
                        selection_title_textview3.setText("Arm Wear");
                        selection_title_textview4.setText("bottom Wear");
                        break;
                    case 4:
                        selection_title_textview1.setText("Thigh Wear");
                        selection_title_textview2.setText("Leg Wear");
                        selection_title_textview3.setText("foot Wear");
                        selection_title_textview4.setText("Chest");
                        break;

                }

                //TODO
            }
        });

        appearance_confirm_button  = findViewById(R.id.appearance_confirm_button);
        appearance_confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activate_MainActivity();
            }
        });


    }

    public void activate_MainActivity()
    {
        Intent main_intent = new Intent(this, MainActivity.class);
        startActivity(main_intent);

    }


}
