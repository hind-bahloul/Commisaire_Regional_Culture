package com.example.application;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;
import android.view.View;
import java.util.List;

public class SliderَAdapterCentreDramatique extends RecyclerView.Adapter<SliderَAdapterCentreDramatique.SliderViewHolder>{
    private List<SliderItem1> sliderItems1;

    private ViewPager2 viewPager2;


    public SliderَAdapterCentreDramatique(List<SliderItem1> sliderItems1, ViewPager2 viewPager2) {
        this.sliderItems1 = sliderItems1;
        this.viewPager2 = viewPager2;

    }

    @NonNull
    @Override
    public SliderَAdapterCentreDramatique.SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderَAdapterCentreDramatique.SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderَAdapterCentreDramatique.SliderViewHolder holder, int position) {
        holder.setImage(sliderItems1.get(position));

        if(position == sliderItems1.size()-2)
        {
            viewPager2.post(runnable);
        }

    }

    @Override
    public int getItemCount() {
        return sliderItems1.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageview;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.imageSlider);
        }
        void setImage(SliderItem1 sliderItem1){
            imageview.setImageResource(sliderItem1.getImage());
        }

    }
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            sliderItems1.addAll(sliderItems1);

            notifyDataSetChanged();
        }
    };
}
