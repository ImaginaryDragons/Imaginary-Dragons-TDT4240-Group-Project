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

import com.dragons.game.model.blocks.Block;
import com.dragons.game.model.factories.BlockFactory;
import com.dragons.game.model.factories.PowerUpFactory;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import com.dragons.game.model.blocks.BlockType;


import java.util.ArrayList;

public class GameMap {

    private Tiled tileRenderer;
    public Table<Integer, Integer, ArrayList<IObject>> tileContainers;
    private int[][] index;
    private int tileWidth, tileHeight,
            mapWidthInTiles, mapHeightInTiles,
            mapWidthInPixels, mapHeightInPixels;

    private TiledMap tiledMap;
    private OrthographicCamera camera;
    private TiledMapRenderer tiledMapRenderer;

    public GameMap(String mapName) {
        tiledMap = new TmxMapLoader().load(mapName); //"TileMapMobile.tmx"

        MapProperties properties = tiledMap.getProperties();
        tileWidth         = properties.get("tilewidth", Integer.class);
        tileHeight        = properties.get("tileheight", Integer.class);
        mapWidthInTiles   = properties.get("width", Integer.class);
        mapHeightInTiles  = properties.get("height", Integer.class);
        mapWidthInPixels  = mapWidthInTiles  * tileWidth;
        mapHeightInPixels = mapHeightInTiles * tileHeight;
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        //camera = new OrthographicCamera();
        //camera.setToOrtho(false,w,h);
        //camera.update();
        tileContainers = HashBasedTable.create();
        for(int x = 1; x <= mapWidthInTiles; x++) {
            for (int y = 1; y <= mapHeightInTiles; y++) {
                tileContainers.put(x, y, new ArrayList<IObject>());
            }
        }

    }

    public Vector2 pos2tile(Vector2 pos) { //brukes til å finne ut hvilken tile man er på basert på posisjonen
        int resX = (int) ((pos.x-pos.x % 32)/32);
        int resY = (int) ((pos.y-pos.y % 32)/32);
        return new Vector2(resX, resY);
            }

    public Vector2 tilePos(Vector2 tile) { //brukes for å finne starten av tilen, bildet som brukes
        return new Vector2((tile.x - 1)*32, (tile.y - 1)*32);
    }

    public void generateBlocks(BlockFactory blockFactory, PowerUpFactory powerUpFactory, int numberOfPowerups, String recipeFile) {
        String number = null;
        Vector2 tile = new Vector2(0, 0);
        for(int x = 1; x <= mapWidthInTiles; x++) {
            for (int y = 1; y <= mapHeightInTiles; y++) {
                //TODO: Les inn neste tall fra tekstfilen
                tile.x = x;
                tile.y = y;
                switch (number) {
                    case "0":
                        break;
                    case "1":
                        Block desblock = blockFactory.createBlock(tilePos(tile), BlockType.DESTRUCTIBLE, tileWidth, tileHeight);
                        tileContainers.get(x, y).add(desblock);
                    case "2":
                        Block wallblock = blockFactory.createBlock(tilePos(tile), BlockType.WALL, tileWidth, tileHeight);
                        tileContainers.get(x, y).add(wallblock);
                    case "3":
                        Block desPowerupBlock = blockFactory.createBlock(tilePos(tile), BlockType.DESTRUCTIBLE,  tileWidth, tileHeight);
                        //PowerUp powerup = powerUpFactory.createPowerUp(PowerUpType.INCREASESPEED); lager en random powerup
                        tileContainers.get(x, y).add(desPowerupBlock);
                        //tileContainers.get(x, y).add(powerup);
                }

            }

        }
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
