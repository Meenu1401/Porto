package com.example.myapplication.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentPortfolioBinding;
import com.example.myapplication.databinding.LoginforgotpassBinding;
import com.example.myapplication.databinding.LoginpageBinding;


public class ForgotPassFragment extends Fragment {

    private LoginforgotpassBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = LoginforgotpassBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        binding.sendCode.setOnClickListener(v->{
            navController.navigate(R.id.action_forgot_fragment_to_reset_password_fragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}