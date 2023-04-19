package MarketResearchSW;

class Survey 
{
    String surveyID;
    String productName;
    String companyName;
    String question1;
    String question2;
    String question3;

    Survey(String surveyID)
    {
        //initialise all variables based on sID
    }

    Survey(String pname, String cname)
    {
        this.surveyID = pname+cname;
        this.productName = pname;
        this.companyName = cname;
    }
    
    String getSurveyQ1()
    {
        return this.question1;
    }

    String getSurveyQ2()
    {
        return this.question2;
    }

    String getSurveyQ3()
    {
        return this.question3;
    }

    void setSurveyQ1(String q1)
    {
        this.question1 = q1;
    }

    void setSurveyQ2(String q2)
    {
        this.question2 = q2;
    }

    void setSurveyQ3(String q3)
    {
        this.question3 = q3;
    }

    void updateSurvey()
    {
        //use current object to update database
    }

}

class SurveyFilled
{
    String surveyID;
    String answer1;
    String answer2;
    String answer3;

    SurveyFilled(String id)
    {
        this.surveyID = id;
        this.answer1 = "";
        this.answer2 = "";
        this.answer3 = "";
    }

    void fillSurveyForm(User u)
    {
        //update Survey results db with above parameters
    }

    void fillAnswer1(String ans)
    {
        this.answer1 = ans;
    }
    void fillAnswer2(String ans)
    {
        this.answer2 = ans;
    }
    void fillAnswer3(String ans)
    {
        this.answer3 = ans;
    }
}
