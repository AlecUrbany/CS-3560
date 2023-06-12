import java.util.*;

class VotingService
{
    private Question question;
    private Map<String, List<String>> submissions;

    public VotingService(Question question)
    {
        this.question = question;
        this.submissions = new HashMap<>();
    }

    public void submitAnswer(Student student, List<String> choices)
    {
        if (question.isValidAnswer(choices))
        {
            submissions.put(student.getId(), choices);

            //These are for debugging. Checking to make sure all students have unique ID's and valid answers.
            //Commented out for brevity.
            //System.out.println("ID and Answer:");
            //System.out.println(student.getId());
            //System.out.println(choices);
        }
    }

    public void printStatistics()
    {
        System.out.println("Submission Statistics:");
        for (String answer : question.getsubmittedAnswers())
        {
            int count = 0;
            for (List<String> choices : submissions.values())
            {
                if (choices.contains(answer))
                {
                    count++;
                }
            }
            System.out.println(answer + " : " + count);
        }
    }
}
