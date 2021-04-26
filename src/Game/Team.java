package Game;

public class Team {
    private String race;
    private int size = 8;
    private Unit[] units = new Unit[size];
    private Unit[] improvedUnits = new Unit[8];

    public Team(String race) {
        if(!race.equals("Орки") && !race.equals("Люди")) {
            throw new IllegalArgumentException("надо выбрать либо Люди либо Орки");
        }
        if("Орки".equals(race)) {
            this.race = race;
            units[0] = new AgregWarrior("Орк воин №1", new Orc());
            units[1] = new AgregWarrior("Орк воин №2", new Orc());
            units[2] = new AgregWarrior("Орк воин №3", new Orc());
            units[3] = new AgregWarrior("Орк воин №4", new Orc());
            units[4] = new AgregMage("Орк маг", new Orc());
            units[5] = new AgregArcher("Орк лучник №1", new Orc());
            units[6] = new AgregArcher("Орк лучник №2", new Orc());
            units[7] = new AgregArcher("Орк лучник №3", new Orc());
        } else if("Люди".equals(race)) {
            this.race = race;
            units[0] = new AgregWarrior("Человек войн №1", new Human());
            units[1] = new AgregWarrior("Человек войн №2", new Human());
            units[2] = new AgregWarrior("Человек войн №3", new Human());
            units[3] = new AgregWarrior("Человек войн №4", new Human());
            units[4] = new AgregMage("Человек маг", new Human());
            units[5] = new AgregArcher("Человек лучник №1", new Human());
            units[6] = new AgregArcher("Человек лучник №2", new Human());
            units[7] = new AgregArcher("Человек лучник №3", new Human());
        }
    }

    public Unit[] getUnits() {
        return units;
    }

    public void setUnits(Unit[] units) {
        this.units = units;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getRace() {
        return race;
    }

    //проверяем есть ли кто живой в команде
    public boolean dead(Team units) {
        boolean rsl = false;
        Unit[] arr = units.getUnits();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getHitpoints() > 0) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static Team attack(Team attackTeam, Team defendTeam) {
        Team rsl = null;
        for (int i = 0; i < attackTeam.getSize(); i++) {
            if(defendTeam.getSize() == 0) {
                return rsl;
            }
            int random = (int) (Math.random() * defendTeam.getSize());
            System.out.print(attackTeam.getUnits()[i].getName() + " ");
            attackTeam.getUnits()[i].action(defendTeam.getUnits()[random], attackTeam, defendTeam);
            if(defendTeam.getUnits()[random].getHitpoints() > 0) {
                if(!(attackTeam.getUnits()[i] instanceof AgregMage)) {
                    System.out.println("У " + defendTeam.getUnits()[random].getName() + " остается HP: " + defendTeam.getUnits()[random].getHitpoints());
                } else {
                    System.out.println();
                }
            } else {
                System.out.println(defendTeam.getUnits()[random].getName() + " погиб");
                defendTeam.setSize(defendTeam.getSize() - 1);
                Unit[] arr = new Unit[defendTeam.getSize()];
                System.arraycopy(defendTeam.getUnits(), 0, arr, 0, random);
                System.arraycopy(defendTeam.getUnits(), random + 1, arr, random, arr.length - random);
                defendTeam.setUnits(arr);
            }
            rsl = defendTeam;
        }
        return rsl;
    }

    public static void start(Team t1, Team t2) {
        Team first;
        Team second;
        int whoFirst = (int)(Math.random() * 2);
        if(whoFirst == 0) {
            first = t1;
            second = t2;
        } else {
            first = t2;
            second = t1;
        }
        System.out.println("Первыми начинают " + first.getRace());
        while(first.getSize() != 0 && second.getSize() != 0) {
            System.out.println();
            System.out.println("---------------------Ходят " + first.getRace() + "---------------------");
            System.out.println();
            second = Team.attack(first, second);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(second.getSize() == 0) {
                System.out.println();
                System.out.println(first.getRace() + " победили");
                break;
            }
            System.out.println();
            System.out.println("---------------------Ходят " + second.getRace() + "---------------------");
            System.out.println();
            first = Team.attack(second, first);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(first.getSize() == 0) {
                System.out.println();
                System.out.println(second.getRace() + " победили");
                break;
            }
        }
    }
}
