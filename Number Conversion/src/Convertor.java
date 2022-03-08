import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class Convertor extends JFrame  {


	private JPanel contentPane;
	private JTextField input;
	private JTextField result;
	private String [] option={"Decimal","Binary","Hexadecimal"};
	private static final String HEX="Hexadecimal";
	private static final String DEC="Decimal";
	private static final String BIN="Binary";
	private final ArrayList<String> Valid_Hex = new ArrayList<String>();
	private final ArrayList<String> Valid_Dec = new ArrayList<String>();
	private final ArrayList<String> Valid_Bin = new ArrayList<String>();
	private boolean isHex;
	private boolean isDec;
	private boolean isBin;


	public static void main(String[] args) {

		Convertor frame = new Convertor();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	public Convertor() {
		setResizable(false);
		setBounds(new Rectangle(0, 0, 16, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 571, 665);
		setSize(500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JComboBox from = new JComboBox(option);
		from.setFocusable(false);
		from.setFont(new Font("Tahoma", Font.PLAIN, 16));

		sl_contentPane.putConstraint(SpringLayout.NORTH, from, 100, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, from, 80, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, from, 150, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, from, 230, SpringLayout.WEST, contentPane);
		contentPane.add(from);

		JComboBox to = new JComboBox(option);
		to.setFocusable(false);
		to.setDoubleBuffered(true);
		to.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sl_contentPane.putConstraint(SpringLayout.NORTH, to, 100, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, to, -230, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, to, 150, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, to, -80, SpringLayout.EAST, contentPane);
		contentPane.add(to);

		JLabel from_lb = new JLabel("From");

		sl_contentPane.putConstraint(SpringLayout.NORTH, from_lb, -30, SpringLayout.NORTH, from);
		from_lb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.WEST, from_lb, 0, SpringLayout.WEST, from);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, from_lb, 0, SpringLayout.NORTH, from);
		contentPane.add(from_lb);

		JLabel to_lb = new JLabel("To");
		sl_contentPane.putConstraint(SpringLayout.NORTH, to_lb, -30, SpringLayout.NORTH, to);
		to_lb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.WEST, to_lb, 0, SpringLayout.WEST, to);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, to_lb, 0, SpringLayout.NORTH, from);
		contentPane.add(to_lb);

		input = new JTextField();
		input.setBorder(new LineBorder(SystemColor.controlShadow, 1, true));
		input.setBackground(SystemColor.control);
		sl_contentPane.putConstraint(SpringLayout.NORTH, input, 100, SpringLayout.SOUTH, from);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, input, 150, SpringLayout.SOUTH, from);
		input.setFont(new Font("Tahoma", Font.PLAIN, 19));
		sl_contentPane.putConstraint(SpringLayout.WEST, input, 0, SpringLayout.WEST, from);
		sl_contentPane.putConstraint(SpringLayout.EAST, input, 0, SpringLayout.EAST, to);
		contentPane.add(input);
		input.setColumns(10);

		JLabel input_lb = new JLabel("Enter Number");
		input_lb.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, input_lb, -5, SpringLayout.NORTH, input);
		input_lb.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.NORTH, input_lb, -25, SpringLayout.NORTH, input);
		sl_contentPane.putConstraint(SpringLayout.WEST, input_lb, 0, SpringLayout.WEST, from);
		contentPane.add(input_lb);

		JButton convert = new JButton("Convert");
		convert.setBorderPainted(false);
		convert.setFocusable(false);
		convert.setFocusPainted(false);
		convert.setForeground(Color.WHITE);
		convert.setFont(new Font("Tahoma", Font.PLAIN, 17));
		convert.setBackground(new Color(102, 204, 51));
		sl_contentPane.putConstraint(SpringLayout.NORTH, convert, 10, SpringLayout.SOUTH, input);
		sl_contentPane.putConstraint(SpringLayout.WEST, convert, 0, SpringLayout.WEST, from);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, convert, 50, SpringLayout.SOUTH, input);
		sl_contentPane.putConstraint(SpringLayout.EAST, convert, 100, SpringLayout.WEST, input);
		contentPane.add(convert);

		JButton reset = new JButton("Reset");
		reset.setForeground(Color.WHITE);
		reset.setFont(new Font("Tahoma", Font.PLAIN, 17));
		reset.setBackground(new Color(255, 0, 51));
		reset.setBorderPainted(false);
		reset.setFocusable(false);
		reset.setFocusPainted(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, reset, 0, SpringLayout.NORTH, convert);
		sl_contentPane.putConstraint(SpringLayout.WEST, reset, -100, SpringLayout.EAST, input);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, reset, 0, SpringLayout.SOUTH, convert);
		sl_contentPane.putConstraint(SpringLayout.EAST, reset, 0, SpringLayout.EAST, to);
		contentPane.add(reset);

		JButton swap = new JButton("Swap");
		swap.setForeground(Color.WHITE);
		swap.setFont(new Font("Tahoma", Font.PLAIN, 17));
		swap.setBackground(new Color(153, 153, 153));
		swap.setBorderPainted(false);
		swap.setFocusable(false);
		swap.setFocusPainted(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, swap, 0, SpringLayout.NORTH, convert);
		sl_contentPane.putConstraint(SpringLayout.WEST, swap, 15, SpringLayout.EAST, convert);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, swap, 0, SpringLayout.SOUTH, convert);
		sl_contentPane.putConstraint(SpringLayout.EAST, swap, -15, SpringLayout.WEST, reset);
		contentPane.add(swap);

		result = new JTextField();
		result.setBorder(new LineBorder(SystemColor.controlShadow, 1, true));
		result.setBackground(SystemColor.control);
		result.setFocusTraversalPolicyProvider(true);
		result.setFocusCycleRoot(true);
		result.setFocusable(false);

		sl_contentPane.putConstraint(SpringLayout.NORTH, result, 110, SpringLayout.SOUTH, input);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, result, 160, SpringLayout.SOUTH, input);
		sl_contentPane.putConstraint(SpringLayout.EAST, result, 0, SpringLayout.EAST, input);
		sl_contentPane.putConstraint(SpringLayout.WEST, result, 0, SpringLayout.WEST, from);
		result.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(result);
		result.setColumns(10);

		JLabel result_lb = new JLabel("Output");
		result_lb.setBackground(UIManager.getColor("Button.background"));
		result_lb.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.WEST, result_lb, 0, SpringLayout.WEST, from);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, result_lb, -5, SpringLayout.NORTH, result);
		contentPane.add(result_lb);

		JLabel title_lb = new JLabel("Number Convertor");
		sl_contentPane.putConstraint(SpringLayout.NORTH, title_lb, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, title_lb, 150, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, title_lb, -150, SpringLayout.EAST, contentPane);
		title_lb.setFont(new Font("Tahoma", Font.BOLD, 19));
		contentPane.add(title_lb);

		for(int i=0 ; i<10 ; i++)
		{
			Valid_Hex.add(Integer.toString(i));
			Valid_Dec.add(Integer.toString(i));
		}
		Valid_Hex.add("A");
		Valid_Hex.add("B");
		Valid_Hex.add("C");
		Valid_Hex.add("D");
		Valid_Hex.add("E");
		Valid_Hex.add("F");
		Valid_Hex.add("a");
		Valid_Hex.add("b");
		Valid_Hex.add("c");
		Valid_Hex.add("d");
		Valid_Hex.add("e");
		Valid_Hex.add("f");


		convert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String con =input.getText();
				String sign="";

				if(con.equals(""))
				{

				}
				else if (con.charAt(0)=='-')
				{
					con=con.replaceFirst("-", "");
					sign ="-";
				}
				else if(con.charAt(0)=='+')
				{
					con=con.replaceFirst("\\+", "");
				}

				String  ans=calculate(from.getSelectedItem().toString(), to.getSelectedItem().toString(),con.toUpperCase());

				if(ans.equals("Invalid Input"))
					result.setText(ans);
				else
					result.setText(sign + ans);

			}
		});

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				input.setText("");
				result.setText("");
			}
		});

		swap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String y = (String) from.getSelectedItem();
				from.setSelectedItem(to.getSelectedItem());
				to.setSelectedItem(y);
			}
		});

	}


	private String calculate(String from, String to, String input)
	{	
		int result=0;
		String merge="";
		String ans="";
		isHex=true;
		isDec=true;
		isBin=true;

		// check input is valid or invalid for hex number
		for (int i=0 ; i<input.length() ; i++)
		{			
			if(Valid_Hex.contains(input.charAt(i)+"")==false)
			{
				isHex=false;
			}	
		}

		// check input is valid or invalid for decimal number
		for (int i=0 ; i<input.length() ; i++)
		{			
			if(Valid_Dec.contains(input.charAt(i)+"")==false)
			{
				isDec=false;
			}
		}

		// check input is valid or invalid for binary number
		for (int i=0 ; i<input.length() ; i++)
		{	
			if(input.charAt(i)!='1' && input.charAt(i)!='0' )
			{
				isBin=false;
			}
		}

		if(from.equals(DEC) && to.equals(BIN))
		{
			if(isDec==false)
				return "Invalid Input";

			int number=Integer.parseInt(input);
			while(number>=2)
			{
				int x = number%2;
				merge = Integer.toString(x) + merge;
				number = number/2;
			}
			ans = Integer.toString(number) + merge;
		}

		else if(from.equals(DEC) && to.equals(HEX))
		{
			if(isDec==false)
				return "Invalid Input";

			int number=Integer.parseInt(input);
			while(number>=16)
			{
				int x = number%16;
				merge = ToHex(x) + merge;
				number = number/16;
			}
			ans = ToHex(number) + merge;
		}

		else if(from.equals(BIN) && to.equals(DEC))
		{	
			if(isBin==false)
				return "Invalid Input";

			for (int i=0 ; i<input.length() ; i++)
			{
				result = (int) (result + ((int)Math.pow(2, i) * Integer.parseInt(input.charAt(input.length()-(1+i))+"")));					
			}		
			ans = Integer.toString(result);	
		}

		else if(from.equals(BIN) && to.equals(HEX))
		{
			if(isBin==false)
				return "Invalid Input";

			for (int i=0 ; i<input.length() ; i++)
			{
				result = (int) (result + ((int)Math.pow(2, i) * Integer.parseInt(input.charAt(input.length()-(1+i))+"")));
			}

			while(result>=16)
			{
				int x=result%16;
				merge= ToHex(x) + merge;
				result=result/16;				
			}		
			ans = ToHex(result) + merge;			
		}

		else if(from.equals(HEX) && to.equals(BIN))
		{
			if(isHex==false)
				return "Invalid Input";

			for (int i=0 ; i<input.length() ; i++)
			{
				int x = (int)Math.pow(16, i) * HexTo(input.charAt(input.length()-(1+i))+"");
				result =  result + x;	
			}

			while(result>=2)
			{
				int x = result%2;
				merge = Integer.toString(x) + merge;
				result = result/2;
			}
			ans = Integer.toString(result) + merge;
		}

		else if(from.equals(HEX) && to.equals(DEC))
		{
			if(isHex==false)
				return "Invalid Input";

			for (int i=0 ; i<input.length() ; i++)
			{
				int x = (int)Math.pow(16, i) * HexTo(input.charAt(input.length()-(1+i))+"");
				result =  result + x;	
			}		
			ans = Integer.toString(result);	
		}

		else if (from.equals(to))
		{
			ans=input;
		}
		else
		{
			System.out.println("Invalid Convert");
		}

		return ans;
	}


	public String ToHex(int num)
	{
		String x="";

		if (num==10)
			x="A";
		else if (num == 11)
			x="B";
		else if (num == 12)
			x="C";
		else if (num == 13)
			x="D";
		else if (num == 14)
			x="E";
		else if (num == 15)
			x="F";
		else 
			x=Integer.toString(num);

		return x;
	}


	public int HexTo (String num) 
	{
		int x=0;

		if (num.equals("A"))
			x=10;
		else if (num.equals("B"))
			x=11;
		else if (num.equals("C"))
			x=12;
		else if (num.equals("D"))
			x=13;
		else if (num.equals("E"))
			x=14;
		else if (num.equals("F"))
			x=15;
		else 
			x=Integer.parseInt(num);

		return x;
	}
}

