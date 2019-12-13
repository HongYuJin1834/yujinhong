import java.awt.*;//그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*;//AWT 이벤트 사용을 위한 경로명
import javax.swing.*;//스윙 컴포넌트 클래스들의 경로명

public class Calculator extends JFrame {//JFrame을 상속받은 Calculator 클래스
	JButton Button = new JButton("계산");//버튼 생성
	JLabel Label1 = new JLabel("환전금액(￦) : ");//레이블 생성
	JLabel Label2 = new JLabel("통화명 : ");//레이블 생성
	JLabel Label3 = new JLabel("결과 : ");//레이블 생성
	JLabel Label4 = new JLabel("");//객체 생성
	JTextField input = new JTextField(10);//텍스트 필드 생성
	JComboBox countryBox; 

	public Calculator() {//디폴트 생성자
		setTitle("환율계산기-2019.12.11기준 환율");//프레임의 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임과 함꼐 종료
		Container contentPane = getContentPane();//컨탠트팬 알아내기
		contentPane.setLayout(new GridLayout(4,2));//GridLayout 배치관리자 사용 4x2 분할로 컴포넌트 배치
		
		Button.addActionListener(new Cal());//버튼에 액션 이벤트기능 달기 
		
		String [] country = {"USD(1192.0)", "JPY(1097.96)", "EUR(1320.32)"}; //배열로 부터 콤보박스 생성
		countryBox = new JComboBox(country);//콤보박스 생성
		contentPane.add(Label1);//라벨을 컨텐트팬에 부착
		contentPane.add(input);//텍스트를 컨텐트팬에 부착
		contentPane.add(Label2);//라벨을 컨텐트팬에 부착
		contentPane.add(countryBox);//콤보박스를 컨텐트팬에 부착
		contentPane.add(Label3);//라벨을 컨텐트팬에 부착
		contentPane.add(Label4);//라벨을 컨텐트팬에 부착
		contentPane.add(Button);//버튼을 컨텐트팬에 부착
		
		setSize(400,200);//프레임 크기 조절
		setVisible(true);//프레임 보이게하기
	}
	
	public static void main(String[] args){
		new Calculator();//Calculator 객체생성
	}	
	
	class Cal implements ActionListener { //버튼 클릭 이벤트를 처리하기 위한 인터페이스
		public void actionPerformed(ActionEvent e){//Action 이벤트 발생시 호출됨
			try{//try-catch문 사용
				String Text = input.getText(); //돈을 입력
				String Text2 = null; //게산한 숫자 뒤에 붙는 단위
				double num1 = Double.parseDouble(Text);//실수 문자열 실수 반환
				double num2 = 0;
		
				switch(countryBox.getSelectedIndex()){//switch문을 이용하여 콤보박스를 선택했을 때 추
					case 0 ://인덱스가 0일때
						num2 = (double)1192.0;
						Text2 = "USD";
						break;//switch문 벗어남
					case 1 ://인덱스가 1일때
						num2 = (double)1097.96;
						Text2 = "JPY";
						break;//switch문 벗어남
					case 2://인덱스가 2일때
						num2 = (double)1320.32;
						Text2 = "EUR";
						break;//switch문 벗어남
					}
			
				double res = (double)num1 / (double)num2; //각 환율로나누기
				String num3 = String.format("%.2f", res);//String.format()을 활용하여 소수점 두자리까지 계산
				Label4.setText(num3 + Text2);//금액+화폐단위 텍스트 필드에 출력
			}
			catch(Exception e1){
				Label4.setText("잘못된 입력"); //double형이 아닌 경우 잘못된 입력이라고 텍스트 필드에 출력
			}
		
		}
	}
}