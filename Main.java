import java.util.*
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		Dice dice = new Dice(1);
		Queue<Player> allPlayers = new LinkedList<>();
		Map<String,Integer> playersCurrentPosition = new HashMap<>();
		List<Jumper> snakes = new ArrayList<>();
		List<Jumper> ladders = new ArrayList<>();
		System.out.println("Enter the board size");
		int boardSize = sc.nextInt();
		System.out.println("How many players you want:");
		int n = sc.nextInt();
		for(int i=1;i<n+1;i++){
		    String name = sc.next();
		    Player p1 = new Player(name,i);
		    allPlayers.offer(p1);
		    playersCurrentPosition.put(name,0);
		}
		System.out.println("How many snakes you want:");
		int t = sc.nextInt();
		System.out.println("Enter tail and head");
		for(int i =0;i<t;i++){
		    int head = sc.nextInt();
		    int tail = sc.nextInt();
		    Jumper snake1 = new Jumper(head,tail);
		    snakes.add(snake1);
		}
        System.out.println("How many ladders you want:");
		int t1 = sc.nextInt();
		System.out.println("Enter head and tail");
		for(int i =0;i<t1;i++){
		    int head1 = sc.nextInt();
		    int tail1 = sc.nextInt();
		    Jumper ladder1 = new Jumper(tail1,head1);
		    ladders.add(ladder1);
		}
        Game obj = new Game(dice,allPlayers,snakes,ladders,playersCurrentPosition,boardSize);
        obj.startGame();
	}
}
