import java.awt.*;

public class Main {
    /**
     * Initialization process
     */
    public static void init(){
        ResourceManager resourceManager = new ResourceManager();
        resourceManager.loadImage();
    }
    //
    public static void main(String[] args) {
        // Create a new instance of MainWindow
        MainWindow mainWindow = new MainWindow();
        //Initialize resources
        init();
        // Call the method to create and display the window
        mainWindow.createAndShowWindow();
        // Example mainObj position
        int mainObjX = 4;
        int mainObjY = 4;
        // Initialize graphics2D after mainWindow is initialized
        graphics2D = mainWindow.getGraphics();
        GameLoop gameLoop = new GameLoop();
        gameLoop.start();


    }



}