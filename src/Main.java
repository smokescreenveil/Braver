import java.awt.*;

public class Main {

    /**
     * Initialization process
     */
    function init () {
        initCanvas()
        loadImage()
    }

    public static void main(String[] args) {
        // Create a new instance of MainWindow
        MainWindow mainWindow = new MainWindow();

        // Call the method to create and display the window
        mainWindow.createAndShowWindow();

        // Create an instance of CameraRenderer
        CameraRenderer cameraRenderer = new CameraRenderer(mainWindow);
        cameraRenderer.startRendering();

        setInterval(gameLoop, GAME_SPEED)

    }



}