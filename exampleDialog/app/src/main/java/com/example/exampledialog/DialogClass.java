package com.example.exampledialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogClass extends AppCompatDialogFragment implements View.OnClickListener {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private MainActivity.getDataBackHere getDataBackHere; //Create instance of interface "getDataBackHere" which is declared in MainActivity

    public DialogClass() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        usernameEditText = view.findViewById(R.id.username);
        passwordEditText = view.findViewById(R.id.password);
        loginButton = view.findViewById(R.id.login);

        loginButton.setOnClickListener(this);

        builder.setView(view);

        return builder.create();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Log.d("THAMBA ", "onClick: Aala login chya case madhye");
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                Log.d("THAMBA ", "onClick: " + username + " " + password);
                getDataBackHere.getData(username, password);

                /* This is another way to send dialog data back to MainActivity (static method) */
                //MainActivity.showCredentials(username, password);
                break;
        }
    }

    //This method will keep instance of interface "getDataBackHere" which is declared in MainActivity
    //Call interface method whenever needed
    public void setCallBack(MainActivity.getDataBackHere callBack){
        getDataBackHere = callBack;
    }
}
