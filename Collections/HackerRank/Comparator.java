import java.io.*;
import java.util.*;


class Player{
	String name;
	int score;
}

class Checker {
    Comparator<Player> desc = new Comparator<Player>() {
        public int compare ( Player p1, Player p2) {
            if (p1.score == p2.score)
                return p2.name.compareTo(p1.name);
            else
                return p2.score - p1.score;
        };
    };    
}


public class Solution {

	 public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       
  	  int N=Integer.parseInt(br.readLine().trim());
  	  String s;
  	  StringTokenizer st;
  	  Player Player[]=new Player[N];
  	  Checker check=new Checker();
	  
  	  for(int i=0;i<N;i++){
  		  s=br.readLine().trim();
  		  st=new StringTokenizer(s);
  		  Player[i]=new Player();
  		  Player[i].name=st.nextToken();
  		  Player[i].score=Integer.parseInt(st.nextToken());
  	  }
	 
  	  Arrays.sort(Player,check.desc);
  	  for(int i=0;i<Player.length;i++){
  			System.out.printf("%s %s\n",Player[i].name,Player[i].score);
  	  }

    }
}
