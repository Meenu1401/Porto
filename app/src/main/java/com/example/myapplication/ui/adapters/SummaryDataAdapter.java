package com.example.myapplication.ui.adapters;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.models.SummaryData;

import java.util.List;

public class SummaryDataAdapter extends RecyclerView.Adapter<SummaryDataAdapter.ViewHolder> {

    private final List<SummaryData> summaryDataList;
    private boolean isSelectedSummaryGain, isSelectedSummaryLv;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name, latestValue, daysGain,daysGainPer;
        private final View itemseparator;
        private final ConstraintLayout llGain;
        private final ConstraintLayout parentCC;

        private final ImageView markerIcon;



        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            latestValue = view.findViewById(R.id.latestValue);
            daysGain = view.findViewById(R.id.daysGain);
            daysGainPer= view.findViewById(R.id.daysGainPer);
            itemseparator= view.findViewById(R.id.itemseparator);
            llGain= view.findViewById(R.id.llGain);
            parentCC= view.findViewById(R.id.parentCC);
            markerIcon= view.findViewById(R.id.markerIcon);
        }
    }

    public SummaryDataAdapter(List<SummaryData> dataSet) {
        summaryDataList = dataSet;
    }

    public void setSelectedSummaryGain(boolean selectedSummaryGain) {
        isSelectedSummaryGain = selectedSummaryGain;
    }

    public void setSelectedSummaryLv(boolean selectedSummaryLv) {
        isSelectedSummaryLv = selectedSummaryLv;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.summaryrow_item_2, viewGroup, false);

        return new ViewHolder(view);
    }
    private Context mContext;

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        SummaryData summaryData = summaryDataList.get(position);

        mContext = viewHolder.parentCC.getContext();
        viewHolder.name.setText(summaryData.getNm());

//Data on gain (days and total)
        if(isSelectedSummaryGain)  {
            viewHolder.daysGain.setText("" +summaryData.getTg() + "");
            viewHolder.daysGainPer.setText("" +summaryData.getTgp() + "%");
        }
        else
        {
            if(position%2==0) {
                viewHolder.daysGain.setTextColor(Color.parseColor("#177A3A"));
                viewHolder.daysGain.setText("" +summaryData.getDg() + "");
                viewHolder.daysGainPer.setTextColor(Color.parseColor("#177A3A"));
                viewHolder.markerIcon.setImageResource(R.drawable.arrow_up);
                viewHolder.llGain.setBackground(ContextCompat.getDrawable(mContext, R.drawable.round_corner_positive));


            }
            else{
                viewHolder.daysGain.setTextColor(Color.parseColor("#AB1711"));
                viewHolder.daysGain.setText("" +summaryData.getDg() + "");
                viewHolder.markerIcon.setImageResource(R.drawable.arrow_down);

                viewHolder.daysGainPer.setTextColor(Color.parseColor("#AB1711"));
                viewHolder.llGain.setBackground(ContextCompat.getDrawable(mContext, R.drawable.round_corner_ng));

            }
            viewHolder.daysGainPer.setText("" +summaryData.getDgp() + "%");
        }


        if(isSelectedSummaryLv)  {
            viewHolder.latestValue.setText(""+summaryData.getInv()+"" );
        }
        else
        {
            viewHolder.latestValue.setText( ""+summaryData.getLv() + "");
        }












        //remove last separator

        if(position+1 ==summaryDataList.size()){
            viewHolder.itemseparator.setVisibility(View.GONE);
        }
        else{
            viewHolder.itemseparator.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return summaryDataList.size();
    }
}
