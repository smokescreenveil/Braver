import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResourceManager {
    public static ResourceManager instance;

    private BufferedImage imgMap;
    private BufferedImage imgMonster;
    private BufferedImage imgPlayer;
    private BufferedImage imgBoss;

    public ResourceManager() {
        // Private constructor to prevent instantiation outside this class
    }

    public static ResourceManager getInstance() {
        if (instance == null) {
            instance = new ResourceManager();
            instance.loadImage(); // Load images when the instance is first created
        }
        return instance;
    }

    public void loadImage() {
        try {
            imgMap = ImageIO.read(new File("images/map.png"));
            imgMonster = ImageIO.read(new File("images/monster.png"));
            imgPlayer = ImageIO.read(new File("images/player.png"));
            imgBoss = ImageIO.read(new File("images/boss.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters for the loaded images
    public BufferedImage getImgMap() {
        return imgMap;
    }

    public BufferedImage getImgMonster() {
        return imgMonster;
    }

    public BufferedImage getImgPlayer() {
        return imgPlayer;
    }

    public BufferedImage getImgBoss() {
        return imgBoss;
    }
}
