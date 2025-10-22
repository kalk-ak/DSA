import javax.crypto.spec.PSource;

public interface SkipList<T> extends List<T>{
    /** Returns the position following p on the same level */
    Position<T> next(Position<T> position);

    /** Returns the position preceding p on the same level */
    Position<T> prev(Position<T> position);

    /** Returns the position above p in the same tower */
    Position<T> above(Position<T> position);

    /** Returns the postion below p in the same tower */
}
