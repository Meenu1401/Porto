package com.example.myapplication.ui.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPortfolioBinding;
import com.example.myapplication.ui.AppPreference;

public class PortfolioFragment extends Fragment {

    private PortfolioViewModel portfolioViewModel;
    private FragmentPortfolioBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        portfolioViewModel = new ViewModelProvider(this).get(PortfolioViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPortfolioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        portfolioViewModel.getText().observe(getViewLifecycleOwner(), s -> {
            if (!AppPreference.getInstance().getString(AppPreference.USER_NAME).isEmpty() &&
                    !AppPreference.getInstance().getString(AppPreference.PASSWORD).isEmpty()){
                //do nothing need to bind view on same fragment
                navController.navigate(R.id.action_navigation_portfolio_to_navigation_detail);
            }
            else {
                navController.navigate(R.id.action_navigation_portfolio_to_login_fragment2);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}