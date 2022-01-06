package pack6;

class A
{
    String s = "AAA";

    void methodA()
    {
        System.out.println(s);
    }

    static class B
    {
        void methodB()
        {
            //methodA();
        }
    }
}
