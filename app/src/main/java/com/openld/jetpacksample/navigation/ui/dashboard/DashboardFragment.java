package com.openld.jetpacksample.navigation.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.openld.jetpacksample.R;

public class DashboardFragment extends Fragment implements View.OnClickListener {
    private TextView mTxtDashboard;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mTxtDashboard = view.findViewById(R.id.text_dashboard);
        mTxtDashboard.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == mTxtDashboard.getId()) {
            Toast.makeText(getActivity(), "点击了Dashboard Fragment", Toast.LENGTH_LONG).show();
        }
    }
}