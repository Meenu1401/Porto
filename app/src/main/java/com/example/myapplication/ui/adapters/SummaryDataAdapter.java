package com.example.myapplication.ui.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.models.SummaryData;

import java.util.List;

public class SummaryDataAdapter extends RecyclerView.Adapter<SummaryDataAdapter.ViewHolder> {

    private final List<SummaryData> summaryDataList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name, latestValue, daysGain;

        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            latestValue = (TextView) view.findViewById(R.id.latestValue);
            daysGain = (TextView) view.findViewById(R.id.daysGain);
        }
    }

    public SummaryDataAdapter(List<SummaryData> dataSet) {
        summaryDataList = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.summaryrow_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        SummaryData summaryData = summaryDataList.get(position);
        viewHolder.name.setText(summaryData.getNm());
        viewHolder.latestValue.setText(summaryData.getLv() + "");
        viewHolder.daysGain.setText(summaryData.getDg() + "");

    }

    @Override
    public int getItemCount() {
        return summaryDataList.size();
    }
}
