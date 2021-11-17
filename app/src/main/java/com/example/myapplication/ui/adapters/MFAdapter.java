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

public class MFAdapter extends RecyclerView.Adapter<MFAdapter.ViewHolder> {

    private final List<SummaryData> summaryDataList;
    private boolean isSelectedMFGain, isSelectedMFLv;

    public void setSelectedMFGain(boolean selectedMFGain) {
        isSelectedMFGain = selectedMFGain;
    }

    public void setSelectedMFLv(boolean selectedMFLv) {
        isSelectedMFLv = selectedMFLv;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name, latestValue, daysGain,daysGainPer;
        private final ConstraintLayout llGain;
        private final View itemseparator;
        private final ConstraintLayout parentCC;
        private final ImageView markerIcon;


        public ViewHolder(View view) {
            super(view);
            name =  view.findViewById(R.id.name);
            latestValue =  view.findViewById(R.id.latestValue);
            daysGain =  view.findViewById(R.id.daysGain);
            llGain= view.findViewById(R.id.llGain);
            daysGainPer=(TextView) view.findViewById(R.id.daysGainPer);
            itemseparator= view.findViewById(R.id.itemseparator);
            parentCC= view.findViewById(R.id.parentCC);

            markerIcon= view.findViewById(R.id.markerIcon);
        }
    }

    public MFAdapter(List<SummaryData> dataSet) {
        summaryDataList = dataSet;
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

        mContext = viewHolder.parentCC.getContext();
        SummaryData summaryData = summaryDataList.get(position);
        viewHolder.name.setText(summaryData.getNm());


        if(isSelectedMFGain)  {
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
                viewHolder.daysGainPer.setTextColor(Color.parseColor("#AB1711"));
                viewHolder.markerIcon.setImageResource(R.drawable.arrow_down);

                viewHolder.llGain.setBackground(ContextCompat.getDrawable(mContext, R.drawable.round_corner_ng));

            }
            viewHolder.daysGainPer.setText("" +summaryData.getDgp() + "%");
        }


        if(isSelectedMFLv)  {
            viewHolder.latestValue.setText(""+summaryData.getInv()+"" );
        }
        else
        {
            viewHolder.latestValue.setText( ""+summaryData.getLv() + "");
        }







        if(position+1 ==summaryDataList.size()){
            viewHolder.itemseparator.setVisibility(View.GONE);
        }
        else{
            viewHolder.itemseparator.setVisibility(View.VISIBLE);

        }



    /*    if(position%2==0) {
            viewHolder.llGain.setBackgroundColor(Color.parseColor("#18A558"));
            viewHolder.daysGain.setText("" +summaryData.getDg() + "");
        }
        else{
            viewHolder.llGain.setBackgroundColor(Color.parseColor("#FF4C4C"));
            viewHolder.daysGain.setText("" + summaryData.getDg() + "");

        }
*/
    }

    @Override
    public int getItemCount() {
        return summaryDataList.size();
    }
}
