package com.dragons.game.model.GameWorld;

import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.dragons.game.model.ISubject;
import com.dragons.game.utilities.Constants;
import com.dragons.game.view.modelViews.ModelView;

public class GameObject {

    // https://gamedev.stackexchange.com/questions/88455/how-can-i-attach-a-libgdx-actor-to-a-box2d-body

    private float PPM = Constants.PPM;
    private ISubject obj;
    private ModelView objView;
    private Body body;
    private World world;
    private Shape2D shape;

    public GameObject(ISubject obj, World world, boolean isStatic) {
        this.obj = obj;
        this.body = createBody(obj.getPosition(), obj.getShape(), isStatic);
        this.world = world;
    }

    public ISubject getObject() {
        return obj;
    }

    public Body getBody() {
        return body;
    }

    public void syncPosition() {
        Vector2 newPos = body.getPosition();
        obj.setPosition(newPos);
    }

    private void onContact() {
        // TODO: Do something with obj
    }

    // Create a body and a fixture for the object and place it in world!
    private Body createBody(Vector2 pos, Shape2D shape, boolean isStatic) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody; // TODO: Consider an approach where you account for all possibilities
        bodyDef.fixedRotation = true;
        // World units = meters
        // From world to screen -> Divide by Pixel Per Meter
        bodyDef.position.set(pos.x / PPM, pos.y / PPM);
        Body body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = (Shape)shape;
        float density = 1; // TODO: Find real density! We might not need to have different densities
        fixtureDef.density = density;

        // This is for the contactListener
        //body.createFixture(fixtureDef).setUserData(contactType);
        //shape.dispose();
        /**Note fra Eldar: Forstår noenlunde hva som er intensjonen her, men trenger hjelp til å
         * integrere det inn. Sånn jeg forstår det går det på hvordan vi ønsker å registrere kontakt
         * mellom objekter av ulik type (som definitivt er en utfordring). Kan være en god løsning
         * dette, så vi kan se på det.
         *
         * Alternativt er det mulig å bruke GameWorld / GameObject klassene ettersom de ligger
         * et lag over bodies og contactlistener og kan derfor brukes til å se over kontaktene som
         * blir gjort for hver iterasjon.*/
        return body;
    }

    private void dispose() {
        world.destroyBody(body);
    }
}
