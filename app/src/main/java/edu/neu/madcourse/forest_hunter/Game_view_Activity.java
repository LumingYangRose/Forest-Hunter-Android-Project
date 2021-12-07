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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.security.interfaces.DSAPrivateKey;
import java.util.ArrayList;

import authentication.login_Activity;

public class Game_view_Activity extends AppCompatActivity {

    private static final int SET_ONE_LENGTH = 2000;

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
    private TextView hunting_info;
    private static ArrayList<ImageView> all_image_view_list;
    private ArrayList<ImageView> boulder_list;
    private ArrayList<ImageView> cliff_list;
    private ArrayList<ImageView> food_list;

    private static int count = 0;
    private int time;
    private ArrayList<ImageView> hearts;
    private ProgressBar progress_bar;

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
    public static boolean paused;
    private static boolean jumped;

    int score;
    int lives;
    int invincible_countdown;
    public int jump_countdown;
    TextView score_view;
    Button pause_button;

    int screen_width;
    int screen_height;

    public static float screenRatioX, screenRatioY;

    private ImageView forest_background_view;
    private ImageView second_forest_background_view;

    OnSwipeTouchListener onSwipeTouchListener1;
    OnSwipeTouchListener onSwipeTouchListener2;

    android.os.Handler Handler;
    android.os.Handler Handler2;
    android.os.Handler Handler3;

