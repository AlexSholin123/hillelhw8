package pack29;

class A {
    {
        System.out.println(1);
    }

    void method() {
        class B {
            {
                System.out.println(2);
            }

            class C {
                {
                    System.out.println(3);
                }
            }
        }
    }
}

public class MainClass {
    public static void main(String[] args) {
        new A().method();
    }
}

