package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Film;

public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();

	public void insert(Actor actor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ACTOR (cod,name,yearOfBirthDate)" + "VALUES (?, ?, ?)");
			preparedStatement.setInt(1, actor.getCod());
			preparedStatement.setString(2, actor.getNombre());
			preparedStatement.setInt(2, actor.getYear());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public void insert(Film film) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Film (tittle)" + "VALUES (?)");
			preparedStatement.setString(1, film.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public void insert(Director director) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO DIRECTOR (cod, name)" + "VALUES (?, ?)");
			preparedStatement.setInt(1, director.getCod());
			preparedStatement.setString(2, director.getNombre());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public void delete(Actor actor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM ACTOR WHERE cod=?");
			preparedStatement.setInt(1, actor.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public void delete(Director actor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM DIRECTOR WHERE cod=?");
			preparedStatement.setInt(1, actor.getCod());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<Actor> selectAllActor() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Actor> list = new ArrayList<Actor>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM ACTOR");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Actor actor = new Actor();
				actor.setCod(resultSet.getInt(0));
				actor.setNombre(resultSet.getNString(0));
				actor.setYear(resultSet.getInt(2));
				list.add(actor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}

	public List<Director> selectAllDirector() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		List<Director> list = new ArrayList<Director>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM DIRECTOR");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Director director = new Director();
				director.setCod(resultSet.getInt(0));
				director.setNombre(resultSet.getNString(0));
				list.add(director);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}

	public List<Film> selectAllPelicula() {
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
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return list;
	}

}
