package defaultMethod;

/**
 * 接口的默认方法
 */
public interface Vehicle {
    default void print() {
        System.out.println("我是一辆车！");
    }

    // 接口可以声明（并且可以提供实现）静态方法
    static void blowHorn() {
        System.out.println("按喇叭！");
    }
}
