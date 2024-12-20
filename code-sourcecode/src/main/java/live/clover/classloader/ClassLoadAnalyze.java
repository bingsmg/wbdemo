package live.clover.classloader;

/**
 * @author weibb
 */
public class ClassLoadAnalyze {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("\n\n class load analyze. ################################### \n");
//        C1 c1 = new C1();
//        System.out.println(C3.CONSTANT);
//        System.out.println(C3.STATIC_CONSTANT);
//        Class<?> aClass = Class.forName("live.clover.classloader.C2"); // reflection
//        System.out.println(C1.C1_STATIC_CONSTANT);
//        System.out.println(C2.C1_STATIC_CONSTANT);
//        C3 c3 = new C3();
//        System.out.println(C3.C3_STATIC_CONSTANT0);
        C2 c2 = new C2();
        System.out.println("\n\n class load analyze. ################################### \n");
    }
}

class C1 {
    static int num = getNum();

    static {
        if (num == 1) System.out.println("parent static variable num is loaded.");
        System.out.println("parent static code block is loaded.");
    }

    public static int getNum() { return 1; }

    public C1() {
        System.out.println("parent constructor method is loaded." + count++);
    }

    {
        System.out.println("ordinary parent code block is loaded.");
    }

    int count = getCount();


    public static int getCount() {
        System.out.println("ordinary parent variable is loaded.");
        return 1;
    }
}

class C2 extends C1 {
    static {
        System.out.println("child static code block is loaded.");
    }

    static int num = 45;
    int cn = 0;
    {
        cn++;
        System.out.println("ordinary child code block is loaded." + cn);
    }

    public C2() {
        System.out.println("child constructor method is loaded.");
    }
}

class C3 {

    // 编译器放入常量池
    public static final String CONSTANT = "constant";

    public static String C3_STATIC_CONSTANT0 = "C3_STATIC_CONSTANT0";

    // 随着类加载调用
    public static String STATIC_CONSTANT = printS0();

    public static String printS0() {
        System.out.println("static variables is initialized while C3 is loaded");
        return "static fill";
    }

    public static void assignmentS() {
        STATIC_CONSTANT = "is assignment";
        System.out.println(STATIC_CONSTANT);
    }

    public void print0() {
        System.out.println("Ordinary Method");
    }

    public static void print1() {
        System.out.println("Static Method");
    }
}

class C4 {
    private C4() {}

    private static C4 instance;

    public static C4 getInstance() {
        if (instance == null) {
            instance = new C4();
        }
        return instance;
    }
}