    static double dpi_ratio;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_view);

        time = 0;
        lives = 3;
        score = 0;
        paused = false;
        invincible = false;
        jumped = false;
        jump_countdown = 0;
        invincible_countdown = 0;
        pause_button = findViewById(R.id.game_menu_button);
        score_view = findViewById(R.id.Score_title_view);
        progress_bar = findViewById(R.id.game_progress);
        progress_bar.setProgress(0);

        swipe_up = findViewById(R.id.swipe_up);
        swipe_down = findViewById(R.id.swipe_down);
        tap_screen = findViewById(R.id.tap_jump);
        swipe_up.setVisibility(View.INVISIBLE);
        swipe_down.setVisibility(View.INVISIBLE);
        tap_screen.setVisibility(View.INVISIBLE);
        tutorial_info = findViewById(R.id.tutorial);
        tutorial_info.setVisibility(View.INVISIBLE);
        hunting_info = findViewById(R.id.hunting_info);
        hunting_info.setVisibility(View.INVISIBLE);
        swipe_up.setX(960);
        swipe_up.setY(240);
        swipe_down.setX(960);
        swipe_down.setY(640);
        tap_screen.setX(960);
        tap_screen.setY(440);
        tutorial_info.setX(1280);
        tutorial_info.setY(440);
        hunting_info.setX(720);
        hunting_info.setY(280);

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

        boulder_list = new ArrayList<>();
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
        setUpCliffs();
        setUpFood();

        crocodile = findViewById(R.id.crocodile);
        crocodile.setX((int)(moveX - 400*dpi_ratio));
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

        pause_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paused = true;
            }
        });

        // onSwipeTouchListener1 = new OnSwipeTouchListener(this, findViewById(R.id.background));
        findViewById(R.id.game_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jump_countdown<=0 && !jumped) {
                    jumped = true;
                    jump_countdown = 27;
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
            if (!paused) {
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
            }

            Handler.postDelayed(this, 30); //repeat timmer
        }
    };

    private Runnable game_play = new Runnable()
    {
        public void run()
        {
            setUpTutorial(time);
            setUpStage1(time);
            setUpProgressBar(time);

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
                        && Math.abs(food.getY()-chest_view.getY())<=100 && !jumped) {
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
            if (jump_countdown>3) {
                jump_countdown--;
            } else if (jump_countdown<=3 && jump_countdown>0) {
                jumped = false;
                jump_countdown--;
            }

            if (!paused) {
                time++;
                if (time%4 == 0) {
                    score += 1;
                    score_view.setText("Score: " + score);
                }
            }

            showHuntingInfo(time);

            if (time >= SET_ONE_LENGTH && time < SET_ONE_LENGTH+32 && !paused) {
                playerEscape();
            }
            if (time == SET_ONE_LENGTH+20) {
                crocodile.setVisibility(View.INVISIBLE);
            }

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
    }

    public static void move_character_y(float new_Y)
    {
        for (ImageView iv: all_image_view_list) {
            float origin_y = iv.getY();
            iv.setY(origin_y - new_Y);
        }
        float croc_y = crocodile.getY();
        crocodile.setY(croc_y - new_Y);
    }

    public static void characterJump(int jump_countdown) {
        if (jump_countdown>15) {
            move_character_y(10.00f);
        } else if (jump_countdown>3 && jump_countdown<=15) {
            move_character_y(-10.00f);
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

        super.onBackPressed();
    }

    public void setUpMovingObjects() {
        ImageView boulder1 = findViewById(R.id.boulder_view);
        ImageView boulder2 = findViewById(R.id.boulder_view2);
        ImageView boulder3 = findViewById(R.id.boulder_view3);
        ImageView boulder4 = findViewById(R.id.boulder_view4);
        ImageView boulder5 = findViewById(R.id.boulder_view5);
        ImageView boulder6 = findViewById(R.id.boulder_view6);
        ImageView boulder7 = findViewById(R.id.boulder_view7);
        ImageView boulder8 = findViewById(R.id.boulder_view8);
        ImageView boulder9 = findViewById(R.id.boulder_view9);
        boulder1.setY((int)(screen_height*0.74-400));
        boulder2.setY((int)(screen_height*0.74-400));
        boulder3.setY((int)(screen_height*0.74-200));
        boulder4.setY((int)(screen_height*0.74-200));
        boulder5.setY((int)(screen_height*0.74));
        boulder6.setY((int)(screen_height*0.74));
        boulder7.setY((int)(screen_height*0.74-400));
        boulder8.setY((int)(screen_height*0.74-200));
        boulder9.setY((int)(screen_height*0.74));
        boulder_list.add(boulder1);
        boulder_list.add(boulder2);
        boulder_list.add(boulder3);
        boulder_list.add(boulder4);
        boulder_list.add(boulder5);
        boulder_list.add(boulder6);
        boulder_list.add(boulder7);
        boulder_list.add(boulder8);
        boulder_list.add(boulder9);
        for (ImageView iv: boulder_list) {
            iv.setX(screen_width + 100*screenRatioX);
            iv.setImageResource(R.drawable.rock_boulder1);
            iv.getLayoutParams().width = 240;
            iv.getLayoutParams().height = 240;
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
            iv.setY(280);
            iv.setImageResource(R.drawable.water_river);
            iv.getLayoutParams().width = 220;
            iv.getLayoutParams().height = 800;
        }
    }

    public void setUpFood() {
        ImageView food1 = findViewById(R.id.food_view1);
        ImageView food2 = findViewById(R.id.food_view2);
        ImageView food3 = findViewById(R.id.food_view3);
        ImageView food4 = findViewById(R.id.food_view4);
        ImageView food5 = findViewById(R.id.food_view5);
        ImageView food6 = findViewById(R.id.food_view6);
        ImageView food7 = findViewById(R.id.food_view7);
        ImageView food8 = findViewById(R.id.food_view8);
        ImageView food9 = findViewById(R.id.food_view9);
        food1.setY((int)(screen_height*0.74-400));
        food2.setY((int)(screen_height*0.74-400));
        food3.setY((int)(screen_height*0.74-200));
        food4.setY((int)(screen_height*0.74-200));
        food5.setY((int)(screen_height*0.74));
        food6.setY((int)(screen_height*0.74));
        food7.setY((int)(screen_height*0.74-400));
        food8.setY((int)(screen_height*0.74-200));
        food9.setY((int)(screen_height*0.74));
        food_list.add(food1);
        food_list.add(food2);
        food_list.add(food3);
        food_list.add(food4);
        food_list.add(food5);
        food_list.add(food6);
        food_list.add(food7);
        food_list.add(food8);
        food_list.add(food9);
        for (ImageView food: food_list) {
            food.setX(screen_width + 100*screenRatioX);
            food.setImageResource(R.drawable.r_weapon_banana);
            food.getLayoutParams().width = 160;
            food.getLayoutParams().height = 160;
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

    public void setUpProgressBar(int time) {
        int ratio = SET_ONE_LENGTH/progress_bar.getMax();
        progress_bar.setProgress(time/ratio);
    }

    public void playerEscape() {
        move_character_x(16.00f);
    }

    public void showHuntingInfo(int time) {
        if (time >= SET_ONE_LENGTH+40 && time < SET_ONE_LENGTH+120 && !paused) {
            hunting_info.setVisibility(View.VISIBLE);
            hunting_info.setText("Congratulations! Nothing horrific is chasing after you \n ... \n for NOW!");
        } else if (time >= SET_ONE_LENGTH+120 && !paused) {
            hunting_info.setTextSize(44);
            hunting_info.setText("It's HUNTING TIME!!!");
        }
    }

    public void setUpStage1(int time) {
        if (time >= 220 && time < 360 && !paused) {
            boulder_list.get(0).setX(boulder_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 260 && time < 400 && !paused) {
            boulder_list.get(2).setX(boulder_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 260 && time < 400 && !paused) {
            food_list.get(4).setX(food_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 300 && time < 440 && !paused) {
            boulder_list.get(5).setX(boulder_list.get(5).getX() - 20 * screenRatioX);
        }
        if (time >= 340 && time < 480 && !paused) {
            cliff_list.get(0).setX(cliff_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 420 && time < 560 && !paused) {
            food_list.get(0).setX(food_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 420 && time < 560 && !paused) {
            food_list.get(2).setX(food_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 420  && time < 560 && !paused) {
            if (time == 420) {
                food_list.get(4).setX(screen_width + 100*screenRatioX);
                food_list.get(4).setVisibility(View.VISIBLE);
            }
            food_list.get(4).setX(food_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 460 && time < 600 && !paused) {
            cliff_list.get(1).setX(cliff_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 500 && time < 640 && !paused) {
            boulder_list.get(1).setX(boulder_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 500 && time < 640 && !paused) {
            food_list.get(3).setX(food_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 540 && time < 680 && !paused) {
            if (time == 540) {
                boulder_list.get(5).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(5).setX(boulder_list.get(5).getX() - 20 * screenRatioX);
        }
        if (time >= 540 && time < 680 && !paused) {
            boulder_list.get(3).setX(boulder_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 580 && time < 720 && !paused) {
            cliff_list.get(2).setX(cliff_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 620 && time < 760 && !paused) {
            if (time == 620) {
                boulder_list.get(0).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(0).setX(boulder_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 620 && time < 760 && !paused) {
            if (time == 620) {
                boulder_list.get(4).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(4).setX(boulder_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 620 && time < 760 && !paused) {
            if (time == 620) {
                food_list.get(2).setX(screen_width + 100*screenRatioX);
                food_list.get(2).setVisibility(View.VISIBLE);
            }
            food_list.get(2).setX(food_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 660 && time < 800 && !paused) {
            if (time == 660) {
                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(2).setX(boulder_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 660 && time < 800 && !paused) {
            if (time == 660) {
                food_list.get(0).setX(screen_width + 100*screenRatioX);
                food_list.get(0).setVisibility(View.VISIBLE);
            }
            food_list.get(0).setX(food_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 700 && time < 840 && !paused) {
            cliff_list.get(3).setX(cliff_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 740 && time < 880 && !paused) {
            cliff_list.get(4).setX(cliff_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 780 && time < 920 && !paused) {
            if (time == 780) {
                food_list.get(1).setX(screen_width + 100*screenRatioX);
                food_list.get(1).setVisibility(View.VISIBLE);
            }
            food_list.get(1).setX(food_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 780 && time < 920 && !paused) {
            if (time == 780) {
                food_list.get(3).setX(screen_width + 100*screenRatioX);
                food_list.get(3).setVisibility(View.VISIBLE);
            }
            food_list.get(3).setX(food_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 780 && time < 920 && !paused) {
            if (time == 780) {
                food_list.get(4).setX(screen_width + 100*screenRatioX);
                food_list.get(4).setVisibility(View.VISIBLE);
            }
            food_list.get(4).setX(food_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 820 && time < 960 && !paused) {
            if (time == 820) {
                boulder_list.get(0).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(0).setX(boulder_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 820 && time < 960 && !paused) {
            if (time == 820) {
                boulder_list.get(5).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(5).setX(boulder_list.get(5).getX() - 20 * screenRatioX);
        }
        if (time >= 840 && time < 980 && !paused) {
            if (time == 840) {
                food_list.get(0).setX(screen_width + 100*screenRatioX);
                food_list.get(0).setVisibility(View.VISIBLE);
            }
            food_list.get(0).setX(food_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 840 && time < 980 && !paused) {
            if (time == 840) {
                food_list.get(5).setX(screen_width + 100*screenRatioX);
                food_list.get(5).setVisibility(View.VISIBLE);
            }
            food_list.get(5).setX(food_list.get(5).getX() - 20 * screenRatioX);
        }
        if (time >= 860 && time < 1000 && !paused) {
            if (time == 860) {
                boulder_list.get(1).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(1).setX(boulder_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 860 && time < 1000 && !paused) {
            if (time == 860) {
                boulder_list.get(4).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(4).setX(boulder_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 900 && time < 1040 && !paused) {
            if (time == 900) {
                cliff_list.get(0).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(0).setX(cliff_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 920 && time < 1060 && !paused) {
            if (time == 920) {
                food_list.get(1).setX(screen_width + 100*screenRatioX);
                food_list.get(1).setVisibility(View.VISIBLE);
            }
            food_list.get(1).setX(food_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 920 && time < 1060 && !paused) {
            if (time == 920) {
                boulder_list.get(7).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(7).setX(boulder_list.get(7).getX() - 20 * screenRatioX);
        }
        if (time >= 920 && time < 1060 && !paused) {
            if (time == 920) {
                boulder_list.get(8).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(8).setX(boulder_list.get(8).getX() - 20 * screenRatioX);
        }
        if (time >= 960 && time < 1100 && !paused) {
            if (time == 960) {
                boulder_list.get(6).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(6).setX(boulder_list.get(6).getX() - 20 * screenRatioX);
        }
        if (time >= 960 && time < 1100 && !paused) {
            if (time == 960) {
                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(2).setX(boulder_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 980 && time < 1120 && !paused) {
            if (time == 980) {
                food_list.get(2).setX(screen_width + 100*screenRatioX);
                food_list.get(2).setVisibility(View.VISIBLE);
            }
            food_list.get(2).setX(food_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 1000 && time < 1140 && !paused) {
            if (time == 1000) {
                food_list.get(0).setX(screen_width + 100*screenRatioX);
                food_list.get(0).setVisibility(View.VISIBLE);
            }
            food_list.get(0).setX(food_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 1040 && time < 1180 && !paused) {
            if (time == 1040) {
                cliff_list.get(1).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(1).setX(cliff_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 1080 && time < 1220 && !paused) {
            if (time == 1080) {
                boulder_list.get(0).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(0).setX(boulder_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 1080 && time < 1220 && !paused) {
            if (time == 1080) {
                food_list.get(4).setX(screen_width + 100*screenRatioX);
                food_list.get(4).setVisibility(View.VISIBLE);
            }
            food_list.get(4).setX(food_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 1100 && time < 1240 && !paused) {
            if (time == 1100) {
                boulder_list.get(5).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(5).setX(boulder_list.get(5).getX() - 20 * screenRatioX);
        }
        if (time >= 1120 && time < 1260 && !paused) {
            if (time == 1120) {
                boulder_list.get(3).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(3).setX(boulder_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 1120 && time < 1260 && !paused) {
            if (time == 1120) {
                food_list.get(6).setX(screen_width + 100*screenRatioX);
                food_list.get(6).setVisibility(View.VISIBLE);
            }
            food_list.get(6).setX(food_list.get(6).getX() - 20 * screenRatioX);
        }
        if (time >= 1160 && time < 1300 && !paused) {
            if (time == 1160) {
                cliff_list.get(2).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(2).setX(cliff_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 1200 && time < 1340 && !paused) {
            if (time == 1200) {
                boulder_list.get(7).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(7).setX(boulder_list.get(7).getX() - 20 * screenRatioX);
        }
        if (time >= 1220 && time < 1360 && !paused) {
            if (time == 1220) {
                cliff_list.get(3).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(3).setX(cliff_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 1240 && time < 1380 && !paused) {
            if (time == 1240) {
                boulder_list.get(8).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(8).setX(boulder_list.get(8).getX() - 20 * screenRatioX);
        }
        if (time >= 1240 && time < 1380 && !paused) {
            if (time == 1240) {
                food_list.get(1).setX(screen_width + 100*screenRatioX);
                food_list.get(1).setVisibility(View.VISIBLE);
            }
            food_list.get(1).setX(food_list.get(6).getX() - 20 * screenRatioX);
        }
        if (time >= 1260 && time < 1400 && !paused) {
            if (time == 1260) {
                cliff_list.get(4).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(4).setX(cliff_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 1280 && time < 1420 && !paused) {
            if (time == 1280) {
                boulder_list.get(6).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(6).setX(boulder_list.get(6).getX() - 20 * screenRatioX);
        }
        if (time >= 1300 && time < 1440 && !paused) {
            if (time == 1300) {
                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(2).setX(boulder_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 1300 && time < 1440 && !paused) {
            if (time == 1300) {
                food_list.get(5).setX(screen_width + 100*screenRatioX);
                food_list.get(5).setVisibility(View.VISIBLE);
            }
            food_list.get(5).setX(food_list.get(5).getX() - 20 * screenRatioX);
        }
        if (time >= 1320 && time < 1460 && !paused) {
            if (time == 1320) {
                cliff_list.get(0).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(0).setX(cliff_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 1340 && time < 1480 && !paused) {
            if (time == 1340) {
                food_list.get(3).setX(screen_width + 100*screenRatioX);
                food_list.get(3).setVisibility(View.VISIBLE);
            }
            food_list.get(3).setX(food_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 1360 && time < 1500 && !paused) {
            if (time == 1360) {
                food_list.get(0).setX(screen_width + 100*screenRatioX);
                food_list.get(0).setVisibility(View.VISIBLE);
            }
            food_list.get(0).setX(food_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 1360 && time < 1500 && !paused) {
            if (time == 1360) {
                boulder_list.get(3).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(3).setX(boulder_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 1380 && time < 1520 && !paused) {
            if (time == 1380) {
                boulder_list.get(0).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(0).setX(boulder_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 1380 && time < 1520 && !paused) {
            if (time == 1380) {
                food_list.get(8).setX(screen_width + 100*screenRatioX);
                food_list.get(8).setVisibility(View.VISIBLE);
            }
            food_list.get(8).setX(food_list.get(8).getX() - 20 * screenRatioX);
        }
        if (time >= 1400 && time < 1540 && !paused) {
            if (time == 1400) {
                cliff_list.get(1).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(1).setX(cliff_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 1440 && time < 1580 && !paused) {
            if (time == 1440) {
                boulder_list.get(7).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(7).setX(boulder_list.get(7).getX() - 20 * screenRatioX);
        }
        if (time >= 1460 && time < 1600 && !paused) {
            if (time == 1460) {
                boulder_list.get(1).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(1).setX(boulder_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 1460 && time < 1600 && !paused) {
            if (time == 1460) {
                boulder_list.get(4).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(4).setX(boulder_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 1480 && time < 1620 && !paused) {
            if (time == 1480) {
                food_list.get(6).setX(screen_width + 100*screenRatioX);
                food_list.get(6).setVisibility(View.VISIBLE);
            }
            food_list.get(6).setX(food_list.get(6).getX() - 20 * screenRatioX);
        }
        if (time >= 1480 && time < 1620 && !paused) {
            if (time == 1480) {
                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(2).setX(boulder_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 1500 && time < 1640 && !paused) {
            if (time == 1500) {
                boulder_list.get(6).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(6).setX(boulder_list.get(6).getX() - 20 * screenRatioX);
        }
        if (time >= 1500 && time < 1640 && !paused) {
            if (time == 1500) {
                boulder_list.get(5).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(5).setX(boulder_list.get(5).getX() - 20 * screenRatioX);
        }
        if (time >= 1520 && time < 1660 && !paused) {
            if (time == 1520) {
                boulder_list.get(3).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(3).setX(boulder_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 1520 && time < 1660 && !paused) {
            if (time == 1520) {
                food_list.get(4).setX(screen_width + 100*screenRatioX);
                food_list.get(4).setVisibility(View.VISIBLE);
            }
            food_list.get(4).setX(food_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 1540 && time < 1680 && !paused) {
            if (time == 1540) {
                cliff_list.get(2).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(2).setX(cliff_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 1580 && time < 1720 && !paused) {
            if (time == 1580) {
                food_list.get(1).setX(screen_width + 100*screenRatioX);
                food_list.get(1).setVisibility(View.VISIBLE);
            }
            food_list.get(1).setX(food_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 1600 && time < 1740 && !paused) {
            if (time == 1600) {
                food_list.get(7).setX(screen_width + 100*screenRatioX);
                food_list.get(7).setVisibility(View.VISIBLE);
            }
            food_list.get(7).setX(food_list.get(7).getX() - 20 * screenRatioX);
        }
        if (time >= 1620 && time < 1760 && !paused) {
            if (time == 1620) {
                food_list.get(5).setX(screen_width + 100*screenRatioX);
                food_list.get(5).setVisibility(View.VISIBLE);
            }
            food_list.get(5).setX(food_list.get(5).getX() - 20 * screenRatioX);
        }
        if (time >= 1660 && time < 1800 && !paused) {
            if (time == 1660) {
                cliff_list.get(3).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(3).setX(cliff_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 1680 && time < 1820 && !paused) {
            if (time == 1680) {
                boulder_list.get(1).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(1).setX(boulder_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 1700 && time < 1840 && !paused) {
            if (time == 1700) {
                boulder_list.get(7).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(7).setX(boulder_list.get(7).getX() - 20 * screenRatioX);
        }
        if (time >= 1720 && time < 1860 && !paused) {
            if (time == 1720) {
                boulder_list.get(8).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(8).setX(boulder_list.get(8).getX() - 20 * screenRatioX);
        }
        if (time >= 1740 && time < 1880 && !paused) {
            if (time == 1740) {
                cliff_list.get(4).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(4).setX(cliff_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 1760 && time < 1900 && !paused) {
            if (time == 1760) {
                food_list.get(0).setX(screen_width + 100*screenRatioX);
                food_list.get(0).setVisibility(View.VISIBLE);
            }
            food_list.get(0).setX(food_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 1780 && time < 1920 && !paused) {
            if (time == 1780) {
                boulder_list.get(0).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(0).setX(boulder_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 1800 && time < 1940 && !paused) {
            if (time == 1800) {
                boulder_list.get(2).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(2).setX(boulder_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 1820 && time < 1960 && !paused) {
            if (time == 1820) {
                boulder_list.get(4).setX(screen_width + 100*screenRatioX);
            }
            boulder_list.get(4).setX(boulder_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time >= 1840 && time < 1980 && !paused) {
            if (time == 1840) {
                cliff_list.get(0).setX(screen_width + 100*screenRatioX);
            }
            cliff_list.get(0).setX(cliff_list.get(0).getX() - 20 * screenRatioX);
        }
        if (time >= 1880) {
            if (time == 1880) {
                food_list.get(6).setX(screen_width + 100*screenRatioX);
                food_list.get(6).setVisibility(View.VISIBLE);
            }
            food_list.get(6).setX(food_list.get(6).getX() - 20 * screenRatioX);
        }
        if (time >= 1880) {
            if (time == 1880) {
                food_list.get(2).setX(screen_width + 100*screenRatioX);
                food_list.get(2).setVisibility(View.VISIBLE);
            }
            food_list.get(2).setX(food_list.get(2).getX() - 20 * screenRatioX);
        }
        if (time >= 1880) {
            if (time == 1880) {
                food_list.get(8).setX(screen_width + 100*screenRatioX);
                food_list.get(8).setVisibility(View.VISIBLE);
            }
            food_list.get(8).setX(food_list.get(8).getX() - 20 * screenRatioX);
        }
        if (time >= 1920) {
            if (time == 1920) {
                food_list.get(1).setX(screen_width + 100*screenRatioX);
                food_list.get(1).setVisibility(View.VISIBLE);
            }
            food_list.get(1).setX(food_list.get(1).getX() - 20 * screenRatioX);
        }
        if (time >= 1920) {
            if (time == 1920) {
                food_list.get(3).setX(screen_width + 100*screenRatioX);
                food_list.get(3).setVisibility(View.VISIBLE);
            }
            food_list.get(3).setX(food_list.get(3).getX() - 20 * screenRatioX);
        }
        if (time >= 1920) {
            if (time == 1920) {
                food_list.get(4).setX(screen_width + 100*screenRatioX);
                food_list.get(4).setVisibility(View.VISIBLE);
            }
            food_list.get(4).setX(food_list.get(4).getX() - 20 * screenRatioX);
        }
        if (time == SET_ONE_LENGTH + 200 && !paused
        ) {
            paused = true;
        }
    }
}
