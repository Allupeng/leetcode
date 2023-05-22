public class _1071_Greatest_Common_Divisor_of_Strings {
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            int minLen = Math.min(str1.length(), str2.length());
            for (int i = minLen; i > 0; i--){
                if (str1.length() % i == 0 && str2.length() % i == 0){
                    String gcdStr = str1.substring(0, i);
                    if (canBeDivided(str1, gcdStr) && canBeDivided(str2, gcdStr)){
                        return gcdStr;
                    }
                }
            }
            return "";
        }
        private boolean canBeDivided(String str1, String str2){
            return str1.split(str2).length == 0;
        }
    }
}