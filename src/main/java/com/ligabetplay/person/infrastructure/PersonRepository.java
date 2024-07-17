package com.ligabetplay.person.infrastructure;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.ligabetplay.person.domain.entity.Person;
import com.ligabetplay.person.domain.service.PersonService;

public class PersonRepository implements PersonService {
    private Connection connection;

    public PersonRepository(){
        try{
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void cratePerson(Person person) {
        
        try{
            String query = "INSERT INTO persona (id,nombre,apellido,edad,email,idciudad) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, person.getId());
            ps.setString(2, person.getNombre());    
            ps.setString(3, person.getApellido());    
            ps.setInt(4, person.getEdad());    
            ps.setString(5, person.getEmail());    
            ps.setInt(6, person.getIdciudad());    

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updatePerson(Person person) {
        String query = "UPDATE persona SET nombre = ?,apellid = ?, edad=?, email= ?, idciudad= ? WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, person.getNombre());
            ps.setString(2, person.getApellido());
            ps.setInt(3, person.getEdad());
            ps.setString(4, person.getEmail());
            ps.setInt(5, person.getIdciudad());
            ps.executeQuery();

        }catch (SQLException e){

        }

    }

    @Override
    public Optional<Person> deletePerson(String id) {
        try{
            String query = "DELETE FROM persona WHERE id = ? RETURNING id,nombre,apellido,edad,email,idciudad";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return Optional.of( new Person(rs.getString("id"),
                rs.getString("nombre"),rs.getString("apellido"),
                rs.getInt("edad"),rs.getString("email"),rs.getInt("idciudad")
                ));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Person> findPersonById(String id) {
        try{
           
            String query ="SELECT id,nombre,apellido,edad,email,idciudad FROM persona WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            
            
            try(ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    Person person =  new Person(rs.getString("id"),rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("edad"),
                    rs.getString("email"),
                    rs.getInt("idciudad"));
                    return Optional.of(person);    
                }
 
            }catch (SQLException e){
                e.printStackTrace();

            }  
            
        
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public List<Person> findAllPerson() {
       List<Person> personas = new ArrayList<>();
       try{
            String query = "SELECT id,nombre,apellido,edad,email,idcuidad FROM persona";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                personas.add(new Person(rs.getString("id"),rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getInt("edad"),
                rs.getString("email"),
                rs.getInt("idciudad")));
            }
            return personas;
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return personas;
    }



}
