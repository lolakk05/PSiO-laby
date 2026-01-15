package frontend;

import backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

public class DisplayAllPeoplePanel extends JPanel implements Observer {
    private MainFrame mainFrame;
    private JPanel list;

    private Service backend;

    public DisplayAllPeoplePanel(MainFrame mainFrame, Service backend) {
        this.mainFrame = mainFrame;
        this.backend = backend;

        this.backend.addObserver(this);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(0, 0));
        topPanel.add(new JLabel("Lista osób: "),  BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton sortNameButton = new JButton("Sortuj: Nazwisko");
        sortNameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backend.ustawSortowanie(new SortowanieNazwisko());
            }
        });
        buttonPanel.add(sortNameButton);

        JButton sortSalaryButton = new JButton("Sortuj: Płaca");
        sortSalaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backend.ustawSortowanie(new SortowaniePlaca());
            }
        });
        buttonPanel.add(sortSalaryButton);

        JButton returnButton = new JButton("Powrót");
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("MENU");
            }
        });
        buttonPanel.add(returnButton);

        topPanel.add(buttonPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void displayPeople() {
        list.removeAll();

        ArrayList<Osoba> result = backend.wyswietlWszystkich();


        for(Osoba person : result) {
            JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
            row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));

            JLabel label = new JLabel(person.toString());
            row.add(label);

            list.add(row);
        }

        list.revalidate();
        list.repaint();

    }

    @Override
    public void update() {
        System.out.println("Panel odebrał powiadomienie, aktualizacja listy");
        displayPeople();
    }
}
