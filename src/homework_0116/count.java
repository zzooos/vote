package homework_0116;

public class count {
	int i, j;
	int win(int[] b) {
		int n= b.length -1, wp = 0, max = 0, max_n = 0;
		float p50 = (float)n/2;
		
		//max ±¸ÇÏ±â
		for (i = 1; i <= n; i++) {
			if (b[i] > max) {
				max = b[i];
				wp = i;}}
		
		if (max > p50) {
			return wp;} else if (max == p50) {
			for (i = 1; i <= n ; i++) {
				if (b[i]!=0 && b[i]!=max) break;
				if (b[i]!=0 && b[i]!=p50) max_n++;}
			if (max_n > 1) wp = -1;
			return -1;
		} else {
			for (i = 1; i <= n; i++) {
				if (b[i] != 0 && b[i]!= max) break;}
			if (i == n+1) return -1;
			else return 0;}
		}
	
	void recount(int[] b, int[][]vt) {
		int min = 0, n=b.length-1, vn=vt.length, i;
		for (i = 1; i <= n; i++) {
			if (b[i]!=0) {
				min = b[i];
				break;}
			}
		for (++i; i <= n; i++) {
			if (b[i]!=0 && b[i] < min) {
				min = b[i];}
			}
		
		for (i = 1; i <= n; i++) {
			if (b[i] == min) {
				b[i]=0; }
			}
		
		for (i = 0; i < vn; i++) {
			if (b[vt[i][0]]==0) {
				for (j =1; j < n; j++) {
					if (b[vt[i][j]] != 0) {
						vt[i][0] = vt[i][j];
						b[vt[i][0]]++;
						break;}
				}
			}
		}
	}
}