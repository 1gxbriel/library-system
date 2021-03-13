package bcu.cmp5332.librarysystem.commands;

import java.time.LocalDate;
import java.util.List;

import bcu.cmp5332.librarysystem.main.LibraryException;
import bcu.cmp5332.librarysystem.model.Book;
import bcu.cmp5332.librarysystem.model.Library;
import bcu.cmp5332.librarysystem.model.Patron;

public class ShowBook implements Command {
	private int id;
	
	public ShowBook(int id)
	{
		this.id = id;
	}
	
	@Override
    public void execute(Library library, LocalDate currentDate) throws LibraryException {
        
        Book book = library.getBookByID(id);
        System.out.println(book.getDetailsLong());
        
    }
	
}
