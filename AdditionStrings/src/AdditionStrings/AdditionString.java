package AdditionStrings;

import AdditionTable.AdditionTable;
import AdditionTable.HashMapNumbers;

import java.util.HashMap;

import static AdditionTable.HashMapNumbers.getKeyByValue;

public class AdditionString {

    private static String addZerosToString(String str, int countZero) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < countZero; ++i) {
            stringBuilder.append("0");
        }
        stringBuilder.append(str);
        str = stringBuilder.toString();
        return str;
    }

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

    private static String sumChars(String a, String b, String carry) {
        String[][] table = AdditionTable.getAdditionTable();
        HashMap<Integer, String> hashMap = HashMapNumbers.getHashMap();
        int keyA = getKeyByValue(hashMap, a);
        int keyB = getKeyByValue(hashMap, b);
        if (carry.equals("0")) {
            return table[keyA][keyB];
        } else {
            return table[keyA][getKeyByValue(hashMap, sumChars(b, carry, "0"))];
        }
    }

    public static String addStings(String str1, String str2) {
        if (isNumber(str1) && isNumber(str2)) {
            if (str1.length() >= str2.length()) {
                str2 = addZerosToString(str2, str1.length() - str2.length());
            } else {
                str1 = addZerosToString(str1, str2.length() - str1.length());
            }

            String[] str1Array = str1.split("(?<=\\G.{1})");
            String[] str2Array = str2.split("(?<=\\G.{1})");

            StringBuilder result = new StringBuilder();

            String carry = "0";
            for (int i = str1Array.length - 1, j = str2Array.length - 1; i >= 0 && j >= 0; --i, --j) {
                String sumTwoChars = sumChars(str1Array[i], str2Array[j], carry);
                if (sumTwoChars.length() == 2) {
                    result.insert(0, sumTwoChars.charAt(sumTwoChars.length() - 1));
                    carry = "1";
                } else {
                    result.insert(0, sumTwoChars);
                    carry = "0";
                }
            }
            if (carry.equals("1")) {
                result.insert(0, carry);
            }
            return result.toString();
        } else {
            return "Неправильно введены данные";
        }
    }
}
