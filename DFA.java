
import java.util.Scanner;

public class DFA {
  private static Scanner teclado;

public static void main(String[] args){
	  

	  teclado = new Scanner(System.in);
	  String alphabet=teclado.nextLine();
	  String pattern=teclado.nextLine();	 
	  String cadena=teclado.nextLine();  
	  System.out.println(finite_automaton_matcher(cadena, transition(pattern, alphabet), pattern.length(), alphabet));

  }
  
  
  public static int[][] transition(String pattern,String alphabet){
	  	
			int k, cnum;
			
			int m = pattern.length();
			int [][] delta = new int[100][m];
			String pq = null;
			String pk= pattern.substring(0,1);
			
			for (int q = 0; q <= m; q++) {
				cnum=0;	
				for(char c: alphabet.toCharArray()) {
					k=Math.min(m+1, q+2);
					pq=pattern.substring(0, q)+c;
					
					
					 do {
						if(1<=k &&  k<= m+1) {
							k=k-1;
							pk=pattern.substring(0,k);
						}						
					} while (!pq.endsWith(pk));
					 delta[q][cnum]=k;
					 cnum++;
				}				
			}
	

			
	  return delta;	  
  }
  
  public static int  finite_automaton_matcher(String cadena, int [][]matrix, int m, String pattern){
	  int n = cadena.length();
	  int q = 0, aux, contador=0;
	  char [] cadenaArr= cadena.toCharArray();
	  for (int i = 0; i < n; i++) {				  
		aux=numChar(cadenaArr[i],pattern);
		q = matrix[q][aux];
		if (q==m) {
//			System.out.println("Pattern occurs" + q);
			contador++;
		}
	  }
  return contador;
  }
  
  public static int numChar(char x, String alphabet) {
	  char [] alphabetArr = alphabet.toCharArray();
	  int num=0;
	  for (int i= 0; i < alphabetArr.length;i++) {
		   if(alphabetArr[i]==x) {
			   num=i;
		   }
	  }
	  return num;	  
  }
  
}

