//package com.toly1994.vvi_mds.v02_card;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.widget.ImageView;
//import android.widget.ListView;
//
//import com.lzy.okgo.OkGo;
//import com.lzy.okgo.cache.CacheMode;
//import com.lzy.okgo.callback.StringCallback;
//import com.lzy.okgo.model.Response;
//import com.squareup.picasso.Picasso;
//import com.toly1994.vvi_mds.R;
//import com.toly1994.vvi_mds.app.Cons;
//
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import top.toly.zutils.core.shortUtils.ToastUtil;
//import top.toly.zutils.core.test.DataUtils;
//import top.toly.zutils.view.listview.ev.MyLVAdapter;
//import top.toly.zutils.view.listview.ev.MyLVHolder;
//
//public class V02_CardPomeActivity extends AppCompatActivity {
//    private static final String TAG = "V02_CardPomeActivity";
//
//    @BindView(R.id.id_lv_poem)
//    ListView mIdLvPoem;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pome);
//        ButterKnife.bind(this);
//        ArrayList<String> names = DataUtils.getRandomName(10, true);
//
//        OkGo.getInstance().init(getApplication());
//        OkGo.<String>get(Cons.LIST_ALL)
//                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)//设置缓存模式
//                .cacheKey("poem")//作为缓存的key
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        Log.d(TAG, "onSuccess: " + response.body());
//                        Poem poem = Poem.objectFromData(response.body());
//                        ToastUtil.show(V02_CardPomeActivity.this, poem.getData().get(0).getAuthor());
//
//                        mIdLvPoem.setAdapter(new MyLVAdapter<Poem.DataBean>(V02_CardPomeActivity.this, poem.getData(), R.layout.a_pome_item) {
//                            @Override
//                            public void setData(MyLVHolder holder, Poem.DataBean data, int position) {
//                                holder.setText(R.id.tv_author, data.getAuthor())
//                                        .setText(R.id.tv_info, data.getInfo())
//                                        .setText(R.id.iv_tv_title, data.getTitle());
//
//                                ImageView imageView = holder.getView(R.id.iv_cover);
//                                Picasso.get()
//                                        .load(Cons.BASE_IMG_URL + data.getImgURL())
//                                        .into(imageView);
//                            }
//                        });
//
//                    }
//                });
//
//
//    }
//
//}
