package com.malaysianmannheim.baca.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.malaysianmannheim.baca.Castle1Activity;
import com.malaysianmannheim.baca.Drawer;
import com.malaysianmannheim.baca.GenderSelection;
import com.malaysianmannheim.baca.MainActivity;
import com.malaysianmannheim.baca.R;
import com.malaysianmannheim.baca.castle1.crown1;
import com.malaysianmannheim.baca.castle1.crown2;
import com.malaysianmannheim.baca.castle1.crown3;
import com.malaysianmannheim.baca.castle1.crown4;
import com.malaysianmannheim.baca.castle1.crown5;
import com.malaysianmannheim.baca.castle1.crown6;
import com.malaysianmannheim.baca.castle1.crown7;
import com.malaysianmannheim.baca.ui.Castle1Crown;
import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.List;

public class Castle1Adapter extends RecyclerView.Adapter<Castle1Adapter.MyViewHolder> {

    private Context context;
    //private List<Castle1Crown> listCrown;
    int listCrown[];
    int[] listBack;
    int[] listName;
    int[] listColorProgress;

    public Castle1Adapter(int[] listCrown, int[] listName, int[] listBack, int[] listColorProgress) {
        this.listCrown = listCrown;
        this.listName = listName;
        this.listBack = listBack;
        this.listColorProgress = listColorProgress;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivCrown;
        TextView tvCrown;
        TextView tvPercentage;
        RelativeLayout backCrownLL;
        RoundedHorizontalProgressBar progressBar;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCrown = itemView.findViewById(R.id.iconCrown);
            tvCrown = itemView.findViewById(R.id.titleTxtV);
            tvPercentage = itemView.findViewById(R.id.percentTxtV);
            backCrownLL = itemView.findViewById(R.id.background_crown);
            progressBar = itemView.findViewById(R.id.progressBar);

            //click card view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.d("RecyclerView", "onClick：" + getAdapterPosition());

                    if (getAdapterPosition()==0){
                        Intent intent = new Intent(itemView.getContext(), crown1.class);
                        itemView.getContext().startActivity(intent);
                    }
                    else if (getAdapterPosition()==1){
                        Intent intent = new Intent(itemView.getContext(), crown2.class);
                        itemView.getContext().startActivity(intent);
                    }
                    else if (getAdapterPosition()==2){
                        Intent intent = new Intent(itemView.getContext(), crown3.class);
                        itemView.getContext().startActivity(intent);
                    }
                    else if (getAdapterPosition()==3){
                        Intent intent = new Intent(itemView.getContext(), crown4.class);
                        itemView.getContext().startActivity(intent);
                    }
                    else if (getAdapterPosition()==4){
                        Intent intent = new Intent(itemView.getContext(), crown5.class);
                        itemView.getContext().startActivity(intent);
                    }
                    else if (getAdapterPosition()==5){
                        Intent intent = new Intent(itemView.getContext(), crown6.class);
                        itemView.getContext().startActivity(intent);
                    }
                    else if (getAdapterPosition()==6){
                        Intent intent = new Intent(itemView.getContext(), crown7.class);
                        itemView.getContext().startActivity(intent);
                    }

                }
            });
        }


    }

    @NonNull
    @Override
    public Castle1Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_crown,parent,false));

    }


    @Override
    public void onBindViewHolder(@NonNull Castle1Adapter.MyViewHolder holder, int position) {
        holder.ivCrown.setImageResource(listCrown[position]);
        holder.backCrownLL.setBackgroundResource(listBack[position]);
        holder.tvCrown.setText(listName[position]);
        holder.tvPercentage.setText(String.valueOf(listColorProgress[position])+"%");
        holder.progressBar.setProgress(listColorProgress[position]);

    }

    @Override
    public int getItemCount() {
        return listCrown.length;
    }


    /*public Castle1Adapter(Context context, List<Castle1Crown> listCrown){
        this.context = context;
        this.listCrown = listCrown;
    }

    @Override
    public int getCount() {
        return listCrown.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_crown, container, false);
        ImageView ivCrown = view.findViewById(R.id.iconCrown);
        TextView tvCrown = view.findViewById(R.id.titleTxtV);
        TextView tvPercentage = view.findViewById(R.id.percentTxtV);
        LinearLayout backCrownLL = view.findViewById(R.id.background_crown);

        ivCrown.setImageResource(listCrown.get(position).getIconCrown());
        backCrownLL.setBackgroundResource(listCrown.get(position).getBackground());
        tvCrown.setText(listCrown.get(position).getTitle());
        tvPercentage.setText(listCrown.get(position).getPercentProgress());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+listCrown, Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view);

        return view;
    }*/




}
