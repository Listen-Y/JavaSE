import java.util.Arrays;

enum ProgramLanguage {
    JAVA,
    C,
    PYTHON,
    PHP,
    GO,
        }
public class EnumTest {

    //使用
    public static void enumUse(ProgramLanguage language) {
        switch (language) {
            case JAVA:
                System.out.println("JAVA");
                break;
            case C:
                System.out.println("C");
                break;
            case GO:
                System.out.println("GO");
                break;
            case PHP:
                System.out.println("PHP");
                break;
            case PYTHON:
                System.out.println("PYTHON");
                break;
        }
    }

    public static void main(String[] args) {
      ProgramLanguage language = ProgramLanguage.JAVA;
        //
        System.out.println(language.ordinal());
        System.out.println(language);
        enumUse(language);
        //
        System.out.println(Arrays.toString(ProgramLanguage.values()));

        System.out.println("====================");
        ProgramLanguage language1 = ProgramLanguage.valueOf("PYTHON");
        System.out.println(language1);
        //
        System.out.println(language.compareTo(language1));
    }
}
