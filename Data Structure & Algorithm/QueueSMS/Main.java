public class Main {
    public static void main(String[] args){
        Account lecturer = new Account("Alice, S.Kom, M.Eng, PhD,.", "+6281267156472");
        Account student = new Account("Bob", "+6281547656795");

        System.out.printf("%s\n", "=== Lecturer Information ===");
        System.out.printf("%s\n", lecturer.accountInformation());
        System.out.printf("%s\n", "=== Student Information ===");
        System.out.printf("%s\n", student.accountInformation());
        System.out.println();

        /*
        ------------------ CONVERSATION ------------------
         */

        // Student sending Lecturer new message
        student.sendMessage(lecturer, "Hello sir");
        student.sendMessage(lecturer, "May I ask a specific question about our latest assignment");

        // Lecturer checking new messages
        System.out.printf("%s\n", lecturer.viewNotification());
        lecturer.readAllMessages();

        // Lecturer replying to Student
        lecturer.sendMessage(student, "Yes, go ahead");

        // Student reading new message and replying
        System.out.printf("%s\n", student.readMessage());
        student.sendMessage(lecturer, "I don't understand this and that");

        // Lecturer final message
        System.out.printf("%s\n", lecturer.readMessage());
        lecturer.sendMessage(student, "well figure it out yourself");

        // Student left Lecturer on read
        System.out.printf("%s\n", student.readAllMessages());
    }
}
