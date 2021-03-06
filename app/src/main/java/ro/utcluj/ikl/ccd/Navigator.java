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

    void startApp(){
        SharedPreferences loginPrefs;
        loginPrefs = mContext.getSharedPreferences(Contract.mLoginSaves, Context.MODE_PRIVATE);
        boolean autoLogin = loginPrefs.getBoolean(Contract.mAutoLogin, false);
        String username= loginPrefs.getString(Contract.mUsername,"");
        String password=loginPrefs.getString(Contract.mPassword,"");


        if(!username.isEmpty() || !password.isEmpty()){
            if(autoLogin){
                ServiceImpl implementation = new ServiceImpl();
                implementation.logIn(username,password);
            }
        }
        showLogin();
    }

    void showLogin() {
            FragmentTransaction transaction;
            transaction = mContext.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, new LoginScreen());
            transaction.addToBackStack(Contract.mLogin);
            transaction.commit();
    }

    void showLoginSettings(){
        FragmentTransaction transaction;
        transaction = mContext.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new LoginSettings());
        transaction.addToBackStack(Contract.mLoginSettings);
        transaction.commit();
    }

    void showDashBoard(){
        FragmentTransaction transaction;
        transaction = mContext.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new DashboardFragment());
        transaction.addToBackStack(Contract.mDashBoard);
        transaction.commit();
    }

    void showHosts(){
        FragmentTransaction transaction;
        transaction = mContext.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new HostsFragment());
        transaction.addToBackStack(Contract.mHostsDash);
        transaction.commit();
    }
}
