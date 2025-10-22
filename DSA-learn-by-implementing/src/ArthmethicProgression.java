public class ArthmethicProgression extends Progression{
    protected long increment;

    public ArthmethicProgression(){ this(1, 0);}

    public ArthmethicProgression(long step) {this(step, 0);}

    public ArthmethicProgression(long step, long start){
        super(start);
        increment = step;
    }

    protected void advance() {
        current += increment;
    }
}
