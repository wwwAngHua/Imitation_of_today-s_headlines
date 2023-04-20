package com.today.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<NewsBean> NewsList;

    public NewsAdapter(Context context, List<NewsBean> NewsList) {
        this.mContext = context;
        this.NewsList = NewsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = null;
        RecyclerView.ViewHolder holder = null;
        if (viewType == 1) {
            itemView = LayoutInflater.from(mContext).inflate(R.layout.list_item_one, parent, false);
            holder = new MyViewHolder1(itemView);
        } else if (viewType == 2) {
            itemView = LayoutInflater.from(mContext).inflate(R.layout.list_item_two, parent, false);
            holder = new MyViewHolder2(itemView);
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return NewsList.get(position).getType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsBean bean = NewsList.get(position);
        if (holder instanceof MyViewHolder1) {
            if (position == 0) {
                ((MyViewHolder1) holder).top_img.setVisibility(View.VISIBLE);
                ((MyViewHolder1) holder).img.setVisibility(View.GONE);
            } else {
                ((MyViewHolder1) holder).top_img.setVisibility(View.GONE);
                ((MyViewHolder1) holder).img.setVisibility(View.VISIBLE);
            }
            ((MyViewHolder1) holder).title.setText(bean.getTitle());
            ((MyViewHolder1) holder).author.setText(bean.getName());
            ((MyViewHolder1) holder).pl.setText(bean.getComment());
            ((MyViewHolder1) holder).time.setText(bean.getTime());
            if (bean.getImgList().size() == 0) return;
            ((MyViewHolder1) holder).img.setImageResource(bean.getImgList().get(0));
        } else if (holder instanceof MyViewHolder2) {
            ((MyViewHolder2) holder).title.setText(bean.getTitle());
            ((MyViewHolder2) holder).author.setText(bean.getName());
            ((MyViewHolder2) holder).pl.setText(bean.getComment());
            ((MyViewHolder2) holder).time.setText(bean.getTime());
            ((MyViewHolder2) holder).img_1.setImageResource(bean.getImgList().get(0));
            ((MyViewHolder2) holder).img_2.setImageResource(bean.getImgList().get(1));
            ((MyViewHolder2) holder).img_3.setImageResource(bean.getImgList().get(2));
        }
    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {
        ImageView top_img, img;
        TextView title, author, pl, time;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            top_img = itemView.findViewById(R.id.top_img);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            pl = itemView.findViewById(R.id.pl);
            time = itemView.findViewById(R.id.time);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder {
        ImageView img_1, img_2, img_3;
        TextView title, author, pl, time;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            img_1 = itemView.findViewById(R.id.img_1);
            img_2 = itemView.findViewById(R.id.img_2);
            img_3 = itemView.findViewById(R.id.img_3);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            pl = itemView.findViewById(R.id.pl);
            time = itemView.findViewById(R.id.time);
        }
    }
}
