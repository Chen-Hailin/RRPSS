import java.util.ArrayList;

public class Rev_report implements Serializable {    
    private double totalRevenue;
    private List<Order> orders;
	
	public Rev_Report() {
        orders = new ArrayList<Order>;
        totalRevenue = 0;
	}
    
    public double getTotalRevenue() {
        return totalRevenue();
    }
    
    public List<Order> getOrders() {
        return orders;
    }
	
    /**
    * Add an order to this report.
    * @param order The order going to be added.
    * @param totalRevenue The total revenue of this order.
    */
    public void addOrder(Order order, totalRevenue) {
        orders.add(order);
        this.totalRevenue += totalRevenue;
    }
    
    /**
    * Print the report details.
    */
    public void print() {
        System.out.println("Revenue report:");
        for (Order order: orders) {
            order.print();
        }
        System.out.println("Total revenue this month: " + getTotalRevenue());
    }
}
