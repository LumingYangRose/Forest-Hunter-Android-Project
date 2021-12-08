package edu.neu.madcourse.numad21fa_zuochengwang;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class URL_View_Holder extends RecyclerView.ViewHolder{

    public ImageView itemIcon;
    public TextView web_Name;
    public TextView URL_text;

    public URL_View_Holder(View itemView, final ItemClickerListener listener) {
        super(itemView);
        itemIcon = itemView.findViewById(R.id.item_icon);
        web_Name = itemView.findViewById(R.id.web_name);
        URL_text = itemView.findViewById(R.id.URL);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        listener.onItemClick(position);
                    }
                }
            }
        });
    }
}
