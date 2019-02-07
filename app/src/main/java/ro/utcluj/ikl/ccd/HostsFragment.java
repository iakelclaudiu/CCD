package ro.utcluj.ikl.ccd;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class HostsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hosts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recycler=getActivity().findViewById(R.id.hostsRecycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(new HostsAdaptor());

        ImageButton logout = getActivity().findViewById(R.id.hostsMenu);
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

        ImageButton refresh = getActivity().findViewById(R.id.hostsRefresh);
        refresh.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Refresh", Toast.LENGTH_SHORT).show();
            ServiceImpl implementation = new ServiceImpl();
            implementation.getHosts();
        });

        Button problems = getActivity().findViewById(R.id.hostsProblemsDash);
        problems.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Going to Problems", Toast.LENGTH_SHORT).show();
            Navigator.getInstance().showDashBoard();
        });

        Button hosts = getActivity().findViewById(R.id.hostsHostsDash);
        hosts.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Already here", Toast.LENGTH_SHORT).show();
        });

        Button history = getActivity().findViewById(R.id.hostsHistoryDash);
        history.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Not yet implemented", Toast.LENGTH_LONG).show();
        });
    }
}
