package ro.utcluj.ikl.ccd;

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

        Button problems = getActivity().findViewById(R.id.hostsProblemsDash);
        problems.setOnClickListener(view1 -> {
            Toast.makeText(getActivity(), "Going to Problems", Toast.LENGTH_SHORT).show();
            Navigator.getInstance().showDashBoard();
        });
    }
}
