public class Monster {

    private String name;
    private int Hp;
    private int baseAttack;
    public boolean dodgeStatus = false;
    public Monster(String name){
        this.name = name;
        this.Hp = 40;
        this.baseAttack = 5;
    }

    public int attack(){
        return this.baseAttack;
    }

    public void attacked(int damage){
        this.Hp -= damage;
        System.out.println("Ouch! " + this.name + " hit for " + damage + " damage!\n");
    }

    public void dodgeAttack(boolean dodgeSuccess, int damage){
        System.out.println("Will " + this.name + " able to dodge attack?");
        if(dodgeSuccess){
            System.out.println("" + this.name + " succesfully doge the attack!!!!");
        } else {
            System.out.println("" + this.name + " failed to dodge the attack");
            this.attacked(damage);
        }
    }
    public void checkStatus(){
        System.out.println(this.name + "'s Status: ");
        System.out.println("HP: " + this.Hp);
        System.out.println("Attack: " + this.baseAttack);
        System.out.println();
    }

    public void dead(){
        System.out.println("" + this.name + " Defeated!");
    }
}