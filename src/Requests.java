import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
public class Requests {
    public void sendMessage(String data) {
        String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
        String apiToken = "5991947660:AAHaZ_T87lGI8vzoS2lp90zMjF2X1wILP7o";
        String chatId = "-977832773";
        urlString = String.format(urlString, apiToken, chatId, data);
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream is = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
