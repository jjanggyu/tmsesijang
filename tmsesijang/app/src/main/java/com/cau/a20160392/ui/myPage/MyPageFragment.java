package com.cau.a20160392.ui.myPage;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cau.a20160392.R;

public class MyPageFragment extends Fragment {

    private MyPageViewModel mViewModel;
    Button button1;
    Button button2;
    Button button3;

    public static MyPageFragment newInstance() {
        return new MyPageFragment();
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile,container,false);
        getChildFragmentManager().beginTransaction().add(R.id.child_fragment, new child1_mywhere()).commit();

        button1 = (Button)v.findViewById(R.id.button1);
        button2 = (Button)v.findViewById(R.id.button2);
        button3 = (Button)v.findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new child1_mywhere()).commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new child2_myphoto()).commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment, new child3_favorites()).commit();
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MyPageViewModel.class);
        // TODO: Use the ViewModel
    }

}
