package Game;

public class Human implements Warrior, Mage, Archer {
    private int warriorDamage = 18;
    private int archerSHootDamage = 5;
    private int archerAttackDamage = 3;
    private int mageAttackDamage = 3;

    public void setWarriorDamage(int warriorDamage) {
        this.warriorDamage = warriorDamage;
    }

    public void setArcherSHootDamage(int archerSHootDamage) {
        this.archerSHootDamage = archerSHootDamage;
    }

    public void setArcherAttackDamage(int archerAttackDamage) {
        this.archerAttackDamage = archerAttackDamage;
    }

    public void setMageAttackDamage(int mageAttackDamage) {
        this.mageAttackDamage = mageAttackDamage;
    }

    public int getWarriorDamage() {
        return warriorDamage;
    }

    public int getArcherSHootDamage() {
        return archerSHootDamage;
    }

    public int getArcherAttackDamage() {
        return archerAttackDamage;
    }

    public int getMageAttackDamage() {
        return mageAttackDamage;
    }

    @Override
    public void attack(Unit unit) {
        System.out.print("атакует мечом (наносит " + warriorDamage + " урона). ");
        unit.setHitpoints(unit.getHitpoints() - warriorDamage);
    }

    @Override
    public Team mageFirstAction(Unit unit, Team humansTeam, Team enemyTeam) {
        Team team = null;
        int random = (int) (Math.random() * humansTeam.getSize());
        System.out.print("наложение улучшения на персонажа своего отряда: " + (humansTeam.getUnits()[random]).getName() + " стал сильнее");
        if ((humansTeam.getUnits()[random] instanceof AgregWarrior)) {
            ((Human)((AgregWarrior)humansTeam.getUnits()[random]).getWarrior()).setWarriorDamage((int)(this.warriorDamage*1.5));
        } else if ((humansTeam.getUnits()[random] instanceof AgregArcher)) {
            ((Human)((AgregArcher)humansTeam.getUnits()[random]).getArcher()).setArcherAttackDamage((int)(this.archerAttackDamage*1.5));
            ((Human)((AgregArcher)humansTeam.getUnits()[random]).getArcher()).setArcherSHootDamage((int)(this.archerSHootDamage*1.5));
        } else if((humansTeam.getUnits()[random] instanceof AgregMage)) {
            ((Human)((AgregMage)humansTeam.getUnits()[random]).getMage()).setMageAttackDamage((int)(this.mageAttackDamage*1.5));
        }
        return team;
    }

    @Override
    public Team mageSecondAction(Unit unit, Team humansTeam, Team enemyTeam) {
        Team team = null;
        System.out.print("атакует магией (наносит " + mageAttackDamage + " урона).");
        unit.setHitpoints(unit.getHitpoints() - mageAttackDamage);
        System.out.print(" У " + unit.getName() + " остается HP: " + unit.getHitpoints());
        return team;
    }

    @Override
    public void shoot(Unit unit) {
        System.out.print("стреляет из арбалета (наносит " + archerSHootDamage + " урона). ");
        unit.setHitpoints(unit.getHitpoints() - archerSHootDamage);
    }

    @Override
    public void archerAttack(Unit unit) {
        System.out.print("атакует (наносит " + archerAttackDamage + "  урона). ");
        unit.setHitpoints(unit.getHitpoints() - archerAttackDamage);
    }
}
