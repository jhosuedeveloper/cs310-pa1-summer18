//These are the only packages you can import
import java.util.Comparator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import no more

//
// this file defines a polygon painter class
// It maintains a list of sorted polygons
//
// total 2 tasks (20%) in this files
//

public class PaintPolygons
{

  //
  // compare two polygons using winding number and areas
  // (15%)
  //
  private class PolygonComparator implements Comparator<Polygon>
  {
    public int compare(Polygon p1, Polygon p2)
    {
      if(p1.winding_number(p2.getVertices().getHead().data.x, p2.getVertices().getHead().data.y)!=0)//case p2 is inside p1
      {
        return 0;
      }
      else if(p2.winding_number(p1.getVertices().getHead().data.x, p1.getVertices().getHead().data.y)!=0)//case p2 is inside p1
      {
        return 1;
      }
      else
      {
        if(p1.area()<p2.area())
        {
          return 1;
        }
        else
        {
          return 0;
        }
      }

    }
  }

  //
  // print the polygons to screen in sorted order
  // (5%)
  //
  public void print()
  {
    ListItem<Polygon> temp = m_polys.getHead();

    for(int i =0;i<m_polys.size();i++)
    {
      System.out.println("polygon "+ temp.data.name +"area= "+ temp.data.area() );

      if(i!=m_polys.size()-1)
      {
        temp=temp.next;
      }
    }

  }

  //---------------------------------------------------------------------------
  //
  // Read the following code but Do Not change.
  //
  //---------------------------------------------------------------------------
  private SimpleLinkedList<Polygon> m_polys;

  public PaintPolygons()
  {
    m_polys=new SimpleLinkedList<Polygon>();
  }

  public void addPolygon(Polygon p)
  {
      m_polys.add(p);
  }

  //sort the polygons from outside to inside
  //if two polygons are in the same level, sort by areas in ascending order
  //(i.e., small to large)
  public void sortPolygons()
  {
      m_polys.bubble_sort(new PolygonComparator());
  }

  //save the polygons to output.svg in sorted order
  public void save2SVG(String filename)
  {
    try
    {
      FileWriter fileWriter = new FileWriter(new File(filename));

      //write svg header
      {
        double [] bbox={Double.MAX_VALUE,-Double.MAX_VALUE,Double.MAX_VALUE,-Double.MAX_VALUE};
        ListItem<Polygon> ptr=m_polys.getHead();
        while(ptr!=null)
        {
          ptr.data.updateBoundingBox(bbox);
          ptr=ptr.next;
        }
        //padding
        double width=(bbox[1]-bbox[0]);
        double height=(bbox[3]-bbox[2]);
        double pad=Math.min(width,height)/50;
        bbox[0]-=pad; bbox[1]+=pad; bbox[2]-=pad; bbox[3]+=pad;
        width=(bbox[1]-bbox[0]);
        height=(bbox[3]-bbox[2]);
        //
        String header="<?xml version=\"1.0\" standalone=\"no\" ?>\n<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n<svg ";
        header+=(" width=\""+ width +"px\"");
        header+=(" height=\""+ height +"px\"");
        header+=(" viewBox=\""+bbox[0]+" "+bbox[2]+" "+width+" "+height+" \"");
        header+=(" xmlns=\"http://www.w3.org/2000/svg\"");
        header+=(" version=\"1.1\""+">\n");
        fileWriter.write(header);
      }

      //write each polygon
      ListItem<Polygon> ptr=m_polys.getHead();
      while(ptr!=null)
      {
        fileWriter.write(ptr.data.toString()+"\n");
        ptr=ptr.next;
      }

      //write svg footer
      {
        String footer="</svg>\n";
        fileWriter.write(footer);
      }

      //done
      fileWriter.flush();
      fileWriter.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("- Saved results to "+filename);
  }
  //FC0182435019643AF53744346B4FE8770B811921140611CF7E9BACA04396F2E2
}
