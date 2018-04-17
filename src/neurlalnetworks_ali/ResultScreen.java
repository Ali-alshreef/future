
package neurlalnetworks_ali;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import neurlalnetworks_ali.Preceptron;

public class ResultScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_11;
	private JTextField textField_111;
	private JTextField textField_1111;
	private JTextField textField_2;
	private JTextField textField_22;
	private JTextField textField_222;
	private JTextField textField_2222;
	private JTextField textField_3;
	private JTextField textField_33;
	private JTextField textField_333;
	private JTextField textField_3333;
	private JTextField textField_4;
	private JTextField textField_44;
	private JTextField textField_444;
	private JTextField textField_4444;
	private JTextField textField_5;
	private JTextField textField_55;
	private JTextField textField_555;
	private JTextField textField_5555;
	private static String[][] last_Result = new String[4][5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int [][][] data =  Preceptron.andData;
        double [] weights = Preceptron.INITIAL_WEIGHTS;
        
        Preceptron prec = new Preceptron();
        int epochNumber =0;
        boolean errorflag =true;
        double error =0;
        double [] adjustedWeights = null;
        while (errorflag){
            printHeading( epochNumber++);
            errorflag = false;
            error=0;  
            for( int x=0; x < data.length ;  x++){
            double weihgtedSum  = prec.calculateWeightedSum(data[x][0], weights);
            int result = prec.applyActivationFunction(weihgtedSum);
            error = data [x][1][0] - result;
            adjustedWeights = prec.adjustWeights(data[x][0], weights, error);
			weights = adjustedWeights;
			if (error != 0)
				errorflag = true;
			else {				
				last_Result[x][0] = String.valueOf(result);
				last_Result[x][1] = String.valueOf(error);
				last_Result[x][2] = String.format("%.2f", weihgtedSum);
				last_Result[x][3] = String.format("%.2f",adjustedWeights[0]);
				last_Result[x][4] = String.format("%.2f",adjustedWeights[1]);
			}
			printVector(data[x], weights, result, error, weihgtedSum, adjustedWeights);
            }
        }       
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultScreen frame = new ResultScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	   
	   public static void printHeading(int  epochNumber){
		    System.out.println("\n\t\t\t\t\t\tEpoch #"+ epochNumber);
	        System.out.println("======================================================================================================================");
	        System.out.println("  w1   |  w2     |  x1   |   x2     |  TargetResult  |  Result  |  Error  |  WeightedSum  |  adjust w1  |  adjust w2  ");
	        System.out.println("----------------------------------------------------------------------------------------------------------------------");
	    
	    }
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
	   public static void printVector( int [][]data,double [] weights, int result ,double error,double weightedSum,double [] adjustedWeights){
	  
	     System.out.println(" "+String.format("%.2f", weights[0])+"  |  "
	    		 			   +String.format("%.2f", weights[1])+"   |   "
	    		 			   +data[0][0] +"   |   "
	    		 			   +data [0][1]+"      |            "
	    		 			   +data [1][0]+"   |      "
	    		 			   + result +"   |   "
	    		 			   + error +"   |        "
	    		 			   +String.format("%.2f", weightedSum)+"   |   "
	    		 			   + String.format("%.2f",adjustedWeights[0])+"      |      "
	    		 			   +String.format("%.2f",adjustedWeights[1]));
	   }
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Create the frame.
	 */
	public ResultScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Libyan Academy - Ganzour");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 16));
		label.setBounds(296, 21, 328, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Basic Science School - Computer Science");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		label_1.setBounds(296, 49, 328, 28);
		contentPane.add(label_1);
		
		JLabel lblApplicationOfArtificial = new JLabel("Application of Artificial Neural Network by Gate  AND");
		lblApplicationOfArtificial.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplicationOfArtificial.setForeground(Color.BLUE);
		lblApplicationOfArtificial.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblApplicationOfArtificial.setBounds(235, 88, 461, 28);
		contentPane.add(lblApplicationOfArtificial);
		
		JLabel label_3 = new JLabel("\u0639\u0645\u0644 \u0627\u0644\u0637\u0627\u0644\u0628: \u0639\u0644\u064A \u0627\u0644\u0634\u0631\u064A\u0641");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(new Color(178, 34, 34));
		label_3.setFont(new Font("Traditional Arabic", Font.BOLD, 14));
		label_3.setBounds(361, 127, 184, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("academy.png")).getImage();
		label_4.setIcon(new ImageIcon(img));
		label_4.setBounds(60, 21, 131, 142);
		contentPane.add(label_4);
		
		JLabel lblX = new JLabel("X1");
		lblX.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(10, 205, 46, 21);
		contentPane.add(lblX);
		
		JLabel lblX_1 = new JLabel("X2");
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblX_1.setBounds(61, 205, 46, 21);
		contentPane.add(lblX_1);
		
		JLabel lblTargetResult = new JLabel("Target Result");
		lblTargetResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblTargetResult.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblTargetResult.setBounds(117, 205, 147, 21);
		contentPane.add(lblTargetResult);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblResult.setBounds(274, 205, 83, 21);
		contentPane.add(lblResult);
		
		JLabel lblError = new JLabel("Error");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblError.setBounds(354, 205, 74, 21);
		contentPane.add(lblError);
		
		JLabel lblWeightedsum = new JLabel("Weighted_Sum");
		lblWeightedsum.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeightedsum.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblWeightedsum.setBounds(439, 205, 147, 21);
		contentPane.add(lblWeightedsum);
		
		JLabel lblAdjustw = new JLabel("Adjust_W1");
		lblAdjustw.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdjustw.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblAdjustw.setBounds(606, 205, 123, 21);
		contentPane.add(lblAdjustw);
		
		JLabel lblAdjustw_1 = new JLabel("Adjust_W2");
		lblAdjustw_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdjustw_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		lblAdjustw_1.setBounds(727, 205, 116, 21);
		contentPane.add(lblAdjustw_1);
		
		JLabel label_5 = new JLabel("0");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_5.setBounds(10, 249, 46, 21);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("0");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_6.setBounds(10, 290, 46, 21);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("1");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_7.setBounds(10, 333, 46, 21);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("1");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_8.setBounds(10, 375, 46, 21);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("0");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_9.setBounds(61, 249, 46, 21);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("1");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_10.setBounds(61, 290, 46, 21);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("0");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_11.setBounds(61, 333, 46, 21);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("1");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_12.setBounds(61, 375, 46, 21);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("0");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_13.setBounds(170, 249, 46, 21);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("0");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_14.setBounds(170, 290, 46, 21);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("0");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_15.setBounds(170, 333, 46, 21);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("1");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
		label_16.setBounds(170, 375, 46, 21);
		contentPane.add(label_16);
		
		textField_1 = new JTextField(last_Result[0][0]);
		textField_1.setForeground(new Color(0, 0, 255));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(274, 249, 62, 20);
		contentPane.add(textField_1);
		
		textField_11 = new JTextField(last_Result[1][0]);
                textField_11.setEditable(false);
		textField_11.setForeground(new Color(0, 0, 255));
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(274, 290, 62, 20);
		contentPane.add(textField_11);
		
		textField_111 = new JTextField(last_Result[2][0]);
                textField_111.setEditable(false);
		textField_111.setForeground(new Color(0, 0, 255));
		textField_111.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_111.setHorizontalAlignment(SwingConstants.CENTER);
		textField_111.setColumns(10);
		textField_111.setBounds(274, 333, 62, 20);
		contentPane.add(textField_111);
		
		textField_1111 = new JTextField(last_Result[3][0]);
                textField_1111.setEditable(false);
		textField_1111.setForeground(new Color(0, 0, 255));
		textField_1111.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1111.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1111.setColumns(10);
		textField_1111.setBounds(274, 375, 62, 20);
		contentPane.add(textField_1111);
		
		textField_2 = new JTextField(last_Result[0][1]);
                textField_2.setEditable(false);
		textField_2.setForeground(new Color(0, 0, 255));
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(366, 250, 62, 20);
		contentPane.add(textField_2);
		
		textField_22 = new JTextField(last_Result[1][1]);
                textField_22.setEditable(false);
		textField_22.setForeground(new Color(0, 0, 255));
		textField_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setColumns(10);
		textField_22.setBounds(366, 291, 62, 20);
		contentPane.add(textField_22);
		
		textField_222 = new JTextField(last_Result[2][1]);
                textField_222.setEditable(false);
		textField_222.setForeground(new Color(0, 0, 255));
		textField_222.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_222.setHorizontalAlignment(SwingConstants.CENTER);
		textField_222.setColumns(10);
		textField_222.setBounds(366, 334, 62, 20);
		contentPane.add(textField_222);
		
		textField_2222 = new JTextField(last_Result[3][1]);
                textField_2222.setEditable(false);
		textField_2222.setForeground(new Color(0, 0, 255));
		textField_2222.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2222.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2222.setColumns(10);
		textField_2222.setBounds(366, 376, 62, 20);
		contentPane.add(textField_2222);
		
		textField_3 = new JTextField(last_Result[0][2]);
                textField_3.setEditable(false);
		textField_3.setForeground(new Color(0, 0, 255));
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(483, 250, 62, 20);
		contentPane.add(textField_3);
		
		textField_33 = new JTextField(last_Result[1][2]);
                textField_33.setEditable(false);
		textField_33.setForeground(new Color(0, 0, 255));
		textField_33.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_33.setHorizontalAlignment(SwingConstants.CENTER);
		textField_33.setColumns(10);
		textField_33.setBounds(483, 291, 62, 20);
		contentPane.add(textField_33);
		
		textField_333 = new JTextField(last_Result[2][2]);
                textField_333.setEditable(false);
		textField_333.setForeground(new Color(0, 0, 255));
		textField_333.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_333.setHorizontalAlignment(SwingConstants.CENTER);
		textField_333.setColumns(10);
		textField_333.setBounds(483, 334, 62, 20);
		contentPane.add(textField_333);
		
		textField_3333 = new JTextField(last_Result[3][2]);
                textField_3333.setEditable(false);
		textField_3333.setForeground(new Color(0, 0, 255));
		textField_3333.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3333.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3333.setColumns(10);
		textField_3333.setBounds(483, 376, 62, 20);
		contentPane.add(textField_3333);
		
		textField_4 = new JTextField(last_Result[0][3]);
                textField_4.setEditable(false);
		textField_4.setForeground(new Color(0, 0, 255));
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(639, 250, 62, 20);
		contentPane.add(textField_4);
		
		textField_44 = new JTextField(last_Result[1][3]);
                textField_44.setEditable(false);
		textField_44.setForeground(new Color(0, 0, 255));
		textField_44.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_44.setHorizontalAlignment(SwingConstants.CENTER);
		textField_44.setColumns(10);
		textField_44.setBounds(639, 291, 62, 20);
		contentPane.add(textField_44);
		
		textField_444 = new JTextField(last_Result[2][3]);
                textField_444.setEditable(false);
		textField_444.setForeground(new Color(0, 0, 255));
		textField_444.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_444.setHorizontalAlignment(SwingConstants.CENTER);
		textField_444.setColumns(10);
		textField_444.setBounds(639, 334, 62, 20);
		contentPane.add(textField_444);
		
		textField_4444 = new JTextField(last_Result[3][3]);
                textField_4444.setEditable(false);
		textField_4444.setForeground(new Color(0, 0, 255));
		textField_4444.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4444.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4444.setColumns(10);
		textField_4444.setBounds(639, 376, 62, 20);
		contentPane.add(textField_4444);
		
		textField_5 = new JTextField(last_Result[0][4]);
                textField_5.setEditable(false);
		textField_5.setForeground(new Color(0, 0, 255));
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(758, 250, 62, 20);
		contentPane.add(textField_5);
		
		textField_55 = new JTextField(last_Result[1][4]);
                textField_55.setEditable(false);
		textField_55.setForeground(new Color(0, 0, 255));
		textField_55.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_55.setHorizontalAlignment(SwingConstants.CENTER);
		textField_55.setColumns(10);
		textField_55.setBounds(758, 291, 62, 20);
		contentPane.add(textField_55);
		
		textField_555 = new JTextField(last_Result[2][4]);
                textField_555.setEditable(false);
		textField_555.setForeground(new Color(0, 0, 255));
		textField_555.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_555.setHorizontalAlignment(SwingConstants.CENTER);
		textField_555.setColumns(10);
		textField_555.setBounds(758, 334, 62, 20);
		contentPane.add(textField_555);
		
		textField_5555 = new JTextField(last_Result[3][4]);
                textField_5555.setEditable(false);
		textField_5555.setForeground(new Color(0, 0, 255));
		textField_5555.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_5555.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5555.setColumns(10);
		textField_5555.setBounds(758, 376, 62, 20);
		contentPane.add(textField_5555);
	}
}
