import java.util.*;
    public class test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
           
            int i, n, m, maxn, curr, num, last, value;
            Deque dq = new ArrayDeque<>();
            Map <Integer, Integer> mp = new HashMap<>();

            n = in.nextInt();
            m = in.nextInt();

            maxn = curr = 0;
            for ( i = 0; i < n; i++ ) {
                num = in.nextInt();
                if ( dq.size() == m ) {
                    last = (int) dq.pollLast();
                    //System.out.println("DqLast -> " + last);
                    value = mp.get(last) - 1;
                    //System.out.println("MapValue -> " + value);

                    mp.put( last, value );
                    if ( value == 0) curr--;
                }

                if ( !mp.containsKey(num) || mp.get(num) == 0 ) curr++;

                dq.offerFirst(num);
                maxn = Math.max( maxn, curr );

                Integer val = mp.get(num);
                if ( val == null )
                    val = new Integer(0);

                mp.put( num, val + 1 ); 
            }

            System.out.println(maxn);
            }
    }
