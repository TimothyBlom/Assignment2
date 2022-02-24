package com.example.assignment2.DataAccess.Repositories;

import com.example.assignment2.DataAccess.Database.ConnectionHelper;
import com.example.assignment2.DataAccess.Models.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//Collects random song names from the SQLite database
public class TrackRepository {
    private final String URL = ConnectionHelper.CONNECTION_URL;
    private Connection conn = null;

    public ArrayList<Track> getRandomTracks(int trackCount) {
        ArrayList<Track> randomTracks = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(URL);
            String selectQuery = "SELECT Name FROM Track ORDER BY random() LIMIT ?";

            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
            preparedStatement.setInt(1, trackCount);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                randomTracks.add(
                        new Track(
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
        return randomTracks;
    }
}
