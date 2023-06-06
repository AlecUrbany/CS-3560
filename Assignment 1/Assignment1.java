import java.util.*;

//Class for Student
class Student
{
    //initializes student ID's
    private String id;

    public Student(String id)
    {
        this.id = id;
    }
    //Will return student ID's
    public String getId()
    {
        return id;
    }
}

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

//The driver for the simulation
class SimulationDriver
{
    public static void main(String[] args)
    {
        //Setting up the questions and answers.
        List<String> submittedAnswers = Arrays.asList("A", "B", "C", "D");
        Question question = new MCQuestion(submittedAnswers);

        //setting up the voting service
        VotingService votingService = new VotingService(question);

        //Randomly generated student submissions
        Random random = new Random();

        //Generate a random number of students. Can change from random to a fixed number if required
        int numStudents = random.nextInt(25) + 1; 
        for (int i = 1; i <= numStudents; i++)
        {
            String studentId = "Student " + i;

            //Generate random choices for the students
            //Random number of choices (including 0)
            int numChoices = random.nextInt(submittedAnswers.size() + 1);
            List<String> choices = new ArrayList<>();
            for (int j = 0; j < numChoices; j++)
            {
                int index = random.nextInt(submittedAnswers.size());
                choices.add(submittedAnswers.get(index));
            }

            Student student = new Student(studentId);
            votingService.submitAnswer(student, choices);
        }

        // Print the statistics
        System.out.println("Number of Student Responses:");
        System.out.println(numStudents);
        votingService.printStatistics();
    }
}