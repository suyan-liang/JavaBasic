package Character;

/**
 * Author:liang;
 * Date:2020/2/24;
 * Time:20:08;
 * Package Name:Character;
 * 需求：
 * 步骤：
 */
/**
 * 装饰设计模式
 * 实现了许多不同的搭配
 * https://www.cnblogs.com/hulizhong/p/11454474.html
 */

/**
 * 被装饰者基类,第一层
 */
abstract class Phone
{
    public abstract void decorate();
}

/**
 * 装饰基类，第二层，继承被装饰者基类
 */
abstract class Decorator extends Phone
{
    Phone phone;//内置一个被装饰者

    /**
     * 构造函数默认初始化那个被装饰者
     * @param phone
     */
    Decorator(Phone phone){
        this.phone=phone;
    }
    @Override
    public abstract void decorate();
}

/**
 * 被装饰者实例，第二层，继承被装饰者基类
 */
class MI6 extends Phone
{
    @Override
    public void decorate() {
        System.out.print("MI6 裸机.........");
    }
}

/**
 * 装饰者实例，第三层，内部含有一个被装饰者对象（在父类中），就相当于装饰内部内置一个被装饰者
 */
class ganghuamo extends Decorator
{
    /**
     * 直接调用父类构造函数即可
     * @param phone
     */
    ganghuamo(Phone phone) {
        super(phone);
    }

    @Override
    /**
     * 调用被装饰者的decorate方法
     */
    public void decorate() {
        phone.decorate();
        System.out.print("加上了钢化膜.......");
    }
}
/**
 * 装饰者实例，第三层
 */
class ke extends Decorator
{
    public ke(Phone phone) {
        super(phone);
    }

    @Override
    public void decorate() {
        phone.decorate();
        System.out.print("加上了壳........");
    }
}
public class Decorate_Design_pattern {
    public static void main(String[] args) {
        Phone myphone=new MI6();
        myphone.decorate();
        System.out.println();
        ganghuamo mo=new ganghuamo(myphone);
        mo.decorate();
        System.out.println();
        ke keke=new ke(mo);
        keke.decorate();
        System.out.println();
        ke mi_ke=new ke(myphone);
        mi_ke.decorate();

    }
}
