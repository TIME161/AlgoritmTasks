package pro.sky;

import pro.sky.model.StringArrayList;

public class Main {
    public static void main(String[] args) {
        StringArrayList list = new StringArrayList();

        list.add("Hello");
        list.add("Hello Man");
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Two");
        System.out.println(list);

        list.add(0, "Hi");
        list.add(2, "Hi Man");

        System.out.println(list);
        line();

        list.set(2, "Index 2");
        list.set(3, "Index 3");

        System.out.println(list);
        line();

        list.remove("Hello");
        System.out.println(list);

        list.remove(1);
        System.out.println(list);
        line();

        System.out.println(list.contains("Index 3"));
        line();

        System.out.println(list.indexOf("Two"));
        line();

        System.out.println(list.lastIndexOf("Two"));
        line();

        System.out.println(list.get(4));
        line();

        StringArrayList listOne = new StringArrayList();
        StringArrayList listTwo = new StringArrayList();
        listTwo.add("Hello");
        listTwo.add("Hello Man");
        listTwo.add("One");
        listTwo.add("Two");
        listTwo.add("Three");
        listTwo.add("Two");
        listTwo.add(0, "Hi");
        listTwo.add(2, "Hi Man");
        listTwo.set(2, "Index 2");
        listTwo.set(3, "Index 3");
        listTwo.remove("Hello");
        listTwo.remove(1);

        System.out.println(list.equals(listOne));
        System.out.println(list.equals(listTwo));
        line();

        System.out.println(list.size());
        line();

        String[] text = list.toArray();
        System.out.println(text[0] +" "+ text[1] +" "+ text[2] +" "+ text[3] +" "+ text[4] +" "+ text[5]);
        line();

        list.clear();
        System.out.println(list);
        line();

        System.out.println(list.isEmpty());
        line();

    }

    private static void line() {
        System.out.println("---------------------------------------------");
    }
}