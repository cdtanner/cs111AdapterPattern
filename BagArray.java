//CS 111 Layered IMplenetmation of a Bag on an ArrayList

import java.util.ArrayList;


public class BagArray<T>
{
    
    private class BagElement<T>
    {
      private T data;
      private int count;
 
      public BagElement (T d)
     { 
	 count =1;
	 data =d;
     }

     public void addOne()
     {
	 count++;
     }

     public void removeOne()
     {
	 count--;
     }

     public boolean equals (Object o)
     {
	 return (o instanceof BagElement &&
		 data.equals(((BagElement)o).data));
     }
 
     public int getCount(){ return count;}
     public T getData() { return data;}
     public String toString()
     {
	 return data + ": " + count;
     }
    }

    private ArrayList<BagElement<T>> theBag;


    public BagArray()
    {
	theBag = new ArrayList<BagElement<T>>();
    }

    public boolean empty() { return theBag.size()==0;}

    public boolean removeAll(T item) throws BagEmptyException, ItemNotInBagException
    { boolean q;
      if (empty()) throw new BagEmptyException("");
      
      BagElement<T> p =new BagElement<T>(item);
      q =theBag.remove(p);
      if (!q) throw new ItemNotInBagException("");
      return q;
    }

    public int size()
    {
	return theBag.size();
    }

    public void insert(T item)
    {
	int i;
	BagElement<T> p = new BagElement<T>(item);

	i = theBag.indexOf(p);
	if (i == -1)
	    theBag.add(p);
	else
	    {   p=theBag.get(i);
		p.addOne();
		theBag.set(i,p);
	    }
    }

    public void removeOne(T item) throws BagEmptyException,ItemNotInBagException
    {
	int i;
	BagElement<T> p = new BagElement<T>(item);

	if (theBag.size() ==0)
	    throw new BagEmptyException(" ");

	i = theBag.indexOf(p);
	if (i == -1)
	    throw new ItemNotInBagException(" ");

	p= theBag.remove(i);
	p.removeOne();
	if (p.count != 0)
	    theBag.add(p);
    }

    public void display()
    {
	BagElement<T> p;

	System.out.print("The contents of the Bag: ");
 
	for (int i=0; i<theBag.size(); i++)
	    {
		p=theBag.get(i);
		System.out.print(p);
	    }
    }
}
