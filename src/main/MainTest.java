// 1.1.2 Creation of the test main class
package main;

import components.Client;

public class MainTest { 
	public static Client[] clients;
	
		
	public static void main (String[] args) {
		
		clients = loadAndReturnClientTable(5);
		
		displayArray(clients);
		
		Client cliente = new Client("Moreira", "Sofia");
		Client cliente1 = new Client("Louro", "João");
/*		
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
	

	public static Client[] loadAndReturnClientTable  (int numberOfClients) {
		Client[] array_of_clients = new Client[numberOfClients];
		
		
		for (int i = 0 ; i < numberOfClients ;  i++) {
			array_of_clients[i] = new Client("name" + (i+1), "firstname" + (i+1));
		}

		return array_of_clients;	
	}
	
	public static void displayArray (Client[] array_of_clients) {
		System.out.println("Clients list");
		
		for (int i = 0 ; i < array_of_clients.length ; i++) {
			System.out.println(array_of_clients[i].toString());
		}
	}	
}

