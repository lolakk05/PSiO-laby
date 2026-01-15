package frontend;


import backend.Kursy;
import backend.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddStudentPanel extends JPanel {
    private MainFrame mainFrame;
    private Service backend;

    JTextField name, surname, email, age, pesel, degree, index, howMany;

    public AddStudentPanel(MainFrame mainFrame, Service backend) {
        this.mainFrame = mainFrame;
        this.backend = backend;



        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0, 2, 10, 10));

        form.add(new JLabel("Imię:"));
        name =  new JTextField(15);
        form.add(name);

        form.add(new JLabel("Nazwisko:"));
        surname =  new JTextField(15);
        form.add(surname);

        form.add(new JLabel("Email:"));
        email =  new JTextField(15);
        form.add(email);

        form.add(new JLabel("Wiek:"));
        age =  new JTextField(15);
        form.add(age);

        form.add(new JLabel("Pesel:"));
        pesel =  new JTextField(15);
        form.add(pesel);

        form.add(new JLabel("Kierunek:"));
        degree =  new JTextField(15);
        form.add(degree);

        form.add(new JLabel("Indeks:"));
        index =  new JTextField(15);
        form.add(index);

        form.add(new JLabel("Ile kursów:"));
        howMany =  new JTextField(15);
        form.add(howMany);

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
                saveStudent();
            }
        });
        form.add(addButton);

        add(form);
    }

    private void saveStudent() {
        try {
            String nameValue = name.getText();
            String surnameValue = surname.getText();
            String emailValue = email.getText();
            String ageValue = age.getText();
            String peselValue = pesel.getText();
            String degreeValue = degree.getText();
            String indexValue = index.getText();
            String howManyValue = howMany.getText();

            int age = Integer.parseInt(ageValue);
            int index = Integer.parseInt(indexValue);

            ArrayList<Kursy> courses = new ArrayList<>();

            if(Integer.parseInt(howManyValue) > 0) {
                for(int i = 0; i< Integer.parseInt(howManyValue) ; i++) {
                    String courseName = JOptionPane.showInputDialog(this,"Nazwa:");
                    String ects = JOptionPane.showInputDialog(this, "ECTS");
                    String evaluation = JOptionPane.showInputDialog(this, "Ocena:");
                    courses.add(new Kursy(courseName, Integer.valueOf(ects), Integer.valueOf(evaluation)));
                }
            }

            backend.dodajStudenta(nameValue, surnameValue, emailValue, age, peselValue, degreeValue, index, courses);
            JOptionPane.showMessageDialog(mainFrame, "Dodano studenta");
            clear();
        }
        catch( NumberFormatException e ) {
            JOptionPane.showMessageDialog(this, "Pola wiek i index muszą być liczbami");
        }
        catch( Exception e ) {
            JOptionPane.showMessageDialog(this, "Błąd");
        }
    }

    public void clear() {
        name.setText("");
        surname.setText("");
        email.setText("");
        age.setText("");
        pesel.setText("");
        degree.setText("");
        index.setText("");
        howMany.setText("");
    }
}
