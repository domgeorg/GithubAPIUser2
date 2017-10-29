package com.example.christiannatsaliki.githubapiuser;

import android.os.AsyncTask;
import android.os.Debug;
import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ChristiannaTsaliki on 22/10/2017.
 */

public class HttpGETRequest extends AsyncTask<String, String , List<usersModel>> {
    public static final String REQUESTED_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;

    @Override
    protected List<usersModel> doInBackground(String... params) {
        String urlRequested = params[0];
        String result;
        String inputline;
        List<usersModel> usersList = new ArrayList<>();
        try{

            URL myUrl = new URL(urlRequested);
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
            connection.setRequestMethod(REQUESTED_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.connect();

            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String response = "";

            while((inputline = reader.readLine()) != null){
                stringBuilder.append(inputline);
                response += inputline;
                Log.d("new Response", response);
            }

            Boolean appLimitExceeded =false;
            //usersModel model = new usersModel();
            if(response.contains("API rate limit exceeded")){
                appLimitExceeded =true;
            }
            else {
                JSONArray users= new JSONArray(response);
                for(int i=0 ;i<=users.length()-1 ;i++){
                    JSONObject obj = users.getJSONObject(i);
                    //Log.d ("Login to be Inserted",obj.getString("login") );
                    String login = obj.getString("login");
                    String type = obj.getString("type");
                    String url = obj.getString("url");
                    usersModel model = new usersModel(login,type,url);
                    //model.setLogin(obj.getString("login"));
                   // model.setType(obj.getString("type"));
                    //model.setUrl(obj.getString("url"));
                   // model.PrintModel();
                    usersList.add(model);
                }

            }

            reader.close();
            streamReader.close();

        }
        catch (IOException  |JSONException e){
            e.printStackTrace();
            return null;
        }

        return usersList;
    }

    @Override
    protected void onPostExecute(List<usersModel> result) {

        super.onPostExecute(result);

    }
}
