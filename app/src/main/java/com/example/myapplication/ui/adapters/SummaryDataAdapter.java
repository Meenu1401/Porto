package com.example.myapplication.ui.adapters;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.models.SummaryData;

import java.util.List;

public class SummaryDataAdapter extends RecyclerView.Adapter<SummaryDataAdapter.ViewHolder> {

    private final List<SummaryData> summaryDataList;
    private boolean isSelectedSummaryGain;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name, latestValue, daysGain,daysGainPer;
        private final View itemseparator;


        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            latestValue = view.findViewById(R.id.latestValue);
            daysGain = view.findViewById(R.id.daysGain);
            daysGainPer= view.findViewById(R.id.daysGainPer);
            itemseparator= view.findViewById(R.id.itemseparator);
        }
    }

    public SummaryDataAdapter(List<SummaryData> dataSet) {
        summaryDataList = dataSet;
    }

    public void setSelectedSummaryGain(boolean selectedSummaryGain) {
        isSelectedSummaryGain = selectedSummaryGain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.summaryrow_item_2, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        SummaryData summaryData = summaryDataList.get(position);
        viewHolder.name.setText(summaryData.getNm());
        viewHolder.latestValue.setText(summaryData.getLv() + "");
      /*  if(position%2==0) {
            viewHolder.llGain.setBackgroundColor(Color.parseColor("#18A558"));
            viewHolder.daysGain.setText("+" +summaryData.getDg() + "");
        }
        else{
            viewHolder.llGain.setBackgroundColor(Color.parseColor("#FF4C4C"));
            viewHolder.daysGain.setText("-" + summaryData.getDg() + "");

        }*/



        if(isSelectedSummaryGain){
            if(position%2==0) {
                viewHolder.daysGain.setTextColor(Color.parseColor("#18A558"));
                viewHolder.daysGain.setText("+" +summaryData.getDg() + "");
                viewHolder.daysGainPer.setTextColor(Color.parseColor("#18A558"));
            }
            else{
                viewHolder.daysGain.setTextColor(Color.parseColor("#FF4C4C"));
                viewHolder.daysGain.setText("-" +summaryData.getDg() + "");
                viewHolder.daysGainPer.setTextColor(Color.parseColor("#FF4C4C"));
            }
            viewHolder.daysGainPer.setText("(" +summaryData.getDg() + "%)");
        }else
            {
                viewHolder.daysGain.setText("+" +summaryData.getTg() + "");
                viewHolder.daysGainPer.setText("(" +summaryData.getTg() + "%)");
            }


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
