/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.service;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Invoice;
import java.time.Duration;

/**
 *
 * @author User
 */
public class RentalService {
    private double pricePerHour;
    private double pricePerDay;
    
    private BrazilTaxService taxService;

    public RentalService(double pricePerHour, double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }
    
    public void processInvoice(CarRental carRental) {
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;
        
        double basicPaymant;
        if (hours <= 12.0) {
            basicPaymant = pricePerHour * Math.ceil(hours);
        }
        else {
            basicPaymant = pricePerDay *Math.ceil( hours / 24.0);
        }
        
        double tax = taxService.tax(basicPaymant);
        
        carRental.setInvoice(new Invoice(50.0, 10.0));
    }
}
