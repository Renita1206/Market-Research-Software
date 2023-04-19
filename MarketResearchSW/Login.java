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
        //connect to user database and verify details
        System.out.println("Logged in");
        this.logged_in = true;
        User user = new MarketResearcher("username", "password", "company", 0, Role.MarketResearcher);
        // output a user object
        return user;
    }

    void logout()
    {
        System.out.println("Logged out");
        this.logged_in = false;
    }
}