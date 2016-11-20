import java.util.*;
import java.io.*;
import java.text.*;
import twitter4j.*;

public class main{

  public static void delay(long d){
    long start=System.currentTimeMillis();
    long end=start+d;
    while(start<end){
      start=System.currentTimeMillis();
    }
    return;
  }

  public static void main(String[] args) throws TwitterException{
    Twitter twitter=TwitterFactory.getSingleton();

    List<String> people=new ArrayList<>();
    String fileName="Friends.txt";
    String lining=null;
    try{
      FileReader fileReader = new FileReader(fileName);
      BufferedReader br=new BufferedReader(fileReader);
      while((lining=br.readLine())!=null){
        people.add(lining);
      }
      br.close();
    }catch(Exception ex){}


    SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
    String startTime=sdf.format(new Date());
    System.out.println("Initiated at "+startTime);

  }
}
