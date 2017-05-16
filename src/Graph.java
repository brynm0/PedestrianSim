import processing.core.PApplet;
import processing.core.PVector;
import static processing.core.PApplet.floor;
import static processing.core.PConstants.RADIUS;

import java.util.ArrayList;


class Graph {
    private PApplet app;

    private GraphNode[][] grid;
    private PVector gridWorldSize;
    private float nodeRadius;

//    ArrayList<GraphNode> openSet;
//    ArrayList<GraphNode> closedSet;

    private float nodeDiameter;
    private int gridSizeX, gridSizeY;

    Graph(PApplet _app, PVector _gridWorldSize, float _nodeRadius) {
        app = _app;
        gridWorldSize = _gridWorldSize;
        nodeRadius = _nodeRadius;
        init();
    }

    private void init() {
        nodeDiameter = nodeRadius * 2;
        gridSizeX = floor(gridWorldSize.x / nodeDiameter);
        gridSizeY = floor(gridWorldSize.y / nodeDiameter);
        createGrid();
    }

    private void createGrid() {
        grid = new GraphNode[gridSizeX][gridSizeY];

        for (int i = 0; i < gridSizeX; i++) {
        float x = i * nodeDiameter + nodeRadius;
            for (int j = 0; j < gridSizeY; j++) {
                float y = j * nodeDiameter + nodeRadius;
                PVector worldPoint = new PVector(x, y);
                grid[i][j] = new GraphNode(app, true, worldPoint);
            }
        }

    }

    void displayGrid() {
        if (grid != null) {
            for (int i = 0; i < gridSizeX; i++) {
                for (int j = 0; j < gridSizeY; j++) {
                    app.strokeWeight(2);
                    app.stroke(255);
                    app.rectMode(RADIUS);
                    app.noFill();
                    app.rect(grid[i][j].position.x, grid[i][j].position.y, nodeRadius, nodeRadius);
                }
            }
        }
    }


}
