package com.example.myapplication.ui.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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




public class PortfolioDetailFragment extends Fragment {

    private FragmentPortfolioDetailBinding binding;
    private CardView cardviewSummaryList, cardviewMFList, cardviewStockList;
    private boolean isSelected = true;

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
        simpleProgressBar= view.findViewById(R.id.simpleProgressBar);

        cardviewSummaryList= view. findViewById(R.id.cardviewSummaryList);
        cardviewSummaryList.setVisibility(View.GONE);
        cardviewStockList= view. findViewById(R.id.cardviewStockList);
        cardviewStockList.setVisibility(View.GONE);
        cardviewMFList= view. findViewById(R.id.cardviewMFList);
        cardviewMFList.setVisibility(View.GONE);




        getTopTable();
        getStockTable();
        getMFTable();
        binding.daysGain.setOnClickListener(view1 -> {
            if(isSelected){

            }else{

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getTopTable() {
        Call<Items> call = RetrofitClient.getInstance().getMyApi().getTopTable();

        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                cardviewSummaryList.setVisibility(View.VISIBLE);



                Items myheroList = response.body();
                SummaryDataAdapter adapter = new SummaryDataAdapter(myheroList.getList());
                binding.recyclerTop.setHasFixedSize(true);
                binding.recyclerTop.setLayoutManager(new LinearLayoutManager(requireContext()));
                binding.recyclerTop.setAdapter(adapter);
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


private ProgressBar simpleProgressBar;
    private void setProgressValue(final int progress) {

        // set the progress
        simpleProgressBar.setProgress(progress);
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 10);
            }
        });
        thread.start();
    }

}