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
//Specific type of question
class MCQuestion extends Question
{
    public MCQuestion(List<String> submittedAnswers)
    {
        super("multiple-choice", submittedAnswers);
    }

    public boolean isValidAnswer(List<String> choices)
    {
        //Any combo is valid, so we can return true whenever.
        return true;
    }
}
//Specific type of question
class SCQuestion extends Question
{
    public SCQuestion(List<String> submittedAnswers)
    {
        super("single-choice", submittedAnswers);
    }

    public boolean isValidAnswer(List<String> choices)
    {
        //Only one choice is allowed.
        return choices.size() == 1;
    }
}
