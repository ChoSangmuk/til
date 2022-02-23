package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonTest {

  public static void main(String[] args) {

    try {
      URL url = new URL("https://jsonplaceholder.typicode.com/todos/"); // JSON API Sample
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

      String str;
      StringBuilder data = new StringBuilder();
      do {
        str = br.readLine();
        if (str == null) break;
        data.append(str);
      } while (true);

      JSONArray array = new JSONArray(data.toString());
      for (int i = 0; i < array.length(); i++) {
        JSONObject obj = array.getJSONObject(i);
        System.out.print(obj.getInt("userId") + " ");
        System.out.print(obj.getInt("id") + " ");
        System.out.print(obj.getString("title") + " ");
        System.out.println(obj.getBoolean("completed"));
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}