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

public class Game_view_Activity extends AppCompatActivity {

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

    private static ImageView crocodile;

    private ImageView hearts_view1;
    private ImageView hearts_view2;
    private ImageView hearts_view3;
    private ImageView swipe_up;
    private ImageView swipe_down;
    private ImageView tap_screen;
    private TextView tutorial_info;
    private static ArrayList<ImageView> all_image_view_list;
    private ArrayList<ImageView> boulder_list;
    private ArrayList<ImageView> gorilla_list;
    private ArrayList<ImageView> cliff_list;
    private ArrayList<ImageView> food_list;

    private static int count = 0;
    private int time;
    private ArrayList<ImageView> hearts;

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
        setContentView(R.layout.game_view);

        time = 0;
        lives = 3;
        score = 0;
        invincible = false;
        jumped = false;
        jump_countdown = 0;
        invincible_countdown = 0;
        score_view = findViewById(R.id.Score_title_view);

        swipe_up = findViewById(R.id.swipe_up);
        swipe_down = findViewById(R.id.swipe_down);
        tap_screen = findViewById(R.id.tap_jump);
        swipe_up.setVisibility(View.INVISIBLE);
        swipe_down.setVisibility(View.INVISIBLE);
        tap_screen.setVisibility(View.INVISIBLE);
        tutorial_info = findViewById(R.id.tutorial);
        tutorial_info.setVisibility(View.INVISIBLE);
        swipe_up.setX(960);
        swipe_up.setY(240);
        swipe_down.setX(960);
        swipe_down.setY(640);
        tap_screen.setX(960);
        tap_screen.setY(440);
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

        boulder_list = new ArrayList<>();
        gorilla_list = new ArrayList<>();
        cliff_list = new ArrayList<>();
        food_list = new ArrayList<>();

        all_image_view_list = new ArrayList<>();

        hearts_view1 = findViewById(R.id.heart_view1);
        hearts_view2 = findViewById(R.id.heart_view2);
        hearts_view3 = findViewById(R.id.heart_view3);
        hearts = new ArrayList<>();
        hearts.add(hearts_view1);
        hearts.add(hearts_view2);
        hearts.add(hearts_view3);

        setUpMovingObjects();
        setUpGorilla();
        setUpCliffs();
        setUpFood();

