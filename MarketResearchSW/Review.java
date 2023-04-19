package MarketResearchSW;

import java.util.Date;

class Review 
{
    String pID;
    String review;
    int rating;
    Date dateOfReview;

    Review(String id, String rev, int rating)
    {
        this.pID = id;
        this.review = rev;
        this.rating = rating;
        this.dateOfReview = new Date();
    }

    void addReview(User u)
    {
        //update database with review details
    }
}
