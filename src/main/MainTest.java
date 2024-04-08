// 1.1.2 Creation of the test main class
package main;

import java.util.ArrayList;

import components.Client;
import components.CurrentAccount;
import components.SavingsAccount;
import components.Account;

public class MainTest { 
	public static Client[] clients;
	public static ArrayList<Client> clientsList = new ArrayList<Client>();
	public static ArrayList<Account> accountList = new ArrayList<Account>();

		
	public static void main (String[] args) {
		
		//with array
        clients = loadAndReturnClientTableArray(5);		
        displayClientsArray(clients);
        
        //with ArrayList
        clientsList = loadAndReturnClientTableArrayList(5);
        displayClientsArrayList(clientsList);
		
		accountList = loadAndReturnAccountTableArrayList(5);
		displayAccountArrayList(accountList);
		
		
		
/*		
		Client cliente = new Client("Moreira", "Sofia");
		Client cliente1 = new Client("Louro", "João");
		
		Account conta = new Account("conta a ordem", cliente);
		Account conta1 = new Account("conta a ordem", cliente);

		System.out.println("Label da conta - " + conta.getLabel());
		
		conta.setLabel("conta a prazo");
		
		System.out.println("Nova label da conta - " + conta.getLabel());
	
		
		
		System.out.println("Label da conta - " + conta1.getClient().toString());
		
		conta1.setClient(cliente1);

		System.out.println("Label da conta - " + conta1.getClient().toString());
		
		System.out.println("Nuemro da conta1 - " + conta1.getaccountNumber());
		
		System.out.println(conta1.toString());
		*/
	}
	

	public static Client[] loadAndReturnClientTableArray  (int numberOfClients) {
		
		Client[] array_of_clients = new Client[numberOfClients];
		
		for (int i = 0 ; i < numberOfClients ;  i++) {
			array_of_clients[i] = new Client("name_with_array" + (i+1), "firstname_with_array" + (i+1));
		}

		return array_of_clients;	
	}
	
	public static ArrayList<Client> loadAndReturnClientTableArrayList (int numberOfClients) {

		ArrayList<Client> clientListtoReturn = new ArrayList<Client>();
		
		for (int i = 0 ; i < numberOfClients ;  i++) {
			clientListtoReturn.add(new Client("name_with_array_list" + (i+1), "firstname_with_array_list" + (i+1)));
		}
		
		return clientListtoReturn;
	}

	public static ArrayList<Account> loadAndReturnAccountTableArrayList (int numberOfAccount) {

		ArrayList<Account> accountListtoReturn = new ArrayList<Account>();
		
		for (int i = 0 ; i < numberOfAccount ;  i++) {
			if(i % 2 == 0) {
				accountListtoReturn.add(new CurrentAccount(new Client("louro", "joao")));	
			}
			else {
				accountListtoReturn.add(new SavingsAccount(new Client("louro", "joao")));
			}
		}
		
		return accountListtoReturn;
	}
	
	public static void displayClientsArray (Client[] array_of_clients) {
		System.out.println("Clients list with array");
		
		for (int i = 0 ; i < array_of_clients.length ; i++) {
			System.out.println(array_of_clients[i].toString());
		}
	}
	
	public static void displayClientsArrayList (ArrayList<Client> array_list_of_clients) {
		System.out.println("Clients list with arrayList");

		System.out.println(array_list_of_clients.size());
		
		for( Client client : array_list_of_clients) {
			System.out.println("vou imporimir na consola");
			System.out.println(client.toString());
		}
	}

	public static void  displayAccountArrayList(ArrayList<Account> array_list_of_accounts) {
		System.out.println("Account List");
		
		System.out.println(array_list_of_accounts.size());
		

		
		for( Account account: array_list_of_accounts) {
			System.out.println(account.toString());
		}
	}
}

