package UserInterface.Insertion;

import UserInterface.Controllers.GameGrid;

public class NotHighlight extends LogicGate {

    @Override
    public void topDirection(GameGrid.Tile[][] grid, int x, int y) {
        System.out.println("You know what to do here. Have fun");
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
