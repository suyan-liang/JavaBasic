package File;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 对这个类的声明
 * 另请参见“@see”
 * 自从版本“@since”
 * <p>
 *     这是一段话
 * </p>
 * <p>
 *     这是另一段话
 * </p>
 * @see FileDemo
 * @since 1.0
 * @author liang
 */
public class test_doc {
    /**
     * 这是啥啊
     */
    public int x;

    /**
     * 这个是说明
     * @param x 这个是参数说明
     */
    public test_doc(int x)
    {
        this.x=x;
    }

    /**
     * 这是说明
     * @param y 这是参数说明
     * @return 这是返回值说明
     * @throws FileNotFoundException 这是异常说明
     */
    public int add(int y) throws FileNotFoundException {
        FileReader fileReader=new FileReader("hello.txt");
        return this.x+y;

    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
