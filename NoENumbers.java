import java.util.Scanner;
public class NoENumbers{
    public static void main(){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int count=0;
        int num=0;
        while(count!=n){
            num++;
            if(!checkLetters(num)){
                count++;
            }
        }
        System.out.println(num);
    }

    public static boolean checkLetters(int num){
        StringBuffer sb=new StringBuffer(Integer.toString(num));
        String num_str=new String(sb.reverse());
        char digits[]=num_str.toCharArray();
        for(int x=0; x<digits.length; x++){
            if(x%3==0||x%3==2){
                if(digits[x]=='1'||digits[x]=='3'||digits[x]=='5'||digits[x]=='7'||digits[x]=='8'||digits[x]=='9'){
                    return true;
                }
            }
            if(x%3==1){
                if(digits[x]=='1'||digits[x]=='2'||digits[x]=='7'||digits[x]=='8'||digits[x]=='9'){
                    return true;
                }
            }
        }
        if((num/100)%10!=0||(num/100000)%10!=0||(num/100000000)!=0){
            return true;
        }
        return false;
    }
}