        crocodile = findViewById(R.id.crocodile);
        crocodile.setX(100);
        crocodile.setY(450);
        crocodile.setImageResource(R.drawable.walking_crocodile);
        AnimationDrawable walking_crocodile = (AnimationDrawable) crocodile.getDrawable();
        walking_crocodile.start();

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
        findViewById(R.id.game_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jump_countdown<=0 && !jumped) {
                    jumped = true;
                    jump_countdown = 35;
                }
            }
        });
        findViewById(R.id.game_view).setOnTouchListener(new OnSwipeTouchListener() {
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

            for (ImageView iv: boulder_list) {
                if ((Math.abs(iv.getX()-chest_view.getX()) <= 100)
                        && (Math.abs(iv.getY()-chest_view.getY()) <= 100)) {
                    if (lives>0 && !invincible) {
                        hearts.get(lives - 1).setVisibility(View.INVISIBLE);
                        lives--;
                        invincible = true;
                        invincible_countdown = 20;
                    }
                }
            }
            for (ImageView iv: gorilla_list) {
                if ((Math.abs(iv.getX()-chest_view.getX()) <= 100)
                        && (Math.abs(iv.getY()-chest_view.getY()) <= 100)) {
                    if (lives>0 && !invincible) {
                        hearts.get(lives - 1).setVisibility(View.INVISIBLE);
                        lives--;
                        invincible = true;
                        invincible_countdown = 20;
                    }
                }

                if ((Math.abs(iv.getX()-bullet_view.getX()) <= 100)
                        && (Math.abs(iv.getY()-bullet_view.getY()) <= 100)) {
                    if (lives>0) {
                        iv.setVisibility(View.INVISIBLE);
                        score += 250;
                        score_view.setText("Score: " + score);
                    }
                }

            }
            for (ImageView cliff: cliff_list) {
                if (Math.abs(cliff.getX()-chest_view.getX()) <= 100) {
                    if (lives>0 && !invincible && !jumped) {
                        hearts.get(lives-1).setVisibility(View.INVISIBLE);
                        lives--;
                        invincible = true;
                        invincible_countdown = 20;
                    }
                }
            }
            for (ImageView food: food_list) {
                if (food.getVisibility()==View.VISIBLE && Math.abs(food.getX()-chest_view.getX())<=100
                        && Math.abs(food.getY()-chest_view.getY())<=100) {
                    score += 100;
                    score_view.setText("Score: " + score);
                    food.setVisibility(View.INVISIBLE);
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
        float croc_x = crocodile.getX();
        crocodile.setX(croc_x + new_X);

        float bullet_x = bullet_view.getX();
        bullet_view.setX(bullet_x + new_X);
    }

    public static void move_character_y(float new_Y)
    {
        for (ImageView iv: all_image_view_list) {
            float origin_y = iv.getY();
            iv.setY(origin_y - new_Y);
        }
        float croc_y = crocodile.getY();
        crocodile.setY(croc_y - new_Y);

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

    public void setUpMovingObjects() {
        ImageView boulder1 = findViewById(R.id.boulder_view);
        ImageView boulder2 = findViewById(R.id.boulder_view2);
        ImageView boulder3 = findViewById(R.id.boulder_view3);
        ImageView boulder4 = findViewById(R.id.boulder_view4);
        ImageView boulder5 = findViewById(R.id.boulder_view5);
        ImageView boulder6 = findViewById(R.id.boulder_view6);
        boulder1.setY((int)(screen_height*0.74-400));
        boulder2.setY((int)(screen_height*0.74-400));
        boulder3.setY((int)(screen_height*0.74-200));
        boulder4.setY((int)(screen_height*0.74-200));
        boulder5.setY((int)(screen_height*0.74));
        boulder6.setY((int)(screen_height*0.74));
        boulder_list.add(boulder1);
//        boulder_list.add(boulder2);
//        boulder_list.add(boulder3);
//        boulder_list.add(boulder4);
//        boulder_list.add(boulder5);
//        boulder_list.add(boulder6);
        for (ImageView iv: boulder_list) {
            iv.setX(screen_width + 100*screenRatioX);
            iv.setImageResource(R.drawable.body_crouched);
            iv.getLayoutParams().width = 200;
            iv.getLayoutParams().height = 200;
        }
    }

    public void setUpGorilla() {
        ImageView gorilla1 = findViewById(R.id.gorilla_view);
        ImageView gorilla2 = findViewById(R.id.gorilla_view2);
        ImageView gorilla3 = findViewById(R.id.gorilla_view3);
        ImageView gorilla4 = findViewById(R.id.gorilla_view4);
        ImageView gorilla5 = findViewById(R.id.gorilla_view5);
        ImageView gorilla6 = findViewById(R.id.gorilla_view6);

        gorilla1.setY((int)(screen_height*0.74-200));
        gorilla2.setY((int)(screen_height*0.74-200));
        gorilla3.setY((int)(screen_height*0.74-200));
        gorilla4.setY((int)(screen_height*0.74-200));
        gorilla5.setY((int)(screen_height*0.74));
        gorilla6.setY((int)(screen_height*0.74));

        gorilla_list.add(gorilla1);
        gorilla_list.add(gorilla2);
        gorilla_list.add(gorilla3);
        gorilla_list.add(gorilla4);
        gorilla_list.add(gorilla5);
        gorilla_list.add(gorilla6);


        for (ImageView iv: gorilla_list) {
            iv.setX(screen_width + 100*screenRatioX);
            iv.setImageResource(R.drawable.__gorilla_brown_walk_standing_011);
            iv.getLayoutParams().width = 200;
            iv.getLayoutParams().height = 200;
        }
    }

    public void setUpCliffs() {
        ImageView cliff1 = findViewById(R.id.cliff_view);
        ImageView cliff2 = findViewById(R.id.cliff_view2);
        ImageView cliff3 = findViewById(R.id.cliff_view3);
        ImageView cliff4 = findViewById(R.id.cliff_view4);
        ImageView cliff5 = findViewById(R.id.cliff_view5);
        cliff_list.add(cliff1);
        cliff_list.add(cliff2);
        cliff_list.add(cliff3);
        cliff_list.add(cliff4);
        cliff_list.add(cliff5);
        for (ImageView iv: cliff_list) {
            iv.setX(screen_width + 100*screenRatioX);
            iv.setY(300);
            iv.setImageResource(R.drawable.water_river);
            iv.getLayoutParams().width = 200;
            iv.getLayoutParams().height = 800;
        }
    }

    public void setUpFood() {
        ImageView food1 = findViewById(R.id.food_view1);
        ImageView food2 = findViewById(R.id.food_view2);
        ImageView food3 = findViewById(R.id.food_view3);
        ImageView food4 = findViewById(R.id.food_view4);
        ImageView food5 = findViewById(R.id.food_view5);
        food1.setY((int)(screen_height*0.74-400));
        food2.setY((int)(screen_height*0.74-400));
        food3.setY((int)(screen_height*0.74-200));
        food4.setY((int)(screen_height*0.74-200));
        food5.setY((int)(screen_height*0.74));
        food_list.add(food1);
        food_list.add(food2);
        food_list.add(food3);
        food_list.add(food4);
        food_list.add(food5);
        for (ImageView food: food_list) {
            food.setX(screen_width + 100*screenRatioX);
            food.setImageResource(R.drawable.r_weapon_banana);
            food.getLayoutParams().width = 200;
            food.getLayoutParams().height = 200;
        }
    }

    public void setUpTutorial(int time) {
        if (time==5) {
            swipe_down.setVisibility(View.VISIBLE);
            swipe_up.setVisibility(View.VISIBLE);
            tutorial_info.setVisibility(View.VISIBLE);
        }
        if (time==80) {
            swipe_down.setVisibility(View.INVISIBLE);
            swipe_up.setVisibility(View.INVISIBLE);
            tap_screen.setVisibility(View.VISIBLE);
            tutorial_info.setText("Tap screen to Jump");
        }
        if (time==160) {
            tap_screen.setVisibility(View.INVISIBLE);
            tutorial_info.setVisibility(View.INVISIBLE);
        }
    }

    public void setUpStage1(int time) {
        if (time >= 200) {
            gorilla_list.get(0).setX(gorilla_list.get(0).getX() - 20 * screenRatioX);
        }

//        if (time >= 220) {
//            gorilla_list.get(1).setX(gorilla_list.get(1).getX() - 20 * screenRatioX);
//        }

        if (time >= 200) {
            boulder_list.get(0).setX(boulder_list.get(0).getX() - 20 * screenRatioX);
        }

//        if (time >= 220) {
//            boulder_list.get(2).setX(boulder_list.get(2).getX() - 20 * screenRatioX);
//        }

        if (time >= 220 && time < 340) {
            food_list.get(4).setX(food_list.get(4).getX() - 20 * screenRatioX);
        }
//        if (time >= 220 && time < 340) {
//            gorilla_list.get(2).setX(gorilla_list.get(2).getX() - 20 * screenRatioX);
//        }
//        if (time >= 260) {
//            boulder_list.get(5).setX(boulder_list.get(5).getX() - 20 * screenRatioX);
//        }
        if (time >= 300) {
            cliff_list.get(0).setX(cliff_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 380) {
            food_list.get(0).setX(food_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 380) {
            food_list.get(2).setX(food_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 380) {
            if (time == 380) {
                food_list.get(4).setX(screen_width + 100*screenRatioX);
                food_list.get(4).setVisibility(View.VISIBLE);
            }
            food_list.get(4).setX(food_list.get(4).getX() - 20 * screenRatioX);
        }
    }

}
