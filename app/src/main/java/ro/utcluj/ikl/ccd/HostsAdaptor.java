package ro.utcluj.ikl.ccd;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HostsAdaptor extends RecyclerView.Adapter<HostsAdaptor.MyViewHolder> {

    HostResponse mList;

    HostsAdaptor(){
        mList=ClientManager.getManager().getmHostResponse();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_host_item, viewGroup, false);

        return new HostsAdaptor.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        String status;
        holder.mName.setText(mList.getmResponseHost().get(i).getmHost());
        status = mList.getmResponseHost().get(i).getmStatus();
        if(status.equals("1")){
            holder.mImageView.setImageResource(R.drawable.ic_router_red_24dp);
            holder.mDetails.setText("Dead");
        }else if (status.equals("0")){
            holder.mImageView.setImageResource(R.drawable.ic_router_green_24dp);
            holder.mDetails.setText("Alive");
        }

    }

    @Override
    public int getItemCount() {
        return mList.getmResponseHost().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView mName;
        private TextView mDetails;
        private ImageView mImageView;

        public MyViewHolder(View view) {
            super(view);
            mName=view.findViewById(R.id.hostItemTitle);
            mDetails=view.findViewById(R.id.hostItemDescription);
            mImageView=view.findViewById(R.id.hostItemImage);
        }
    }
}
