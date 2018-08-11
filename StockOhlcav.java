import java.io.*;
import java.net.*;

public class StockOhlcav
{

  public void get(String CompanyName)
  {



    String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol="+CompanyName+"&outputsize=full&apikey=R4MH59PCDVHF6SDB&datatype=csv";

    URL u;
    InputStream is = null;
    DataInputStream dis;
    String s;

	
    try
    {
	  PrintWriter writer = new PrintWriter(CompanyName+".csv", "UTF-8");

      u = new URL(url);
      is = u.openStream();
      dis = new DataInputStream(new BufferedInputStream(is));
      while ((s = dis.readLine()) != null)
      {
        //System.out.println(s);
		writer.println(s);
      }
	  writer.close();
    }
    catch (MalformedURLException mue)
    {
      System.err.println("Ouch - a MalformedURLException happened.");
      mue.printStackTrace();
      System.exit(2);
    }
    catch (IOException ioe)
    {
      System.err.println("Oops- an IOException happened.");
      ioe.printStackTrace();
      System.exit(3);
    }

    finally
    {
      try
      {
        is.close();
      }
      catch (IOException ioe)
      {
      }
    }
  
  }

}