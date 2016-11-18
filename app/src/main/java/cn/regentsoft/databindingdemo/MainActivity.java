package cn.regentsoft.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.regentsoft.databindingdemo.databinding.MainActivityLayoutBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityLayoutBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.main_activity_layout);
        User user = new User("测试人员", "21");
        viewDataBinding.setUser(user);
    }
}
