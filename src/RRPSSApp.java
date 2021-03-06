import java.util.*;
import java.text.SimpleDateFormat;

class RRPSSApp {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int choice = 1, ch = 1;
        Reservation currentReservation;
        String contactNum;
        Date resDate;
        while (1 <= choice && choice <= 12) {
        	 try{     
        		RRPSS_IO.loadData();
	            Rev_rep_list rev_rep_list = Rev_rep_list.getInstance();
	            TablesList tablesList = TablesList.getInstance();
	            Menu menu = Menu.getInstance();
	            PromoSet promoSet = PromoSet.getInstance();
	            OrderList orderList = OrderList.getInstance();
	            ReservationList reservationList = ReservationList.getInstance();
	            StaffList staffList = StaffList.getInstance();
	
	            Date today = DateHandler.getTimeNow();
	            // refresh table
	            // tablesList.remove_old(DateHandler.parseDatetoInteger(today));
	            // remove expired reservation
	            reservationList.removeExpiredReservation(today);
	            tablesList.remove_old(DateHandler.parseDatetoInteger(today));
	
	            System.out.println("RRPSS:");
	            System.out.println("1. Check & Create/Update/Remove menu item");
	            System.out.println("2. Check & Create/Update/Remove promotion");
	            System.out.println("3. Create order");
	            System.out.println("4. View order");
	            System.out.println("5. Add/Remove order item/s to/from order");
	            System.out.println("6. Create reservation booking");
	            System.out.println("7. Check/Remove reservation booking");
	            System.out.println("8. Check table availability");
	            System.out.println("9. Print order invoice");
	            System.out.println("10. Print sale revenue report by month");
	            System.out.println("11. Add/Remove staff");
	            System.out.println("12. Check/Add tables");
	            System.out.print("Please input your choice: ");
	
	            choice = sc.nextInt();
	
	            switch (choice) {
	                case 1 : //Create/Update/Remove menu item
	                    // show current menu
	                    menu.printMenu();
	                    System.out.print("\n1. Create\n2. Update\n3. Remove\n4. cancel\nPlease input your choice: ");
	                    ch = sc.nextInt();
	                    sc.nextLine();
	                    switch (ch) {
	                        case 1 : // create new
	                            System.out.print("Please input the new menu in format \"Type, Description, Name, Price\" respectively: ");
	                            menu.addItem(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
	                            break;
	
	                        case 2 : // update
	                            System.out.print("Please input the id to be updated: ");
	                            int menuId = sc.nextInt();
	                            sc.nextLine();
	                            System.out.print("Please input the updated data in format \"Type, Description, Name, Price\" respectively: ");
	                            menu.updateMenuItem(menuId, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
	                            break;
	
	                        case 3 : // remove
	                            System.out.print("Please input the id which will be removed: ");
	                            menu.MenuItemRemove(sc.nextInt());
	                            break;
	
	                        case 4:
	                            break;
	                    }
	
	                    break;
	
	                case 2 : //Create/Update/Remove promotion
	                    promoSet.printSets();
	                    System.out.print("\n1. Create\n2. Update\n3. Remove\n4. Cancel\nPlease input your choice: ");
	                    ch = sc.nextInt();
	                    sc.nextLine();
	                    switch (ch) {
	                        case 1 : // create new
	                            System.out.print("Please input the new promo set in format \"Name, Price\" respectively: ");
	                            promoSet.addSet(sc.nextLine(), sc.nextDouble());
	                            break;
	
	                        case 2 : // update
	                            System.out.print("Please input the id to be updated: ");
	                            int promoId = sc.nextInt();
	
	                            System.out.print("1. Add new menu item to the set\n2. Remove a menu item from the set\n3. Update the data of the set\n4. Cancle\nPlease input your choice: ");
	                            int promoChoice = sc.nextInt();
	
	                            switch (promoChoice) {
	                                case 1 : // add new menu item to the set
	                                    menu.printMenu();
	                                    System.out.print("Please input the menu item id which will be inserted to the set: ");
	                                    promoSet.getSetItem(promoId).addItem(menu.getMenuItem(sc.nextInt()));
	                                    break;
	
	                                case 2 : // remove a menu item from the set
	                                	menu.printMenu();
	                                    System.out.print("Please input the menu item id which will be removed: ");
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
	                            promoSet.RemoveSet(sc.nextInt());
	                            break;
	
	                        case 4 :
	                        	break;
	                    }
	
	                    break;
	
	                case 3 : //Create order, (chl: i think better to a staff list to choose which staff)
	                    System.out.print("Input your reservation contact number: ");
	                    contactNum = sc.next();
	                    System.out.print("Please input the reservation date (in format d/m/yyyy h:m): ");
	                    sc.nextLine();
	                    resDate = DateHandler.readDate(sc.nextLine());
	
	                    if (resDate.before(DateHandler.getTimeNow())) {
	                        System.out.println ("The date have already passed...");
	                    } else if (!DateHandler.isAMSession (resDate) && !DateHandler.isPMSession (resDate)) {
	                        System.out.println ("The arrival time is out of range!");
	                    } else {
	                        currentReservation = reservationList.getReservation (resDate, contactNum);
	                        if (currentReservation == null) {
	                            System.out.println("Please make the reservation first for " + new SimpleDateFormat("d/M/yyyy a").format (resDate) + " session");
	                        } else {
	                            System.out.println ("==== STAFF LIST ====");
	                            staffList.printAll();
	                            System.out.print("Input employee id which handling this order: ");
	                            orderList.addOrder(staffList.getStaff(sc.nextInt()), currentReservation);
	                        }
	                    }
	                    break;
	
	                case 4 : //View order
	                    System.out.println ("==== ORDER LIST ====");
	                    orderList.printOrder();
	                    break;
	
	                case 5 : //Add/Remove order item/s to/from order
	                    System.out.print("Input your reservation contact number: ");
	                    contactNum = sc.next();
	                    System.out.print("Please input the reservation date (in format d/m/yyyy h:m): ");
	                    sc.nextLine();
	                    resDate = DateHandler.readDate(sc.nextLine());
	
	                    if (resDate.before(DateHandler.getTimeNow())) {
	                        System.out.println ("The date have already passed...");
	                    } else if (!DateHandler.isAMSession (resDate) && !DateHandler.isPMSession (resDate)) {
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
	                                    System.out.print("1. Add a menu item\n2. Add a set\nPlease input your choice: ");
	                                    choiceType = sc.nextInt();
	                                    System.out.print("Input the corresonding id: ");
	                                    if (choiceType == 1) currentOrder.addMenuItem (sc.nextInt());
	                                    else currentOrder.addPromotionSet (sc.nextInt());
	                                    break;
	
	                                case 2 : // remove
	                                    System.out.print("1. Remove a menu item\n2. Remove a set\nPlease input your choice: ");
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
	                    Date reservationDate = DateHandler.readDate(sc.nextLine());
	
	                    if (reservationDate.before(DateHandler.getTimeNow())) {
	                        System.out.println ("The date have already passed...");
	                    } else if (!DateHandler.isAMSession (reservationDate) && !DateHandler.isPMSession (reservationDate)) {
	                        System.out.println ("The arrival time is out of range!");
	                    } else {
	                        System.out.print("Please input reservation detail in format \"number of pax, booking name, contact number\" respectively: ");
	                        int numPax = sc.nextInt();
	                        String name = sc.next();
	                        String contactNumber = sc.next();
	
	                        int tableId = tablesList.check_get(DateHandler.parseDatetoInteger(reservationDate), numPax, "vacated", "reserved");

	
	                        if (reservationList.getReservation(reservationDate, contactNumber) != null) {
	                            System.out.println ("You cannot make another reservation with same contant number in a session...");
	                        } else if (tableId != -1) {
	                            //Reservation newReservation = new Reservation(reservationDate, numPax, name, contactNumber, tableId, tablesList);
	                            //reservationList.getReservationList().add(newReservation);
	                        	reservationList.addReservation(reservationDate, numPax, name, contactNumber, tableId, tablesList);
	                        } else System.out.println ("No table available for " + numPax + " pax");
	                        
	                        
	                    }
	                    break;
	
	                case 7 : //Check/Remove reservation booking
	                    System.out.print ("1. check one reservation\n2. remove reservation\n3. check all by date\nPlease input your choice: ");
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
	
	                            resDate = DateHandler.readDate(sc.nextLine());
	                            if (resDate.before(DateHandler.getTimeNow())) {
	                                System.out.println ("The date have already passed...");
	                            } else {
	                                reservationList.removeReservation (resDate, contactNum, tablesList);
	
	                                System.out.println("remove done!\n");
	                            }
	
	                            break;
	                            
	                        case 3:
	                        	System.out.print ("Please input the date arrival (in format d/m/yyyy h:m): ");
	                        	sc.nextLine();
	                        	resDate = DateHandler.readDate(sc.nextLine());
	                        	reservationList.checkReservationDate(resDate);
	                        	break;
	                        default :
	                            System.out.println ("No such case...");
	                    }
	                    break;
	
	                case 8 : //Check table availability
	                    System.out.print ("Input date (in format d/m/yyyy h:m): ");
	                    sc.nextLine();
	                    Date checkDate = DateHandler.readDate(sc.nextLine());
	
	                    if (checkDate.before(DateHandler.getTimeNow())) {
	                        System.out.println ("The date have already passed...");
	                    } else if (!DateHandler.isAMSession (checkDate) && !DateHandler.isPMSession (checkDate)) {
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
	                    resDate = DateHandler.readDate(sc.nextLine());
	
	                    if (resDate.before(DateHandler.getTimeNow())) {
	                        System.out.println ("The date have already passed...");
	                    } else if (!DateHandler.isAMSession (resDate) && !DateHandler.isPMSession (resDate)) {
	                        System.out.println ("The arrival time is out of range!");
	                    } else {
	                        currentReservation = reservationList.getReservation (resDate, contactNum);
	
	                        if (currentReservation == null) System.out.println ("No reservation found");
	                        else {
	                            Order currentOrder = orderList.getOrder(currentReservation);
	
	                            if (currentOrder == null) System.out.println ("No Order for this reservation found");
	                            else {
	                                currentOrder.printInvoice(menu, promoSet, rev_rep_list);
	                                // delete from map
	                                orderList.removeOrder(currentReservation);
	                            }
	                        }
	                    }
	                    break;
	
	                case 10 : //Print sale revenue report by month
	                    System.out.print("Input start month and end month (in integer): ");
	                    rev_rep_list.printReport(sc.nextInt() - 1, sc.nextInt() - 1, menu, promoSet);
	                    break;
	
	                case 11 : // add/remove staff
	                    System.out.println("==== STAFF LIST ====");
	                    staffList.printAll();
	                    System.out.print("1. Add\n2. Remove\nPlease input your choice: ");
	                    ch = sc.nextInt();
	
	                    switch (ch) {
	                        case 1 : //add
	                            System.out.print("Please input staff info in format \"name, gender, position\": ");
	                            staffList.addStaff(sc.next(), sc.next(), sc.next());
	                            break;
	
	                        case 2 : //remove
	                            System.out.print("Please input employee id which going to be removed: ");
	                            staffList.removeStaff(sc.nextInt());
	                            break;
	
	                        default :
	                            System.out.println ("No such choice...");
	                    }
	                    break;
	                case 12: //add table
	                	System.out.print("1. Check\n2. Add\nPlease input your choice: ");
	                	ch = sc.nextInt();
	          
	                	switch(ch){
	                		case 1:
	                			tablesList.printTable();
	                			break;
	                		case 2:
			                	System.out.println("Please input table quantity and max pax:");
			                	tablesList.addTable(sc.nextInt(), sc.nextInt());
			                	break;
	                	}
	            }
	
	            System.out.println();
	            // write the data again
	            RRPSS_IO.storeData();
        	}
        	catch(Exception e){
             	System.out.println(e.getMessage());
             	System.out.println("Error occured, please check your input and try again");
             	choice = 1;
             }
	   }
        
	    sc.close();
    }
}
