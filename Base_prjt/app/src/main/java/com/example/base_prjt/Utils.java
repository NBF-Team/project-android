package com.example.base_prjt;

import android.util.Pair;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    static private OkHttpClient client = new OkHttpClient();

    static private String get_req(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    static public int get_id(String name) {
        JSONObject res;

        if (name == null) {
            return -1;
        }

        try {
            res = new JSONObject(Utils.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (Exception e) {
            return -1;
        }

        JSONArray results;
        try {
            results = res.getJSONArray("results");
        } catch (JSONException e) {
            return -1;
        }

        JSONObject result;
        try {
            result = results.getJSONObject(0);
        } catch (JSONException e) {
            return -1;
        }

        try {
            int id = result.getInt("id");
            return id;
        } catch (JSONException e) {
            return -1;
        }

    }

    static public int get_incomes(String name) {
        int sum = 0;
        JSONObject res;

        if (name == null) {
            return -1;
        }

        try {
            res = new JSONObject(Utils.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (Exception e) {
            return -1;
        }

        JSONArray results;
        try {
            results = res.getJSONArray("results");
        } catch (JSONException e) {
            return -1;
        }

        JSONObject result;
        try {
            result = results.getJSONObject(0);
        } catch (JSONException e) {
            return -1;
        }

        JSONArray sections;
        try {
            sections = result.getJSONArray("sections");
        } catch (JSONException e) {
            return -1;
        }

        for (int i = 0; i < sections.length(); i++) {
            JSONObject iter;
            try {
                iter = sections.getJSONObject(i);
            } catch (JSONException e) {
                return -1;
            }

            JSONArray sections2;
            try {
                sections2 = iter.getJSONArray("sections");
            } catch (JSONException e) {
                return -1;
            }

            for (int j = 0; j < sections2.length(); j++) {
                JSONObject iter2;
                try {
                    iter2 = sections.getJSONObject(j);
                } catch (JSONException e) {
                    return -1;
                }

                JSONArray incomes;
                try {
                    incomes = iter2.getJSONArray("incomes");
                } catch (JSONException e) {
                    return -1;
                }

                for (int k = 0; k < incomes.length(); k++) {
                    JSONObject iter3;
                    try {
                        iter3 = incomes.getJSONObject(k);
                    } catch (JSONException e) {
                        return -1;
                    }

                    try {
                        sum += iter3.getInt("size");
                    } catch (JSONException e) {
                        return -1;
                    }
                }
            }
        }

        return sum / 12;
    }

    static public String get_vehicles(String name) {
        StringBuilder str = new StringBuilder();
        JSONObject res;

        if (name == null) {
            return null;
        }

        try {
            res = new JSONObject(Utils.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (Exception e) {
            return null;
        }

        JSONArray results;
        try {
            results = res.getJSONArray("results");
        } catch (JSONException e) {
            return null;
        }

        JSONObject result;
        try {
            result = results.getJSONObject(0);
        } catch (JSONException e) {
            return null;
        }

        JSONArray sections;
        try {
            sections = result.getJSONArray("sections");
        } catch (JSONException e) {
            return null;
        }

        for (int i = 0; i < sections.length(); i++) {
            JSONObject iter;
            try {
                iter = sections.getJSONObject(i);
            } catch (JSONException e) {
                return null;
            }

            JSONArray sections2;
            try {
                sections2 = iter.getJSONArray("sections");
            } catch (JSONException e) {
                return null;
            }

            for (int j = 0; j < sections2.length(); j++) {
                JSONObject iter2;
                try {
                    iter2 = sections.getJSONObject(j);
                } catch (JSONException e) {
                    return null;
                }

                JSONArray vehicles;
                try {
                    vehicles = iter2.getJSONArray("incomes");
                } catch (JSONException e) {
                    return null;
                }

                for (int k = 0; k < vehicles.length(); k++) {
                    JSONObject iter3;
                    try {
                        iter3 = vehicles.getJSONObject(k);
                    } catch (JSONException e) {
                        return null;
                    }

                    try {
                        String relative = iter3.getString("relative");
                        str.append(iter3.getString("brand.name") + " " + iter3.getInt("manufacture_year"));
                        if (relative != null) {
                            str.append(" (принадлежит " + relative + ")\n");
                        }
                    } catch (JSONException e) {
                        return null;
                    }
                }
            }
        }

        return str.toString();
    }

    static public String get_savings(String name) {
        StringBuilder str = new StringBuilder();
        JSONObject res;

        if (name == null) {
            return null;
        }

        try {
            res = new JSONObject(Utils.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (Exception e) {
            return null;
        }

        JSONArray results;
        try {
            results = res.getJSONArray("results");
        } catch (JSONException e) {
            return null;
        }

        JSONObject result;
        try {
            result = results.getJSONObject(0);
        } catch (JSONException e) {
            return null;
        }

        JSONArray sections;
        try {
            sections = result.getJSONArray("sections");
        } catch (JSONException e) {
            return null;
        }

        for (int i = 0; i < sections.length(); i++) {
            JSONObject iter;
            try {
                iter = sections.getJSONObject(i);
            } catch (JSONException e) {
                return null;
            }

            JSONArray sections2;
            try {
                sections2 = iter.getJSONArray("sections");
            } catch (JSONException e) {
                return null;
            }

            for (int j = 0; j < sections2.length(); j++) {
                JSONObject iter2;
                try {
                    iter2 = sections.getJSONObject(j);
                } catch (JSONException e) {
                    return null;
                }

                JSONArray savings;
                try {
                    savings = iter2.getJSONArray("savings");
                } catch (JSONException e) {
                    return null;
                }

                for (int k = 0; k < savings.length(); k++) {
                    JSONObject iter3;
                    try {
                        iter3 = savings.getJSONObject(k);
                    } catch (JSONException e) {
                        return null;
                    }

                    str.append(iter3 + "\n");
                }
            }
        }

        return str.toString();
    }

    static public String get_real_estates(String name) {
        StringBuilder str = new StringBuilder();
        JSONObject res;

        if (name == null) {
            return null;
        }

        try {
            res = new JSONObject(Utils.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (Exception e) {
            return null;
        }

        JSONArray results;
        try {
            results = res.getJSONArray("results");
        } catch (JSONException e) {
            return null;
        }

        JSONObject result;
        try {
            result = results.getJSONObject(0);
        } catch (JSONException e) {
            return null;
        }

        JSONArray sections;
        try {
            sections = result.getJSONArray("sections");
        } catch (JSONException e) {
            return null;
        }

        for (int i = 0; i < sections.length(); i++) {
            JSONObject iter;
            try {
                iter = sections.getJSONObject(i);
            } catch (JSONException e) {
                return null;
            }

            JSONArray sections2;
            try {
                sections2 = iter.getJSONArray("sections");
            } catch (JSONException e) {
                return null;
            }

            for (int j = 0; j < sections2.length(); j++) {
                JSONObject iter2;
                try {
                    iter2 = sections.getJSONObject(j);
                } catch (JSONException e) {
                    return null;
                }

                JSONArray real_estates;
                try {
                    real_estates = iter2.getJSONArray("real_estates");
                } catch (JSONException e) {
                    return null;
                }

                for (int k = 0; k < real_estates.length(); k++) {
                    JSONObject iter3;
                    try {
                        iter3 = real_estates.getJSONObject(k);
                    } catch (JSONException e) {
                        return null;
                    }

                    try {
                        str.append(iter3.getString("own_type.name") + " собственность: " +
                                iter3.getString("type.name") + " размером " + iter3.getInt("square") + " м2\n");
                    } catch (JSONException e) {
                        return null;
                    }
                }
            }
        }

        return str.toString();
    }

    static public int update_rankings(int id, String name) {
        StringBuilder str = new StringBuilder();
        String res;

        if (name == null) {
            return -1;
        }

        try {
            res = Utils.get_req("http://34.245.212.90:5000/api/update_ranking?id=" + id + "&name=" + name + "&answered=true");
        } catch (IOException e) {
            return -1;
        }

        return (res.equals("\"Ranking successfully updated\"")) ? 0 : -1;
    }

    static public ArrayList<Pair<String,Integer>> get_ranking() {
        JSONArray obj;
        try {
            obj = new JSONArray(Utils.get_req("http://34.245.212.90:5000/api/ranking"));
        } catch (Exception e) {
            return null;
        }

        ArrayList<Pair<String, Integer>> list = new ArrayList<>();

        for (int i = 0; i < obj.length(); i++) {
            try {
                list.add(new Pair<>(obj.getJSONArray(i).getString(0),
                                    obj.getJSONArray(i).getInt(1)));
            } catch (JSONException e) {
                return null;
            }
        }

        return list;
    }
}
