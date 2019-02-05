package ro.utcluj.ikl.ccd;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EventListAdaptor extends RecyclerView.Adapter<EventListAdaptor.MyViewHolder> {

    ListResponse mList;

    EventListAdaptor(){
        mList=ClientManager.getManager().getmListResponse();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.mName.setText(mList.getmResponseList().get(i).getmName());
        holder.mDetails.setText(mList.getmResponseList().get(i).getmClock());
    }

    @Override
    public int getItemCount() {
        return mList.getmResponseList().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView mName;
        private TextView mDetails;
        private ImageView mImageView;

        public MyViewHolder(View view) {
            super(view);
            mName=view.findViewById(R.id.itemTitle);
            mDetails=view.findViewById(R.id.itemDescription);
            mImageView=view.findViewById(R.id.itemImage);
        }
    }
}
