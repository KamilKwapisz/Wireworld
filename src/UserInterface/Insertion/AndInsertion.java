package UserInterface.Insertion;

import UserInterface.Controllers.GameGrid;

public class AndInsertion implements Insertion{

    @Override
    public void insertTop(GameGrid.Tile[][] grid, int x, int y) {
        grid[x][y].yellowTile();
        grid[x+2][y].yellowTile();
        grid[x][y-1].yellowTile();
        grid[x+2][y-1].yellowTile();
        grid[x][y-2].yellowTile();
        grid[x+2][y-2].yellowTile();
        grid[x-1][y-3].yellowTile();
        grid[x-2][y-3].yellowTile();
        grid[x+3][y-3].yellowTile();
        grid[x-3][y-4].yellowTile();
        grid[x+4][y-4].yellowTile();
        grid[x-2][y-5].yellowTile();
        grid[x-1][y-5].yellowTile();
        grid[x][y-5].yellowTile();
        grid[x+1][y-5].yellowTile();
        grid[x+5][y-5].yellowTile();
        grid[x+2][y-6].yellowTile();
        grid[x+5][y-6].yellowTile();
        grid[x+1][y-7].yellowTile();
        grid[x+2][y-7].yellowTile();
        grid[x+3][y-7].yellowTile();
        grid[x+5][y-7].yellowTile();
        grid[x+2][y-8].yellowTile();
        grid[x+5][y-8].yellowTile();
        grid[x+1][y-9].yellowTile();
        grid[x+3][y-9].yellowTile();
        grid[x+5][y-9].yellowTile();
        grid[x][y-10].yellowTile();
        grid[x+4][y-10].yellowTile();
        grid[x-1][y-11].yellowTile();
        grid[x][y-11].yellowTile();
        grid[x+1][y-11].yellowTile();
        grid[x+4][y-11].yellowTile();
        grid[x][y-12].yellowTile();
        grid[x+4][y-12].yellowTile();
        grid[x-1][y-13].yellowTile();
        grid[x+1][y-13].yellowTile();
        grid[x+2][y-13].yellowTile();
        grid[x+3][y-13].yellowTile();
        grid[x-1][y-14].yellowTile();
        grid[x][y-15].yellowTile();
        grid[x+1][y-16].yellowTile();
        grid[x+1][y-17].yellowTile();
    }

    @Override
    public void insertBottom(GameGrid.Tile[][] grid, int x, int y) {
        grid[x][y].yellowTile();
        grid[x-2][y].yellowTile();
        grid[x][y+1].yellowTile();
        grid[x-2][y+1].yellowTile();
        grid[x][y+2].yellowTile();
        grid[x-2][y+2].yellowTile();
        grid[x-3][y+3].yellowTile();
        grid[x+1][y+3].yellowTile();
        grid[x+2][y+3].yellowTile();
        grid[x-4][y+4].yellowTile();
        grid[x+3][y+4].yellowTile();
        grid[x-5][y+5].yellowTile();
        grid[x-1][y+5].yellowTile();
        grid[x][y+5].yellowTile();
        grid[x+1][y+5].yellowTile();
        grid[x+2][y+5].yellowTile();
        grid[x-5][y+6].yellowTile();
        grid[x-2][y+6].yellowTile();
        grid[x-5][y+7].yellowTile();
        grid[x-3][y+7].yellowTile();
        grid[x-2][y+7].yellowTile();
        grid[x-1][y+7].yellowTile();
        grid[x-5][y+8].yellowTile();
        grid[x-2][y+8].yellowTile();
        grid[x-5][y+9].yellowTile();
        grid[x-3][y+9].yellowTile();
        grid[x-1][y+9].yellowTile();
        grid[x-4][y+10].yellowTile();
        grid[x][y+10].yellowTile();
        grid[x-4][y+11].yellowTile();
        grid[x-1][y+11].yellowTile();
        grid[x][y+11].yellowTile();
        grid[x+1][y+11].yellowTile();
        grid[x-4][y+12].yellowTile();
        grid[x][y+12].yellowTile();
        grid[x-3][y+13].yellowTile();
        grid[x-2][y+13].yellowTile();
        grid[x-1][y+13].yellowTile();
        grid[x+1][y+13].yellowTile();
        grid[x+1][y+14].yellowTile();
        grid[x][y+15].yellowTile();
        grid[x-1][y+16].yellowTile();
        grid[x-1][y+17].yellowTile();
    }

