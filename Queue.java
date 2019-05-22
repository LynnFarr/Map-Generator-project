public class Queue {
    private MapTile[] beholder;
    private int cap;
    private int front;
    private int size;

    public Queue(int cap){
        this.cap = cap;
        beholder = new MapTile[cap];
        front = 0;
        size = 0;
    }

    public MapTile peek(){
        if(size == 0){
            return null;
        }
        return beholder[front];
    }

    public void push(MapTile minion){
        beholder[size] = minion;
        size++;
    }

    public void pop(){
        size--;
    }
}
