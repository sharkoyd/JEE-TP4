package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.SingletonConnection;
import metier.entities.Game;
public class GameDaoImpl implements IGameDao {
@Override
public Game save(Game p) {
Connection conn=SingletonConnection.getConnection();
 try {
	PreparedStatement ps= conn.prepareStatement("INSERT INTO Game(name,type,age_rating) VALUES(?,?,?)");
	ps.setString(1, p.getNomGame());
	ps.setString(2, p.getType());
	ps.setString(3, p.getAgeRating());
	ps.executeUpdate();
	PreparedStatement ps2= conn.prepareStatement("SELECT MAX(id) as MAX_ID FROM Game");
	ResultSet rs =ps2.executeQuery();
	if (rs.next()) {
		p.setIdGame(rs.getLong("MAX_ID"));
	}
ps.close();
ps2.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public List<Game> GamesParMC(String mc) {
 List<Game> prods= new ArrayList<Game>();
 Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("select * from Game where name LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
Game p = new Game();
p.setIdGame(rs.getLong("id"));
p.setNomGame(rs.getString("name"));
p.setType(rs.getString("type"));
p.setAgeRating(rs.getString("age_rating"));
prods.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
}
return prods;
}
@Override
public Game getGame(Long id) {

 Connection conn=SingletonConnection.getConnection();
 Game p = new Game();
 try {
PreparedStatement ps= conn.prepareStatement("select * from Game where id = ?");
ps.setLong(1, id);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
p.setIdGame(rs.getLong("id"));
p.setNomGame(rs.getString("name"));
p.setType(rs.getString("type"));
p.setAgeRating(rs.getString("age_rating"));
}
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public Game updateGame(Game p) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("UPDATE Game SET name=?,type=?,age_rating=? WHERE id=?");
ps.setString(1, p.getNomGame());
ps.setString(2, p.getType());
ps.setString(3, p.getAgeRating());
ps.setLong(4, p.getIdGame());
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
@Override
public void deleteGame(Long id) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("DELETE FROM Game WHERE id = ?");
ps.setLong(1, id);
ps.executeUpdate();
ps.close();
} catch (SQLException e) {
e.printStackTrace();
}
}

	}