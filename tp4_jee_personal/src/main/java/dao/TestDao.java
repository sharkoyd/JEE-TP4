package dao;
import java.util.List;
import metier.entities.Game;
public class TestDao {
public static void main(String[] args) {
GameDaoImpl pdao= new GameDaoImpl();
Game prod= pdao.save(new Game("Minecraft","sandbox,adventure","+3"));
System.out.println(prod);
List<Game> prods =pdao.GamesParMC("HP");
for (Game p : prods)
System.out.println(p);
}
}
