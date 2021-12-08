package edu.neu.madcourse.numad21fa_zuochengwang;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class URL_View_Adapter extends RecyclerView.Adapter<URL_View_Holder>  {

    private final ArrayList<Link_Item_Card> URL_itemList;
    private ItemClickerListener listener;

    //Constructor
    public URL_View_Adapter(ArrayList<Link_Item_Card> URL_List) {
        this.URL_itemList = URL_List;
    }

    public void setOnItemClickListener(ItemClickerListener listener) {
        this.listener = listener;
    }

    @Override
    public URL_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.link_item_card, parent, false);
        return new URL_View_Holder(view, listener);
    }

    @Override
    public void onBindViewHolder(URL_View_Holder holder, int position) {
        Link_Item_Card currentItem = URL_itemList.get(position);

        holder.itemIcon.setImageResource(currentItem.getImage());
        holder.web_Name.setText(currentItem.getWebName());
        holder.URL_text.setText(currentItem.getURL());
    }

    @Override
    public int getItemCount() {
        return URL_itemList.size();
    }
}
