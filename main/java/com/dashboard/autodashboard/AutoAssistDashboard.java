import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AutoAssistDashboard extends JFrame implements ActionListener {

    private JToggleButton drivingAssistToggleButton;
    private JToggleButton headlightAssistToggleButton;
    private JLabel drivingAssistStatusLabel;
    private JLabel headlightAssistStatusLabel;

    private DrivingAssist drivingAssist;
    private Headlights headlights;

    private boolean drivingAssistActive = true;
    private boolean headlightsActive = true;

    public AutoAssistDashboard() {
        drivingAssist = new DrivingAssist();
        drivingAssist.deactivateDrivingAssist();
        headlights = new Headlights();
        headlights.deactivateHeadlightAssist();

        drivingAssistToggleButton = new JToggleButton("DRIVING ASSIST");
        drivingAssistToggleButton.addActionListener(this);
        drivingAssistStatusLabel = new JLabel("ACTIVATED");
        headlightAssistToggleButton = new JToggleButton("AUTO HEADLIGHTS");
        headlightAssistToggleButton.addActionListener(this);
        headlightAssistStatusLabel = new JLabel("ACTIVATED");

        drivingAssistToggleButton.setSelected(drivingAssistActive);
        headlightAssistToggleButton.setSelected(headlightsActive);

        setLayout(new GridLayout(2, 2));
        add(drivingAssistToggleButton);
        add(drivingAssistStatusLabel);
        add(headlightAssistToggleButton);
        add(headlightAssistStatusLabel);

        setTitle("Auto Assist Dashboard");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == drivingAssistToggleButton) {   
            drivingAssistActive = drivingAssistToggleButton.isSelected();
            if (drivingAssistActive) {
                drivingAssist.activateDrivingAssist();
                drivingAssistStatusLabel.setText("ACTIVATED");
            } 
            else {
                drivingAssist.deactivateDrivingAssist();
                drivingAssistStatusLabel.setText("DEACTIVATED");
            }
            setVisible(true);
        } 
        else if (e.getSource() == headlightAssistToggleButton) {
            headlightsActive = headlightAssistToggleButton.isSelected();
            if (headlightsActive) {
                headlights.activateHeadlightAssist();
                headlightAssistStatusLabel.setText("ACTIVATED");
            } 
            else {
                headlights.deactivateHeadlightAssist();
                headlightAssistStatusLabel.setText("DEACTIVATED");
            }
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AutoAssistDashboard();
    }
}
