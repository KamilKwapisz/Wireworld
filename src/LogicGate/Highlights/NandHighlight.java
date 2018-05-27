package LogicGate.Highlights;

import LogicGate.LogicGate;
import UserInterface.Controllers.GameGrid;

public class NandHighlight extends LogicGate {

    @Override
    public void topDirection(GameGrid.Tile[][] grid, int x, int y) {
        grid[x+1][y-13].highlightTile();
        grid[x+1][y-12].highlightTile();
        grid[x+1][y-11].highlightTile();
        grid[x+1][y-10].highlightTile();
        grid[x-5][y-9].highlightTile();
        grid[x-5][y-8].highlightTile();
        grid[x-5][y-7].highlightTile();
        grid[x-4][y-10].highlightTile();
        grid[x-4][y-6].highlightTile();
        grid[x-3][y-11].highlightTile();
        grid[x-3][y-10].highlightTile();
        grid[x-3][y-9].highlightTile();
        grid[x-3][y-5].highlightTile();
        grid[x-2][y-10].highlightTile();
        grid[x-1][y-9].highlightTile();
        grid[x-1][y-11].highlightTile();
        grid[x][y-11].highlightTile();
        grid[x-2][y-4].highlightTile();
        grid[x][y-2].highlightTile();
        grid[x][y-1].highlightTile();
        grid[x][y].highlightTile();
        grid[x][y-8].highlightTile();
        grid[x-1][y-3].highlightTile();
        grid[x][y-6].highlightTile();
        grid[x][y-5].highlightTile();
        grid[x+2][y-6].highlightTile();
        grid[x+2][y-5].highlightTile();
        grid[x+2][y-2].highlightTile();
        grid[x+2][y-1].highlightTile();
        grid[x+2][y].highlightTile();
        grid[x+1][y-7].highlightTile();
        grid[x+2][y-11].highlightTile();
        grid[x+2][y-8].highlightTile();
        grid[x+1][y-4].highlightTile();
        grid[x+3][y-11].highlightTile();
        grid[x+3][y-3].highlightTile();
        grid[x+3][y-9].highlightTile();
        grid[x+5][y-11].highlightTile();
        grid[x+5][y-10].highlightTile();
        grid[x+5][y-9].highlightTile();
        grid[x+4][y-10].highlightTile();
        grid[x+6][y-10].highlightTile();
        grid[x+7][y-9].highlightTile();
        grid[x+7][y-8].highlightTile();
        grid[x+7][y-7].highlightTile();
        grid[x+4][y-4].highlightTile();
        grid[x+5][y-5].highlightTile();
        grid[x+6][y-6].highlightTile();

    }

    @Override
    public void bottomDirection(GameGrid.Tile[][] grid, int x, int y) {
        grid[x][y].highlightTile();
        grid[x][y+1].highlightTile();
        grid[x][y+2].highlightTile();
        grid[x-2][y].highlightTile();
        grid[x-2][y+1].highlightTile();
        grid[x-2][y+2].highlightTile();
        grid[x+1][y+3].highlightTile();
        grid[x+2][y+4].highlightTile();
        grid[x+3][y+5].highlightTile();
        grid[x+4][y+6].highlightTile();
        grid[x+5][y+7].highlightTile();
        grid[x+5][y+8].highlightTile();
        grid[x+5][y+9].highlightTile();
        grid[x+3][y+9].highlightTile();
        grid[x+3][y+10].highlightTile();
        grid[x+3][y+11].highlightTile();
        grid[x-5][y+5].highlightTile();
        grid[x-6][y+6].highlightTile();
        grid[x-7][y+7].highlightTile();
        grid[x-7][y+8].highlightTile();
        grid[x-7][y+9].highlightTile();
        grid[x-6][y+10].highlightTile();
        grid[x+4][y+10].highlightTile();
        grid[x+2][y+10].highlightTile();
        grid[x+1][y+9].highlightTile();
        grid[x+1][y+11].highlightTile();
        grid[x-1][y+10].highlightTile();
        grid[x-1][y+11].highlightTile();
        grid[x-1][y+12].highlightTile();
        grid[x-1][y+13].highlightTile();
        grid[x][y+5].highlightTile();
        grid[x][y+6].highlightTile();
        grid[x-2][y+5].highlightTile();
        grid[x-2][y+6].highlightTile();
        grid[x-2][y+8].highlightTile();
        grid[x-2][y+11].highlightTile();
        grid[x-3][y+9].highlightTile();
        grid[x][y+8].highlightTile();
        grid[x][y+11].highlightTile();
        grid[x-1][y+4].highlightTile();
        grid[x-1][y+7].highlightTile();
        grid[x-4][y+4].highlightTile();
        grid[x-5][y+9].highlightTile();
        grid[x-5][y+10].highlightTile();
        grid[x-5][y+11].highlightTile();
        grid[x-3][y+11].highlightTile();
        grid[x-4][y+10].highlightTile();
        grid[x-3][y+3].highlightTile();

    }

