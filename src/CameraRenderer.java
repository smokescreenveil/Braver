import java.awt.*;
import java.awt.image.BufferedImage;

public class CameraRenderer {
    private MainWindow mainWindow;
    private Thread renderingThread;
    private boolean isRendering;
    private MapDraw mapDraw; // New instance of MapDraw

    private int cameraX;
    private int cameraY;

    private int mainObjX; // mainObj's X position
    private int mainObjY; // mainObj's Y position

    BufferedImage imgPlayer; // Declare imgPlayer once

    Graphics2D graphics2D;

    public CameraRenderer(MainWindow mainWindow, int mainObjX, int mainObjY) {
        this.mainWindow = mainWindow;
        this.mapDraw = new MapDraw(); // Initialize MapDraw
        this.cameraX = 0; // Initial camera position
        this.cameraY = 0;
        this.mainObjX = mainObjX;
        this.mainObjY = mainObjY;

        // Initialize graphics2D after mainWindow is initialized
        graphics2D = mainWindow.getGraphics();
    }

    int CHARACTER_WIDTH = 16; // Example value, adjust as needed
    int CHARACTER_HEIGHT = 16; // Example value, adjust as needed
    int VIRTUAL_WIDTH = 800; // Example value, adjust as needed
    int VIRTUAL_HEIGHT = 600; // Example value, adjust as needed
    int TILE_SIZE = 16; // Example value, adjust as needed


    private DrawMainObject drawMainObject;


    public CameraRenderer(MainWindow mainWindow, int mainObjX, int mainObjY, boolean isSecondConstructor) {
        this.mainWindow = mainWindow;
        this.mapDraw = new MapDraw(); // Initialize MapDraw
        this.cameraX = 0; // Initial camera position
        this.cameraY = 0;
        this.mainObjX = mainObjX;
        this.mainObjY = mainObjY;

    }


    public void moveCamera(int deltaX, int deltaY) {
        // Move the camera by the specified amount
        cameraX += deltaX;
        cameraY += deltaY;
    }


    public void startRendering() {
        if (renderingThread == null || !isRendering) {
            isRendering = true;
            renderingThread = new Thread(this::renderLoop);
            renderingThread.start();
        }
    }

    public void stopRendering() {
        isRendering = false;
        try {
            renderingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void renderLoop() {
        while (isRendering) {
            // Get the graphics context of the main window
            Graphics2D g = mainWindow.getGraphics();

            // Render the map
            renderMapTwo(g);

            this.imgPlayer = ResourceManager.getInstance().getImgPlayer(); // Initialize imgPlayer
            Graphics2D graphics2D = mainWindow.getGraphics();
            // Render the main mainObj object
            // Initialize DrawMainObject with necessary arguments
            this.drawMainObject = new DrawMainObject(imgPlayer, graphics2D, CHARACTER_WIDTH, CHARACTER_HEIGHT, VIRTUAL_WIDTH, VIRTUAL_HEIGHT, TILE_SIZE);

            // Dispose the graphics context to release resources
            g.dispose();

            // Sleep for a short time to control the rendering speed
            try {
                Thread.sleep(100); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void renderMapTwo(Graphics2D g) {
        // Get the image of the map from the resource manager
        BufferedImage imgMap = ResourceManager.getInstance().getImgMap();

        // Call the renderMap method of MapDraw to render the map
        mapDraw.renderMapOne(g, imgMap, mainObjX, mainObjY, cameraX, cameraY);


        // Get necessary resources and values

    }

}
