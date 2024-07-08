public class StringMultiplication {
    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        // Multiply each digit of num1 with each digit of num2
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + result[p2];

                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }

        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println("Product of " + num1 + " and " + num2 + " is: " + multiply(num1, num2));

        // Additional test cases
        num1 = "2";
        num2 = "3";
        System.out.println("Product of " + num1 + " and " + num2 + " is: " + multiply(num1, num2));

        num1 = "0";
        num2 = "0";
        System.out.println("Product of " + num1 + " and " + num2 + " is: " + multiply(num1, num2));

        num1 = "123456789";
        num2 = "987654321";
        System.out.println("Product of " + num1 + " and " + num2 + " is: " + multiply(num1, num2));
    }
}
