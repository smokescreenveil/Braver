import java.awt.*;
import java.awt.image.BufferedImage;

public class MapDraw {
    private static final int TILE_SIZE = 32; // Size of each tile
    private static final int SCREEN_WIDTH = 10; // Number of tiles to draw horizontally
    private static final int SCREEN_HEIGHT = 10; // Number of tiles to draw vertically
    private static final int VIRTUAL_WIDTH = SCREEN_WIDTH * TILE_SIZE; // Width of the virtual screen
    private static final int VIRTUAL_HEIGHT = SCREEN_HEIGHT * TILE_SIZE; // Height of the virtual screen
    private static final int MAP_WIDTH = 20; // Width of the map in tiles
    private static final int MAP_HEIGHT = 20; // Height of the map in tiles
    private static final int TILE_COLUMN = 4; // Number of columns in the tileset

    // Sample map data
    private static final int[] MAP = {
            /* Sample map data here */
    };

    // Sample player coordinates
    private int playerX;
    private int playerY;

    public void drawMap(Graphics2D g, BufferedImage imgMap) {
        // Player tile coordinates
        int mx = playerX / TILE_SIZE;
        int my = playerY / TILE_SIZE;

        for (int dy = -SCREEN_HEIGHT; dy <= SCREEN_HEIGHT; dy++) {
            int y = dy + SCREEN_HEIGHT;
            int ty = my + dy; // tile coordinates
            int py = (ty + MAP_HEIGHT) % MAP_HEIGHT; // Tile coordinates after loop

            for (int dx = -SCREEN_WIDTH; dx <= SCREEN_WIDTH; dx++) {
                int x = dx + SCREEN_WIDTH;
                int tx = mx + dx; // tile coordinates
                int px = (tx + MAP_WIDTH) % MAP_WIDTH; // Tile coordinates after loop

                drawTile(g,
                        tx * TILE_SIZE + VIRTUAL_WIDTH / 2 - playerX,
                        ty * TILE_SIZE + VIRTUAL_HEIGHT / 2 - playerY,
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
