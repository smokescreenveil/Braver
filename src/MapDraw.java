import java.awt.*;
import java.awt.image.BufferedImage;

public class MapDraw {
    private static final int TILE_SIZE = 16; // Size of each tile
    private static final int SCREEN_WIDTH = 10; // Number of tiles to draw horizontally
    private static final int SCREEN_HEIGHT = 10; // Number of tiles to draw vertically
    private static final int VIRTUAL_WIDTH = SCREEN_WIDTH * TILE_SIZE; // Width of the virtual screen
    private static final int VIRTUAL_HEIGHT = SCREEN_HEIGHT * TILE_SIZE; // Height of the virtual screen
    private static final int MAP_WIDTH = 20; // Width of the map in tiles
    private static final int MAP_HEIGHT = 20; // Height of the map in tiles
    private static final int TILE_COLUMN = 4; // Number of columns in the tileset

    private int mainObjX; // Example value, adjust as needed
    private int mainObjY; // Example value, adjust as needed
    private BufferedImage imgMap; // Example BufferedImage for your map image
    private Graphics vCtx; // Example Graphics context for drawing

    // Sample map data
    private static final int[] MAP = {
            /* Sample map data here */
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
            3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
    };

    // Sample mainObj coordinates


    public void renderMapOne(Graphics2D g, BufferedImage imgMap, int mainObjX, int mainObjY, int cameraX, int cameraY) {
        // Adjust rendering based on the camera position
        int offsetX = cameraX % TILE_SIZE;
        int offsetY = cameraY % TILE_SIZE;

        // Calculate the starting tile index to render
        int startTileX = cameraX / TILE_SIZE;
        int startTileY = cameraY / TILE_SIZE;

        // Calculate the ending tile index to render
        int endTileX = startTileX + SCREEN_WIDTH + 1; // Add 1 to ensure the last tile is rendered
        int endTileY = startTileY + SCREEN_HEIGHT + 1; // Add 1 to ensure the last tile is rendered

        // Loop through visible tiles and render them
        for (int y = startTileY; y < endTileY; y++) {
            for (int x = startTileX; x < endTileX; x++) {
                int tileIndex = (y % MAP_HEIGHT) * MAP_WIDTH + (x % MAP_WIDTH);
                int dx = (x - startTileX) * TILE_SIZE - offsetX;
                int dy = (y - startTileY) * TILE_SIZE - offsetY;
                drawTile(g, dx, dy, MAP[tileIndex], imgMap);
            }
        }
    }


    public void drawMap(Graphics2D g, BufferedImage imgMap) {
        // mainObj tile coordinates
        int mx = mainObjX / TILE_SIZE;
        int my = mainObjY / TILE_SIZE;

        for (int dy = -SCREEN_HEIGHT; dy <= SCREEN_HEIGHT; dy++) {
            int y = dy + SCREEN_HEIGHT;
            int ty = my + dy; // tile coordinates
            int py = (ty + MAP_HEIGHT) % MAP_HEIGHT; // Tile coordinates after loop

            for (int dx = -SCREEN_WIDTH; dx <= SCREEN_WIDTH; dx++) {
                int x = dx + SCREEN_WIDTH;
                int tx = mx + dx; // tile coordinates
                int px = (tx + MAP_WIDTH) % MAP_WIDTH; // Tile coordinates after loop

                drawTile(g,
                        tx * TILE_SIZE + VIRTUAL_WIDTH / 2 - mainObjX,
                        ty * TILE_SIZE + VIRTUAL_HEIGHT / 2 - mainObjY,
                        MAP[py * MAP_WIDTH + px], imgMap);
            }
        }
    }

    /**
     * Draw a tile at the specified location.
     */
    private void drawTile(Graphics2D g, int x, int y, int index, BufferedImage imgMap) {
        int ix = (index % TILE_COLUMN) * TILE_SIZE;
        int iy = (index / TILE_COLUMN) * TILE_SIZE;
        // Draw the tile using the tileset image
        g.drawImage(imgMap, x, y, x + TILE_SIZE, y + TILE_SIZE, ix, iy, ix + TILE_SIZE, iy + TILE_SIZE, null);
    }






}
