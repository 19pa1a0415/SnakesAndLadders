class Game {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private  List<Jumper> ladders;
    private  Map<String,Integer> playersCurrentPosition;
    int boardSize;

     Game(Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders,Map<String,Integer> playersCurrentPosition,int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }

     void startGame(){
        while(nextTurn.size()>1) {
            Player player = nextTurn.poll();
            int curr_Position = playersCurrentPosition.get(player.getPlayerName());
            int diceValue = dice.rollDice();
            int newPosition = curr_Position + diceValue;
            if (newPosition > boardSize) 
                  nextTurn.offer(player);
                  
            else if (newPosition == boardSize) {
                System.out.println( player.getPlayerName() + " won the game");
            }
            
            else{
                
               int[] nextPosition = new int[1];
               
               boolean[] b = new boolean[1];
               nextPosition[0] = newPosition;
               for(Jumper obj: snakes) {
                   if(obj.startPoint==newPosition) {
                       nextPosition[0] = obj.endPoint;
                   }
               }
                   
               if(nextPosition[0] != newPosition) {
                          System.out.println(player.getPlayerName() + " Bitten by Snake present at: "+ newPosition);
               }
               
               for(Jumper obj:ladders) {
                    if(obj.startPoint==newPosition) {
                        nextPosition[0] = obj.endPoint;
                        b[0]=true;
                    } 
               }
               
                if(nextPosition[0] != newPosition && b[0]){
                     System.out.println(player.getPlayerName() + " Got ladder present at: "+ newPosition);
                }
                if(nextPosition[0] == boardSize){
                    System.out.println(player.getPlayerName() + " won the game");
                }else{
                    playersCurrentPosition.put(player.getPlayerName(),nextPosition[0]);
                    System.out.println(player.getPlayerName() + " is moved to the position "+ nextPosition[0]);
                    nextTurn.offer(player);
                }
            }
        }
    }
}
