package ru.itis.collections.list;

public class ArrayListInt implements IntList {
    private int[] array = new int[2];
    private int count = 0;

    @Override
    public void add(int x) {
        array[count] = x;
        count++;
        if(count == array.length) {
            grow();
        }
    }

    @Override
    public void add(int x, int index) {
        System.out.println("ДОБАВЛЕНИЕ НОВОГО ЭЛЕМЕНТА В МАССИВ ПУТЕМ ПЕРЕСТАНОВКИ");
        int p = array[index];
        array[index] = x;
        int[] oldArray = array;
        array = new int[oldArray.length + 1];
        //        int p = oldArray[index];
        //        oldArray[index] = x;
        for (int i = 0; i <= index; i++) {
            array[i] = oldArray[i];
        }
        array[index + 1] = p;
        for (int i = index + 1; i < oldArray.length; i++) {
            array[i + 1] = oldArray[i];
        }
        count++;
    }
    @Override
    public void set(int x, int index) {
        array[index] = x;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }
        cut();
    }

    @Override
    public void clear() {
        int[] oldArray = array;
        array = new int[oldArray.length];
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    private void grow() {
        System.out.println("ПЕРЕСОЗДАНИЕ МАССИВА");
        int[] oldArray = array;
        array = new int[oldArray.length * 2];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
    }
    private void cut() {
        System.out.println("УМЕНЬШЕНИЕ МАССИВА");
        int[] oldArray = array;
        array = new int[oldArray.length - 1];
        for (int i = 0; i < oldArray.length - 1; i++) {
            array[i] = oldArray[i];
        }
    }
}
