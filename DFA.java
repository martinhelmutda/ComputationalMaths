import Java.lang.*;

public class DFA {
  public static void main(String[] args){
	  
	  String pattern = "abba";
	  String alphabet = "ab";
	  String cadena = "aaaaabbbb";
	  
	  transition(pattern, alphabet);
	  
	  if(pattern.contains(alphabet)) {
		  System.out.println("Sí está");
		  
		
	  }else {
		  System.out.println("No está");
	  }
  }
  
  
  public static char[][] transition(String pattern,String alphabet){
	  	
			System.out.println("Sí está");
			int k, cnum;
			
			int m = pattern.length();
			int [][] delta = new int[100][m];
			char[] patternArr=pattern.toCharArray();
			
			String pq = null;
			String pk= pattern.substring(0,1);
			//String pk="abba";
			//System.out.println(pk);
			
			for (int q = 0; q <= m; q++) {
				//System.out.println(q);
				cnum=0;
				
				
				for(char c: alphabet.toCharArray()) {
					k=Math.min(m+1, q+2);
					//System.out.println(c);
					pq=pattern.substring(0, q)+c;
					
					
					 do {
						if(1<=k &&  k<= m+1) {
							k=k-1;
							//System.out.print(" "+ k);
							pk=pattern.substring(0,k);
						}						
						//System.out.println(c + " "+pq +" "+pk);
					} while (!pq.endsWith(pk));
					 delta[q][cnum]=k;
					 cnum++;
				}				
			}
	
			for (int i = 0; i < m+1; i++) {
				for (int j = 0; j < alphabet.length(); j++) {
					System.out.print(delta[i][j] +" ");
				}
				System.out.println();
			}
	  return null;	  
  }
}
