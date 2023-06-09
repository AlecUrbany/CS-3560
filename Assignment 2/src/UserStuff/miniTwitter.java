import java.util.*;

//The driver for the simulation
class SimulationDriver
{
    public static void main(String[] args)
    {
        //Setting up the questions and answers.
        List<String> submittedAnswers = Arrays.asList("A", "B", "C", "D");
        Question question1 = new MCQuestion(submittedAnswers);
        Question question2 = new SCQuestion(submittedAnswers);
        //random question either mult choice or single choice
        Random rand=new Random();
        int x = rand.nextInt(2);
        Question question;
        if(x == 0)
        {
            question = question1;
        }
        else
        {
            submittedAnswers = Arrays.asList("A", "B");
            question = question2;
        }
        System.out.println(question);

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