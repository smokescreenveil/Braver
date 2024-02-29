import java.awt.*;
import java.awt.image.BufferedImage;

public class MainWindow {
    private Frame frame;

    public void createAndShowWindow() {
        // Create a new frame
        frame = new Frame("Main Project Window");

        // Set the size of the frame
        frame.setSize(800, 800);

        // Make the frame visible
        frame.setVisible(true);
    }

    public Graphics2D getGraphics() {
        // Ensure that the frame is initialized before accessing its graphics
        if (frame != null) {
            // Get the graphics context of the frame's content pane
            return (Graphics2D) frame.getGraphics();
        } else {
            // Handle the case when frame is null (optional)
            throw new IllegalStateException("Frame is not initialized");
        }

    }
}