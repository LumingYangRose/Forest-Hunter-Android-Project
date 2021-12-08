package edu.neu.madcourse.numad21fa_zuochengwang;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServiceActivity extends AppCompatActivity {

    private TextView temp_view;
    private TextView city_view;
    private TextView weather_description_view;
    private TextView date_view;
    private TextView temp_range_view;
    private TextView humandity_wind_view;
    private Button Add_input_Button;
    public ImageView weather_icon_view;

    String zipcode;
    String city_name;
    String temperature;
    String high_temp;
    String low_temp;
    String icon_id;
    double temperature_F;
    double temperature_C;
    String weahter_description;
    int humidity;
    int wind;
    String feels_like_temp;
    String date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_weather);

        Add_input_Button = findViewById(R.id.enter_weather_input_button);
        Add_input_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ask_location_input_dialog(v);
            }
        });

        temp_view = findViewById(R.id.temp_view);
        city_view = findViewById(R.id.city_country_view);
        weather_description_view = findViewById(R.id.weather_description_view);
        date_view = findViewById(R.id.date_view);
        temp_range_view = findViewById(R.id.temp_range_view);
        humandity_wind_view = findViewById(R.id.humandity_wind);
        weather_icon_view = findViewById(R.id.weather_icon);

        city_name = "Boston";
        zipcode = "02115";
        city_view.setText("N/A");
        weather_description_view.setText("N/A");
        temp_view.setText("N/A");
        date_view.setText("N/A");
        temp_range_view.setText("");

        get_weather_by_zipcode(zipcode);


    }

    protected void get_weather_by_city_name(String input_city_name)
    {
        String web_address = "http://api.openweathermap.org/data/2.5/weather?q=" + input_city_name + ",us&appid=93dce0a3176480f442be61f06fd423a1&units=Imperial";
        StringRequest string_request = new StringRequest(Request.Method.POST, web_address, new Response.Listener<String>() {

            public void onResponse(String response)
            {
                try {

                    JSONObject Json_response = new JSONObject(response);
                    JSONArray jArray = Json_response.getJSONArray("weather");
                    JSONObject j_weather_Object = jArray.getJSONObject(0);
                    String General_weather = j_weather_Object.getString("main");
                    weahter_description = j_weather_Object.getString("description");
                    icon_id = j_weather_Object.getString("icon");
                    String icon_image_url = "http://openweathermap.org/img/wn/"+ icon_id +"@2x.png";

                    Load_Image image = new Load_Image(weather_icon_view);//todo
                    image.execute(icon_image_url);

                    JSONObject Json_main = Json_response.getJSONObject("main");
                    JSONObject Json_wind = Json_response.getJSONObject("wind");

                    temperature = String.valueOf(Json_main.getDouble("temp"));
                    feels_like_temp = String.valueOf(Json_main.getDouble("feels_like"));
                    high_temp = String.valueOf(Json_main.getDouble("temp_max"));
                    low_temp = String.valueOf(Json_main.getDouble("temp_min"));

                    humidity = Json_main.getInt("humidity");
                    wind = Json_wind.getInt("speed");

                    city_name = Json_response.getString("name");

                    city_view.setText("City:\n" + city_name);
                    weather_description_view.setText("Weather: " +weahter_description);


                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat date_format = new SimpleDateFormat("MM-dd-yyyy");
                    date = date_format.format(calendar.getTime());

                    date_view.setText("Date: " + date);
                    temperature_F = Double.parseDouble(temperature);
                    Double feels_like_temp_F = Double.parseDouble(feels_like_temp);
                    Double high_temp_F = Double.parseDouble(high_temp);
                    Double low_temp_F = Double.parseDouble(low_temp);
                    temperature_C =  (temperature_F - 32)/1.8000;
                    Double feels_like_temp_C = (feels_like_temp_F - 32)/1.8000;
                    Double high_temp_C = (high_temp_F - 32)/1.8000;
                    Double low_temp_C = (low_temp_F - 32)/1.8000;

                    temperature_F = Math.round(temperature_F);
                    int feels_like_temp_F_int = feels_like_temp_F.intValue();
                    int high_temp_F_int = high_temp_F.intValue();
                    int low_temp_F_int = low_temp_F.intValue();


                    temperature_C = Math.round(temperature_C);
                    int feels_like_temp_C_int = feels_like_temp_C.intValue();
                    int high_temp_C_int = high_temp_C.intValue();
                    int low_temp_C_int = low_temp_C.intValue();

                    int temperature_F_int = (int) temperature_F;

                    int temperature_C_int = (int) temperature_C;

                    temp_view.setText(String.valueOf(temperature_F_int) + " F\u00B0  /  " + String.valueOf(temperature_C_int) +" C\u00B0");
                    temp_range_view.setText("H: " +String.valueOf(high_temp_F_int) + " F\u00B0  /  " + String.valueOf(high_temp_C_int) +" C\u00B0"
                            + "\n" + "L: " +String.valueOf(low_temp_F_int) + " F\u00B0  /  " + String.valueOf(low_temp_C_int) +" C\u00B0");

                    humandity_wind_view.setText("Humidity: " + humidity +"%\n" + "Wind Speed: " +wind +" m/s"
                            +"\n" + "feels like: " + String.valueOf(feels_like_temp_F_int) + " F\u00B0  /  " + String.valueOf(feels_like_temp_C_int) +" C\u00B0");
                    snackbar("Updating");

                } catch(JSONException e)
                {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener()
        {
            public void onErrorResponse(VolleyError err)
            {
                snackbar("Error!");
            }
        }
        );

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(string_request);

        snackbar("Error!");

    }

    protected void get_weather_by_zipcode(String zipcode)
    {
        String web_address = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipcode + ",us&appid=93dce0a3176480f442be61f06fd423a1&units=Imperial";
        StringRequest string_request = new StringRequest(Request.Method.POST, web_address, new Response.Listener<String>() {

            public void onResponse(String response)
            {
                try {

                    JSONObject Json_response = new JSONObject(response);
                    JSONArray jArray = Json_response.getJSONArray("weather");
                    JSONObject j_weather_Object = jArray.getJSONObject(0);
                    String General_weather = j_weather_Object.getString("main");
                    weahter_description = j_weather_Object.getString("description");
                    icon_id = j_weather_Object.getString("icon");
                    String icon_image_url = "http://openweathermap.org/img/wn/"+ icon_id +"@2x.png";

                    Load_Image image = new Load_Image(weather_icon_view);//todo
                    image.execute(icon_image_url);

                    JSONObject Json_main = Json_response.getJSONObject("main");
                    JSONObject Json_wind = Json_response.getJSONObject("wind");

                    temperature = String.valueOf(Json_main.getDouble("temp"));
                    feels_like_temp = String.valueOf(Json_main.getDouble("feels_like"));
                    high_temp = String.valueOf(Json_main.getDouble("temp_max"));
                    low_temp = String.valueOf(Json_main.getDouble("temp_min"));

                    humidity = Json_main.getInt("humidity");
                    wind = Json_wind.getInt("speed");

                    city_name = Json_response.getString("name");

                    city_view.setText("City:\n" + city_name);
                    weather_description_view.setText("Weather: " +weahter_description);


                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat date_format = new SimpleDateFormat("MM-dd-yyyy");
                    date = date_format.format(calendar.getTime());

                    date_view.setText("Date: " + date);
                    temperature_F = Double.parseDouble(temperature);
                    Double feels_like_temp_F = Double.parseDouble(feels_like_temp);
                    Double high_temp_F = Double.parseDouble(high_temp);
                    Double low_temp_F = Double.parseDouble(low_temp);
                    temperature_C =  (temperature_F - 32)/1.8000;
                    Double feels_like_temp_C = (feels_like_temp_F - 32)/1.8000;
                    Double high_temp_C = (high_temp_F - 32)/1.8000;
                    Double low_temp_C = (low_temp_F - 32)/1.8000;

                    temperature_F = Math.round(temperature_F);
                    int feels_like_temp_F_int = feels_like_temp_F.intValue();
                    int high_temp_F_int = high_temp_F.intValue();
                    int low_temp_F_int = low_temp_F.intValue();


                    temperature_C = Math.round(temperature_C);
                    int feels_like_temp_C_int = feels_like_temp_C.intValue();
                    int high_temp_C_int = high_temp_C.intValue();
                    int low_temp_C_int = low_temp_C.intValue();

                    int temperature_F_int = (int) temperature_F;

                    int temperature_C_int = (int) temperature_C;

                    temp_view.setText(String.valueOf(temperature_F_int) + " F\u00B0  /  " + String.valueOf(temperature_C_int) +" C\u00B0");
                    temp_range_view.setText("H: " +String.valueOf(high_temp_F_int) + " F\u00B0  /  " + String.valueOf(high_temp_C_int) +" C\u00B0"
                            + "\n" + "L: " +String.valueOf(low_temp_F_int) + " F\u00B0  /  " + String.valueOf(low_temp_C_int) +" C\u00B0");

                    humandity_wind_view.setText("Humidity: " + humidity +"%\n" + "Wind Speed: " +wind +" m/s"
                            +"\n" + "feels like: " + String.valueOf(feels_like_temp_F_int) + " F\u00B0  /  " + String.valueOf(feels_like_temp_C_int) +" C\u00B0");
                    snackbar("Updating");

                } catch(JSONException e)
                {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener()
        {
            public void onErrorResponse(VolleyError err)
            {
                Toast.makeText(getApplicationContext(), err.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        }
        );

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(string_request);

        snackbar("Error!");

    }

    public void ask_location_input_dialog(View view) {
        final AlertDialog.Builder dialog;
        final EditText input_city_name;
        final EditText input_zipcode;
        Button input_cancel_button;
        Button input_confirm_button;
        final AlertDialog alert_dialog;

        dialog = new AlertDialog.Builder(ServiceActivity.this);
        View dialog_view = getLayoutInflater().inflate(R.layout.ask_for_weather_input, null);

        input_city_name = dialog_view.findViewById(R.id.enter_city_name_input_box);
        input_zipcode = dialog_view.findViewById(R.id.enter_zipcode_box);

        input_cancel_button = dialog_view.findViewById(R.id.weather_input_cancel_button);
        input_confirm_button = dialog_view.findViewById(R.id.weather_input_confirm_button);

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
                String city_name_input = input_city_name.getText().toString();
                String zipcode_input = input_zipcode.getText().toString();

                if (!city_name_input.equals("")  && !zipcode_input.equals("") )
                {
                    get_weather_by_zipcode(zipcode_input);
                }
                else if (!city_name_input.equals("") && zipcode_input.equals("") )
                {
                    get_weather_by_city_name(city_name_input);
                }
                else if(city_name_input.equals("")  && !zipcode_input.equals("") )
                {
                    get_weather_by_zipcode(zipcode_input);
                }
                else
                {
                    snackbar("input is empty");
                }
                alert_dialog.dismiss();
            }
        });

        alert_dialog.show();
    }

    public void snackbar(String notification) {

        Snackbar snackbar = Snackbar.make(findViewById(R.id.service_weather), notification, Snackbar.LENGTH_LONG);
        snackbar.show();
    }


}


class Load_Image extends AsyncTask<String, Void, Bitmap> {
    ImageView image;
    public Load_Image(ImageView weather_icon_view)
    {
        this.image = weather_icon_view;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String url = strings[0];
        Bitmap bitmap = null;
        try {
            InputStream input = new URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(input);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap bitmap)
    {
        image.setImageBitmap(bitmap);
    }
}