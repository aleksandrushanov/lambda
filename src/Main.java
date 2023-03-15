import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static <T, U> Function<T, U> ternaryOperator(
         Predicate<? super T> condition,
         Function<? super T, ? extends U> ifTrue,
         Function<? super T, ? extends U> ifFalse)
 {
     return (value) -> condition.test(value) ? ifTrue.apply(value): ifFalse.apply(value);
 }
    public static void main(String[] args) {

        Function<String, Integer> stringLength = ternaryOperator(s -> s != null, s -> s.length(), s -> 0);

        Predicate<Integer> checkingTheNumber = new Predicate<Integer>() {// Анонимный класс
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println();
        Predicate<Integer> checkingTheNumberLambda = integer -> integer > 0;// лямбда

        Consumer<String> helloWord = new Consumer<String>() {// Анонимный класс
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Consumer<String> helloWordLambda = s -> System.out.println(s);// лямбда, можно ещё сократить но по задание сказано сделать так

        Double one = 363.48546;
        Function<Double, Long> conversion = new Function<Double, Long>() {// анонимный класс
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(conversion.apply(one));

        // анонимный класс
        Function<Double, Long> conversionlamda = aDouble -> Math.round(aDouble);// лямбда,можно ещё сократить но по задание сказано сделать так

        Supplier<Integer> numberRandom = new Supplier<Integer>() {// анонимный класс
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(100);// отсчёт nextInt =0 , bound = 100 верхнее оганичение
            }
        };
        System.out.println(numberRandom.get());


        Supplier<Integer> numberRandomLambda = () -> {// лямбда
            Random random = new Random();
            return random.nextInt(100);// отсчёт nextInt =0 , bound = 100 верхнее оганичение
        };


    }


}

