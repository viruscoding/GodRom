package com.god.godmanager.ui.abort;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.god.godmanager.Common.FileHelper;
import com.god.godmanager.databinding.FragmentAbortBinding;
import com.god.godmanager.databinding.FragmentGlobalSettingBinding;

public class AbortFragment extends Fragment {

    private AbortViewModel abortViewModel;
    private FragmentAbortBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        abortViewModel =
                new ViewModelProvider(this).get(AbortViewModel.class);

        binding = FragmentAbortBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}