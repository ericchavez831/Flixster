package com.codepath.eric.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// Creating the Movie class in order to store the values needed for a movie object
public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;

    // Takes it a JSON object which contains the info in the JSON format
    // Added exception to method signature, so that if any of the variable
    // assignments fail, it will throw an exception
    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");

    }

    // Taking in the JSON and creating a list of Movies
    // We put this in movie.java everything to be organized

    // Function: Responsible for iterating through the JSON array and constructing a movie
    // for each element in the array
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        // Iterating through the JSON
        for(int i  = 0; i < movieJsonArray.length(); i++) {
            // Adding movies to the array
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        // Returning the array
        return movies;
    }

    // (Right-clicked) and generated getters so that we can retrieve all of the
    // information we need/want

    // Poster path is only returning a relative path, meaning that it is not a full url.
    public String getPosterPath() {
        // %s is adding posterPath to the url
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    // For landscape orientation
    public String getBackdropPath() {
        // %s is adding backdropPath to the url
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
