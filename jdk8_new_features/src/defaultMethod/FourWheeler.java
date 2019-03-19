package defaultMethod;

public interface FourWheeler {
    default void print() {
        System.out.println("我是一个四轮车！");
    }
}
