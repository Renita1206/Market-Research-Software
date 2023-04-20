package MarketResearchSW;

import java.sql.*;

class Product
{
    String name;
    String desc;
    String pID;
    String cID;

    Product(String name, String desc, String pID, String cID)
    {
        this.name = name;
        this.desc = desc;
        this.pID = pID;
        this.cID = cID;
    }

    static Product getProductDetails(String pID)
    {
        Connection connection = null;
        Product p = null;
        try 
        {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/marketresearchsw",
                "root", "");
 
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                "select * from products where id = \"" + pID + "\";");

            //System.out.println(resultSet);

            if(resultSet.next()) 
            {
                System.out.println("Product Found");

                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                String cID = resultSet.getString("companyID");
                
                p = new Product(name, desc, pID, cID);
                
            }
        }
        catch(Exception e)
        {
            //something
        }

        return p;
        
    }

    void addProduct()
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

            String command = "insert into products values(\"" + this.pID + "\",\"" + this.name + "\",\"" + this.desc + "\",\"" + this.cID + "\");";
            System.out.println(command);
            statement.executeUpdate(command);

        }
        catch(Exception e)
        {
            //something
        }
    }
}