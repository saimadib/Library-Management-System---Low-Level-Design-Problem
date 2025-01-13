package LibraryManagement;

import java.util.HashMap;
import java.util.Map;

public class LibraryManager {
    private Map<String, Library> libraries;

    public LibraryManager() {
        libraries = new HashMap<>();
    }

    // Add a new library to the system
    public void addLibrary(String libraryName, String address, int maxBooks) {
        if (libraries.containsKey(libraryName)) {
            System.out.println("Library with name " + libraryName + " already exists.");
        } else {
            Library newLibrary = new Library(libraryName, address, maxBooks);
            libraries.put(libraryName, newLibrary);
            System.out.println("Library " + libraryName + " added successfully.");
        }
    }

    // Remove a library from the system
    public void removeLibrary(String libraryName) {
        if (libraries.containsKey(libraryName)) {
            libraries.remove(libraryName);
            System.out.println("Library " + libraryName + " removed successfully.");
        } else {
            System.out.println("Library " + libraryName + " does not exist.");
        }
    }

    // Get a library by name
    public Library getLibrary(String libraryName) {
        if (libraries.containsKey(libraryName)) {
            return libraries.get(libraryName);
        } else {
            System.out.println("Library " + libraryName + " does not exist.");
            return null;
        }
    }

    // Display all libraries
    public void displayLibraries() {
        if (libraries.isEmpty()) {
            System.out.println("No libraries in the system.");
        } else {
            System.out.println("Libraries in the system:");
            for (Library library : libraries.values()) {
                library.display();
                System.out.println("--------------------");
            }
        }
    }
}
