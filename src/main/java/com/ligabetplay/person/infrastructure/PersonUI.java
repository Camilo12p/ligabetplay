package com.ligabetplay.person.infrastructure;

import java.util.Optional;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ligabetplay.person.application.CreatePersonUseCase;
import com.ligabetplay.person.application.FindPersonByIdUseCase;
import com.ligabetplay.person.domain.entity.Person;

public class PersonUI {
    private CreatePersonUseCase createPersonUseCase;
    private FindPersonByIdUseCase findByIdUseCase;


    public PersonUI (CreatePersonUseCase createPersonUseCase, 
    FindPersonByIdUseCase findByIdCase){
       this.createPersonUseCase = createPersonUseCase;
       this.findByIdUseCase = findByIdCase; 
    }
    public void crear(){
        Person person = new Person();
        person.setId(JOptionPane.showInputDialog(null,"Ingresa el id"));
        person.setNombre(JOptionPane.showInputDialog(null,"Ingresa el nombre"));
        person.setApellido(JOptionPane.showInputDialog(null,"Ingresa el apellido"));
        person.setEdad(Integer.valueOf(JOptionPane.showInputDialog(null,"Ingresa la edad")));
        person.setEmail(JOptionPane.showInputDialog(null,"Ingresa el email"));
        person.setIdciudad(Integer.valueOf(JOptionPane.showInputDialog(null,"Ingrese el id de la ciudad")));

        createPersonUseCase.execute(person);
    }

    public Optional<Person> findPersonById(){
        String id = JOptionPane.showInputDialog(null,"Ingrese el id a buscar");
        return findByIdUseCase.execute(id);
    }




    ///////////// Grafico interfaz
    public void frmRegPerson() {
        // Crear el JFrame
        JFrame frame = new JFrame("Registro de Personas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Crear el JPanel con BoxLayout para alineación vertical
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8)); // Espacio alrededor

        // Añadir componentes al topPanel
        JLabel lblId = new JLabel("Id Persona");
        lblId.setFont(new Font("Arial", Font.PLAIN, 18));
        lblId.setPreferredSize(new Dimension(100, 20));
        topPanel.add(lblId);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtId = new JTextField();
        txtId.setFont(new Font("Arial", Font.PLAIN, 18));
        txtId.setPreferredSize(new Dimension(250, 40));
        txtId.setMaximumSize(new Dimension(250, 40));
        topPanel.add(txtId);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        // Añadir componentes al topPanel
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 18));
        lblNombre.setPreferredSize(new Dimension(100, 20));
        lblNombre.setMaximumSize(new Dimension(450, 40));
        topPanel.add(lblNombre);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtNombre = new JTextField();
        txtNombre.setFont(new Font("Gadugi", Font.PLAIN, 18));
        txtNombre.setPreferredSize(new Dimension(450, 40));
        topPanel.add(txtNombre);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setFont(new Font("Arial", Font.PLAIN, 18));
        lblApellidos.setPreferredSize(new Dimension(100, 20));
        lblApellidos.setMaximumSize(new Dimension(450, 40));
        topPanel.add(lblApellidos);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtApellidos = new JTextField();
        txtApellidos.setFont(new Font("Arial", Font.PLAIN, 18));
        txtApellidos.setPreferredSize(new Dimension(450, 40));
        // txtApellidos.setMaximumSize(new Dimension(450, 40));
        topPanel.add(txtApellidos);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        JLabel lblEmail = new JLabel("Correo electronico");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        lblEmail.setPreferredSize(new Dimension(100, 20));
        lblEmail.setMaximumSize(new Dimension(450, 40));
        topPanel.add(lblEmail);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtEmail = new JTextField();
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 18));
        txtEmail.setPreferredSize(new Dimension(450, 40));
        // txtEmail.setMaximumSize(new Dimension(450, 40));
        topPanel.add(txtEmail);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        JLabel lblEdad = new JLabel("Edad de la persona");
        lblEdad.setFont(new Font("Arial", Font.PLAIN, 18));
        lblEdad.setPreferredSize(new Dimension(100, 20));
        lblEdad.setMaximumSize(new Dimension(450, 40));
        topPanel.add(lblEdad);
        topPanel.add(Box.createRigidArea(new Dimension(0, 2))); // Espacio vertical

        JTextField txtEdad = new JTextField();
        txtEdad.setFont(new Font("Arial", Font.PLAIN, 18));
        txtEdad.setPreferredSize(new Dimension(150, 40));
        txtEdad.setMaximumSize(new Dimension(150, 40));
        topPanel.add(txtEdad);
        topPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espacio vertical

        txtEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    JOptionPane.showMessageDialog(frame, "Campo solo numeros", "Error", JOptionPane.ERROR_MESSAGE);
                    e.consume(); // Ignorar la tecla no numérica
                }
            }
        });
        txtEdad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtEdad.getText().length() >= 2) {
                    JOptionPane.showMessageDialog(frame, "La edad no puede ser mayor a 99", "Error", JOptionPane.ERROR_MESSAGE);
                    e.consume(); // Ignorar la tecla si el límite se ha alcanzado
                }
            }
        });
        // Añadir el topPanel al JFrame en la posición NORTH
        frame.add(topPanel, BorderLayout.NORTH);
        // Crear el JPanel inferior con FlowLayout para los botones
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Crear los botones y añadirlos al bottomPanel
        JButton saveButton = new JButton("Guardar datos");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person person = new Person();
                person.setId(txtId.getText());
                person.setNombre(txtNombre.getText());
                person.setApellido(txtApellidos.getText());
                person.setEmail(txtEmail.getText());
                person.setEdad(Integer.parseInt(txtEdad.getText()));
                person.setIdciudad(1);
                createPersonUseCase.execute(person);
            }
        });

        JButton closeButton = new JButton("Cerrar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar el JFrame
            }
        });

        bottomPanel.add(saveButton);
        bottomPanel.add(closeButton);


        // Añadir el bottomPanel al JFrame en la posición SOUTH
        frame.add(bottomPanel, BorderLayout.SOUTH);
        // Centrar el JFrame en la pantalla
        frame.setLocationRelativeTo(null);
        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}
