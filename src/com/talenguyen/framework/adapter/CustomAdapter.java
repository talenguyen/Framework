package com.talenguyen.framework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GIANG on 12/18/13.
 */
public class CustomAdapter<T> extends BaseAdapter {

    private List<T> mItems;
    private LayoutInflater mInflater;
    private int layoutId;
    private ViewHolderFactory<T> viewHolderFactory;

    /**
     * Constructor to create a new CustomAdapter object
     * @param context The context
     * @param layoutId The layout id. That will be use to present for a list item.
     * @param viewHolderFactory The {@link com.talenguyen.framework.adapter.CustomAdapter.ViewHolderFactory} object that will create ViewHolder.
     */
    public CustomAdapter(Context context, int layoutId, ViewHolderFactory<T> viewHolderFactory) {
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutId = layoutId;
        this.viewHolderFactory = viewHolderFactory;
    }

    public void add(T item) {
        if (mItems == null) {
            mItems = new ArrayList<T>();
        }
        mItems.add(item);
    }

    public void swapData(List<T> newData) {
        mItems = newData;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mItems == null) {
            return 0;
        }
        return mItems.size();
    }

    @Override
    public T getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mInflater.inflate(layoutId, viewGroup, false);
            ViewHolder<T> viewHolder = viewHolderFactory.newViewHolder();
            viewHolder.findView(view);
            view.setTag(viewHolder);
        }
        @SuppressWarnings("unchecked")
		ViewHolder<T> viewHolder = (ViewHolder<T>) view.getTag();
        viewHolder.bindView(getItem(i));
        return view;
    }

    public static abstract class ViewHolder<T> {
        /**
         * Where you can find all view that is held by ViewHolder
         * @param parent
         */
        public abstract void findView(View parent);

        /**
         * Where you bind data for the ViewHolder
         * @param item
         */
        public abstract void bindView(T item);
    }

    public static abstract class ViewHolderFactory<T> {
        /**
         * Factory method to create a ViewHolder object
         * @return {@link com.talenguyen.framework.adapter.CustomAdapter.ViewHolder}
         */
        public abstract ViewHolder<T> newViewHolder();
    }
}
