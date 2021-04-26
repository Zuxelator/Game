package Game;

public class Main {
    public static void main(String[] args) {
        Team humans = new Team("Люди");
        Team orcs = new Team("Орки");
        Team.start(humans, orcs);
    }
}
