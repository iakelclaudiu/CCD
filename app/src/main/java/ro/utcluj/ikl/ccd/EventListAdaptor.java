package ro.utcluj.ikl.ccd;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.TintTypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        String mSeverity;
        String mTitle;
        long mUnixTimeStamp;
        String mResolv;

        //holder.mDetails.setText(mList.getmResponseList().get(i).getmClock());
        holder.mName.setText(mList.getmResponseList().get(i).getmName());
        mSeverity = mList.getmResponseList().get(i).getmSeverity();
        mResolv = mList.getmResponseList().get(i).getmR_clock();


        mUnixTimeStamp = Long.valueOf(mList.getmResponseList().get(i).getmClock());
        Date date = new java.util.Date(mUnixTimeStamp*1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+2"));
        holder.mDetails.setText(sdf.format(date));


        switch (mSeverity){
            case "1" : holder.mImageView.setImageResource(R.drawable.ic_info_black_24dp);
                    break;
            case "5" : holder.mImageView.setImageResource(R.drawable.ic_cancel_black_24dp);
                    break;
            default: holder.mImageView.setImageResource(R.drawable.ic_warning_black_24dp);
                    break;
        }
        Log.d("IKLtest", "onBindViewHolder: " + mResolv);
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
        private String mSeverity;

        public MyViewHolder(View view) {
            super(view);
            mName=view.findViewById(R.id.itemTitle);
            mDetails=view.findViewById(R.id.itemDescription);
            mImageView=view.findViewById(R.id.itemImage);
        }
    }
}
