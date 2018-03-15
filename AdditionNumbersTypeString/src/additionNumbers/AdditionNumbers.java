package additionNumbers;


public class AdditionNumbers {
    private static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); ++i) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String add(String str1, String str2) {
        if (isNumber(str1) && isNumber(str2)) {
            StringBuilder result = new StringBuilder();
            int carry = 0;

            for (int i = str1.length() - 1, j = str2.length() - 1; i >= 0 || j >= 0; --i, --j) {
                int value1 = 0;
                int value2 = 0;
                if (i >= 0) {
                    value1 = str1.charAt(i) - '0';
                }
                if (j >= 0) {
                    value2 = str2.charAt(j) - '0';
                }
                int sum = value1 + value2 + carry;
                if (sum >= 10) {
                    carry = sum / 10;
                } else {
                    carry = 0;
                }
                result.insert(0, sum % 10);
            }

            if (carry != 0) {
                result.insert(0, carry);
            }
            return result.toString();
        } else {
            return "Неправильно введены данные";
        }
    }
}