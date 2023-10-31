import java.util.*;

public class Main {
    static Map<String, Integer> indexMark = new HashMap<>();
    public static void main(String[] args){
        /*
        No. 1 ShowCase
         */
        Matakuliah LSD = new Matakuliah("Logics and Discrete Structure", 10);
        Matakuliah DP = new Matakuliah("Fundamental Programming", 15);
        Matakuliah ASD = new Matakuliah("Algorithm & Data Structure", 5);
        Matakuliah[] courses = {LSD, DP, ASD}; // pre-defined at this case, no need to dynamically increasing size as in Linkedlist

        /*
        No.2 ShowCase
         */
        // simulate randomised students taking course at the same time
        System.out.println("====== COURSE TAKING SESSION =======");
        Queue<Mahasiswa> candidates = new LinkedList<>();
        for(int i = 0; i < 40; i++){
            candidates.add(new Mahasiswa(produceRandomString(8))); // this is somewhat No.1 Showcase
        }

        // simulate randomised students taking course at the same time
        while(!candidates.isEmpty()){
            Matakuliah course = randomiseCourse(courses);
            candidates.poll().enroll(course);
        }

        System.out.println("\n====== COURSES FINAL STATE =======");
        for(Matakuliah c: courses){
            System.out.println(c);
        }

        /*
        No.3 ShowCase
         */
        System.out.println("\n====== GRADING SESSION =======");
        seedIndexMap(indexMark);
        for(Matakuliah c: courses) {
            c.gradeAllStudents();
            c.finalReport(indexMark);
        }

    }

   public static void seedIndexMap(Map<String, Integer> indexM) {
        // Index : Minimum Grade
        indexM.put("A", 86);
        indexM.put("AB", 76);
        indexM.put("B", 66);
        indexM.put("BC", 61);
        indexM.put("C", 56);
        indexM.put("D", 41);
        indexM.put("E", 0);
   }

    public static String produceRandomString(long desiredLength) {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder str = new StringBuilder();
        Random prng = new Random();
        while (str.length() < desiredLength) {
            int index = (int) (prng.nextFloat() * CHARS.length());
            str.append(CHARS.charAt(index));
        }
        return str.toString();
    }

    public static Matakuliah randomiseCourse(Matakuliah[] courses){
        Random prng = new Random();
        int rand = prng.nextInt();
        while(rand < 0){
            rand = prng.nextInt();
        }
        return courses[rand % 3];
    }

    public static long randomiseGPA(){
        Random prng = new Random();
        return (prng.nextInt() % 100);
    }
}