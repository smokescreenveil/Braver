
    import javax.imageio.ImageIO;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;

    public class ResourceManager {
        private BufferedImage imgMap;
        private BufferedImage imgMonster;
        private BufferedImage imgPlayer;
        private BufferedImage imgBoss;

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
