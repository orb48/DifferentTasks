package AdditionTable;

public class AdditionTable {

    public static String[][] getAdditionTable() {
        int countNumbers = HashMapNumbers.getHashMap().size();
        String[][] additionTable = new String[countNumbers][countNumbers];

        for (int i = 0; i < countNumbers; ++i) {
            for (int j = i; j >= 0; --j) {
                additionTable[j][i - j] = (HashMapNumbers.getHashMap()).get(i);
            }
        }
        for (int i = 1; i < countNumbers; i++) {
            int k = i;
            for (int j = countNumbers - 1; j >= i; --j) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = HashMapNumbers.getHashMap().get(i);
                if (str.length() == 1) {
                    stringBuilder.insert(0, (HashMapNumbers.getHashMap()).get(i));
                    stringBuilder.insert(0, "1");
                } else {
                    stringBuilder.insert(0, (HashMapNumbers.getHashMap()).get(i).substring(1));
                    stringBuilder.insert(0, "2");
                }
                additionTable[k++][j] = stringBuilder.toString();
            }
        }
        return additionTable;
    }
}
