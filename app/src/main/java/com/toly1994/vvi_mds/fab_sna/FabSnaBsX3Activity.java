package com.toly1994.vvi_mds.fab_sna;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.toly1994.test.L;
import com.toly1994.test.ToastUtil;
import com.toly1994.vvi_mds.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FabSnaBsX3Activity extends AppCompatActivity {

    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.cl_root)
    CoordinatorLayout mClRoot;
    @BindView(R.id.bottom_sheet)
    LinearLayout mBottomSheet;
    private BottomSheetBehavior<LinearLayout> mBottomSheetBehavior;

    private boolean isOpen;
    private BottomSheetDialog mBottomSheetDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        ButterKnife.bind(this);

        mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                ToastUtil.showAtOnce(FabSnaBsX3Activity.this, "newState:" + newState);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                L.d(slideOffset + L.l());//slideOffset：移动的分度值
            }
        });


        mFab.setOnClickListener(v -> {
//            playBottomSheet();
//            playBottomSheetDialog();
            new MyBSDFragment().show(getSupportFragmentManager(), "toly");
            showSnackbar();
        });

    }

    private void playBottomSheetDialog() {
        mBottomSheetDialog = new BottomSheetDialog(this);
        mBottomSheetDialog.setContentView(R.layout.a_pome_item);
        mBottomSheetDialog.show();
    }


    private void playBottomSheet() {
        if (isOpen) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
        isOpen = !isOpen;
    }

    private void showSnackbar() {
        Snackbar snackbar = Snackbar.make(mClRoot, "Hello Snack", Snackbar.LENGTH_LONG);
        ViewGroup view = (ViewGroup) snackbar.getView();
        view.setBackgroundColor(0xffffffff);
        view.removeAllViews();//清除原来的View
        View child = LayoutInflater.from(this).inflate(R.layout.item_of_base, view, false);
        view.addView(child);//添加自己的View
        snackbar.show();
    }


}
