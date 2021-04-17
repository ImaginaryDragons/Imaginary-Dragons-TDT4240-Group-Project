package com.dragons.game.utilities;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.physics.box2d.World;

public class TiledObjectUtil {
    public static void parseTiledObjectLayer(World world, MapObjects objects){
        for(MapObject object : objects){
            if(object instanceof PolylineMapObject){
                
            }
        }
    }
}
