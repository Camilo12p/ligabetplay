package com.ligabetplay.city.Infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.ligabetplay.city.domain.entity.City;
import com.ligabetplay.city.domain.service.CityService;

public class CityRepository implements CityService {
    private Connection connection;

    public CityRepository(){
        
        try{
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url= properties.getProperty("url");
            String user= properties.getProperty("user");
            String password= properties.getProperty("password");
            connection = DriverManager.getConnection(url,user,password);

        }catch(Exception e){
            e.printStackTrace();	
        }
    }

    @Override
    public void createCity(City city) {
        String query = "INSERT INTO city (id,nombre,idCiudad) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement =  connection.prepareStatement(query);
            preparedStatement.setString(1, city.getId());
            preparedStatement.setString(2, city.getNombre());
            preparedStatement.setInt(3, city.getIdRegion());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void updateCity(City city) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCity'");
    }

    @Override
    public Optional<City> findCityById(String id) {
        
        try{
            String query = "SELECT id,nombre,idciudad FROM city WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){    
                return Optional.of( new City(rs.getString("id"),
                rs.getString("nombre"),
                rs.getInt("idCiudad")));                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<City> findAllCities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllCities'");
    }

}
