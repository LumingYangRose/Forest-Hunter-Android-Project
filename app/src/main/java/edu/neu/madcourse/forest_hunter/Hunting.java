package edu.neu.madcourse.forest_hunter;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.security.interfaces.DSAPrivateKey;
import java.util.ArrayList;

import authentication.login_Activity;

public class Hunting extends AppCompatActivity {

    private static ImageView hair_view;
    private static ImageView head_view;
    private static ImageView eye_view;
    private static ImageView nose_view;
    private static ImageView mouth_view;
    private static ImageView l_eyebrow_view;
    private static ImageView r_eyebrow_view;
    private static ImageView ear_view;
    private static ImageView chest_view;
    private static ImageView r_arm_view;
    private static ImageView l_arm_view;
    private static ImageView r_shoulder_view;
    private static ImageView l_shoulder_view;
    private static ImageView r_hand_view;
    private static ImageView l_hand_view;

    private static ImageView chest_view_wear;
    private static ImageView r_arm_view_wear;
    private static ImageView l_arm_view_wear;
    private static ImageView r_shoulder_view_wear;
    private static ImageView l_shoulder_view_wear;

    private static ImageView r_thigh_view;
    private static ImageView l_thigh_view;
    private static ImageView r_leg_view;
    private static ImageView l_leg_view;
    private static ImageView r_foot_view;
    private static ImageView l_foot_view;

    private static ImageView r_thigh_view_wear;
    private static ImageView l_thigh_view_wear;
    private static ImageView r_leg_view_wear;
    private static ImageView l_leg_view_wear;
    private static ImageView r_foot_view_wear;
    private static ImageView l_foot_view_wear;
    private static ImageView bottom_view_wear;

    private static ImageView l_leg_view_run;
    private static ImageView l_leg_view_wear_run;
    private static ImageView l_foot_view_run;
    private static ImageView l_foot_view_wear_run;
    private static ImageView l_thigh_view_wear_run;
    private static ImageView l_thigh_view_run;

    private static ImageView r_leg_view_run;
    private static ImageView r_leg_view_wear_run;
    private static ImageView r_foot_view_run;
    private static ImageView r_foot_view_wear_run;
    private static ImageView r_thigh_view_wear_run;
    private static ImageView r_thigh_view_run;




    private ImageView swipe_up;
    private ImageView swipe_down;
    private ImageView swipe_right;
    private ImageView tap_screen;
    private TextView tutorial_info;
    private static ArrayList<ImageView> all_image_view_list;
    private ArrayList<ImageView> gorilla_list;


    private static int count = 0;
    private int time;


    public int moveX = 500;
    public int moveY = 150;  // range from -150 to 350

    static double ratio = 0.4;

    double head_adjustment = -6;
    double chest_adjustment_y = 135;
    double chest_adjustment_x = -7;
    double ear_adjustment_y = -8;
    double ear_adjustment_x = -2;
    double l_arm_adjustment_y = 180;
    double l_arm_adjustment_x = -1;
    double r_arm_adjustment_y = 205;
    double r_arm_adjustment_x = -3;
    double l_shoulder_adjustment_y = 155;
    double l_shoulder_adjustment_x = -5;
    double r_shoulder_adjustment_y = 20;
    double r_shoulder_adjustment_x = -3;
    double r_hand_adjustment_y = 215;
    double r_hand_adjustment_x = 2;
    double l_hand_adjustment_y = 227;
    double l_hand_adjustment_x = 110;

    double r_thigh_adjustment_y = 130;
    double r_thigh_adjustment_x = -10;
    double l_thigh_adjustment_y = 130;
    double l_thigh_adjustment_x = -20;
    double r_leg_adjustment_y = 195;
    double r_leg_adjustment_x = -10;
    double l_leg_adjustment_y = 140;
    double l_leg_adjustment_x = -15;
    double r_foot_adjustment_y = 270;
    double r_foot_adjustment_x = -10;
    double l_foot_adjustment_y = 353;
    double l_foot_adjustment_x = -17;
    double bottom_adjustment_x = -7;
    double bottom_adjustment_y = 146;

    Appearance ap;

    boolean is_playing = true;
    boolean invincible;
    public boolean jumped;

    int score;
    int lives;
    int invincible_countdown;
    public int jump_countdown;
    int shoot_countdown;
    TextView score_view;

    int screen_width;
    int screen_height;

    public static float screenRatioX, screenRatioY;

    private ImageView forest_background_view;
    private ImageView second_forest_background_view;

    // bullet view
    private static ImageView bullet_view;

    OnSwipeTouchListener onSwipeTouchListener1;
    OnSwipeTouchListener onSwipeTouchListener2;

    android.os.Handler Handler;
    android.os.Handler Handler2;
    android.os.Handler Handler3;
    android.os.Handler Handler4;

