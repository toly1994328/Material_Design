package com.toly1994.vvi_mds.v01_tab;

import android.os.Bundle;
import android.view.View;

import com.toly1994.test.base.BaseV4Fragment;
import com.toly1994.vvi_mds.R;



public class V01_ContentV4Fragment extends BaseV4Fragment {
    /**
     *
     * @param str Activity向Fragment的数据
     * @return ViewPagerFragment对象
     */
    public static V01_ContentV4Fragment newInstance(String str) {
        Bundle arguments = new Bundle();
        arguments.putString("name_data", str);
        V01_ContentV4Fragment instance = new V01_ContentV4Fragment();
        instance.setArguments(arguments);
        return instance;
    }

    @Override
    protected void render(View rootView) {

        String name = getArguments().getString("name_data");
        setTextView(R.id.tv_content, name);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fg_v01_tab_content;
    }
}
