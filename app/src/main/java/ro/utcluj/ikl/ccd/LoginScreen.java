package ro.utcluj.ikl.ccd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class LoginScreen extends Fragment {

    private View mView;
    private SharedPreferences mSharedPrefs;

    public LoginScreen() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login_screen, container, false);
        mSharedPrefs = getActivity().getSharedPreferences(Contract.mLoginSaves, Context.MODE_PRIVATE);


        // Inflate the layout for this fragment
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton button = getActivity().findViewById(R.id.loginSettings);


        if (button != null) {
            button.setOnClickListener(view12 -> Navigator.getInstance().showLoginSettings());
        }

        EditText userName = getActivity().findViewById(R.id.inputUsername);
        EditText password = getActivity().findViewById(R.id.inputPassword);

        SharedPreferences.OnSharedPreferenceChangeListener sharedPreferenceChangeListener = (mSharedPrefs, key) -> {
            Log.d("IKLtest", "onViewCreated: SharedPrefs changed");
            if (key.equals(Contract.mUsername)) {
                userName.setText(mSharedPrefs.getString(Contract.mUsername, ""));
            }
            if (key.equals(Contract.mPassword)) {
                password.setText(mSharedPrefs.getString(Contract.mPassword, ""));
            }
        };
        mSharedPrefs.registerOnSharedPreferenceChangeListener(sharedPreferenceChangeListener);

        userName.setText(mSharedPrefs.getString(Contract.mUsername, ""));
        password.setText(mSharedPrefs.getString(Contract.mPassword, ""));


        Button button1 = getActivity().findViewById(R.id.login_button);
        button1.setOnClickListener(view1 -> {
            Log.d("IKLtest", "LoginButton pressed ");
            // If Username and password fields are empty MAKE A TOAST MESSAGE
            if(userName.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                Toast.makeText(getActivity(), "No username or password entered", Toast.LENGTH_LONG).show();
            }else{ //if above fields are not empty check autologin variable if TRUE save creds, after that login
                if(mSharedPrefs.getBoolean(Contract.mAutoLogin,false)){
                    SharedPreferences.Editor editor = mSharedPrefs.edit();
                    editor.putString(Contract.mUsername,userName.getText().toString());
                    editor.putString(Contract.mPassword,password.getText().toString());
                    editor.apply();
                }
                Toast.makeText(getActivity(), "Login in", Toast.LENGTH_LONG).show();

                ServiceImpl implementation = new ServiceImpl();
                implementation.logIn(userName.getText().toString(),password.getText().toString());
            }
        });


    }

}
