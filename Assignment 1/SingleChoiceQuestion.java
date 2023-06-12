import java.util.*;

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
