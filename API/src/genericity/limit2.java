package genericity;

/**
 * Author:liang;
 * Date:2020/2/22;
 * Time:16:32;
 * Package Name:genericity;
 * 需求：
 * 步骤：
 */
/**
 * 这节学的不好
 */
/**    感觉泛型就像一个筛子 这个筛子相当严格，只允许许可的类型，继承的都不行，除非用了 ? extends XX 之类
 * 1.通配符： ?  代指不确定的Java类型
 * 2.与定义泛型函数区别不大，只是 ? 有一些限制
 *   2.1不能定义这种类型的引用，如需操作，最好还是定义成泛型函数
 *      即不能     ? t = list.get(0);
 *   2.2
 * 3.一般情况下都可以使用   ?
 */

/**
 * 上界通配符 < ? extends E>  筛出来E以及其子类
 * 下界通配符 < ? super E>    筛出来E以及其父类
 */

/**
 * 一般存储元素的时候使用super，这时候不会出现类型安全隐患
 * 这时候是用E进行操作数据
 */

/**
 * 泛型方法的上下限限制
 * public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
 * public <T extends Number> T showKeyName(Generic<T> container)
 */
public class limit2 {
    public static void main(String[] args) {

    }
}
