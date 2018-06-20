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
    ListItem<T> x = new ListItem<T>(data);


    if(m_tail!=null)
    {
      m_tail.next = x;
      x.pre= m_tail;
      m_tail = x;
      x.next=null;
    }
    else
    {
      m_tail=m_head=x;
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


    if(is_cicular())
    {
      if(n1.next ==n2 || n2.next==n1)
      {
        swap4nextto(n1,n2);
      }
      else
      {
        ListItem<T> tempp = n1.pre;
        ListItem<T> tempn = n1.next;

        n1.next = n2.next;
        n1.pre = n2.pre;
        n2.next.pre=n1;
        n2.pre.next=n1;

        n2.next = tempn;
        n2.pre = tempp;
        tempn.pre = n2;
        tempp.next = n2;
      }

      if(n1==m_head && n2==m_tail)
      {
        n1=m_tail;
        n2=m_head;
      }
      else if (n2==m_head && n1==m_tail)
      {
        n2=m_tail;
        n1=m_head;
      }
      else if(n1==m_head)
      {
        n2=m_head;
      }
      else if(n2==m_head)
      {
        n1=m_head;
      }
      else if(n1==m_tail)
      {
        n2=m_tail;
      }
      else if(n2==m_tail)
      {
        n1=m_tail;
      }
      else
      {
        //extra case might be applied.
      }
    }
    else if((n1==m_head && n2==m_tail) || (n1==m_tail && n2==m_head))
    {      System.out.println("case 1");
      if(n1.next==n2 || n2.next==n1)
      {
        System.out.println("case 1.1");

        swap1nextto(n1,n2);
      }
      else
      {
        if(n1==m_head)
        {
           System.out.println("case 1.2");
          ListItem<T> temp = n1.next;
          n1.next = null;
          n1.pre = n2.pre;
          n2.pre.next = n1;

          n2.pre=null;
          n2.next=temp;
          temp.pre = n2;

          m_head = n2;
          m_tail = n1;
        }
        else
        {
          System.out.println("case 1.3");

          ListItem<T> temp = n2.next;
          n2.next = null;
          n2.pre = n1.pre;
          n1.pre.next=n2;

          n1.pre=null;
          n1.next=temp;
          temp.pre = n1;

          m_head = n1;
          m_tail = n2;
        }
      }
    }
    else if ((n1==m_head)||(n2==m_head))
    {  System.out.println("case 2");
      if(n1.next==n2 || n2.next==n1)
      {
        System.out.println("case 2.1");

        swap2nextto(n1,n2);
      }
      else
      {
        System.out.println("case 2.2");

        if(n1==m_head)
        {
          ListItem<T> temp = n1.next;
          n1.next = n2.next;
          n1.pre = n2.pre;
          n2.next.pre = n1;
          n2.pre.next = n1;

          n2.pre = null;
          n2.next = temp;
          temp.pre=n2;

          m_head = n2;

        }
        else
        {
          ListItem<T> temp = n2.next;
          n2.next = n1.next;
          n2.pre = n1.pre;
          n1.next.pre = n2;
          n1.pre.next = n2;

          n2.pre = null;
          n2.next = temp;
          temp.pre = n2;

          m_head = n1;
        }
      }
    }
    else if ((n1==m_tail)||(n2==m_tail))
    {  System.out.println("case 3");
      if(n1.next==n2||n2.next==n1)
      {
        swap3nextto(n1,n2);
      }
      else
      {
        if(n1==m_tail)
        {
          ListItem<T> temp = n1.pre;
          n1.next = n2.next;
          n1.pre = n2.pre;
          n2.next.pre = n1;
          n2.pre.next = n1;

          n2.next = null;
          n2.pre = temp;
          temp.next = n2;

          m_tail = n2;
        }
        else
        {
          ListItem<T> temp = n2.pre;
          n2.next = n1.next;
          n2.pre = n1.pre;
          n1.next.pre = n2;
          n1.pre.next = n2;

          n1.next = null;
          n1.pre = temp;
          temp.next = n1;

          m_tail = n1;
        }
      }
    }
    else
    {
      System.out.println("case 4");
      if(n1.next ==n2 || n2.next==n1)
      {
        swap4nextto(n1,n2);
      }
      else
      {
        ListItem<T> tempp = n1.pre;
        ListItem<T> tempn = n1.next;

        n1.next = n2.next;
        n1.pre = n2.pre;
        n2.next.pre=n1;
        n2.pre.next=n1;

        n2.next = tempn;
        n2.pre = tempp;
        tempn.pre = n2;
        tempp.next = n2;
      }
    }


  }


  public void swap1nextto(ListItem<T> n1, ListItem<T> n2)
  {
    if(n1.next == n2)
    {
      n1.next = null;
      n1.pre = n2;
      n2.next = n1;
      n2.pre=null;
      m_head=n2;
      m_tail=n1;
    }
    else
    {
      n2.next = null;
      n2.pre = n1;
      n1.next = n2;
      n1.pre = null;
      m_head=n1;
      m_tail=n2;
    }
  }

  public void swap2nextto(ListItem<T> n1, ListItem<T> n2)
  {
    if(n1.next == n2)
    {
      System.out.println("case 2.1.1");

      ListItem<T> temp = n2.next;
      n1.next = temp;
      n1.pre = n2;
      temp.pre=n1;
      n2.next=n1;
      n2.pre=null;
      m_head=n2;

    }
    else
    {
      System.out.println("case 2.1.2");

      ListItem<T> tempx = n1.next;
      n2.next = tempx;
      n2.pre = n1;
      tempx.pre=n2;
      n1.next=n2;
      n1.pre=null;
      m_head=n1;
    }
  }


  public void swap3nextto(ListItem<T> n1, ListItem<T> n2)
  {
    if(n1.next == n2)
    {
      ListItem<T> temp = n1.pre;
      n1.next = null;
      n1.pre = n2;
      n2.next = n1;
      n2.pre = temp;
      temp.next=n2;
      m_tail=n1;
    }
    else
    {
      ListItem<T> tempx = n2.pre;
      n2.next = null;
      n2.pre = n1;
      n1.next = n2;
      n1.pre = tempx;
      tempx.next=n1;
      m_tail=n2;
    }
  }

  public void swap4nextto(ListItem<T> n1, ListItem<T> n2)
  {
    ListItem<T> temp =n1.pre;
    if(n1.next == n2)
    {
      n1.next = n2.next;
      n1.pre = n2;
      n2.next.pre = n1;

      n2.next = n1;
      n2.pre = temp;
      temp.next = n2;
    }
    else
    {
      ListItem<T> tempx =n2.pre;

      n2.next = n1.next;
      n2.pre = n1;
      n1.next.pre = n2;

      n1.next = n2;
      n1.pre = temp;
      tempx.next = n1;
    }
  }
  //reverse the order of the nodes
  //(15%)
  public void reverse()
  {
    //TODO: your code here
    ListItem<T> tempL = m_head;
    ListItem<T> tempR = m_tail;


    if(is_cicular())
    {
      System.out.println("it is circular in reverse");
    }
    else
    {
      System.out.println("it is NOT circular in reverse");

    }
    for(int i=0;i< (int)size/2; i++)
    {

      swap(tempL, tempR);

      //for next round
      if(i!=((int)(size/2)-1))
      {
        tempL = m_head;
        tempR = m_tail;
        for(int j=0;j<i+1;j++)
        {
          tempL = tempL.next;
          tempR = tempR.pre;
        }
      }

    }

  }

  //sort all elements in this list in decending order
  //(25%)
  public void bubble_sort(Comparator<T> comp)
  {
    ListItem<T> tempL = m_head;
    int n = size;
    boolean swapped;

    int batch =0;
    do
    {
      batch++;
      swapped = false;
      System.out.println(batch);
      for (int i=1;i<n;i++)
      {
        System.out.println(tempL.data +"-----" + tempL.next.data +"bubble_sort");
        System.out.println("count" + comp.compare(tempL.data, tempL.next.data));

        if(comp.compare(tempL.data, tempL.next.data)>0)
        {
          System.out.println(tempL.data +"-----" + tempL.next.data +"bubble_sortx");

          swap(tempL, tempL.next);
          swapped = true;
        }


        //for next round
        if(i!=n-1)
        {
          tempL = m_head;
          for(int j=0;j<i;j++)
          {
            tempL = tempL.next;
            System.out.println("--->"+tempL.data);
          }
        }
      }
      n--;
      tempL=m_head;
    } while (swapped==true);

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
    iLL.add(3);
    iLL.add(-20);
    iLL.add(100);
    iLL.add(50);
    iLL.add(2);
    iLL.add(-1);
    iLL.add(9);
    iLL.add(100);
    iLL.add(21);
    iLL.add(3);
    System.out.println(iLL.toString());
    iLL.bubble_sort(new Comparator<Integer>(){
      public int compare(Integer a, Integer b){return a-b;}
    });
    System.out.println("In decending order: "+iLL.toString());
    iLL.reverse();

    System.out.println(iLL.toString());
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
