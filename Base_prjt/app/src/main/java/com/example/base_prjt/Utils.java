package com.example.base_prjt;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Utils {
    private OkHttpClient client = new OkHttpClient();

    private String get_req(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public int get_incomes(int id, String name) {
        int sum = 0;
        JSONObject res;

        if (name == null) {
            return -1;
        }

        try {
            res = new JSONObject(this.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (JSONException e) {
            return -1;
        } catch (IOException e) {
            return -1;
        }

        JSONObject results;
        try {
            results = res.getJSONObject("results");
        } catch (JSONException e) {
            return -1;
        }

        int parsed_id;
        String parsed_name;

        try {
            parsed_id = results.getInt("id");
            parsed_name = results.getString("family_name");
        } catch (JSONException e) {
            return -1;
        }

        if (id != parsed_id || !name.equals(parsed_name)) {
            return -1;
        }

        JSONArray sections;
        try {
            sections = results.getJSONArray("sections");
        } catch (JSONException e) {
            return -1;
        }

        for (int i = 0; i < sections.length(); i++) {
            JSONObject iter;
            try {
                iter = (JSONObject) sections.get(i);
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
                    iter2 = (JSONObject) sections.get(j);
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
                        iter3 = (JSONObject) incomes.get(k);
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

    public String get_vehicles(int id, String name) {
        StringBuilder str = new StringBuilder();
        JSONObject res;

        if (name == null) {
            return null;
        }

        try {
            res = new JSONObject(this.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (JSONException e) {
            return null;
        } catch (IOException e) {
            return null;
        }

        JSONObject results;
        try {
            results = res.getJSONObject("results");
        } catch (JSONException e) {
            return null;
        }

        int parsed_id;
        String parsed_name;

        try {
            parsed_id = results.getInt("id");
            parsed_name = results.getString("family_name");
        } catch (JSONException e) {
            return null;
        }

        if (id != parsed_id || !name.equals(parsed_name)) {
            return null;
        }

        JSONArray sections;
        try {
            sections = results.getJSONArray("sections");
        } catch (JSONException e) {
            return null;
        }

        for (int i = 0; i < sections.length(); i++) {
            JSONObject iter;
            try {
                iter = (JSONObject) sections.get(i);
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
                    iter2 = (JSONObject) sections.get(j);
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
                        iter3 = (JSONObject) vehicles.get(k);
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

    public String get_savings(int id, String name) {
        StringBuilder str = new StringBuilder();
        JSONObject res;

        if (name == null) {
            return null;
        }

        try {
            res = new JSONObject(this.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (JSONException e) {
            return null;
        } catch (IOException e) {
            return null;
        }

        JSONObject results;
        try {
            results = res.getJSONObject("results");
        } catch (JSONException e) {
            return null;
        }

        int parsed_id;
        String parsed_name;

        try {
            parsed_id = results.getInt("id");
            parsed_name = results.getString("family_name");
        } catch (JSONException e) {
            return null;
        }

        if (id != parsed_id || !name.equals(parsed_name)) {
            return null;
        }

        JSONArray sections;
        try {
            sections = results.getJSONArray("sections");
        } catch (JSONException e) {
            return null;
        }

        for (int i = 0; i < sections.length(); i++) {
            JSONObject iter;
            try {
                iter = (JSONObject) sections.get(i);
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
                    iter2 = (JSONObject) sections.get(j);
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
                        iter3 = (JSONObject) savings.get(k);
                    } catch (JSONException e) {
                        return null;
                    }

                    str.append(iter3 + "\n");
                }
            }
        }

        return str.toString();
    }

    public String get_real_estates(int id, String name) {
        StringBuilder str = new StringBuilder();
        JSONObject res;

        if (name == null) {
            return null;
        }

        try {
            res = new JSONObject(this.get_req("https://declarator.org/api/v1/search/person-sections/?name=" + name));
        } catch (JSONException e) {
            return null;
        } catch (IOException e) {
            return null;
        }

        JSONObject results;
        try {
            results = res.getJSONObject("results");
        } catch (JSONException e) {
            return null;
        }

        int parsed_id;
        String parsed_name;

        try {
            parsed_id = results.getInt("id");
            parsed_name = results.getString("family_name");
        } catch (JSONException e) {
            return null;
        }

        if (id != parsed_id || !name.equals(parsed_name)) {
            return null;
        }

        JSONArray sections;
        try {
            sections = results.getJSONArray("sections");
        } catch (JSONException e) {
            return null;
        }

        for (int i = 0; i < sections.length(); i++) {
            JSONObject iter;
            try {
                iter = (JSONObject) sections.get(i);
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
                    iter2 = (JSONObject) sections.get(j);
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
                        iter3 = (JSONObject) real_estates.get(k);
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

    public int update_rankings(int id, String name) {
        StringBuilder str = new StringBuilder();
        String res;

        if (name == null) {
            return -1;
        }

        try {
            res = this.get_req("http://34.245.212.90:5000/api/update_ranking?id=" + id + "&name=" + name + "&answered=true");
        } catch (IOException e) {
            return -1;
        }

        return (res.equals("\"Ranking successfully updated\"")) ? 0 : -1;
    }

    public String get_ranking() {
        try {
            return this.get_req("http://34.245.212.90:5000/api/ranking");
        } catch (IOException e) {
            return null;
        }
    }
}
