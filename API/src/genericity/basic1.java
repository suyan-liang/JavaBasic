package genericity;

/**
 * Author:liang;
 * Date:2020/2/22;
 * Time:10:17;
 * Package Name:genericity;
 * 需求：
 * 步骤：
 * !!!!把要操作的数据类型作为一个参数传入
 * !!!!!!!限定包含的类型，从容器的角度去考虑，里面装的都是xxx
 * 下面三种泛型在定义的时候均不知道要操作的数据类型是什么，实现时才知道
 *
 * 泛型就是那个比如<String>这样注明类型
 * 用了泛型就不必进行强制类型转换了
 * <p>
 * 泛型是编译时期的技术，是给编译器使用的，确保类型安全。
 * 运行时会将泛型去掉，class文件中无泛型，称之为泛型的擦除。为了兼容运行的类加载器
 * 泛型补偿机制用于处理多态问题，一个操作Class字节码文件的方法
 */
/**泛型就是那个比如<String>这样注明类型
 * 用了泛型就不必进行强制类型转换了
 *
 * 泛型是编译时期的技术，是给编译器使用的，确保类型安全。
 * 运行时会将泛型去掉，class文件中无泛型，称之为泛型的擦除。为了兼容运行的类加载器
 * 泛型补偿机制用于处理多态问题，一个操作Class字节码文件的方法
 */

/**1、泛型类，当类中要操作的引用数据类型不确定的时候使用
 * 就像以前用Object来接收不确定的引用，现在用泛型，更加安全。在编译时期就会把类型错误提示出来
 *
 * 2、泛型方法，就是说方法的参数不确定。打比方说该方法在一个String类中，它想打印任何类型，可以
 * 把这个方法定义为泛型，泛型方法一定要在返回值之前、修饰符之后加上<T>
 * 当方法静态时，不能访问类上定义的泛型。如果静态方法使用泛型，要将泛型定义在方法上，类名调用
 * 在泛型中不能使用对象的特有方法
 *
 * 3.泛型接口
 * 就是把泛型定义在接口上，有两种情况
 * 第一种：实现接口的类知道接口要实现的类型是什么
 * 第二种：实现接口的类不知道接口要实现的类型是什么
 */
public class basic1 {
    public static void main(String[] args) {
        Gen_class<String> gen = new Gen_class<String>();
        gen.not_gen("str");
        gen.gen_func(2);
        Gen_class.static_func('a');//静态方法直接类名调用
        First first = new First();//第一种实现方式定义对象的时候无需写泛型
        first.show("first string");
        Second<Integer> second=new Second<Integer>();//第二种需要
        second.show(2);

    }
}

/**
 * 泛型类
 * @param <T>
 */
class Gen_class<T> {
    private T t;

    /**
     * 不是泛型函数，只是单纯使用类的泛型
     * @param t
     */
    public void not_gen(T t) {
        System.out.println("我在泛型类中使用的类型" + t.getClass());
    }

    /**
     * 泛型方法
     * 如果想在方法中操作任意类型的引用，需要把方法定义为泛型方法
     */
    public <E> void gen_func(E e) {
        System.out.println("我在泛型方法中使用的类型" + e.getClass());
    }

    /**
     * 静态泛型方法
     * 静态方法使用泛型
     */
    public static <M> void static_func(M m) {
        System.out.println("我在静态泛型方法中使用的类型" + m.getClass());
    }
}

/**
 * 其实泛型接口和泛型类差不多
 * @param <G>
 */
interface Gen_inter<G> {
    public abstract void show(G g);
}

class First implements Gen_inter<String> {
    public void show(String str) {

        System.out.println("第一种实现接口的方式,直接打印字符串了：" + str);
    }
}

class Second<G> implements Gen_inter<G> {
    public void show(G g) {
        System.out.println("第二种实现接口的方式，类型" + g.getClass());
    }
}