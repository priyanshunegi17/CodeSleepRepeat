class Solution 
{
    HashMap<Integer,Integer> cache = new HashMap<>();
    public int fib(int n) {
        if(n<2){
            return n;
        }
        if(cache.containsKey(n)) return cache.get(n);
        int ans= fib(n-1)+fib(n-2);
        cache.put(n,ans);
        return ans;
    }
}