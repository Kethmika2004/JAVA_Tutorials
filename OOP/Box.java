public class Box<T> {

    T item;

    public void putItem(T item){
        this.item = item;
    }

    public T getItem(){
        return this.item;
    }
    
}
