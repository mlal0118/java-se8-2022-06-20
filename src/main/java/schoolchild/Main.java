package schoolchild;

public class Main {
    public static void main(String[] args) {
        PrimarySchoolChild psc = PrimarySchoolChild.of(12);
        System.out.println(psc.getClass().toString());
    }
}
