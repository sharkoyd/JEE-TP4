package web;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Game;
public class GameModele {
private String motCle;
List<Game> Games = new ArrayList<>();
public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<Game> getGames() {
return Games;
}
public void setGames(List<Game> Games) {
this.Games = Games;
}
}