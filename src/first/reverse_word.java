package first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class reverse_word {
	
	public static String reverse(String s) {
		String reverse_s="";
		for(int j=s.length()-1;j>=0;j--) {
			reverse_s+=s.charAt(j);
		}
		return reverse_s;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb=new StringBuffer();
		String s=br.readLine();
		String answer="";
		String temp="";
		boolean tag_flag=false;
		for(int i=0;i<s.length();i++) {
			//<>태그 안 그대로 넣는것 처리
			if(s.charAt(i)=='<') {
				tag_flag=true;
				answer+=reverse(temp);
				temp="";
			}
			
			//태그 안이라면 그대로 넣기
			if(tag_flag==true) {
				answer+=s.charAt(i);
			}else {
				//띄어쓰기일때 temp에 저장된 문자 뒤집어서 정답에 넣기
				if(s.charAt(i)==' ') {
					answer+=reverse(temp)+' ';
					temp="";
				}else {
					temp+=s.charAt(i);
				}
			}
			if(s.charAt(i)=='>') {
				tag_flag=false;
			}
			//마지막 인덱스일때 남은 문자열 털기
			if(i==s.length()-1) {
				answer+=reverse(temp);
			}
			
		}
		sb.append(answer);
		bw.write(sb.toString());;
		bw.flush();
		
	}
}
