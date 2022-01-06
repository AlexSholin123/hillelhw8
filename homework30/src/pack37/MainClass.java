package pack37;

interface I
{
    String name = "III";

    void printName();
}

class C
{
    String name = "CCC";

    static
    {
        new I()
        {
            public void printName()
            {
                System.out.println(name);
            }
        }.printName();
    }

    {
        System.out.println(name);
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