    @Override
    public void leftDirection(GameGrid.Tile[][] grid, int x, int y) {
        grid[x][y].highlightTile();
        grid[x][y-2].highlightTile();
        grid[x-1][y-2].highlightTile();
        grid[x-11][y-3].highlightTile();
        grid[x-11][y-2].highlightTile();
        grid[x-11][y-1].highlightTile();
        grid[x-11][y].highlightTile();
        grid[x-11][y+1].highlightTile();
        grid[x-10][y-6].highlightTile();
        grid[x-10][y-5].highlightTile();
        grid[x-10][y-4].highlightTile();
        grid[x-10][y+2].highlightTile();
        grid[x-10][y+3].highlightTile();
        grid[x-10][y+4].highlightTile();
        grid[x-11][y+3].highlightTile();
        grid[x-13][y-1].highlightTile();
        grid[x-12][y-1].highlightTile();
        grid[x-10][y-1].highlightTile();
        grid[x-11][y-5].highlightTile();
        grid[x-9][y-7].highlightTile();
        grid[x-9][y+1].highlightTile();
        grid[x-9][y-5].highlightTile();
        grid[x-9][y-3].highlightTile();
        grid[x-9][y+5].highlightTile();
        grid[x-9][y+3].highlightTile();
        grid[x-8][y-7].highlightTile();
        grid[x-8][y-2].highlightTile();
        grid[x-8][y+5].highlightTile();
        grid[x-8][y].highlightTile();
        grid[x-7][y-7].highlightTile();
        grid[x-7][y-1].highlightTile();
        grid[x-7][y+5].highlightTile();
        grid[x-6][y-6].highlightTile();
        grid[x-5][y-5].highlightTile();
        grid[x-4][y-4].highlightTile();
        grid[x-3][y-3].highlightTile();
        grid[x-2][y-2].highlightTile();
        grid[x-6][y-2].highlightTile();
        grid[x-6][y].highlightTile();
        grid[x-6][y+4].highlightTile();
        grid[x-5][y-2].highlightTile();
        grid[x-5][y+3].highlightTile();
        grid[x-5][y].highlightTile();
        grid[x-4][y-1].highlightTile();
        grid[x-4][y+2].highlightTile();
        grid[x-3][y+1].highlightTile();
        grid[x-2][y].highlightTile();
        grid[x-1][y].highlightTile();

    }

    @Override
    public void rightDirection(GameGrid.Tile[][] grid, int x, int y) {
        grid[x][y].highlightTile();
        grid[x+1][y].highlightTile();
        grid[x+2][y].highlightTile();
        grid[x+3][y-1].highlightTile();
        grid[x+4][y-2].highlightTile();
        grid[x+5][y-3].highlightTile();
        grid[x+6][y-4].highlightTile();
        grid[x+7][y-5].highlightTile();
        grid[x+8][y-5].highlightTile();
        grid[x+9][y-5].highlightTile();
        grid[x+10][y-4].highlightTile();
        grid[x+9][y-3].highlightTile();
        grid[x+10][y-3].highlightTile();
        grid[x+11][y-3].highlightTile();
        grid[x+10][y-2].highlightTile();
        grid[x+9][y-1].highlightTile();
        grid[x+11][y-1].highlightTile();
        grid[x+8][y].highlightTile();
        grid[x+11][y].highlightTile();
        grid[x+10][y+1].highlightTile();
        grid[x+11][y+1].highlightTile();
        grid[x+11][y+2].highlightTile();
        grid[x+11][y+3].highlightTile();
        grid[x+12][y+1].highlightTile();
        grid[x+13][y+1].highlightTile();
        grid[x+11][y+5].highlightTile();
        grid[x+10][y+4].highlightTile();
        grid[x+10][y+5].highlightTile();
        grid[x+10][y+6].highlightTile();
        grid[x+9][y+3].highlightTile();
        grid[x+9][y+5].highlightTile();
        grid[x+9][y+7].highlightTile();
        grid[x+8][y+2].highlightTile();
        grid[x+6][y].highlightTile();
        grid[x+7][y+1].highlightTile();
        grid[x+5][y].highlightTile();
        grid[x+4][y+1].highlightTile();
        grid[x+5][y+2].highlightTile();
        grid[x+6][y+2].highlightTile();
        grid[x+8][y+7].highlightTile();
        grid[x+7][y+7].highlightTile();
        grid[x+6][y+6].highlightTile();
        grid[x+5][y+5].highlightTile();
        grid[x+4][y+4].highlightTile();
        grid[x+3][y+3].highlightTile();
        grid[x+2][y+2].highlightTile();
        grid[x+1][y+2].highlightTile();
        grid[x][y+2].highlightTile();


    }


    
}
