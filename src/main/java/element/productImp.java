package element;

import java.lang.annotation.Retention;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conn;
import dao.IDAO;
import entity.Product;

public class productImp implements IDAO<Integer, Product> {
	private Connection connect = Conn.getConnection();

	@Override
	public List<Product> getAll() {
		String sql = "select * from product";
		List<Product> list = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				float price = resultSet.getFloat("price");
				float sale_price = resultSet.getFloat("sale_price");
				String description = resultSet.getString("description");
				boolean status = resultSet.getBoolean("status");
				list.add(new Product(id, name, price, sale_price, description, status));

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean add(Product object) {
		// TODO Auto-generated method stub
		String query = "insert into product values(?,?,?,?,?)";
		try {

			PreparedStatement preparedStatement = connect.prepareStatement(query);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setFloat(2, object.getPrice());
			preparedStatement.setFloat(3, object.getSale_price());
			preparedStatement.setString(4, object.getDescription());
			preparedStatement.setBoolean(5, object.isStatus());
			int check = preparedStatement.executeUpdate();
			if (check > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean edit(Integer id, Product object) {
		String query = "update product set name=?,price = ?,sale_price=?,description=?,status =? where id =?";
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(query);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setFloat(2, object.getPrice());
			preparedStatement.setFloat(3, object.getSale_price());
			preparedStatement.setString(4, object.getDescription());
			preparedStatement.setBoolean(5, object.isStatus());
			preparedStatement.setInt(6, id);
			int check = preparedStatement.executeUpdate();
			if (check > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		String query = "delete from product where id =?";
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int check = preparedStatement.executeUpdate();
			if (check > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Product find_by_id(Integer id) {
			String query = "select * from product where id=?";
			
			try {
				PreparedStatement preparedStatement = connect.prepareStatement(query);
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				resultSet.next();
				String name = resultSet.getString("name");
				float price = resultSet.getFloat("price");
				float sale_price = resultSet.getFloat("sale_price");
				String description = resultSet.getString("description");
				boolean status = resultSet.getBoolean("status");
				Product product = new Product(id, name, price, sale_price, description, status);
				return product;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return null;
	}

}
