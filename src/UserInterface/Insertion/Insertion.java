package UserInterface.Insertion;

import UserInterface.Controllers.GameGrid.Tile;

public interface Insertion {
    public void insertTop(Tile[][] grid, int x, int y);
    public void insertBottom(Tile[][] grid, int x, int y);
    public void insertLeft(Tile[][] grid, int x, int y);
    public void insertRight(Tile[][] grid, int x, int y);
}
