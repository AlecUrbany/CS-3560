public class UserGroup 
{
    private String groupID;
    private List<User> users;
    private List<UserGroup> subGroups;

    public UserGroup(String groupID) 
    {
        this.groupID = groupID;
        this.users = new ArrayList<>();
        this.subGroups = new ArrayList<>();
    }

    // Getters and setters
    // ...
    
    public void addUser(User user) 
    {
        users.add(user);
    }
    
    public void addGroup(UserGroup group) 
    {
        subGroups.add(group);
    }
    
    public void notifyUsers(String message) 
    {
        for (User user : users) 
        {
            user.addMessageToNewsFeed(message);
        }
        for (UserGroup group : subGroups) 
        {
            group.notifyUsers(message);
        }
    }
}