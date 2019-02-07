package ro.utcluj.ikl.ccd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recycler=getActivity().findViewById(R.id.problemsRecycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(new EventListAdaptor());



        ImageButton logout = getActivity().findViewById(R.id.problemsMenu);
        logout.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Logged out", Toast.LENGTH_LONG).show();
            ServiceImpl implementation = new ServiceImpl();
            implementation.logout();

            SharedPreferences mSharedPrefs;
            mSharedPrefs = getActivity().getSharedPreferences(Contract.mLoginSaves, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = mSharedPrefs.edit();
            editor.putBoolean(Contract.mAutoLogin,false);
            editor.apply();
            Navigator.getInstance().showLogin();

        });

        ImageButton refresh = getActivity().findViewById(R.id.problemsRefresh);
        refresh.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Refresh", Toast.LENGTH_SHORT).show();
            ServiceImpl implementation = new ServiceImpl();
            implementation.getList();
        });

        Button problems = getActivity().findViewById(R.id.problemsProblemsDash);
        problems.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Already here", Toast.LENGTH_SHORT).show();
        });

        Button hosts = getActivity().findViewById(R.id.problmesHostsDash);
        hosts.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Going to Hosts", Toast.LENGTH_SHORT).show();
            ServiceImpl implementation = new ServiceImpl();
            implementation.getHosts();
        });

        Button history = getActivity().findViewById(R.id.problmesHistoryDash);
        history.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Not yet implemented!", Toast.LENGTH_LONG).show();
        });
       // Log.d("IKLTest", "onBindViewHolder: " + recycler.getAdapter().getItemCount());

    }
}
