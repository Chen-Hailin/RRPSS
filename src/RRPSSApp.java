import java.util.*;
import java.text.SimpleDateFormat;

class RRPSSApp {
    private static Scanner sc = new Scanner(System.in);

    private static Date readDate() throws Exception{
        return new SimpleDateFormat("d/M/yyyy H:m").parse(sc.nextLine());
    }

    public static void main(String[] args) throws Exception {
        int choice = 1, ch = 1;
        Reservation currentReservation;
        String contactNum;
        Date resDate;

        while (1 <= choice && choice <= 10) {
            RRPSS_IO.loadData();

            Rev_rep_list rev_rep_list = Rev_rep_list.getInstance();
            TablesList tablesList = TablesList.getInstance();
            Menu menu = Menu.getInstance();
            PromoSet promoSet = PromoSet.getInstance();
            OrderList orderList = OrderList.getInstance();
            ReservationList reservationList = ReservationList.getInstance();

            Date today = DateHandler.getTimeNow();
            // refresh table
//            tablesList.remove_old(DateHandler.parseDatetoInteger(today));
            // remove expired reservation
            reservationList.removeExpiredReservation(today);

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
                    menu.printMenu();
                    System.out.print("\n1. Create\n2. Update\n3. Remove\nPlease input your choice: ");
                    ch = sc.nextInt();

                    switch (ch) {
                        case 1 : // create new
                            System.out.print("Please input the new menu in format \"Type, Description, Name, Price\" respectively: ");
                            menu.addItem(sc.next(), sc.next(), sc.next(), sc.nextDouble());
                            break;

                        case 2 : // update
                            System.out.print("Please input the id to be updated: ");
                            int menuId = sc.nextInt();
                            System.out.print("Please input the updated data in format \"Type, Description, Name, Price\" respectively: ");
                            menu.updateMenuItem(menuId, sc.next(), sc.next(), sc.next(), sc.nextDouble());
                            break;

                        case 3 : // remove
                            System.out.print("Please input the id which will be removed: ");
                            menu.MenuItemRemove(sc.nextInt());
                            break;

                        default :
                            System.out.println("No such choice...\n");
                    }

                    break;

                case 2 : //Create/Update/Remove promotion
                    promoSet.printSets();
                    System.out.print("\n1. Create\n2. Update\n3. Remove\nPlease input your choice: ");
                    ch = sc.nextInt();

                    switch (ch) {
                        case 1 : // create new
                            System.out.print("Please input the new promo set in format \"Name, Price\" respectively: ");
                            promoSet.addSet(1, sc.next(), sc.nextDouble());
                            break;

                        case 2 : // update
                            System.out.print("Please input the id to be updated: ");
                            int promoId = sc.nextInt();

                            System.out.print("1. Add new menu to the set\n2. Remove a menu from the set\n3. Update the data of the set\nPlease input your choice: ");
                            int promoChoice = sc.nextInt();

                            switch (promoChoice) {
                                case 1 : // add new menu to the set
                                    menu.printMenu();
                                    System.out.print("Please input the menu id which will be inserted to the set: ");
                                    promoSet.getSetItem(promoId).addItem(menu.getMenuItem(sc.nextInt()));
                                    break;

                                case 2 : // remove a menu from the set
                                	menu.printMenu();
                                    System.out.print("Please input the menu id which will be removed: ");
                                    promoSet.getSetItem(promoId).removeItem(menu.getMenuItem(sc.nextInt()));
                                    break;

                                case 3 :
                                    System.out.print("Please input the updated data in format \"Name, Price\" respectively: ");
                                    promoSet.updateSetItem(promoId, sc.next(), sc.nextDouble());
                                    break;

                                default :
                                    System.out.println("No such choice...\n");
                            }
                            break;

                        case 3 : // remove
                        System.out.print("Please input the id which will be removed: ");
                            promoSet.MenuItemRemove(sc.nextInt());
                            break;

                        default :
                            System.out.println("No such choice...\n");
                    }

                    break;

                case 3 : //Create order, (chl: i think better to a staff list to choose which staff)
                    System.out.print("Input your reservation contactNumber: ");
                    contactNum = sc.next();
                    System.out.print("Please input the reservation date (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    resDate = readDate();

                    if (!DateHandler.isAMSession (resDate) && !DateHandler.isPMSession (resDate)) {
                        System.out.println ("The arrival time is out of range!");
                    } else {
                        currentReservation = reservationList.getReservation (resDate, contactNum);
                        if (currentReservation == null) {
                            System.out.println("Please make the reservation first for " + new SimpleDateFormat("d/M/yyyy a").format (resDate) + " session");
                        } else {
                            System.out.print("Input staff handling this order in format \"employee ID, name, gender, job title\": ");
                            orderList.getOrderList().put(currentReservation, new Order(new Staff(sc.nextInt(), sc.next(), sc.next(), sc.next()), currentReservation));
                        }
                    }
                    break;

                case 4 : //View order
                    orderList.printOrder();
                    break;

                case 5 : //Add/Remove order item/s to/from order
                    System.out.print("Input your reservation contact number: ");
                    contactNum = sc.next();
                    System.out.print("Please input the reservation date (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    resDate = readDate();

                    if (!DateHandler.isAMSession (resDate) && !DateHandler.isPMSession (resDate)) {
                        System.out.println ("The arrival time is out of range!");
                    } else {
                        currentReservation = reservationList.getReservation (resDate, contactNum);

                        if (currentReservation == null) System.out.println ("No reservation found");
                        else {
                            currentReservation.check();
                            System.out.print("1. Add\n2. Remove\nPlease input your choice: ");
                            ch = sc.nextInt();

                            Order currentOrder = orderList.getOrderList().get(currentReservation);
                            currentOrder.print(menu, promoSet);

                            System.out.println ("==== OUR MENU AND SETS =====");
                            menu.printMenu();
                            promoSet.printSets();

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
                    }
                    break;

                case 6 : //Create reservation booking
                    System.out.print("Please input the reservation date arrival (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    Date reservationDate = readDate();
                    if (!DateHandler.isAMSession (reservationDate) && !DateHandler.isPMSession (reservationDate)) {
                        System.out.println ("The arrival time is out of range!");
                    } else {
                        System.out.print("Please input reservation detail in format \"number of pax, booking name, contact number\" respectively: ");
                        int numPax = sc.nextInt();
                        String name = sc.next();
                        String contactNumber = sc.next();
                        int tableId = tablesList.check_get(DateHandler.parseDatetoInteger(reservationDate), numPax, "vacated", "reserved");

                        if (tableId != -1) {
                            Reservation newReservation = new Reservation(reservationDate, numPax, name, contactNumber, tableId, tablesList);
                            reservationList.getReservationList().add(newReservation);
                        } else System.out.println ("No table available for " + numPax + " pax");
                    }
                    break;

                case 7 : //Check/Remove reservation booking
                    System.out.print ("1. check reservation\n2. remove reservation\nPlease input your choice: ");
                    ch = sc.nextInt();

                    switch (ch) {
                        case 1 : // find reservation w.r.t. contact number
                            System.out.print ("Please input the particular contact number: ");

                            contactNum = sc.next();
                            reservationList.checkReservation (contactNum);
                            break;

                        case 2 : // remove
                            System.out.print ("Please input the particular contact number: ");

                            contactNum = sc.next();
                            System.out.print ("Please input the date arrival (in format d/m/yyyy h:m): ");
                            sc.nextLine();

                            reservationList.removeReservation (readDate(), contactNum, tablesList);

                            System.out.println("remove done!\n");
                            break;

                        default :
                            System.out.println ("No such case...");
                    }
                    break;

                case 8 : //Check table availability
                    System.out.print ("Input date (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    Date checkDate = readDate();

                    if (!DateHandler.isAMSession (checkDate) && !DateHandler.isPMSession (checkDate)) {
                        System.out.println ("The input time is out of range!");
                    } else {
                        System.out.print ("Input the pax number: ");
                        int idx = tablesList.check_get(DateHandler.parseDatetoInteger(checkDate), sc.nextInt(), "vacated", "vacated");

                        if (idx == -1) System.out.println ("No available table found");
                        else System.out.println ("There is an available table");
                    }
                    break;

                case 9 : //Print order invoice -> delete order
                    System.out.print("Input your reservation contact number: ");
                    contactNum = sc.next();
                    System.out.print("Please input the reservation date (in format d/m/yyyy h:m): ");
                    sc.nextLine();
                    resDate = readDate();

                    if (!DateHandler.isAMSession (resDate) && !DateHandler.isPMSession (resDate)) {
                        System.out.println ("The arrival time is out of range!");
                    } else {
                        currentReservation = reservationList.getReservation (resDate, contactNum);

                        if (currentReservation == null) System.out.println ("No reservation found");
                        else {
                            Order currentOrder = orderList.getOrderList().get(currentReservation);

                            if (currentOrder == null) System.out.println ("No Order for this reservation found");
                            else {
                                currentOrder.printInvoice(menu, promoSet, rev_rep_list);
                                // delete from map
                                orderList.getOrderList().remove(currentReservation);
                            }
                        }
                    }
                    break;

                case 10 : //Print sale revenue report by month
                    System.out.print("Input start month and end month (in integer): ");
                    rev_rep_list.printReport(sc.nextInt() - 1, sc.nextInt() - 1, menu, promoSet);
                    break;
            }

            // write the data again
            RRPSS_IO.storeData();
        }

        sc.close();
    }
}
