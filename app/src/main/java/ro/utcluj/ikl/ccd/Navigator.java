package ro.utcluj.ikl.ccd;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

class Navigator {

    private AppCompatActivity mContext;
    private static Navigator sInstance = null;

    static Navigator getInstance() {
        if (sInstance == null) {
            sInstance = new Navigator();
        }

        return sInstance;
    }

    void setContext(AppCompatActivity context) {
        mContext = context;
    }

    void showLogin() {
        SharedPreferences loginPrefs;
        loginPrefs = mContext.getSharedPreferences(Contract.mLoginSaves, Context.MODE_PRIVATE);
        boolean autoLogin = loginPrefs.getBoolean(Contract.mAutoLogin, false);
        String username= loginPrefs.getString(Contract.mUsername,"");
        String password=loginPrefs.getString(Contract.mPassword,"");
        String server=loginPrefs.getString(Contract.mServer,"");


       // if(!autoLogin&&isEmpty(username)&&isEmpty(password)&&isEmpty(server)){
            FragmentTransaction transaction;
            transaction = mContext.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, new LoginScreen());
            transaction.addToBackStack(Contract.mLogin);
            transaction.commit();
       // }

    }

    void showLoginSettings(){
        FragmentTransaction transaction;
        transaction = mContext.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new LoginSettings());
        transaction.addToBackStack(Contract.mLoginSettings);
        transaction.commit();
    }

    private boolean isEmpty(String string){
        if(string==null || string.isEmpty()){
            return true;
        }

        return false;
    }
}
