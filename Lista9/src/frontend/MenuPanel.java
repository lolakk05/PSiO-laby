package frontend;

import backend.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends javax.swing.JPanel {
    private MainFrame mainFrame;
    private Service backend;

    public MenuPanel(MainFrame mainFrame,  Service backend) {
        this.mainFrame = mainFrame;
        this.backend = backend;

        setLayout(new GridBagLayout());

        JPanel menuPanel  = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 2, 10, 10));

        JButton showAll = new JButton("Pokaż wszystkich");
        showAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("ALL");
            }
        });
        menuPanel.add(showAll);

        JButton addStudent = new JButton("Dodaj studenta");
        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("ADD_STUDENT");
            }
        });
        menuPanel.add(addStudent);

        JButton addWorker = new JButton("Dodaj pracownika uczelni");
        addWorker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("ADD_WORKER");
            }
        });
        menuPanel.add(addWorker);

        JButton addLecturer = new JButton("Dodaj wykładowce");
        addLecturer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("ADD_LECTURER");
            }
        });
        menuPanel.add(addLecturer);

        JButton buttonSearch = new JButton("Wyszukiwanie");
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("SEARCH");
            }
        });
        menuPanel.add(buttonSearch);

        JButton strategyMode =  new JButton("Zmień strategie");
        strategyMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backend.zmianaStrategii();
                if(backend.getActiveStrategy() == 1) {
                    JOptionPane.showMessageDialog(mainFrame, "Strategia domyślna");
                }
                else {
                    JOptionPane.showMessageDialog(mainFrame, "Strategia zaawansowana");
                }
            }
        });
        menuPanel.add(strategyMode);

        add(menuPanel);
    }
}
