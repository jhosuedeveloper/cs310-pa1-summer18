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
    //TODO: your code here
  }

  //swap two nodes in linked list
  //(20%)
  private void swap(ListItem<T> n1, ListItem<T> n2)
  {
    //TODO: your code here
  }

  //reverse the order of the nodes
  //(15%)
  public void reverse()
  {
    //TODO: your code here
  }

  //sort all elements in this list in decending order
  //(25%)
  public void bubble_sort(Comparator<T> comp)
  {
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
