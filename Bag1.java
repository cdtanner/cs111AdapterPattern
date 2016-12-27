public class Bag1
{
    private int [] theBag;
    private int numInBag;

    public Bag1()
    {
	theBag= new int[100];
	numInBag=0;
    }
    
    public boolean placeInBag(int item);
    public boolean removeFromBag (int item);
    public boolean removeLastItem();
    public boolean removeRandom();
    public int numItems();
    public boolean full();
    public boolean empty();
    public void clear()
    {
	numInBag =0;
    }
}
