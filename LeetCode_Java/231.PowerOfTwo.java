public class Solution {
    public boolean isPowerOfTwo_v1(int n) {
        int count = 0;
        while(n > 0){
            count += (n & 1); 
            n >>= 1;
        }
        return count == 1;
    }

   public boolean isPowerOfTwo_v2(int n) {
        if(n <= 0) return false;
        else return (n & (n-1)) == 0;
    }
}
