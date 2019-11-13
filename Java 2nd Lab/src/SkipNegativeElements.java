public class SkipNegativeElements {
    public static void skipNegativeElems(int array[]){
        for(int i = 0; i < array.length; i++){
            if(array[i] >= 0){
                System.out.println(array[i]);
            }
        }
    }

    public static void main(String[] args){
        int[] array;
        array = new int[] {10, 3, 5, -1, -4, 2, -8, -9, 260, 99};
        skipNegativeElems(array);
    }
}
