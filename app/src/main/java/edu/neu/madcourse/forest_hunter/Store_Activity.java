package edu.neu.madcourse.forest_hunter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Store_Activity extends AppCompatActivity {
    ImageButton return_main_activity;
    Button recharge_500;
    Button recharge_1000;
    Button recharge_2000;
    private String username;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_view);
        username = getIntent().getStringExtra("username");
        reference = FirebaseDatabase.getInstance().getReference();
        return_main_activity = findViewById(R.id.return_main_activity);
        recharge_500 = findViewById(R.id.recharge_500);
        recharge_1000 = findViewById(R.id.recharge_1000);
        recharge_2000 = findViewById(R.id.recharge_2000);

        return_main_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activate_return_main_activity();
            }
        });

        //todo   Click to recharge gold coins
        recharge_500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child("users").child(username).child("num_of_gold").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int value = snapshot.getValue(Integer.class);
                        value = value + 500;
                        reference.child("users").child(username).child("num_of_gold").setValue(value);
                        showMyDialog();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        recharge_1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child("users").child(username).child("num_of_gold").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int value = snapshot.getValue(Integer.class);
                        value = value + 100;
                        reference.child("users").child(username).child("num_of_gold").setValue(value);
                        showMyDialog();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        recharge_2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child("users").child(username).child("num_of_gold").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int value = snapshot.getValue(Integer.class);
                        value = value + 2000;
                        reference.child("users").child(username).child("num_of_gold").setValue(value);
                        showMyDialog();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


    }

    public void showMyDialog() {
        //todo   showMyDialog
        AlertDialog alert_dialog;
        AlertDialog.Builder dialog = new AlertDialog.Builder(Store_Activity.this);
        View dialog_view = getLayoutInflater().inflate(R.layout.coinsuc, null);
        Button login_cancel_button = dialog_view.findViewById(R.id.login_cancel_button);
        dialog.setView(dialog_view);
        alert_dialog = dialog.create();
        alert_dialog.setCanceledOnTouchOutside(false);
        login_cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_dialog.dismiss();
            }
        });
        alert_dialog.show();
    }

    public void activate_return_main_activity() {
        Intent game_view_intent = new Intent(this, MainActivity.class);
        startActivity(game_view_intent);
    }

}