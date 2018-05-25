package UserInterface.Insertion;

import UserInterface.Controllers.GameGrid;

public abstract class LogicGate {
    public abstract void topDirection(GameGrid.Tile[][] grid, int x, int y);
    public abstract void bottomDirection(GameGrid.Tile[][] grid, int x, int y);
    public abstract void leftDirection(GameGrid.Tile[][] grid, int x, int y);
    public abstract void rightDirection(GameGrid.Tile[][] grid, int x, int y);
}
