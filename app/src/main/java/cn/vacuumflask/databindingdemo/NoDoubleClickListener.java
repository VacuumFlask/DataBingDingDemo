package cn.vacuumflask.databindingdemo;

import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/12/2 0002.
 * 防止多次点击
 */
public abstract class NoDoubleClickListener implements View.OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;

    protected abstract void onNoDoubleClick(View view);

    @Override
    public void onClick(View view) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNoDoubleClick(view);
        } else {
            Toast.makeText(view.getContext(), "不要点这么多次", Toast.LENGTH_SHORT).show();
        }
    }
}
