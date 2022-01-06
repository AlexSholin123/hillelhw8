package pack39;

class A {
    class B {
        static final int i = 111;
    }

    class C {
         final int i = 111;
    }
}

public class MainClass {
    public static void main(String[] args) {
        System.out.println(A.B.i);
        System.out.println(new A().new C().i);
    }
}
