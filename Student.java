import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Grade> grades;


    private static final double A_THRESHOLD=90.0;
    private static final double B_THRESHOLD=80.0;
    private static final double C_THRESHOLD=70.0;

    public Student(String name, String id){
        this.name=name;
        this.id=id;
        this.grades=new ArrayList<>();
    }

    //method to add grade
    public void addGrade(String subject,double grade){
        grades.add(new Grade(subject,grade));
    }

    //method to calculate average grade
    public double calculateAverage(){
        double total=0.0;
        for(Grade grade : grades){
            total+=grade.getGrade();
        }
        return total/grades.size();
    }
    //method to determine overall grade
    public char determineOverallGrade(){
        double average = calculateAverage();
        if(average>=A_THRESHOLD){
            return 'A';
        }else if(average>=B_THRESHOLD){
            return 'B';
        }else if(average>=C_THRESHOLD){
            return 'C';
        }else{
            return 'D';
        }

    }

    public void displayPerformance(){
        System.out.println("Student: " + name + " (ID: " + id + ")");
        System.out.println("Grades:");
        for (Grade grade : grades) {
            System.out.println(grade.getSubject() + ": " + grade.getGrade());
        }
        System.out.println("Average Grade: " + calculateAverage());
        System.out.println("Overall Grade: " + determineOverallGrade());
    }
}
