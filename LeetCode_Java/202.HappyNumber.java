public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<> ();
        while(!set.contains(n)){
            set.add(n);
            n = update(n);
        }
        return n == 1;
    }
    
    public int update(int num){
        int ans = 0;

        while(num >0){
            ans += (num % 10) * (num % 10);
            num /= 10;
        }
        return ans;
    }
}
