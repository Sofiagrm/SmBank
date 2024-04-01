// 1.1.2 Creation of the test main class
package main;

import components.Client;

public class MainTest { 
	public static Client[] clients;
	
		
	public static void main (String[] args) {
		
		clients = loadAndReturnClientTable(5);
		
		displayArray(clients);
	
		
	}
	

	public static Client[] loadAndReturnClientTable  (int numberOfClients) {
		Client[] array_of_clients = new Client[numberOfClients];
		
		
		for (int i = 0 ; i < numberOfClients ;  i++) {
			array_of_clients[i] = new Client("name" + (i+1), "firstname" + (i+1));;
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

