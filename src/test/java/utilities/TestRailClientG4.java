package utilities;

import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class TestRailClientG4 {
    private final String baseUrl = "https://roje.testrail.io/";
    private final String username = "zarslankule@yahoo.com";
    private final String apiKey = "V1aGQIkGu5ZugGYj4k3i-u8Zv7wrVTQ8HV8ngcpjZ";

    public void addResultForTestCase(int runId, int caseId, int statusId, String comment) throws IOException {
        String uri = baseUrl + "index.php?/api/v2/add_result_for_case/" + runId + "/" + caseId;
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(uri);
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Authorization", getAuthHeader());

        JsonObject body = new JsonObject();
        body.addProperty("status_id", statusId);
        body.addProperty("comment", comment);

        post.setEntity(new StringEntity(body.toString()));
        HttpResponse response = client.execute(post);
        System.out.println("TestRail response: " + response.getStatusLine());
    }

    private String getAuthHeader() {
        String auth = username + ":" + apiKey;
        return "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
    }
}
