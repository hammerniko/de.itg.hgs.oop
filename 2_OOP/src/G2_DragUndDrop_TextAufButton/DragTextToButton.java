package G2_DragUndDrop_TextAufButton;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.TransferHandler;


public class DragTextToButton extends JFrame {

    JTextField field;
    JTextField field2;
    JButton button;

    public DragTextToButton() {

        setTitle("Simple Drag & Drop");

        setLayout(null);

        button = new JButton("Button");
        button.setBounds(200, 50, 90, 25);

        field = new JTextField("f1");
        field.setBounds(30, 50, 150, 25);

        field2 = new JTextField("f2");
        field2.setBounds(30, 80, 150, 25);

        
        add(button);
        add(field);
        add(field2);

        field.setDragEnabled(true);
        field2.setDragEnabled(true);
        field.setTransferHandler(new TransferHandler("text"));
        button.setTransferHandler(new TransferHandler("text"));
        field.setTransferHandler(new TransferHandler("text"));
        setSize(330, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DragTextToButton();
    }
}