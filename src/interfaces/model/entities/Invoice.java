
package interfaces.model.entities;

public class Invoice {
    private double basicPaymant;
    private double tax;
    
    public Invoice() {
        
    }

    public Invoice(double basicPaymant, double tax) {
        this.basicPaymant = basicPaymant;
        this.tax = tax;
    }

    public double getBasicPaymant() {
        return basicPaymant;
    }

    public void setBasicPaymant(double basicPaymant) {
        this.basicPaymant = basicPaymant;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    
    public double getTotalPaymant() {
        return getBasicPaymant() - getTax();
    }
    
}
