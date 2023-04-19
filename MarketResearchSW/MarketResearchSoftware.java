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
            switch(user.role)
            {
                case CompanyExecutive: //display company exec page
                                            break;
                case MarketResearcher: //display market researcher page
                                            break;
                case Customer:         //display customer page
                                            break;
                default:                    //display company exec page
                                            break;
            }
        }

        sc.close();
    }
}