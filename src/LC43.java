public class LC43 {
    public String multiply(String num1, String num2) {
        // 1.创建数字：存储单个字符相乘结果
        int len1 = num1.length();
        int len2 = num2.length();
        int[] cheng = new int[len1 + len2];

        // 2. 对相乘数组进行赋值。
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int tempNum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                tempNum += cheng[i + j + 1];

                cheng[i + j] += tempNum / 10;
                cheng[i + j + 1] = tempNum % 10;
            }
        }
        // 3. 赋值结束，需要将结果
        int index= 0;
        StringBuilder sb = new StringBuilder();
        while (index < len1 + len2 && cheng[index] == 0) index++;
        for (int i = index; i < len1 + len2; i++) {
            sb.append(cheng[i]);
        }
        return sb.toString();

    }
}
