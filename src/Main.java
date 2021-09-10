import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		while (num-- != 0) {
			boolean wrongsequence = false;
			char[] simbols = br.readLine().toCharArray();
			Sq sequence = new Sq ();
				for (char c : simbols) {
					if (c == '[' || c == '(') {
						sequence.addelement(c);
					} else {
						if (c == ']') {
							if (sequence.isEmpty() || (char)sequence.top() == '(')
								wrongsequence |= true;
						} else if (c == ')') {
							if (sequence.isEmpty() || (char)sequence.top() == '[')
								wrongsequence |= true;
						}
						if (!sequence.isEmpty())
							sequence.deleteelement();
					}
				}
				if (!sequence.isEmpty())
					wrongsequence = true;
				System.out.println(wrongsequence ? "NO" : "YES");
		}
	}
	
	public static class Sq extends ArrayList{
		public void addelement(Object obj) {
			if(obj != null){
				this.add(obj);}
		}
		public Object deleteelement() {
			Object aux = this.get(0);
			if(this.size() > 0){
				this.remove(this.size()-1);
			}
			return aux;
		}
		public Object top() {
			Object aux = null;
			if(this.size() > 0){
				aux = this.get(this.size()-1);
			}
			return aux;
		}
		public boolean isEmpty() {
			return this.isEmpty();
		}
	}
}