package com.example.exampledialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowAnimationFrameStats;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showDialogButton;
    private static TextView usernameTextView, passwordTextView;
    private static DialogClass dialogClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogClass = new DialogClass();

        showDialogButton = findViewById(R.id.button);

        usernameTextView = findViewById(R.id.usernameEditText);
        passwordTextView = findViewById(R.id.passwordEditText);

        showDialogButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                dialogClass.setCallBack(new getDataBackHere() {
                    @Override
                    public void getData(String user, String pass) {
                        showCreds(user, pass);
                    }
                });
                dialogClass.show(getSupportFragmentManager(), "Type Something Meaningful Here");
                break;
        }
    }

    private void showCreds(String username, String password) {
        usernameTextView.setText(username);
        passwordTextView.setText(password);
        dialogClass.dismiss();
    }

//    public static void showCredentials(String username, String password) {
//        Log.d("Main", "showCredentials: " + username + " " + password);
//
//        usernameTextView.setText(username);
//        passwordTextView.setText(password);
//        dialogClass.dismiss();
//    }

    public interface getDataBackHere{
        void getData(String user, String pass);
    }
}