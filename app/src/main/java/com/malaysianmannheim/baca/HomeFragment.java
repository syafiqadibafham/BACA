package com.malaysianmannheim.baca;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    ImageView castle1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragments_home, container, false);
        // open castle1 Activity
        castle1 = (ImageView) rootView.findViewById(R.id.castle1ImageView);
        castle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail(v);
            }
        });
        return rootView;
    }
    public void updateDetail(View v)
    {
        Intent intent = new Intent(getActivity(), Castle1Activity.class);
        startActivity(intent);
    }
}

