package com.example.myapplication.ui.portfolio;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPortfolioDetailBinding;
import com.example.myapplication.ui.adapters.MFAdapter;
import com.example.myapplication.ui.adapters.StocksAdapter;
import com.example.myapplication.ui.adapters.SummaryDataAdapter;
import com.example.myapplication.ui.models.Items;
import com.example.myapplication.ui.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//API
// top table : https://myjson.dit.upm.es/api/bins/7v99
// stock table :http://myjson.dit.upm.es/api/bins/eigd
// mf table :http://myjson.dit.upm.es/api/bins/f6dh




public class PortfolioDetailFragment extends Fragment implements View.OnClickListener {

    private FragmentPortfolioDetailBinding binding;
    private CardView cardviewSummaryList, cardviewMFList, cardviewStockList;
    private TextView lblAddtoPort, daysGain,lvSummary, daysGainstock, lvStock, daysgainMf, lvMf ;
    private boolean isSelectedSummaryGain,isSelectedStockGain,isSelectedMFGain,isSelectedSummaryLv,isSelectedStockLv,isSelectedMFLv ;
    private int lvselectedStock=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPortfolioDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cardviewSummaryList= view. findViewById(R.id.cardviewSummaryList);
        cardviewSummaryList.setVisibility(View.GONE);
        cardviewStockList= view. findViewById(R.id.cardviewStockList);
        cardviewStockList.setVisibility(View.GONE);
        cardviewMFList= view. findViewById(R.id.cardviewMFList);
        cardviewMFList.setVisibility(View.GONE);

        lblAddtoPort= view. findViewById(R.id.lblAddtoPort);

        daysGain= view. findViewById(R.id.daysGain);
        daysGain.setOnClickListener(this);

        lvSummary= view. findViewById(R.id.lvSummary);
        lvSummary.setOnClickListener(this);

        daysGainstock= view. findViewById(R.id.daysGainstock);
        daysGainstock.setOnClickListener(this);

        lvStock= view. findViewById(R.id.lvStock);
        lvStock.setOnClickListener(this);

        daysgainMf= view. findViewById(R.id.daysgainMf);
        daysgainMf.setOnClickListener(this);

        lvMf= view. findViewById(R.id.lvMf);
        lvMf.setOnClickListener(this);



        getTopTable();
        getStockTable();
        getMFTable();
        enableAddToPortfolio();
    }

    private void enableAddToPortfolio() {
        lblAddtoPort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        String[] items = {"Stock","Mutual Fund"};
        int checkedItem = 3;
        alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Toast.makeText(getContext(), "Navigate to the Add stock page", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                        break;
                    case 1:
                        Toast.makeText(getContext(), "Navigate to the Add Mutual funds page", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                        break;
                }
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(true);
        alert.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    SummaryDataAdapter adapterSumm;
    private void getTopTable() {
        Call<Items> call = RetrofitClient.getInstance().getMyApi().getTopTable();

        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {







                Items myheroList = response.body();

                adapterSumm = new SummaryDataAdapter(myheroList.getList());
                binding.recyclerTop.setHasFixedSize(true);
                binding.recyclerTop.setLayoutManager(new LinearLayoutManager(requireContext()));
                binding.recyclerTop.setAdapter(adapterSumm);

                cardviewSummaryList.animate().translationY(cardviewSummaryList.getHeight());
                cardviewSummaryList.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }

    private void getStockTable() {
        Call<Items> call = RetrofitClient.getInstance().getMyApi().getStockTable();

        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {


                cardviewStockList.setVisibility(View.VISIBLE);


                Items myheroList = response.body();
                StocksAdapter adapter = new StocksAdapter(myheroList.getList());
                binding.recyclerStock.setHasFixedSize(true);
                binding.recyclerStock.setLayoutManager(new LinearLayoutManager(requireContext()));
                binding.recyclerStock.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }

    private void getMFTable() {
        Call<Items> call = RetrofitClient.getInstance().getMyApi().getMFTable();

        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {


                cardviewMFList.setVisibility(View.VISIBLE);

                Items myheroList = response.body();
                MFAdapter adapter = new MFAdapter(myheroList.getList());
                binding.recyclerMf.setHasFixedSize(true);
                binding.recyclerMf.setLayoutManager(new LinearLayoutManager(requireContext()));
                binding.recyclerMf.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Toast.makeText(getContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.daysGain:
                if(isSelectedSummaryGain)
                {
                    daysGain.setText("Days Gain");
                    //getUpdatedNumbers
                    isSelectedSummaryGain =false;

                }
                else{
                    daysGain.setText("Total Gain");
                    isSelectedSummaryGain =true;
                    //getUpdatedNumbers

                }
                break;
            case R.id.lvSummary:

                if(isSelectedSummaryLv)
                {
                    lvSummary.setText("latest Value");
                    //getUpdatedNumbers
                    isSelectedSummaryLv =false;

                }
                else{
                    lvSummary.setText("Invested Amount");
                    isSelectedSummaryLv =true;
                    //getUpdatedNumbers

                }

                break;
            case R.id.daysGainstock:

                if(isSelectedStockGain)
                {
                    daysGainstock.setText("Days Gain");
                    //getUpdatedNumbers
                    isSelectedStockGain =false;

                }
                else{
                    daysGainstock.setText("Total Gain");
                    isSelectedStockGain =true;
                    //getUpdatedNumbers

                }

                break;
            case R.id.lvStock:

                if(lvselectedStock==0)
                {
                    lvStock.setText("Invested Amount");
                    //getUpdatedNumbers
                    lvselectedStock =1;

                }
                else if(lvselectedStock ==1){
                    lvStock.setText("Quantity");
                    lvselectedStock =2;

                }
                else{
                    lvStock.setText("Latest Value");
                    lvselectedStock =0;

                }

                break;
            case R.id.daysgainMf:

                if(isSelectedMFGain)
                {
                    daysgainMf.setText("Days Gain");
                    //getUpdatedNumbers
                    isSelectedMFGain =false;

                }
                else{
                    daysgainMf.setText("Total Gain");
                    isSelectedMFGain =true;
                    //getUpdatedNumbers

                }
                break;
            case R.id.lvMf:
                if(isSelectedMFLv)
                {
                    lvMf.setText("latest Value");
                    //getUpdatedNumbers
                    isSelectedMFLv =false;

                }
                else{
                    lvMf.setText("Invested Amount");
                    isSelectedMFLv =true;
                    //getUpdatedNumbers

                }
                break;

        }

    }
}