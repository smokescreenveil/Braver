import java.awt.*;

public class Main {

    /**
     * Initialization process
     */
    public static void init() {
        ResourceManager resourceManager = new ResourceManager();
        resourceManager.loadImage();

    }
    public static void main(String[] args) {
        // Create a new instance of MainWindow
        MainWindow mainWindow = new MainWindow();

        // Call the method to create and display the window
        mainWindow.createAndShowWindow();

        // Initialize resources
        init();

        // Create an instance of CameraRenderer
        CameraRenderer cameraRenderer = new CameraRenderer(mainWindow);
        cameraRenderer.startRendering();

        //setInterval(gameLoop, GAME_SPEED)

    }



}