    @Override
    public void insertLeft(GameGrid.Tile[][] grid, int x, int y) {
        grid[x][y].yellowTile();
        grid[x][y-2].yellowTile();
        grid[x-1][y].yellowTile();
        grid[x-1][y-2].yellowTile();
        grid[x-2][y].yellowTile();
        grid[x-2][y-2].yellowTile();
        grid[x-3][y+2].yellowTile();
        grid[x-3][y+1].yellowTile();
        grid[x-3][y-3].yellowTile();
        grid[x-4][y+3].yellowTile();
        grid[x-4][y-4].yellowTile();
        grid[x-5][y+2].yellowTile();
        grid[x-5][y+1].yellowTile();
        grid[x-5][y].yellowTile();
        grid[x-5][y-1].yellowTile();
        grid[x-5][y-5].yellowTile();
        grid[x-6][y-2].yellowTile();
        grid[x-6][y-5].yellowTile();
        grid[x-7][y-1].yellowTile();
        grid[x-7][y-2].yellowTile();
        grid[x-7][y-3].yellowTile();
        grid[x-7][y-5].yellowTile();
        grid[x-8][y-2].yellowTile();
        grid[x-8][y-5].yellowTile();
        grid[x-9][y-1].yellowTile();
        grid[x-9][y-3].yellowTile();
        grid[x-9][y-5].yellowTile();
        grid[x-10][y-4].yellowTile();
        grid[x-10][y-1].yellowTile();
        grid[x-11][y+1].yellowTile();
        grid[x-11][y].yellowTile();
        grid[x-11][y-1].yellowTile();
        grid[x-11][y-4].yellowTile();
        grid[x-12][y].yellowTile();
        grid[x-12][y-4].yellowTile();
        grid[x-13][y+1].yellowTile();
        grid[x-13][y-1].yellowTile();
        grid[x-13][y-2].yellowTile();
        grid[x-13][y-3].yellowTile();
        grid[x-14][y+1].yellowTile();
        grid[x-15][y].yellowTile();
        grid[x-16][y-1].yellowTile();
        grid[x-17][y-1].yellowTile();
    }

    @Override
    public void insertRight(GameGrid.Tile[][] grid, int x, int y) {
        grid[x][y].yellowTile();
        grid[x][y+2].yellowTile();
        grid[x+1][y].yellowTile();
        grid[x+1][y+2].yellowTile();
        grid[x+2][y].yellowTile();
        grid[x+2][y+2].yellowTile();
        grid[x+3][y-1].yellowTile();
        grid[x+3][y-2].yellowTile();
        grid[x+3][y+3].yellowTile();
        grid[x+4][y-3].yellowTile();
        grid[x+4][y+4].yellowTile();
        grid[x+5][y-2].yellowTile();
        grid[x+5][y-1].yellowTile();
        grid[x+5][y].yellowTile();
        grid[x+5][y+1].yellowTile();
        grid[x+5][y+5].yellowTile();
        grid[x+6][y+2].yellowTile();
        grid[x+6][y+5].yellowTile();
        grid[x+7][y+1].yellowTile();
        grid[x+7][y+2].yellowTile();
        grid[x+7][y+3].yellowTile();
        grid[x+7][y+5].yellowTile();
        grid[x+8][y+2].yellowTile();
        grid[x+8][y+5].yellowTile();
        grid[x+9][y+1].yellowTile();
        grid[x+9][y+3].yellowTile();
        grid[x+9][y+5].yellowTile();
        grid[x+10][y].yellowTile();
        grid[x+10][y+4].yellowTile();
        grid[x+11][y-1].yellowTile();
        grid[x+11][y].yellowTile();
        grid[x+11][y+1].yellowTile();
        grid[x+11][y+4].yellowTile();
        grid[x+12][y].yellowTile();
        grid[x+12][y+4].yellowTile();
        grid[x+13][y-1].yellowTile();
        grid[x+13][y+1].yellowTile();
        grid[x+13][y+2].yellowTile();
        grid[x+13][y+3].yellowTile();
        grid[x+14][y-1].yellowTile();
        grid[x+15][y].yellowTile();
        grid[x+16][y+1].yellowTile();
        grid[x+17][y+1].yellowTile();
    }
    
}
