class DSArrayList<E> implements DSList<E>{

private int capacity = 10; //how much a can contain (we will maintain this)
private E[] a; //backing array
//private int[] a = new int[capacity];
private int length; // Number of items that count as being in the list

// Methods 

/**
 * Default constructor - builds an object of the class
 */
@SuppressWarnings("unchecked")
public DSArrayList(){
        this.capacity = 10; 
        this.length = 0;
        this.a = (E[])(new Object[this.capacity]);
//      new [this.capacity];
}

@SuppressWarnings("unchecked")  
        public void add(E n){ 
                if(this.length >= this.capacity){
                        int newCapacity = capacity * 2;
                        E[] newA = (E[])(new Object[newCapacity]);
                        for(int i = 0; i < this.capacity; i++){
                                newA[i] = a[i];
                        }
                        this.a = newA;
                        this.capacity = newCapacity;
                }

                this.a[this.length] = n;
                this.length++;
	}

        public void replace(int idx, E newValue){
                this.a[idx] = newValue;
        }

        public void sort(){
        }

        public int length(){
                return this.length;
        }


        public void remove(int idx){
                for(int i = idx; i < this.length - 1; i++){
                        this.a[i] = this.a[i+1];
                }
                this.length--;
        }

        public int count(E item){
                int c = 0;
                for (int i = 0; i < this.length; i++){
                        if( this.a[i].equals(item))
                                c++;
                }
                return c;
        }

        public E get(int idx){
                return this.a[idx];
        }
        // returns the index of the first occurence of the item
        public int find(E item){
                        for(int i = 0; i < this.length; i++){
                                if(this.a[i].equals(item))
                                        return i;
                        }
                        return -1;
        }

        @Override
        public String toString(){
                String rv = "["; // print array here

                if(this.length == 0) return "[]";

                for(int i = 0; i < this.length-1; i++){
                        rv = rv + this.a[i] + ", ";
                }
                // Add the last element of the list
                rv = rv + this.a[this.length - 1] + "]";
                return rv;
        }
}
