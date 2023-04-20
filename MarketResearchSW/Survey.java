package MarketResearchSW;

import java.sql.*;
import java.util.Random;

class Survey 
{
    String surveyID;
    String productName;
    String companyName;
    String question1;
    String question2;
    String question3;

    Survey(String surveyID)
    {
        //initialise all variables based on sID
    }

    Survey(String pname, String cname)
    {
        Random rand = new Random();
        this.surveyID = pname+cname+ rand.nextInt(1000);
        this.productName = pname;
        this.companyName = cname;
    }
    
    String getSurveyQ1()
    {
        return this.question1;
    }

    String getSurveyQ2()
    {
        return this.question2;
    }

    String getSurveyQ3()
    {
        return this.question3;
    }

    void setSurveyQ1(String q1)
    {
        this.question1 = q1;
    }

    void setSurveyQ2(String q2)
    {
        this.question2 = q2;
    }

    void setSurveyQ3(String q3)
    {
        this.question3 = q3;
    }

    void updateSurvey()
    {
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

            String pID = Product.getProductID(this.productName, this.companyName);
            //check if survey exists, if not then add else update
            //get pID from products table using name and co
            String command = "insert into survey values(\"" + this.surveyID + "\",\"" + pID + "\",\"" + this.question1 + "\",\"" + this.question2 + "\",\"" + this.question3 + "\");";
            System.out.println(command);
            statement.executeUpdate(command);

            statement.close();
            connection.close();

        }
        catch(Exception e)
        {
            //something
        }
    }

}

class SurveyFilled
{
    String surveyID;
    String answer1;
    String answer2;
    String answer3;

    SurveyFilled(String id)
    {
        this.surveyID = id;
        this.answer1 = "";
        this.answer2 = "";
        this.answer3 = "";
    }

    void fillSurveyForm(User u)
    {
        //update Survey results db with above parameters
    }

    void fillAnswer1(String ans)
    {
        this.answer1 = ans;
    }
    void fillAnswer2(String ans)
    {
        this.answer2 = ans;
    }
    void fillAnswer3(String ans)
    {
        this.answer3 = ans;
    }
}
