package com.iteso.tarea2;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {
    LinearLayout linearLayout;
    TextView bicycle, color, description, descriptionBody, measurement, measurementBody;
    ImageView bicyclePic;
    ImageButton like;
    RadioGroup sizeGroup, colorGroup;
    RadioButton grayButton, brownButton, blackButton, pinkButton, smallButton, mediumButton, largeButton, xlargeButton;
    Button addToCart;

    int selectedColor = 1;
    int selectedSize = 1;

    boolean checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.activity_main_layout);
        bicycle = findViewById(R.id.activity_main_vintage);
        color = findViewById(R.id.activity_main_description);
        description = findViewById(R.id.activity_main_description_text);
        descriptionBody = findViewById(R.id.activity_main_color);
        measurement = findViewById(R.id.activity_main_measurement);
        measurementBody = findViewById(R.id.activty_main_measurement_text);
        bicyclePic = findViewById(R.id.activity_main_bicycle);
        like = findViewById(R.id.activity_main_like);
        colorGroup = findViewById(R.id.activity_main_colorButtons);
        sizeGroup = findViewById(R.id.activity_main_sizeButtons);
        grayButton = findViewById(R.id.button_gray);
        brownButton = findViewById(R.id.button_brown);
        blackButton = findViewById(R.id.button_black);
        pinkButton = findViewById(R.id.button_pink);
        smallButton = findViewById(R.id.button_small);
        mediumButton = findViewById(R.id.button_medium);
        largeButton = findViewById(R.id.button_large);
        xlargeButton = findViewById(R.id.button_xlarge);
        addToCart = findViewById(R.id.activity_main_add);


        //like
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast plusOne = Toast.makeText(ActivityMain.this,
                        R.string.like_pressed
                        , Toast.LENGTH_LONG);
                plusOne.show();
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checked == true) {
                    Toast alreadyInCart = Toast.makeText(ActivityMain.this,
                            R.string.already_in_cart
                            , Toast.LENGTH_LONG);
                    alreadyInCart.show();
                }
                else {
                    addToCart.setText(R.string.button_added);

                    Snackbar.make(linearLayout, R.string.button_added, Snackbar.LENGTH_INDEFINITE)
                            .setAction(R.string.undo, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    addToCart.setText(R.string.button_add);
                                    checked = false;
                                }
                            })
                            .show();
                }
                checked = true;
            }
        });
    }

    //radio buttons
    public void onColorClick(View view) {
        boolean check = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.button_gray:
                if (check) {
                    selectedColor = 1;
                    break;
                }
            case R.id.button_brown:
                if (check) {
                    selectedColor = 2;
                    break;
                }
            case R.id.button_pink:
                if (check) {
                    selectedColor = 3;
                    break;
                }
            case R.id.button_black:
                if (check) {
                    selectedColor = 4;
                    break;
                }
        }
    }

    public void onSizeClick(View view) {
        boolean check = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button_small:
                if (check) {
                    selectedSize = 1;
                    break;
                }
            case R.id.button_medium:
                if (check) {
                    selectedSize = 2;
                    break;
                }
            case R.id.button_large:
                if (check) {
                    selectedSize = 3;
                    break;
                }
            case R.id.button_xlarge:
                if (check) {
                    selectedSize = 4;
                    break;
                }
        }

    }

}
