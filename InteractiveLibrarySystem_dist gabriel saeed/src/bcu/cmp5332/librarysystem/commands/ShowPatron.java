package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;
import java.util.List;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

public class ShowPatron implements Command {
	private int id;
	
	public ShowPatron(int id)
	{
		this.id = id;
	}
	
	@Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {
        
        Patron patron = library.getPatronByID(id);
        System.out.println(patron.getDetailsLong());
        
    }
	
}
