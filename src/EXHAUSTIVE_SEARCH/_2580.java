package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2580 {
	// FIXME ��Ȯ�� �м��� �ʿ��ϴ�.
	// ��Ʈ��ŷ �������� ���� https://idea-sketch.tistory.com/29
	static boolean[][] check_col = new boolean[9][10]; // �� �˻�
	static boolean[][] check_row = new boolean[9][10]; // �� �˻�
	static boolean[][] check_box = new boolean[9][10]; // �ڽ� �˻�
	
	static boolean sd(int[][] arr,int count,ArrayList<Node> nodes,int idx) {
		if(idx>=count) { // ��� �ִ� ĭ�� ��� Ž���ߴٸ� ���
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++)
					System.out.print(arr[i][j]+" ");
				System.out.println();
			}
			return true;
		}
		Node node = nodes.get(idx);
		for(int i=1;i<=9;i++) { // 1���� 9���� ��� ����� �� Ž��
			if(check_col[node.x][i]==true)
				continue;
			if(check_row[node.y][i]==true)
				continue;
			if(check_box[(node.x/3)*3+(node.y)/3][i] == true)
				continue;
			check_col[node.x][i]=true;
			check_row[node.y][i]=true;
			check_box[(node.x/3)*3+(node.y)/3][i]=true;
			
			arr[node.x][node.y] = i;
			
			if(sd(arr, count, nodes, idx+1))
				return true; // Ž�� ��
			arr[node.x][node.y] = 0;
			check_col[node.x][i]=false;
			check_row[node.y][i]=false;
			check_box[(node.x/3)*3+(node.y)/3][i]=false;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] sd = new int[9][9]; // ������ 
		int count = 0; // ��ü ��ĭ�� �� ( 0�� ���� )
		ArrayList<Node> nodes = new ArrayList<>();
		
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				sd[i][j] = Integer.parseInt(st.nextToken());
				if(sd[i][j]==0) {
					count++;
					nodes.add(new Node(i, j));
				}else {
					check_col[i][sd[i][j]] = true;
					check_row[j][sd[i][j]] = true;
					check_box[i/3*3+j/3][sd[i][j]] = true;
				}
			}
		}
		sd(sd, count, nodes, 0);

		br.close();
	}

	private static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
