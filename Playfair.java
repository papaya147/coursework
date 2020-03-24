import java.util.Scanner;
public class Playfair{
    public static void main(){
        Scanner s=new Scanner(System.in);
        String code1=s.nextLine().trim().toUpperCase();
        String code2=s.nextLine().trim().toUpperCase();

        char[][] mat1=createFrontMatrix(code1);
        char[][] mat2=createBackMatrix(code2);

        String word=s.nextLine().trim().toUpperCase();
        if(word.length()%2!=0){
            word=word.concat("X");
        }

        String encoded=encode(word,mat1,mat2);
        System.out.println(encoded);
    }

    public static char[][] createFrontMatrix(String word){
        char[][] matrix=new char[5][5];
        int wordcount=0;

        outer:
        for(int x=0; x<5; x++)
            for(int y=0; y<5; y++){
                if(!isRepeatLetter(matrix,word.charAt(wordcount)))
                    matrix[x][y]=word.charAt(wordcount++);
                else{
                    y--;
                    wordcount++;
                }
                if(wordcount==word.length())
                    break outer;
            }

        char letter='A';
        for(int x=0; x<5; x++){
            for(int y=0; y<5; y++){
                if(Character.toString(matrix[x][y]).equals("\u0000")){
                    if(isRepeatLetter(matrix,letter)||letter=='Q'){
                        y--;
                        letter++;
                    }
                    else
                        matrix[x][y]=letter++;
                }
            }
        }

        return matrix;
    }

    public static char[][] createBackMatrix(String word){
        char[][] matrix=new char[5][5];
        int wordcount=0;

        outer:
        for(int x=4; x>=0; x--)
            for(int y=4; y>=0; y--){
                if(!isRepeatLetter(matrix,word.charAt(wordcount)))
                    matrix[x][y]=word.charAt(wordcount++);
                else{
                    y++;
                    wordcount++;
                }
                if(wordcount==word.length())
                    break outer;
            }

        char letter='A';
        for(int x=4; x>=0; x--){
            for(int y=4; y>=0; y--){
                if(Character.toString(matrix[x][y]).equals("\u0000")){
                    if(isRepeatLetter(matrix,letter)||letter=='Q'){
                        y++;
                        letter++;
                    }
                    else
                        matrix[x][y]=letter++;
                }
            }
        }

        return matrix;
    }

    public static boolean isRepeatLetter(char[][] matrix, char letter){
        for(int x=0; x<5; x++)
            for(int y=0; y<5; y++)
                if(matrix[x][y]==letter)
                    return true;
        return false;
    }

    public static String encode(String text, char[][] key1, char[][] key2){
        String code="";
        for(int x=0; x<text.length(); x+=2){
            char let1=text.charAt(x);
            char let2=text.charAt(x+1);

            int coor1=findCoor(let1,key1);
            int coor2=findCoor(let2,key2);
            System.out.println(coor1+" "+coor2);

            if(coor1/10==coor2/10){
                if(coor1%10!=4)
                    code+=Character.toString(key1[coor1/10][coor1%10+1]);
                else
                    code+=Character.toString(key1[coor1/10][0]);
                if(coor2%10!=4)
                    code+=Character.toString(key2[coor2/10][coor2%10+1]);
                else
                    code+=Character.toString(key2[coor2/10][0]);
            }else{
                code+=Character.toString(key1[coor2/10][coor1%10]);
                code+=Character.toString(key2[coor1/10][coor2%10]);
            }
        }
        return code;
    }

    public static int findCoor(char letter, char[][] array){
        for(int x=0; x<5; x++){
            for(int y=0; y<5; y++){
                if(array[x][y]==letter){
                    return x*10+y;
                }
            }
        }
        return 0;
    }
}