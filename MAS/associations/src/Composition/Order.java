package Composition;

public class Order {
    //public not only for simplicity, but also to make everything less crowded with all the getters and setters
    public int orderId;
    private Customer customer;
    private Order(Customer customer, int orderId) {
        this.orderId = orderId;
        this.customer = customer;
    }
    public static Order createOrder(Customer customer, int orderId) throws Exception {
        if(customer == null) {
            throw new Exception("The given customer does not exist, can not create an order without a customer.");
        }
        Order order = new Order(customer, orderId);
        customer.addOrder(order);
        return order;
    }
}
