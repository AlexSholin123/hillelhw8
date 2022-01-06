package pack30;

class X
{
    static
    {
        class Y
        {
            {
                System.out.println(1);
            }
        }
    }

    {
        class Y
        {
            {
                System.out.println(2);
            }
        }
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        new X();
    }
}
//Prints nothing
