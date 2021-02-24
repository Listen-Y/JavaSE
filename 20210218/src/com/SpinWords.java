package com;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-02-22
 * Time: 9:28
 */
public class SpinWords {

    /**
     * 字符串 序列反转
     * @param sentence
     * @return
     */
    public String spinWords(String sentence) {
        //TODO: Code stuff here
        String[] parts = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String temp : parts
             ) {
            if (temp.length() >= 5) {
                StringBuilder builder1 = new StringBuilder(temp);
                StringBuilder reverse = builder1.reverse();
                ans.append(reverse).append(" ");
            } else {
                ans.append(temp).append(" ");
            }
        }
        return ans.toString().trim();
    }


}
