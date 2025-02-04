import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame
{
    private JPanel panel;
    private JList studentList;
    private DefaultListModel<String> studentListModel;

    private JLabel labelFirstName;
    private JLabel labelLastName;
    private JLabel labelStudentID;

    private JTextField inputFirstName;
    private JTextField inputLastName;
    private JTextField inputStudentID;

    private JButton buttonAddStudent;
    private JButton buttonDropStudent;

    public StudentGUI()
    {
        setContentPane(panel); //sets the pane
        setTitle("Student DIR"); //gives it a title
        setSize(500, 500); //sets size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes it so when you hit the X, the program ends

        studentListModel = new DefaultListModel<>();
        buttonAddStudent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // JOptionPane.showMessageDialog(null, "YOU DID IT!"); this was a test
                String firstName = inputFirstName.getText();
                String lastName = inputLastName.getText();
                String studentID = inputStudentID.getText();

                if(firstName.isEmpty() || lastName.isEmpty() || studentID.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "All fields are required!");
                    return; //this is checking that each field aka text box needs to be filled, if not then this if is hit.
                }

                inputFirstName.setText("");
                inputLastName.setText("");
                inputStudentID.setText("");

                String record = firstName + " " + lastName + " (" + studentID + ")";
                studentListModel.addElement(record);
                studentList.setModel(studentListModel);
            }
        });
        buttonDropStudent.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int studentIndex = studentList.getSelectedIndex();

                if(studentIndex < 0)
                {
                    JOptionPane.showMessageDialog(null, "Please select a student to remove");
                    return;
                }
                studentListModel.remove(studentIndex);
                studentList.setModel(studentListModel);
            }
        });
    }
}
