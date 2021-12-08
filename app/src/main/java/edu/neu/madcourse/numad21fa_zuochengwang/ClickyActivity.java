package edu.neu.madcourse.numad21fa_zuochengwang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickyActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicky);

        Button button_A = findViewById(R.id.button_clicky_A);
        Button button_B = findViewById(R.id.button_clicky_B);
        Button button_C = findViewById(R.id.button_clicky_C);
        Button button_D = findViewById(R.id.button_clicky_D);
        Button button_E = findViewById(R.id.button_clicky_E);
        Button button_F = findViewById(R.id.button_clicky_F);

        button_A.setOnTouchListener(this);
        button_B.setOnTouchListener(this);
        button_C.setOnTouchListener(this);
        button_D.setOnTouchListener(this);
        button_E.setOnTouchListener(this);
        button_F.setOnTouchListener(this);

        TextView press_text = findViewById(R.id.button_click);
        String no_click = "Pressed: -";
        press_text.setText(no_click);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            show_button_click(view);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            TextView press_text = findViewById(R.id.button_click);
            String no_click = "Pressed: -";
            press_text.setText(no_click);
        }
        return false;
    }

    public void show_button_click(View view)
    {
        TextView press_text = findViewById(R.id.button_click);
        String click_A = "Pressed: A";
        String click_B = "Pressed: B";
        String click_C = "Pressed: C";
        String click_D = "Pressed: D";
        String click_E = "Pressed: E";
        String click_F = "Pressed: F";
        switch(view.getId())
        {
            case R.id.button_clicky_A:
                press_text.setText(click_A);
                break;
            case R.id.button_clicky_B:
                press_text.setText(click_B);
                break;
            case R.id.button_clicky_C:
                press_text.setText(click_C);
                break;
            case R.id.button_clicky_D:
                press_text.setText(click_D);
                break;
            case R.id.button_clicky_E:
                press_text.setText(click_E);
                break;
            case R.id.button_clicky_F:
                press_text.setText(click_F);
                break;
        }
    }

}