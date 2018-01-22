import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField display;
	private String temp1, temp2, sAnswer;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero, add, multiply, divide, subtract, equals,
			clear, negative, percent, decimal, extend, Sin, cos, tan, back, square, squareRoot;
	private double answer = 0.0;
	public boolean equalsClicked = false, opChosen = false;
	String operation = " ";

	public GUI() {
		super("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Font font = new Font("Arial", Font.BOLD, 24);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.foreground"));
		panel.setForeground(UIManager.getColor("Button.darkShadow"));
		contentPane.add(panel, BorderLayout.CENTER);

		panel.setLayout(null);

		extend = new JButton("Extend");
		extend.setBounds(221, 7, 70, 29);
		panel.add(extend);

		back = new JButton("Back");
		back.setBounds(221, 7, 70, 29);
		back.setVisible(false);
		panel.add(back);

		display = new JTextField("0");
		display.setBounds(19, 7, 272, 64);
		display.setFont(font);
		panel.add(display);
		display.setColumns(10);

		Numbers n = new Numbers();
		Calc c = new Calc();

		seven = new JButton("7");
		seven.setBounds(19, 129, 59, 42);
		panel.add(seven);

		eight = new JButton("8");
		eight.setBounds(90, 129, 59, 42);
		panel.add(eight);

		nine = new JButton("9");
		nine.setBounds(161, 129, 59, 42);
		panel.add(nine);

		divide = new JButton("/");
		divide.setBounds(232, 75, 59, 42);
		panel.add(divide);

		one = new JButton("1");
		one.setBounds(20, 237, 59, 42);
		panel.add(one);

		four = new JButton("4");
		four.setBounds(20, 183, 59, 42);
		panel.add(four);

		five = new JButton("5");
		five.setBounds(90, 183, 59, 42);
		panel.add(five);

		six = new JButton("6");
		six.setBounds(161, 183, 59, 42);
		panel.add(six);

		multiply = new JButton("x");
		multiply.setBounds(232, 129, 59, 42);
		panel.add(multiply);

		two = new JButton("2");
		two.setBounds(90, 237, 59, 42);
		panel.add(two);

		three = new JButton("3");
		three.setBounds(161, 237, 59, 42);
		panel.add(three);

		subtract = new JButton("-");
		subtract.setBounds(232, 183, 59, 42);
		panel.add(subtract);

		zero = new JButton("0");
		zero.setBounds(19, 291, 59, 42);
		panel.add(zero);

		decimal = new JButton(".");
		decimal.setBounds(90, 291, 59, 42);
		panel.add(decimal);

		equals = new JButton("=");
		equals.setBounds(161, 291, 130, 42);
		panel.add(equals);

		add = new JButton("+");
		add.setBounds(232, 237, 59, 42);
		panel.add(add);

		clear = new JButton("CE");
		clear.setBounds(20, 75, 59, 42);
		panel.add(clear);

		negative = new JButton("+/-");
		negative.setBounds(90, 75, 59, 42);
		panel.add(negative);

		percent = new JButton("%");
		percent.setBounds(161, 75, 59, 42);
		panel.add(percent);

		Sin = new JButton("sin");
		Sin.setBounds(303, 75, 59, 42);
		panel.add(Sin);

		cos = new JButton("cos");
		cos.setBounds(303, 129, 59, 42);
		panel.add(cos);

		back.addActionListener(c);
		tan = new JButton("tan");
		tan.setBounds(303, 183, 59, 42);
		panel.add(tan);

		square = new JButton("x^2");
		square.setBounds(303, 237, 59, 42);
		panel.add(square);

		squareRoot = new JButton("√");
		squareRoot.setBounds(303, 291, 59, 42);
		panel.add(squareRoot);
		one.addActionListener(n);
		two.addActionListener(n);
		three.addActionListener(n);
		four.addActionListener(n);
		five.addActionListener(n);
		six.addActionListener(n);
		seven.addActionListener(n);
		eight.addActionListener(n);
		nine.addActionListener(n);
		zero.addActionListener(n);
		add.addActionListener(c);
		subtract.addActionListener(c);
		multiply.addActionListener(c);
		divide.addActionListener(c);
		clear.addActionListener(c);
		negative.addActionListener(n);
		percent.addActionListener(c);
		equals.addActionListener(c);
		decimal.addActionListener(n);
		extend.addActionListener(c);
		Sin.addActionListener(c);
		cos.addActionListener(c);
		tan.addActionListener(c);
		square.addActionListener(c);
		squareRoot.addActionListener(c);

	}

	private class Numbers implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent event) {
			JButton src = (JButton) event.getSource();

			if (src.equals(negative)) {

				if (opChosen == false) {
					if (temp1 == null) {
						temp1 = "-";

					} else if (temp1 != null && temp1.startsWith("-")) {
						temp1 = temp1.substring(1);
					} else {
						temp1 = "-" + temp1;
					}
				} else {
					if (temp2 == null) {
						temp2 = "-";

					} else if (temp2 != null && temp2.startsWith("-")) {
						temp2 = temp2.substring(1);
					} else {
						temp2 = "-" + temp2;
					}
				}

			}

			if (src.equals(decimal)) {
				if (opChosen == false) {
					if (temp1 == null) {
						temp1 = "0.";

					} else if (temp1 != null) {
						if (temp1.contains(".")) {
							display.setText(temp1);
						} else
							temp1 += decimal.getLabel();
					}
				} else if (temp2 != null) {
					if (temp2.contains(".")) {
						display.setText(temp2);
					} else
						temp2 += decimal.getLabel();
				}

			}

			JButton[] array = { one, two, three, four, five, six, seven, eight, nine, zero };

			for (JButton x : array) {
				if (src.equals(x)) {
					if (opChosen == false) {
						if (temp1 == null) {
							temp1 = x.getLabel();

						} else {
							temp1 += x.getLabel();
						}
					} else {
						if (temp2 == null) {
							temp2 = x.getLabel();

						} else {
							temp2 += x.getLabel();
						}

					}

				}

				if (equalsClicked == false) {
					if (opChosen == false) {
						display.setText(temp1);
					} else {
						display.setText(temp2);
					}

				}
			}

		}

	}

	// ADD COMMAS FOR NUMBERS
	// ADD MORE OPERATIONS
	// ADD CONTINIOUS CALCULATIONS
	// CREATE AN ARRAY FOR SIN COS TAN
	private class Calc implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton src = (JButton) event.getSource();

			if (src.equals(extend)) {
				setBounds(100, 100, 512, 380);
				extend.setVisible(false);
				back.setVisible(true);

			}

			if (src.equals(back)) {
				setBounds(100, 100, 315, 380);
				extend.setVisible(true);
				back.setVisible(false);
			}

			double N1, N2;

			if (src.equals(percent)) {
				if (temp1 != null) {
					N1 = Double.parseDouble(temp1);

					answer = N1 * .01;

					sAnswer = Double.toString(answer);
					display.setText(sAnswer);
				}
			}

			if (src.equals(squareRoot)) {
				if (temp1 == null) {
					display.setText("0");
				} else {
					N1 = Double.parseDouble(temp1);
					answer = Math.sqrt(N1);
					sAnswer = Double.toString(answer);
					sAnswer = String.format("%.2f", answer);
					display.setText(sAnswer);
				}
			}
			if (src.equals(square)) {
				if (temp1 == null) {
					display.setText("0");
				} else {
					N1 = Double.parseDouble(temp1);
					answer = Math.pow(N1, 2);
					sAnswer = Double.toString(answer);
					sAnswer = String.format("%.2f", answer);
					display.setText(sAnswer);
				}

			}

			if (src.equals(clear)) {
				temp1 = null;
				temp2 = null;
				equalsClicked = false;
				opChosen = false;
				operation = " ";
				display.setText(null);
				sAnswer = null;

			}

			if (src.equals(Sin)) {

				if (temp1 == null) {
					display.setText("0");

				} else {
					N1 = Double.parseDouble(temp1);
					answer = Math.sin(N1);
					sAnswer = Double.toString(answer);

					sAnswer = String.format("%.5f", answer);
					display.setText(sAnswer);

				}
			}
			if (src.equals(cos)) {

				if (temp1 == null) {
					display.setText("0");

				} else {
					N1 = Double.parseDouble(temp1);
					answer = Math.cos(N1);
					sAnswer = Double.toString(answer);

					sAnswer = String.format("%.5f", answer);
					display.setText(sAnswer);

				}
			}
			if (src.equals(tan)) {

				if (temp1 == null) {
					display.setText("0");

				} else {
					N1 = Double.parseDouble(temp1);
					answer = Math.tan(N1);
					sAnswer = Double.toString(answer);

					sAnswer = String.format("%.5f", answer);
					display.setText(sAnswer);

				}
			}

			JButton[] opArray = { add, subtract, multiply, divide };

			for (JButton x : opArray) {
				if (src.equals(x)) {
					if (temp1 == null) {
						display.setText("0");

					} else if (temp1 != null && temp2 == null) {
						opChosen = true;
						operation = x.getLabel();
					} else if (temp1 != null && temp2 != null) {
						display.setText("0");
					}

				}
				if (src.equals(equals)) {
					if (temp1 != null && temp2 != null) {
						N1 = Double.parseDouble(temp1);
						N2 = Double.parseDouble(temp2);

						switch (operation) {
						case "+":
							answer = N1 + N2;
							break;
						case "-":
							answer = N1 - N2;
							break;
						case "x":
							answer = N1 * N2;
							break;
						case "/":
							answer = N1 / N2;
							break;
						}

						if (temp1.contains(".") || temp2.contains(".")) {
							sAnswer = Double.toString(answer);
							display.setText(sAnswer);
						} else {
							answer = (int) answer;
							sAnswer = Integer.toString((int) answer);
							display.setText(sAnswer);
						}

						if (operation == "/" && N2 == 0.0) {
							display.setText("Error");

						}

					}
				}

			}
		}

	}

}
