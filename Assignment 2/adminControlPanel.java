public class AdminControlPanel
{
    private List<User> users;
    private UserGroup rootGroup;

    public AdminControlPanel()
    {
        this.users = new ArrayList<>();
        this.rootGroup = new UserGroup("Root");
    }

    // Getters and setters
    // ...
    
    public void createUser(String userID)
    {
        User user = new User(userID);
        users.add(user);
        rootGroup.addUser(user);
    }
    
    public void createGroup(String groupID)
    {
        UserGroup group = new UserGroup(groupID);
        rootGroup.addGroup(group);
    }
    
    public int getTotalUsers()
    {
        return users.size();
    }
    
    public int getTotalGroups()
    {
        // Implement logic to calculate total groups
    }
    
    public int getTotalTweets()
    {
        // Implement logic to calculate total tweets
    }
    
    public double getPositiveTweetsPercentage()
    {
        // Implement logic to calculate percentage of positive tweets
    }
}