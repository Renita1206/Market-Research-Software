package MarketResearchSW;

import java.sql.*;

class MarketResearcher extends User
{
    MarketResearcher(String usr, String pass, String comp, int acl, Role r)
    {
        this.username = usr;
        this.password = pass;
        this.company = comp;
        this.accessLevel = acl;
        this.role = r;
    }

    /*@Override
    ResultSet viewReviews(String product) // view reviews pertaining to a product
    {
        System.out.println("Report for product "  + product + "by company " + this.company);
        //retrieve all reviews for product from review table
        //print everything
    }

    @Override
    ResultSet viewAllReviews() //view all reviews related to company
    {
        System.out.println("Here are all the reviews for company " + this.company);
        //retrieve all related reviews from review table
        //print everything
    }*/

    @Override
    void generateReport(Product p, ReportType type, String loc) //ideally return a downloadable report (that is then pushed to a database?)
    {
        //switch case -> what type of report would you like
        switch(type)
        {
            case PDF:  ReportGeneratorFacade.generateReport(ReportType.PDF, loc, p);
                       break;
            case HTML: ReportGeneratorFacade.generateReport(ReportType.HTML, loc, p);
                       break;
            default: System.out.println("Invalid input");

        }

        System.out.println("Report has been generated");
        
    }

    @Override
    void addProduct(String name, String type, String pID, String company, String cID)
    {
        Product product = new Product(name, type, pID, cID);
        product.addProduct();
    }

    @Override
    void createSurvey(String pname, String cname, String q1, String q2, String q3)
    {
        Survey survey = new Survey(pname, cname);
        survey.setSurveyQ1(q1);
        survey.setSurveyQ2(q2);
        survey.setSurveyQ3(q3);
        // add survey to dbString surveyID;
        survey.updateSurvey();
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
    ResultSet viewCompanyCatalogue() //view all products assoc. to a company
    {
        ResultSet resultSet = null;
        System.out.println("Here is the current catalogue of products for company " + this.company);
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

            String command = "select * from company where name = \"" + this.company + "\";";
            
            resultSet = statement.executeQuery(command);

            //System.out.println(resultSet);
            String cID = "";

            if(resultSet.next()) 
            {
                System.out.println("Company Found");
                cID = resultSet.getString("ID");
            }

            //System.out.println(cID);

            command = "select * from products where companyID = \"" + cID + "\";";
            //System.out.println(command);
            resultSet = statement.executeQuery(command);
            
            /*if(resultSet.next()) 
            {
                System.out.println("Products Found");
            }*/

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
