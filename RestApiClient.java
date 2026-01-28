import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class RestApiClient {

    public static void main(String[] args) {

        try {
            
            String apiUrl = "https://jsonplaceholder.typicode.com/users";

            
            URL url = new URL(apiUrl);

            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            
            System.out.println("API Response:");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("Error while fetching API data.");
            e.printStackTrace();
        }
    }
}
