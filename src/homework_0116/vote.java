package homework_0116;
import java.util.Scanner;

public class vote {
	public static void main(String[] args) {
		count c = new count();
		Scanner sc = new Scanner(System.in);
		System.out.println("�ĺ��� ��(n<=20)�� �ĺ��� ��(80���� ����)��ŭ �̸� �Է��ϼ���");
		
		int n=sc.nextInt();
		int i,j,vn,win;
		String[] name = new String[n+1];
		
		//�ĺ� �̸� �Է�
		for (i=0; i<n+1; i++) {
			name[i] = sc.nextLine();
			if (name[i].length()>80) {
				System.out.println("�ĺ� �̸��� 80���� ���Ϸ� �Է��ϼ���");
				name[i]=sc.nextLine();
			}
		}
		
		int[] ballot = new int[n+1];
		
		do {
			System.out.println("��ǥ ������ �Է��ϰ� ��ǥ�� ������ ���ڸ� ������ ���ڸ� �Է��ϼ���(��ǥ���� <=1000)");
			int[][] vt = new int[1000][n]; //vt�� ��ǥ ����
			Vote:
			for (i = 0; i < 1000; i++) {
				for (j = 0; j < n; j++) {
					vt[i][j] = sc.nextInt();
					while (!sc.hasNextInt()) { //���ڸ� ������ ���� �Է½� ��ǥ ����
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
					System.out.println("�缱�� �ĺ� : " + name[win]);
					break;
				}else if (win == 1) {
					System.out.println("Ż���ĺ� �� ���� ��ǥ");
					break;
				} else {
					c.recount(ballot, vt);
				}	
			} while (win == 0);
		} while(sc.nextInt()==1);	
	}
}