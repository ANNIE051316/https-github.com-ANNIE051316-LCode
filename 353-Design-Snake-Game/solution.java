public class SnakeGame {
    
    class Pos {
        int row;
        int col;
        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    
    Queue<Pos> snake;
    int width;
    int height;
    int[][] food;
///    boolean[][] board;
    int headx = 0, heady = 0;
    int foodIndex = 0;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<Pos>();
        snake.offer(new Pos(0, 0));
        this.width = width;
        this.height = height;
        this.food = food;
   //     this.board = new boolean[height][width];
     //   this.board[0][0] = true;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch (direction) {
            case "U": 
                headx--;
                break;
            case "L":
                heady--;
                break;
            case "R":
                heady++;
                break;
            case "D":
                headx++;
                break;
            default:
                throw new IllegalArgumentException("Illegal input of direction" + direction);
        }
        
        if(headx < 0 || headx >= this.height || heady < 0 || heady >= this.width) {
            return -1;
        }
        
    
        if(this.foodIndex < food.length && food[foodIndex][0] == headx && food[foodIndex][1] == heady) {
            this.foodIndex++;
        }
        else {
            snake.poll();
            Iterator<Pos> iter = snake.iterator();
            while(iter.hasNext()) {
                Pos tmp = (Pos)iter.next();
                if(tmp.row == headx && tmp.col == heady) 
                {
                    return -1;
                }
            }
        }
        snake.offer(new Pos(headx, heady));
        
        return this.foodIndex;
        
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */