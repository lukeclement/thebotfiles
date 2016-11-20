import java.util.*;
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
    
  }
}
