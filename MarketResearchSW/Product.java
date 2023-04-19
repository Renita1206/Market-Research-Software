package MarketResearchSW;

class Product
{
    String name;
    String type;
    String pID;
    String company;
    String cID;

    Product(String name, String type, String pID, String company, String cID)
    {
        this.name = name;
        this.type = type;
        this.pID = pID;
        this.company = company;
        this.cID = cID;
    }

    void getProductDetails(String pID)
    {
        //connect to DB and retreive product info
    }

    void setProductDetails(String pID)
    {
        // edit db
    }

    static String getProductID(String product, String company)
    {
        String pID = "asfg";
        //Crosscheck against database and init value
        return pID;
    }
}