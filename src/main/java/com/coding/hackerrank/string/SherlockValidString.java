package com.coding.hackerrank.string;

import java.util.HashMap;

public class SherlockValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (char i : s.toCharArray()) {
            if (!h.containsKey(i)) {
                h.put(i, 0);
            }
            h.put(i, h.get(i) + 1);
        }

        boolean isValid = true;
        int n = h.get(s.charAt(0));
        for (int i : h.values()) {
            if (i != n) {
                isValid = false;
            }
        }

        if (isValid) {
            return "YES";
        }


        for (int i = 0; i < s.length(); i++) {
            isValid = true;
            h.put(s.charAt(i), h.get(s.charAt(i)) - 1);
            n = h.get(s.charAt(0));
            for (int t : h.values()) {
                if (t != n && t > 0) {
                    isValid = false;
                }
            }
            h.put(s.charAt(i), h.get(s.charAt(i)) + 1);

            if (isValid) {
                System.out.println();
                return "YES";
            }
        }

        return "NO";
    }


    public static void main(String[] args) {
        System.out.println(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
        System.out.println(isValid("abcc"));
        System.out.println(isValid("abccc"));
    }


}
