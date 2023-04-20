package MarketResearchSW;

//import java.util.List;

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
    void fillSurvey(String surveyID, String a1, String a2, String a3)
    {
       SurveyFilled answers = new SurveyFilled(surveyID);
       answers.fillAnswer1(a1);
       answers.fillAnswer2(a2);
       answers.fillAnswer3(a3);
       //put answers back in db
       answers.fillSurveyForm(this);
       //confirmation msg
       System.out.println("Survey has been filled");
    }

    @Override
    void viewAvailableSurveys()
    {
        //Connect to database and then 
    }

    @Override
    void viewCatalogue() //check if product in catalogue
    {
        //Catalogue catalogue = new Catalogue(this.company);
        //display available products ordered by company
        //return catalogue.products;
    }

    @Override
    void reviewProduct(String company, String product, String productReview, int rating)
    {
        //get product id from product name and company
        String pID = Product.getProductID(product, company);
        //get review and rating from user
        Review review = new Review(pID, productReview, rating);
        //put into db
        review.addReview(this);
        //get confirmation msg
    }
}
