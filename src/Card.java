import java.util.*;

public class Card {
    private String shape;
    private int num;
    private String strNum;
    private String[] shapeName = {"Diamond", "Clover", "Heart", "Spade"};
    private List<String> cards = new ArrayList<>();

    public Card() {
        setCards();
    }

    //getter
    public List<String> getCards() {
        return cards;
    }

    public int getNum(){
        return num;
    }

    //methods
    public void setCards(){
        this.cards.clear();
        for(int h = 0; h < 6; h++){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 13; j++){
                    cards.add(shapeName[i] + "_" + ChangeNum(j+1));
                }
            }
        }
        Collections.shuffle(cards);
    }



    public String ChangeNum(int num){
        switch(num){
            case 1:
                strNum = "A";
                break;

            case 11:
                strNum = "J";
                break;

            case 12:
                strNum = "Q";
                break;

            case 13:
                strNum = "K";
                break;

            default:
                strNum = ""+num;
        }
        return strNum;
    }

    public int CheckNum(String str){
        int num = 0;
        String result = str.substring(str.length()-1);
        if(result == "0") result = "10";

        switch(result){
            case "A":
                num = 1;
                break;

            case "2":
                num = 2;
                break;

            case "3":
                num = 3;
                break;

            case "4":
                num = 4;
                break;

            case "5":
                num = 5;
                break;

            case "6":
                num = 6;
                break;

            case "7":
                num = 7;
                break;

            case "8":
                num = 8;
                break;

            case "9":
                num = 9;
                break;

            case "10":
            case "J":
            case "Q":
            case "K":
                num = 10;
                break;
        }
        return num;
    }

    public String draw(){
        String card = cards.getLast();
        num = CheckNum(card);
        cards.removeLast();
        return card;
    }


}
