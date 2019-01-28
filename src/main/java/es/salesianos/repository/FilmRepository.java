package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Film;

public class FilmRepository {
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	private static final Logger log = LogManager.getLogger(ActorRepository.class);
	AbstractConnection manager = new H2Connection();
	
	public void insert(Film film) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Film (tittle)" + "VALUES (?)");
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public void delete(Film film) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM Film WHERE cod=?");
			preparedStatement.setInt(1, film.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}
	
	public List<Film> selectAllFilms() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Film> list = new ArrayList<Film>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Film");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Film filmFromDatabase = new Film();
				filmFromDatabase.setCod(resultSet.getInt(1));
				filmFromDatabase.setTitle(resultSet.getString(2));
				filmFromDatabase.setCodDirector(resultSet.getInt(3));
				list.add(filmFromDatabase);
			}

		} catch (SQLException e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}


}
