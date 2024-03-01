import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DrawMainObject {
    private BufferedImage imgPlayer;
    private Graphics vCtx;
    private int frame;
    private int angle;
    private int CHARACTER_WIDTH; // Note: There seems to be a typo here, it should be "CHARACTER_WIDTH"
    private int CHARACTER_HEIGHT; // Note: There seems to be a typo here, it should be "CHARACTER_HEIGHT"
    private int VIRTUAL_WIDTH;
    private int VIRTUAL_HEIGHT;
    private int TILE_SIZE;

    public DrawMainObject(BufferedImage imgPlayer, Graphics vCtx, int CHARACTER_WIDTH, int CHARACTER_HEIGHT,
                          int VIRTUAL_WIDTH, int VIRTUAL_HEIGHT, int TILE_SIZE) {
        this.imgPlayer = imgPlayer;
        this.vCtx = vCtx;
        this.CHARACTER_WIDTH = CHARACTER_WIDTH;
        this.CHARACTER_HEIGHT = CHARACTER_HEIGHT;
        this.VIRTUAL_WIDTH = VIRTUAL_WIDTH;
        this.VIRTUAL_HEIGHT = VIRTUAL_HEIGHT;
        this.TILE_SIZE = TILE_SIZE;

        int ax = (frame >> 4 & 1) * CHARACTER_WIDTH; // Divide by 16 in bit shift operation and truncate a small number, omit division by &

    }

    }