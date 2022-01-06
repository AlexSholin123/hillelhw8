package pack10;

class A
{
    void methodOne()
    {
        class B
        {
            void methodTwo()
            {
                System.out.println("Method Two");
            }

        }
       // void methodThree()
        {
            new B().methodTwo();
        }
        //Local inner classes are not visible outside the method or block in which they are defined.
    }


}
