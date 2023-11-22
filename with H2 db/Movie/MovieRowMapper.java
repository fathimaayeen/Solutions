/*
 * You can use the following import statements
 *
 * 
 *
 */

// Write your code here
package com.example.movie.model;



import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Movie(
                rs.getInt("movieId"),
                rs.getString("movieName"),
                rs.getString("leadActor"));
    }
}
