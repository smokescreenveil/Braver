import java.awt.*;
import java.awt.image.BufferedImage;

public class CameraRenderer {
    private MainWindow mainWindow;
    private Thread renderingThread;
    private boolean isRendering;
    private MapDraw mapDrawer; // New instance of MapDraw

    public CameraRenderer(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.mapDrawer = new MapDraw(); // Initialize MapDraw
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
            renderMap(g);

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

    private void renderMap(Graphics2D g) {
        // Get the image of the map from the resource manager
        BufferedImage imgMap = ResourceManager.getInstance().getImgMap();

        // Call the drawMap method of MapDraw to render the map
        mapDrawer.drawMap(g, imgMap);
    }
}
