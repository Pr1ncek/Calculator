import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ex1212 extends JFrame {

	private JPanel contentPane;
	private JTextField fText;
	private JTextField cText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex1212 frame = new Ex1212();
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
	public Ex1212() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Font font = new Font("Arial", Font.BOLD, 20);
		
		JButton btnNewButton = new JButton("CONVERT");
		

		
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (fText.getText().isEmpty()) {
					double C = Double.parseDouble(cText.getText());
					double F = ((C * 9 / 5.0) + 32);
					fText.setText(String.format("%.2f", F));
					btnNewButton.setVisible(false);
					
				} else if (cText.getText().isEmpty()) {
					double F = Double.parseDouble(fText.getText());
					double C = ((F - 32) * 5) / 9;
					cText.setText(String.format("%.2f", C));
					btnNewButton.setVisible(false);
					
					
				}
				
			}
			
			
		});
		
		
		btnNewButton.setBounds(77, 155, 285, 72);
		btnNewButton.setFont(font);
		contentPane.add(btnNewButton);

		fText = new JTextField();

		fText.setBounds(169, 45, 183, 43);
		contentPane.add(fText);
		fText.setColumns(10);

		JLabel lblFahrenheit = new JLabel("Fahrenheit");
		lblFahrenheit.setFont(new Font("Arial", Font.BOLD, 15));
		lblFahrenheit.setForeground(Color.WHITE);
		lblFahrenheit.setBackground(Color.BLACK);
		lblFahrenheit.setBounds(77, 58, 109, 28);
		contentPane.add(lblFahrenheit);

		JLabel lblCelsius = new JLabel("Celsius");
		lblCelsius.setFont(new Font("Arial", Font.BOLD, 15));
		lblCelsius.setForeground(Color.WHITE);
		lblCelsius.setBounds(77, 113, 61, 16);
		contentPane.add(lblCelsius);

		cText = new JTextField();

		cText.setColumns(10);
		cText.setBounds(169, 100, 183, 43);
		contentPane.add(cText);
		
		JButton Reset = new JButton("RESET");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fText.setText("");
				cText.setText("");
				btnNewButton.setVisible(true);
				
				
			}
		});
		Reset.setBounds(77, 155, 285, 72);
		Reset.setFont(font);
		contentPane.add(Reset);
		
		
	}
}
