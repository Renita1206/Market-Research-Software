package MarketResearchSW;

class Login
{
    boolean logged_in;

    Login()
    {
        this.logged_in = false;
    }

    User login(String username, String password)
    {
        //connect to user database and verify details, once verified get access level and role
        System.out.println("Logged in");
        this.logged_in = true;
        Role role = Role.MarketResearcher;
        String company = "company";
        int acl = 0;
        
        User user = null;
        
        switch(role)
        {
            case MarketResearcher: user = new MarketResearcher(username, password, company, acl, Role.MarketResearcher); break;
            case CompanyExecutive: user = new CompanyExec(username, password, company, acl, Role.CompanyExecutive); break;
            case Customer:         user = new Customer(username, password, null, 0, Role.Customer); break;
        }
        // output a user object
        return user;
    }

    void logout()
    {
        System.out.println("Logged out");
        this.logged_in = false;
    }
}