package C_OOPPasswortPrueferBidirektional;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class GuiTest extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldVorname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTest frame = new GuiTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][][][][][][][][][][][]", "[][][][][][][][]"));
		
		JLabel lblName = new JLabel("Name:");
		contentPane.add(lblName, "cell 1 0,alignx trailing");
		
		textFieldName = new JTextField();
		contentPane.add(textFieldName, "cell 2 0,growx");
		textFieldName.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname:");
		contentPane.add(lblVorname, "cell 1 1,alignx trailing");
		
		textFieldVorname = new JTextField();
		contentPane.add(textFieldVorname, "cell 2 1,growx");
		textFieldVorname.setColumns(10);
		
		JLabel lblGeurtsdatum = new JLabel("Geurtsdatum");
		contentPane.add(lblGeurtsdatum, "cell 1 2,alignx trailing");
		
		MaskFormatter dateMask=null;
		try {
		    dateMask = new MaskFormatter("##/##/####");
		    dateMask.setPlaceholderCharacter('-');
		    dateMask.setValidCharacters("0123456789");}
		 catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JFormattedTextField formattedTextField = new JFormattedTextField(dateMask);
		formattedTextField.setHorizontalAlignment(JTextField.RIGHT);
		contentPane.add(formattedTextField, "cell 2 2,growx");
		
		JButton btnOk = new JButton("Ok");
		contentPane.add(btnOk, "cell 12 7");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		contentPane.add(btnAbbrechen, "cell 13 7");
	}

}
