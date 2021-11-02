package edu.neu.madcourse.forest_hunter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Character_customize_Activity extends AppCompatActivity {

    public EditText User_name_Edit_Text;
    public TextView selection_title_textview1;
    public TextView selection_title_textview2;
    public TextView selection_title_textview3;
    public TextView selection_title_textview4;
    public TextView appearance_change_textview1;
    public TextView appearance_change_textview2;
    public TextView appearance_change_textview3;
    public TextView appearance_change_textview4;

    public ImageButton appearance_last_button1;
    public ImageButton appearance_next_button1;
    public ImageButton appearance_last_button2;
    public ImageButton appearance_next_button2;
    public ImageButton appearance_last_button3;
    public ImageButton appearance_next_button3;
    public ImageButton appearance_last_button4;
    public ImageButton appearance_next_button4;
    public ImageButton character_next_page_button;
    public ImageButton character_last_page_button;

    public ImageView hair_view;
    public ImageView head_view;
    public ImageView eye_view;
    public ImageView nose_view;
    public ImageView mouth_view;
    public ImageView l_eyebrow_view;
    public ImageView r_eyebrow_view;
    public ImageView ear_view;

    private int current_page_number;

    private int current_hair_index;
    private int current_head_index;
    private int current_eye_index;
    private int current_nose_index;
    private int current_mouth_index;
    private int current_l_eye_brow_index;
    private int current_r_eye_brow_index;
    private int current_ear_index;

    private int[] hair_image_id_list;
    private int[] head_image_id_list;
    private int[] eye_image_id_list;
    private int[] nose_image_id_list;
    private int[] mouth_image_id_list;
    private int[] l_eye_brow_image_id_list;
    private int[] r_eye_brow_image_id_list;
    private int[] ear_image_id_list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_view);

        appearance_change_textview1 = findViewById(R.id.appearance_change_textview1);
        appearance_change_textview2 = findViewById(R.id.appearance_change_textview2);
        appearance_change_textview3 = findViewById(R.id.appearance_change_textview3);
        appearance_change_textview4 = findViewById(R.id.appearance_change_textview4);


        hair_view = findViewById(R.id.hair_view);
        head_view = findViewById(R.id.head_view);
        eye_view = findViewById(R.id.eyes_view);
        nose_view = findViewById(R.id.nose_view);
        mouth_view = findViewById(R.id.mouth_view);
        l_eyebrow_view = findViewById(R.id.l_eyebrow_view);
        r_eyebrow_view = findViewById(R.id.r_eyebrow_view);
        ear_view = findViewById(R.id.ear_view);

        current_page_number = 1;

        current_hair_index = 0;
        current_head_index = 0;
        current_eye_index = 0;
        current_nose_index = 0;
        current_mouth_index = 0;
        current_l_eye_brow_index = 0;
        current_r_eye_brow_index = 0;
        current_ear_index = 0;

        appearance_change_textview1.setText("Style 1");
        appearance_change_textview2.setText("Style 1");
        appearance_change_textview3.setText("Style 1");
        appearance_change_textview4.setText("Style 1");

        hair_image_id_list = new int[]{R.drawable.hair_1, R.drawable.hair_2, R.drawable.hair_3, R.drawable.hair_4,
                R.drawable.hair_5, R.drawable.hair_6, R.drawable.hair_7, R.drawable.hair_8, R.drawable.hair_9, 0};

        head_image_id_list = new int[]{R.drawable.face_1, R.drawable.face_2, R.drawable.face_3, R.drawable.face_4,
                R.drawable.face_5, R.drawable.face_6, R.drawable.face_7, R.drawable.face_8, R.drawable.face_9,
                R.drawable.face_10, R.drawable.face_11, R.drawable.face_12};

        eye_image_id_list = new int[] {R.drawable.open_eyes_1, R.drawable.open_eyes_2, R.drawable.open_eyes_3,
                R.drawable.open_eyes_4, R.drawable.open_eyes_5, R.drawable.open_eyes_6, R.drawable.open_eyes_7,
                R.drawable.open_eyes_8, R.drawable.open_eyes_9, R.drawable.open_eyes_10, R.drawable.open_eyes_11,
                R.drawable.open_eyes_12, R.drawable.open_eyes_13, R.drawable.open_eyes_14, R.drawable.open_eyes_15,
                R.drawable.open_eyes_16, R.drawable.open_eyes_17, R.drawable.open_eyes_18, R.drawable.open_eyes_19,
                R.drawable.open_eyes_20, R.drawable.open_eyes_21, R.drawable.open_eyes_22, R.drawable.open_eyes_23,
                R.drawable.open_eyes_24, R.drawable.open_eyes_25, R.drawable.open_eyes_26, R.drawable.open_eyes_27,
                R.drawable.open_eyes_28, R.drawable.open_eyes_29};

        nose_image_id_list = new int[] {R.drawable.nose_1, R.drawable.nose_2, R.drawable.nose_3,
                R.drawable.nose_4, R.drawable.nose_5, R.drawable.nose_6, R.drawable.nose_7, R.drawable.nose_8,
                R.drawable.nose_9, R.drawable.nose_10, R.drawable.nose_11, R.drawable.nose_12, R.drawable.nose_13};

        mouth_image_id_list = new int[] {R.drawable.mouth_1, R.drawable.mouth_2, R.drawable.mouth_3,
                R.drawable.mouth_4, R.drawable.mouth_5, R.drawable.mouth_6, R.drawable.mouth_7,
                R.drawable.mouth_8, R.drawable.mouth_9, R.drawable.mouth_10, R.drawable.mouth_11,
                R.drawable.mouth_12, R.drawable.mouth_13, R.drawable.mouth_14, R.drawable.mouth_15,
                R.drawable.mouth_16, R.drawable.mouth_17, R.drawable.mouth_18, R.drawable.mouth_19,
                R.drawable.mouth_20, R.drawable.mouth_21, R.drawable.mouth_21, R.drawable.mouth_22,
                R.drawable.mouth_23, R.drawable.mouth_24, R.drawable.mouth_25, R.drawable.mouth_26};

        l_eye_brow_image_id_list = new int[] {R.drawable.l_eyebrow_1, R.drawable.l_eyebrow_2, R.drawable.l_eyebrow_3,
                R.drawable.l_eyebrow_4, R.drawable.l_eyebrow_5, R.drawable.l_eyebrow_6, R.drawable.l_eyebrow_7,
                R.drawable.l_eyebrow_8, R.drawable.l_eyebrow_9, R.drawable.l_eyebrow_10, R.drawable.l_eyebrow_11,
                R.drawable.l_eyebrow_12, R.drawable.l_eyebrow_13, R.drawable.l_eyebrow_14, R.drawable.l_eyebrow_15};

        r_eye_brow_image_id_list = new int[] {R.drawable.r_eyebrow_1, R.drawable.r_eyebrow_2, R.drawable.r_eyebrow_3,
                R.drawable.r_eyebrow_4, R.drawable.r_eyebrow_5, R.drawable.r_eyebrow_6, R.drawable.r_eyebrow_7,
                R.drawable.r_eyebrow_8, R.drawable.r_eyebrow_9, R.drawable.r_eyebrow_10, R.drawable.r_eyebrow_11,
                R.drawable.r_eyebrow_12, R.drawable.r_eyebrow_13, R.drawable.r_eyebrow_14, R.drawable.r_eyebrow_15};

        ear_image_id_list = new int[] {R.drawable.ear_1, R.drawable.ear_2, R.drawable.ear_3,
                R.drawable.ear_4, R.drawable.ear_5, R.drawable.ear_6, R.drawable.ear_7,
                R.drawable.ear_8, R.drawable.ear_9};


        User_name_Edit_Text = findViewById(R.id.User_name_EditText);

        selection_title_textview1 = findViewById(R.id.selection_title_textview1);
        selection_title_textview2 = findViewById(R.id.selection_title_textview2);
        selection_title_textview3 = findViewById(R.id.selection_title_textview3);
        selection_title_textview4 = findViewById(R.id.selection_title_textview4);

        appearance_change_textview1 = findViewById(R.id.appearance_change_textview1);
        appearance_change_textview2 = findViewById(R.id.appearance_change_textview2);
        appearance_change_textview3 = findViewById(R.id.appearance_change_textview3);
        appearance_change_textview4 = findViewById(R.id.appearance_change_textview4);

        appearance_last_button1 = findViewById(R.id.appearance_last_button1);
        appearance_last_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (current_page_number) {
                    case 1:
                        current_hair_index--;

                        if (current_hair_index < 0)
                        {
                            current_hair_index = hair_image_id_list.length - 1;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_hair_index + 1));
                        hair_view.setBackground(null);
                        hair_view.setImageResource(hair_image_id_list[current_hair_index]);
                        break;

                    case 2:
                        current_mouth_index--;

                        if (current_mouth_index < 0)
                        {
                            current_mouth_index = mouth_image_id_list.length - 1;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_mouth_index + 1));
                        mouth_view.setBackground(null);
                        mouth_view.setImageResource(mouth_image_id_list[current_mouth_index]);
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

                        if (current_hair_index > hair_image_id_list.length - 1)
                        {
                            current_hair_index = 0;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_hair_index + 1));
                        hair_view.setBackground(null);
                        hair_view.setImageResource(hair_image_id_list[current_hair_index]);
                        break;

                    case 2:

                        current_mouth_index++;

                        if (current_mouth_index > mouth_image_id_list.length - 1)
                        {
                            current_mouth_index = 0;
                        }

                        appearance_change_textview1.setText("Style " + Integer.toString(current_mouth_index + 1));
                        mouth_view.setBackground(null);
                        mouth_view.setImageResource(mouth_image_id_list[current_mouth_index]);
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
                            current_head_index = head_image_id_list.length - 1;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_head_index + 1));
                        head_view.setBackground(null);
                        head_view.setImageResource(head_image_id_list[current_head_index]);
                        break;

                    case 2:
                        current_l_eye_brow_index--;

                        if (current_l_eye_brow_index < 0)
                        {
                            current_l_eye_brow_index = l_eye_brow_image_id_list.length - 1;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_l_eye_brow_index + 1));
                        l_eyebrow_view.setBackground(null);
                        l_eyebrow_view.setImageResource(l_eye_brow_image_id_list[current_l_eye_brow_index]);
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

                        if (current_head_index > head_image_id_list.length - 1)
                        {
                            current_head_index = 0;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_head_index + 1));
                        head_view.setBackground(null);
                        head_view.setImageResource(head_image_id_list[current_head_index]);
                        break;

                    case 2:

                        current_l_eye_brow_index++;

                        if (current_l_eye_brow_index > l_eye_brow_image_id_list.length - 1)
                        {
                            current_l_eye_brow_index = 0;
                        }

                        appearance_change_textview2.setText("Style " + Integer.toString(current_l_eye_brow_index + 1));
                        l_eyebrow_view.setBackground(null);
                        l_eyebrow_view.setImageResource(l_eye_brow_image_id_list[current_l_eye_brow_index]);
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
                            current_eye_index = eye_image_id_list.length - 1;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_eye_index + 1));
                        eye_view.setBackground(null);
                        eye_view.setImageResource(eye_image_id_list[current_eye_index]);
                        break;

                    case 2:
                        current_r_eye_brow_index--;

                        if (current_r_eye_brow_index < 0)
                        {
                            current_r_eye_brow_index = r_eye_brow_image_id_list.length - 1;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_r_eye_brow_index + 1));
                        r_eyebrow_view.setBackground(null);
                        r_eyebrow_view.setImageResource(r_eye_brow_image_id_list[current_r_eye_brow_index]);
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

                        if (current_eye_index > eye_image_id_list.length - 1)
                        {
                            current_eye_index = 0;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_eye_index + 1));
                        eye_view.setBackground(null);
                        eye_view.setImageResource(eye_image_id_list[current_eye_index]);
                        break;

                    case 2:

                        current_r_eye_brow_index++;

                        if (current_r_eye_brow_index > r_eye_brow_image_id_list.length - 1)
                        {
                            current_r_eye_brow_index = 0;
                        }

                        appearance_change_textview3.setText("Style " + Integer.toString(current_r_eye_brow_index + 1));
                        r_eyebrow_view.setBackground(null);
                        r_eyebrow_view.setImageResource(r_eye_brow_image_id_list[current_r_eye_brow_index]);
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
                            current_nose_index = hair_image_id_list.length - 1;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_nose_index + 1));
                        nose_view.setBackground(null);
                        nose_view.setImageResource(nose_image_id_list[current_nose_index]);
                        break;

                    case 2:
                        current_ear_index--;

                        if (current_ear_index < 0)
                        {
                            current_ear_index = ear_image_id_list.length - 1;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_ear_index + 1));
                        ear_view.setBackground(null);
                        ear_view.setImageResource(ear_image_id_list[current_ear_index]);
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

                        if (current_nose_index > nose_image_id_list.length - 1)
                        {
                            current_nose_index = 0;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_nose_index + 1));
                        nose_view.setBackground(null);
                        nose_view.setImageResource(nose_image_id_list[current_nose_index]);
                        break;

                    case 2:

                        current_ear_index++;

                        if (current_ear_index > ear_image_id_list.length - 1)
                        {
                            current_ear_index = 0;
                        }

                        appearance_change_textview4.setText("Style " + Integer.toString(current_ear_index + 1));
                        ear_view.setBackground(null);
                        ear_view.setImageResource(ear_image_id_list[current_ear_index]);
                        break;

                }
            }
        });

        character_next_page_button = findViewById(R.id.character_next_page_button);
        character_next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current_page_number++;

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

                }

                //TODO
            }
        });

        character_last_page_button = findViewById(R.id.character_last_page_button);
        character_last_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current_page_number--;

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
                        selection_title_textview1.setText("Mouth");
                        selection_title_textview2.setText("Left Eyebrow");
                        selection_title_textview3.setText("Right Eyebrow");
                        selection_title_textview4.setText("Ear");
                        break;

                }

                //TODO
            }
        });


    }


}
