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

    private int current_page_number;

    private int current_hair_index;
    private int current_head_index;
    private int current_eye_index;
    private int current_nose_index;

    private int[] hair_image_id_list;
    private int[] head_image_id_list;
    private int[] eye_image_id_list;
    private int[] nose_image_id_list;

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

        current_page_number = 1;


        current_hair_index = 0;
        current_head_index = 0;
        current_eye_index = 0;
        current_nose_index = 0;


        appearance_change_textview1.setText("Hair Style 1");
        appearance_change_textview2.setText("Head Style 1");
        appearance_change_textview3.setText("Eye Style 1");
        appearance_change_textview4.setText("Nose Style 1");

        hair_image_id_list = new int[]{R.drawable.hair_1, R.drawable.hair_2, R.drawable.hair_3, R.drawable.hair_4,
                R.drawable.hair_5, R.drawable.hair_6, R.drawable.hair_7, R.drawable.hair_8, R.drawable.hair_9};

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
                if (current_page_number == 1)
                {
                    current_hair_index--;

                    if (current_hair_index < 0)
                    {
                        current_hair_index = hair_image_id_list.length - 1;
                    }

                    appearance_change_textview1.setText("Hair Style " + Integer.toString(current_hair_index + 1));
                    hair_view.setBackground(null);
                    hair_view.setImageResource(hair_image_id_list[current_hair_index]);

                }
            }
        });

        appearance_next_button1 = findViewById(R.id.appearance_next_button1);
        appearance_next_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current_page_number == 1)
                {
                    current_hair_index++;

                    if (current_hair_index > hair_image_id_list.length - 1)
                    {
                        current_hair_index = 0;
                    }

                    appearance_change_textview1.setText("Style " + Integer.toString(current_hair_index + 1));
                    hair_view.setBackground(null);
                    hair_view.setImageResource(hair_image_id_list[current_hair_index]);

                }
            }
        });

        appearance_last_button2 = findViewById(R.id.appearance_last_button2);
        appearance_last_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current_page_number == 1)
                {
                    current_head_index--;

                    if (current_head_index < 0)
                    {
                        current_head_index = head_image_id_list.length - 1;
                    }

                    appearance_change_textview2.setText("Head Style " + Integer.toString(current_head_index + 1));
                    head_view.setBackground(null);
                    head_view.setImageResource(head_image_id_list[current_head_index]);

                }
            }
        });

        appearance_next_button2 = findViewById(R.id.appearance_next_button2);
        appearance_next_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current_page_number == 1)
                {
                    current_head_index++;

                    if (current_head_index > head_image_id_list.length - 1)
                    {
                        current_head_index = 0;
                    }

                    appearance_change_textview2.setText("Style " + Integer.toString(current_head_index + 1));
                    head_view.setBackground(null);
                    head_view.setImageResource(head_image_id_list[current_head_index]);

                }
            }
        });

        appearance_last_button3 = findViewById(R.id.appearance_last_button3);
        appearance_last_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current_page_number == 1)
                {
                    current_eye_index--;

                    if (current_eye_index < 0)
                    {
                        current_eye_index = eye_image_id_list.length - 1;
                    }

                    appearance_change_textview3.setText("Eye Style " + Integer.toString(current_eye_index + 1));
                    eye_view.setBackground(null);
                    eye_view.setImageResource(eye_image_id_list[current_eye_index]);

                }
            }
        });

        appearance_next_button3 = findViewById(R.id.appearance_next_button3);
        appearance_next_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (current_page_number == 1)
                    {
                        current_eye_index++;

                        if (current_eye_index > eye_image_id_list.length - 1)
                        {
                            current_eye_index = 0;
                        }

                        appearance_change_textview3.setText("Eye Style " + Integer.toString(current_eye_index + 1));
                        eye_view.setBackground(null);
                        eye_view.setImageResource(eye_image_id_list[current_eye_index]);

                    }
            }
        });

        appearance_last_button4 = findViewById(R.id.appearance_last_button4);
        appearance_last_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current_page_number == 1)
                {
                    current_nose_index--;

                    if (current_nose_index < 0)
                    {
                        current_nose_index = hair_image_id_list.length - 1;
                    }

                    appearance_change_textview4.setText("Nose Style " + Integer.toString(current_nose_index + 1));
                    nose_view.setBackground(null);
                    nose_view.setImageResource(nose_image_id_list[current_nose_index]);

                }
            }
        });

        appearance_next_button4 = findViewById(R.id.appearance_next_button4);
        appearance_next_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current_page_number == 1)
                {
                    current_nose_index++;

                    if (current_nose_index > nose_image_id_list.length - 1)
                    {
                        current_nose_index = 0;
                    }

                    appearance_change_textview4.setText("Nose Style " + Integer.toString(current_nose_index + 1));
                    nose_view.setBackground(null);
                    nose_view.setImageResource(nose_image_id_list[current_nose_index]);

                }
            }
        });

        character_next_page_button = findViewById(R.id.character_next_page_button);
        character_next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current_page_number++;
                //TODO
            }
        });

        character_last_page_button = findViewById(R.id.character_last_page_button);
        character_last_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current_page_number--;
                //TODO
            }
        });


    }


}
