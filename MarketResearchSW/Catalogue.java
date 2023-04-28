package MarketResearchSW;

import java.util.List;

class Catalogue
{
    // Reference to refer to list of books.
    List<Product> products;
 
    // Constructor of this class
    Catalogue(String company)
    {
        //connect to db and get products of this company and add to list
    }

    Catalogue()
    {
        //catalogue of all products
    }

    public List<Product> getCatalogue()
    {
        return products;
    }

    void addItem(Product p)
    {
        this.products.add(p);
    }

    //Function to edit a certain product - use setProductDetails
    
}