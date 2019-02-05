package ro.utcluj.ikl.ccd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


public class LoginSettings extends Fragment {

    private SharedPreferences mSharedPrefs;
    private CheckBox mCheckbox;
    private CheckBox mCheckBox1;
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
        mCheckBox1=getActivity().findViewById(R.id.loginAuto);
        mCheckbox = getActivity().findViewById(R.id.ticketCredentials);
        mButton=getActivity().findViewById(R.id.loginSettingsSave);
        mEditText=getActivity().findViewById(R.id.inputServer);

        boolean ticket=mSharedPrefs.getBoolean(Contract.mTicketCreds,false);
        mCheckbox.setChecked(ticket);

        boolean autoLogin=mSharedPrefs.getBoolean(Contract.mAutoLogin,false);
        mCheckBox1.setChecked(autoLogin);

        String server=mSharedPrefs.getString(Contract.mServer,"");
        mEditText.setText(server);

        setValues();
    }

    private void setValues() {
        mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                SharedPreferences.Editor editor = mSharedPrefs.edit();

                if (checked && mSharedPrefs != null) {
                    editor.putBoolean(Contract.mTicketCreds, true);
                } else {
                    editor.putBoolean(Contract.mTicketCreds, false);
                }

                editor.apply();
            }
        });

        mCheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
            }
        });
    }
}
