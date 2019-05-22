public class Stack {

    private MapTile[] beholder;
    private int cap;
    private int top;
    private int size;

    public Stack(int cap){
        this.cap = cap;
        top = -1;
        size = 0;
        beholder = new MapTile[cap];
    }

    public MapTile peek(){
        if(size == 0){
            return null;
        }
        return beholder[top];
    }

    public void push(MapTile minion){
        top++;
        size++;
        beholder[top] = minion;
    }

    public void pop(){
        top--;
        size--;
    }

    public boolean isFull(){
        if(size == cap){
            return true;
        }
        else {
            return false;
        }
    }

}
