package eduardobachiega.udacitytourguideapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import eduardobachiega.udacitytourguideapp.R;
import eduardobachiega.udacitytourguideapp.model.MenuItem;

/**
 * Created by bachiega on 02/09/17.
 */

public class MenuRecyclerAdapter extends RecyclerView.Adapter<MenuRecyclerAdapter
        .MenuItemViewHolder> {
    static OnItemClickListener mItemClickListener;
    static OnItemLongClickListener mItemLongClickListener;
    List<MenuItem> items;

    public MenuRecyclerAdapter(List<MenuItem> items) {
        this.items = items;
    }

    @Override
    public MenuItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.menu_item, parent, false);

        return new MenuItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MenuItemViewHolder holder, int position) {
        MenuItem item = items.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvDescription.setText(item.getDescription());
        holder.ivIcon.setImageResource(item.getImageResource());
    }

    public static class MenuItemViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener, View.OnLongClickListener {
        ImageView ivIcon;
        TextView tvTitle, tvDescription;

        MenuItemViewHolder(View itemView) {
            super(itemView);
            tvTitle = ButterKnife.findById(itemView, R.id.tvTitle);
            tvDescription = ButterKnife.findById(itemView, R.id.tvDescription);
            ivIcon = ButterKnife.findById(itemView, R.id.ivIcon);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null)
                mItemClickListener.onItemClick(v, getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            if (mItemLongClickListener != null)
                mItemLongClickListener.onItemLongClick(v, getAdapterPosition());
            return true;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setOnItemLongClickListener(final OnItemLongClickListener mItemLongClickListener) {
        this.mItemLongClickListener = mItemLongClickListener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
