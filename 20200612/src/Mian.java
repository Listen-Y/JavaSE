import java.util.Arrays;

public class Mian {
    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        System.out.println(Arrays.toString(grayCode.getGray(3)));
    }
}



class Exchange {
    public int[] exchangeAB(int[] AB) {
        // write code here
        //AB[0] = AB[0] + AB[1];
        //AB[1] = AB[0] - AB[1];
        //AB[0] = AB[0] - AB[1];
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }
}




class GrayCode {
    public String[] getGray(int n) {
        // write code here
        //String[] ret = null;
        if (n == 1) {
            return new String[] {"0", "1"};
        } else {
            String[] ret = getGray(n - 1);
            String[] newRet = new String[ret.length * 2];
            for (int i = 0; i < ret.length; i++) {
                newRet[i] = "0" + ret[i];
            }
            for (int i = 0; i < ret.length; i++) {
                newRet[ret.length + i] = "1" + ret[ret.length - 1 - i];
            }
            return newRet;
        }
        //return ret;
    }
}
