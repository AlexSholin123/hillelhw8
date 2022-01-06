package pack12;

class A
{
    class B
    {
        {
            System.out.println(1);
        }

        //static
        {
            System.out.println(2);
        }
    }
}
//Non-static inner classes must not contain static initializers.
