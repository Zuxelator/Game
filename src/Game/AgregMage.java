package Game;

public class AgregMage extends Unit{
    private Mage mage;

    public AgregMage(String name, Mage mage) {
        super(name);
        this.mage = mage;
    }

    public Mage getMage() {
        return mage;
    }

    public void mageFirstAction(Unit unit, Team ourTeam, Team enemyTeam) {
        mage.mageFirstAction(unit, ourTeam, enemyTeam);
    }

    public void mageSecondAction(Unit unit, Team ourTeam, Team enemyTeam) {
        mage.mageSecondAction(unit, ourTeam, enemyTeam);
    }

    public void action(Unit unit, Team ourTeam, Team enemyTeam) {
        int random = (int)(Math.random() * 2);
        if(random == 0) {
            mageFirstAction(unit, ourTeam, enemyTeam);
        } else {
            mageSecondAction(unit, ourTeam, enemyTeam);
        }
    }
}
