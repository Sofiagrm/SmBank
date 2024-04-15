// 1.1.2 Creation of the test main class
package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import components.Account;
import components.Client;
import components.Credit;
import components.CurrentAccount;
import components.Debit;
import components.Flow;
import components.SavingsAccount;
import components.Transfer;

public class MainTest { 
	public static Client[] clients;
	public static ArrayList<Client> clientsList = new ArrayList<Client>();
	public static ArrayList<Account> accountList = new ArrayList<Account>();
	public static Hashtable<Integer, Account> accountsMap = new Hashtable<Integer, Account>();
	public static ArrayList<Flow> flowList = new ArrayList<Flow>();

		
	public static void main (String[] args) {
		
		//create clients list with array
        clients = loadAndReturnClientTableArray(5);		
        //displayClientsArray(clients);
        
        //1.1.2 create clients list with ArrayList
        clientsList = loadAndReturnClientTableArrayList(5);
        //displayClientsArrayList(clientsList);
		
        //1.2.3 create accounts list with ArrayList
		accountList = loadAndReturnAccountTableArrayList(5);
		//displayAccountArrayList(accountList);
		
		//1.3.1 adapt account list to account map
		accountsMap = accountsArrayListtoHashTable(accountList);
		//displayAccountTable(accountsMap);
		
		//1.3.4 create flows array list
		flowList = loadDataToFlowArrayList();
		//displayFlowList(flowList);
		
		//1.3.5 apply flows list to accounts on accounts map
		updateUdateAccountsWithFlows(flowList, accountsMap);
		//displayAccountsMap(accountsMap);
		
		
		// prepate files data load 
		clearLists();
		
		
		//2.1 load flow list with data from json file
		flowList = loadFlowsFromJsonFile(flowList);
		displayFlowList(flowList);
		
		//2.2 accounts list from xml file
		accountList = loadAccountsFromXMLFile(accountList);
		displayAccountArrayList(accountList);
		accountsMap = accountsArrayListtoHashTable(accountList);
		displayAccountsMap(accountsMap);
		updateUdateAccountsWithFlows(flowList, accountsMap);
		//displayAccountsMap(accountsMap);
		
	}
	
