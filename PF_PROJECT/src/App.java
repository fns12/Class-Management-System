
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class App implements ActionListener {

    private static JPanel cardPanel;
    private static CardLayout cardLayout;
    private static JPanel loginPanel;
    private static JLabel label1;
    private static JTextField userText;
    private static JLabel label2;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel successLabel;

public static void main(String[] args) {

   //---------------------------------------CREATING FRAME------------------------------------------------ 

        JFrame frame = new JFrame();// creates a frame
        // Create a CardLayout for switching between panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create a login panel
        loginPanel = createLoginPanel();
        
        
        // Add the login panel to the card panel
        cardPanel.add(loginPanel,"loginPanel");

        // Add the card panel to the frame
        frame.add(cardPanel);     
        
        // frame
        //frame.setTitle("Class Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exist out of application
        frame.setSize(1920,1080);// sets the height and width of frame
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setTitle("Class Management System");
    //-------------------------------CREATING FILE TO SAVE MARKS OF STUDENTS------------------------------------    
    try{
     File file = new File("java34_output.txt");
     file.createNewFile();
     BufferedWriter writer = new BufferedWriter(new FileWriter(file)); 
        writer.write(String.format("%-15s| %-15s| %-5s| %-5s| %-5s| %-5s%n", "NAME", "ROLL NUMBER", "PF", "DLD", "FOM", "CS"));
        
        writer.write("-----------------------------------------------------------\n");
        writer.close();
    }
    catch(Exception e){
        e.printStackTrace();
    };
    //----------------------------------CREATING FILE TO SAVE GPA OF STUDENTS----------------------------------
    try{
     File file = new File("GPA.txt");
     file.createNewFile();
     BufferedWriter writer = new BufferedWriter(new FileWriter(file)); 
        writer.write(String.format("   %-20s | %-15s |%-4s|%-4s|%-4s|%-4s|%-10s%n|", "NAME", "ROLL NUMBER", "PF", "DLD", "FOM", "CS","CGPA"));
        
        writer.write("----------------------------------------------------------------\n");
        writer.close();
    }
    catch(Exception e){
        e.printStackTrace();
    };    
    }
    //-----------------------------------------LOGIN PANEL-----------------------------------------------
    private static JPanel createLoginPanel() {
        JPanel panel = new JPanel(null);
        
        ImageIcon image = new ImageIcon("myimage.png");
                    // label for main heading
        JLabel label = new JLabel();
        label.setText("Class Management System");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Times New Roman", Font.BOLD, 22));
        label.setIconTextGap(20);
        label.setBackground(Color.CYAN);
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(480,15,300,230);

        // ------SUCCESS LABEL--------
        successLabel = new JLabel();
        successLabel.setBounds(545, 430, 200, 30);
        successLabel.setOpaque(true);
        successLabel.setBackground(Color.CYAN);
        successLabel.setForeground(Color.RED);
        successLabel.setHorizontalAlignment(JLabel.CENTER);

        // -------WORKING FOR USERNAME-------
        label1 = new JLabel("Username:");
        label1.setBounds(540, 290, 170, 20);
        label1.setFont(new Font("Aptos Display", Font.BOLD, 16));

        userText = new JTextField(20);
        userText.setBounds(630, 290, 120, 23);

        // ------WORKING FOR PASSWORD--------
        label2 = new JLabel("Password:");
        label2.setBounds(540, 340, 170, 20);
        label2.setFont(new Font("Aptos Display", Font.BOLD, 16));

        passwordText = new JPasswordField();
        passwordText.setBounds(630, 340, 120, 23);

        // -----LOGIN BUTTON---------
        button = new JButton("Login");
        button.setBounds(600, 400, 80, 20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        // Add components to the login panel
        panel.setBounds(0, 0, 1920, 1080); // Set the panel to cover the whole screen
        panel.setLayout(null); 
        panel.add(label);
        panel.add(label1);
        panel.add(userText);
        panel.add(label2);
        panel.add(passwordText);
        panel.add(button);
        panel.add(successLabel);
        panel.setSize(1920,1080);
        panel.setBackground(Color.CYAN);
        
        return panel;
    }

    private static void handleLogin() {
        String user = userText.getText();
        String password = new String(passwordText.getPassword());

        if (user.equals("hey") && password.equals("123")) {
            

            // Open a new panel with a label
            openNewPanelWithLabel();
        } else {
            successLabel.setText("Try Again!");
        }
    }
    //---------------------------------------PANEL FOR MENU-----------------------------------------------------

    private static void openNewPanelWithLabel() {
        // Create a new panel with a label
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1)); // 0 means unlimited rows, 1 column
        JLabel mainLabel = new JLabel("Select to Perform Mentioned Task\n\n");
        mainLabel.setBounds(500,50,20,60);
        mainLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        mainLabel.setHorizontalTextPosition(JLabel.CENTER);
        mainLabel.setVerticalTextPosition(JLabel.TOP);
        mainPanel.add(mainLabel);
    
        // Buttons panel to hold the buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(0, 1)); // 0 means unlimited rows, 1 column
    
        // Add buttons and labels to the buttons panel
        addButtonToPanel("View Student Details", "1. Click button to view details of students", Color.BLUE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewPanel1();
            }
        }, buttonsPanel);
    
        addButtonToPanel("Add Student Marks", "2. Click the button to add marks of students", Color.BLUE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewPanel2();
            }
        }, buttonsPanel);
    
        addButtonToPanel("Calculate Student GPA", "3. Click the button to calculate GPA students", Color.BLUE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewPanel3();
            }
        }, buttonsPanel);
    
        addButtonToPanel("Display Detailed Result", "4. Click the button to view detailed result of students", Color.BLUE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewPanel4();
            }
        }, buttonsPanel);
        addButtonToPanel("Logout", "Press to logout", Color.BLUE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 cardLayout.show(cardPanel, "loginPanel");
            }
        }, buttonsPanel);
    
        // Add buttons panel to the main panel
        mainPanel.add(buttonsPanel);
    
        // Add the new panel to the card panel
        cardPanel.add(mainPanel, "mainPanel");
    
        // Switch to the new panel
        cardLayout.show(cardPanel, "mainPanel");
    }
    
    // Helper method to add a button to a panel
    private static void addButtonToPanel(String buttonText, String label, Color labelColor, ActionListener actionListener, JPanel panel) {
        JLabel buttonLabel = new JLabel(label);
        
        buttonLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        buttonLabel.setForeground(labelColor);
        buttonLabel.setHorizontalAlignment(JLabel.LEFT);
    
        JButton button = new JButton(buttonText);
        button.addActionListener(actionListener);
    
        panel.add(buttonLabel);
        panel.add(button);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    //-------------------------------------PROCESSING FOR OPTION 1 STARTS--------------------------------------
    //FUNCTION CALLING NEW PANEL FOR OPTION 1
    private static void openNewPanel1() {
        JPanel newPanel = studentInformationPanel();
        cardPanel.add(newPanel, "newPanel");
        cardLayout.show(cardPanel, "newPanel");
    }
    
    private static JPanel studentInformationPanel() {
        JPanel panelstdinfo = new JPanel(new BorderLayout());
        
        // Read data from file and create a table
        String filePath = "java34.txt"; // Replace with your file path
        JTable table = createTableFromData(filePath);
        
        // Add a back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "mainPanel");
            }
        });
    
        // Create a panel to hold the table and back button
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
        tablePanel.add(backButton, BorderLayout.SOUTH);
    
        panelstdinfo.add(tablePanel, BorderLayout.CENTER);
    
        return panelstdinfo;
    }
    
    private static JTable createTableFromData(String filePath) {
        String[] columnNames = {"Name", "RollNo.", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return new JTable(model);
    }
    //PROCESSING FOR OPTION 1 ENDS
    

    //--------------------------------------PROCESSING FOR OPTION 2 STARTS------------------------------------------
    // FUNCTION CALLING NEW PANEL FOR OPTION 2
private static void openNewPanel2() {
        JPanel newPanel = createMarksPanel();
        cardPanel.add(newPanel, "marksPanel");
        cardLayout.show(cardPanel, "marksPanel");
    }
private static JPanel createMarksPanel() {
    JPanel marksPanel = new JPanel(new BorderLayout());
    String filePath = "java34.txt"; // Replace with your file path
    String[] columnNames = {"Name", "RollNo.", "PF", "DLD", "FOM", "CS"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    marksPanel.add(scrollPane, BorderLayout.CENTER);

    JPanel inputPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);

    // Create a JComboBox to select students
    JComboBox<String> studentComboBox = new JComboBox<>();
    loadStudents(filePath, studentComboBox);

    JLabel nameLabel = new JLabel("Name:");
    JTextField nameField = new JTextField();
    nameField.setColumns(25);  // Set the width
    JLabel rollNoLabel = new JLabel("RollNo.:");
    JTextField rollNoField = new JTextField();
    rollNoField.setColumns(25);  // Set the width
    JLabel subject1Label = new JLabel("PF");
    JTextField subject1Field = new JTextField();
    subject1Field.setColumns(25);  // Set the width
    JLabel subject2Label = new JLabel("DLD");
    JTextField subject2Field = new JTextField();
    subject2Field.setColumns(25);  // Set the width
    JLabel subject3Label = new JLabel("FOM");
    JTextField subject3Field = new JTextField();
    subject3Field.setColumns(25);  // Set the width
    JLabel subject4Label = new JLabel("CS");
    JTextField subject4Field = new JTextField();
    subject4Field.setColumns(25);  // Set the width
    

    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveMarks(nameField.getText(), rollNoField.getText(),
                    subject1Field.getText(), subject2Field.getText(),
                    subject3Field.getText(), subject4Field.getText(),
                     model);
                    
        
        }

    private void saveMarks(String name, String rollNo, String subject1, String subject2,
                String subject3, String subject4, DefaultTableModel model) {
            // Add a new row to the table
            model.addRow(new Object[]{name, rollNo, subject1, subject2, subject3, subject4});


            // Save the data to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("java34_output.txt", true))) {
                String modifiedLine = String.format("%-15s| %-15s| %-5s| %-5s| %-5s| %-5s%n",
                    name,rollNo,subject1 ,subject2,subject3,subject4);
                writer.write(modifiedLine);
                } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Clear input fields after saving
            nameField.setText("");
            rollNoField.setText("");
            subject1Field.setText("");
            subject2Field.setText("");
            subject3Field.setText("");
            subject4Field.setText("");
            
        }
    });

    // Add action listener to JComboBox for dynamic updating
    studentComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Load selected student's data into input fields
            String selectedStudent = (String) studentComboBox.getSelectedItem();
            if (selectedStudent != null) {
                String[] studentData = selectedStudent.split(",");
                nameField.setText(studentData[0]);
                rollNoField.setText(studentData[1]);
            }
        }
    });
    JButton BackButton = new JButton("Back");
    BackButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
         cardLayout.show(cardPanel, "mainPanel");   
        }
        
    }); 
    gbc.gridx = 0;
    gbc.gridy = 0;
    inputPanel.add(new JLabel("Select Student:"), gbc);
    gbc.gridx = 1;
    inputPanel.add(studentComboBox, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    inputPanel.add(nameLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(nameField, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    inputPanel.add(rollNoLabel, gbc);
    gbc.gridx = 1;
    inputPanel.add(rollNoField, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    inputPanel.add(subject1Label, gbc);
    gbc.gridx = 1;
    inputPanel.add(subject1Field, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    inputPanel.add(subject2Label, gbc);
    gbc.gridx = 1;
    inputPanel.add(subject2Field, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    inputPanel.add(subject3Label, gbc);
    gbc.gridx = 1;
    inputPanel.add(subject3Field, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    inputPanel.add(subject4Label, gbc);
    gbc.gridx = 1;
    inputPanel.add(subject4Field, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 2;
    inputPanel.add(saveButton, gbc);

    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 3;
    inputPanel.add(BackButton, gbc);

    marksPanel.add(inputPanel, BorderLayout.SOUTH);

    return marksPanel;
}

// Load student names and roll numbers from file to JComboBox
private static void loadStudents(String filePath, JComboBox<String> comboBox) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            comboBox.addItem(data[0] + "," + data[1]);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

}
//PROCESSING FOR OPTION 2 ENDS


//----------------------------------PROCESSING FOR OPTION 3 STARTS---------------------------------------------
// FUNCTION CALLING NEW PANEL FOR OPTION 3
private static void openNewPanel3() {
        JPanel newPanel = creategpaPanel();
        cardPanel.add(newPanel, "gpaPanel");
        cardLayout.show(cardPanel, "gpaPanel");
    } 
private static JPanel creategpaPanel() {
    JPanel gpaPanel = new JPanel();
    gpaPanel.setLayout(new BoxLayout(gpaPanel, BoxLayout.Y_AXIS));

    // Add a label for GPA calculation
    JLabel gpaLabel = new JLabel("GPA Calculation Status\n\n");
    gpaLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
    gpaPanel.add(gpaLabel);

    
       // Display different labels based on file validity
    if (isFileValid()) {
        
        String[][] finalMarks = arrayMarks();
        String[][] gpa = new String [finalMarks.length][7];
        GPAofsubjects(gpa,finalMarks);
        calculateGPA(gpa);
        JLabel successLabel = new JLabel("GPA Calculated Successfully!");
        successLabel.setForeground(Color.GREEN);
      
        
        gpaPanel.add(successLabel);
    } else {
        JLabel errorLabel = new JLabel("Marks not uploaded. Invalid file.");
        errorLabel.setForeground(Color.RED);
        
        gpaPanel.add(errorLabel);

    }
    //BACK BUTTON
      JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "mainPanel");
            }
        });  
      gpaPanel.add(backButton);
    

    // Add the GPA panel to the card panel
    cardPanel.add(gpaPanel, "gpaPanel");

    // Switch to the GPA panel
    cardLayout.show(cardPanel, "gpaPanel");


    return gpaPanel;
}  
private static boolean isFileValid() {
    File file = new File("java34_output.txt");
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        long lineCount = br.lines().count();
        // Check if the file has at least 5 lines (including header lines)
        return lineCount >= 5;
    } catch (IOException e) {
        return false;
    }
}



    //method for storing the marks from the file into an array
    public static String[][] arrayMarks() {
      String[][] finalMarks = null;
  
      try (BufferedReader br = new BufferedReader(new FileReader("java34_output.txt"))) {
          // Count the number of lines in the file
          long lineCount = br.lines().count();
  
          // Reset the BufferedReader to read from the beginning of the file
          br.close();
          BufferedReader rw = new BufferedReader(new FileReader("java34_output.txt"));
  
          // Adjust the size of the finalMarks array based on the line count
          finalMarks = new String[(int) lineCount - 2][6];
  
          // Skip first two lines
          rw.readLine();
          rw.readLine();
  
          int i = 0;
          String line;
  
          // Read each line from the file
          while ((line = rw.readLine()) != null && i < lineCount) {
              // Split the line into parts using either space or "|" as the separator
              String[] parts = line.split("\\|");
              for (int j = 0; j < 6; j++)
                  finalMarks[i][j] = parts[j];
              i++;
          }
  
          // Now finalMarks array contains the data from the file
      } catch (IOException e) {
          e.printStackTrace();
      }
  
      return finalMarks;
      
  }
    public static void GPAofsubjects(String[][] gpa,String[][]finalMarks) {
      for (int i = 0; i < finalMarks.length; i++)
            for (int j = 0; j < 6; j++) {
                if ((j == 0) || (j == 1))
                    gpa[i][j] = finalMarks[i][j];
                /*using integer.parseInt to convert string into an integer because
                otherwise an error was occuring as a string cant be compared to an integer
                */
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 85)
                    gpa[i][j] = "4.0";
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 80)
                    gpa[i][j] = "3.66";
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 75)
                    gpa[i][j] = "3.33";
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 71)
                    gpa[i][j] = "3.00";
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 68)
                    gpa[i][j] = "2.66";
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 64)
                    gpa[i][j] = "2.33";
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 61)
                    gpa[i][j] = "2.00";
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 58)
                    gpa[i][j] = "1.66";
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 54)
                    gpa[i][j] = "1.30";
                else if (Integer.parseInt(finalMarks[i][j].trim()) >= 50)
                    gpa[i][j] = "1.00";
                else
                    gpa[i][j] = "0.00";
            }           
              
    }
    //FUNCTION CALCULATING CGPA
    public static void calculateGPA(String[][]gpa){
      for (int i = 0; i < gpa.length; i++) {
        double gradepoints = 0; // Changed the data type to double
        for (int j = 2; j < 6; j++) // Changed the loop start index to 2
            gradepoints = gradepoints + (Double.parseDouble(gpa[i][j]) * 4); // Changed to Double.parseDouble()
            gpa[i][6] = Double.toString(gradepoints / 16);
            
      }
      writeinfile(gpa);
    }
    //FUNCTION WRITING GPA AND CGPA IN FILE 
    public static void writeinfile(String[][]gpa){ 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("GPA.txt", true))) {
            for (int i = 0; i < gpa.length; i++) {
                for (int j = 0; j <= 6; j++) {
                    String modifiedLine = String.format("%-5s", gpa[i][j] + ",");
                    writer.write(modifiedLine);
                }
                // Add a newline after each row
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       }
    //PROCESSING FOR OPTION 3 ENDS
    
    //-------------------------------------PROCESSING FOR OPTION 4 STARTS----------------------------------------
    // FUNCTION CALLING NEW PANEL FOR OPTION 4
    private static void openNewPanel4() {
        JPanel newPanel = studentgpaPanel();
        cardPanel.add(newPanel, "newPanel");
        cardLayout.show(cardPanel, "newPanel");
    }
    //Panel to display student gpa
    private static JPanel studentgpaPanel() {
        JPanel gpapanel = new JPanel(new BorderLayout());
        
        // Read data from file and create a table
        String filePath = "gpa.txt"; // Replace with your file path
        JTable table = tableofgpa(filePath);
        
        // Add a back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "mainPanel");
            }
        });
    
        // Create a panel to hold the table and back button
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
        tablePanel.add(backButton, BorderLayout.SOUTH);
    
        gpapanel.add(tablePanel, BorderLayout.CENTER);
    
        return gpapanel;
        
    }
    private static JTable tableofgpa(String filePath) {
        String[] columnNames = {"Name", "RollNo.", "PF", "DLD","FOM","CS","CGPA"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return new JTable(model);
    }
   //PROCESSING FOR OPTION 4 ENDS
    
}