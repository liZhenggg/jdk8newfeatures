# jdk8newfeatures
Java 8 新特性

Java 8 (又称为 jdk 1.8) 是 Java 语言开发的一个主要版本。 Oracle 公司于 2014 年 3 月 18 日发布 Java 8 ，它支持函数式编程，新的 JavaScript 引擎，新的日期 API，新的Stream API 等。


-- Lambda表达式
允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
使代码变得更加简洁和紧凑。

语法：
(parameters) -> expression
或：
(parameters) -> { statements; }

Lambda表达式的重要特性：
可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。


-- 方法引用
方法引用通过方法的名字来指向一个方法。
方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
方法引用使用一对冒号 :: 。

构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
final Car car = Car.create( Car::new );
final List< Car > cars = Arrays.asList( car );

静态方法引用：它的语法是Class::static_method，实例如下：
cars.forEach( Car::collide );

特定类的任意对象的方法引用：它的语法是Class::method实例如下：
cars.forEach( Car::repair );

特定对象的方法引用：它的语法是instance::method实例如下：
final Car police = Car.create( Car::new );
cars.forEach( police::follow );


-- 函数式接口
函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
函数式接口可以被隐式转换为 lambda 表达式。
Lambda 表达式和方法引用（实际上也可认为是Lambda表达式）上。


-- 默认方法
简单说，默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。
我们只需在方法名前面加个 default 关键字即可实现默认方法。
引进的默认方法的目的是为了解决接口的修改与现有的实现不兼容的问题。

多个默认方法
一个类实现了多个接口，且这些接口有相同的默认方法
解决方案一是创建自己的默认方法，来覆盖重写接口的默认方法；
解决方案二是使用 super 来调用指定接口的默认方法。

静态默认方法
接口可以声明（并且可以提供实现）静态方法


-- Stream
Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。
这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。

+--------------------+       +------+   +------+   +---+   +-------+
| stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
+--------------------+       +------+   +------+   +---+   +------- +
转换为 Java 代码为：

List<Integer> transactionsIds = 
widgets.stream()
             .filter(b -> b.getColor() == RED)
             .sorted((x,y) -> x.getWeight() - y.getWeight())
             .mapToInt(Widget::getWeight)
             .sum();

什么是 Stream？
Stream（流）是一个来自数据源的元素队列并支持聚合操作。
	元素:是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
	数据源:流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
	聚合操作:类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。

和以前的Collection操作不同， Stream操作还有两个基础的特征：	
Pipelining：
	中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道， 如同流式风格（fluent style）。 这样做可以对操作进行优化， 比如延迟执行(laziness)和短路( short-circuiting)。	
内部迭代：
	以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。 Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。

生成流
在 Java 8 中, 集合接口有两个方法来生成流：
stream() − 为集合创建串行流。
parallelStream() − 为集合创建并行流。

常用方法:
forEach --迭代流中的每个数据
map --映射每个元素到对应的结果
filter --过滤出指定的元素
limit --获取指定数量的流
sorted --排序
parallelStream --流并行处理程序的代替方法
Collectors --类实现了很多归约操作，例如将流转换成集合和聚合元素
summaryStatistics --产生统计结果的收集器，主要用于int、double、long等基本类型上


-- Nashorn
Nashorn 一个 javascript 引擎。
从JDK 1.8开始，Nashorn取代Rhino(JDK 1.6, JDK1.7)成为Java的嵌入式JavaScript引擎。
与先前的Rhino实现相比，这带来了2到10倍的性能提升。

jjs
jjs是基于Nashorn引擎的命令行工具。它接受一些JavaScript源代码为参数，并且执行这些源代码。
在控制台运行js文件：
$ jss filename.js

jjs 交互式编程
打开控制台，输入以下命令：
$ jjs
jjs> print("Hello, World!")
Hello, World!
jjs> quit()
>>

传递参数
打开控制台，输入以下命令：
$ jjs -- a b c
jjs> print('字母: ' +arguments.join(", "))
字母: a, b, c
jjs> 