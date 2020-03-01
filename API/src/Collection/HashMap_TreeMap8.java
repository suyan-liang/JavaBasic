package Collection;

/**
 * Author:liang;
 * Date:2020/2/22;
 * Time:9:18;
 * Package Name:Collection;
 * 需求：
 * 步骤：
 */

import java.util.*;

/**Map常用子类
 * 1.HashTable:内部哈希表，同步。不允许使用null作为键，null作为值
 *      下面有properties类，用来储存键值类型的配置文件信息，可以和IO技术结合
 * 2.HashMap:内部哈希表，不同步。允许使用null作为键，null作为值
 * 3.TreeMap:内部二叉树，不同步，便于排序
 */
class Worker
{
    private String name;
    private int age;

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 自动生成真香
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return age == worker.age &&
                name.equals(worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
class WorkerCompare implements Comparator<Worker>
{
    @Override
    public int compare(Worker o1, Worker o2) {
        int main_judge=o1.getAge()-o2.getAge();
        int second_judge=o1.getName().compareTo(o2.getName());
        if(main_judge!=0)
            return main_judge;
        else if(second_judge!=0)
            return second_judge;
        else
        return 0;
    }
}
public class HashMap_TreeMap8 {
    public static void main(String[] args) {
        /**HashMap存储自定义对象的时候，必须要override内部的equals方法和hashcode方法以保证唯一性
         * 其他基础类型系统内部自带了所以不用重写，只有自定义需要重写
         * 本类是工人和其所在地的HashMap
         */
        System.out.println("HashMap自定义对象演示，上面的Worker类override了hashcode和equals方法");
        HashMap<Worker,String > hm=new HashMap<Worker, String>();
        hm.put(new Worker("zhang3",25),"哈尔滨");
        hm.put(new Worker("li4",28),"上海");
        hm.put(new Worker("wang5",35),"北京");
        hm.put(new Worker("zhang3",25),"商丘");
        Iterator<Worker> it=hm.keySet().iterator();
        while(it.hasNext())
        {
            Worker worker=it.next();
            String value=hm.get(worker);
            System.out.println("name="+worker.getName()+".....age="+worker.getAge()+"...地址:"+value);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("TreeMap演示，其实和TreeSet一回事，这里演示构造器");
        TreeMap<Worker,String > tm=new TreeMap<Worker, String>(new WorkerCompare());
        tm.put(new Worker("zhang3",25),"哈尔滨");
        tm.put(new Worker("li4",28),"上海");
        tm.put(new Worker("wang5",35),"北京");
        tm.put(new Worker("zhang3",25),"商丘");
        tm.put(new Worker("xiaowang",28),"安徽");//年龄相同
        Iterator<Map.Entry<Worker,String >> iter=tm.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry<Worker,String > mid=iter.next();
            System.out.println("name="+mid.getKey().getName()+".....age="+mid.getKey().getAge()+"...地址:"+mid.getValue());
        }
    }
}
