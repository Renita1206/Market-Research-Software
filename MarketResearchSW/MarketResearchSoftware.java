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
        User user = loginobj.login("Renita Kurian", "Password");
        while(loginobj.logged_in) //that user can do whatever he is allowed to as long as they are logged in
        {
            //System.out.println(user.username + " " + user.company);
            Product P = new Product("Crutches", "Provides support to those who need it", "SLIFGH9876KJ", "LO2F03N4");
            //System.out.println(P.cID + " " + P.name + " " + P.desc);
            P.addProduct();
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

            loginobj.logout();
        }

        sc.close();
    }
}