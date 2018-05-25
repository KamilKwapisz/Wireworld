package UserInterface.Insertion;

import UserInterface.Controllers.GameGrid;

public class AndHighlight extends LogicGate {

    @Override
    public void topDirection(GameGrid.Tile[][] grid, int x, int y) {
        grid[x][y].highlightTile();
        grid[x+2][y].highlightTile();
        grid[x][y-1].highlightTile();
        grid[x+2][y-1].highlightTile();
        grid[x][y-2].highlightTile();
        grid[x+2][y-2].highlightTile();
        grid[x-1][y-3].highlightTile();
        grid[x-2][y-3].highlightTile();
        grid[x+3][y-3].highlightTile();
        grid[x-3][y-4].highlightTile();
        grid[x+4][y-4].highlightTile();
        grid[x-2][y-5].highlightTile();
        grid[x-1][y-5].highlightTile();
        grid[x][y-5].highlightTile();
        grid[x+1][y-5].highlightTile();
        grid[x+5][y-5].highlightTile();
        grid[x+2][y-6].highlightTile();
        grid[x+5][y-6].highlightTile();
        grid[x+1][y-7].highlightTile();
        grid[x+2][y-7].highlightTile();
        grid[x+3][y-7].highlightTile();
        grid[x+5][y-7].highlightTile();
        grid[x+2][y-8].highlightTile();
        grid[x+5][y-8].highlightTile();
        grid[x+1][y-9].highlightTile();
        grid[x+3][y-9].highlightTile();
        grid[x+5][y-9].highlightTile();
        grid[x][y-10].highlightTile();
        grid[x+4][y-10].highlightTile();
        grid[x-1][y-11].highlightTile();
        grid[x][y-11].highlightTile();
        grid[x+1][y-11].highlightTile();
        grid[x+4][y-11].highlightTile();
        grid[x][y-12].highlightTile();
        grid[x+4][y-12].highlightTile();
        grid[x-1][y-13].highlightTile();
        grid[x+1][y-13].highlightTile();
        grid[x+2][y-13].highlightTile();
        grid[x+3][y-13].highlightTile();
        grid[x-1][y-14].highlightTile();
        grid[x][y-15].highlightTile();
        grid[x+1][y-16].highlightTile();
        grid[x+1][y-17].highlightTile();
    }

    @Override
    public void bottomDirection(GameGrid.Tile[][] grid, int x, int y) {
        System.out.println("You know what to do here. Have fun");
    }

    @Override
    public void leftDirection(GameGrid.Tile[][] grid, int x, int y) {
        System.out.println("You know what to do here. Have fun");
    }

    @Override
    public void rightDirection(GameGrid.Tile[][] grid, int x, int y) {
        System.out.println("You know what to do here. Have fun");
    }
    
}
