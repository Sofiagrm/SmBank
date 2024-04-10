// 1.1.2 Creation of the test main class
package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import components.Client;
import components.Credit;
import components.CurrentAccount;
import components.Debit;
import components.Flow;
import components.SavingsAccount;
import components.Transfer;
import components.Account;

public class MainTest { 
	public static Client[] clients;
	public static ArrayList<Client> clientsList = new ArrayList<Client>();
	public static ArrayList<Account> accountList = new ArrayList<Account>();
	public static Hashtable<Integer, Account> accountsMap = new Hashtable<Integer, Account>();
	public static ArrayList<Flow> flowList = new ArrayList<Flow>();

		
	public static void main (String[] args) {
		
		//with array
        clients = loadAndReturnClientTableArray(5);		
        //displayClientsArray(clients);
        
        //with ArrayList
        clientsList = loadAndReturnClientTableArrayList(5);
        //displayClientsArrayList(clientsList);
		
		accountList = loadAndReturnAccountTableArrayList(5);
		//displayAccountArrayList(accountList);
		
		accountsMap = accountsArrayListtoHashTable(accountList);
		//displayAccountTable(accountsMap);
		
		flowList = loadDataToFlowArrayList();
		
		
		updateUdateAccountsWithFlows(flowList, accountsMap);
		
		
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
				accountListtoReturn.add(new CurrentAccount(new Client("moreira", "sofia")));	
			}
			else {
				accountListtoReturn.add(new SavingsAccount(new Client("moreira", "sofia")));
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
			System.out.println(account);
		}
	}
	
	public static Hashtable<Integer, Account> accountsArrayListtoHashTable (ArrayList<Account> array_list_of_accounts ) {
		Hashtable<Integer, Account> accountsTable = new Hashtable<Integer, Account>();
		
		for( Account account: array_list_of_accounts) {
			accountsTable.put(account.getaccountNumber(), account);
		}
		
		return accountsTable;
	}
	
	public static void displayAccountTable(Hashtable<Integer, Account> accountsTable) {
		System.out.println("Accounts Table");
		
		System.out.println(accountsTable.size());	
		
		// Create a synchronized list from the values of accountsTable
		List<Account> list_of_accounts = Collections.synchronizedList(new ArrayList<>(accountsTable.values()));

		// Sort the list if Account implements Comparable<Account>
		Collections.sort(list_of_accounts);

		// Assuming displayAccountArrayList method takes an ArrayList<Account> as argument
		displayAccountArrayList(new ArrayList<>(list_of_accounts));
		
		/*
		String newLine = System.getProperty("line.separator");
		
		String print = "Accounts Table".concat(newLine).concat(newLine);		
		
		for(Map.Entry<Integer, Account> entry : list_of_accounts.entrySet()) {
			print.concat("Account Numnber : " + entry.getKey().toString())
				.concat(newLine)
				.concat("Account : ")
				.concat(newLine).concat(newLine)
				.concat(entry.getValue().toString())
				.concat(newLine).concat(newLine);			

		}
		*/
	}
	
	public static void displayAccountsMap (Hashtable<Integer, Account> accounts_table) {
		String newLine = System.getProperty("line.separator");
		
		//String print = 
		System.out.println("Accounts Table".concat(newLine).concat(newLine));

		for(Entry<Integer, Account> entry : accounts_table.entrySet()) {
			System.out.println(entry.getValue().toString().concat(newLine).concat(newLine));
		}
		
		//System.out.println(print);
	}
	
	
	public static ArrayList<Flow> loadDataToFlowArrayList() {
		ArrayList<Flow> flowList = new ArrayList<Flow>();
		
		Debit flow_1 = new Debit("debit - 50€ from account nr 1", 50.0, 1, false, LocalDate.now().plusDays(2));
		flowList.add(flow_1);
				
		for(Account a : accountList) {
			if (CurrentAccount.class == a.getClass()) {
				Credit flow_2 = new Credit("credit - 100.5€ on account nr " + a.getaccountNumber(), 100.5, a.getaccountNumber(), false, LocalDate.now().plusDays(2));
				flowList.add(flow_2);				
			}
		}
		
		for(Account a : accountList) {
			if (SavingsAccount.class == a.getClass()) {
				Credit flow_3 = new Credit("credit - 1500€ on account nr " + a.getaccountNumber(), 100.5, a.getaccountNumber(), false, LocalDate.now().plusDays(2));
				flowList.add(flow_3);				
			}
		}
		
		Transfer flow_4 = new Transfer("tranfer - 50€€ from account nr 1 to account nr 2", 50.0, 1, false, LocalDate.now().plusDays(2), 2);
		flowList.add(flow_4);
		
		return flowList;
	}
	
	public static void updateUdateAccountsWithFlows(ArrayList<Flow> flow_array, Hashtable<Integer, Account> accounts_table) {

		for(Flow f : flow_array) {
			System.out.println(f.toString());
			accounts_table.get(f.getAccountNr()).setBalance(f);
		}
		
		displayAccountsMap(accounts_table);
		

		Optional<Account> accountWithNegativeBalance = accounts_table.values().stream()
			.filter(account -> account.getBalance() < 0)
			.findAny();

		accountWithNegativeBalance.ifPresent(account -> System.out.println("Account " + account.getaccountNumber() + " has a negative balance."));
		
	}
}