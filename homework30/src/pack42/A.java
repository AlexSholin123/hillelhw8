package pack42;

class A {
    int a;

    class B {
        int b;
        int qwerty = a = b;


    }
}

class C extends A {

}

// Only members of Class A are inherited to Class C, not the members of Class B.
