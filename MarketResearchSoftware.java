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
            user.viewReport("null");
            user.viewAllReviews();
            loginobj.logout();
        }

        sc.close();
    }
}

class Login
{
    boolean logged_in;

    Login()
    {
        this.logged_in = false;
    }

    User login(String username, String password)
    {
        //connect to user database and verify details
        System.out.println("Logged in");
        this.logged_in = true;
        User user = new CompanyExec("username", "password", "company", 0, Role.CompanyExecutive);
        // output a user object
        return user;
    }

    void logout()
    {
        System.out.println("Logged out");
        this.logged_in = false;
    }
}

enum Role
{
    CompanyExecutive,
    MarketResearcher,
    Customer
}

class User
{
    String username;
    String password;
    String company;
    int accessLevel;
    Role role;

    void viewCatalogue() //view all products assoc. to a company
    {
        errorMsg();
    }
    
    void viewReport(String product) //view summary report of a particular product based on reviews like avg rating etc
    {
        errorMsg();
    }
    
    void viewReviews(String product) // view reviews pertaining to a product
    {
        errorMsg();
    }

    void viewAllReviews() //view all reviews related to company
    {
        errorMsg();
    }

    void generateReport() //ideally return a downloadable report that is then pushed to a database
    {
        errorMsg();
    }
    void editCatalogue()
    {
        errorMsg();
    }
    void createSurvey()
    {
        errorMsg();
    }
    void editEmailData()
    {
        errorMsg();
    }
    void sendEmails()
    {
        errorMsg();
    }

    void fillSurvey(String surveyID)
    {
        errorMsg();
    }
    void viewAvailableSurveys()
    {
        errorMsg();
    }
    void checkCatalogue() //check if product in catalogue
    {
        errorMsg();
    }
    void reviewProduct(String company, String product)
    {
        errorMsg();
    }

    void errorMsg()
    {
        System.out.println("Method not applicable");
    }

}

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
    void viewCatalogue() //view all products assoc. to a company
    {
        System.out.println("Here is the current catalogue of products for company " + this.company);
        //retrieve all related products from catalogue table
        //print everything
    }

    @Override
    void viewReport(String product) //view summary report of a particular product based on reviews like avg rating etc
    {
        System.out.println("Report for product "  + product + "by company " + this.company);
        //retrieve report from report table
        //give option to view or download
    }

    @Override
    void viewReviews(String product) // view reviews pertaining to a product
    {
        System.out.println("Report for product "  + product + "by company " + this.company);
        //retrieve all reviews for product from review table
        //print everything
    }

    @Override
    void viewAllReviews() //view all reviews related to company
    {
        System.out.println("Here are all the reviews for company " + this.company);
        //retrieve all related reviews from review table
        //print everything
    }
}

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
    void fillSurvey(String surveyID)
    {
       //extract questions for this survey id from survey questions table
       //get customer answers
       //put answers back in db
       //confirmation msg
    }

    @Override
    void viewAvailableSurveys()
    {
        //look up db
        //display available surveys - ie. survey name, product/company
    }

    @Override
    void checkCatalogue() //check if product in catalogue
    {
        //look up db
        //display available products ordered by company
    }

    @Override
    void reviewProduct(String company, String product)
    {
        //get review and rating from user
        //put into db
        //get confirmation msg
    }
}

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

    @Override
    void viewCatalogue() //view all products assoc. to a company
    {
        System.out.println("Here is the current catalogue of products for company " + this.company);
        //retrieve all related products from catalogue table
        //print everything
    }

    @Override
    void viewReport(String product) //view summary report of a particular product based on reviews like avg rating etc
    {
        System.out.println("Report for product "  + product + "by company " + this.company);
        //retrieve report from report table
        //give option to view or download
    }

    @Override
    void viewReviews(String product) // view reviews pertaining to a product
    {
        System.out.println("Report for product "  + product + "by company " + this.company);
        //retrieve all reviews for product from review table
        //print everything
    }

    @Override
    void viewAllReviews() //view all reviews related to company
    {
        System.out.println("Here are all the reviews for company " + this.company);
        //retrieve all related reviews from review table
        //print everything
    }

    @Override
    void generateReport() //ideally return a downloadable report that is then pushed to a database
    {
        //Use something similar to facade example, facade pattern, option of HTML, pdf report
        // Builder pattern for adding stats and then visualizations?
    }

    @Override
    void editCatalogue()
    {
        // make changes to catalogue database
    }

    @Override
    void createSurvey()
    {
        // add survey to db
    }

    @Override
    void editEmailData()
    {
        // add email to db
    }

    @Override
    void sendEmails()
    {
        // send out emails to addresses from db
    }

    @Override
    void viewAvailableSurveys()
    {
        //look up db
        //display available surveys - ie. survey name, product/company
    }

    @Override
    void checkCatalogue() //check if product in catalogue
    {
        //look up db
        //display available products ordered by company
    }

}

// Other classes that can possibly be added - a class each for Catalogue, Email, Review, Survey to ensure single responsibility principle is maintained.
// Facade pattern, Builder pattern, prototype pattern for Survey
//MVC arch. ----idk how rn
// DAO/Proxy pattern for auth. using access level?

