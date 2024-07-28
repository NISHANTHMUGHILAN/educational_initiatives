// Abstract class
abstract class OrderProcessor {
    // Template method
    public final void processOrder() {
        selectItem();
        addItemToCart();
        payment();
        delivery();
        confirmation();
    }

    protected abstract void selectItem();
    protected abstract void addItemToCart();
    protected abstract void payment();
    protected abstract void delivery();
    protected abstract void confirmation();
}

// Concrete class
class OnlineOrderProcessor extends OrderProcessor {
    @Override
    protected void selectItem() {
        System.out.println("Item selected from online store.");
    }

    @Override
    protected void addItemToCart() {
        System.out.println("Item added to online shopping cart.");
    }

    @Override
    protected void payment() {
        System.out.println("Payment made online.");
    }

    @Override
    protected void delivery() {
        System.out.println("Item delivered to home address.");
    }

    @Override
    protected void confirmation() {
        System.out.println("Order confirmation email sent.");
    }
}

// Concrete class
class InStoreOrderProcessor extends OrderProcessor {
    @Override
    protected void selectItem() {
        System.out.println("Item selected from store shelf.");
    }

    @Override
    protected void addItemToCart() {
        System.out.println("Item added to physical shopping cart.");
    }

    @Override
    protected void payment() {
        System.out.println("Payment made at store checkout.");
    }

    @Override
    protected void delivery() {
        System.out.println("Item carried out of store.");
    }

    @Override
    protected void confirmation() {
        System.out.println("Order confirmation receipt printed.");
    }
}

// Main class
public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        OrderProcessor onlineOrder = new OnlineOrderProcessor();
        OrderProcessor inStoreOrder = new InStoreOrderProcessor();

        System.out.println("Processing online order:");
        onlineOrder.processOrder();

        System.out.println("\nProcessing in-store order:");
        inStoreOrder.processOrder();
    }
}
