import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//  It allows users to add, view, and update their favorite currency list.
//  Use a option to show the favorite currency.
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.newApiRequest();
    }
    public void newApiRequest() {
        Gson gson;
        Root root;
        String BASE_URL = "https://dummyjson.com/products";
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL))
                    // .header("Authorization", API_KEY)
                    .GET()
                    .build();
            HttpClient HttpClient = java.net.http.HttpClient.newHttpClient();
            HttpResponse<String> getResponse = HttpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            gson = new Gson();
            root = gson.fromJson(getResponse.body(), Root.class);
            for (int i = 0; i < root.getProducts().size(); i++) {
                System.out.println(root.getProducts().get(i));
            }

        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}