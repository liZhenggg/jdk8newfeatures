import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * 方法引用
 */
public class Car {
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follw(final Car another) {
        System.out.println("Fllowing the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        //构造器引用
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        //静态方法引用
        cars.forEach(Car::collide);

        // 特定类的任意对象的方法引用
        cars.forEach(Car::repair);

        //特定对象的方法引用
        final Car police = Car.create(Car::new);
        cars.forEach(police::follw);

        test();
    }

    public static void test() {
        List names = new ArrayList();

        names.add("Google");
        names.add("Sina");
        names.add("Alibaba");
        names.add("Baidu");

//      等价
//        names.forEach(i -> System.out.println(i));
        names.forEach(System.out::println);
    }

}
