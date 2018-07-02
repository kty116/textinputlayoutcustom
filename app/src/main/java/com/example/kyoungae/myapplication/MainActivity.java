package com.example.kyoungae.myapplication;

import android.annotation.SuppressLint;
import android.support.design.widget.CheckableImageButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout;
    private TextInputEditText textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayout = findViewById(R.id.text_layout);
        textView = findViewById(R.id.text);

        View view =
        textInputLayout.addView();

//        textInputLayout.setPassword

        Log.d("Dddd", "onCreate: " + textView.getText().toString());

        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (charSequence.length() > 0){  //text 있을때
//                    textInputLayout.setPasswordVisibilityToggleEnabled(true);
//                }else {
//                    textInputLayout.setPasswordVisibilityToggleEnabled(false);
//                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editable.toString();
                if (s.length() > 0) {
                    textInputLayout.setPasswordVisibilityToggleEnabled(true);
//                    textInputLayout.set
//                    textInputLayout.setPa
                    textInputLayout.setPasswordVisibilityToggleDrawable(R.drawable.ic_clear_black_24dp);
                    setToggle();
                } else {
                    textInputLayout.setPasswordVisibilityToggleEnabled(false);
                }
            }
        });


    }

    public void setToggle() {
        View togglePasswordButton = findTogglePasswordButton(textInputLayout);
        if (togglePasswordButton != null) {
            togglePasswordButton.setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint("RestrictedApi")
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    // implementation
                    CheckableImageButton checkableImageButton = (CheckableImageButton) view;
                    Log.d("Ddd", "onTouch: " + checkableImageButton.isChecked());

//                    if(!checkableImageButton.isChecked()){
                    textView.setText("");
//                    }else {

//                    }

                    return false;
                }
            });
        }
    }

    private View findTogglePasswordButton(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int ind = 0; ind < childCount; ind++) {
            View child = viewGroup.getChildAt(ind);
            if (child instanceof ViewGroup) {
                View togglePasswordButton = findTogglePasswordButton((ViewGroup) child);
                if (togglePasswordButton != null) {
                    return togglePasswordButton;
                }
            } else if (child instanceof CheckableImageButton) {
                return child;
            }
        }
        return null;
    }

}
