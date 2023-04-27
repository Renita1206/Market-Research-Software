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
            //Product P = new Product("Something", "Provides support to those who need it", "SLIFGH9876KJ", "LO2F03N4");
            //System.out.println(Product.getProductID("S23", "Samsung"));
            //P.addProduct();
            //user.viewAvailableSurveys();
            //user.createSurvey("S23", user.company, "Q1", "Q2", "Q3");
            /*Survey s = new Survey("S23Samsung267");
            System.out.println(s.getSurveyQ2());
            try 
            {
                Survey s1 = (Survey) s.clone();
                System.out.println(s1.getSurveyQ2());
            } 
            catch (CloneNotSupportedException e) 
            {
                System.out.println("Something went wrong while cloning");
            }*/
            //user.fillSurvey("SLKFJG20498R", "Good", "Meh", "IDC");
            //user.viewCompanyCatalogue();
            //user.reviewProduct("Samsung", "S23", "Pretty cool", 4);
            //user.viewCatalogue();
            //Product p = Product.getProductDetails("POLKJFG98");
            //String cmp = Product.getProductCompany("POLKJFG98");
            //System.out.println(p.name + "\t" + p.cID + "\t" + p.desc + " \t" + cmp);
            //user.viewAllReviews();
            //user.viewReviews("POLKJFG98");
            //user.generateReport(p, ReportType.PDF);
        
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