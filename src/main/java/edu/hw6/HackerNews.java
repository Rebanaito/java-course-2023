package edu.hw6;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class HackerNews {
    private HackerNews() {
    }

    private final static int POINTER_SHIFT = 9;

    public static long[] hackerNewsTopStories() {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create("https://hacker-news.firebaseio.com/v0/topstories.json"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return Arrays.stream(
                            response.body()
                                    .substring(1, response.body().length() - 1)
                                    .split(","))
                    .mapToLong(Long::parseLong)
                    .toArray();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String news(long id) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            URI uri = URI.create(String.format("https://hacker-news.firebaseio.com/v0/item/%d.json", id));
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            int start = response.body().indexOf("\"title\"");
            if (start == -1) {
                return null;
            }
            start += POINTER_SHIFT;

            int end = start;
            while (end < response.body().length()) {
                if (response.body().charAt(end) == '"') {
                    break;
                }
                end++;
            }

            return response.body().substring(start, end);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
