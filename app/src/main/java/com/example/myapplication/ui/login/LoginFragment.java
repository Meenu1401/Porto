package com.example.myapplication.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.LoginpageBinding;
import com.example.myapplication.ui.portfolio.PortfolioViewModel;


public class LoginFragment extends Fragment {

    public static String LOGIN_SUCCESSFUL = "LOGIN_SUCCESSFUL";
    private PortfolioViewModel portfolioViewModel;
    private SavedStateHandle savedStateHandle;
    private LoginpageBinding binding;
    private NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = LoginpageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        portfolioViewModel = new ViewModelProvider(requireActivity()).get(PortfolioViewModel.class);
        savedStateHandle = Navigation.findNavController(view)
                .getPreviousBackStackEntry()
                .getSavedStateHandle();
        savedStateHandle.set(LOGIN_SUCCESSFUL, false);
        navController = Navigation.findNavController(view);
        binding.loginBtn.setOnClickListener(v -> {
            String username = binding.edit1.getText().toString();
            String password = binding.edit2.getText().toString();
            login(username, password);
        });

        binding.signup.setOnClickListener(v->{
            navController.navigate(R.id.action_login_fragment_to_signup_fragment);
        });

        binding.forgotPass.setOnClickListener(v->{
            navController.navigate(R.id.action_login_fragment_to_forgot_fragment2);
        });
    }

    private void login(String username, String password) {
        portfolioViewModel.login(username, password).observe(getViewLifecycleOwner(), result -> {
            if (result) {
                savedStateHandle.set(LOGIN_SUCCESSFUL, true);
                NavHostFragment.findNavController(this).popBackStack();
               // navController.navigate(R.id.action_login_fragment_to_navigation_portfolio_detail);
            } else {
                showErrorMessage();
            }
        });
    }

    private void showErrorMessage() {
        Toast.makeText(requireContext(),"Enter credentials", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
     }
}