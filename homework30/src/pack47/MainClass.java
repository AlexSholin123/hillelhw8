package pack47;

class A
{
    static
    {
        System.out.println(1);

        class B
        {
            {
                System.out.println(2);
            }
        }
    }

    {
        System.out.println(3);

        class B
        {
            {
                System.out.println(4);
            }
        }
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}

//Output:
// 1
// 3