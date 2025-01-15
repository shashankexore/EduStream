import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EduStreamApp extends JFrame 
{
    private static final String[] classroomCodes = {"APP", "DSA", "COA", "OS", "DTM", "TBVP"};
    private static final String UPLOAD_DIR = "uploads";
    private JComboBox<String> classroomCodeDropdown;
    private JTextArea uploadedFilesArea;

    public EduStreamApp() 
    {
        setTitle("Edu-Stream: E-Learning Platform");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Menu
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton teacherButton = new JButton("Teacher Login");
        JButton studentButton = new JButton("Student Login");
        JButton adminButton = new JButton("Admin Login");

        // Set button heights to fill the panel
        Dimension buttonSize = new Dimension(200, 100);
        teacherButton.setPreferredSize(buttonSize);
        studentButton.setPreferredSize(buttonSize);
        adminButton.setPreferredSize(buttonSize);

        teacherButton.addActionListener(e -> showTeacherMenu());
        studentButton.addActionListener(e -> showStudentMenu());
        adminButton.addActionListener(e -> showAdminMenu());

        mainMenuPanel.add(teacherButton);
        mainMenuPanel.add(studentButton);
        mainMenuPanel.add(adminButton);
        add(mainMenuPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void showTeacherMenu() 
    {
        JFrame teacherFrame = new JFrame("Teacher Panel");
        teacherFrame.setSize(400, 300);
        teacherFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel teacherPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        classroomCodeDropdown = new JComboBox<>(classroomCodes);

        JButton uploadButton = new JButton("Upload Content");
        JButton startCallButton = new JButton("Start Video Call");
        JButton uploadAndCallButton = new JButton("Upload Content and Start Video Call");

        uploadButton.addActionListener(e -> uploadContent());
        startCallButton.addActionListener(e -> startVideoCall());
        uploadAndCallButton.addActionListener(e -> 
        {
            uploadContent();
            startVideoCall();
        });

        teacherPanel.add(classroomCodeDropdown);
        teacherPanel.add(uploadButton);
        teacherPanel.add(startCallButton);
        teacherPanel.add(uploadAndCallButton);

        teacherFrame.add(teacherPanel);
        teacherFrame.setVisible(true);
    }

    // Student Menu
    private void showStudentMenu() 
    {
        JFrame studentFrame = new JFrame("Student Panel");
        studentFrame.setSize(400, 300);
        studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel studentPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        classroomCodeDropdown = new JComboBox<>(classroomCodes);

        JButton viewFilesButton = new JButton("View Uploaded Content");
        JButton joinCallButton = new JButton("Join Video Call");

        viewFilesButton.addActionListener(e -> listUploadedFiles());
        joinCallButton.addActionListener(e -> startVideoCall());

        studentPanel.add(classroomCodeDropdown);
        studentPanel.add(viewFilesButton);
        studentPanel.add(joinCallButton);

        studentFrame.add(studentPanel);
        studentFrame.setVisible(true);
    }

    // Admin Menu
    private void showAdminMenu() 
    {
        JFrame adminFrame = new JFrame("Admin Panel");
        adminFrame.setSize(400, 300);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel adminPanel = new JPanel(new GridLayout(4, 1));
        
        JLabel adminLabel = new JLabel("Admin controls will be implemented here.");
        adminPanel.add(adminLabel);
        
        adminFrame.add(adminPanel);
        adminFrame.setVisible(true);
    }

    // Upload content method
    private void uploadContent() 
    {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) 
        {
            File file = fileChooser.getSelectedFile();
            
            if (!new File(UPLOAD_DIR).exists()) 
            {
                new File(UPLOAD_DIR).mkdir();
            }
            
            File dest = new File(UPLOAD_DIR, file.getName());
            
            if (file.renameTo(dest)) 
            {
                JOptionPane.showMessageDialog(this, "Uploaded: " + dest.getAbsolutePath());
            } 
            
            else 
            {
                JOptionPane.showMessageDialog(this, "Failed to upload the file.");
            }
        }
    }

    // Start video call by opening the default web browser with a classroom URL
    private void startVideoCall() 
    {
        String classroomCode = (String) classroomCodeDropdown.getSelectedItem();
        
        if (classroomCode != null) 
        {
            try 
            {
                Desktop.getDesktop().browse(new java.net.URI("https://meet.jit.si/" + classroomCode));
                JOptionPane.showMessageDialog(this, "Starting video call for code: " + classroomCode);
            }
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(this, "Error starting video call: " + ex.getMessage());
            }
        } 
        
        else 
        {
            JOptionPane.showMessageDialog(this, "Please select a classroom code.");
        }
    }

    // List uploaded files for the student
    private void listUploadedFiles() 
    {
        if (uploadedFilesArea == null) 
        {
            uploadedFilesArea = new JTextArea(10, 30);
            uploadedFilesArea.setEditable(false);
        }

        JFrame contentFrame = new JFrame("Uploaded Content");
        contentFrame.setSize(400, 300);
        contentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        File uploadDir = new File(UPLOAD_DIR);
        File[] files = uploadDir.listFiles();
        
        if (files != null && files.length > 0) 
        {
            uploadedFilesArea.setText("");
            
            for (int i = 0; i < files.length; i++) 
            {
                uploadedFilesArea.append((i + 1) + ". " + files[i].getName() + "\n");
            }
            
        } 
        
        else 
        {
            uploadedFilesArea.setText("No files uploaded.");
        }

        contentFrame.add(new JScrollPane(uploadedFilesArea));
        contentFrame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(EduStreamApp::new);
    }
}