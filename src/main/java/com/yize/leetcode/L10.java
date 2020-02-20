package com.yize.leetcode;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L10 {
    public boolean isMatch(String str, String pattern) {
        return match(str.toCharArray(),pattern.toCharArray(),0,0);
    }
    /**
     * 状态
     * 首先状态 dp 一定能自己想出来。
     * dp[i][j] 表示 s 的前 ii 个是否能被 p 的前 jj 个匹配
     *
     * 转移方程
     * 怎么想转移方程？首先想的时候从已经求出了 dp[i-1][j-1] 入手，再加上已知 s[i]、p[j]，要想的问题就是怎么去求 dp[i][j]。
     *
     * 已知 dp[i-1][j-1] 意思就是前面子串都匹配上了，不知道新的一位的情况。
     * 那就分情况考虑，所以对于新的一位 p[j] s[i] 的值不同，要分情况讨论：
     *
     * 考虑最简单的 p[j] == s[i] : dp[i][j] = dp[i-1][j-1]
     * 然后从 p[j] 可能的情况来考虑，让 p[j]=各种能等于的东西。
     *
     * p[j] == "." : dp[i][j] = dp[i-1][j-1]
     *
     * p[j] ==" * ":
     *
     * 第一个难想出来的点：怎么区分 *∗ 的两种讨论情况
     * 首先给了 *，明白 * 的含义是 匹配零个或多个前面的那一个元素，所以要考虑他前面的元素 p[j-1]。* 跟着他前一个字符走，前一个能匹配上 s[i]，* 才能有用，前一个都不能匹配上 s[i]，* 也无能为力，只能让前一个字符消失，也就是匹配 00 次前一个字符。
     * 所以按照 p[j-1] 和 s[i] 是否相等，我们分为两种情况：
     *
     * 3.1 p[j-1] != s[i] : dp[i][j] = dp[i][j-2]
     * 这就是刚才说的那种前一个字符匹配不上的情况。
     * 比如(ab, abc * )。遇到 * 往前看两个，发现前面 s[i] 的 ab 对 p[j-2] 的 ab 能匹配，虽然后面是 c*，但是可以看做匹配 00 次 c，相当于直接去掉 c *，所以也是 True。注意 (ab, abc**) 是 False。
     * 3.2 p[j-1] == s[i] or p[j-1] == "."：
     * * 前面那个字符，能匹配 s[i]，或者 * 前面那个字符是万能的 .
     * 因为 . * 就相当于 . .，那就只要看前面可不可以匹配就行。
     * 比如 (##b , ###b *)，或者 ( ##b , ### . * ) 只看 ### 后面一定是能够匹配上的。
     * 所以要看 b 和 b * 前面那部分 ## 的地方匹不匹配。
     * 第二个难想出来的点：怎么判断前面是否匹配
     * dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
     * or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
     * or dp[i][j] = dp[i][j-2] // 没有匹配的情况
     * 看 ### 匹不匹配，不是直接只看 ### 匹不匹配，要综合后面的 b b* 来分析
     * 这三种情况是 oror 的关系，满足任意一种都可以匹配上，同时是最难以理解的地方：
     *
     * dp[i-1][j] 就是看 s 里 b 多不多， ### 和 ###b * 是否匹配，一旦匹配，s 后面再添个 b 也不影响，因为有 * 在，也就是 ###b 和 ###b *也会匹配。
     *
     * dp[i][j-1] 就是去掉 * 的那部分，###b 和 ###b 是否匹配，比如 qqb qqb
     *
     * dp[i][j-2] 就是 去掉多余的 b *，p 本身之前的能否匹配，###b 和 ### 是否匹配，比如 qqb qqbb* 之前的 qqb qqb 就可以匹配，那多了的 b * 也无所谓，因为 b * 可以是匹配 00 次 b，相当于 b * 可以直接去掉了。
     *
     * 三种满足一种就能匹配上。
     *
     * 为什么没有 dp[i-1][j-2] 的情况？ 就是 ### 和 ### 是否匹配？因为这种情况已经是 dp[i][j-1] 的子问题。也就是 s[i]==p[j-1]，则 dp[i-1][j-2]=dp[i][j-1]。
     *
     * 最后来个归纳：
     * 如果 p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1]；
     * 如果 p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1]；
     * 如果 p.charAt(j) == '*'：
     * 如果 p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2] //in this case, a* only counts as empty
     * 如果 p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.'：
     * dp[i][j] = dp[i-1][j] //in this case, a* counts as multiple a
     * or dp[i][j] = dp[i][j-1] // in this case, a* counts as single a
     * or dp[i][j] = dp[i][j-2] // in this case, a* counts as empty
     *
     * 作者：kao-la-7
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    /**
     * 动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean method1(String s,String p){
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
        for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true; // here's y axis should be i+1
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    /**
     * 普通方法
     * @param str
     * @param pattern
     * @param ptrStr
     * @param ptrPat
     * @return
     */
    public boolean match(char[] str,char[] pattern,int ptrStr,int ptrPat){
        if(ptrStr==str.length&&ptrPat==pattern.length){
            return true;//匹配到底，成功
        }
        if(ptrStr!=str.length&&ptrPat==pattern.length){
            return false;
        }
        /**
         * 下一个字符是*
         */
        if(ptrPat+1<pattern.length&&pattern[ptrPat+1]=='*'){//确保没匹配完
            if(ptrStr!=str.length&&(pattern[ptrPat]=='.'||pattern[ptrPat]==str[ptrStr])){//匹配上了
                return match(str,pattern,ptrStr,ptrPat+2)||match(str,pattern,ptrStr+1,ptrPat);
            }else {
                return match(str,pattern,ptrStr,ptrPat+2);
            }
        }else {
            //下一个字符不是*
            if(ptrStr!=str.length&&(pattern[ptrPat]==str[ptrStr]||pattern[ptrPat]=='.')){
                return match(str,pattern,ptrStr+1,ptrPat+1);
            }else {
                return false;
            }
        }
    }

}
