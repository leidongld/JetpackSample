package com.openld.jetpacksample.navigation.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.openld.jetpacksample.R;


public class NotificationsFragment extends Fragment implements View.OnClickListener {
    private TextView mTxtNotifications;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        mTxtNotifications = view.findViewById(R.id.text_notifications);
        mTxtNotifications.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == mTxtNotifications.getId()) {
            Toast.makeText(getActivity(), "点击了Notifications Fragment", Toast.LENGTH_LONG).show();
        }
    }
}