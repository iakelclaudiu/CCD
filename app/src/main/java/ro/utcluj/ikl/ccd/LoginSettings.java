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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;


public class LoginSettings extends Fragment {

    private SharedPreferences mSharedPrefs;
    private CheckBox mloginAuto;
    private CheckBox mTicket;
    private Button mButton;
    private EditText mEditText;

    public LoginSettings() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mSharedPrefs = getActivity().getSharedPreferences(Contract.mLoginSaves, Context.MODE_PRIVATE);
        return inflater.inflate(R.layout.fragment_login_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mloginAuto=getActivity().findViewById(R.id.loginAuto);
        mTicket = getActivity().findViewById(R.id.ticketCredentials);
        mButton=getActivity().findViewById(R.id.loginSettingsSave);
        mEditText=getActivity().findViewById(R.id.inputServer);



        mTicket.setChecked(mSharedPrefs.getBoolean(Contract.mTicketCreds,false));
        mloginAuto.setChecked(mSharedPrefs.getBoolean(Contract.mAutoLogin,false));
        mEditText.setClickable(false);

        SharedPreferences.Editor editor = mSharedPrefs.edit();

        mTicket.setOnClickListener(view1 -> {
            if(mTicket.isChecked()){
                editor.putString(Contract.mUsername,"tickets");
                editor.putString(Contract.mPassword,"puBCLjkLqHj8ycs");
                editor.putBoolean(Contract.mAutoLogin,true);
                editor.apply();
                mloginAuto.setChecked(true);
                mloginAuto.setClickable(false);
            }else{
                editor.remove(Contract.mUsername);
                editor.remove(Contract.mPassword);
                mloginAuto.setClickable(true);
                editor.apply();
            }
        });


        //setValues();
    }

    private void setValues() {
        mTicket.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                SharedPreferences.Editor editor = mSharedPrefs.edit();

                if (checked) {

                    editor.putBoolean(Contract.mTicketCreds, true);
                    editor.putBoolean(Contract.mAutoLogin,true);
                    editor.putString(Contract.mUsername,"tickets");
                    editor.putString(Contract.mPassword,"puBCLjkLqHj8ycs");
                    mloginAuto.setChecked(true);
                    mloginAuto.setClickable(false);
                } else if(!checked) {
                    Log.d("IKLtest", "onCheckedChanged: false");
                    editor.putBoolean(Contract.mTicketCreds, false);
                    editor.putString(Contract.mUsername,"");
                    editor.putString(Contract.mPassword,"");
                    mloginAuto.setClickable(true);
                }

                editor.apply();
            }
        });

        mloginAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                SharedPreferences.Editor editor = mSharedPrefs.edit();
                if(checked){
                    editor.putBoolean(Contract.mAutoLogin, true);
                }else {
                    editor.putBoolean(Contract.mAutoLogin, false);
                }
                editor.apply();
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = mSharedPrefs.edit();
                editor.putString(Contract.mServer,mEditText.getText().toString());
                editor.apply();
                Log.d("IKL", "onClick: Button pressed");
            }
        });
    }
}
