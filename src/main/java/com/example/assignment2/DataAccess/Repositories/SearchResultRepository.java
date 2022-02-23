package com.example.assignment2.DataAccess.Repositories;

import com.example.assignment2.DataAccess.Database.ConnectionHelper;
import com.example.assignment2.DataAccess.Models.SearchResult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchResultRepository {
    private final String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<SearchResult> getSearchResults(String query) {
        ArrayList<SearchResult> searchResults = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT Track.Name AS TrackName, Artist.Name AS ArtistName, Album.Title AS AlbumTitle, Genre.Name AS GenreName FROM Track";
            selectQuery += " INNER JOIN Genre ON Track.GenreId = Genre.GenreId";
            selectQuery += " INNER JOIN Artist ON Album.ArtistId = Artist.ArtistId";
            selectQuery += " INNER JOIN Album ON Track.AlbumId = Album.AlbumId";
            selectQuery += " WHERE Track.Name LIKE ?";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setString(1, "%" + query + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                searchResults.add(
                        new SearchResult(
                                resultSet.getString("TrackName"),
                                resultSet.getString("ArtistName"),
                                resultSet.getString("AlbumTitle"),
                                resultSet.getString("GenreName")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return searchResults;
    }
}
