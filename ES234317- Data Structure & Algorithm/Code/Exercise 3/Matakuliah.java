import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Matakuliah {
    private List<Mahasiswa> participant = new ArrayList<>();
    protected String courseName;
    private long maxParticipant;

    Matakuliah(String cN, long mP){
        this.courseName = cN;
        this.maxParticipant = mP;
    }

    /*
    No. 1
    each course have a maximum participant
     */
    public boolean addParticipant(Mahasiswa student){
        if(participant.size() >= maxParticipant){
            System.out.printf("[!] %s course is full\n", this.courseName);
            return false;
        }
        participant.add(student);
        return true;
    }

    /*
    No.3
    Lecturer Grading, simulates it as random
     */
    public void gradeAllStudents(){
         for(Mahasiswa p: participant){
             Random prng = new Random();
             long rand = prng.nextInt();
             while(rand < 0){
                 rand = prng.nextInt();
             }
             p.setGPA(rand % 100);
         }
    }

    public void finalReport(Map<String, Integer> indexM){
        for(Mahasiswa p: this.participant){
            System.out.println(p.getFinalReport(indexM));
        }
    }

    @Override
    public String toString(){
        return "Course name: " + this.courseName +
                "\nSpace remaining: " + (this.maxParticipant - participant.size()) +
                "\nParticipants: " + this.participant.toString();
    }
}
