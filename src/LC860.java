public class LC860 {
    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;
        int tenNum = 0;
        int twNum = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNum++;
            } else if (bills[i] == 10) {
                if (fiveNum < 0) return false;
                fiveNum--;
                tenNum++;
            } else {
                if (fiveNum > 0 && tenNum > 0) {
                    fiveNum--;
                    tenNum--;
                    twNum++;
                } else if (fiveNum >= 3){
                    twNum++;
                    fiveNum -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
