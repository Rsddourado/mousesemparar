import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseMover {

    public static void main(String[] args) {
        // Cria um frame só pra permitir fechar o programa
        JFrame frame = new JFrame("Mouse Mover Ativo");
        frame.setSize(200, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centraliza
        frame.setResizable(false);
        frame.add(new JLabel("Rodando no X Encerra ", SwingConstants.CENTER));
        frame.setVisible(true);

        // Inicia o movimento do mouse
        try {
            Robot robot = new Robot();
            while (frame.isDisplayable()) {
                Point p = MouseInfo.getPointerInfo().getLocation();
                robot.mouseMove(p.x + 1, p.y); // Move um pixel
                Thread.sleep(1000);
                robot.mouseMove(p.x, p.y); // Volta pro ponto original
                Thread.sleep(1000);
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa encerrado.");
    }
}
