package com.example.base_prjt;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class VievPaperAdaptet extends FragmentPagerAdapter {

    public VievPaperAdaptet(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem (int position) {
        FragmentA demoFragment = new FragmentA();
        position = position+1;
        Bundle bundle = new Bundle();
        bundle.putString("message", "Fragment: " +position) ;
        demoFragment.setArguments(bundle);
        return demoFragment;
    }
    @Override
    public int getCount() {
        return 4;
    }

}
