import java.util.Scanner;

public class Casino {
    public Casino(){
        Scanner sc = new Scanner(System.in);
        Card card = new Card();
        Dealer dealer = new Dealer();
        Player player = new Player();
        int  bet, choice;
        float money = 1000;


        while(true){
            boolean h = true;
            dealer.reset();
            player.reset();

            if(card.getCards().size()<10){
                card.setCards();
            }

            System.out.println("-----------------------------------------");
            System.out.println("<MONEY : "+money+">");
            System.out.println("<BETTING>");
            System.out.print(">>>> ");
            bet = sc.nextInt();

            while(bet>money){
                System.out.println();

                System.out.println("<MONEY : "+money+">");
                System.out.println("<RE-BETTING>");
                System.out.print(">>>> ");
                bet = sc.nextInt();
            }

            System.out.println();
            System.out.println("<DEALER>");
            for(int i=0;i<=1;i++) {
                dealer.drawStore();
            }
            System.out.println(dealer.getHand(1));

            System.out.println();
            System.out.println("<PLAYER>");
            for(int i=0;i<=1;i++) {
                player.drawStore();
            }
            System.out.println(player.getHand(2));

            System.out.println("<player : "+player.getScore()+">");


            while(h){

                System.out.println();
                System.out.println("1.Hit 2.Double Down 3.Stand");
                System.out.print(">>>> ");
                choice = sc.nextInt();

                switch(choice) {
                    case 1:
                        System.out.println("<<Hit!>>");
                        player.drawStore();
                        System.out.println("<PLAYER>");
                        System.out.println(player.getHand(2) + "-> "+ "<player : "+player.getScore()+">");

                        if(player.getScore() > 21) {
                            h = false;
                            break;
                        }

                        continue;

                    case 2:
                        System.out.println("<<Double Down!>>");
                        bet *= 2;
                        System.out.println("<Bet : "+bet+">");
                        player.drawStore();
                        System.out.println("<PLAYER>");
                        System.out.println(player.getHand(2)+ "-> "+ "<player : "+player.getScore()+">");

                        if(player.getScore() <= 21){
                            while(dealer.getScore() < 17){
                                System.out.println();
                                System.out.println("<DEALER>");
                                System.out.println(dealer.getHand(2)+ "-> "+ "<dealer : "+dealer.getScore()+">");
                                dealer.drawStore();
                            }
                            System.out.println();
                            System.out.println("<DEALER>");
                            System.out.println(dealer.getHand(2)+ "-> "+ "<dealer : "+dealer.getScore()+">");
                        }

                        h = false;
                        break;

                    case 3:
                        System.out.println("<<Stand!>>");
                        while(dealer.getScore() < 17){
                            System.out.println();
                            System.out.println("<DEALER>");
                            System.out.println(dealer.getHand(2)+ "-> "+ "<dealer : "+dealer.getScore()+">");
                            dealer.drawStore();
                        }
                        System.out.println();
                        System.out.println("<DEALER>");
                        System.out.println(dealer.getHand(2)+ "-> "+ "<dealer : "+dealer.getScore()+">");


                        h = false;

                }


            }

            if(player.getScore()>21){
                System.out.println();
                System.out.println("<Bust!>");

                money -= bet;
                System.out.println();
                System.out.println("<<LOSE>>");
                System.out.println("<MONEY : "+money+">");

            }else if(dealer.getScore() > 21){
                if(player.getHandLen() == 2 && player.getScore() == 21){
                    money += (float) (1.5 * bet);
                    System.out.println();
                    System.out.println("<BlackJack!!!>");
                }else{
                    money += bet;
                }
                System.out.println();
                System.out.println("<<WIN>>");
                System.out.println("<MONEY : "+money+">");
            }else{
                if(player.getScore() <= 21){
                    if(player.getHandLen() == 2 && player.getScore() == 21){
                        money += (float) (1.5 * bet);
                        System.out.println();
                        System.out.println("<BlackJack!!!>");

                        System.out.println();
                        System.out.println("<<WIN>>");
                        System.out.println("<MONEY : "+money+">");
                    }else{
                        if(dealer.getScore() > player.getScore()){
                            money -= bet;
                            System.out.println();
                            System.out.println("<<LOSE>>");
                            System.out.println("<MONEY : "+money+">");
                        }else if(dealer.getScore() == player.getScore()){
                            System.out.println();
                            System.out.println("<<DRAW>>");
                            System.out.println("<MONEY : "+money+">");
                        }else{
                            money += bet;
                            System.out.println();
                            System.out.println("<<WIN>>");
                            System.out.println("<MONEY : "+money+">");
                        }
                    }

                }
            }



            System.out.println();
            System.out.print("CONTINUE? (Y/N) : ");
            String select = sc.next();

            switch(select) {
                case "Y":
                case "y":
                    System.out.println();
                    System.out.println("-----------------------------------------");
                    continue;
                case "N":
                case "n":
                    System.out.println("Ending Game...");
                    System.out.println();
                    return;
            }




        }
    }

}
