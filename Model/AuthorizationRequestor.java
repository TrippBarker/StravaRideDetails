package Model;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class AuthorizationRequestor {
    private String auth = "Bearer [YOUR APPLICATION ACCESS TOKEN HERE]";
    private String clientID = "client_id=[YOUR CLIENT ID HERE]";
    private String clientSecret = "client_secret=[YOUR CLIENT SECRET HERE]";
    private String authCode = "code=[YOUR AUTHORIZATION CODE HERE]";
    private String authGrantType = "grant_type=authorization_code";
    public AuthorizationRequestor() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI("https://www.strava.com/api/v3/athlete"))
                .header("Authorization", auth)
                .GET().build();
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://www.strava.com/oauth/token?"+clientID+"&"+clientSecret+"&"+authCode+"&"+authGrantType))
                .POST(HttpRequest.BodyPublishers.ofString(""))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(postResponse.body());
        System.out.println(postResponse.body());
    }

}
