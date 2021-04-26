package Game;

public class Orc implements Warrior, Mage, Archer{
    private int warriorDamage = 20;
    private int archerSHootDamage = 3;
    private int archerAttackDamage = 2;
    private int mageAttackDamage = 0;

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

    @Override
    public void attack(Unit unit) {
        System.out.print("атакует дубиной (наносит " + warriorDamage + " урона). ");
        unit.setHitpoints(unit.getHitpoints() - warriorDamage);
    }

    @Override
    public Team mageFirstAction(Unit unit, Team orcsTeam, Team enemyTeam) {
        Team team = null;
        int random = (int) (Math.random() * orcsTeam.getSize());
        System.out.print("наложение улучшения на персонажа своего отряда: " + (orcsTeam.getUnits()[random]).getName() + " стал сильнее");
        if ((orcsTeam.getUnits()[random] instanceof AgregWarrior)) {
            ((Orc)((AgregWarrior)orcsTeam.getUnits()[random]).getWarrior()).setWarriorDamage((int)(this.warriorDamage*1.5));
        } else if ((orcsTeam.getUnits()[random] instanceof AgregArcher)) {
            ((Orc)((AgregArcher)orcsTeam.getUnits()[random]).getArcher()).setArcherAttackDamage((int)(this.archerAttackDamage*1.5));
            ((Orc)((AgregArcher)orcsTeam.getUnits()[random]).getArcher()).setArcherSHootDamage((int)(this.archerSHootDamage*1.5));
        } else if((orcsTeam.getUnits()[random] instanceof AgregMage)) {
            ((Orc)((AgregMage)orcsTeam.getUnits()[random]).getMage()).setMageAttackDamage((int)(this.mageAttackDamage*1.5));
        }
        return team;
    }

    @Override
    public Team mageSecondAction(Unit unit, Team orc, Team enemy) {
        Team team = null;
        int random = (int) (Math.random() * enemy.getSize());
        System.out.print("накладывает проклятие на персонажа вражеского отряда: " + (enemy.getUnits()[random]).getName() + " стал слабее");
        if ((enemy.getUnits()[random] instanceof AgregWarrior)) {
            ((Human)((AgregWarrior)enemy.getUnits()[random]).getWarrior()).setWarriorDamage((int)(this.warriorDamage/1.5));
        } else if ((enemy.getUnits()[random] instanceof AgregArcher)) {
            ((Human)((AgregArcher)enemy.getUnits()[random]).getArcher()).setArcherAttackDamage((int)(this.archerAttackDamage/1.5));
            ((Human)((AgregArcher)enemy.getUnits()[random]).getArcher()).setArcherSHootDamage((int)(this.archerSHootDamage/1.5));
        } else if((enemy.getUnits()[random] instanceof AgregMage)) {
            ((Human)((AgregMage)enemy.getUnits()[random]).getMage()).setMageAttackDamage((int)(this.mageAttackDamage/1.5));
        }
        return team;
    }

    @Override
    public void shoot(Unit unit) {
        System.out.print("стреляет из лука (нанесение " + archerSHootDamage + " урона). ");
        unit.setHitpoints(unit.getHitpoints() - archerSHootDamage);
    }

    @Override
    public void archerAttack(Unit unit) {
        System.out.print("бьет клинком (наносит " + archerAttackDamage + " урона). ");
        unit.setHitpoints(unit.getHitpoints() - archerAttackDamage);
    }
}
