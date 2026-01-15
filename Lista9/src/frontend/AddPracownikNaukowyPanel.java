package frontend;

import backend.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPracownikNaukowyPanel extends JPanel {
    private MainFrame mainFrame;
    private Service backend;

    // Pola tekstowe w języku angielskim
    JTextField name, surname, email, age, pesel, role, title, achievement, faculty, department;

    public AddPracownikNaukowyPanel(MainFrame mainFrame, Service backend) {
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

        form.add(new JLabel("Tytuł:"));
        title = new JTextField(15);
        form.add(title);

        form.add(new JLabel("Dorobek (liczba):"));
        achievement = new JTextField(15);
        form.add(achievement);

        form.add(new JLabel("Wydział:"));
        faculty = new JTextField(15);
        form.add(faculty);

        form.add(new JLabel("Katedra:"));
        department = new JTextField(15);
        form.add(department);

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
                saveScientist();
            }
        });
        form.add(addButton);

        add(form);
    }

    private void saveScientist() {
        try {
            String nameValue = name.getText();
            String surnameValue = surname.getText();
            String emailValue = email.getText();
            String ageValue = age.getText();
            String peselValue = pesel.getText();
            String roleValue = role.getText();
            String titleValue = title.getText();
            String achievementValue = achievement.getText();
            String facultyValue = faculty.getText();
            String departmentValue = department.getText();


            int ageInt = Integer.parseInt(ageValue);
            int achievementInt = Integer.parseInt(achievementValue);

            backend.dodajPracownikaNaukowego(nameValue, surnameValue, emailValue, ageInt, peselValue, roleValue, titleValue, achievementInt, facultyValue, departmentValue);

            JOptionPane.showMessageDialog(mainFrame, "Dodano pracownika naukowego");
            clear();
        }
        catch( NumberFormatException e ) {
            JOptionPane.showMessageDialog(this, "Pola 'Wiek' i 'Dorobek' muszą być liczbami");
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
        title.setText("");
        achievement.setText("");
        faculty.setText("");
        department.setText("");
    }
}