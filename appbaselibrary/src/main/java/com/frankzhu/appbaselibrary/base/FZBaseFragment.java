package com.frankzhu.appbaselibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frankzhu.appbaselibrary.utils.FZSharedPreferencesHelper;

import butterknife.ButterKnife;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      16/1/25  下午2:28.
 * Description: Fragment 基类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 16/1/25        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public abstract class FZBaseFragment extends Fragment {
    protected final String TAG = getClass().getSimpleName();
    protected FZSharedPreferencesHelper mFZSharedPreferencesHelper;

    protected abstract int getFragmentLayoutRes();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFZSharedPreferencesHelper = FZSharedPreferencesHelper.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getFragmentLayoutRes(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
