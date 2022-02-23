package com.example.assignment2.DataAccess.Repositories;

import com.example.assignment2.DataAccess.Database.ConnectionHelper;
import com.example.assignment2.DataAccess.Models.Genre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GenreRepository {
    private final String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<Genre> getRandomGenres(int genreCount) {
        ArrayList<Genre> randomGenres = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT Name FROM Genre ORDER BY random() LIMIT ?";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, genreCount);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                randomGenres.add(
                        new Genre(
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
        return randomGenres;
    }
}
