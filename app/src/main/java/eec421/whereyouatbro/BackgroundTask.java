package eec421.whereyouatbro;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by HanSolo on 11/1/2016.
 */

public class BackgroundTask {

    Context context;
    ArrayList<Contact> arrayList = new ArrayList<>();
    //the URL is for the localhost -> use ipconfig in cmd to find correct ip_address:IPv4
    String json_url = "http://172.20.41.250/whereyouatbro/users.php";

    public BackgroundTask(Context context){
        this.context = context;
    }

    public ArrayList<Contact> getList() {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, json_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                while (count < response.length()){
                    try {
                        JSONObject jsonObject = response.getJSONObject(count);
                        Contact contact =  new Contact(jsonObject.getString("Name"), jsonObject.getString("Address"));
                        arrayList.add(contact);
                        count++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Error... ",Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });

        MySingleton.getInstance(context).addToRequestque(jsonArrayRequest);
        return arrayList;
    }
}
