import processing.core.PApplet;
import processing.core.PVector;

public class MainApp extends PApplet {

    public static void main(String[] args) {
        PApplet.main("MainApp", args);
    }

    Graph g;

    public void settings() {
        size(800,800);
    }
    public void setup() {
        background(0);
        g = new Graph(this, new PVector(800,800),50);
    }
    public void draw() {
        g.displayGrid();
    }

}
