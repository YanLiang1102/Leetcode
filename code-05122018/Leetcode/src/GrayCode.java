/***
beautiful solution beat 100% on leetcode,but my solution is kind of dumb it is the first several submission on leetcode
***/
class Solution {
     public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        
        int bit = 1 << (n - 1);
        List<Integer> grayList = grayCode(n - 1);
        for (int i = grayList.size() - 1; i >= 0; i--) {
            //this is adding on teh previous list kind of dynamic programming and use an or to solve , beautiful sultion, win 100%
            grayList.add(bit | grayList.get(i));
        }
        
        return grayList;
    }
}
