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


        // Example mainObj position
        int mainObjX = 3;
        int mainObjY = 3;


        // Create an instance of CameraRenderer
        CameraRenderer cameraRenderer = new CameraRenderer(mainWindow, mainObjX, mainObjY);
        cameraRenderer.startRendering();



        //setInterval(gameLoop, GAME_SPEED)

    }



}