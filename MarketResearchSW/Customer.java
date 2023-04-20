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
        String pID = "d";
        //get review and rating from user
        Review review = new Review(pID, productReview, rating);
        //put into db
        review.addReview(this);
        //get confirmation msg
    }
}
