package pack24;

class A {
    class B {

    }

}

class C extends A.B {
    public C() {
        new A().super();
    }
}