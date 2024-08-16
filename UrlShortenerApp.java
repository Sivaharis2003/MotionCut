import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class UrlShortenerApp {
    private static final Map<String, String> urlStorage = new HashMap<>();
    private static final String BASE_URL = "http://website.ly/";


    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;


            while (running) {
                System.out.println("\n--- URL Shortener App ---");
                System.out.println("1. Shorten a URL");
                System.out.println("2. Retrieve original URL");
                System.out.println("3. Exit");
                System.out.print("Select an option: ");
                int userChoice = scanner.nextInt();
                scanner.nextLine();  // Consume newline


                switch (userChoice) {
                    case 1:
                        System.out.print("Enter the full URL: ");
                        String longUrl = scanner.nextLine();
                        String shortUrl = generateShortUrl(longUrl);
                        System.out.println("Shortened URL: " + shortUrl);
                        break;


                    case 2:
                        System.out.print("Enter the shortened URL: ");
                        String shortUrlInput = scanner.nextLine();
                        String originalUrl = getOriginalUrl(shortUrlInput);
                        if (originalUrl != null) {
                            System.out.println("Original URL: " + originalUrl);
                        } else {
                            System.out.println("URL not found.");
                        }
                        break;


                    case 3:
                        System.out.println("Exiting...");
                        running = false;
                        break;


                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }


    private static String generateShortUrl(String longUrl) {
        String id = "id" + urlStorage.size();
        String shortUrl = BASE_URL + id;
        urlStorage.put(shortUrl, longUrl);
        return shortUrl;
    }


    private static String getOriginalUrl(String shortUrl) {
        return urlStorage.get(shortUrl);
    }
}