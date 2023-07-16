public class LC65 {
    public boolean isNumber(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = s.length() - 1;
        int idxE = -1;
        // 记录分割标记E或e。
        for (int i = left; i < right; ++i) {
            if (arr[i] == 'e' || arr[i] == 'E') {
                // 找到就返回。
                idxE = i;
                break;
            }
        }
        // 如果有分割标记。
        if (idxE != -1) {
            if (
                    // 分割标记之后，必须为整数，分割之前可以为整数，也可以为小数。
                    (isInteger(arr, left, idxE - 1) || isFraction(arr, left, idxE - 1))
                    && isInteger(arr, idxE + 1, right)
                        ) {
                return true;
            }
        } else if (isInteger(arr, left, right) || isFraction(arr, left, right)) {
            // 没有分割标记，就要看整体满足整数或小数要求吗？
            return true;
        }
        return false;
    }
    // 判断E之前是不是整数。
    public boolean isInteger(char[] arr, int start, int end) {
        if (start > end) {
            return false;
        }
        if (start < end && (arr[start] == '-' || arr[start] == '+')) {
            start++;
        }
        if (start <= end && isDigits(arr, start, end)) {
            return true;
        }
        return false;
    }
    // 判断小数
    public boolean isFraction(char[] arr, int start, int end) {
        if (start >= end) {
            return false;
        }
        if (start < end && (arr[start] == '-' || arr[start] == '+')) {
            start++;
        }
        if (start == end) {
            return false;
        }
        int idxDot = -1;
        for (int i = start; i <= end; ++i) {
            if (arr[i] == '.') {
                idxDot = i;
                break;
            }
        }
        // 如果小数点存在，判断下小数点前后时候符合整数。
        if (idxDot != -1) {
            if (
                            // 情况三：小数点最后，那之前的数字需要满足整数。
                    (idxDot == end && isDigits(arr, start, idxDot - 1))
                            // 情况二：小数点开头，那之后的数字需要满足整数。
                    || (idxDot == start && isDigits(arr, idxDot + 1, end))
                            // 情况一：小数点中间，那小数点前后的数为整数。
                    || (isDigits(arr, start, idxDot - 1) && isDigits(arr, idxDot + 1, end))
                        ) {
                return true;
            }
        }
        return false;
    }
    // 无符号"+"、"-"判断是不是整数。
    public boolean isDigits(char[] arr, int start, int end) {
        if (start > end) {
            return false;
        }
        while (start <= end) {
            int digit = arr[start] - '0';
            if (digit < 0 || digit > 9) {
                return false;
            }
            start++;
        }
        return true;
    }

}
