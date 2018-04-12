package com.movieq.db;


import com.movieq.domain.Movie;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

public class MovieDBInput {

    public static void main(String[] args) throws Exception {
        List<String> movieIds = Arrays.asList("297222");
        List<Movie> movies = getMovies(movieIds);

    }

    private static List<Movie> getMovies(List<String> movieIds) throws Exception {
        List<Movie> movies = new ArrayList<>();
        for (String movieId : movieIds) {
            String details = getDetails(movieId);
            String credits = getDetails(movieId + "/credits");
            System.out.println();
        }
        return movies;
    }

    private static String getDetails(String movieId) throws Exception {
        String url = "https://api.themoviedb.org/3/movie";
        try (CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault()) {
            httpclient.start();
            HttpUriRequest uriRequest = RequestBuilder.create("GET")
                    .setUri(new URIBuilder(url + "/" + movieId).build())
                    .addParameter("api_key", "a5b5f4346233f9d54901fbc84c35ef74")
                    .build();
            Future<HttpResponse> future = httpclient.execute(uriRequest, null);
            return EntityUtils.toString(future.get().getEntity());
        }
    }
}
