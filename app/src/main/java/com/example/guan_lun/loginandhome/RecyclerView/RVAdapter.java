package com.example.guan_lun.loginandhome.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.guan_lun.loginandhome.R;

import java.util.ArrayList;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private static final String TAG = "RV_Adapter"; //for log recognition

    //vars
    private Context mContext;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mRatings = new ArrayList<>();


    public RVAdapter(Context context, ArrayList<String> mNames, ArrayList<String> mImageUrls, ArrayList<String> mRatings) {
        this.mContext = context;
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.mRatings = mRatings;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: called.");  //for log recognition

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item, viewGroup, false);
        return new ViewHolder(view);    // bind the layout
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {   //bind data
        Log.d(TAG, "onBindViewHolder: called.");  //for log recognition

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(i))
                .into(viewHolder.image);

        viewHolder.title.setText(mNames.get(i));
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on an image " + mNames.get(i));
                Toast.makeText(mContext, mNames.get(i), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.rating.setText(mRatings.get(i));
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView rating;
        ImageView star;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.rv_image);
            title = itemView.findViewById(R.id.rv_title);
            rating = itemView.findViewById(R.id.rv_rating);
            star = itemView.findViewById(R.id.rv_star);
        }
    }

}
