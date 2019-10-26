package com.example.base_prjt;

import android.util.Log;
import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import static com.ramotion.paperonboarding.utils.PaperOnboardingEngineDefaults.TAG;

public class Utils {
    static public String get_req(String urlToRead) {
        StringBuilder result = new StringBuilder();
        URL url;

        try {
            url = new URL(urlToRead);
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e);
            return null;
        }

        HttpURLConnection conn;

        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            System.out.println("Could not open connection: " + e);
            return null;
        }

        BufferedReader rd;

        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            System.out.println("Could not send get request: " + e);
            return null;
        }

        try {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (IOException e) {
            System.out.println("Could not buffered readered: " + e);
            return null;
        }

        String line;
        try {
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            System.out.println("Could not append lines to result: " + e);
            return null;
        }

        try {
            rd.close();
        } catch (IOException e) {
            System.out.println("Could not close buffer reader: " + e);
            return null;
        }

        return result.toString();
    }

    static private JSONObject get_results_array(String name) {
        JSONObject res;

        try {
            res = new JSONObject(Utils.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (Exception e) {
            System.out.println("Could not get response");
            return null;
        }

        JSONArray results;
        try {
            results = res.getJSONArray("results");
        } catch (JSONException e) {
            System.out.println("Could not get from results array");
            return null;
        }

        JSONObject result;
        try {
            result = results.getJSONObject(0);
        } catch (JSONException e) {
            System.out.println("Could not get 0th element");
            return null;
        }

        return result;
    }

    static public int get_id(String name) {
        if (name == null) {
            System.out.println("Name is not defined");
            return -1;
        }

        JSONObject result = get_results_array(name);

        if (result == null) {
            System.out.println("Could not get result");
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
        if (name == null) {
            System.out.println("Name is not defined");
            return -1;
        }

        int sum = 0;

        JSONObject result = get_results_array(name);

        if (result == null) {
            System.out.println("Could not get result");
            return -1;
        }

        JSONArray sections;
        try {
            sections = result.getJSONArray("sections");
        } catch (JSONException e) {
            System.out.println("Could not get sections");
            return -1;
        }

        for (int i = 0; i < sections.length(); i++) {
            JSONObject iter;
            try {
                iter = sections.getJSONObject(i);
            } catch (JSONException e) {
                System.out.println("Could not get sections element");
                return -1;
            }

            JSONArray sections2;
            try {
                sections2 = iter.getJSONArray("sections");
            } catch (JSONException e) {
                System.out.println("Could not get sections 2");
                return -1;
            }

            for (int j = 0; j < sections2.length(); j++) {
                JSONObject iter2;
                try {
                    iter2 = sections.getJSONObject(j);
                } catch (JSONException e) {
                    System.out.println("Could not get sections element 2");
                    return -1;
                }

                JSONArray incomes;
                try {
                    incomes = iter2.getJSONArray("incomes");
                } catch (JSONException e) {
                    System.out.println("Could not get incomes");
                    return -1;
                }

                for (int k = 0; k < incomes.length(); k++) {
                    JSONObject iter3;
                    try {
                        iter3 = incomes.getJSONObject(k);
                        System.out.println("Could not get incomes elements");
                    } catch (JSONException e) {
                        return -1;
                    }

                    try {
                        sum += iter3.getInt("size");
                    } catch (JSONException e) {
                        System.out.println("Could not get size");
                        return -1;
                    }
                }
            }
        }

        System.out.println("sum = " + sum);

        return sum / 12;
    }

    static public String get_vehicles(String name) {
        if (name == null) {
            System.out.println("Name is not defined");
            return null;
        }

        StringBuilder str = new StringBuilder();

        JSONObject res;

        if (name == null) {
            return null;
        }

        JSONObject result = get_results_array(name);

        if (result == null) {
            System.out.println("Could not get result");
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
        if (name == null) {
            System.out.println("Name is not defined");
            return null;
        }

        StringBuilder str = new StringBuilder();

        JSONObject res;

        if (name == null) {
            return null;
        }

        JSONObject result = get_results_array(name);

        if (result == null) {
            System.out.println("Could not get result");
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
        if (name == null) {
            return null;
        }

        StringBuilder str = new StringBuilder();

        JSONObject result = get_results_array(name);

        if (result == null) {
            System.out.println("Could not get result");
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

        res = Utils.get_req("http://34.245.212.90:5000/api/update_ranking?id=" + id + "&name=" + name + "&answered=true");

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
