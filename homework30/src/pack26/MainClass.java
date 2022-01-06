package pack26;

class X
{
    int x = 111;

    static class Y extends X
    {
        int y = x + 222;
    }

    class Z extends X.Y
    {
        int z = y + 333;
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        X.Z z = new X().new Z();

        System.out.println(z.x);

        System.out.println(z.y);

        System.out.println(z.z);
    }
}

//Answer :
//c) No errors. Output will be,
//111
//333
//666

