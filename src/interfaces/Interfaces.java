/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaces;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Vehicle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.service.BrazilTaxService;
import model.service.RentalService;

public class Interfaces {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        System.out.println("Entre com os dados do aluguem ");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.println("Retirada (dd/MM/yyyy HH:MM):");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Retorno (dd/MM/yyyy HH:mm):");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
        sc.close();
        
        CarRental car = new CarRental(start, finish, new Vehicle(carModel));
    
        System.out.print("Entre com o preço por hora: ");
        double pricePerHour = sc.nextDouble();
        System.out.println("Entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();
        
        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        
        rentalService.processInvoice(car);
        
        System.out.println("FATURA: ");
        System.out.println("Pagamento Básico: " + car.getInvoice().getBasicPaymant());
        System.out.println("Imposto: " + car.getInvoice().getTax());
        System.out.println("Pagamento total: " + car.getInvoice().getTotalPaymant());
    }
}
