package MarketResearchSW;


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
       Survey survey = new Survey(surveyID);
       //SOP(survey.getSurveyQ1())
       //get customer answers
       SurveyFilled answers = new SurveyFilled(surveyID);
       answers.fillAnswer1("answer1");
       //put answers back in db
       answers.fillSurveyForm(this);
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
        Catalogue catalogue = new Catalogue(this.company);
        //display available products ordered by company
        //just have to print out from the catalogue list
    }

    @Override
    void reviewProduct(String company, String product)
    {
        //get product id from product name and company
        String pID = Product.getProductID(product, company);
        //get review and rating from user
        Review review = new Review(pID, "review", 3);
        //put into db
        review.addReview(this);
        //get confirmation msg
    }
}
