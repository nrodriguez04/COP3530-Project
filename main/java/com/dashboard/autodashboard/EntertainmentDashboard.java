import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntertainmentDashboard extends JFrame {
    private JPanel mainPanel;

    private JButton carPlayButton;
    private JButton radioButton;
    private JButton bluetoothButton;
    private JButton phoneButton;

    public EntertainmentDashboard() {

        carPlayButton = new JButton("CarPlay");
        carPlayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(createCarPlayMenu());
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        radioButton = new JButton("Radio");
        radioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(createRadioMenu());
                mainPanel.revalidate();
                mainPanel.repaint();
        }
    });

        bluetoothButton = new JButton("Bluetooth");
        bluetoothButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(createBluetoothMenu());
                mainPanel.revalidate();
                mainPanel.repaint();
        }
    });

        phoneButton = new JButton("Phone");
        phoneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(createPhoneMenu());
                mainPanel.revalidate();
                mainPanel.repaint();
        }
    });

        mainPanel = new JPanel(new FlowLayout());
        mainPanel.add(carPlayButton);
        mainPanel.add(radioButton);
        mainPanel.add(bluetoothButton);
        mainPanel.add(phoneButton);

        setContentPane(mainPanel);

        setTitle("Entertainment Dashboard");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private JPanel createCarPlayMenu() {
        // CarPlay section
        JButton phoneButton = new JButton("Phone");
        JButton musicButton = new JButton("Music");
        JButton mapsButton = new JButton("Maps");
        JButton EntertainmentDashboardButton = new JButton("Dashboard");

        JPanel carPlayPanel = new JPanel(new FlowLayout());
        carPlayPanel.setBorder(BorderFactory.createTitledBorder("CarPlay"));
        carPlayPanel.add(phoneButton);
        carPlayPanel.add(musicButton);
        carPlayPanel.add(mapsButton);
        carPlayPanel.add(EntertainmentDashboardButton);

        EntertainmentDashboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(carPlayButton);
                mainPanel.add(radioButton);
                mainPanel.add(bluetoothButton);
                mainPanel.add(phoneButton);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        return carPlayPanel;
    }

    private JPanel createRadioMenu() {
        JButton freqButton = new JButton("AM/FM");
        JButton tuneButton = new JButton("Tune");
        JButton presetButton = new JButton("Preset");
        JButton scanButton = new JButton("Scan");
        JButton EntertainmentDashboardButton = new JButton("Dashboard");
    
        JPanel radioPanel = new JPanel(new FlowLayout());
        radioPanel.setBorder(BorderFactory.createTitledBorder("RADIO"));
        radioPanel.add(freqButton);
        radioPanel.add(tuneButton);
        radioPanel.add(presetButton);
        radioPanel.add(scanButton);
        radioPanel.add(EntertainmentDashboardButton);

        EntertainmentDashboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(carPlayButton);
                mainPanel.add(radioButton);
                mainPanel.add(bluetoothButton);
                mainPanel.add(phoneButton);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
    
        return radioPanel;
    }

    private JPanel createBluetoothMenu() {
        JButton musicButton = new JButton("Music");
        JButton phoneButton = new JButton("Phone");
        JButton EntertainmentDashboardButton = new JButton("Dashboard");
    
        JPanel bluetoothPanel = new JPanel(new FlowLayout());;
        bluetoothPanel.setBorder(BorderFactory.createTitledBorder("BLUETOOTH"));
        bluetoothPanel.add(musicButton);
        bluetoothPanel.add(phoneButton);
        bluetoothPanel.add(EntertainmentDashboardButton);

        EntertainmentDashboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(carPlayButton);
                mainPanel.add(radioButton);
                mainPanel.add(bluetoothButton);
                mainPanel.add(phoneButton);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
    
        return bluetoothPanel;
    }

    private JPanel createPhoneMenu() {
        JButton favButton = new JButton("Favorites");
        JButton recentButton = new JButton("Recent");
        JButton contactsButton = new JButton("Contacts");
        JButton keypadButton = new JButton("Keypad");
        JButton EntertainmentDashboardButton = new JButton("Dashboard");
    
        JPanel phonePanel = new JPanel(new FlowLayout());;
        phonePanel.setBorder(BorderFactory.createTitledBorder("PHONE"));
        phonePanel.add(favButton);
        phonePanel.add(recentButton);
        phonePanel.add(contactsButton);
        phonePanel.add(keypadButton);
        phonePanel.add(EntertainmentDashboardButton);

        keypadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a new panel with a GridLayout and add buttons for each number
                JPanel keypadPanel = new JPanel(new GridLayout(4, 3));
                for (int i = 1; i <= 9; i++) {
                    JButton button = new JButton(String.valueOf(i));
                    keypadPanel.add(button);
                }
                JButton zeroButton = new JButton("0");
                JButton clearButton = new JButton("Clear");
                JButton phoneReturn = new JButton ("Return");
                keypadPanel.add(zeroButton);
                keypadPanel.add(clearButton);
                keypadPanel.add(phoneReturn);
        
                phoneReturn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainPanel.removeAll();
                        mainPanel.add(createPhoneMenu());
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    }
                });
        
                mainPanel.removeAll();
                mainPanel.add(keypadPanel);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
    
        EntertainmentDashboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(carPlayButton);
                mainPanel.add(radioButton);
                mainPanel.add(bluetoothButton);
                mainPanel.add(phoneButton);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
    
        return phonePanel;
    }

    public static void main(String[] args) {
        new EntertainmentDashboard();
    }
}
