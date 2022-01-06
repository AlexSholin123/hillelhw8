package pack16;

class A {
    void methodA1(int i) {
        System.out.println(i++ + i);
    }

    void methodA2(int i) {
        System.out.println(--i - i--);
    }
}

class B {
    A a = new A() {
        void methodA1(int i) {
            System.out.println(++i + i++);
        }

        void methodA2(int i) {
            System.out.println(i-- - i);
        }
    };
}

public class MainClass {
    public static void main(String[] args) {
        A a = new A();

        a.methodA1(10);//10+11=21

        a.methodA2(10);//9-9=0

        B b = new B();

        b.a.methodA1(10);//11+11=22

        b.a.methodA2(10);//10-9=1
    }
}
