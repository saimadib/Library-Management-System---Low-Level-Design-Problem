package PatronManagement;

import java.util.Map;
import java.util.HashMap;

public class PatronManager {
    // Contain the mapping of patron with ISBN string for easy access
    private Map<String, Patron> patrons;

    // Constructor
    public PatronManager(){
        patrons = new HashMap<>();
    }

    // Add Patron to the patrons map
    public void addPatron(Patron patron){
        patrons.put(patron.getEmail(), patron);
    }

    // remove Patron from the patrons map
    public void removePatron(Patron patron){
        patrons.remove(patron.getEmail());
    }

    // Update Patron's information
    public void updatePatron(Patron patron, String name, String email, String phoneNumber){
        if(patrons.containsKey(patron.getEmail())){
            patron.setName(name);
            patron.setEmail(email);
            patron.setPhoneNumber(phoneNumber);
        }
    }

    // Search Patron by email
    public Patron searchByEmail(String email){
        for(Patron patron : patrons.values()){
            if(patron.getEmail().equals(email)){
                return patron;
            }
        }
        return null;
    }
}
