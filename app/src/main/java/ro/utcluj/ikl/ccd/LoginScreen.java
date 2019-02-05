package ro.utcluj.ikl.ccd;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class LoginScreen extends Fragment {

    private View mView;

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
        mView=inflater.inflate(R.layout.fragment_login_screen, container, false);

        // Inflate the layout for this fragment
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton button=getActivity().findViewById(R.id.loginSettings);


        if(button!=null){
            button.setOnClickListener(view12 -> Navigator.getInstance().showLoginSettings());
        }

        final EditText userName=getActivity().findViewById(R.id.inputUsername);
        EditText password=getActivity().findViewById(R.id.inputPassword);

        Button button1=getActivity().findViewById(R.id.login_button) ;
        button1.setOnClickListener(view1 -> {
            ServiceImpl implementation=new ServiceImpl();
            implementation.logIn("tickets","puBCLjkLqHj8ycs");
        });


    }

}
