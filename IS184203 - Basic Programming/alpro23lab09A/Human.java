public class Human {
    private String name;
    private int Hp;
    private int baseAttack;
    private int level;
    public Human(String name){
        this.name = name;
        this.Hp = 100;
        this.baseAttack = 10;
        this.level = 1;
    }

    public void levelup(){
        this.level += 1;
    }

    public int attack(){
        return this.baseAttack * level;
    }

    public void attacked(int damage){
        this.Hp -= damage;
        System.out.println("Ouch! " + this.name + " hit for " + damage + " damage!\n");
    }

    public void checkStatus(){
        System.out.println(this.name + "'s Status: ");
        System.out.println("Level: " + this.level);
        System.out.println("HP: " + this.Hp);
        System.out.println("Attack: " + this.baseAttack);
        System.out.println();
    }

    public void dead(){
        System.out.println("" + this.name + " Defeated!");
    }
}