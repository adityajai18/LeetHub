class Solution {
    public boolean checkDivisibility(int n) {
       int temp=n;
       int sum=0;
       int product=1;
       int original=n;
       while(n!=0)
       {
         temp=n%10;
         sum+=temp;
         product*=temp;
         n=n/10;
       }
         int total=sum+product;
       if(original % total==0){
           return true;
       }
       return false;

    }
}