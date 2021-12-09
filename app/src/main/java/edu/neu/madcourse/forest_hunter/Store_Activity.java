package edu.neu.madcourse.forest_hunter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import user.Login_User;

public class Store_Activity extends AppCompatActivity {
    ImageButton return_main_activity;
    Button recharge_10k;
    Button recharge_60k;
    Button recharge_250k;
    private String username;
    private DatabaseReference reference;
    private TextView coins;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_view);
        username = Login_User.current_User.username;
        reference = FirebaseDatabase.getInstance().getReference();
        return_main_activity = findViewById(R.id.return_main_activity);
        recharge_10k = findViewById(R.id.recharge_10k);
        recharge_60k = findViewById(R.id.recharge_60k);
        recharge_250k = findViewById(R.id.recharge_250k);
        coins = findViewById(R.id.coins);

        return_main_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activate_return_main_activity();
            }
        });

        reference.child("users").child(username).child("num_of_gold").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                value = snapshot.getValue(Integer.class);
                coins.setText("Your Coins :" + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //todo   Click to recharge gold coins
        recharge_10k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child("users").child(username).child("num_of_gold").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        value = snapshot.getValue(Integer.class);
                        value = value + 1000;
                        coins.setText("Your Coins :" + value);
                        reference.child("users").child(username).child("num_of_gold").setValue(value);
                        showMyDialog();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        recharge_60k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child("users").child(username).child("num_of_gold").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        value = snapshot.getValue(Integer.class);
                        value = value + 6000;
                        coins.setText("Your Coins :" + value);
                        reference.child("users").child(username).child("num_of_gold").setValue(value);
                        showMyDialog();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        recharge_250k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child("users").child(username).child("num_of_gold").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        value = snapshot.getValue(Integer.class);
                        value = value + 15000;
                        coins.setText("Your Coins :" + value);
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
        finish();
    }

}