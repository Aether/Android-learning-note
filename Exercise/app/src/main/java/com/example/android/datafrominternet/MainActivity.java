/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.datafrominternet;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.datafrominternet.utilities.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText mSearchBoxEditText;

    private TextView mUrlDisplayTextView;

    private TextView mSearchResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);
        mUrlDisplayTextView = (TextView) findViewById(R.id.tv_url_display);
        mSearchResultsTextView = (TextView) findViewById(R.id.tv_weather_search_results_json);

    }

    private void makeWeatherSeachQuery(){
        String cityQuery = mSearchBoxEditText.getText().toString();
        URL weatherSearchUrl = NetworkUtils.buildUrl(cityQuery);
        mUrlDisplayTextView.setText(weatherSearchUrl.toString());
        String weatherSearchResults = null;
        new WeatherQueryTask().execute(weatherSearchUrl);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_search) {
            makeWeatherSeachQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class WeatherQueryTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String weatherSearchResults = null;
            try {
                weatherSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return weatherSearchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            String wind_direction = null;
            if(s != null && !s.equals(""))
                try {
                    JSONObject weatherSearchResult = new JSONObject(s);
                    JSONArray HeWeather = weatherSearchResult.getJSONArray("HeWeather6");
                    Log.d("test",HeWeather+" "+"\n"+HeWeather.length());
                    JSONObject Weather = HeWeather.getJSONObject(0);
                    JSONArray daily_forecast = Weather.getJSONArray("daily_forecast");
                    JSONObject wind_dir = (JSONObject) daily_forecast.get(0);
                    wind_direction = wind_dir.getString("wind_dir");
                    Log.d("test",wind_direction+" ");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            Log.d("test",wind_direction+" ");
            mSearchResultsTextView.setText(wind_direction+" ");
            super.onPostExecute(s);
        }
    }


}