package Oop;

public class Main {
	public static void main(String[] args) {
		int sayi1 = 10;
		int sayi2 = 20;
		sayi1 = sayi2;
		sayi2 = 100;
		System.out.println(sayi1);// 20
		////////////////////////////////
		int[] sayilar1 = { 1, 2, 3 };
		int[] sayilar2 = { 4, 5, 6 };
		sayilar1 = sayilar2;
		sayilar2[0] = 100;
		//////////////////////////////////
		System.out.println(sayilar1[0]);// 100
		CreditManager creditManager = new CreditManager();
		creditManager.Calculate();
		creditManager.Save();

		Customer customer = new Customer();
		customer.Id = 1;
		customer.City = "Ankara";

		CustomerManager customerManager = new CustomerManager(customer);
		customerManager.Delete();
		customerManager.Save();
		/////////////////////////
		Company company = new Company();
		company.TaxNumber = "32434";
		company.CompanyName = "Arçelik";
		company.Id = 110;
		CustomerManager customerManager2 = new CustomerManager(new Company());
		Person person = new Person();
		person.FirstName = "Hatice";
		person.LastName = "Zehra";

		Customer c1 = new Customer();// INHERİTANCE
		Customer c2 = new Person();// INHERİTANCE
		Customer c3 = new Company();// INHERİTANCE
		CustomerManager customerManager1=new CustomerManager(new Customer(),new MilitaryCreditManager());
		customerManager1.GiveCredit();
	}
}

class CreditManager {
	public void Calculate() {
		System.out.println("Hesaplandi");
	}

	public void Save() {
		System.out.println("Kredi Verildi");
	}

}

class Customer {
	// Özellikler
	public int Id;

	public String City;

	/*
	 * public Customer(int id, String firstName, String lastName, String
	 * nationalIdentity, String city) { super(); Id = id; FirstName = firstName;
	 * LastName = lastName; NationalIdentity = nationalIdentity; City = city; }
	 */

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

}

class CustomerManager {
	private Customer customer;
	ICreditManager iCreditManager;

	public CustomerManager(Customer customer, ICreditManager iCreditManager) {
		super();
		this.customer = customer;
		this.iCreditManager = iCreditManager;
	}

	public CustomerManager(Customer customer) {
		super();
		this.customer = customer;
	}

	public void Save() {

		System.out.println("Müşteri Kaydedildi." + customer.Id);
	}

	public void Delete() {

		System.out.println("Müşteri Silindi." + customer.Id);
	}
	public void GiveCredit()
	{
		iCreditManager.Calculate();
		System.out.println("Kredi Verildi");
	}
}

class Company extends Customer {
	public String TaxNumber;
	public String CompanyName;

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getTaxNumber() {
		return TaxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		TaxNumber = taxNumber;
	}
}

class Person extends Customer {
	public String NationalIdentity;
	public String FirstName;
	public String LastName;

	public String getNationalIdentity() {
		return NationalIdentity;
	}

	public void setNationalIdentity(String nationalIdentity) {
		NationalIdentity = nationalIdentity;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

}

interface ICreditManager {
	void Calculate();

	void Save();
}

abstract class BaseCreditManager implements ICreditManager
{
	public abstract void Calculate();
	public void Save()
	{
		System.out.println("Kaydedildi");
	}
}

class TeacherCreditManager  extends BaseCreditManager implements ICreditManager  {

	@Override
	public void Calculate() {
		System.out.println("Öğretmen  kredisi hesaplandı.");

	}

	

}

class MilitaryCreditManager  extends BaseCreditManager implements ICreditManager {

	@Override
	public void Calculate() {
		System.out.println("Asker kredisi hesaplandı.");

	}

	

}