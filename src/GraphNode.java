import processing.core.PApplet;
import processing.core.PVector;

public class GraphNode {
    PApplet app;

    boolean walkable;
    PVector position;
    GraphNode parent;


    GraphNode(PApplet _app, boolean _walkable, PVector _position) {
        app = _app;
        walkable = _walkable;
        position = _position;
    }
}
