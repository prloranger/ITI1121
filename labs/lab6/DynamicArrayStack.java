public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        // Your code here.
        if(capacity < DEFAULT_INC){
            capacity = DEFAULT_INC;
        }
        elems = (E[]) new Object [capacity];
        top = 0;
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        // Your code here.
        E returnable = elems[ --top ];

        elems[ top ] = null;

        if (elems.length - (top + 1) == DEFAULT_INC) {
            E[] newL = (E[]) new Object[elems.length - DEFAULT_INC];
            for ( int i = 0; i < top; i++ ) {
                newL[i] = elems[i];
            }
            elems = newL;
        }
        return returnable;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        // Your code here.
        if (top == this.getCapacity()) {
            E[] newL = (E[]) new Object[this.getCapacity() + DEFAULT_INC];

            for (int i = 0; i < this.getCapacity(); i++) {
                newL[i] = elems[i];
            }
            elems = newL;
        }
        elems[ top++ ] = element;
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        // Your code here.
        elems = (E[]) new Object[DEFAULT_INC];
        top = 0;
    }

}