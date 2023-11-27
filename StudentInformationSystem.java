import java.util.*;
class Course {
    //for make a course
    private String courseId;
    private String courseName;
    private int credits;
  //set course id course name and credits
    public Course(String courseId, String courseName, int cre) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = cre;
    }
    //for course id

    public String getCourseId() {
        return courseId;
    }
//for course name
    public String getCourseName() {
        return courseName;
    }
//for creadit
    public int getCredits() {
        return credits;
    }
}
//student section start

class Student {
    private String studentId;
    private String name;
    private List<Course> enrolledCourses;
    private Map<String, Integer> grades; // Course ID se grade mapping ho rhi h
         //set student id and student name
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }
    //for enroll in course

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        grades.put(course.getCourseId(), -1); // Initialize grade as -1 (not graded yet)
    }
  //for set grade
    public void setGrade(String courseId, int grade) {
        if (grades.containsKey(courseId)) {
            grades.put(courseId, grade);
        }
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }
//genrate grade
    public String generateTranscript() {
        StringBuilder transcript = new StringBuilder();
        transcript.append("Transcript for ").append(name).append("\n");
        for (Course course : enrolledCourses) {
            int grade = grades.getOrDefault(course.getCourseId(), -1);
            transcript.append(course.getCourseName()).append(": ");
            if (grade >= 0) {
                transcript.append(grade);
            } else {
                transcript.append("Not graded yet");
            }
            transcript.append("\n");
        }
        return transcript.toString();
    }
}

public class StudentInformationSystem {
    public static void main(String[] args) { 
        //make a student
        Course mathCourse = new Course("M2", "Mathematics-2", 3);
        Course bioCourse = new Course("M1", "Mathematics-1", 4);
            //make a  new student
        Student student = new Student("0206cs211001", "Aadarsh Singh");
        student.enrollCourse(mathCourse);
        student.enrollCourse(bioCourse);

        student.setGrade("M2", 90);
        student.setGrade("M1", 85);

        //  printing transcript
        String transcript = student.generateTranscript();
        System.out.println(transcript);
    }
}
