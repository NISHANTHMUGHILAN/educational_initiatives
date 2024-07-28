// Component interface
interface Product {
    String getDescription();
    double getCost();
}

// Concrete Component
class BasicProduct implements Product {
    @Override
    public String getDescription() {
        return "Basic Product";
    }

    @Override
    public double getCost() {
        return 20.0;
    }
}

// Decorator class
abstract class ProductDecorator implements Product {
    protected Product decoratedProduct;

    public ProductDecorator(Product decoratedProduct) {
        this.decoratedProduct = decoratedProduct;
    }

    public String getDescription() {
        return decoratedProduct.getDescription();
    }

    public double getCost() {
        return decoratedProduct.getCost();
    }
}

// Concrete Decorator
class GiftWrappedProduct extends ProductDecorator {
    public GiftWrappedProduct(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public String getDescription() {
        return decoratedProduct.getDescription() + ", Gift Wrapped";
    }

    @Override
    public double getCost() {
        return decoratedProduct.getCost() + 5.0;
    }
}

// Main class
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Product basicProduct = new BasicProduct();
        System.out.println(basicProduct.getDescription() + " costs $" + basicProduct.getCost());

        Product giftWrappedProduct = new GiftWrappedProduct(basicProduct);
        System.out.println(giftWrappedProduct.getDescription() + " costs $" + giftWrappedProduct.getCost());
    }
}
