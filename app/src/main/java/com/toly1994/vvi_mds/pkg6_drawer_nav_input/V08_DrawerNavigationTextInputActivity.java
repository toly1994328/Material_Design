package com.toly1994.vvi_mds.pkg6_drawer_nav_input;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.toly1994.test.L;
import com.toly1994.test.ToastUtil;
import com.toly1994.vvi_mds.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V08_DrawerNavigationTextInputActivity extends AppCompatActivity {


    @BindView(R.id.id_dl_root)
    DrawerLayout mIdDlRoot;
    @BindView(R.id.id_ll_right)
    LinearLayout mIdLlLeft;
    @BindView(R.id.id_tb_top)
    Toolbar mIdTbTop;
    @BindView(R.id.id_nv_root)
    NavigationView mIdNvRoot;
    @BindView(R.id.id_til_user_name)
    TextInputLayout mIdTilUserName;
    @BindView(R.id.et_user_name)
    EditText mEtUserName;
    private ActionBarDrawerToggle mABDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawlayout);
        ButterKnife.bind(this);

        testNavigationView();

        mIdTilUserName.setCounterEnabled(true);
        mIdTilUserName.setCounterMaxLength(5);

        mEtUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int len = s.length();
                if (len > 5) {
                    mIdTilUserName.setError("超过最大值:5");
                } else {
                    mIdTilUserName.setErrorEnabled(false);
                }

            }
        });
//        testDrawerLayoutListener();

    }

    /**
     * DrawerLayout监听成测试
     */
    private void testDrawerLayoutListener() {
        mIdDlRoot.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
//                L.d("onDrawerSlide：" + slideOffset + L.l());//0~1
                mIdLlLeft.setRotation(360 * slideOffset);

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                ToastUtil.showAtOnce(V08_DrawerNavigationTextInputActivity.this, "onDrawerOpened");

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                ToastUtil.showAtOnce(V08_DrawerNavigationTextInputActivity.this, "onDrawerClosed");

                //关闭后时关闭手势滑动
                //mIdDlRoot.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                L.d("onDrawerStateChanged：" + newState + L.l());
                //STATE_IDLE--------0----空闲状态
                //STATE_DRAGGING----1---手指在触摸滑动
                //STATE_SETTLING----1---无手指在触摸仍在滑动
            }
        });
    }

    private void testNavigationView() {
        setSupportActionBar(mIdTbTop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示按钮
        mABDT = new ActionBarDrawerToggle(
                this, mIdDlRoot, mIdTbTop, R.string.str_open, R.string.str_close);
        mIdDlRoot.addDrawerListener(mABDT);

        mIdNvRoot.setNavigationItemSelectedListener(item -> {
            String res = "";
            switch (item.getItemId()) {
                case R.id.icon_a:
                    res = "about";
                    break;
                case R.id.icon_b:
                    res = "before";
                    break;
                case R.id.icon_c:
                    res = "card";
                    break;
                case R.id.icon_d:
                    res = "dall";
                    break;
                case R.id.icon_x:
                    res = "xor";
                    break;
                case R.id.icon_y:
                    res = "yes";
                    break;
                case R.id.icon_z:
                    res = "zone";
                    break;
            }

            ToastUtil.showAtOnce(this, res);
            return false;
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mABDT.syncState();//加了这个才有酷炫的按钮变化
    }


}
