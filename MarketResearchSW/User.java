package MarketResearchSW;

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

    void generateReport(Product p) //ideally return a downloadable report that is then pushed to a database
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
