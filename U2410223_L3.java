import java.util.ArrayList;
import java.util.List;

// TASK 1: Base abstraction

abstract class CommunityMember{
    private int id;
    private String name;

    //instance initializer
    { 
        System.out.println("CommunityMember instance init");
    }

    // TASK 5 parent constructor
    public CommunityMember(int id,String name) {
        this.id = id;
        this.name = name;
    }
    //accessors
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    //mutators
    public int getId(){return id;}
    public String getName(){return name;}
    
    @Override
    public String toString(){
        return "id: "+id+"\nname: "+name; 
    }
    
    abstract public String getRole();
    
}

// Subclass: Student

class Student extends CommunityMember{
    private double gpa;

// TASK 5 Constructor with super reference
    public Student(int id,String name,double gpa){
        super(id, name);
        this.gpa = gpa;
    } 
    //accessors
    public void setGpa(double gpa){
        this.gpa = gpa;
    }
    //mutators
    public double getGpa(){
        return gpa;
    } 
    @Override
    public String toString(){
        return super.toString()+"\nGPA: "+gpa;
        
    }
    @Override
    public String getRole(){
        return "Student";
    }

}

// Subclass: Professor

class Professor extends CommunityMember{
    private String departament;

// TASK 5 constructor with super reference

    public Professor(int id,String name,String deparatemnt){
        super(id, name);
        this.departament = deparatemnt;
    }
    //accessors
    public void setDepartament(String departament){
        this.departament = departament;
    }

    //mutators
    public String getDepartament(){
        return departament;
    }

    @Override
    public String toString(){
        return super.toString()+"\nDepartment: "+departament;
    }

    @Override
    public String getRole(){
        return "Professor";
    }
}

// Subclass: Staff

class Staff extends CommunityMember{
    private String title;
// TASK 5 constructor with super reference
    public Staff(int id,String name,String title) {
        super(id,name);
        this.title = title;
    }

    //mutators
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){ return title;}

    
    @Override
    public String toString(){
        return super.toString()+"\nTitle: "+title;
    }

    @Override
    public String getRole(){
        return "Staff";
    }
    
}


//TASK 2 : Course

class Course{
    private String courseCode;
    private String courseName;
    private Professor instructor;
    private ArrayList<Student> enrolledStudents= new ArrayList<>();

    public Course(String courseCode,String courseName,Professor instuctor){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instuctor;
    }

//TASK 4 Enroll

    public void enrollStudent(Student s){
        enrolledStudents.add(s);
        System.out.println("Student " +s.getName()+ " added to course "+courseName);

    }
    //overloaded method with addAll method using ArrayList
    public void enrollStudent(ArrayList<Student> students){
        enrolledStudents.addAll(students);
    }
    
//===================================================================/

    public void printClassList(){
        System.out.println("Course code: "+courseCode);
        System.out.println("Course name: "+courseName);
        System.out.println("Instructor: "+instructor.toString());
        System.out.println("Enrolled Students: ");
        for(Student i:enrolledStudents){
            System.out.println(i.toString());
        }
        
    }



}
class UniversityLab {
    public static void main(String[] args){

    //TASK 3 Create some members

       Professor p1 = new Professor(10001, "Steftcho P.Dokov", "Computer Science");
        Professor p2 = new Professor(10002, "Rano Shodiyeva", "Academic English");

        Student student1 = new Student(2410201, "Behruz", 4.12);
        Student student2 = new Student(2410252, "Lochinbek", 4.3);
        Student student3 = new Student(2410202, "Muhammad", 3.3);
        Student student4 = new Student(2410205, "Orzubek", 2.1);

        Staff staff1 = new Staff(1200001, "Javlon","Admin Assistant");

    // Create courses

       Course course1 = new Course("Soc2025", "Data Strucure and Algorithms",p1);
       Course course2 = new Course("Soc2023", "Academic English",p2);

    // Enroll students

       course1.enrollStudent(student4);
       course1.enrollStudent(student1);
       course2.enrollStudent(student3);
       course2.enrollStudent(student2);

    // Polymorphic collection

       ArrayList<CommunityMember> members = new ArrayList<>(List.of(p1,p2,student1,student2,student3,student4,staff1));


       for(CommunityMember mem:members){
            System.out.println("\n");
            System.out.println(mem);
            System.out.println("Role: "+mem.getRole());
            System.out.println("\n");
       }

       // demonstrate overloaded enroll
       ArrayList<Student> batch = new ArrayList<>(List.of(student1, student2));
       course1.enrollStudent(batch);
}
}
