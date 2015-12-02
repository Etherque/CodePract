public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int overlap;
        int lx = Math.max(A, E);
        int ly = Math.max(B, F);
        int rx = Math.min(C, G);
        int ry = Math.min(D, H);
        
        if(B > H || A > G || C < E || D < F) overlap = 0;
        else overlap =  (rx - lx) * (ry - ly);
        
        return (C - A) * (D - B) + (G - E) * (H - F) - overlap;
        
    }
}
