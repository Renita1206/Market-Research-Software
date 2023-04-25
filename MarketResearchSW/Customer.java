package MarketResearchSW;

import java.sql.*;

//import java.util.List;

class Customer extends User
{
    Customer(String usr, String pass, String comp, int acl, Role r)
    {
        this.username = usr;
        this.password = pass;
        this.company = comp;
        this.accessLevel = acl;
        this.role = r;
    }

    @Override
    void fillSurvey(String surveyID, String a1, String a2, String a3)
    {
       SurveyFilled answers = new SurveyFilled(surveyID);
       answers.fillAnswer1(a1);
       answers.fillAnswer2(a2);
       answers.fillAnswer3(a3);
       //put answers back in db
       answers.fillSurveyForm(this);
       //confirmation msg
       System.out.println("Survey has been filled");
    }

    @Override
    ResultSet viewAvailableSurveys()
    {
        Connection connection = null;
        ResultSet resultSet = null;
        try 
        {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/marketresearchsw",
                "root", "");
 
            Statement statement;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                "select * from survey;");

            //System.out.println(resultSet);

            if(!resultSet.next()) 
            {
                System.out.println("No Availably Surveys");
            }

            //System.out.println(resultSet.getString("ID").trim());

            statement.close();
            connection.close();
            
        }
        catch(Exception e)
        {
            //something
        }
        
        return resultSet;

    }

    @Override
    void reviewProduct(String company, String product, String productReview, int rating)
    {
        String pID = Product.getProductID("S23", "Samsung");
        //get review and rating from user
        Review review = new Review(pID, productReview, rating);
        //System.out.println(review.pID + "\t" + review.rating + "\t" + review.review + "\t" + review.dateOfReview);
        //put into db
        review.addReview(this);
        //get confirmation msg
    }

    @Override
    ResultSet viewCatalogue() //view all products assoc. to a company
    {
        ResultSet resultSet = null;
        //retrieve all related products from db
        Connection connection = null;

        try 
        {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/marketresearchsw",
                "root", "");
 
            Statement statement;
            statement = connection.createStatement();

            String command = "select * from products;";
            //System.out.println(command);
            resultSet = statement.executeQuery(command);
            

            while(resultSet.next()) 
            {
                String product = resultSet.getString("name");
                String pID = resultSet.getString("ID");
                String desc = resultSet.getString("description");

                System.out.println(pID + "\t" + product + "\t" + desc);

            }

            statement.close();
            connection.close();

        }
        catch(Exception e)
        {
            //something
        }

        return resultSet;
    }
}
