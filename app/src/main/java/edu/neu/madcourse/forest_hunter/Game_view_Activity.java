package edu.neu.madcourse.forest_hunter;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Game_view_Activity extends AppCompatActivity {

    private ImageView hair_view;
    private ImageView head_view;
    private ImageView eye_view;
    private ImageView nose_view;
    private ImageView mouth_view;
    private ImageView l_eyebrow_view;
    private ImageView r_eyebrow_view;
    private ImageView ear_view;
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
    private ImageView bottom_view_wear;

    public int moveX = 300;
    public int moveY = 350;  // range from -150 to 350

    double ratio = 0.4;

    int head_adjustment = -6;
    int chest_adjustment_y = 135;
    int chest_adjustment_x = -7;
    int ear_adjustment_y = -10;
    int ear_adjustment_x = 0;
    int l_arm_adjustment_y = 180;
    int l_arm_adjustment_x = -1;
    int r_arm_adjustment_y = 205;
    int r_arm_adjustment_x = -3;
    int l_shoulder_adjustment_y = 155;
    int l_shoulder_adjustment_x = -5;
    int r_shoulder_adjustment_y = 20;
    int r_shoulder_adjustment_x = -3;
    int r_hand_adjustment_y = 225;
    int r_hand_adjustment_x = 2;
    int l_hand_adjustment_y = 228;
    int l_hand_adjustment_x = 113;

    int r_thigh_adjustment_y = 130;
    int r_thigh_adjustment_x = -10;
    int l_thigh_adjustment_y = 130;
    int l_thigh_adjustment_x = -20;
    int r_leg_adjustment_y = 195;
    int r_leg_adjustment_x = -10;
    int l_leg_adjustment_y = 140;
    int l_leg_adjustment_x = -15;
    int r_foot_adjustment_y = 270;
    int r_foot_adjustment_x = -10;
    int l_foot_adjustment_y = 356;
    int l_foot_adjustment_x = -15;
    int bottom_adjustment_x = -4;
    int bottom_adjustment_y = 143;

    Appearance ap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_view);

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

        chest_view = findViewById(R.id.chest_view);
        chest_view.setBackground(null);
        chest_view.setImageResource(ap.chest_image_id_list[Appearance.current_chest_index]);

        r_arm_view = findViewById(R.id.r_arm_view);
        l_arm_view = findViewById(R.id.l_arm_view);
        r_shoulder_view = findViewById(R.id.r_shoulder_view);
        l_shoulder_view = findViewById(R.id.l_shoulder_view);

        chest_view_wear = findViewById(R.id.chest_view_wear);
        chest_view_wear.setBackground(null);
        chest_view_wear.setImageResource(ap.chest_wear_image_id_list[Appearance.current_chest_wear_index]);


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
        r_thigh_view.setBackground(null);
        r_thigh_view.setImageResource(ap.thigh_r_l_wear_image_id_list[Appearance.current_thigh_wear_index][0]);
        l_thigh_view.setBackground(null);
        l_thigh_view.setImageResource(ap.thigh_r_l_wear_image_id_list[Appearance.current_thigh_wear_index][1]);


        r_leg_view = findViewById(R.id.r_leg_view);
        l_leg_view = findViewById(R.id.l_leg_view);
        r_leg_view.setBackground(null);
        r_leg_view.setImageResource(ap.leg_r_l_wear_image_id_list[Appearance.current_leg_wear_index][0]);
        l_leg_view.setBackground(null);
        l_leg_view.setImageResource(ap.leg_r_l_wear_image_id_list[Appearance.current_leg_wear_index][1]);


        r_foot_view = findViewById(R.id.r_foot_view);
        l_foot_view = findViewById(R.id.l_foot_view);
        r_foot_view.setBackground(null);
        r_foot_view.setImageResource(ap.foot_r_l_wear_image_id_list[Appearance.current_foot_wear_index][0]);
        l_foot_view.setBackground(null);
        l_foot_view.setImageResource(ap.foot_r_l_wear_image_id_list[Appearance.current_foot_wear_index][1]);

        r_thigh_view_wear = findViewById(R.id.r_thigh_view_wear);
        l_thigh_view_wear = findViewById(R.id.l_thigh_view_wear);
        r_leg_view_wear = findViewById(R.id.r_leg_view_wear);
        l_leg_view_wear = findViewById(R.id.l_leg_view_wear);
        r_foot_view_wear = findViewById(R.id.r_foot_view_wear);
        l_foot_view_wear = findViewById(R.id.l_foot_view_wear);

        bottom_view_wear = findViewById(R.id.bottom_view_wear);
        bottom_view_wear.setBackground(null);
        bottom_view_wear.setImageResource(ap.bottom_wear_image_id_list[Appearance.current_bottom_wear_index]);

        move_character(moveX, moveY);

    }

    public void move_character(int moveX, int moveY)
    {
        ArrayList<ImageView> head_image_view_list = new ArrayList<>();

        head_image_view_list.add(hair_view);
        head_image_view_list.add(head_view);
        head_image_view_list.add(eye_view);
        head_image_view_list.add(nose_view);
        head_image_view_list.add(mouth_view);
        head_image_view_list.add(l_eyebrow_view);
        head_image_view_list.add(r_eyebrow_view);

        for (ImageView iv:head_image_view_list)
        {
            iv.getLayoutParams().width = (int) (iv.getLayoutParams().width * ratio);
            iv.getLayoutParams().height = (int) (iv.getLayoutParams().height * ratio);

            int x = (int) iv.getX();
            int y = (int) iv.getY();

            iv.setX(x + moveX - head_adjustment);
            iv.setY(y + moveY);

        }

        move_after_resize(ear_view, moveX, moveY, ratio, ear_adjustment_y, ear_adjustment_x);
        move_after_resize(chest_view,moveX, moveY, ratio, chest_adjustment_y, chest_adjustment_x);
        move_after_resize(r_arm_view, moveX, moveY, ratio, r_arm_adjustment_y, r_arm_adjustment_x);
        move_after_resize(l_arm_view, moveX, moveY, ratio, l_arm_adjustment_y, l_arm_adjustment_x);
        move_after_resize(r_shoulder_view, moveX, moveY, ratio, r_shoulder_adjustment_y, r_shoulder_adjustment_x);
        move_after_resize(l_shoulder_view, moveX, moveY, ratio, l_shoulder_adjustment_y, l_shoulder_adjustment_x);


        move_after_resize(chest_view_wear,moveX, moveY, ratio, chest_adjustment_y, chest_adjustment_x);
        move_after_resize(r_arm_view_wear, moveX, moveY, ratio, r_arm_adjustment_y, r_arm_adjustment_x);
        move_after_resize(l_arm_view_wear, moveX, moveY, ratio, l_arm_adjustment_y, l_arm_adjustment_x);
        move_after_resize(r_shoulder_view_wear, moveX, moveY, ratio, r_shoulder_adjustment_y, r_shoulder_adjustment_x -5);
        move_after_resize(l_shoulder_view_wear, moveX, moveY, ratio, l_shoulder_adjustment_y, l_shoulder_adjustment_x);

        move_after_resize(r_hand_view, moveX, moveY, ratio, r_hand_adjustment_y, r_hand_adjustment_x);
        move_after_resize(l_hand_view, moveX, moveY, ratio, l_hand_adjustment_y, l_hand_adjustment_x);

        move_after_resize(r_thigh_view, moveX, moveY, ratio, r_thigh_adjustment_y, r_thigh_adjustment_x);
        move_after_resize(l_thigh_view, moveX, moveY, ratio, l_thigh_adjustment_y, l_thigh_adjustment_x);
        move_after_resize(r_leg_view, moveX, moveY, ratio, r_leg_adjustment_y, r_leg_adjustment_x);
        move_after_resize(l_leg_view, moveX, moveY, ratio, l_leg_adjustment_y, l_leg_adjustment_x);
        move_after_resize(r_foot_view, moveX, moveY, ratio, r_foot_adjustment_y, r_foot_adjustment_x);
        move_after_resize(l_foot_view, moveX, moveY, ratio, l_foot_adjustment_y, l_foot_adjustment_x);

        move_after_resize(r_thigh_view_wear, moveX, moveY, ratio, r_thigh_adjustment_y, r_thigh_adjustment_x);
        move_after_resize(l_thigh_view_wear, moveX, moveY, ratio, l_thigh_adjustment_y, l_thigh_adjustment_x);
        move_after_resize(r_leg_view_wear, moveX, moveY, ratio, r_leg_adjustment_y, r_leg_adjustment_x);
        move_after_resize(l_leg_view_wear, moveX, moveY, ratio, l_leg_adjustment_y, l_leg_adjustment_x);
        move_after_resize(r_foot_view_wear, moveX, moveY, ratio, r_foot_adjustment_y, r_foot_adjustment_x);
        move_after_resize(l_foot_view_wear, moveX, moveY, ratio, l_foot_adjustment_y, l_foot_adjustment_x);
        move_after_resize(bottom_view_wear, moveX, moveY, ratio, bottom_adjustment_y, bottom_adjustment_x);


    }

    public void move_after_resize(ImageView view, int moveX, int moveY, double ratio, int adjustment_y, int adjustment_x)
    {
        view.getLayoutParams().width = (int) (view.getLayoutParams().width * ratio);
        view.getLayoutParams().height = (int) (view.getLayoutParams().height * ratio);

        int x = (int) view.getX();
        int y = (int) view.getY();

        view.setX(x + moveX - adjustment_x);
        view.setY(y + moveY - adjustment_y);
    }


}
