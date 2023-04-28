package MarketResearchSW;

import java.util.Date;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class Review 
{
    String pID;
    String review;
    int rating;
    Date dateOfReview;

    Review(String id, String rev, int rating)
    {
        this.pID = id;
        this.review = rev;
        this.rating = rating;
        this.dateOfReview = new Date();
    }

    void addReview(User u) 
    {
        String url = "jdbc:mysql://localhost:3306/marketresearchsw";
        String username = "root";
        String password = "";
        
        try 
        {

            Connection conn = DriverManager.getConnection(url, username, password);

            Random rand = new Random();
            String newID = this.pID + username + rand.nextInt(1000);

            String sql = "INSERT INTO review VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newID);
            statement.setString(2, this.pID);
            statement.setString(3, u.username); 
            statement.setDate(4, new java.sql.Date(this.dateOfReview.getTime()));
            statement.setInt(5, this.rating);
            statement.setString(6, this.review);
            
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Review added successfully!");
            }
            conn.close();
        } 
        catch (SQLException ex) 
        {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}