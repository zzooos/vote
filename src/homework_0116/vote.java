package homework_0116;
import java.util.Scanner;

public class vote {
	public static void main(String[] args) {
		count c = new count();
		Scanner sc = new Scanner(System.in);
		System.out.println("후보의 수(n<=20)와 후보의 수(80글자 이하)만큼 이름 입력하세요");
		
		int n=sc.nextInt();
		int i,j,vn,win;
		String[] name = new String[n+1];
		
		//후보 이름 입력
		for (i=0; i<n+1; i++) {
			name[i] = sc.nextLine();
			if (name[i].length()>80) {
				System.out.println("후보 이름은 80글자 이하로 입력하세요");
				name[i]=sc.nextLine();
			}
		}
		
		int[] ballot = new int[n+1];
		
		do {
			System.out.println("투표 내역을 입력하고 투표가 끝나면 숫자를 제외한 문자를 입력하세요(투표내역 <=1000)");
			int[][] vt = new int[1000][n]; //vt는 투표 내역
			Vote:
			for (i = 0; i < 1000; i++) {
				for (j = 0; j < n; j++) {
					vt[i][j] = sc.nextInt();
					while (!sc.hasNextInt()) { //숫자를 제외한 문자 입력시 투표 종료
						sc.next();
						break Vote;
						}
					}
				}
			vn = i + 1;
			for (i = 0; i < vn; i++) {
				ballot[vt[i][0]]++;
			}
			
			do {
				win = c.win(ballot);
				if (win > 0) {
					System.out.println("당선된 후보 : " + name[win]);
					break;
				}else if (win == 1) {
					System.out.println("탈락후보 외 동일 득표");
					break;
				} else {
					c.recount(ballot, vt);
				}	
			} while (win == 0);
		} while(sc.nextInt()==1);	
	}
}