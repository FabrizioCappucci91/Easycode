import com.game.GameController;
import com.utils.Utils;

public class Main {
  public static void main(String[] args) {
    Utils.print("Welcome to Pawtropolis.");
    GameController gameController= new GameController();
    gameController.runGame();
    Utils.print("Bye bye");
  }
}