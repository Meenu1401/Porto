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

public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.ViewHolder> {

    private final List<SummaryData> summaryDataList;
    private Context mContext;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name, latestValue, daysGain,daysGainPer,stockPrice;
        private final ConstraintLayout llGain;
        private final View itemseparator;
        private final ConstraintLayout parentCC;

        private final ImageView markerIcon;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            latestValue = (TextView) view.findViewById(R.id.latestValue);
            daysGain = (TextView) view.findViewById(R.id.daysGain);
            stockPrice= (TextView) view.findViewById(R.id.stockPrice);

            llGain= view.findViewById(R.id.llGain);
            daysGainPer=(TextView) view.findViewById(R.id.daysGainPer);
            itemseparator= view.findViewById(R.id.itemseparator);
            parentCC= view.findViewById(R.id.parentCC);


            markerIcon= view.findViewById(R.id.markerIcon);
        }
    }

    public StocksAdapter(List<SummaryData> dataSet) {
        summaryDataList = dataSet;
    }

    private boolean isSelectedStockGain;
    private int lvselectedStock;


    public void setSelectedStockGain(boolean selectedSummaryGain) {
        isSelectedStockGain = selectedSummaryGain;
    }

    public void setSelectedStockLv(int selectedStockLv) {
        lvselectedStock = selectedStockLv;
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

        mContext = viewHolder.parentCC.getContext();

        viewHolder.name.setText(summaryData.getNm());
        viewHolder.stockPrice.setText(summaryData.getSp());

        viewHolder.stockPrice.setVisibility(View.VISIBLE);
        if(isSelectedStockGain)  {
            viewHolder.daysGain.setText(""+summaryData.getTg() + "");
            viewHolder.daysGainPer.setText(""+summaryData.getTgp() + "%");
        }
        else
        {
            if(position%2==0) {
                viewHolder.daysGain.setTextColor(Color.parseColor("#177A3A"));
                viewHolder.daysGain.setText(""+summaryData.getDg() + "");
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
            viewHolder.daysGainPer.setText(""+summaryData.getDgp() + "%");
        }


        if(lvselectedStock==1)  {
            viewHolder.latestValue.setText(summaryData.getInv() + "");
        }
        else if(lvselectedStock==2)
        {
            viewHolder.latestValue.setText(summaryData.getQn() + "");

        }
        else{
            viewHolder.latestValue.setText(summaryData.getLv() + "");

        }







        if(position+1 ==summaryDataList.size()){
            viewHolder.itemseparator.setVisibility(View.GONE);
        }
        else{
            viewHolder.itemseparator.setVisibility(View.VISIBLE);

        }





       /* if(position%2==0) {
            viewHolder.llGain.setBackgroundColor(Color.parseColor("#18A558"));
            viewHolder.daysGain.setText(""+summaryData.getDg() + "");
        }
        else{
            viewHolder.llGain.setBackgroundColor(Color.parseColor("#FF4C4C"));
            viewHolder.daysGain.setText("" + summaryData.getDg() + "");

        }*/

    }

    @Override
    public int getItemCount() {
        return summaryDataList.size();
    }
}
