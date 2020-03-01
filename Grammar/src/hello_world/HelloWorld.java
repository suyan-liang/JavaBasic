package hello_world;
/*
需求：
设计一个类，其中有一个功能show，可以返回对应的数组值；
当出现数组下标越界时，抛出异常；
测试有无异常，有无对应时的代码执行情况
 */
class demo
{
    int show(int[] arr,int index)throws ArrayIndexOutOfBoundsException//其实抛不抛都行，最好throws一下，比较清晰
    {
        if(index>=arr.length)
        {
            throw new ArrayIndexOutOfBoundsException("Exception Message!!!");
        }
        return arr[index];
    }
}
public class HelloWorld
{
    public static void main(String[] args)
    {
        int [] arr=new int[3];
        try
        {
            System.out.println("before");
            new demo().show(arr,2);
            System.out.println("after");
        }
        /*
        catch(ArrayIndexOutOfBoundsException x)
        {
            System.out.println("ArrayIndexOutOfBoundsException异常被捕捉");
            System.out.println("异常信息:"+x.toString());
        }
        */
         catch (NullPointerException x)
         {
             System.out.println("NullPointerException");
         }
        finally
        {
            System.out.println("finally ran!");
        }
    }
}
