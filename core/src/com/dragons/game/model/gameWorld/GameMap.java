package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

import com.dragons.game.components.Tiled;
import com.dragons.game.model.IObject;

import com.dragons.game.model.factories.BlockFactory;
import com.dragons.game.model.factories.PowerUpFactory;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import com.dragons.game.model.blocks.BlockType;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameMap {

    private Tiled tileRenderer;
    public Table<Integer, Integer, ArrayList<IObject>> tileContainers;
    private int tileWidth, tileHeight,
            mapWidthInTiles, mapHeightInTiles,
            mapWidthInPixels, mapHeightInPixels;

    private TiledMap tiledMap;
    private final BlockFactory blockFactory;
    private final PowerUpFactory powerUpFactory;

    public GameMap(String mapName) {
        Gdx.app.log("GameMap", "Constructing game map");
        tiledMap = new TmxMapLoader().load(mapName); //"TileMapMobile.tmx"

        MapProperties properties = tiledMap.getProperties();
        tileWidth         = properties.get("tilewidth", Integer.class);
        tileHeight        = properties.get("tileheight", Integer.class);
        mapWidthInTiles   = properties.get("width", Integer.class);
        mapHeightInTiles  = properties.get("height", Integer.class);
        mapWidthInPixels  = mapWidthInTiles  * tileWidth;
        mapHeightInPixels = mapHeightInTiles * tileHeight;
        float w = Gdx.graphics.getWidth(); // TODO: SE PÅ HVA DETTE ER!!!
        float h = Gdx.graphics.getHeight();
        //camera = new OrthographicCamera();
        //camera.setToOrtho(false,w,h);
        //camera.update();
        blockFactory = new BlockFactory();
        powerUpFactory = new PowerUpFactory();
        tileContainers = HashBasedTable.create();
        // Initialize tileContainers with tiles
        for (int x = 0; x < mapWidthInTiles; x++) {
            for (int y = 0; y < mapHeightInTiles; y++) {
                tileContainers.put(x, y, new ArrayList<IObject>());
            }
        }

    }

    // Find the associated tile given a coordinate position
    public Vector2 pos2tile(Vector2 pos) {
        int resX = (int) ((pos.x-(pos.x % tileWidth)) / tileWidth) - 1;
        int resY = (int) ((pos.y-(pos.y % tileHeight)) / tileHeight) - 1;
        return new Vector2(resX, resY);
    }

    // Find the starting position of a tile given the tile index
    public Vector2 tilePos(Vector2 tile) {
        return new Vector2((tile.x)*tileWidth, (tile.y)*tileHeight);
    }

    public Vector2 tilePosCenter(Vector2 tile) {
        return new Vector2((tile.x)*tileWidth + (tileWidth/2), (tile.y)*tileHeight + (tileHeight/2));
    }

    // Generate block instances in the tile containers given a recipe
    public void generateBlocks(int numberOfPowerups, String recipeFile) throws IOException {
        Gdx.app.log("GameMap", "Generating blocks from recipe");
        Vector2 tile = new Vector2(0, 0);
        Scanner scanner = new Scanner(new File(recipeFile));
        scanner.useDelimiter("");

        int x = 0;
        int y = mapHeightInTiles-1; // We start in the top left corner iterating through our recipe!
        // TODO: Check that the initial indexes are correct in case of placement mistake!!

        while(scanner.hasNext()) {
            tile.x = x;
            tile.y = y;
            switch (scanner.next()) {
                case "0":
                    x++;
                    break;
                case "1":

                    IObject desblock = blockFactory.createBlock(tilePosCenter(tile), BlockType.DESTRUCTIBLE, tileWidth, tileHeight);
                    tileContainers.get(x, y).add(desblock);
                    x++;
                    break;
                case "2":
                    System.out.print(tilePos(tile).toString());
                    IObject wallblock = blockFactory.createBlock(tilePosCenter(tile), BlockType.WALL, tileWidth, tileHeight);
                    tileContainers.get(x, y).add(wallblock);
                    x++;
                    break;
                case "3":
                    IObject desPowerupBlock = blockFactory.createBlock(tilePosCenter(tile), BlockType.DESTRUCTIBLE, tileWidth, tileHeight);
                    //IObject powerup = powerUpFactory.createPowerUp(PowerUpType.INCREASESPEED); lager en random powerup
                    tileContainers.get(x, y).add(desPowerupBlock);
                    //tileContainers.get(x, y).add(powerup);
                    x++;
                    break;
                case " ":
                    break;
                default:
                    // Basically when we reach the end of the line!
                    y = y - 1;
                    x = 0;
                    break;
            }
        }
    }

    public ArrayList<IObject> getTileContent(int xKey, int yKey) {
        return tileContainers.get(xKey,yKey);
    }

    public void setTileContent(int xKey, int yKey, ArrayList<IObject> list) {
        tileContainers.put(xKey, yKey, list);
    }

    public Tiled getTileRenderer() {
        return tileRenderer;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getMapWidthInTiles() {
        return mapWidthInTiles;
    }

    public int getMapHeightInTiles() {
        return mapHeightInTiles;
    }

    public int getMapWidthInPixels() {
        return mapWidthInPixels;
    }

    public int getMapHeightInPixels() {
        return mapHeightInPixels;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

}
