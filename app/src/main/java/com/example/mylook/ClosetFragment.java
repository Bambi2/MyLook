package com.example.mylook;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ClosetFragment extends Fragment{
    Fragment childFragment;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_closet, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        insertNestedFragment();
    }

    public void insertNestedFragment() {
        Fragment childFragment = new ShkafButtons();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container, childFragment).commit();
    }
    public void swapnizlist() {
        Fragment childFragment = new NizList();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container, childFragment).commit();
    }

    public static class ShkafButtons extends Fragment{
        ImageView nizButton;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_shkaf_buttons, container, false);
            nizButton = (ImageView) view.findViewById(R.id.niz);
            nizButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClosetFragment parentfrag=((ClosetFragment)ShkafButtons.this.getParentFragment());
                    parentfrag.swapnizlist();
                    /*FragmentManager manager = getChildFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.child_fragment_container, new NizList());
                    transaction.commit();*/
                }
            });
            return view;
        }
    }

    public static class NizList extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_niz_list, container, false);
        }
    }
}