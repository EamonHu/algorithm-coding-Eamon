public class Offer19_IsMatch {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        return matchCore(str, 0, pattern, 0);
    }

    public boolean matchCore(char[] str, int i, char[] pattern, int j) {
        if (i == str.length && j == pattern.length) return true;

        if (j == pattern.length) return false;

        // 下一个字符是*时
        if ((j + 1 < pattern.length) && (pattern[j + 1] == '*')) {
            // 第一个字符匹配上
            if ((i != str.length && pattern[j] == str[i]) || (i != str.length && pattern[j] == '.')) {
                return matchCore(str, i, pattern, j + 2)    //*匹配了0次
                        || matchCore(str, i + 1, pattern, j + 2)    //*匹配了1次
                        || matchCore(str, i + 1, pattern, j);    //*匹配了多次
            } else {
                // 第一个字符不匹配,*=0的情况
                return matchCore(str, i, pattern, j + 2);
            }
        }
        // 下一个字符不是*时
        if ((i != str.length && pattern[j] == str[i]) || (i != str.length && pattern[j] == '.')) {
            return matchCore(str, i + 1, pattern, j + 1);
        }
        return false;
    }
}
