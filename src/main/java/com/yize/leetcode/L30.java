package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L30 {
    @Test
    public void test(){
        String s="pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String ss[]={"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        System.out.println(findSubstring(s,ss));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        return method1(s,words);
    }
    public List<Integer> method1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> tmp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(tmp_map)) res.add(i);
        }
        return res;
    }

    public List<Integer> method2(String s, String[] words) {
        List<Integer> list=new ArrayList<>();
        if(s==null||words==null||s.length()==0||words.length==0){
            return list;
        }
        int wordLen=words[0].length();
        int totalLen=wordLen*words.length;
        //记录每个单词出现的次数
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else {
                map.put(words[i],1);
            }
        }

        for(int i=0;i<s.length()-totalLen+1;i++){
            Map<String,Integer> mmp=new HashMap<>();
            String tmpStr=s.substring(i,i+totalLen);
            for(int j=0;j<totalLen;j+=wordLen){
                String w=tmpStr.substring(j,j+wordLen);
                if(mmp.containsKey(w)){
                    mmp.put(w,mmp.get(w)+1);
                }else {
                    mmp.put(w,1);
                }
            }
            if(map.equals(mmp)){
                list.add(i);
            }
        }
        return list;
    }




//    public List<Integer> method1(String s, String[] words) {
//        if(s==null||words.length==0){
//            return new ArrayList<>();
//        }
//        List<String> list=new ArrayList<>();
//        int len=0;
//        for (int i=0;i<words.length;i++){
//            len+=words[i].length();
//        }
//        allSort(list,new ArrayList<>(),"",words,len);
//        List<Integer> list1=new ArrayList<>();
//        for(String ss:list){
//            List<Integer> list2=findIndexOfStr(s,ss);
//            list1.addAll(list2);
//        }
//        return list1;
//    }
//
//    public List<Integer> findIndexOfStr(String s,String pattern){
//        List<Integer> list=new ArrayList<>();
//        for(int i=0;i<s.length()-pattern.length()+1;i++){
//            if(s.charAt(i)==pattern.charAt(0)){
//                int start=i,end=i+pattern.length();
//                while (start<end){
//                    if(s.charAt(start)!=pattern.charAt(start-i)){
//                        break;
//                    }
//                    start++;
//                }
//                if(start==end){
//                    list.add(i);
//                }
//            }
//        }
//        return list;
//
//    }
//
//    public void allSort(List<String> list,List<Integer> addedList,String item,String[] words,int len){
//        if(item.length()==len){
//            if(!list.contains(item)){
//                list.add(item);
//            }
//            return;
//        }
//        for(int i=0;i<words.length;i++){
//            if(!addedList.contains(i)){
//                addedList.add(i);
//                allSort(list,addedList,item+words[i],words,len);
//                addedList.remove(addedList.size()-1);
//            }
//        }
//    }
}
