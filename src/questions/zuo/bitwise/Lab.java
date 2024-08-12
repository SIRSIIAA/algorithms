package questions.zuo.bitwise;

public class Lab {
    public static void main(String[] args) {
        /*
         * get opposite number using bitwise
         */
        int a = 78;
        System.out.println(a);
        System.out.println(~(a - 1));
        System.out.println(~a + 1);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

        /*
         * test ^
         * 0 ^ 1 = 1
         * 1 ^ 1 = 0 
         * a ^ a = 0
         * a ^ b ^ c = a ^ (b ^ c)
         */
    }

}
