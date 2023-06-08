import utils;
import java.util.*;

//Class for our questions - this is our constructor for the questions.
abstract class Question 
{
    protected String questionType;
    protected List<String> submittedAnswers;

    public Question(String questionType, List<String> submittedAnswers)
    {
        this.questionType = questionType;
        this.submittedAnswers = submittedAnswers;
    }

    //getters for answers and question types
    public String getQuestionType()
    {
        return questionType;
    }

    public List<String> getsubmittedAnswers()
    {
        return submittedAnswers;
    }

    //Checker for whether or not answer is valid.
    public abstract boolean isValidAnswer(List<String> choices);
}