package test.java8;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author liu-zl
 * @Created on 2018/9/26.
 */
public class TestInterface {

    /**
     * Java8内置四大核心函数式接口
     * <p>
     * 1.Consumer<T>:消费型接口
     * void accept(T t);
     * <p>
     * 2.Supplier<T>:供给型接口
     * T get();
     * <p>
     * 3.Function<T,R>:函数型接口
     * R apply(T t);
     * <p>
     * 4.Prdicate<T>:断言型接口
     * boolean test(T t);
     */

    //断言型接口
    @Test
    public void test04() {
        List<String> strings = Arrays.asList("我猜", "你猜我猜不猜", "豆瓣电影");
        List<String> strings1 = filterStr(strings, str -> "我猜".equals(str));
        System.out.println(strings1);
    }

    public List<String> filterStr(List<String> list, Predicate<String> predicate) {

        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                arrayList.add(s);
            }

        }
        return arrayList;
    }


    //函数型接口
    @Test
    public void test03() {
        String result = getResult("\t\t\t  这是函数型接口,第二个为返回值类型~", str -> str.trim());
        System.out.println(result);
    }

    public String getResult(String str, Function<String, String> function) {
        return function.apply(str);
    }


    //供给型接口
    @Test
    public void test02() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println(numList);

    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }


    //消费型接口
    @Test
    public void test01() {
        happy(10000, m -> System.out.println("谁不喜欢花钱,网购花费" + m + "元"));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }


    //reduce:可以将流中的元素反复结合起来,得到一个新值
    @Test
    public void test05() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);//先将0作为x,然后结果作为x.
        System.out.println(sum);
    }


}
