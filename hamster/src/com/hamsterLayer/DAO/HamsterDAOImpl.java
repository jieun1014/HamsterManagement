package com.hamsterLayer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.hamster.hamster.Hamster;

public class HamsterDAOImpl implements HamsterDAO {

	@Override
	public void insert(Hamster hamster) {
		String sql = "INSERT INTO HAMSTER VALUES(hamster_Info_seq.nextval, ?, ?, ?, ?, ?, ?)";

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			InitialContext ic = new InitialContext();

			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/mybatis");

			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, hamster.getName());
			preparedStatement.setString(2, hamster.getGender());
			preparedStatement.setString(3, hamster.getSpecies());
			preparedStatement.setString(4, hamster.getBirth_date());
			preparedStatement.setString(5, hamster.getColor());
			preparedStatement.setString(6, hamster.getStatus());

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {

			}
		}
	}

	@Override
	public List<Hamster> selectAll() {
		List<Hamster> hamsters = new ArrayList<Hamster>();

		String sql = "select no, name, decode(species, 'G', '시리아 햄스터', 'W', '윈터화이트', 'K', '캠밸', 'R', '로브로브 스키', 'C', '차이니즈') as species from hamster";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			InitialContext ic = new InitialContext();

			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/mybatis");

			connection = ds.getConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Hamster hamster = new Hamster(resultSet.getInt("no"), resultSet.getString("name"),
						resultSet.getString("species"));

				hamsters.add(hamster);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}

				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hamsters;
	}

	@Override
	public Hamster select(int hamsterNo) {
		Hamster hamster = null;

		String sql = "SELECT NO, NAME, " 
				+ "DECODE(GENDER, 'M', '수컷', 'F', '암컷') AS GENDER, "
				+ "DECODE(SPECIES, 'G', '시리아 햄스터', 'W', '윈터 화이트', 'K', '캠밸', 'R', '로브로브 스키', 'C', '차이니즈') AS SPECIES, "
				+ "BIRTH_DATE, COLOR, STATUS FROM HAMSTER WHERE NO = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/mybatis");
			connection = ds.getConnection();

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, hamsterNo);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int no = resultSet.getInt("NO");
				String name = resultSet.getString("NAME");
				String gender = resultSet.getString("GENDER");
				String species = resultSet.getString("SPECIES");
				String birth_date = resultSet.getString("BIRTH_DATE");
				String color = resultSet.getString("COLOR");
				String status = resultSet.getString("STATUS");

				hamster = new Hamster(no, name, gender, species, birth_date, color, status);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return hamster;
	}

	@Override
	public void update(Hamster hamster) {
		String sql = "UPDATE HAMSTER SET NAME = ?, GENDER = ?, SPECIES = ?, BIRTH_DATE = ?, COLOR = ?, STATUS = ? WHERE NO = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			InitialContext initialContext = new InitialContext();
			DataSource dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/mybatis");
			
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, hamster.getName());
			preparedStatement.setString(2, hamster.getGender());
			preparedStatement.setString(3, hamster.getSpecies());
			preparedStatement.setString(4, hamster.getBirth_date());
			preparedStatement.setString(5, hamster.getColor());
			preparedStatement.setString(6, hamster.getStatus());
			preparedStatement.setInt(7, hamster.getNo());
			
			int resultCount = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(int no) {
		String sql = "DELETE FROM HAMSTER WHERE NO = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			InitialContext initialContext = new InitialContext();
			DataSource dataSource = (DataSource)initialContext.lookup("java:comp/env/jdbc/mybatis");
			connection = dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, no);
			
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
