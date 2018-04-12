package com.movieq.db;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieq.domain.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class MovieDBInput {

    List<Movie> getMovies(List<String> movieIds) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Movie> movies = new ArrayList<>();
        for (String movieId : movieIds) {
            String details = getDetails(movieId);
            String credits = getDetails(movieId + "/credits");
            JsonNode jsonNode = mapper.readTree(details);
            JsonNode creditsNode = mapper.readTree(credits);
            int id = jsonNode.get("id").intValue();
            String title = jsonNode.get("title").asText();
            String description = jsonNode.get("overview").asText();
            double rating = jsonNode.get("vote_average").asDouble();
            LocalDate releaseDate = LocalDate.parse(jsonNode.get("release_date").asText(), DateTimeFormatter.ISO_DATE);
            List<Genre> genres = new ArrayList<>();
            for (JsonNode node : jsonNode.get("genres")) {
                genres.add(new Genre(node.get("id").asInt(), node.get("name").asText()));
            }
            JsonNode productionCountryNode = jsonNode.get("production_countries").get(0);
            ProductionCountry productionCountry = new ProductionCountry(productionCountryNode.get("iso_3166_1").asText(), productionCountryNode.get("name").asText());
            List<People> people = new ArrayList<>();
            for (JsonNode node : creditsNode.get("cast")) {
                int gender = node.get("gender").intValue();
                people.add(new People(node.get("id").asInt(), node.get("name").asText(), gender == 1 ? Gender.Female() :
                        gender == 2 ? Gender.Male() : Gender.Unkwown()));

            }
            Converter converter = new Converter();
            movies.add(new Movie(id, title, description, rating, converter.convert(people), converter.convert(genres), releaseDate, productionCountry));
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
