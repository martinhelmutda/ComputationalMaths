

public class DFA {
  public static void main(String[] args){
	  
//	  String pattern = "abba";
//	  String alphabet = "ab";
//	  String cadena = "baabbabbaaba";
	  
	  String pattern = "zyx";
	  String alphabet = "xyz";
	  String cadena = "zyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyxzyx";
	  
	  System.out.println(finite_automaton_matcher(cadena, transition(pattern, alphabet), pattern.length(), alphabet));
	  //transition(pattern, alphabet);
	  
	  if(pattern.contains(alphabet)) {
		  System.out.println("Sí está");
		  
		
	  }else {
		  System.out.println("No está");
	  }
  }
  
  
  public static int[][] transition(String pattern,String alphabet){
	  	
			int k, cnum;
			
			int m = pattern.length();
			int [][] delta = new int[100][m];
			char[] patternArr=pattern.toCharArray();
			
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
	
//			for (int i = 0; i < m+1; i++) {
//				for (int j = 0; j < alphabet.length(); j++) {
//					System.out.print(delta[i][j] +" ");
//				}
//				System.out.println();
//			}
			
	  return delta;	  
  }
  
  public static int  finite_automaton_matcher(String cadena, int [][]matrix, int m, String pattern){
	  int n = cadena.length();
	  int q = 0, aux, contador=0;
	  char [] cadenaArr= cadena.toCharArray();
	  for (int i = 0; i < n; i++) {		
		  
		aux=numChar(cadenaArr[i],pattern);
//		System.out.println("HOLA:" + cadenaArr[i]+" so "+ aux);
		
		q = matrix[q][aux];
		
//		System.out.println("Esta es i:"+q+"  "+aux + " " + q);
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
//		  System.out.println(x +" estamos en este numero " +alphabetArr[i]);
		   if(alphabetArr[i]==x) {
			   num=i;
		   }
	  }
	  return num;	  
  }
  
}
