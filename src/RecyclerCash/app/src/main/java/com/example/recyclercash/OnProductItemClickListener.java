package com.example.recyclercash;

import android.view.View;

public interface OnProductItemClickListener {
    public void onItemClick(ProductAdater.ViewHolder holer,
                            View view,
                            int position);
}
