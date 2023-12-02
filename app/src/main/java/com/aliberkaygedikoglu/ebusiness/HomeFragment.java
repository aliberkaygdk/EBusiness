package com.aliberkaygedikoglu.ebusiness;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aliberkaygedikoglu.ebusiness.databinding.FragmentHomeBinding;
import com.aliberkaygedikoglu.ebusiness.databinding.FragmentSocketBinding;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);


        binding.nfc.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.goToDialog);

        });



        return binding.getRoot();
    }
    private void OnOffNFC() {
        NfcManager manager = (NfcManager) getContext().getSystemService(Context.NFC_SERVICE);
        NfcAdapter adapter = manager.getDefaultAdapter();
        if (adapter != null && adapter.isEnabled()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                Intent intent = new Intent(Settings.ACTION_NFC_SETTINGS);
                startActivity(intent);
            } else {
                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(intent);
            }
        } else {
            Toast.makeText(getContext(), "Your device not have NFC", Toast.LENGTH_SHORT).show();
        }
    }
}