package pack22;

class OuterClass1
{
    static class InnerClass
    {
        int i;
    }
}

public class OuterClass {
    public static void main(String[] args) {
//        OuterClass1.InnerClass innerClass = new OuterClass1.InnerClass();
        System.out.println(new OuterClass1.InnerClass().i);
    }
}

