package pack44;

class A {
    private int i = 1;
    private static int I = 1;

    class B {
        int c = A.this.i;
        int e = A.I;
    }
}

//How do you access hidden outer class variable in inner class?
//To access non-static hidden outer class variable in inner class,
//use this syntax : OuterClassName.this.variableName and to access
//static hidden outer class variable in inner class use the same
//syntax or access like OuterClassName.variableName.