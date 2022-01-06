package pack36;

class OuterClass
{
    static class InnerClassOne
    {
        int i = 1221;

        int getI()
        {
            return i = i++ - ++i;//1221-1223=-2
        }
    }

    static class InnerClassTwo extends InnerClassOne
    {
        @Override
        int getI()
        {
            return i = i-- + --i;//1221+1219=2440
        }
    }
}

public class MainClass
{
    public static void main(String[] args)
    {
        OuterClass.InnerClassOne one = new OuterClass.InnerClassOne();

        System.out.println(one.getI());

        one = new OuterClass.InnerClassTwo();

        System.out.println(one.getI());
    }
}
