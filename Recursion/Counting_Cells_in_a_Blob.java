public class Counting_Cells_in_a_Blob {
    private static int BACKGROUND_COLOR = 0;
    private static int IMAGE_COLOR= 1;
    private static int ALREADY_COUNTED = 2; //방문했던 cell에 해당

    public int countCells(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= N) //N x N에 해당하기에.
            return 0;
        else if(grid[x][y] != IMAGE_COLOR) //grid는 주어지는 map에 해당
            return 0;
        else {
            grid[x][y] = ALREADY_COUNTED;
            return 1 + countCells(x-1, y+1) + countCells(x, y+1)
                    + countCells(x+1, y+1) + countCells(x-1, y)
                    + countCells(x+1, y) + countCells(x-1, y-1)
                    + countCells(x, y-1) + countCells(x+1, y-1);
            //1 + 는 자기 자신을 더한 후, 북쪽부터 시계방향으로 8개의 좌표가 나온다.
        }
    }
}