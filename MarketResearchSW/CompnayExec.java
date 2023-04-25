package MarketResearchSW;

import java.sql.*;

class CompanyExec extends User
{
    CompanyExec(String usr, String pass, String comp, int acl, Role r)
    {
        this.username = usr;
        this.password = pass;
        this.company = comp;
        this.accessLevel = acl;
        this.role = r;
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

    @Override
    void generateReport(Product p, ReportType type) //ideally return a downloadable report (that is then pushed to a database?)
    {
        //switch case -> what type of report would you like
        switch(type)
        {
            case PDF:  ReportGeneratorFacade.generateReport(ReportType.PDF, p);
                       break;
            case HTML: ReportGeneratorFacade.generateReport(ReportType.HTML, p);
                       break;
            default: System.out.println("Invalid input");

        }

        System.out.println("Report has been generated");
        
    }

    @Override
    ResultSet viewAllReviews() //view all products assoc. to a company
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

            command = "select * from review as R where r.PID in (select ID from products where companyID = \"" + cID +"\");";
            //System.out.println(command);
            resultSet = statement.executeQuery(command);
            
            /*if(resultSet.next()) 
            {
                System.out.println("Products Found");
            }*/

            while(resultSet.next()) 
            {
                String review = resultSet.getString("review");
                int rating = resultSet.getInt("rating");

                System.out.println(rating + "\t" + review);

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

    @Override
    ResultSet viewReviews(String productID) // view reviews pertaining to a product
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

            command = "select * from review as R where r.PID in (select ID from products where companyID = \"" + cID +"\") and pid = \"" + productID + "\";";
            //System.out.println(command);
            resultSet = statement.executeQuery(command);
            
            /*if(resultSet.next()) 
            {
                System.out.println("Products Found");
            }*/

            while(resultSet.next()) 
            {
                String review = resultSet.getString("review");
                int rating = resultSet.getInt("rating");

                System.out.println(rating + "\t" + review);

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

