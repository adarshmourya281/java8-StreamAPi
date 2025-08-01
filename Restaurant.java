package com.akshu.streams;
import java.util.*;

public class Restaurant {
    private Map<Integer, Boolean> tableAvailability;
    private Map<String, Set<Integer>> reservationDetails;
    private Map<String, Set<String>> customerContacts;

    public Restaurant() 
    {
        tableAvailability = new HashMap<>();
        reservationDetails = new HashMap<>();
        customerContacts = new HashMap<>();
    }

    public void reserveTable(String reservationID, Set<Integer> tableNumbers) 
    {
        for (int tableNumber : tableNumbers) {
            tableAvailability.put(tableNumber, false);
        }
        reservationDetails.put(reservationID, new HashSet<>(tableNumbers));
    }

    public void cancelReservation(String reservationID) 
    {
        Set<Integer> tablesToCancel = reservationDetails.get(reservationID);
        if (tablesToCancel != null) 
        {
            for (int tableNumber : tablesToCancel) 
            {
                tableAvailability.put(tableNumber, true);
            }
            reservationDetails.remove(reservationID);
        }
    }

    public void addCustomerContact(String customerName, String reservationID) 
    {
        customerContacts.computeIfAbsent(customerName, k -> new HashSet<>()).add(reservationID);
    }

    public void removeCustomerContact(String customerName)
    {
        customerContacts.remove(customerName);
    }

    public List<Integer> getAvailableTables(int partySize) {
        return tableAvailability.entrySet().stream()
                .filter(entry -> entry.getValue() && entry.getKey() >= partySize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getReservationsByCustomer(String customerName)
    {
        return customerContacts.getOrDefault(customerName, new HashSet<>()).stream().toList();
    }

    public String searchCustomerByEmail(String customerEmail) 
    {
        for (Map.Entry<String, Set<String>> entry : customerContacts.entrySet()) 
        {
            if (entry.getKey().contains(customerEmail))
            {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<Integer> getReservedTablesForReservation(String reservationID) 
    {
        return new ArrayList<>(reservationDetails.getOrDefault(reservationID, new HashSet<>()));
    }

    public static void main(String[] args) 
    {
        Restaurant restaurant = new Restaurant();

        // Test Cases
        Set<Integer> tables = new HashSet<>(Arrays.asList(1, 2, 3));
        restaurant.reserveTable("1", tables);
        restaurant.addCustomerContact("John", "1");

        System.out.println("Available Tables: " + restaurant.getAvailableTables(2)); 
        restaurant.cancelReservation("1");
        System.out.println("Available Tables after cancellation: " + restaurant.getAvailableTables(2)); 

        restaurant.addCustomerContact("Alice", "2");
        restaurant.addCustomerContact("Bob", "3");
        restaurant.addCustomerContact("Alice", "4");

        System.out.println("Reservations for Alice: " + restaurant.getReservationsByCustomer("Alice")); 

        restaurant.removeCustomerContact("Alice");
        System.out.println("Reservations for Alice after removal: " + restaurant.getReservationsByCustomer("Alice")); 

        restaurant.reserveTable("5", new HashSet<>(Collections.singletonList(4)));
        System.out.println("Reserved tables for reservation 5: " + restaurant.getReservedTablesForReservation("5")); 

        System.out.println("Customer found by email: " + restaurant.searchCustomerByEmail("ob")); 
    }
}
