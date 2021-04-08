package com.dragons.game.model.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        for(int x = 1; x <= mapWidthInTiles; x++) {
            for (int y = 1; y <= mapHeightInTiles; y++) {
                tileContainers.put(x, y, new ArrayList<IObject>());
            }
        }

    }

    public Vector2 pos2tile(Vector2 pos) {
        //brukes til å finne ut hvilken tile man er på basert på posisjonen
        // TODO: change 32 to dynamic
        int resX = (int) ((pos.x-(pos.x % 32)) / 32);
        int resY = (int) ((pos.y-(pos.y % 32)) / 32);
        return new Vector2(resX, resY);
    }

    public Vector2 tilePos(Vector2 tile) {
        //brukes for å finne starten av tilen, bildet som brukes
        return new Vector2((tile.x - 1)*32, (tile.y - 1)*32);
    }

    public void generateBlocks(int numberOfPowerups, String recipeFile) throws IOException {
        Gdx.app.log("GameMap", "Generating blocks from recipe");
        String number = null;
        Vector2 tile = new Vector2(0, 0);

        //String recipeFile = "C:\\Users\\Bruker\\Desktop\\Progark\\Prosjekt\\android\\assets\\map.txt"; For testing
        Scanner scanner = new Scanner(new File("map.txt"));
        scanner.useDelimiter(" ");
        String nextChar;

        int x = 0;
        int y = mapHeightInTiles; // We start in the top left corner iterating through our recipe!
        // TODO: Check that the initial indexes are correct in case of placement mistake!!

        while(scanner.hasNext()) {
            tile.x = x;
            tile.y = y;
            x++;
            switch (scanner.next()) {
                case "0":
                    break;
                case "1":
                    IObject desblock = blockFactory.createBlock(tilePos(tile), BlockType.DESTRUCTIBLE, tileWidth, tileHeight);
                    tileContainers.get(x, y).add(desblock);
                    break;
                case "2":
                    IObject wallblock = blockFactory.createBlock(tilePos(tile), BlockType.WALL, tileWidth, tileHeight);
                    tileContainers.get(x, y).add(wallblock);
                    break;
                case "3":
                    IObject desPowerupBlock = blockFactory.createBlock(tilePos(tile), BlockType.DESTRUCTIBLE, tileWidth, tileHeight);
                    //IObject powerup = powerUpFactory.createPowerUp(PowerUpType.INCREASESPEED); lager en random powerup
                    tileContainers.get(x, y).add(desPowerupBlock);
                    //tileContainers.get(x, y).add(powerup);
                    break;
                case " ":
                    break;
                default:
                    // Basically when we reach the end of the file!
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
