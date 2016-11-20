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

    List<String> people;
    List<String> adjective;
    while(true){
      people=new ArrayList<>();
      adjective=new ArrayList<>();
      String fileName="Friends.txt";
      String fileNameTwo="adj.txt";
      String lining=null;
      try{
        FileReader fileReader = new FileReader(fileNameTwo);
        BufferedReader br=new BufferedReader(fileReader);
        while((lining=br.readLine())!=null){
          adjective.add(lining);
        }
        br.close();
      }catch(Exception ex){}

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
      System.out.println("Checked time at "+startTime);
      SimpleDateFormat day=new SimpleDateFormat("dd/MM/YYYY");
      String date=day.format(new Date());
      int personSelect=(int)(Math.floor(Math.random()*people.size()));

      try{
        Status st=twitter.updateStatus("Hey @"+people.get(personSelect)+" guess who's testing the new twitter bot rn?");
        if(startTime.substring(0,2).equals("08")){
          if(date.substring(3,5).equals("12")&&Integer.parseInt(date.substring(0,2))<25){
            //Days leading up to Christmas
            Status status=twitter.updateStatus("Good morning @"+people.get(personSelect));
          }
          else if(date.substring(3,5).equals("12")&&Integer.parseInt(date.substring(0,2))==25){
            //Christmas!
          }
          else{
            //The rest of the year
          }
        }
        else if(startTime.substring(0,2).equals("21")){
          if(date.substring(3,5).equals("12")&&Integer.parseInt(date.substring(0,2))<25){
            //Days leading up to Christmas

          }
          else if(date.substring(3,5).equals("12")&&Integer.parseInt(date.substring(0,2))==25){
            //Christmas!
          }
          else{
            //The rest of the year
          }
        }
      }catch(TwitterException e){}
      delay(60*60*1000);
    }
  }
}
