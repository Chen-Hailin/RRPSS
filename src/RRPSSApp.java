import java.util.*;
import java.text.SimpleDateFormat;

class RRPSSApp {
    private static RRPSS restaurant = new RRPSS();

    private static Integer parseDatetoInteger (Date dateIn) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        String date = ft.format(dateIn);
        ft = new SimpleDateFormat("a");
        if (ft.format(dateIn) == "AM") date.concat("0");
        else date.concat("1");

        return Integer.parseInt(date);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice = 1, ch = 1;
        Reservation currentReservation;
        String contactNum;
        Date resDate;

        while (1 <= choice && choice <= 10) {
            restaurant.loadData();

            System.out.println("RRPSS:");
            System.out.println("1. Create/Update/Remove menu item");
            System.out.println("2. Create/Update/Remove promotion");
            System.out.println("3. Create order");
            System.out.println("4. View order");
            System.out.println("5. Add/Remove order item/s to/from order");
            System.out.println("6. Create reservation booking");
            System.out.println("7. Check/Remove reservation booking");
            System.out.println("8. Check table availability");
            System.out.println("9. Print order invoice");
            System.out.println("10. Print sale revenue report by month");
            System.out.print("Please input your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 : //Create/Update/Remove menu item
                    // show current menu
                    Menu.getInstance().printMenu();
                    System.out.print("\n1. Create\n2. Update\n3. Remove\nPlease input your choice: ");
                    ch = sc.nextInt();

                    switch (ch) {
                        case 1 : // create new
                            System.out.print("Please input the new menu in format \"Type, Description, Name, Price\" respectively: ");
                            Menu.getInstance().addItem(1, sc.next(), sc.next(), sc.next(), sc.nextDouble());
                            break;

                        case 2 : // update
                            System.out.print("Please input the id to be updated: ");
                            int menuId = sc.nextInt();
                            System.out.print("Please input the updated data in format \"Type, Description, Name, Price\" respectively: ");
                            Menu.getInstance().updateMenuItem(menuId, sc.next(), sc.next(), sc.next(), sc.nextDouble());
                            break;

                        case 3 : // remove
                            System.out.print("Please input the id which will be removed: ");
                            Menu.getInstance().MenuItemRemove(sc.nextInt());
                            break;

                        default :
                            System.out.println("No such choice...\n");
                    }

                    break;

                case 2 : //Create/Update/Remove promotion
                    PromoSet.getInstance().printSets();
                    System.out.print("\n1. Create\n2. Update\n3. Remove\nPlease input your choice: ");
                    ch = sc.nextInt();

                    switch (ch) {
                        case 1 : // create new
                            System.out.println("Please input the new promo set in format \"Name, Price\" respectively: ");
                            PromoSet.getInstance().addSet(1, sc.next(), sc.nextDouble());
                            break;

                        case 2 : // update
                            System.out.print("Please input the id to be updated: ");
                            int promoId = sc.nextInt();

                            System.out.print("1. Add new menu to the set\n2. Remove a menu from the set\n3. Update the data of the set\nPlease input your choice: ");
                            int promoChoice = sc.nextInt();

                            switch (promoChoice) {
                                case 1 : // add new menu to the set
                                    Menu.getInstance().printMenu();
                                    System.out.print("Please input the menu id which will be inserted to the set: ");
                                    PromoSet.getInstance().getSetItem(promoId).addItem(Menu.getInstance().getMenuItem(sc.nextInt()));
                                    break;

                                case 2 : // remove a menu from the set
                                    Menu.getInstance().printMenu();
                                    System.out.print("Please input the menu id which will be removed: ");
                                    PromoSet.getInstance().getSetItem(promoId).removeItem(Menu.getInstance().getMenuItem(sc.nextInt()));
                                    break;

                                case 3 :
                                    System.out.print("Please input the updated data in format \"Name, Price\" respectively: ");
                                    PromoSet.getInstance().updateSetItem(promoId, sc.next(), sc.nextDouble());
                                    break;

                                default :
                                    System.out.println("No such choice...\n");
                            }
                            break;

                        case 3 : // remove
                        System.out.print("Please input the id which will be removed: ");
                            PromoSet.getInstance().MenuItemRemove(sc.nextInt());
                            break;

                        default :
                            System.out.println("No such choice...\n");
                    }

                    break;

                case 3 : //Create order
                    System.out.print("Input your reservation contactNumber: ");
                    contactNum = sc.next();
                    System.out.print("Please input the reservation date (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    resDate = new SimpleDateFormat("d/M/yyyy h:m").parse(sc.nextLine());
                    currentReservation = restaurant.getReservation (resDate, contactNum);
                    if (currentReservation == null) {
                        System.out.println("Please make the reservation first for " + new SimpleDateFormat("d/M/yyyy a").format (resDate) + " session");
                    } else {
                        System.out.print("Input staff handling this order in format \"employee ID, name, gender, job title\": ");
                        restaurant.getOrderList().put(currentReservation, new Order(new Staff(sc.nextInt(), sc.next(), sc.next(), sc.next()), currentReservation));
                    }
                    break;

                case 4 : //View order
                    restaurant.printOrder();
                    break;

                case 5 : //Add/Remove order item/s to/from order
                    System.out.print("Input your reservation contact number: ");
                    contactNum = sc.next();
                    System.out.print("Please input the reservation date (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    resDate = new SimpleDateFormat("d/M/yyyy h:m").parse(sc.nextLine());
                    currentReservation = restaurant.getReservation (resDate, contactNum);

                    if (currentReservation == null) System.out.println ("No reservation found");
                    else {
                        currentReservation.check();
                        System.out.print("1. Add\n2. Remove\nPlease input your choice: ");
                        ch = sc.nextInt();

                        Order currentOrder = restaurant.getOrderList().get(currentReservation);
                        currentOrder.print(Menu.getInstance(), PromoSet.getInstance());

                        System.out.println ("==== OUR MENU AND SETS =====");
                        Menu.getInstance().printMenu();
                        PromoSet.getInstance().printSets();

                        int choiceType;

                        switch (ch) {
                            case 1 : // add
                                System.out.print("1. Add a menu\n2. Add a set\nPlease input your choice: ");
                                choiceType = sc.nextInt();
                                System.out.print("Input the corresonding id: ");
                                if (choiceType == 1) currentOrder.addMenuItem (sc.nextInt());
                                else currentOrder.addPromotionSet (sc.nextInt());
                                break;

                            case 2 : // remove
                                System.out.print("1. Remove a menu\n2. Remove a set\nPlease input your choice: ");
                                choiceType = sc.nextInt();
                                System.out.print("Input the corresonding id: ");
                                if (choiceType == 1) currentOrder.removeMenuItem (sc.nextInt());
                                else currentOrder.removePromotionSet (sc.nextInt());
                                break;

                            default :
                                System.out.println("No such choice...");
                        }
                    }
                    break;

                case 6 : //Create reservation booking
                    //TODO: check arrival date --> possible or not
                    System.out.print("Please input the reservation date arrival (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    Date reservationDate = new SimpleDateFormat("d/M/yyyy h:m").parse(sc.nextLine());

                    System.out.print("Please input reservation detail in format \"number of pax, booking name, contact number\" respectively: ");
                    int numPax = sc.nextInt();
                    String name = sc.next();
                    String contactNumber = sc.next();
                    int tableId = TablesList.getInstance().check_get(Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(reservationDate)), numPax, "vacated", "reserved");

                    if (tableId != -1) {
                        Reservation newReservation = new Reservation(reservationDate, numPax, name, contactNumber, tableId);
                        restaurant.getReservationList().add(newReservation);
                    } else System.out.println ("No table available for " + numPax + " pax");
                    break;

                case 7 : //Check/Remove reservation booking
                    System.out.print ("1. check reservation\n2. remove reservation\nPlease input your choice: ");
                    ch = sc.nextInt();
                    System.out.print ("Please input the particular contact number: ");

                    contactNum = sc.next();

                    switch (ch) {
                        case 1 : // find reservation w.r.t. contact number
                            restaurant.checkReservation (contactNum);
                            break;

                        case 2 : // TODO: remove --> need to modify
                            System.out.println ("Please input the date arrival (in format d/m/yyyy h:m): ");
                            sc.nextLine();

                            restaurant.removeReservation (new SimpleDateFormat("d/M/yyyy h:m").parse(sc.nextLine()), contactNum);

                            System.out.println("remove done!\n");
                            break;

                        default :
                            System.out.println ("No such case...");
                    }
                    break;

                case 8 : //Check table availability
                    System.out.print ("Input date (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    Date checkDate = new SimpleDateFormat("d/M/yyyy h:m").parse(sc.nextLine());

                    System.out.print ("Input the pax number: ");
                    int idx = TablesList.getInstance().check_get(parseDatetoInteger(checkDate), sc.nextInt(), "vacated", "vacated");

                    if (idx == -1) System.out.println ("No available table found");
                    else System.out.println ("There is an available table");
                    break;

                case 9 : //Print order invoice -> delete order
                    System.out.print("Input your reservation contact number: ");
                    contactNum = sc.next();
                    System.out.print("Please input the reservation date (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    resDate = new SimpleDateFormat("d/M/yyyy h:m").parse(sc.nextLine());
                    currentReservation = restaurant.getReservation (resDate, contactNum);

                    if (currentReservation == null) System.out.println ("No reservation found");
                    else {
                        Order currentOrder = restaurant.getOrderList().get(currentReservation);

                        if (currentOrder == null) System.out.println ("No Order for this reservation found");
                        else {
                            currentOrder.printInvoice(Menu.getInstance(), PromoSet.getInstance());
                            // delete from map
                            restaurant.getOrderList().remove(currentReservation);
                        }
                    }
                    break;

                case 10 : //Print sale revenue report by month
                    System.out.print("Input start month and end month (in integer): ");
                    Rev_rep_list.getInstance().printReport(sc.nextInt() - 1, sc.nextInt() - 1, Menu.getInstance(), PromoSet.getInstance());
                    break;
            }

            // write the data again
            restaurant.storeData();
        }

        // TODO: refresh table, revenue report list
        sc.close();
    }
}
