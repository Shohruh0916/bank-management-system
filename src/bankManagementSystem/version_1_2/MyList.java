package bankManagementSystem.version_1_2;

public class MyList {

    private  Object[] elements;
    private  static final int CAPACITY=5;
    private int size;

    MyList(){
        elements=new Object[CAPACITY];
    }

    public MyList(int COPOSITY_size){
        elements=new MyList[COPOSITY_size];
    }

    public Object get(int index){
        return elements[index];
    }

    public int capasity(){
        return elements.length;
    }

    public Object add(Object element){
        if(elements.length<=size){
            Object[] newObject=new Object[2*elements.length];
            for(int i=0; i<size; i++){
                newObject[i]=elements[i];
            }
            elements=newObject;
        }
        elements[size++]=element;
        return element;
    }

    public int size(){
        return size;
    }
}
