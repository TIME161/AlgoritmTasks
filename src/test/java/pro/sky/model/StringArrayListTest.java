package pro.sky.model;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.exceptions.AddNullException;
import pro.sky.exceptions.IncorrectIndexException;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StringArrayListTest {

    StringArrayList list = new StringArrayList();

    private static Stream<Arguments> words() {
        return Stream.of(
                Arguments.of("Hi", 0, "Good", "Day"),
                Arguments.of("Bye", 0, "Good", "Day"),
                Arguments.of("Good", 0, "Good", "Day")
        );
    }


    @ParameterizedTest(name = "{index} => addWord={0}")
    @MethodSource("words")
    public void testAdd(String addWord) {
        String actualResult = list.add(addWord);
        assertEquals(addWord, actualResult);

    }

    @ParameterizedTest(name = "{index} => addWord={0}, index={1}")
    @MethodSource("words")
    public void testAddIndex(String addWord, int index) {
        String actualResult = list.add(index, addWord);
        assertEquals(addWord, actualResult);
    }

    @ParameterizedTest(name = "{index} => newWord={0}, index={1}, wordOne={2}, wordTwo={3}")
    @MethodSource("words")
    public void testSet(String newWord, int index, String wordOne, String wordTwo) {
        list.add(wordOne);
        list.add(wordTwo);
        String actualResult = list.set(index, newWord);
        String expectedResult = list.get(index);


        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testRemove() {
        list.add("Hello");
        list.add("world");
        list.add("!");

        String actualResult = list.remove("world");
        assertEquals("world", actualResult);

    }

    @Test
    public void testIndexRemove() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        String actualResult = list.remove(1);
        assertEquals("world", actualResult);
    }

    @Test
    public void testContains() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        Boolean expectedResult = true;
        Boolean actualResult = list.contains("!");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIndexOf() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        int expectedResult = 2;
        int actualResult = list.indexOf("!");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLastIndexOf() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        list.add("Hello");
        int expectedResult = 3;
        int actualResult = list.lastIndexOf("Hello");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGet() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        String expectedResult = "Hello";
        String actualResult = list.get(0);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testTestEquals() {

        list.add("Hello");
        list.add("world");
        list.add("!");
        StringArrayList list1 = new StringArrayList();
        list1.add("Hello");
        list1.add("world");
        list1.add("!");
        Boolean expectedResult = true;
        Boolean actualResult = list.equals(list1);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSize() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        int expectedResult = 3;
        int actualResult = list.size();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testIsEmpty() {
        Boolean expectedResult = true;
        Boolean actualResult = list.isEmpty();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testClear() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        list.clear();
        Boolean expectedResult = true;
        Boolean actualResult = list.isEmpty();
        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testToArray() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        String[] actualResult = list.toArray();
        assertEquals(actualResult.length, 3);
        assertEquals(actualResult[0], "Hello");
        assertEquals(actualResult[1], "world");
        assertEquals(actualResult[2], "!");
    }

    @Test
    public void testTestToString() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        String expectedResult = "StringArrayList{elements=[Hello, world, !], size=3}";
        String actualResult = list.toString();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void addWithException() {
            Exception exception = assertThrows(AddNullException.class, () -> list.add(null));
            String expectedMessege = "Вы добавили null";
            assertEquals(expectedMessege, exception.getMessage());
        }

    @Test
    public void addIndexWithException() {
        int indexLocal = 10;
        Exception exception = assertThrows(IncorrectIndexException.class, () -> list.add(indexLocal,"Hello"));
        String expectedMessege = "Индекс " + indexLocal + " некорректен!";
        assertEquals(expectedMessege, exception.getMessage());
    }

    @Test
    public void setWithException() {
        int indexLocal = 10;
        Exception exception = assertThrows(IncorrectIndexException.class, () -> list.set(indexLocal,"Hello"));
        String expectedMessege = "Индекс " + indexLocal + " некорректен!";
        assertEquals(expectedMessege, exception.getMessage());
    }

    @Test
    public void removeWithException() {
        list.add("Hello");
        list.add("world");
        list.add("!");

        Exception exception = assertThrows(IncorrectIndexException.class, () -> list.remove("Hi"));
        String expectedMessege = "Данного значения нет";
        assertEquals(expectedMessege, exception.getMessage());
    }

    @Test
    public void removeIndexWithException() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        int indexLocal = 4;
        Exception exception = assertThrows(IncorrectIndexException.class, () -> list.remove(indexLocal));
        String expectedMessege = "Индекс " + indexLocal + " некорректен!";
        assertEquals(expectedMessege, exception.getMessage());
    }

    @Test
    public void getWithException() {
        list.add("Hello");
        list.add("world");
        list.add("!");
        int indexLocal = 4;
        Exception exception = assertThrows(IncorrectIndexException.class, () -> list.get(indexLocal));
        String expectedMessege = "Индекс " + indexLocal + " некорректен!";
        assertEquals(expectedMessege, exception.getMessage());
    }

    @Test
    public void equalsWithException() {
        Exception exception = assertThrows(AddNullException.class, () -> list.equals(null));
        String expectedMessege = "Вы добавили null";
        assertEquals(expectedMessege, exception.getMessage());
    }

    }