import java.io.*;
public class LRU {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LRUList list = new LRUList();
		String input;
		int loopFlag=1;
		System.out.print("Enter the capacity of LRU : ");
		list.Capacity = Integer.parseInt(br.readLine());
		do {
			System.out.print("Input value : ");
			input = br.readLine();
			list.Set(input);
			System.out.print("Input 1 to add more values else 0 to stop : ");
			loopFlag = Integer.parseInt(br.readLine());
		}while(loopFlag!=0);
		list.disp();
	}
}
                