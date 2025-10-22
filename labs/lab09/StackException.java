
public class StackException extends Exception{

    public StackException(int size){
        this.size = size;
    }
    public int getSize(){
        return size;
    }
    int size;
}
