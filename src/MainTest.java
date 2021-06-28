
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainTest extends JFrame{

    private JButton FbBtn,GmBtn,InsBtn;
    FlowLayout layout = new FlowLayout();
    public MainTest() {start();}

    public void start() {;
        setTitle("Automation Scripts GUI");
        setSize(new Dimension(250, 300));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(layout);

        FbBtn = new JButton("Run FaceBook test");
        FbBtn.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    FacebookLoginTest.test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        GmBtn =  new JButton("Run Gmail test");
        GmBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    GmailLoginTest.test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        InsBtn = new JButton("Run Instagram test");
        InsBtn.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    InstagramLoginTest.test();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        add(FbBtn);
        add(InsBtn);
        add(GmBtn);
    }

    public static void main(String[] values){
        EventQueue.invokeLater(()->new MainTest().setVisible(true));
    }
}
