package com.toly1994.vvi_mds.pkg2_fab_sna_sheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toly1994.vvi_mds.R;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/11/29 0029:13:01<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class MyBSDFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.a_pome_item, container, false);
    }

}
