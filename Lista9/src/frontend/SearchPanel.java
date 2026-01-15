package frontend;

import backend.Osoba;
import backend.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchPanel extends JPanel {
    private MainFrame mainFrame;
    private Service backend;

    private JComboBox<String> searchTypeComboBox;
    private JTextField inputField;
    private JPanel resultListPanel;

    public SearchPanel(MainFrame mainFrame, Service backend) {
        this.mainFrame = mainFrame;
        this.backend = backend;

        setLayout(new BorderLayout());

        JPanel controlsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        controlsPanel.add(new JLabel("Szukaj po:"));


        String[] options = {"Nazwisko", "Indeks", "Dorobek (>)", "Stanowisko", "Średnia (>)"};
        searchTypeComboBox = new JComboBox<>(options);
        controlsPanel.add(searchTypeComboBox);

        controlsPanel.add(new JLabel("Wartość:"));
        inputField = new JTextField(15);
        controlsPanel.add(inputField);

        JButton searchButton = new JButton("Szukaj");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });
        controlsPanel.add(searchButton);

        JButton returnButton = new JButton("Powrót");
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("MENU");
            }
        });
        controlsPanel.add(returnButton);

        add(controlsPanel, BorderLayout.NORTH);

        resultListPanel = new JPanel();
        resultListPanel.setLayout(new BoxLayout(resultListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(resultListPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void performSearch() {
        String type = (String) searchTypeComboBox.getSelectedItem();
        String value = inputField.getText();
        ArrayList<Osoba> result = new ArrayList<>();

        try {
            if (type.equals("Nazwisko")) {
                result = backend.szukajPoNazwisku(value);
            }
            else if (type.equals("Indeks")) {
                int index = Integer.parseInt(value);
                result = backend.szukajPoIndeksie(index);
            }
            else if (type.equals("Dorobek (>)")) {
                int achievement = Integer.parseInt(value);
                result = backend.szukajPoDorobku(achievement);
            }
            else if (type.equals("Stanowisko")) {
                result = backend.szukajPoStanowisku(value);
            }
            else if (type.equals("Średnia (>)")) {
                double average = Double.parseDouble(value);
                result = backend.szukajPoSredniej(average);
            }
            displayResults(result);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Wystąpił błąd: " + e.getMessage());
        }
    }

    private void displayResults(ArrayList<Osoba> results) {
        resultListPanel.removeAll();

        if (results.isEmpty()) {
            resultListPanel.add(new JLabel("Brak wyników."));
        } else {
            for (Osoba person : results) {
                JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
                row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
                row.add(new JLabel(person.toString()));
                resultListPanel.add(row);
            }
        }

        resultListPanel.revalidate();
        resultListPanel.repaint();
    }
}