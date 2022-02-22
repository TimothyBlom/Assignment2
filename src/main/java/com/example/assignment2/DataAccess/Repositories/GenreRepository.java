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

    public ArrayList<Genre> getRandomGenre() {
        ArrayList<Genre> Genre = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT GenreName FROM Genre");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Genre.add(
                        new Genre(
                                resultSet.getString("GenreName")
                        )
                );
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(-1);
        }
        finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return Genre;
    }
}
