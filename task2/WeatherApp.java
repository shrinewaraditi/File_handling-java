import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) {

        try {
            // API URL (Pune coordinates)
            String urlString = "https://api.open-meteo.com/v1/forecast?latitude=18.52&longitude=73.85&current_weather=true";

            // 🔹 Step 1: Create URL
            URL url = new URL(urlString);

            // 🔹 Step 2: Open connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 🔹 Step 3: Check response
            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {

                // 🔹 Step 4: Read response
                Scanner sc = new Scanner(conn.getInputStream());
                StringBuilder jsonData = new StringBuilder();

                while (sc.hasNext()) {
                    jsonData.append(sc.nextLine());
                }
                sc.close();

                String json = jsonData.toString();

                //  Step 5: Extract ONLY current_weather block
                String currentWeather = json.split("\"current_weather\":\\{")[1].split("\\}")[0];

                // 🔹 Step 6: Extract values correctly
                String temperature = currentWeather.split("\"temperature\":")[1].split(",")[0];
                String windspeed = currentWeather.split("\"windspeed\":")[1].split(",")[0];
                String winddirection = currentWeather.split("\"winddirection\":")[1].split(",")[0];
                String weathercode = currentWeather.split("\"weathercode\":")[1].split(",")[0];

                // 🔹 Step 7: Display formatted output
                System.out.println("\n===== Weather Report =====");
                System.out.println("Location: Pune");
                System.out.println("Temperature: " + temperature + " C");
                System.out.println("Wind Speed: " + windspeed + " km/h");
                System.out.println("Wind Direction: " + winddirection + " degrees");
                System.out.println("Weather Code: " + weathercode);
                System.out.println("==========================");
            } else {
                System.out.println(" Error: Unable to fetch data. Response Code: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Exception occurred:");
            e.printStackTrace();
        }
    }
}