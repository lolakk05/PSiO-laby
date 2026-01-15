package frontend;

import backend.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPracownikUczelniPanel extends JPanel {
    private MainFrame mainFrame;
    private Service backend;

    JTextField name, surname, email, age, pesel, role, position, etat;

    public AddPracownikUczelniPanel(MainFrame mainFrame, Service backend) {
        this.mainFrame = mainFrame;
        this.backend = backend;

        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0, 2, 10, 10));

        form.add(new JLabel("Imię:"));
        name = new JTextField(15);
        form.add(name);

        form.add(new JLabel("Nazwisko:"));
        surname = new JTextField(15);
        form.add(surname);

        form.add(new JLabel("Email:"));
        email = new JTextField(15);
        form.add(email);

        form.add(new JLabel("Wiek:"));
        age = new JTextField(15);
        form.add(age);

        form.add(new JLabel("Pesel:"));
        pesel = new JTextField(15);
        form.add(pesel);

        form.add(new JLabel("Rola:"));
        role = new JTextField(15);
        form.add(role);

        form.add(new JLabel("Stanowisko:"));
        position = new JTextField(15);
        form.add(position);

        form.add(new JLabel("Etat:"));
        etat = new JTextField(15);
        form.add(etat);

        JButton returnButton = new JButton("Powrót");
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.changeCard("MENU");
            }
        });
        form.add(returnButton);

        JButton addButton = new JButton("Dodaj");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveWorker();
            }
        });
        form.add(addButton);

        add(form);
    }

    private void saveWorker() {
        try {
            String nameValue = name.getText();
            String surnameValue = surname.getText();
            String emailValue = email.getText();
            String ageValue = age.getText();
            String peselValue = pesel.getText();
            String roleValue = role.getText();
            String positionValue = position.getText();
            String etatValue = etat.getText();

            int ageInt = Integer.parseInt(ageValue);

            backend.dodajPracownikaUczelni(nameValue, surnameValue, emailValue, ageInt, peselValue, roleValue, positionValue, etatValue);

            JOptionPane.showMessageDialog(mainFrame, "Dodano pracownika uczelni");
            clear();
        }
        catch( NumberFormatException e ) {
            JOptionPane.showMessageDialog(this, "Pole wiek musi być liczbą");
        }
        catch( Exception e ) {
            JOptionPane.showMessageDialog(this, "Błąd: " + e.getMessage());
        }
    }

    public void clear() {
        name.setText("");
        surname.setText("");
        email.setText("");
        age.setText("");
        pesel.setText("");
        role.setText("");
        position.setText("");
        etat.setText("");
    }
}