package cn.regentsoft.databindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.regentsoft.databindingdemo.databinding.ItemMovieLayoutBinding;

/**
 * Created by Administrator on 2016/12/2 0002.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> implements View.OnClickListener {

    private List<Movie> list;

    private OnItemClickListener onItemClickListener;

    public MyRecyclerViewAdapter(List<Movie> list) {
        this.list = list;
    }

    interface OnItemClickListener {
        void setOnItemClickListener(View view);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMovieLayoutBinding layoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_movie_layout, parent, false);
        View view = layoutBinding.getRoot();
        view.setOnClickListener(this);
        MyViewHolder holder = new MyViewHolder(view);
        holder.setLayoutBinding(layoutBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = list.get(position);
        holder.itemView.setTag(position);
        holder.layoutBinding.setMovie(movie);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.setOnItemClickListener(view);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ItemMovieLayoutBinding layoutBinding;

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public void setLayoutBinding(ItemMovieLayoutBinding layoutBinding) {
            this.layoutBinding = layoutBinding;
        }
    }
}
