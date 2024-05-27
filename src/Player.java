import java.util.*;

public class Player extends Card {

   private int score = 0;
   private int check = 0;
   private Map<Integer, String> hand = new HashMap<>();
   private List<Integer> handNum = new ArrayList<>();

   public Player() {
       score = 0;
       check = 0;
   }

   public String getHand(int blind) {
       String hand = "";
       switch (blind) {
           case 1:
               hand = this.hand.get(0) + " =BLINDED=";
               break;
           case 2:
               for (int i = 0; i < this.hand.size(); i++) {
                   hand += this.hand.get(i) + " ";
               }
               break;
       }
       return hand;
   }
    public int getHandLen(){
        return hand.size();
    }

    public int getScore(){
       return score;
    }

    public void setScore(){
       int cnt = Collections.frequency(this.handNum, 1);
       switch(cnt){
           case 1:
               if(getNum()==1){
                   if(score <= 10){
                       score += 11;
                   }else{
                       score += 1;
                       check++;
                   }
               }else{
                   if(score + getNum() > 21){
                       if(check == 0){
                           score += getNum()-10;
                           check++;
                       }else {
                           score += getNum();
                       }
                   }else{
                       score += getNum();
                   }
               }
               break;

           case 2:
               if(getNum()==1){
                   score += 1;
                   check++;
               }else{
                   if(score + getNum() > 21){
                       if(check == 0){
                           score += getNum()-10;
                           check++;
                       }else {
                           score += getNum();
                       }
                   }else{
                       score += getNum();
                   }
               }
               break;

           case 0:
               score += getNum();
               break;

           default:
               if(getNum()==1){
                   score += 11;
               }else{
                   score += getNum();
               }
               break;
       }
    }


    public void reset(){
        hand.clear();
        handNum.clear();
        score = 0;
        check = 0;
    }


    public void drawStore(){
        hand.put(hand.size(),draw());
        handNum.add(getNum());
        setScore();
    }

}
