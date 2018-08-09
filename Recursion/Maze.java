public class Maze {
    private static int N = 8;
    private static int [][] maze = { //미로의 모양에 해당
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
    };

    private static final int PATHWAY_COLOUR = 0;
    private static final int WALL_COLOUR = 1;
    private static final int BLOCKED_COLOUR= 2; //이미 방문했지만 막힌 길
    private static final int PATH_COLOUR = 3; //이미 방문했고, 지나온 길

    public static boolean findMazePath(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N)
            return false;
        else if(maze[x][y] != PATHWAY_COLOUR)
            return false;
        else if(x == N-1 && y == N-1) { //출구에 해당한다.
            maze[x][y] = PATH_COLOUR;
            return true;
        } else {
            maze[x][y] = PATH_COLOUR;
            if(findMazePath(x-1, y) || findMazePath(x, y+1)
                    || findMazePath(x+1, y) || findMazePath(x, y-1)) {
                //동 서 남 북 모든 방향을 탐지한다.
                return true;
            } //재귀를 이용하여 모든 경우의 수를 확인하게 된다.
            maze[x][y] = BLOCKED_COLOUR;
            //바로 위의 if문을 벗어나게 된다면, 해당 cell의 경우 BLOCKED_COLOUR이므로, 표시를 하게 된다.
            //해당하는 방법을 사용하여 모든 경로를 확인하게 된다.
            return false;
        }
    }

    public static void main(String [] args) {
        printMaze();
        findMazePath(0, 0);
        printMaze();
    }
}