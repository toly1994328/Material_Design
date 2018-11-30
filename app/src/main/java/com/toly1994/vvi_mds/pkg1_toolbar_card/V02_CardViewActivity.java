package com.toly1994.vvi_mds.pkg1_toolbar_card;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.ImageView;

import com.toly1994.vvi_mds.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class V02_CardViewActivity extends AppCompatActivity {

    @BindView(R.id.id_cv)
    CardView mIdCv;
    @BindView(R.id.id_img)
    ImageView mIdImg;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2_card);
        ButterKnife.bind(this);
        mIdCv.setOnClickListener(v -> runAnima());
    }

    private void runAnima() {
        mIdCv.animate().translationX(100 + count).setDuration(1000).start();
        count += 10;
    }
}
