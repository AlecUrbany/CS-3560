import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class User implements UserInterface
{
    private String userID;
    
    private Set<FollowerInterface> followers;

    private Set<PosterInterface> following;

    private List<String> timeline;

    public User()
    {
        this.userID = IDValidator.getInstance().findValidID();
        initializeUser();
    }

    public User(String userID)
    {
        this.setID(userID);
        initializeUser();
    }

    private void initializeUser()
    {
        UserManager.getInstance().addItem(this);
        followers = new HashSet<FollowerInterface>();
        following = new HashSet<PosterInterface>();
        timeline = new ArrayList<String>();   
    }

    @Override
    public void setID(String generatedID)
    {
        //Checks to see if ID has been made
        IDValidator.getInstance().useID(generatedID);
        this.userID = generatedID;

        //If it's already in use, will refuse to use this ID
        IDValidator.getInstance().dropID(userID);
    }

    public String getID()
    {
        return this.userID;
    }

    public String getFormattedID(String indentation)
    {
        return indentation + "- " + this.userID;
    }


    public boolean isRelated(UserInterface other)
    {
        return this.getID().equals(other.getID());
    }

    public void followUser(String targetID)
    {
        if (targetID.equals(this.userID))
        {
            throw new IllegalArgumentException("A User cannot follow themselves.");
        }

        User user = UserManager.getInstance().findItem(targetID);
        this.following.add(user);
        user.addFollower(this);
    }   

    public void addFollower(FollowerInterface follower){
        this.followers.add(follower);
    }

    public Set<FollowerInterface> getFollowers(){
        return this.followers;
    }

    public Set<PosterInterface> getFollowing(){
        return this.following;
    }

    public void post(String message){
        //Display post to ourselves
        this.timeline.add(this.userID +  message);

        //Display post to followers
        for(FollowerInterface follower : followers){
            follower.update(this.userID, message);
        }
    }

    public void update(String posterID, String message)
    {
        this.timeline.add(posterID + ": " + message);
    }

    public List<String> gettimeline()
    {
        return this.timeline;
    }

    public void accept(AnalyzerInterface visitor)
    {
        visitor.visitUser(this);
        visitor.visitTimeline(this.timeline);
    }

    public String toString()
    {
        return "User(" + getID() + ")";
    }

}