import utils;
import java.util.*;


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
