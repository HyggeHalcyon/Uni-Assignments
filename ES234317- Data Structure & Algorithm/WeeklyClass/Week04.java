import java.util.ArrayList;
import java.util.List;
import java.io.File;
public class Week04 {
    public static void listADTExample(){
        // Creating a list using ArrayList
        List<Integer> myArrayList = new ArrayList<>();

        // Insertion
        myArrayList.add(1);  // Add at the end
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);

        // Deletion
        myArrayList.remove(Integer.valueOf(3));  // Remove the value 3

        // Access
        int thirdElement = myArrayList.get(2);  // Access element at index 2

        // Update
        myArrayList.set(1, 8);  // Update element at index 1

        // Search
        int indexOf4 = myArrayList.indexOf(4);  // Get index of value 4

        // Size
        int listSize = myArrayList.size();  // Get the number of elements

        // Iteration
        for (int element : myArrayList) {
            System.out.println(element);
        }
    }

    public static void listExercise2() {
        List<InfoFile> listFiles = new ArrayList<>();
        listFiles.add(new InfoFile("AOT S3 EP1.mkv", 1024.0));
        listFiles.add(new InfoFile("AOT S3 EP2.mkv", 1024.0));
        listFiles.add(new InfoFile("AOT S3 EP3.mkv", 1024.0));
        listFiles.add(new InfoFile("AOT S3 EP4.mkv", 1024.0));
        listFiles.add(new InfoFile("AOT S3 EP5.mkv", 1024.0));

        for(InfoFile file: listFiles){
            System.out.println(file);
        }

        System.out.println("Amount of files: " + listFiles.size());

    }

    private static String getFileSize(String path) {
        File file = new File(path);
        //checks if the specified exists
        if (!file.exists() || !file.isFile())
            return "";


        return (double) file.length() / 1024 + " kb";
    }

    public static void listExercise1() {
        File folder = new File("C:/Windows/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName() + ",  " + getFileSize(file.getAbsolutePath()));
            }
        }
    }
}

class InfoFile{
    private String fileName;
    private double size;

    InfoFile(String n, double s){
        this.fileName = n;
        this.size = s;
    }

    public String toString(){
        return fileName + ", " + size;
    }
}
