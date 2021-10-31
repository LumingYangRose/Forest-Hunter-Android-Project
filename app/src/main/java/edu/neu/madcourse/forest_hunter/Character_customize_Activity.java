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

    private int current_page_number;
    private int current_hair_index;

    private ArrayList<Integer> hair_pic_id_list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_view);

        appearance_change_textview1 = findViewById(R.id.appearance_change_textview1);
        appearance_change_textview2 = findViewById(R.id.appearance_change_textview2);
        appearance_change_textview3 = findViewById(R.id.appearance_change_textview3);
        appearance_change_textview4 = findViewById(R.id.appearance_change_textview4);


        hair_view = findViewById(R.id.hair_view);

        current_page_number = 1;
        current_hair_index = 0;
        appearance_change_textview1.setText("Style 1");

        hair_pic_id_list = new ArrayList<Integer>();
        hair_pic_id_list.add(700012);
        hair_pic_id_list.add(700014);
        hair_pic_id_list.add(700016);
        hair_pic_id_list.add(700019);
        hair_pic_id_list.add(700020);


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

                //TODO
            }
        });

        appearance_next_button1 = findViewById(R.id.appearance_next_button1);
        appearance_next_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current_page_number == 1)
                {
                    current_hair_index++;
                    appearance_change_textview1.setText("Style " + Integer.toString(current_hair_index + 1));
                    hair_view.setImageResource(R.drawable.hair_3);
                    //hair_view.setImageResource(hair_pic_id_list.get(current_hair_index));
                }
            }
        });

        appearance_last_button2 = findViewById(R.id.appearance_last_button2);
        appearance_last_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        appearance_next_button2 = findViewById(R.id.appearance_next_button2);
        appearance_next_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        appearance_last_button3 = findViewById(R.id.appearance_last_button3);
        appearance_last_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        appearance_next_button3 = findViewById(R.id.appearance_next_button3);
        appearance_next_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        appearance_last_button4 = findViewById(R.id.appearance_last_button4);
        appearance_last_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        appearance_next_button4 = findViewById(R.id.appearance_next_button4);
        appearance_next_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        character_next_page_button = findViewById(R.id.character_next_page_button);
        character_next_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });

        character_last_page_button = findViewById(R.id.character_last_page_button);
        character_last_page_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO
            }
        });


    }


}
