package leetcode.DP;

public class RegularExpressionMatching {
        public boolean isMatch(String text, String pattern) {
            boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
            dp[text.length()][pattern.length()] = true;

            for (int i = text.length(); i >= 0; i--){
                for (int j = pattern.length() - 1; j >= 0; j--){
                    boolean first_match = (i < text.length() &&
                            (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));
                    if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                        dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                    } else {
                        dp[i][j] = first_match && dp[i+1][j+1];
                    }
                }
            }
            for(int i = 0; i < dp.length; i++){
                for(int j = 0; j < dp[0].length; j++){
                    System.out.print(dp[i][j] + ",");
                }
                System.out.println();
            }
            return dp[0][0];
        }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        String p = "c*a*b";
        String s = "aab";
        regularExpressionMatching.isMatch(s,p);
    }
}
