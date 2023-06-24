public interface UserInterface 
{
    public String getID();

    public void setID(String userID);
    
    public boolean isGroup(UserInterface group);

    public void accept(AnalyzerInterface visitor);
}