package day16;


class Prob {
    //변수
    int len;
    int[] wirelessFreq;
    int[] number;
    int[] freqCheck;
    int nonRecursNum;

    public FindFrequency(int[] wF) {

        len = wF.length;


        wirelessFreq = new int[len];

        for (int i = 0; i < len; i++) {
            wirelessFreq[i] = wF[i];
        }
    }

    public void sorting() {
        int i, j, key;

        for (i = 1; i < len; i++) {
            key = wirelessFreq[i];

            for (j = i - 1; wirelessFreq[j] > key; j--) {
                wirelessFreq[j - 1] = wirelessFreq[j];
            }
            wirelessFreq[j + 1] = key;
        }
    }

    public void watchData() {
        for (int i = 0; i < len; i++) {
            System.out.printf("%8d", wirelessFreq[i]); // 가장 큰 숫자가 8자리
            if (i % 5 == 4) { // 다섯칸 마다 띄어주기
                System.out.println();
            }
        }
    }


}


public class ClassChallengeProb {
    public static void main(String[] args) {
        int[] wirelessFreq = {
                1, 5, 10, 10, 15, 150, 1500, 2300,
                2350, 2350, 2350, 2350, 2350, 2350, 2350, 2350,
                23423, 1231, 52352, 2352332, 13123, 34531, 2342,
                1231, 2342, 2342, 368, 4675, 47905, 45604, 4500,
                5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000

        };

        FindFrequncy ff = new

    }
}
