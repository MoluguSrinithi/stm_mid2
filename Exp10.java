import java.util.*;
import java.io.File;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Exp10{
    public static void main(String[] args) throws Exception{
        Runtime.getRuntime().exec("calc.exe");
        Thread.sleep(2000);

        Robot robot = new Robot();
        robot.setAutoDelay(200);

        typeKey(robot, KeyEvent.VK_7);
        typeKey(robot, KeyEvent.VK_ADD);
        typeKey(robot, KeyEvent.VK_5);
        typeKey(robot, KeyEvent.VK_EQUALS);

        Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image = robot.createScreenCapture(screen);
        ImageIO.write(image,"png", new File("calc_capture.png"));
        System.out.println("Test executed: 7+5 = 12");
        System.out.println("ss saved");

    }

    public static void typeKey(Robot robot, int key){
        robot.keyPress(key);
        robot.keyRelease(key);
    }
}