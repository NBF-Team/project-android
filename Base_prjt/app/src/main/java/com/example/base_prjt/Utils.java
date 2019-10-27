package com.example.base_prjt;

import android.util.Log;
import android.util.Pair;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static com.ramotion.paperonboarding.utils.PaperOnboardingEngineDefaults.TAG;

public class Utils {
    int mId;

    public int get_id(String name) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://declarator.org/api/v1/search/person-sections/?name=" + name)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request Failed.");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Error : " + response);
                } else {
                    Log.d(TAG, "Request Successful.");
                }

                final JSONObject data;
                try {
                    data = new JSONObject(response.body().string());
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray results;
                try {
                    results = data.getJSONArray("results");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONObject result;
                try {
                    result = results.getJSONObject(0);
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                try {
                    mId = result.getInt("id");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }
            }
        });

        return mId;
    }

    ArrayList<Pair<String,Integer>> mSearchResult = new ArrayList<>();

    public ArrayList<Pair<String,Integer>> get_search_result(final String name) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://declarator.org/api/v1/search/person-sections/?name=" + name)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request Failed.");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Error : " + response);
                } else {
                    Log.d(TAG, "Request Successful.");
                }

                final JSONObject data;
                try {
                    data = new JSONObject(response.body().string());
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray results;
                try {
                    results = data.getJSONArray("results");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                for (int i = 0; i < results.length(); i++) {
                    try {
                        mSearchResult.add(new Pair<>(results.getJSONObject(i).getString("family_name"),
                                          get_incomes(name)));
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }
                }
            }
        });

        return mSearchResult;
    }

    int mSum;

    public int get_incomes(String name) {
        mSum = 0;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://declarator.org/api/v1/search/person-sections/?name=" + name)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request Failed.");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Error : " + response);
                } else {
                    Log.d(TAG, "Request Successful.");
                }

                final JSONObject data;
                try {
                    data = new JSONObject(response.body().string());
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray results;
                try {
                    results = data.getJSONArray("results");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONObject result;
                try {
                    result = results.getJSONObject(0);
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray sections;
                try {
                    sections = result.getJSONArray("sections");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                for (int i = 0; i < sections.length(); i++) {
                    JSONObject iter;
                    try {
                        iter = sections.getJSONObject(i);
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }

                    JSONArray sections2;
                    try {
                        sections2 = iter.getJSONArray("sections");
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }

                    for (int j = 0; j < sections2.length(); j++) {
                        JSONObject iter2;
                        try {
                            iter2 = sections.getJSONObject(j);
                        } catch (JSONException e) {
                            throw new IOException("Error : " + e);
                        }

                        JSONArray incomes;
                        try {
                            incomes = iter2.getJSONArray("incomes");
                        } catch (JSONException e) {
                            throw new IOException("Error : " + e);
                        }

                        for (int k = 0; k < incomes.length(); k++) {
                            JSONObject iter3;
                            try {
                                iter3 = incomes.getJSONObject(k);
                                System.out.println("Could not get incomes elements");
                            } catch (JSONException e) {
                                throw new IOException("Error : " + e);
                            }

                            try {
                                mSum += iter3.getInt("size");
                            } catch (JSONException e) {
                                System.out.println("Could not get size");
                                throw new IOException("Error : " + e);
                            }
                        }
                    }
                }
            }
        });

        return mSum / 12;
    }

    StringBuilder mVehivles;

    public String get_vehicles(String name) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://declarator.org/api/v1/search/person-sections/?name=" + name)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request Failed.");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Error : " + response);
                } else {
                    Log.d(TAG, "Request Successful.");
                }

                final JSONObject data;
                try {
                    data = new JSONObject(response.body().string());
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray results;
                try {
                    results = data.getJSONArray("results");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONObject result;
                try {
                    result = results.getJSONObject(0);
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray sections;
                try {
                    sections = result.getJSONArray("sections");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                for (int i = 0; i < sections.length(); i++) {
                    JSONObject iter;
                    try {
                        iter = sections.getJSONObject(i);
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }

                    JSONArray sections2;
                    try {
                        sections2 = iter.getJSONArray("sections");
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }

                    for (int j = 0; j < sections2.length(); j++) {
                        JSONObject iter2;
                        try {
                            iter2 = sections.getJSONObject(j);
                        } catch (JSONException e) {
                            throw new IOException("Error : " + e);
                        }

                        JSONArray vehicles;
                        try {
                            vehicles = iter2.getJSONArray("incomes");
                        } catch (JSONException e) {
                            throw new IOException("Error : " + e);
                        }

                        for (int k = 0; k < vehicles.length(); k++) {
                            JSONObject iter3;
                            try {
                                iter3 = vehicles.getJSONObject(k);
                            } catch (JSONException e) {
                                throw new IOException("Error : " + e);
                            }

                            try {
                                String relative = iter3.getString("relative");
                                mVehivles.append(iter3.getString("brand.name") + " " + iter3.getInt("manufacture_year"));
                                if (relative != null) {
                                    mVehivles.append(" (принадлежит " + relative + ")\n");
                                }
                            } catch (JSONException e) {
                                throw new IOException("Error : " + e);
                            }
                        }
                    }
                }
            }
        });

        return mVehivles.toString();
    }

    StringBuilder mSavings;

    public String get_savings(String name) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://declarator.org/api/v1/search/person-sections/?name=" + name)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request Failed.");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Error : " + response);
                } else {
                    Log.d(TAG, "Request Successful.");
                }

                final JSONObject data;
                try {
                    data = new JSONObject(response.body().string());
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray results;
                try {
                    results = data.getJSONArray("results");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONObject result;
                try {
                    result = results.getJSONObject(0);
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray sections;
                try {
                    sections = result.getJSONArray("sections");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                for (int i = 0; i < sections.length(); i++) {
                    JSONObject iter;
                    try {
                        iter = sections.getJSONObject(i);
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }

                    JSONArray sections2;
                    try {
                        sections2 = iter.getJSONArray("sections");
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }

                    for (int j = 0; j < sections2.length(); j++) {
                        JSONObject iter2;
                        try {
                            iter2 = sections.getJSONObject(j);
                        } catch (JSONException e) {
                            throw new IOException("Error : " + e);
                        }

                        JSONArray savings;
                        try {
                            savings = iter2.getJSONArray("savings");
                        } catch (JSONException e) {
                            throw new IOException("Error : " + e);
                        }

                        for (int k = 0; k < savings.length(); k++) {
                            JSONObject iter3;
                            try {
                                iter3 = savings.getJSONObject(k);
                            } catch (JSONException e) {
                                throw new IOException("Error : " + e);
                            }

                            mSavings.append(iter3 + "\n");
                        }
                    }
                }
            }
        });

        return mSavings.toString();
    }

    StringBuilder mReadEstates;

    public String get_real_estates(String name) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://declarator.org/api/v1/search/person-sections/?name=" + name)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request Failed.");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Error : " + response);
                } else {
                    Log.d(TAG, "Request Successful.");
                }

                final JSONObject data;
                try {
                    data = new JSONObject(response.body().string());
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray results;
                try {
                    results = data.getJSONArray("results");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONObject result;
                try {
                    result = results.getJSONObject(0);
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                JSONArray sections;
                try {
                    sections = result.getJSONArray("sections");
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                for (int i = 0; i < sections.length(); i++) {
                    JSONObject iter;
                    try {
                        iter = sections.getJSONObject(i);
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }

                    JSONArray sections2;
                    try {
                        sections2 = iter.getJSONArray("sections");
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }

                    for (int j = 0; j < sections2.length(); j++) {
                        JSONObject iter2;
                        try {
                            iter2 = sections.getJSONObject(j);
                        } catch (JSONException e) {
                            throw new IOException("Error : " + e);
                        }

                        JSONArray real_estates;
                        try {
                            real_estates = iter2.getJSONArray("real_estates");
                        } catch (JSONException e) {
                            throw new IOException("Error : " + e);
                        }

                        for (int k = 0; k < real_estates.length(); k++) {
                            JSONObject iter3;
                            try {
                                iter3 = real_estates.getJSONObject(k);
                            } catch (JSONException e) {
                                throw new IOException("Error : " + e);
                            }

                            try {
                                mReadEstates.append(iter3.getString("own_type.name") + " собственность: " +
                                    iter3.getString("type.name") + " размером " + iter3.getInt("square") + " м2\n");
                            } catch (JSONException e) {
                                throw new IOException("Error : " + e);
                            }
                        }
                    }
                }
            }
        });

        return mReadEstates.toString();
    }

    boolean mUpdateSuccess;

    public boolean update_rankings(int id, String name) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://34.245.212.90:5000/api/update_ranking?id=" + id + "&name=" + name + "&answered=true")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request Failed.");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Error : " + response);
                } else {
                    Log.d(TAG, "Request Successful.");
                }

                String data = response.body().string();

                mUpdateSuccess = data.equals("\"Ranking successfully updated\"");
            }
        });

        return mUpdateSuccess;
    }

    ArrayList<Pair<String,Integer>> mRanking = new ArrayList<>();

    public ArrayList<Pair<String,Integer>> get_ranking() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://34.245.212.90:5000/api/ranking")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request Failed.");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Error : " + response);
                } else {
                    Log.d(TAG, "Request Successful.");
                }

                JSONArray data;
                try {
                    data = new JSONArray(response.body().string());
                } catch (JSONException e) {
                    throw new IOException("Error : " + e);
                }

                for (int i = 0; i < data.length(); i++) {
                    try {
                        mRanking.add(new Pair<>(data.getJSONArray(i).getString(0),
                                                data.getJSONArray(i).getInt(1)));
                    } catch (JSONException e) {
                        throw new IOException("Error : " + e);
                    }
                }
            }
        });

        return mRanking;
    }
}
