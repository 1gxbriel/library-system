package bcu.cmp5332.librarysystem.commands;

import bcu.cmp5332.librarysystem.data.LibraryData;
import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

import java.io.IOException;
import java.time.LocalDate;

public class AddPatron implements Command {

    private final String name;
    private final String phone;

    public AddPatron(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {
    	int lastIndex = library.getPatrons().size() - 1;
        int maxId = 0;
        if (lastIndex >= 0)
        	maxId = library.getPatrons().get(lastIndex).getId();
        Patron patron = new Patron(++maxId, name, phone);
        try {
	        library.addPatron(patron);
	        LibraryData.store(library);
	        System.out.println("Patron #" + patron.getId() + " added.");
        } catch (IOException e) {
        	library.deletePatron(patron.getId());
        	throw new LibraryException(FILE_ERROR_MESSAGE);
        }
    }
}
