package MarketResearchSW;

import java.util.Scanner;

class MarketResearchSoftware
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("Welcome to Market Research Software");
        Login loginobj = new Login();
        //input username and password
        User user = loginobj.login("username", "password");
        while(loginobj.logged_in) //that user can do whatever he is allowed to as long as they are logged in
        {
            //switch case -> for each type of user diff interface
            Product p = new Product("name", "mobile", "alshdg", "Samsung", "alskbf");
            System.out.println("CP1");
            user.generateReport(p);
            user.checkCatalogue();
        }

        sc.close();
    }
}