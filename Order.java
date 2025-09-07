import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

public class Order {
    private int id;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items;
    private double total;

    public Order() {
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
    }

    public void addItem(OrderItem item) {
        if (item != null) {
            this.items.add(item);
            recalculateTotal();
        }
    }

    public void removeItem(OrderItem item) {
        if (item != null) {
            this.items.remove(item);
            recalculateTotal();
        }
    }

    private void recalculateTotal() {
        this.total = this.items.stream()
                .mapToDouble(OrderItem::getItemTotal)
                .sum();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public List<OrderItem> getItems() {
        return items;
    }
    public double getTotal() {
        return total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("Order Moment: " ).append(sdf.format(new java.util.Date())).append("\n");
        sb.append("Order status: ").append(status).append("\n");
        sb.append("Client: ").append(client.getName());
        sb.append(" (").append(sdf.format(client.getBirthDate())).append(") - ");
        sb.append(client.getEmail()).append("\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Total price: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }
}
