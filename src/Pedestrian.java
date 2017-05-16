
/**
 * Created by Bryn Murrell on 4/27/2017.
 */

import processing.core.PApplet;
import processing.core.PVector;

//import java.util.ArrayList;

//import static java.lang.Float.POSITIVE_INFINITY;

class Pedestrian {
    private PApplet app;
    private PVector acceleration;
    private PVector velocity;
    private PVector position;
    private int r;
    private float maxspeed;
    private float maxforce;
    private float health;

    Pedestrian(PApplet _app, float _x, float _y, float[] _dna) {
        app = _app;
        acceleration = new PVector(0,0);
        velocity =  new PVector(0,0);
        position = new PVector(_x, _y);
        r = 4;
        maxspeed = 5f;
        maxforce = 0.5f;

    }

    void update() {
        //health -= 0.005f;
        velocity.add(acceleration);
        velocity.limit(maxspeed);
        position.add(velocity);
        acceleration.mult(0);
    }

    private void applyForce(PVector _force) {
        acceleration.add(_force);
    }

    void behaviors() {

        //pseudocode
        //PVector steer();
        //steer.add(navigateToNextNode());
        //steer.add(avoidNeighbours());
        //steer.add(alignwithNeighbours());
        //steer.limit(maxForce);

    }

    PVector navigateToNextNode() {
        //pseudocode
        //find next node
        //PVector tmp = new PVector;
        //tmp = seek(nextNode);
        //return tmp
        return new PVector();
    }

    private PVector seek (PVector _target) {
            PVector desired = PVector.sub(_target, position);
            desired.setMag(maxspeed);

            //steering = desired - velocity
            PVector steer = PVector.sub(desired, velocity);
            steer.limit(maxforce);

            return steer;
    }

    void display() {

        float angle = velocity.heading() + 3.14159f / 2;
        app.pushMatrix();



        app.translate(this.position.x, this.position.y);
        //translate(50,50);
        app.rotate(angle);

        //int gr = app.color(0,255,0);
        int rd = app.color(255,0,0);
        //int col = app.lerpColor(rd,gr,health);
        app.fill(rd);
        app.stroke(rd);
        app.strokeWeight(1);
        app.beginShape();
        app.vertex(0, -this.r * 2);
        app.vertex(-this.r, this.r * 2);
        app. vertex(this.r, this.r * 2);
        app.endShape(app.CLOSE);
        app.popMatrix();

    }
    void display2() {
        app.fill(255);
        app.stroke(255);
        app.strokeWeight(0);
        app.ellipse(position.x,position.y,1,1);
    }

    //todo rework boundaries so it constrains to path region
    void boundaries() {
        if (position.x < 0) {
            position.x = app.width + position.x;
        }
        if (position.x > app.width) {
            position.x = 0 + (app.width - position.x);
        }
        if (position.y < 0) {
            position.y = app.height + position.y;
        }
        if (position.y > app.height) {
            position.y = 0 + (app.height - position.y);
        }

    }


}
