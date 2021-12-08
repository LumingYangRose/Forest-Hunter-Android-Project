package edu.neu.madcourse.numad21fa_zuochengwang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class LinkCollectorActivity extends AppCompatActivity {

    private ArrayList<Link_Item_Card> itemList = new ArrayList<>();

    private RecyclerView recyclerView;
    private URL_View_Adapter URL_viewAdapter;
    private RecyclerView.LayoutManager rLayoutManger;
    private FloatingActionButton Add_URL_Button;

    private static final String KEY = "KEY";
    private static final String NUMBER_OF_WEB_URL = "NUMBER_OF_WEB_URL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_collector);

        init(savedInstanceState);

        Add_URL_Button = findViewById(R.id.Add_URL_Button);
        Add_URL_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ask_url_dialog(v);
                    URL_viewAdapter.notifyDataSetChanged();
                }
        });



        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                Toast.makeText(LinkCollectorActivity.this, "A Web URL has been deleted", Toast.LENGTH_SHORT).show();
                int position = viewHolder.getLayoutPosition();
                itemList.remove(position);

                URL_viewAdapter.notifyItemRemoved(position);

            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {


        int size = itemList == null ? 0 : itemList.size();
        outState.putInt(NUMBER_OF_WEB_URL, size);

        for (int i = 0; i < size; i++) {
            outState.putInt(KEY + i + "0", itemList.get(i).getImage());
            outState.putString(KEY + i + "1", itemList.get(i).getWebName());
            outState.putString(KEY + i + "2", itemList.get(i).getURL());
        }
        super.onSaveInstanceState(outState);

    }

    private void init(Bundle savedInstanceState) {

        initialItemData(savedInstanceState);
        createRecyclerView();
    }

    private void initialItemData(Bundle savedInstanceState) {

        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_WEB_URL)) {
            if (itemList == null || itemList.size() == 0) {

                int size = savedInstanceState.getInt(NUMBER_OF_WEB_URL);

                for (int i = 0; i < size; i++) {
                    Integer imgId = savedInstanceState.getInt(KEY + i + "0");
                    String webName = savedInstanceState.getString(KEY + i + "1");
                    String URL = savedInstanceState.getString(KEY + i + "2");

                    Link_Item_Card Link_itemCard = new Link_Item_Card(imgId, webName, URL);

                    itemList.add(Link_itemCard);
                }
            }
        }

        else {
            Link_Item_Card initial_item1 = new Link_Item_Card(R.drawable.pic_neu, "Northeastern University", "https://www.northeastern.edu/");
            Link_Item_Card initial_item2 = new Link_Item_Card(R.drawable.pic_chelsea, "Chelsea Soccer Club", "https://www.chelseafc.com/en");
            Link_Item_Card initial_item3 = new Link_Item_Card(R.drawable.pic_gamestop, "GameStop", "https://www.gamestop.com/search/?q=fifa+22&gclid=CjwKCAjwhuCKBhADEiwA1HegOdqiohHdt9pdS7P1geOFPXx_5etgkEfLVLMrsqJzqjfirLwjVlXZdxoCJJYQAvD_BwE&gclsrc=aw.ds");
            itemList.add(initial_item1);
            itemList.add(initial_item2);
            itemList.add(initial_item3);
        }

    }

    private void createRecyclerView() {


        rLayoutManger = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        URL_viewAdapter = new URL_View_Adapter(itemList);
        ItemClickerListener itemClickerListener = new ItemClickerListener() {
            @Override
            public void onItemClick(int position) {

                URL_viewAdapter.notifyItemChanged(position);
                String URL_temp = itemList.get(position).getURL();
                goto_website(URL_temp);
            }
        };

        URL_viewAdapter.notifyDataSetChanged();
        URL_viewAdapter.setOnItemClickListener(itemClickerListener);
        recyclerView.setAdapter(URL_viewAdapter);
        recyclerView.setLayoutManager(rLayoutManger);


    }

    private void addItem(int position, String web_name, String URL) {
        boolean is_validate = this.Url_validator(URL);
        //boolean is_validate = true;

        if (is_validate == true) {

            itemList.add(position, new Link_Item_Card(R.drawable.pic_no_web_img, web_name, URL));
            URL_viewAdapter.notifyItemInserted(position);
            URL_viewAdapter.notifyDataSetChanged();

            //Toast.makeText(LinkCollectorActivity.this, "Web has been added", Toast.LENGTH_SHORT).show();
            snackbar("Web has been added");
        } else {
            //Toast.makeText(LinkCollectorActivity.this, "URL is not valid", Toast.LENGTH_SHORT).show();
            snackbar("URL is not valid");
        }
    }

    public void ask_url_dialog(View view) {
        final AlertDialog.Builder dialog;
        final EditText input_web_name;
        final EditText input_url_name;
        Button input_cancel_button;
        Button input_confirm_button;
        final AlertDialog alert_dialog;

        dialog = new AlertDialog.Builder(LinkCollectorActivity.this);
        View dialog_view = getLayoutInflater().inflate(R.layout.ask_name_url, null);

        input_web_name = dialog_view.findViewById(R.id.enter_web_name_input_box);
        input_url_name = dialog_view.findViewById(R.id.enter_URL_input_box);

        input_cancel_button = dialog_view.findViewById(R.id.url_cancel_button);
        input_confirm_button = dialog_view.findViewById(R.id.url_confirm_button);

        dialog.setView(dialog_view);
        alert_dialog = dialog.create();

        alert_dialog.setCanceledOnTouchOutside(false);

        input_cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert_dialog.dismiss();
            }
        });

        input_confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = 0;
                String web_name_temp = input_web_name.getText().toString();
                String url_temp = input_url_name.getText().toString();
                addItem(pos, web_name_temp,url_temp);
                alert_dialog.dismiss();
            }
        });

        alert_dialog.show();
    }

    public boolean Url_validator(String URL_address)
    {
        String temp_string;
        try{
            temp_string = URL_address;
            new URL(temp_string).openConnection();
            return true;
        } catch(MalformedURLException exception)
        {
            return false;
        } catch (IOException e) {
            return false;
        }

    }

    public void goto_website(String URL) {
        if (! URL.substring(0,8).equals("https://")) {
            String temp_string = "https://" + URL;
            URL = temp_string;
        }

        Intent web_url_address = new Intent( Intent.ACTION_VIEW , Uri.parse( URL ) );
        startActivity( web_url_address );
    }

    public void snackbar(String notification) {

        Snackbar snackbar = Snackbar.make(findViewById(R.id.link_collector_activity), notification, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
