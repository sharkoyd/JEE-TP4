package metier.entities;
import java.io.Serializable;
public class Game implements Serializable{
private Long idGame;
private String nomGame;
private String type;
private String ageRating;

public Game() {
super();
}
public Game(String nomGame, String type,String ageRating) {
super();
this.nomGame = nomGame;
this.type = type;
this.ageRating = ageRating;

}
public Long getIdGame() {
return idGame;
}
public void setIdGame(Long idGame) {
this.idGame = idGame;
}
public String getNomGame() {
return nomGame;
}
public void setNomGame(String nomGame) {
this.nomGame = nomGame;
}
public String getType() {
return type;
}
public void setType(String type) {
this.type = type;
}
public String getAgeRating() {
return ageRating;
}
public void setAgeRating(String type) {
this.ageRating = type;
}
public String toString() {
	return "Game [idGame=" + idGame + ", nomGame=" +
	nomGame + ", type=" + type +", age rating=" + ageRating + "]";
}
}