public class User 
{
    private String userID;
    private List<String> followers;
    private List<String> followings;
    private List<String> newsFeed;

    public User(String userID) 
    {
        this.userID = userID;
        this.followers = new ArrayList<>();
        this.followings = new ArrayList<>();
        this.newsFeed = new ArrayList<>();
    }

    // Getters and setters
    // ...
    
    public void postTweet(String message) 
    {
        newsFeed.add(message);
        notifyFollowers(message);
    }
    
    public void followUser(User user) 
    {
        if (!followings.contains(user.getUserID()))
         {
            followings.add(user.getUserID());
            user.addFollower(this);
        }
    }
    
    private void addFollower(User follower) 
    {
        followers.add(follower.getUserID());
    }
    
    private void notifyFollowers(String message) 
    {
        for (String followerID : followers) 
        {
            // Get follower user object and add message to their news feed
        }
    }
}