    static double dpi_ratio;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hunting_view);

        time = 0;
        lives = 3;
        score = 0;
        invincible = false;
        jumped = false;
        jump_countdown = 0;
        invincible_countdown = 0;
        shoot_countdown = 0;
        score_view = findViewById(R.id.Score_title_view);

        swipe_up = findViewById(R.id.swipe_up);
        swipe_down = findViewById(R.id.swipe_down);
        swipe_right = findViewById(R.id.swipe_right);
        tap_screen = findViewById(R.id.tap_jump);
        swipe_up.setVisibility(View.INVISIBLE);
        swipe_down.setVisibility(View.INVISIBLE);
        swipe_right.setVisibility(View.INVISIBLE);
        tap_screen.setVisibility(View.INVISIBLE);
        tutorial_info = findViewById(R.id.tutorial);
        tutorial_info.setVisibility(View.INVISIBLE);
        swipe_up.setX(960);
        swipe_up.setY(240);
        swipe_down.setX(960);
        swipe_down.setY(640);
        tap_screen.setX(960);
        tap_screen.setY(440);
        swipe_right.setX(960);
        swipe_right.setY(440);
        tutorial_info.setX(1280);
        tutorial_info.setY(440);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screen_width = size.x;
        screen_height = size.y;

        float float_w = screen_width;
        float float_h = screen_height;

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int dpi = (int)(metrics.density * 160f);

        dpi_ratio = dpi/440.00;

        Toast.makeText(this, String.valueOf(dpi_ratio), Toast.LENGTH_SHORT).show();

        screenRatioX = float_w / screen_width;
        screenRatioY = float_h / screen_height;

        forest_background_view = findViewById(R.id.background);
        second_forest_background_view = findViewById(R.id.background2);

        forest_background_view.setX(0);
        forest_background_view.getLayoutParams().width = screen_width;
        second_forest_background_view.getLayoutParams().width = screen_width;
        second_forest_background_view.setX(screen_width);

        // bullet view
        bullet_view = findViewById(R.id.sword_view);
        bullet_view.setImageResource(R.drawable.sword);
        bullet_view.getLayoutParams().width = 80;
        bullet_view.getLayoutParams().height = 80;

        bullet_view.setX(500);
        bullet_view.setY(600);
        bullet_view.setVisibility(View.INVISIBLE);


        gorilla_list = new ArrayList<>();


        all_image_view_list = new ArrayList<>();


        setUpGorilla();




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

        // setup imageview for the run image
        l_leg_view_run =findViewById(R.id.l_leg_view_run);
        l_thigh_view_run =findViewById(R.id.l_thigh_view_run);
        l_leg_view_wear_run =findViewById(R.id.l_leg_view_wear_run);
        l_leg_view_wear_run.setBackground(null);
        l_leg_view_wear_run.setImageResource(ap.leg_r_l_wear_image_id_list[Appearance.current_leg_wear_index][1]);

        l_thigh_view_wear_run =findViewById(R.id.l_thigh_view_wear_run);
        l_thigh_view_wear_run.setBackground(null);
        l_thigh_view_wear_run.setImageResource(ap.thigh_r_l_wear_image_id_list[Appearance.current_thigh_wear_index][1]);

        l_foot_view_run =findViewById(R.id.l_foot_view_run);
        l_foot_view_wear_run =findViewById(R.id.l_foot_view_wear_run);
        l_foot_view_wear_run.setBackground(null);
        l_foot_view_wear_run.setImageResource(ap.foot_r_l_wear_image_id_list[Appearance.current_foot_wear_index][1]);

        l_leg_view_run.setVisibility(View.INVISIBLE);
        l_thigh_view_run.setVisibility(View.INVISIBLE);
        l_leg_view_wear_run.setVisibility(View.INVISIBLE);
        l_thigh_view_wear_run.setVisibility(View.INVISIBLE);
        l_foot_view_run.setVisibility(View.INVISIBLE);
        l_foot_view_wear_run.setVisibility(View.INVISIBLE);

        r_leg_view_run =findViewById(R.id.r_leg_view_run);
        r_thigh_view_run =findViewById(R.id.r_thigh_view_run);
        r_leg_view_wear_run =findViewById(R.id.r_leg_view_wear_run);
        r_leg_view_wear_run.setBackground(null);
        r_leg_view_wear_run.setImageResource(ap.leg_r_l_wear_image_id_list[Appearance.current_leg_wear_index][1]);

        r_thigh_view_wear_run =findViewById(R.id.r_thigh_view_wear_run);
        r_thigh_view_wear_run.setBackground(null);
        r_thigh_view_wear_run.setImageResource(ap.thigh_r_l_wear_image_id_list[Appearance.current_thigh_wear_index][1]);

        r_foot_view_run =findViewById(R.id.r_foot_view_run);
        r_foot_view_wear_run =findViewById(R.id.r_foot_view_wear_run);
        r_foot_view_wear_run.setBackground(null);
        r_foot_view_wear_run.setImageResource(ap.foot_r_l_wear_image_id_list[Appearance.current_foot_wear_index][0]);


        r_leg_view_run.setVisibility(View.INVISIBLE);
        r_thigh_view_run.setVisibility(View.INVISIBLE);
        r_leg_view_wear_run.setVisibility(View.INVISIBLE);
        r_thigh_view_wear_run.setVisibility(View.INVISIBLE);
        r_foot_view_run.setVisibility(View.INVISIBLE);
        r_foot_view_wear_run.setVisibility(View.INVISIBLE);

        //finish the setup of run imageview

        r_foot_view_wear = findViewById(R.id.r_foot_view_wear);
        l_foot_view_wear = findViewById(R.id.l_foot_view_wear);
        r_foot_view_wear.setBackground(null);
        r_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[Appearance.current_foot_wear_index][0]);
        l_foot_view_wear.setBackground(null);
        l_foot_view_wear.setImageResource(ap.foot_r_l_wear_image_id_list[Appearance.current_foot_wear_index][1]);

        bottom_view_wear = findViewById(R.id.bottom_view_wear);
        bottom_view_wear.setBackground(null);
        bottom_view_wear.setImageResource(ap.bottom_wear_image_id_list[Appearance.current_bottom_wear_index]);

        all_image_view_list.add(hair_view);
        all_image_view_list.add(head_view);
        all_image_view_list.add(eye_view);
        all_image_view_list.add(nose_view);
        all_image_view_list.add(mouth_view);
        all_image_view_list.add(ear_view);
        all_image_view_list.add(l_eyebrow_view);
        all_image_view_list.add(r_eyebrow_view);
        all_image_view_list.add(chest_view);
        all_image_view_list.add(r_arm_view);
        all_image_view_list.add(l_arm_view);
        all_image_view_list.add(r_shoulder_view);
        all_image_view_list.add(l_shoulder_view);
        all_image_view_list.add(r_hand_view);
        all_image_view_list.add(l_hand_view);

        all_image_view_list.add(r_thigh_view);
        all_image_view_list.add(l_thigh_view);
        all_image_view_list.add(r_leg_view);
        all_image_view_list.add(l_leg_view);
        all_image_view_list.add(r_foot_view);
        all_image_view_list.add(l_foot_view);

        all_image_view_list.add(chest_view_wear);
        all_image_view_list.add(r_arm_view_wear);
        all_image_view_list.add(l_arm_view_wear);
        all_image_view_list.add(r_shoulder_view_wear);
        all_image_view_list.add(l_shoulder_view_wear);

        all_image_view_list.add(r_thigh_view_wear);
        all_image_view_list.add(l_thigh_view_wear);
        all_image_view_list.add(r_leg_view_wear);
        all_image_view_list.add(l_leg_view_wear);
        all_image_view_list.add(r_foot_view_wear);
        all_image_view_list.add(l_foot_view_wear);
        all_image_view_list.add(bottom_view_wear);

        all_image_view_list.add(l_leg_view_run);
        all_image_view_list.add(l_leg_view_wear_run);
        all_image_view_list.add(l_foot_view_run);
        all_image_view_list.add(l_foot_view_wear_run);
        all_image_view_list.add(l_thigh_view_wear_run);
        all_image_view_list.add(l_thigh_view_run);
        all_image_view_list.add(r_leg_view_run);
        all_image_view_list.add(r_leg_view_wear_run);
        all_image_view_list.add(r_foot_view_run);
        all_image_view_list.add(r_foot_view_wear_run);
        all_image_view_list.add(r_thigh_view_wear_run);
        all_image_view_list.add(r_thigh_view_run);

        oncreate_resize_move_character(moveX, moveY);

        Handler = new android.os.Handler();
        Handler.postDelayed(refresh_view, 0);

        Handler2 = new android.os.Handler();
        Handler2.postDelayed(refresh_character_view, 0);

        Handler3 = new android.os.Handler();
        Handler3.postDelayed(game_play, 0);

        Handler4 = new android.os.Handler();
        Handler4.postDelayed(refresh_bullet_view, 0);

        // onSwipeTouchListener1 = new OnSwipeTouchListener(this, findViewById(R.id.background));
        findViewById(R.id.hunting_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jump_countdown<=0 && !jumped) {
                    jumped = true;
                    jump_countdown = 35;
                }
            }
        });
        findViewById(R.id.hunting_view).setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public boolean onSwipeTop() {
                if(hair_view.getY() > 348 && !jumped)
                {
                    move_character_y(200);
                }
                return true;
            }

            @Override
            public boolean onSwipeBottom() {
                if(hair_view.getY() < 648 && !jumped)
                {
                    move_character_y(-200);
                }
                return true;
            }

            @Override
            public boolean onSwipeRight() {
                bullet_view.setVisibility(View.VISIBLE);
                shoot_countdown = 35;
                return true;
            }
        });
    }

    private Runnable refresh_view = new Runnable()
    {
        public void run()
        {
            forest_background_view.setX(forest_background_view.getX() - 20 * screenRatioX);
            second_forest_background_view.setX(second_forest_background_view.getX() - 20 * screenRatioX);

            int width = second_forest_background_view.getWidth();

            if (forest_background_view.getX() + forest_background_view.getWidth() < 0) {
                forest_background_view.setX(second_forest_background_view.getX() + second_forest_background_view.getLayoutParams().width);
                //forest_background_view.setX(screen_width);
            }

            if (second_forest_background_view.getX() + second_forest_background_view.getWidth() < 0) {
                second_forest_background_view.setX(forest_background_view.getX() + forest_background_view.getLayoutParams().width);
                //second_forest_background_view.setX(screen_width);
            }

            Handler.postDelayed(this, 30); //repeat timer
        }
    };

    private Runnable refresh_bullet_view = new Runnable()
    {
        public void run()
        {
            bullet_view.setX(bullet_view.getX() + 20 * screenRatioX);

            if (bullet_view.getX() >= screen_width) {
                bullet_view.setX(moveX+50);
//                bullet_view.setY(moveY - 100);
//                bullet_view.setVisibility(View.INVISIBLE);
            }

            Handler.postDelayed(this, 15); //repeat timer
        }
    };

    private Runnable game_play = new Runnable()
    {
        public void run()
        {
            setUpTutorial(time);
            setUpStage1(time);


            for (ImageView iv: gorilla_list) {
                if ((Math.abs(iv.getX()-chest_view.getX()) <= 100)
                        && (Math.abs(iv.getY()-chest_view.getY()) <= 100)) {
                    if (iv.getVisibility() == View.VISIBLE) {
                        score -= 100;
                        score_view.setText("Score: " + score);
                        invincible = true;
                        invincible_countdown = 20;
                    }
                }

                if ((Math.abs(iv.getX()-bullet_view.getX()) <= 100)
                        && (Math.abs(iv.getY()-bullet_view.getY()) <= 100)) {
                    if (lives>0 && bullet_view.getVisibility() != View.INVISIBLE) {
                        iv.setVisibility(View.INVISIBLE);
                        score += 250;
                        score_view.setText("Score: " + score);
                    }
                }
            }

            characterJump(jump_countdown);
            getHit(invincible_countdown);
            if (invincible_countdown>0) {
                invincible_countdown--;
            } else {
                invincible = false;
            }
            if (jump_countdown>5) {
                jump_countdown--;
            } else if (jump_countdown<=5 && jump_countdown>0) {
                jumped = false;
                jump_countdown--;
            }
            if (shoot_countdown > 0) {
                shoot_countdown--;
            } else {
                bullet_view.setVisibility(View.INVISIBLE);
            }
            time ++;

            Handler.postDelayed(this, 30);

        }
    };

    private Runnable refresh_character_view = new Runnable()
    {
        public void run()
        {
            if (count == 0)
            {
                l_leg_view_run.setVisibility(View.VISIBLE);
                l_thigh_view_run.setVisibility(View.VISIBLE);
                l_leg_view_wear_run.setVisibility(View.VISIBLE);
                l_thigh_view_wear_run.setVisibility(View.VISIBLE);
                l_foot_view_run.setVisibility(View.VISIBLE);
                l_foot_view_wear_run.setVisibility(View.VISIBLE);

                r_leg_view_run.setVisibility(View.VISIBLE);
                r_thigh_view_run.setVisibility(View.VISIBLE);
                r_leg_view_wear_run.setVisibility(View.VISIBLE);
                r_thigh_view_wear_run.setVisibility(View.VISIBLE);
                r_foot_view_run.setVisibility(View.VISIBLE);
                r_foot_view_wear_run.setVisibility(View.VISIBLE);

                l_leg_view_wear.setVisibility(View.INVISIBLE);
                l_leg_view.setVisibility(View.INVISIBLE);
                l_thigh_view_wear.setVisibility(View.INVISIBLE);
                l_thigh_view.setVisibility(View.INVISIBLE);
                l_foot_view_wear.setVisibility(View.INVISIBLE);
                l_foot_view.setVisibility(View.INVISIBLE);

                r_leg_view_wear.setVisibility(View.INVISIBLE);
                r_leg_view.setVisibility(View.INVISIBLE);
                r_thigh_view_wear.setVisibility(View.INVISIBLE);
                r_thigh_view.setVisibility(View.INVISIBLE);
                r_foot_view_wear.setVisibility(View.INVISIBLE);
                r_foot_view.setVisibility(View.INVISIBLE);

                count += 1;
            }
            else if (count == 1 && !jumped)
            {
                l_leg_view_run.setVisibility(View.INVISIBLE);
                l_thigh_view_run.setVisibility(View.INVISIBLE);
                l_leg_view_wear_run.setVisibility(View.INVISIBLE);
                l_thigh_view_wear_run.setVisibility(View.INVISIBLE);
                l_foot_view_run.setVisibility(View.INVISIBLE);
                l_foot_view_wear_run.setVisibility(View.INVISIBLE);

                r_leg_view_run.setVisibility(View.INVISIBLE);
                r_thigh_view_run.setVisibility(View.INVISIBLE);
                r_leg_view_wear_run.setVisibility(View.INVISIBLE);
                r_thigh_view_wear_run.setVisibility(View.INVISIBLE);
                r_foot_view_run.setVisibility(View.INVISIBLE);
                r_foot_view_wear_run.setVisibility(View.INVISIBLE);

                l_leg_view_wear.setVisibility(View.VISIBLE);
                l_leg_view.setVisibility(View.VISIBLE);
                l_thigh_view_wear.setVisibility(View.VISIBLE);
                l_thigh_view.setVisibility(View.VISIBLE);
                l_foot_view_wear.setVisibility(View.VISIBLE);
                l_foot_view.setVisibility(View.VISIBLE);

                r_leg_view_wear.setVisibility(View.VISIBLE);
                r_leg_view.setVisibility(View.VISIBLE);
                r_thigh_view_wear.setVisibility(View.VISIBLE);
                r_thigh_view.setVisibility(View.VISIBLE);
                r_foot_view_wear.setVisibility(View.VISIBLE);
                r_foot_view.setVisibility(View.VISIBLE);

                count = 0;
            }


            Handler.postDelayed(this, 100); //repeat timmer
        }
    };



    public void oncreate_resize_move_character(int moveX, int moveY)
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

            iv.setX(x + moveX - (float)head_adjustment);
            iv.setY(y + moveY);

        }

        //eyebrow somehow mis-position
        // this is to correct the location
        l_eyebrow_view.setY(l_eyebrow_view.getY() - 6);
        r_eyebrow_view.setY(r_eyebrow_view.getY() - 2);

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

        move_after_resize(l_leg_view_run, moveX, moveY, ratio, l_leg_adjustment_y - 15.00, l_leg_adjustment_x +6.00);
        move_after_resize(l_leg_view_wear_run, moveX, moveY, ratio, l_leg_adjustment_y -15.00, l_leg_adjustment_x +6.00);
        move_after_resize(l_thigh_view_run, moveX, moveY, ratio, l_thigh_adjustment_y, l_thigh_adjustment_x);
        move_after_resize(l_thigh_view_wear_run, moveX, moveY, ratio, l_thigh_adjustment_y, l_thigh_adjustment_x);
        move_after_resize(l_foot_view_run, moveX, moveY, ratio, l_foot_adjustment_y -45.00 , l_foot_adjustment_x + 138.00);
        move_after_resize(l_foot_view_wear_run, moveX, moveY, ratio, l_foot_adjustment_y - 45.00, l_foot_adjustment_x + 138.00);//TODO


        move_after_resize(r_leg_view_run, moveX, moveY, ratio, r_leg_adjustment_y - 15.00, r_leg_adjustment_x + 20.00);
        move_after_resize(r_leg_view_wear_run, moveX, moveY, ratio, r_leg_adjustment_y -15.00, r_leg_adjustment_x + 20.00);
        move_after_resize(r_thigh_view_run, moveX, moveY, ratio, r_thigh_adjustment_y, r_thigh_adjustment_x);
        move_after_resize(r_thigh_view_wear_run, moveX, moveY, ratio, r_thigh_adjustment_y, r_thigh_adjustment_x);
        move_after_resize(r_foot_view_run, moveX, moveY, ratio, r_foot_adjustment_y - 24.00 , r_foot_adjustment_x +5.00);
        move_after_resize(r_foot_view_wear_run, moveX, moveY, ratio, r_foot_adjustment_y - 24.00, r_foot_adjustment_x +5.00);//TODO

    }

    public void move_after_resize(ImageView view, int moveX, int moveY, double ratio, double adjustment_y, double adjustment_x)
    {
        view.getLayoutParams().width = (int) (view.getLayoutParams().width * ratio);
        view.getLayoutParams().height = (int) (view.getLayoutParams().height * ratio);

        float x = view.getX();
        float y = view.getY();

        view.setX((float) (x + moveX - adjustment_x * dpi_ratio));
        view.setY((float) (y + moveY - adjustment_y * dpi_ratio));
    }

    public static void move_character_x(float new_X)
    {
        for (ImageView iv: all_image_view_list) {
            float origin_x = iv.getX();
            iv.setX(origin_x + new_X);
        }


        float bullet_x = bullet_view.getX();
        bullet_view.setX(bullet_x + new_X);
    }

    public static void move_character_y(float new_Y)
    {
        for (ImageView iv: all_image_view_list) {
            float origin_y = iv.getY();
            iv.setY(origin_y - new_Y);
        }

        float bullet_y = bullet_view.getY();
        bullet_view.setY(bullet_y - new_Y);
    }

    public static void characterJump(int jump_countdown) {
        if (jump_countdown>20) {
            move_character_y(8.00f);
        } else if (jump_countdown>5 && jump_countdown<=20) {
            move_character_y(-8.00f);
        }
    }

    public static void getHit(int invincible_countdown) {
        if (invincible_countdown>0 && invincible_countdown%2 == 0) {
            for (ImageView iv: all_image_view_list) {
                iv.setVisibility(View.INVISIBLE);
            }
        } else if (invincible_countdown>0 && invincible_countdown%2 == 1) {
            for (ImageView iv: all_image_view_list) {
                iv.setVisibility(View.VISIBLE);
            }
        }
    }

    public static class OnSwipeTouchListener implements View.OnTouchListener {
        private final GestureDetector gestureDetector = new GestureDetector(new GestureListener());

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }

        public class GestureListener extends GestureDetector.SimpleOnGestureListener {
            private static final int SWIPE_THRESHOLD = 60;
            private static final int SWIPE_VELOCITY_THRESHOLD = 60;

            @Override
            public boolean onFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
                boolean result = false;
                try {
                    float difference_Y = me2.getY() - me1.getY();
                    float difference_X = me2.getX() - me1.getX();
                    if (Math.abs(difference_X) > Math.abs(difference_Y)) {
                        if (Math.abs(difference_X) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                            if (difference_X > 0) {
                                System.out.println("here");
                                result = onSwipeRight();
                            } else {
                                result = onSwipeLeft();
                            }
                        }
                    }
                    else if (Math.abs(difference_Y) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (difference_Y > 0) {
                            result = onSwipeBottom();
                        } else {
                            result = onSwipeTop();
                        }
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                return result;
            }
        }

        public boolean onSwipeRight() {

            return false;
        }


        public boolean onSwipeLeft() {

            return false;
        }


        public boolean onSwipeTop() {

            return false;
        }


        public boolean onSwipeBottom() {

            return false;
        }
    }

    @Override
    public void onBackPressed() {
        Handler.removeCallbacksAndMessages(null);
        Handler2.removeCallbacksAndMessages(null);
        Handler3.removeCallbacksAndMessages(null);
        Handler4.removeCallbacksAndMessages(null);

        super.onBackPressed();
    }



    public void setUpGorilla() {
        ImageView gorilla1 = findViewById(R.id.gorilla_view1);
        ImageView gorilla2 = findViewById(R.id.gorilla_view2);
        ImageView gorilla3 = findViewById(R.id.gorilla_view3);
        ImageView gorilla4 = findViewById(R.id.gorilla_view4);
        ImageView gorilla5 = findViewById(R.id.gorilla_view5);
        ImageView gorilla6 = findViewById(R.id.gorilla_view6);
        ImageView gorilla7 = findViewById(R.id.gorilla_view7);
        ImageView gorilla8 = findViewById(R.id.gorilla_view8);
        ImageView gorilla9 = findViewById(R.id.gorilla_view9);

//        gorilla1.setY((int)(screen_height*0.74-300));

//        上：
        gorilla1.setY((int)(screen_height*0.74-400));
        gorilla2.setY((int)(screen_height*0.74-400));
//        中
        gorilla3.setY((int)(screen_height*0.74-200));
        gorilla4.setY((int)(screen_height*0.74-200));
//        下
        gorilla5.setY((int)(screen_height*0.74));
        gorilla6.setY((int)(screen_height*0.74));

        gorilla7.setY((int)(screen_height*0.74-200));
        gorilla8.setY((int)(screen_height*0.74-200));
        gorilla9.setY((int)(screen_height*0.74));
        

        gorilla_list.add(gorilla1);
        gorilla_list.add(gorilla2);
        gorilla_list.add(gorilla3);
        gorilla_list.add(gorilla4);
        gorilla_list.add(gorilla5);
        gorilla_list.add(gorilla6);
        gorilla_list.add(gorilla7);
        gorilla_list.add(gorilla8);
        gorilla_list.add(gorilla9);

        System.out.println(gorilla_list.size());

        for (ImageView iv: gorilla_list) {
            iv.setX(screen_width + 100*screenRatioX);
            iv.setImageResource(R.drawable.gorilla);
            iv.getLayoutParams().width = 200;
            iv.getLayoutParams().height = 200;
        }
    }



    public void setUpTutorial(int time) {
        if (time==5) {
            swipe_down.setVisibility(View.VISIBLE);
            swipe_up.setVisibility(View.VISIBLE);
            tutorial_info.setVisibility(View.VISIBLE);
        }
        if (time==40) {
            swipe_down.setVisibility(View.INVISIBLE);
            swipe_up.setVisibility(View.INVISIBLE);
            tap_screen.setVisibility(View.VISIBLE);
            tutorial_info.setText("Tap screen to Jump");
        }
        if (time == 80) {
            tap_screen.setVisibility(View.INVISIBLE);
            swipe_right.setVisibility(View.VISIBLE);
            tutorial_info.setText("Swipe right to hunt");
        }
        if (time==120) {
            swipe_right.setVisibility(View.INVISIBLE);
            tutorial_info.setVisibility(View.INVISIBLE);
        }
    }
    int speed_index = 22;
    public void setUpStage1(int time) {
        if (time >= 220 && time < 360 ) {
            gorilla_list.get(0).setX(gorilla_list.get(0).getX() - speed_index * screenRatioX);
        }
        if (time >= 260 && time < 400) {
            gorilla_list.get(2).setX(gorilla_list.get(2).getX() - speed_index * screenRatioX);
        }
        if (time >= 260 && time < 400) {
            gorilla_list.get(4).setX(gorilla_list.get(4).getX() - speed_index * screenRatioX);
        }
        if (time >= 300 && time < 440) {
            gorilla_list.get(5).setX(gorilla_list.get(5).getX() - speed_index * screenRatioX);
        }
        if (time >= 340 && time < 480) {
            gorilla_list.get(0).setX(gorilla_list.get(0).getX() - speed_index * screenRatioX);
        }
        if (time >= 420 && time < 560 ) {
            gorilla_list.get(0).setX(gorilla_list.get(0).getX() - speed_index * screenRatioX);
        }
        if (time >= 420 && time < 560) {
            gorilla_list.get(2).setX(gorilla_list.get(2).getX() - speed_index * screenRatioX);
        }
        if (time >= 420  && time < 560) {
            if (time == 420) {
                gorilla_list.get(4).setX(screen_width + 100*screenRatioX);
                gorilla_list.get(4).setVisibility(View.VISIBLE);
            }
            gorilla_list.get(4).setX(gorilla_list.get(4).getX() - speed_index * screenRatioX);
        }

        if (time >= 500 && time < 640) {
            gorilla_list.get(3).setX(gorilla_list.get(3).getX() - speed_index * screenRatioX);
        }

        if (time >= 620 && time < 760) {
            if (time == 620) {
                gorilla_list.get(2).setX(screen_width + 100*screenRatioX);
                gorilla_list.get(2).setVisibility(View.VISIBLE);
            }
            gorilla_list.get(2).setX(gorilla_list.get(2).getX() - speed_index * screenRatioX);
        }
//        if (time >= 660 && time < 800 && !paused) {
//            if (time == 660) {
//                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(2).setX(boulder_list.get(2).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 660 && time < 800 && !paused) {
//            if (time == 660) {
//                gorilla_list.get(0).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(0).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(0).setX(gorilla_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 700 && time < 840 && !paused) {
//            cliff_list.get(3).setX(cliff_list.get(3).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 740 && time < 880 && !paused) {
//            cliff_list.get(4).setX(cliff_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 780 && time < 920 && !paused) {
//            if (time == 780) {
//                gorilla_list.get(1).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(1).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(1).setX(gorilla_list.get(1).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 780 && time < 920 && !paused) {
//            if (time == 780) {
//                gorilla_list.get(3).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(3).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(3).setX(gorilla_list.get(3).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 780 && time < 920 && !paused) {
//            if (time == 780) {
//                gorilla_list.get(4).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(4).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(4).setX(gorilla_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 820 && time < 960 && !paused) {
//            if (time == 820) {
//                boulder_list.get(0).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(0).setX(boulder_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 820 && time < 960 && !paused) {
//            if (time == 820) {
//                boulder_list.get(5).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(5).setX(boulder_list.get(5).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 840 && time < 980 && !paused) {
//            if (time == 840) {
//                gorilla_list.get(0).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(0).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(0).setX(gorilla_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 840 && time < 980 && !paused) {
//            if (time == 840) {
//                gorilla_list.get(5).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(5).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(5).setX(gorilla_list.get(5).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 860 && time < 1000 && !paused) {
//            if (time == 860) {
//                boulder_list.get(1).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(1).setX(boulder_list.get(1).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 860 && time < 1000 && !paused) {
//            if (time == 860) {
//                boulder_list.get(4).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(4).setX(boulder_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 900 && time < 1040 && !paused) {
//            if (time == 900) {
//                cliff_list.get(0).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(0).setX(cliff_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 920 && time < 1060 && !paused) {
//            if (time == 920) {
//                gorilla_list.get(1).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(1).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(1).setX(gorilla_list.get(1).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 920 && time < 1060 && !paused) {
//            if (time == 920) {
//                boulder_list.get(7).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(7).setX(boulder_list.get(7).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 920 && time < 1060 && !paused) {
//            if (time == 920) {
//                boulder_list.get(8).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(8).setX(boulder_list.get(8).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 960 && time < 1100 && !paused) {
//            if (time == 960) {
//                boulder_list.get(6).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(6).setX(boulder_list.get(6).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 960 && time < 1100 && !paused) {
//            if (time == 960) {
//                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(2).setX(boulder_list.get(2).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 980 && time < 1120 && !paused) {
//            if (time == 980) {
//                gorilla_list.get(2).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(2).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(2).setX(gorilla_list.get(2).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1000 && time < 1140 && !paused) {
//            if (time == 1000) {
//                gorilla_list.get(0).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(0).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(0).setX(gorilla_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1040 && time < 1180 && !paused) {
//            if (time == 1040) {
//                cliff_list.get(1).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(1).setX(cliff_list.get(1).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1080 && time < 1220 && !paused) {
//            if (time == 1080) {
//                boulder_list.get(0).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(0).setX(boulder_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1080 && time < 1220 && !paused) {
//            if (time == 1080) {
//                gorilla_list.get(4).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(4).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(4).setX(gorilla_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1100 && time < 1240 && !paused) {
//            if (time == 1100) {
//                boulder_list.get(5).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(5).setX(boulder_list.get(5).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1120 && time < 1260 && !paused) {
//            if (time == 1120) {
//                boulder_list.get(3).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(3).setX(boulder_list.get(3).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1120 && time < 1260 && !paused) {
//            if (time == 1120) {
//                gorilla_list.get(6).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(6).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(6).setX(gorilla_list.get(6).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1160 && time < 1300 && !paused) {
//            if (time == 1160) {
//                cliff_list.get(2).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(2).setX(cliff_list.get(2).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1200 && time < 1340 && !paused) {
//            if (time == 1200) {
//                boulder_list.get(7).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(7).setX(boulder_list.get(7).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1220 && time < 1360 && !paused) {
//            if (time == 1220) {
//                cliff_list.get(3).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(3).setX(cliff_list.get(3).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1240 && time < 1380 && !paused) {
//            if (time == 1240) {
//                boulder_list.get(8).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(8).setX(boulder_list.get(8).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1240 && time < 1380 && !paused) {
//            if (time == 1240) {
//                gorilla_list.get(1).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(1).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(1).setX(gorilla_list.get(6).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1260 && time < 1400 && !paused) {
//            if (time == 1260) {
//                cliff_list.get(4).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(4).setX(cliff_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1280 && time < 1420 && !paused) {
//            if (time == 1280) {
//                boulder_list.get(6).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(6).setX(boulder_list.get(6).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1300 && time < 1440 && !paused) {
//            if (time == 1300) {
//                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(2).setX(boulder_list.get(2).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1300 && time < 1440 && !paused) {
//            if (time == 1300) {
//                gorilla_list.get(5).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(5).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(5).setX(gorilla_list.get(5).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1320 && time < 1460 && !paused) {
//            if (time == 1320) {
//                cliff_list.get(0).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(0).setX(cliff_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1340 && time < 1480 && !paused) {
//            if (time == 1340) {
//                gorilla_list.get(3).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(3).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(3).setX(gorilla_list.get(3).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1360 && time < 1500 && !paused) {
//            if (time == 1360) {
//                gorilla_list.get(0).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(0).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(0).setX(gorilla_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1360 && time < 1500 && !paused) {
//            if (time == 1360) {
//                boulder_list.get(3).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(3).setX(boulder_list.get(3).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1380 && time < 1520 && !paused) {
//            if (time == 1380) {
//                boulder_list.get(0).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(0).setX(boulder_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1380 && time < 1520 && !paused) {
//            if (time == 1380) {
//                gorilla_list.get(8).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(8).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(8).setX(gorilla_list.get(8).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1400 && time < 1540 && !paused) {
//            if (time == 1400) {
//                cliff_list.get(1).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(1).setX(cliff_list.get(1).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1440 && time < 1580 && !paused) {
//            if (time == 1440) {
//                boulder_list.get(7).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(7).setX(boulder_list.get(7).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1460 && time < 1600 && !paused) {
//            if (time == 1460) {
//                boulder_list.get(1).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(1).setX(boulder_list.get(1).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1460 && time < 1600 && !paused) {
//            if (time == 1460) {
//                boulder_list.get(4).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(4).setX(boulder_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1480 && time < 1620 && !paused) {
//            if (time == 1480) {
//                gorilla_list.get(6).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(6).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(6).setX(gorilla_list.get(6).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1480 && time < 1620 && !paused) {
//            if (time == 1480) {
//                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(2).setX(boulder_list.get(2).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1500 && time < 1640 && !paused) {
//            if (time == 1500) {
//                boulder_list.get(6).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(6).setX(boulder_list.get(6).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1500 && time < 1640 && !paused) {
//            if (time == 1500) {
//                boulder_list.get(5).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(5).setX(boulder_list.get(5).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1520 && time < 1660 && !paused) {
//            if (time == 1520) {
//                boulder_list.get(3).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(3).setX(boulder_list.get(3).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1520 && time < 1660 && !paused) {
//            if (time == 1520) {
//                gorilla_list.get(4).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(4).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(4).setX(gorilla_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1540 && time < 1680 && !paused) {
//            if (time == 1540) {
//                cliff_list.get(2).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(2).setX(cliff_list.get(2).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1580 && time < 1720 && !paused) {
//            if (time == 1580) {
//                gorilla_list.get(1).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(1).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(1).setX(gorilla_list.get(1).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1600 && time < 1740 && !paused) {
//            if (time == 1600) {
//                gorilla_list.get(7).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(7).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(7).setX(gorilla_list.get(7).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1620 && time < 1760 && !paused) {
//            if (time == 1620) {
//                gorilla_list.get(5).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(5).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(5).setX(gorilla_list.get(5).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1660 && time < 1800 && !paused) {
//            if (time == 1660) {
//                cliff_list.get(3).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(3).setX(cliff_list.get(3).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1680 && time < 1820 && !paused) {
//            if (time == 1680) {
//                boulder_list.get(1).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(1).setX(boulder_list.get(1).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1700 && time < 1840 && !paused) {
//            if (time == 1700) {
//                boulder_list.get(7).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(7).setX(boulder_list.get(7).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1720 && time < 1860 && !paused) {
//            if (time == 1720) {
//                boulder_list.get(8).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(8).setX(boulder_list.get(8).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1740 && time < 1880 && !paused) {
//            if (time == 1740) {
//                cliff_list.get(4).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(4).setX(cliff_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1760 && time < 1900 && !paused) {
//            if (time == 1760) {
//                gorilla_list.get(0).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(0).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(0).setX(gorilla_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1780 && time < 1920 && !paused) {
//            if (time == 1780) {
//                boulder_list.get(0).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(0).setX(boulder_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1800 && time < 1940 && !paused) {
//            if (time == 1800) {
//                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(2).setX(boulder_list.get(2).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1820 && time < 1960 && !paused) {
//            if (time == 1820) {
//                boulder_list.get(4).setX(screen_width + 100*screenRatioX);
//            }
//            boulder_list.get(4).setX(boulder_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1840 && time < 1980 && !paused) {
//            if (time == 1840) {
//                cliff_list.get(0).setX(screen_width + 100*screenRatioX);
//            }
//            cliff_list.get(0).setX(cliff_list.get(0).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1880) {
//            if (time == 1880) {
//                gorilla_list.get(6).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(6).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(6).setX(gorilla_list.get(6).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1880) {
//            if (time == 1880) {
//                gorilla_list.get(2).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(2).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(2).setX(gorilla_list.get(2).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1880) {
//            if (time == 1880) {
//                gorilla_list.get(8).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(8).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(8).setX(gorilla_list.get(8).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1920) {
//            if (time == 1920) {
//                gorilla_list.get(1).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(1).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(1).setX(gorilla_list.get(1).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1920) {
//            if (time == 1920) {
//                gorilla_list.get(3).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(3).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(3).setX(gorilla_list.get(3).getX() - speed_index * screenRatioX);
//        }
//        if (time >= 1920) {
//            if (time == 1920) {
//                gorilla_list.get(4).setX(screen_width + 100*screenRatioX);
//                gorilla_list.get(4).setVisibility(View.VISIBLE);
//            }
//            gorilla_list.get(4).setX(gorilla_list.get(4).getX() - speed_index * screenRatioX);
//        }
//        if (time == SET_ONE_LENGTH + 200 && !paused
//        ) {
//            paused = true;
//        }
//    }

}
}
