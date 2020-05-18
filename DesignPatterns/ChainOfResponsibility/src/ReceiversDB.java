import java.util.ArrayList;

public class ReceiversDB {

    public static ArrayList<String> getSystemAdmins(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("system.admin@example.com");
        return strings;
    }
    public static ArrayList<String> getPrincipals(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("principal@example.com");
        return strings;
    }
    public static ArrayList<String> getSectionalHeads(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("sectional.head@example.com");
        return strings;
    }
    public static ArrayList<String> getTeachers(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("teacher@example.com");
        return strings;
    }
    public static ArrayList<String> getStudents(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("student@example.com");
        return strings;
    }


}
