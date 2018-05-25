package UserInterface.Insertion;

import UserInterface.Controllers.GameGrid;

public abstract class LogicGate {
    public abstract void insertTop(GameGrid.Tile[][] grid, int x, int y);
    public abstract void insertBottom(GameGrid.Tile[][] grid, int x, int y);
    public abstract void insertLeft(GameGrid.Tile[][] grid, int x, int y);
    public abstract void insertRight(GameGrid.Tile[][] grid, int x, int y);
}
