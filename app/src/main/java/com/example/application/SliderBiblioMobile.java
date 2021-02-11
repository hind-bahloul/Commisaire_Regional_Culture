package com.example.application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderBiblioMobile extends RecyclerView.Adapter<SliderBiblioMobile.SliderViewHolder>{
    private List<SliderItem5> sliderItems5;

    private ViewPager2 viewPager2;


    public SliderBiblioMobile(List<SliderItem5> sliderItems5, ViewPager2 viewPager2) {
        this.sliderItems5 = sliderItems5;
        this.viewPager2 = viewPager2;

    }

    @NonNull
    @Override
    public SliderBiblioMobile.SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderBiblioMobile.SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderBiblioMobile.SliderViewHolder holder, int position) {
        holder.setImage(sliderItems5.get(position));

        if(position == sliderItems5.size()-2)
        {
            viewPager2.post(runnable);
        }

    }

    @Override
    public int getItemCount() {
        return sliderItems5.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageview;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.imageSlider);
        }
        void setImage(SliderItem5 sliderItems5){
            imageview.setImageResource(sliderItems5.getImage());
        }

    }
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            sliderItems5.addAll(sliderItems5);

            notifyDataSetChanged();
        }
    };
}
