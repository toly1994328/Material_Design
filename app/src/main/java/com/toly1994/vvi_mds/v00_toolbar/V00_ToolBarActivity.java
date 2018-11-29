package com.toly1994.vvi_mds.v00_toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.toly1994.test.ToastUtil;
import com.toly1994.vvi_mds.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V00_ToolBarActivity extends AppCompatActivity {


    @BindView(R.id.my_tb)
    Toolbar mMyTb;
    @BindView(R.id.my_tb2)
    Toolbar mMyTb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a0_toolbar);
        ButterKnife.bind(this);

        setSupportActionBar(mMyTb);//不加这句无菜单!!!
//        setSupportActionBar(mMyTb2);//不加这句无菜单!!!
    }

    //菜单栏点击
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tool_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_add:
                ToastUtil.showAtOnce(V00_ToolBarActivity.this, "tab_add");
                return true;

            case R.id.tab_mode_fixed:
                ToastUtil.showAtOnce(V00_ToolBarActivity.this, "tab_mode_fixed");

                return true;

            case R.id.tab_mode_scrollable:
                ToastUtil.showAtOnce(V00_ToolBarActivity.this, "tab_mode_scrollable");

                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
