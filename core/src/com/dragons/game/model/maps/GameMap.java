package com.dragons.game.model.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;

import com.dragons.game.model.IModel;

import com.dragons.game.model.modelFactories.BlockFactory;
import com.dragons.game.model.modelFactories.PowerUpFactory;
import com.dragons.game.model.powerUps.PowerUpType;
import com.dragons.game.utilities.Constants;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import com.dragons.game.model.blocks.BlockType;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameMap {

    private final Table<Integer, Integer, ArrayList<IModel>> tileContainers;
    private int tileWidth, tileHeight,
            mapWidthInTiles, mapHeightInTiles,
            mapWidthInPixels, mapHeightInPixels;

    private final TiledMap tiledMap;

    // Factories
    private final BlockFactory blockFactory = BlockFactory.getInstance();;
    private final PowerUpFactory powerUpFactory = PowerUpFactory.getInstance();;

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

        tileContainers = HashBasedTable.create();

        // Initialize tileContainers with tiles
        for (int x = 0; x < mapWidthInTiles; x++) {
            for (int y = 0; y < mapHeightInTiles; y++) {
                tileContainers.put(x, y, new ArrayList<IModel>());
            }
        }
    }

    // Find the associated tile given IView coordinate position
    public Vector2 pos2tile(Vector2 pos) {
        int resX = (int) ((pos.x-(pos.x % tileWidth)) / tileWidth);
        int resY = (int) ((pos.y-(pos.y % tileHeight)) / tileHeight);
        return new Vector2(resX, resY);
    }


    public Vector2 tilePosCenter(Vector2 tile) {
        return new Vector2((tile.x)*tileWidth + (tileWidth / 2f), (tile.y)*tileHeight + (tileHeight / 2f));
    }

    // Generate block instances in the tile containers given IView recipe
    public void generateBlocks(String recipeFile){
        Gdx.app.log("GameMap", "Generating blocks from recipe");
        Vector2 tile = new Vector2(0, 0);

        Scanner scanner = new Scanner(Gdx.files.internal(recipeFile).read());
        scanner.useDelimiter("");
        int x = 0;
        int y = mapHeightInTiles-1; // We start in the top left corner iterating through our recipe!

        while(scanner.hasNext()) {
            tile.x = x;
            tile.y = y;
            switch (scanner.next()) {
                case "0":
                    x++;
                    break;
                case "1":
                    if (Math.random() < 0.75){
                        IModel desblock = blockFactory.createBlock(tilePosCenter(tile), BlockType.DESTRUCTIBLEBlOCK, tileWidth, tileHeight);
                        if (Math.random() < 0.4){
                            IModel powerUp = powerUpFactory.createPowerUp(tilePosCenter(tile), PowerUpType.RANDOM, tileWidth * Constants.PowerUpScaleFactor, tileHeight * Constants.PowerUpScaleFactor);
                            tileContainers.get(x, y).add(powerUp);
                        }
                        tileContainers.get(x, y).add(desblock);
                    }
                    x++;
                    break;
                case "2":
                    IModel wallblock = blockFactory.createBlock(tilePosCenter(tile), BlockType.WALLBLOCK, tileWidth, tileHeight);
                    tileContainers.get(x, y).add(wallblock);
                    x++;
                    break;
                case " ":
                    break;
                case "\r\n":
                case "\n":
                    y = y - 1;
                    x = 0;
                    break;
            }
        }
    }

    public ArrayList<IModel> getTileContent(int xKey, int yKey) {
        return tileContainers.get(xKey,yKey);
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
