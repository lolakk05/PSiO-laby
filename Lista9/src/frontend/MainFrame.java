package frontend;

import backend.Main;
import backend.Service;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends javax.swing.JFrame {
    private CardLayout layout;
    private JPanel cards;

    private Service backend;

    private DisplayAllPeoplePanel displayAllPeoplePanel;
    private MenuPanel menuPanel;
    private AddStudentPanel addStudentPanel;
    private AddPracownikUczelniPanel addPracownikUczelniPanel;
    private AddPracownikNaukowyPanel addPracownikNaukowyPanel;
    private SearchPanel searchPanel;


    public MainFrame() {
        this.backend = new Service();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);

        layout = new CardLayout();
        cards = new JPanel(layout);

        menuPanel = new MenuPanel(this, backend);
        displayAllPeoplePanel = new DisplayAllPeoplePanel(this, backend);
        addStudentPanel = new AddStudentPanel(this, backend);
        addPracownikUczelniPanel = new AddPracownikUczelniPanel(this, backend);
        addPracownikNaukowyPanel = new AddPracownikNaukowyPanel(this, backend);
        searchPanel = new SearchPanel(this, backend);

        displayAllPeoplePanel.displayPeople();

        cards.add(menuPanel, "MENU");
        cards.add(displayAllPeoplePanel, "ALL");
        cards.add(addStudentPanel, "ADD_STUDENT");
        cards.add(addPracownikUczelniPanel, "ADD_WORKER");
        cards.add(addPracownikNaukowyPanel, "ADD_LECTURER");
        cards.add(searchPanel, "SEARCH");

        add(cards);

        layout.show(cards, "MENU");

        setVisible(true);

    }

    public void changeCard(String cardName) {
        layout.show(cards, cardName);
    }
}
