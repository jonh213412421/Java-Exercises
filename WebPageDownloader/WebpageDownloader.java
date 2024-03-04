import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WebpageDownloader {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the desired url: "); //asks url
        String url = scan.nextLine(); //gets url

        try {
            // Download the webpage
            String webpageContent = downloadWebpage(url);

            // Save the webpage content to a file
            Path filePath = saveWebpageToFile(webpageContent);

            // Open the file in the default browser
            openFileInDefaultBrowser(filePath);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    //downloads url
    private static String downloadWebpage(String url) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);

        try {
            HttpResponse response = httpClient.execute(request);
            return EntityUtils.toString(response.getEntity());
        } finally {
            request.releaseConnection();
        }
    }
    //save page
    private static Path saveWebpageToFile(String content) throws IOException {
        Path filePath = FileSystems.getDefault().getPath("downloaded_webpage.html");
        Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        return filePath;
    }
    //open downloaded html
    private static void openFileInDefaultBrowser(Path filePath) throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
        desktop.get(filePath.toFile());
    }
}
