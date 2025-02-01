public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        
        int pref[] = new int[n];
        pref[0] = A[0];
        
        for(int i = 1; i<n; i++){
            pref[i] = pref[i-1] ^ A[i];
        }
        Map<Integer,Integer> map = new HashMap<>();
        
        int c = 0;
        for(int i = 0; i<pref.length; i++){
            int xor1 = pref[i] ^ B;
            
            if(map.containsKey(xor1)){
                c += map.get(xor1);
            }
            map.put(pref[i], map.getOrDefault(pref[i],0) + 1);
            
            if(pref[i] == B){
                c++;
            }
        }
        return c;
        
        
    }
}
