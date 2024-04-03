// 1.1.1 Creation of the client class

package components;

public class Client {
	private String name = "";
	private String firstName = "";
	private int clientNr;
	
	private static int nrOfClients= 0;	
	
	public Client (String name, String firstName) {
		this.name = name;
		this.firstName = firstName;		
		this.clientNr = Client.nrOfClients;
		
		Client.nrOfClients += 1; // this.clientNumber = this.clientNumber + 1;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the lastName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return the clientNr
	 */
	public int getClientNr() {
		return clientNr;
	}


	public String toString() {
		String newLine = System.getProperty("line.separator");
		
	    return "Client Nr : " + this.clientNr + ""
	    		.concat(newLine)
	            .concat("  Name : " + this.name)
	            .concat(newLine)
	            .concat("  First name : " + this.firstName)
	            .concat(newLine)
	            .concat("--------------------");

	}

	public static void main(String[] args) {
		
		Client client1 = new Client("Sofia", "Moreira");
	
		System.out.println(client1.toString());	
		System.out.println("Name of client1 : " + client1.getName());
		System.out.println("LastName client1 : " + client1.getFirstName());
		System.out.println("Client number of client1 : " + client1.getClientNr());
		System.out.println("Changing client1");
		client1.setName("Manel");
		client1.setLastName("Manel");
		System.out.println("client1 changed");
		System.out.println("Name of client1 : " + client1.getName());
		System.out.println("LastName client1 : " + client1.getFirstName());
		System.out.println("Client number of client1 : " + client1.getClientNr());
		
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println();
		System.out.println();
		
		Client client2 = new Client("João", "Gonçalves");
		
		System.out.println("Name of client2 : " + client2.getName());
		System.out.println("LastName client2 : " + client2.getFirstName());
		System.out.println("Client number of client2 : " + client2.getClientNr());
		System.out.println("Changing client2");
		client2.setName("Asdrubal");
		client2.setLastName("Anibal");
		System.out.println("client2 changed");
		System.out.println("Name of client2 : " + client2.getName());
		System.out.println("LastName client2 : " + client2.getFirstName());
		System.out.println("Client number of client2 : " + client2.getClientNr());
	}
}
