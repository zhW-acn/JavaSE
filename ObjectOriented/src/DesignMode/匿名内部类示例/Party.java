package DesignMode.匿名内部类示例;

public class Party {
    public void play(Human human){
        human.play();
        System.out.println("人类 is playing!");
    }
    public static void main(String[] args) {
        Party party = new Party();
        Man man = new Man();
        party.play(man);
        Woman woman = new Woman();
        party.play(woman);
        party.play(new Human() {
            @Override
            public void play() {
                System.out.println("renyao is playing!");
            }
        });
    }
}
