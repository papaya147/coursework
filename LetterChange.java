import java.util.Scanner;
public class LetterChange{
    public static void main(){
        Scanner s=new Scanner(System.in);
        String word=s.nextLine().trim();
        word=word.toUpperCase();
        int n=s.nextInt();
        for(int x=0; x<n; x++)
            word=replaceLetters(word);
        int p=s.nextInt();
        char letters[]=word.toCharArray();
        int count[]=new int[5];
        for(int x=0; x<p; x++)
            count[((int)letters[x])-65]++;
        for(int x=0; x<5; x++)
            System.out.print(count[x]+" ");
    }

    public static String replaceLetters(String word){
        char letters[]=word.toCharArray();
        String lets[]=new String[letters.length];
        for(int x=0; x<letters.length; x++)
            lets[x]=Character.toString(letters[x]);
        for(int x=0; x<lets.length; x++){
            switch(lets[x]){
                case "A": lets[x]="B"; break;
                case "B": lets[x]="AB"; break;
                case "C": lets[x]="CD"; break;
                case "D": lets[x]="DC"; break;
                case "E": lets[x]="EE";
            }
        }
        word="";
        for(int x=0; x<lets.length; x++){
            word+=lets[x];
        }
        return word;
    }
}