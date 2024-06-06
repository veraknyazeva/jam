public class JvmComprehension {    //данный класс загрузит Application ClassLoader / Стек JvmComprehension / Metaspace

    public static void main(String[] args) {  //String - Bootstrap ClassLoader(ищет в стандартной библиотеке джава) / Создается фрейм в стеке
        int i = 1;                      // 1 хранится в стеке
        Object o = new Object();        // 2  Object - Bootstrap ClassLoader / "o" хранится в стеке и ссылается на Object в куче
        Integer ii = 2;                 // 3  Integer - Bootstrap ClassLoader / "ii" хранится в стеке и ссылается на Integer в куче
        printAll(o, i, ii);             // 4 создается фрейм printAll в стеке, куда передадим Object, int и Integer
        System.out.println("finished"); // 7  Bootstrap ClassLoader / создается фрейм printAll в стеке, куда передадим "finished"
    }

    private static void printAll(Object o, int i, Integer ii) { //Bootstrap ClassLoader
        Integer uselessVar = 700;                   // 5        //Bootstrap ClassLoader / uselessVar хранится в стеке и ссылается на Integer в куче
        System.out.println(o.toString() + i + ii);  // 6        //Bootstrap ClassLoader / создается новый фрейм в стеке, куда мы передаем Object, int и Integer
    }
}
//сборщик мусора очистит uselessVar, так как данный объект не используется