public class GameEntry {
    private String name;
    private int score;

    public GameEntry(String n, int s){
        this.name = n;
        this.score = s;

    }
    public void setName(String n){ this.name = n; }
    public String getName(){ return this.name; }

    public int getScore(){ return this.score;}

    public String toString(){
        return "( " + name + ", " + score + " )";
    }


}

