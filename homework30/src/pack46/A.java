package pack46;

class A
{
    private static class B
    {

    }
}

class B // extends A.B
{

}

//Class B can not extend Class A.B. Because, A.B is declared as private.
// It is not visible outside the class A.
