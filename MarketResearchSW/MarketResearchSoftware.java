package MarketResearchSW;

import java.util.Scanner;

class MarketResearchSoftware
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int num;
        String id,name,type,pID,company,cID,pname,cname,q1,q2,q3;
        Product p;

        System.out.println("Welcome to Market Research Software");

        //input username and password
        System.out.print("Username: ");
        String userName = sc.nextLine();
        System.out.print("Password: ");
        String passWord= sc.nextLine();

        // Creating Login Model
        Login loginobj = new Login();
        
        // Creating User
        User user = loginobj.login(userName, passWord);

        // System.out.println(user.username + " " + user.company);
        
        while(loginobj.logged_in) //that user can do whatever he is allowed to as long as they are logged in
        {
            System.out.println(user.username + " " + user.company);
            // Product P = new Product("Crutches", "Provides support to those who need it", "SLIFGH9876KJ", "LO2F03N4");
            // System.out.println(Product.getProductID("S23", "Samsung"));
            // P.addProduct();
            // user.viewAvailableSurveys();
            // user.createSurvey("S23", user.company, "sdf", "sfgsfgd", "asfg");
            // Survey s = new Survey("SLKFJG20498R");
            // System.out.println(s.getSurveyQ2());
            // user.fillSurvey("SLKFJG20498R", "Good", "Meh", "IDC");
            // user.viewCompanyCatalogue();
            // user.reviewProduct("Samsung", "S23", "Pretty cool", 4);
            // user.viewCatalogue();
            // Product p = Product.getProductDetails("POLKJFG98");
            // String cmp = Product.getProductCompany("POLKJFG98");
            // System.out.println(p.name + "\t" + p.cID + "\t" + p.desc + " \t" + cmp);
            // user.viewAllReviews();
            // user.viewReviews("POLKJFG98");
            // user.generateReport(p, ReportType.PDF, "D:\\Documents\\");

            switch(user.role)
            {
                case CompanyExecutive: //display company exec page
                    System.out.println("*** ROLE: Company Executive ***");
                    System.out.println("1. View Company Catalogue");
                    System.out.println("2. Generate Report");
                    System.out.println("3. View Product Review");
                    System.out.println("4. View All Reviews");
                    System.out.print("Enter CHOICE: ");

                    num = sc.nextInt();

                    switch(num)
                    {
                        case 1:
                            user.viewCompanyCatalogue();
                            break;
                        case 2:
                            System.out.print("Enter Product ID: ");
                            pID = sc.nextLine();
                            p = Product.getProductDetails(pID);
                            System.out.print("Enter Report Format (PDF/HTML): ");
                            type = sc.nextLine();
                            if (type.equals("PDF"))
                                user.generateReport(p, ReportType.PDF);
                            else if(type.equals("HTML"))
                                user.generateReport(p, ReportType.HTML);
                            else
                            {
                                System.out.println("DEFAULT to PDF");
                                user.generateReport(p, ReportType.PDF);
                            }
                            break;
                        case 3:
                            System.out.print("Enter Product ID: ");
                            id = sc.nextLine();
                            user.viewReviews(id);
                            break;
                        case 4:
                            user.viewAllReviews();
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                    break;

                case MarketResearcher: //display market researcher page
                    System.out.println("*** ROLE: Market Researcher ***");
                    System.out.println("1. Generate Report");
                    System.out.println("2. Add Product");
                    System.out.println("3. Create Survey");
                    System.out.println("4. View Available Surveys");
                    System.out.println("5. View Company Catalogue");
                    System.out.println("6. View Product Review");
                    System.out.println("7. View All Reviews");
                    
                    System.out.print("Enter CHOICE: ");

                    num = sc.nextInt();

                    switch(num)
                    {
                        case 1:
                            System.out.print("Enter Product ID: ");
                            pID = sc.nextLine();
                            p = Product.getProductDetails(pID);
                            System.out.print("Enter Report Format (PDF/HTML): ");
                            type = sc.nextLine();
                            if (type.equals("PDF"))
                                user.generateReport(p, ReportType.PDF);
                            else if(type.equals("HTML"))
                                user.generateReport(p, ReportType.HTML);
                            else
                            {
                                System.out.println("DEFAULT to PDF");
                                user.generateReport(p, ReportType.PDF);
                            }
                            break;
                        case 2:
                            System.out.print("Enter Product name: ");
                            name = sc.nextLine();
                            System.out.print("Enter Type of Product: ");
                            type = sc.nextLine();
                            System.out.print("Enter Product ID: ");
                            pID = sc.nextLine();
                            company = user.company;
                            System.out.print("Enter Company ID ");
                            cID = sc.nextLine();
                            user.addProduct(name, type, pID, company, cID);
                            break;
                        case 3:
                            System.out.print("Enter Product name: ");
                            pname = sc.nextLine();
                            cname = user.company;
                            System.out.println("Enter First Question");
                            q1 = sc.nextLine();
                            System.out.println("Enter Second Question");
                            q2 = sc.nextLine();
                            System.out.println("Enter Third Question");
                            q3 = sc.nextLine();
                            user.createSurvey(pname,cname,q1,q2,q3);
                            break;
                        case 4:
                            user.viewAvailableSurveys();
                            break;
                        case 5:
                            user.viewCompanyCatalogue();
                            break;
                        case 6:
                            System.out.print("Enter Product ID: ");
                            pID = sc.nextLine();
                            user.viewReviews(pID);
                            break;
                        case 7:
                            user.viewAllReviews();
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                    break;

                case Customer:         //display customer page
                    System.out.println("ROLE: Customer");
                    System.out.println("1. Fill Survey");
                    System.out.println("2. View Available Survey");
                    System.out.println("3. Review product");
                    System.out.println("4. View Catalogue");
                    
                    System.out.print("Enter CHOICE: ");

                    num = sc.nextInt();

                    switch(num)
                    {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            user.viewCatalogue();
                            break;
                        default:
                            System.out.println("Invalid Choice");
                            break;
                    }
                    break;

                default:                    //display company exec page
                    break;
            }

            loginobj.logout();
        }

        sc.close();
    }
}
