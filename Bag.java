//CS 111 Layered IMplenetmation of a Bag on a LinkedList

import java.util.LinkedList;
import java.util.Iterator;


public class Bag<T>
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
                 data.equals(((BagElement)(o)).data));
       }
 
       public int getCount(){ return count;}
       public T getData() { return data;}
       public String toString()
       {
         return data + ": " + count;
       }
    }

    private LinkedList<BagElement<T>> theBag;

    public Bag()
    {
      theBag = new LinkedList<BagElement<T>>();
    }

    public boolean empty() { return theBag.size()==0;}

    public boolean removeAll(T item) throws BagEmptyException, ItemNotInBagException
	{boolean q; 
	 if (empty()) throw new BagEmptyException("");
         BagElement<T> p =new BagElement<T>(item);

         q=theBag.remove(p);
	 if(!q) throw new ItemNotInBagException("");
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
        theBag.addFirst(p);
      else
      {   p=theBag.remove(i);
        p.addOne();
        theBag.addFirst(p);
      }
    }

    public void removeOne(T item) throws BagEmptyException, ItemNotInBagException
    {
      int i;
      BagElement<T> p = new BagElement<T>(item);

      if (theBag.size() ==0)
        throw new BagEmptyException("");

      i = theBag.indexOf(p);
      if (i == -1)
        throw new ItemNotInBagException("");

      p= theBag.remove(i);
      p.removeOne();
      if (p.count != 0)
        theBag.addFirst(p);
    }

    public void display()
    {
      BagElement<T> p;
      Iterator<BagElement<T>> itr;

      System.out.print("The contents of the Bag: ");
 
      itr = theBag.listIterator();
      while (itr.hasNext())
      {
        p=itr.next();
        System.out.print(p);
      }
    }
}
