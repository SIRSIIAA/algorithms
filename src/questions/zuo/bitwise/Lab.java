package questions.zuo.bitwise;

/*
 * bitwise in Java
 */
public class Lab {
    public static void main(String[] args) {
        /*
         * define binary integer
         */
        int positive = 0b00110100;
        System.out.println("positive: " + Integer.toBinaryString(positive));
        System.out.println(Integer.toBinaryString(positive << 1));
        System.out.println(Integer.toBinaryString(positive << 2));
        /*
         * >> & >>> takes same effect on positive number
         * supplement with zero for the leading part
         */
        System.out.println("positive: " + Integer.toBinaryString(positive));
        System.out.println(Integer.toBinaryString(positive >> 1));
        System.out.println(Integer.toBinaryString(positive >> 2));
        System.out.println("positive: " + Integer.toBinaryString(positive));
        System.out.println(Integer.toBinaryString(positive >>> 1));
        System.out.println(Integer.toBinaryString(positive >>> 2));

        System.out.println("============");

        /*
         * >> & >>> takes different effect on negative number
         * >> supplement with one (symbol bit) for leading part
         * >>> supplement with zero for leading part
         */
        int negative = 0b10111010;
        System.out.println("negative: " + Integer.toBinaryString(negative));
        System.out.println(Integer.toBinaryString(negative >> 1));
        System.out.println(Integer.toBinaryString(negative >> 2));
        System.out.println("negative: " + Integer.toBinaryString(negative));
        System.out.println(Integer.toBinaryString(negative >>> 1));
        System.out.println(Integer.toBinaryString(negative >>> 2));
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
