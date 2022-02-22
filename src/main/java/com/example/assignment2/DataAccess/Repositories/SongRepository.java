package com.example.assignment2.DataAccess.Repositories;

import com.example.assignment2.DataAccess.Database.ConnectionHelper;
import com.example.assignment2.DataAccess.Models.Song;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SongRepository {
    private final String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<Song> getRandomGenre() {
        ArrayList<Song> Song = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);

            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT SongName FROM Song");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Song.add(
                        new Song(
                                resultSet.getString("SongName")
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
        return Song;
    }
}
