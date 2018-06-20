//This is the only packages you can import
import java.util.Comparator;
//These are the only packages you can import

//
// finish the implementation of a generic double linked list
// total 4 tasks (75%) in this files
//

public class SimpleLinkedList<T>
{

  //add a new record to the end of the list
  //(15%)
  public void add(T data)
  {
    ListItem<T> x = new ListItem<T>();
    x.data = data;

    if(tail!=null)
    {
      m_tail.next = x;
      x.prev= m_tail;
      m_tail = x;
    }
    else
    {
      tail=head=x;
    }


    size++;
  }

  //swap two nodes in linked list
  //(20%)
  private void swap(ListItem<T> n1, ListItem<T> n2)
  {
    if(size<2)
    {
      throw new IndexOutOfBoundsException("swap can't be done");
    }




    if((n1==m_head && n2==m_tail) || (n1==m_tail && n2==m_head))
    {
      if(n1==m_head)
      {
        ListItem<T> temp = n1.next;
        n1.next = null;
        n1.prev = n2.prev;
        n2.prev.next = n1;

        n2.prev=null;
        n2.next=temp;
        temp.prev = n2;

        m_head = n2;
        m_tail = n1;
      }
      else
      {
        ListItem<T> temp = n2.next;
        n2.next = null;
        n2.prev = n1.prev;
        n1.prev.next=n2;

        n1.prev=null;
        n1.next=temp;
        temp.prev = n1;

        m_head = n1;
        m_tail = n2;
      }
    }
    else if ((n1==m_head)||(n2==m_head))
    {
      if(n1==head)
      {
        ListItem<T> temp = n1.next;
        n1.next = n2.next;
        n1.prev = n2.prev;
        n2.next.prev = n1;
        n2.prev.next = n1;

        n2.prev = null;
        n2.next = temp;
        temp.prev=n2;

        m_head = n2;

      }
      else
      {
        ListItem<T> temp = n2.next;
        n2.next = n1.next;
        n2.prev = n1.prev;
        n1.next.prev = n2;
        n1.prev.next = n2;

        n2.prev = null;
        n2.next = temp;
        temp.prev = n2;

        m_head = n1;
      }
    }
    else if ((n1==m_tail)||(n2==m_tail))
    {
      if(n1==m_tail)
      {
        ListItem<T> temp = n1.prev;
        n1.next = n2.next;
        n1.prev = n2.prev;
        n2.next.prev = n1;
        n2.prev.next = n1;

        n2.next = null;
        n2.prev = temp;
        temp.next = n2;

        m_tail = n2;
      }
      else
      {
        ListItem<T> temp = n2.prev;
        n2.next = n1.next;
        n2.prev = n1.prev;
        n1.next.prev = n2;
        n1.prev.next = n2;

        n1.next = null;
        n1.prev = temp;
        temp.next = n1;

        m_tail = n1;
      }
    }
    else
    {
      ListItem<t> tempp = n1.prev;
      ListItem<t> tempn = n1.next;

      n1.next = n2.next;
      n1.prev = n2.prev;
      n2.next.prev=n1;
      n2.prev.next=n1;

      n2.next = tempn;
      n2.prev = tempp;
      tempn.prev = n2;
      tempp.next = n2;
    }


  }

  //reverse the order of the nodes
  //(15%)
  public void reverse()
  {
    //TODO: your code here
    ListItem<T> tempL = m_head;
    ListItem<T> tempR = m_tail;
    ListItem<T> tempx = new ListItem<T>();

    for(int i=0;i< (int)size/2; i++)
    {

      swap(tempL, tempR);

      //for next round
      tempL = tempL.next;
      tempR = tempR.prev;
    }

  }

  //sort all elements in this list in decending order
  //(25%)
  public void bubble_sort(Comparator<T> comp)
  {
    ListItem<T> tempL = m_head;
    int n = size;
    boolean swapped;

    do
    {
      swapped = false;
      for (i=1;i<n;i++)
      {
        if(tempL > tempL.next)
        {
          swap(tempL, tempL.next);
          swapped = true;
        }
        tempL = tempL.next;
      }
      n--;
      tempL=m_head;
    } while (swapped==false);





    //TODO: your code here
    //you can find bubble sort pseudocode here:
    //https://en.wikipedia.org/wiki/Bubble_sort#Pseudocode_implementation
  }

  //test function
  //use "java SimpleLinkedList" to call this function
  public static void main(String [] args)
  {
    //TODO: add your test code here
    SimpleLinkedList<String> sLL=new SimpleLinkedList<String>();
    SimpleLinkedList<Integer> iLL=new SimpleLinkedList<Integer>();

    sLL.add("abc");
    sLL.add("ef");
    sLL.add("xyz");
    sLL.add("gmu");

    System.out.println(sLL.toString());

    //sLL.reverse();
    //System.out.println(sLL.toString());

    sLL.bubble_sort(new Comparator<String>(){
      public int compare(String a, String b){return a.compareTo(b);}
    });
    System.out.println("In decending order: "+sLL.toString());

    iLL.add(-1);
    iLL.add(9);
    iLL.add(21);
    iLL.add(3);
    System.out.println(iLL.toString());
    iLL.bubble_sort(new Comparator<Integer>(){
      public int compare(Integer a, Integer b){return a-b;}
    });
    System.out.println("In decending order: "+iLL.toString());
  }

  //---------------------------------------------------------------------------
  //
  // Read the following code but Do Not change.
  //
  //---------------------------------------------------------------------------

  private ListItem<T> m_head, m_tail;
  private int size;

  public SimpleLinkedList()
  {
    size=0;
  }

  public int size()
  {
    return size;
  }

  public void make_cicular()
  {
    if(m_head!=null && m_tail!=null)
    {
      m_head.pre=m_tail;
      m_tail.next=m_head;
    }
  }

  public boolean is_cicular()
  {
    if(m_head!=null && m_tail!=null)
    {
      if(m_head.pre==m_tail && m_tail.next==m_head)
        return true;
    }
    return false;
  }

  public String toString()
  {
    ListItem<T> ptr=m_head;
    String result="";
    while(ptr!=m_tail)
    {
      result+=("["+ptr.data.toString()+"]->");
      ptr=ptr.next;
    }
    result+=("["+m_tail.data.toString()+"]");
    return result;
  }

  public ListItem<T> getHead() { return m_head; }
  public ListItem<T> getTail() { return m_tail; }
}

//FC0182435019643AF53744346B4FE8770B811921140611CF7E9BACA04396F2E2
