package cn.vacuumflask.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import cn.vacuumflask.databindingdemo.databinding.ActivityMovieLayoutBinding;

/**
 * Created by Administrator on 2016/12/2 0002.
 *
 */
public class MovieActivity extends AppCompatActivity {

    private String TAG = MovieActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMovieLayoutBinding layoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_layout);
        layoutBinding.recyclerView.setHasFixedSize(true);
        layoutBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList<Movie> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Movie movie = new Movie("123", "测试", "1994", R.mipmap.icon_one, 7);
            list.add(movie);
        }
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(list);
        layoutBinding.recyclerView.setAdapter(adapter);
        list.get(0).setName("修改过的");
        list.add(new Movie("123", "新增加", "1994", R.mipmap.icon_one, 7));
        list.add(new Movie("123", "新增加", "1994", R.mipmap.icon_one, 7));
        list.add(new Movie("123", "新增加", "1994", R.mipmap.icon_one, 7));

        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void setOnItemClickListener(View view) {
                Integer tag = (Integer) view.getTag();
                Log.i(TAG, "setOnItemClickListener: " + tag);
                list.get(tag).setName("点击事件");
            }
        });
    }
}
