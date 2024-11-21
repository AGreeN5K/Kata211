//


import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> romanKeyMap = new TreeMap();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap();

    public Converter() {
        this.romanKeyMap.put('I', 1);
        this.romanKeyMap.put('V', 5);
        this.romanKeyMap.put('X', 10);
        this.romanKeyMap.put('L', 50);
        this.romanKeyMap.put('C', 100);
        this.romanKeyMap.put('D', 500);
        this.romanKeyMap.put('M', 1000);
        this.arabianKeyMap.put(1000, "M");
        this.arabianKeyMap.put(900, "CM");
        this.arabianKeyMap.put(500, "D");
        this.arabianKeyMap.put(400, "CD");
        this.arabianKeyMap.put(100, "C");
        this.arabianKeyMap.put(90, "XC");
        this.arabianKeyMap.put(50, "L");
        this.arabianKeyMap.put(40, "XL");
        this.arabianKeyMap.put(10, "X");
        this.arabianKeyMap.put(9, "IX");
        this.arabianKeyMap.put(5, "V");
        this.arabianKeyMap.put(4, "IV");
        this.arabianKeyMap.put(1, "I");
    }

    public boolean isRoman(String number) {
        return this.romanKeyMap.containsKey(number.charAt(0));
    }

    public String intToRoman(int number) {
        String roman = "";

        do {
            int arabianKey = (Integer)this.arabianKeyMap.floorKey(number);
            roman = roman + (String)this.arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while(number != 0);

        return roman;
    }

    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int result = (Integer)this.romanKeyMap.get(arr[end]);

        for(int i = end - 1; i >= 0; --i) {
            int arabian = (Integer)this.romanKeyMap.get(arr[i]);
            if (arabian < (Integer)this.romanKeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }

        return result;
    }
}
