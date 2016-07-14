package AddressBook;
/**
*
* @author Peter Wong
*/


import AddressBook.controller.AddressBookController;
import AddressBook.model.HibernateDB;
import AddressBook.model.Person;
import AddressBook.view.AddressBookView;

public class AddressBook {

	public static void main(String[] args) {

		Person model  = new Person();
		AddressBookView view = new AddressBookView();
		AddressBookController controller = new AddressBookController(model, view);

		controller.startMenu();
		
	}

}
