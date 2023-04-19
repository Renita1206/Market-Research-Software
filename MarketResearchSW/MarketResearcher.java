package MarketResearchSW;


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
    void generateReport(Product p) //ideally return a downloadable report that is then pushed to a database
    {
        //switch case -> what type of report would you like
        ReportGeneratorFacade.generateReport(ReportType.HTML, null, p);
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
