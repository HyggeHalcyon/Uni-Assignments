import java.util.Map;

public class Mahasiswa {
    private boolean enrolled;
    private String studentName;
    private Matakuliah courseTaken;
    private long GPA = 0;
    Mahasiswa(String name){
        this.studentName = name;
        this.enrolled = false;
    }

    /*
    No. 1
    each student can only partake in a single course
     */
    public void enroll(Matakuliah course){
        if (this.enrolled){
            // each student can only take exactly one course
            System.out.printf("[!] %s already taken a course\n", this.studentName);
            return;
        }

        // each course have a maximum participant
        if(!course.addParticipant(this)) return;

        this.enrolled = true;
        this.courseTaken = course;
        System.out.printf("[+] %s successfully enrolled in %s course\n", this.studentName, course.courseName);
    }

    /*
    No.3
    Lecturer Grading, simulates it as random
     */
    public void setGPA(long gpa){
        if(this.GPA != 0 ){
            System.out.println("[!] GPA can't be changed");
            return;
        }
        this.GPA = gpa;
    }

    /*
    No.3
    prints the
     */
    public String getFinalReport(Map<String, Integer> indexM){
        String idx = "";
        for(Map.Entry<String, Integer> i: indexM.entrySet()){
            if(this.GPA >= i.getValue() ){
                idx = i.getKey();
                break;
            }
        }

        return "Student name: " + this.studentName +
                "\nCourse taken: " + this.courseTaken.courseName +
                "\nGPA: " + this.GPA +
                "\nIndex: " + idx;
    }

    @Override
    public String toString(){
        return this.studentName;
    }
}
