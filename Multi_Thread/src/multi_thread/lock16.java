package multi_thread;
/*
    Author:liang;
    Date:2020/2/14;
    Time:19:47;
    Package Name:multi_thread;
    需求：
    步骤：
    知识点：零、比喻
                    1.烧鸡有两个空间，厨房和餐厅。这上面锁着同一把锁，厨师想做烧鸡必须进入厨房，消费者想吃必须进餐厅
                    Condition就相当于门前的保安，负责唤醒，睡眠
                    厨师进厨房上锁lock，出厨房开锁unlock
            一.与synchronized的对比
                    1.synchronized对锁的操作是隐式的，而Lock把锁封装成了一个对象，有lock()(获取锁)和unlock()(释放锁)方法，可以由程序员控制
                    2.Lock是一个接口，它有子类，创建子类对象自定义锁。
                    3.unlock要放在finally中，因为释放锁是无论如何都要执行的
                    4.Lock要导入才能直接使用   import java.util.concurrent.locks.*;

            二、lock三步走
                    1.创建锁对象   Lock lock=new ReentrantLock();
                    2.上锁         lock.lock();
                    3.解锁         finally{lock.unlock();}
            三、Condition
                    0.比喻:  桌子上的按钮，可以实现喊人和催眠功能，而且这个按钮可以多个
                    1.将Object对象上的wait,notify,notifyAll进行封装，成一个Condition对象
                    2.一个锁可以挂多个Condition
                    3.lock.newCondition创建
                    4.await--wait  , signal--notify  ,signalAll--notifyAll
                    5.可以唤醒“对方”


*/

public class lock16 {

}
