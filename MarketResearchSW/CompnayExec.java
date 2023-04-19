package MarketResearchSW;


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
    void viewCompanyCatalogue() //view all products assoc. to a company
    {
        System.out.println("Here is the current catalogue of products for company " + this.company);
        //retrieve all related products from db
        //print everything
    }

    @Override
    void generateReport(Product p, ReportType type, String loc) //ideally return a downloadable report (that is then pushed to a database?)
    {
        //switch case -> what type of report would you like
        switch(type)
        {
            case PDF:  ReportGeneratorFacade.generateReport(ReportType.PDF, loc, p);
                       break;
            case HTML: ReportGeneratorFacade.generateReport(ReportType.HTML, loc, p);
                       break;
            default: System.out.println("Invalid input");

        }

        System.out.println("Report has been generated");
        
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

