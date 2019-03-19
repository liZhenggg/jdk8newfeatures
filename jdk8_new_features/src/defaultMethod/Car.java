package defaultMethod;

/**
 * 类实现了多个接口，并且这些接口有相同的默认方法
 */
public class Car implements Vehicle, FourWheeler {

//    // 解决方法一：创建自己的默认方法
//    default void print() {
//        System.out.println("我是一辆四轮汽车!");
//    }

    // 解决方法二：使用super调用指定接口的默认方法
    public void print() {
        Vehicle.super.print();
    }
}
