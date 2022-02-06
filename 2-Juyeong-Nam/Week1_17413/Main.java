import java.util.Scanner;
import java.lang.StringBuffer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        sc.close();

        int start, end;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '<') {
                while (i < S.length() && S.charAt(i) != '>') i++;
            }else if(S.charAt(i) != ' '){
                start = i;
                while(i < S.length() && S.charAt(i) != '<' && S.charAt(i) != ' ') i++;
                end = i;
                StringBuffer sb = new StringBuffer(S.substring(start,end));
                S = S.substring(0, start) + sb.reverse() + S.substring(end);
                i--;
            }
        }
        System.out.print(S);
    }
}
