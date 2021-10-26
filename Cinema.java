package cinema;

import java.util.Scanner;


public class Cinema {

    static int seatNumber;
    static int rowNumber;
    static char[][] seats;
    static int totalSeat;
    static int purchasedTicked = 0;
    static int currentIncome = 0;
    static int totalIncome;
    private static double percentage;

    public static void main(String[] args) {



    
 programStart();
        








        }

    private static void programStart() {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        rowNumber = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatNumber = scan.nextInt();
        totalSeat = seatNumber * rowNumber;

        seats = new char[rowNumber][seatNumber];

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'S';

            }



        }
        mainMenu();
    }

    public static void mainMenu(){
        Scanner scan = new Scanner(System.in);


        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +"3. Statistics\n" +
                "0. Exit");
        int input = scan.nextInt();

        switch (input){
            case 1: showSeats();
            break;
            case 2: buyTicked();
            break;
            case 3:
                showStatistics();
                break;
            case 0: exit();
            break;
        }



    }

    private static void exit() {
    }

    private static void buyTicked() {
        Scanner scan = new Scanner(System.in);
    int tickedPrice;

        System.out.println("Enter a row number:");
        int selectedRowNumber = scan.nextInt();
        System.out.println("Enter a seat number in that row:");
        int selectedSeatNumber = scan.nextInt();

        if (selectedRowNumber>rowNumber || selectedSeatNumber>seatNumber){
            System.out.println("Wrong input\n");
            buyTicked();

        }

        else if (seats[selectedRowNumber-1][selectedSeatNumber-1] == 'B'){
            System.out.println("That ticket has already been purchased!\n");
        buyTicked();}
        else{
            seats[selectedRowNumber-1][selectedSeatNumber-1] = 'B';

            purchasedTicked += 1;



            if (totalSeat<=60){
                tickedPrice = 10;
                totalIncome = totalSeat*10;}
            else
            {
                if(rowNumber%2==0) {
                    if (selectedRowNumber <= rowNumber/2)
                        tickedPrice =10;
                    else
                        tickedPrice = 8;
                }
                else
                {

                    if (selectedRowNumber <= rowNumber/2)
                        tickedPrice =10;
                    else
                        tickedPrice = 8;

                }


            }

            System.out.print("Ticket price: $");
            System.out.println(tickedPrice+"\n");

            currentIncome += tickedPrice;

        }


        mainMenu();

    }

    private static void showSeats() {

        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < seatNumber; i++) {
            System.out.print(" "+(i+1));

        }
        System.out.println();

        for (int i = 0; i < rowNumber; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < seatNumber; j++) {
                System.out.print((seats[i][j])+" ");
            }
            System.out.println();

        }
        System.out.println();

        mainMenu();
    }

    public static void showStatistics() {



        percentage = (double) ((double)purchasedTicked/(double) totalSeat)*100;

        System.out.println("Number of purchased tickets: " +purchasedTicked);
        System.out.printf("Percentage: %.2f", percentage);
        System.out.println("%");
        System.out.println("Current income: $" + currentIncome);


        if (totalSeat<=60)
        totalIncome = totalSeat*10;
        else
        {
            if(rowNumber%2==0) {
                totalIncome = totalSeat*9;
            }
            else
            {

         totalIncome = (int)(rowNumber/2+1)*8*seatNumber + (rowNumber/2)*10*seatNumber;

            }}
            System.out.println("Total income: $" +totalIncome+ "\n");

        mainMenu();





} }