	public static void clearLists () {
		accountList = new ArrayList<Account>();
		accountsMap = new Hashtable<Integer, Account>();
		flowList = new ArrayList<Flow>();
		Account.resetNrOfAccounts();

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
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Accounts List");
		
		System.out.println(array_list_of_accounts.size() + " Accounts");	

		System.out.println();
		
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
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Accounts Table");
		
		System.out.println("Number of accounts : " + accountsTable.size());	
		
		// Create a synchronized list from the values of accountsTable
		List<Account> list_of_accounts = Collections.synchronizedList(new ArrayList<>(accountsTable.values()));

		// Sort the list if Account implements Comparable<Account>
		Collections.sort(list_of_accounts);

		// Assuming displayAccountArrayList method takes an ArrayList<Account> as argument
		//displayAccountArrayList(new ArrayList<>(list_of_accounts));
		
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
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Accounts Table");	
		System.out.println("Number of accounts : " + accounts_table.size());
		
		System.out.println();
		System.out.println();

		for(Entry<Integer, Account> entry : accounts_table.entrySet()) {
			System.out.println(entry.getValue().toString().concat(newLine).concat(newLine));
		}
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
	
	public static void displayFlowList(ArrayList<Flow> flow_list) {
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Flow List");
		System.out.println("Number of flows : " + flow_list.size());
		
		System.out.println();
		System.out.println();
		
		for(Flow f : flow_list) {
			System.out.println(f.toString());
		}
	}
	
	public static void updateUdateAccountsWithFlows(ArrayList<Flow> flow_array, Hashtable<Integer, Account> accounts_table) {

		for(Flow f : flow_array) {
			if(f.getClass() == Transfer.class)
			{
				accounts_table.get(f.getAccountNr()).setBalance(f);
				accounts_table.get(((Transfer)f).getIssuingAccountNr()).setBalance(f);
			}
			else
			{
				accounts_table.get(f.getAccountNr()).setBalance(f);
			}
		}		

		Optional<Account> accountWithNegativeBalance = accounts_table.values().stream()
			.filter(account -> account.getBalance() < 0)
			.findAny();

		accountWithNegativeBalance.ifPresent(account -> System.out.println("Account " + account.getaccountNumber() + " has a negative balance."));
		
	}
	
	public static ArrayList<Flow> loadFlowsFromJsonFile (ArrayList<Flow> flow_list) {
		Path flows_file = Paths.get("./assets/flows.json");
		JsonArray json_array = null;
		
	    try {
            JsonReader jsonReader = Json.createReader(Files.newBufferedReader(flows_file));
            json_array = jsonReader.readArray();
            jsonReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String comment = "";
		double amount = 0.0;
		int accountNr  = 0;
		boolean effect = false;
		LocalDate date = null;
		int issuingAccountNr = 0;

		for(int i = 0; i < json_array.size(); i++) {
	    	JsonObject flow = json_array.getJsonObject(i);
	    		    	
			comment = flow.getString("comment");
			amount = Double.parseDouble(flow.getJsonNumber("amount").toString());
			accountNr  = flow.getInt("accountNr");
			effect = flow.getBoolean("effect");
			date = LocalDate.parse(flow.getString("date"));

	    	if("Transfer".equals(flow.getString("type"))) {
				issuingAccountNr = flow.getInt("issuingAccountNr");
				Transfer f = new Transfer(comment, amount, accountNr, effect, date, issuingAccountNr);
				flowList.add(f);
	    	}
	    	else if("Debit".equals(flow.getString("type"))) {
				Debit f = new Debit(comment, amount, accountNr, effect, date);
				flowList.add(f);
	    	}
	    	else {
				Credit f = new Credit(comment, amount, accountNr, effect, date);
				flowList.add(f);
	    	}
	    }
		
		return flow_list;
	}
	
	
	public static ArrayList<Account> loadAccountsFromXMLFile (ArrayList<Account> accounts_list) {
		Path xmlFilePath = Paths.get("./assets/accounts.xml");

		try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(Files.newInputStream(xmlFilePath));

            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();

            NodeList element_list = root.getElementsByTagName("account");

    		String accountLabel = "";
    		String clientName  = "";
    		String clientFirstName = "";
    		
            for(int i = 0 ; i < element_list.getLength() ; i++) {
            	NodeList account = element_list.item(i).getChildNodes();
            	
            	for(int j = 0 ; j < account.getLength() ; j++) {                	
            		if(account.item(j).getNodeType() == 3) {
                		continue;
                	}
            		
                	String node_name = account.item(j).getNodeName();
                	String value = account.item(j).getTextContent().trim();

                	switch(node_name) {
            			case "label": 
            				accountLabel = value;
            				break;
            			case "client":
            				NodeList client = account.item(j).getChildNodes();
            				for (int k = 0; k < client.getLength(); k++) {
            				    Node childNode = client.item(k);
            				    
            				    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
            				        String nodeName = childNode.getNodeName();
            				        
            				        if ("name".equals(nodeName)) {
            				        	clientName = childNode.getTextContent().trim();
            				        } else if ("firstname".equals(nodeName)) {
            				        	clientFirstName = childNode.getTextContent().trim();
            				        }
            				    }
            				}
            				break;
                	}
            	}
            	
            	
            	if("Savings".equals(accountLabel)) {
            		accounts_list.add(new SavingsAccount(new Client(clientName, clientFirstName)));
            	}
            	else if ("Current".equals(accountLabel)) {
            		accounts_list.add(new CurrentAccount(new Client(clientName, clientFirstName)));
            	}

            }
            
		} catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
		}

		return accounts_list;
	}
}