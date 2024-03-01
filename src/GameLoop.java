public class GameLoop implements Runnable {
    private static final int TARGET_FPS = 60;
    private static final long OPTIMAL_TIME = 1000000000 / TARGET_FPS; // Nanoseconds per frame

    private boolean running = false;

    public void start() {
        running = true;
        new Thread(this::run).start();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        long lastLoopTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            long updateTime = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateTime / ((double) OPTIMAL_TIME);

            // Your game logic update
            update(delta);

            // Render the game
            render();

            // Cap the frame rate
            long sleepTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void update(double delta) {
        // Update game logic using delta time
        // Example: position += velocity * delta;
    }

    private void render() {
        // Create an instance of CameraRenderer
        CameraRenderer cameraRenderer = new CameraRenderer(mainWindow, mainObjX, mainObjY);
        CameraRenderer.startRendering();

    }
}