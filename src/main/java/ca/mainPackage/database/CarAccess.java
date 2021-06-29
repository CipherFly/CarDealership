package ca.mainPackage.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.mainPackage.beans.Car;


@Repository
public class CarAccess {
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void addCar(Car car) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "INSERT INTO car_list (make, car_model, colour, price, vin, dealership) "
				+ "VALUES (:make, :carModel, :colour, :price, :vin, :dealership)";
		parameters.addValue("make", car.getMake());
		parameters.addValue("carModel", car.getCarModel());
		parameters.addValue("colour", car.getColour());
		parameters.addValue("price", car.getPrice());
		parameters.addValue("vin", car.getVin());
		parameters.addValue("dealership", car.getDealership());
		
		jdbc.update(query, parameters);
	}
	
	public ArrayList<Car> getCars(){
		ArrayList<Car> cars = new ArrayList<Car>();
		String query = "SELECT * FROM CAR_LIST";
		List<Map<String,Object>> rows = jdbc.queryForList(query, new HashMap<String, Object>());
		
		for(Map<String,Object> row: rows) {
			Car c = new Car();
			c.setId((Integer)row.get("id"));
			c.setMake((String)row.get("make"));
			c.setCarModel((String)row.get("car_model"));
			c.setColour((String)row.get("colour"));
			c.setPrice(((BigDecimal)row.get("price")).doubleValue());
			c.setVin((Integer)row.get("vin"));
			c.setDealership((String)row.get("dealership"));
			cars.add(c);
		}
		
		return cars;
	}
	
	public Car getCarById(int id){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		ArrayList<Car> cars = new ArrayList<Car>();
		String query = "SELECT * FROM CAR_LIST WHERE ID=:id";
		parameters.addValue("id", id);
		List<Map<String,Object>> rows = jdbc.queryForList(query, parameters);
		
		for(Map<String,Object> row: rows) {
			Car c = new Car();
			c.setId((Integer)row.get("id"));
			c.setMake((String)row.get("make"));
			c.setCarModel((String)row.get("car_model"));
			c.setColour((String)row.get("colour"));
			c.setPrice(((BigDecimal)row.get("price")).doubleValue());
			c.setVin((Integer)row.get("vin"));
			c.setDealership((String)row.get("dealership"));
			cars.add(c);
		}
		
		if (cars.size()>0) {
			return cars.get(0);
		}
		else {
			return null;
		}
	}
	
	public void editCar(Car car) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "UPDATE car_list SET make=:make, car_model=:carModel, colour=:colour, price=:price, vin=:vin, dealership=:dealership"
				+ " WHERE id=:id";
		parameters.addValue("make", car.getMake());
		parameters.addValue("carModel", car.getCarModel());
		parameters.addValue("colour", car.getColour());
		parameters.addValue("price", car.getPrice());
		parameters.addValue("vin", car.getVin());
		parameters.addValue("dealership", car.getDealership());
		parameters.addValue("id", car.getId());
		
		jdbc.update(query, parameters);
	}
	
	public void deleteCar(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "DELETE FROM car_list WHERE id=:id";
		parameters.addValue("id", id);
		
		jdbc.update(query, parameters);
	}
	
	public ArrayList<Car> getCarByMake(String make){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		ArrayList<Car> cars = new ArrayList<Car>();
		String query = "SELECT * FROM CAR_LIST WHERE make=:make";
		parameters.addValue("make", make);
		List<Map<String,Object>> rows = jdbc.queryForList(query, parameters);
		
		for(Map<String,Object> row: rows) {
			Car c = new Car();
			c.setId((Integer)row.get("id"));
			c.setMake((String)row.get("make"));
			c.setCarModel((String)row.get("car_model"));
			c.setColour((String)row.get("colour"));
			c.setPrice(((BigDecimal)row.get("price")).doubleValue());
			c.setVin((Integer)row.get("vin"));
			c.setDealership((String)row.get("dealership"));
			cars.add(c);
		}
		
		return cars;
	}
	
	public ArrayList<Car> getCarByModel(String carModel){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		ArrayList<Car> cars = new ArrayList<Car>();
		String query = "SELECT * FROM car_list WHERE car_model=:carModel";
		parameters.addValue("carModel", carModel);
		List<Map<String,Object>> rows = jdbc.queryForList(query, parameters);
		
		for(Map<String,Object> row: rows) {
			Car c = new Car();
			c.setId((Integer)row.get("id"));
			c.setMake((String)row.get("make"));
			c.setCarModel((String)row.get("car_model"));
			c.setColour((String)row.get("colour"));
			c.setPrice(((BigDecimal)row.get("price")).doubleValue());
			c.setVin((Integer)row.get("vin"));
			c.setDealership((String)row.get("dealership"));
			cars.add(c);
		}
		
		return cars;
	}
	
	public ArrayList<Car> getCarByPrice(double min, double max){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		ArrayList<Car> cars = new ArrayList<Car>();
		String query = "SELECT * FROM car_list WHERE price BETWEEN :min AND :max";
		parameters.addValue("min", min);
		parameters.addValue("max", max);
		List<Map<String,Object>> rows = jdbc.queryForList(query, parameters);
		
		for(Map<String,Object> row: rows) {
			Car c = new Car();
			c.setId((Integer)row.get("id"));
			c.setMake((String)row.get("make"));
			c.setCarModel((String)row.get("car_model"));
			c.setColour((String)row.get("colour"));
			c.setPrice(((BigDecimal)row.get("price")).doubleValue());
			c.setVin((Integer)row.get("vin"));
			c.setDealership((String)row.get("dealership"));
			cars.add(c);
		}
		
		return cars;
	}

}
