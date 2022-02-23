package com.example.assignment2.DataAccess.Repositories;

import com.example.assignment2.DataAccess.Database.ConnectionHelper;
import com.example.assignment2.DataAccess.Models.Artist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArtistRepository {
    private final String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<Artist> getRandomArtists(int artistCount) {
        ArrayList<Artist> randomArtists = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT Name FROM Artist ORDER BY random() LIMIT ?";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, artistCount);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                randomArtists.add(
                        new Artist(
                                resultSet.getString("Name")
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
        return randomArtists;
    }
}