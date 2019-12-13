import java.awt.*;//�׷��� ó���� ���� Ŭ�������� ��θ�
import java.awt.event.*;//AWT �̺�Ʈ ����� ���� ��θ�
import javax.swing.*;//���� ������Ʈ Ŭ�������� ��θ�

public class Calculator extends JFrame {//JFrame�� ��ӹ��� Calculator Ŭ����
	JButton Button = new JButton("���");//��ư ����
	JLabel Label1 = new JLabel("ȯ���ݾ�(��) : ");//���̺� ����
	JLabel Label2 = new JLabel("��ȭ�� : ");//���̺� ����
	JLabel Label3 = new JLabel("��� : ");//���̺� ����
	JLabel Label4 = new JLabel("");//��ü ����
	JTextField input = new JTextField(10);//�ؽ�Ʈ �ʵ� ����
	JComboBox countryBox; 

	public Calculator() {//����Ʈ ������
		setTitle("ȯ������-2019.12.11���� ȯ��");//�������� Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����Ӱ� �Բ� ����
		Container contentPane = getContentPane();//����Ʈ�� �˾Ƴ���
		contentPane.setLayout(new GridLayout(4,2));//GridLayout ��ġ������ ��� 4x2 ���ҷ� ������Ʈ ��ġ
		
		Button.addActionListener(new Cal());//��ư�� �׼� �̺�Ʈ��� �ޱ� 
		
		String [] country = {"USD(1192.0)", "JPY(1097.96)", "EUR(1320.32)"}; //�迭�� ���� �޺��ڽ� ����
		countryBox = new JComboBox(country);//�޺��ڽ� ����
		contentPane.add(Label1);//���� ����Ʈ�ҿ� ����
		contentPane.add(input);//�ؽ�Ʈ�� ����Ʈ�ҿ� ����
		contentPane.add(Label2);//���� ����Ʈ�ҿ� ����
		contentPane.add(countryBox);//�޺��ڽ��� ����Ʈ�ҿ� ����
		contentPane.add(Label3);//���� ����Ʈ�ҿ� ����
		contentPane.add(Label4);//���� ����Ʈ�ҿ� ����
		contentPane.add(Button);//��ư�� ����Ʈ�ҿ� ����
		
		setSize(400,200);//������ ũ�� ����
		setVisible(true);//������ ���̰��ϱ�
	}
	
	public static void main(String[] args){
		new Calculator();//Calculator ��ü����
	}	
	
	class Cal implements ActionListener { //��ư Ŭ�� �̺�Ʈ�� ó���ϱ� ���� �������̽�
		public void actionPerformed(ActionEvent e){//Action �̺�Ʈ �߻��� ȣ���
			try{//try-catch�� ���
				String Text = input.getText(); //���� �Է�
				String Text2 = null; //�Ի��� ���� �ڿ� �ٴ� ����
				double num1 = Double.parseDouble(Text);//�Ǽ� ���ڿ� �Ǽ� ��ȯ
				double num2 = 0;
		
				switch(countryBox.getSelectedIndex()){//switch���� �̿��Ͽ� �޺��ڽ��� �������� �� ��
					case 0 ://�ε����� 0�϶�
						num2 = (double)1192.0;
						Text2 = "USD";
						break;//switch�� ���
					case 1 ://�ε����� 1�϶�
						num2 = (double)1097.96;
						Text2 = "JPY";
						break;//switch�� ���
					case 2://�ε����� 2�϶�
						num2 = (double)1320.32;
						Text2 = "EUR";
						break;//switch�� ���
					}
			
				double res = (double)num1 / (double)num2; //�� ȯ���γ�����
				String num3 = String.format("%.2f", res);//String.format()�� Ȱ���Ͽ� �Ҽ��� ���ڸ����� ���
				Label4.setText(num3 + Text2);//�ݾ�+ȭ����� �ؽ�Ʈ �ʵ忡 ���
			}
			catch(Exception e1){
				Label4.setText("�߸��� �Է�"); //double���� �ƴ� ��� �߸��� �Է��̶�� �ؽ�Ʈ �ʵ忡 ���
			}
		
		}
	}
}