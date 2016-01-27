package spike;

public class PackageName {

    public static void main(String[] args) {
        System.out.println("Package: " + new PackageName().getClass().getPackage().getName());
    }
}
