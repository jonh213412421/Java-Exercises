//native imports
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

//create Jpanel
public class Screen extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_phone;
	private JTextField textField_address;
	private JTextField textField_age;
	private JTextField textField_gender;
	private JTextField textField_coments;

//ste elements in panel
	public Screen() { //create panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Name = new JLabel("Name");
		Name.setBounds(10, 11, 46, 14);
		contentPane.add(Name);
		
		textField_name = new JTextField();
		textField_name.setBounds(56, 8, 341, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		textField_phone = new JTextField();
		textField_phone.setBounds(56, 43, 341, 20);
		contentPane.add(textField_phone);
		textField_phone.setColumns(10);
		
		JLabel Phone = new JLabel("Phone");
		Phone.setBounds(10, 46, 46, 14);
		contentPane.add(Phone);
		
		textField_address = new JTextField();
		textField_address.setBounds(56, 74, 341, 20);
		contentPane.add(textField_address);
		textField_address.setColumns(10);
		
		JLabel Adress = new JLabel("Adress");
		Adress.setBounds(10, 77, 46, 14);
		contentPane.add(Adress);
		
		textField_age = new JTextField();
		textField_age.setBounds(56, 105, 78, 20);
		contentPane.add(textField_age);
		textField_age.setColumns(10);
		
		JLabel Age = new JLabel("Age");
		Age.setBounds(20, 108, 36, 14);
		contentPane.add(Age);
		
		JLabel Gender = new JLabel("Gender");
		Gender.setBounds(162, 108, 36, 14);
		contentPane.add(Gender);
		
		textField_gender = new JTextField();
		textField_gender.setColumns(10);
		textField_gender.setBounds(204, 105, 78, 20);
		contentPane.add(textField_gender);
		
		textField_coments = new JTextField();
		textField_coments.setText("");
		textField_coments.setBounds(66, 136, 331, 85);
		contentPane.add(textField_coments);
		textField_coments.setColumns(10);
		
		JLabel Coments = new JLabel("Coments");
		Coments.setBounds(10, 150, 56, 14);
		contentPane.add(Coments);
		
		JButton Submit = new JButton("Submit");
		Submit.setBounds(176, 232, 89, 23);
		contentPane.add(Submit);
		ArrayList<Client> clientlist = new ArrayList<>();
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitForm(clientlist);
                printUsers(clientlist);
            }
        });
	}

  //submit form action
	public void submitForm(ArrayList<Client> clientlist) {
    //gets variables
		String name = textField_name.getText();
		String phone = textField_phone.getText();
		String address = textField_address.getText();
		int age = 0;
        try {// Handle invalid age input
            age = Integer.parseInt(textField_age.getText());
        } catch (NumberFormatException e) {
          }
		String gender = textField_gender.getText();
		String coments = textField_coments.getText();
		Client client = new Client(name, phone, address, age, gender, coments); //creates new client
		clientlist.add(client); //add client to an array
	}
    public void printUsers(ArrayList<Client> clientList) {//prints client list
        for (Client client : clientList) {
            System.out.println(client.name);
            System.out.println(client.phone);
            System.out.println(client.age);
            System.out.println(client.gender);
        }
    }
}
