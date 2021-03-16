package com.dragons.game.components;

public class Board {

    private final Tile[][] tiles;

    private int width;
    private int height;

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
