package main.java.com.magicvet.componet;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

public class ApplicationRunner {

    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();
    public void run() {
        if (Authenticator.auth()){
            Client client = clientService.registerNewClient();

            if(client != null){
                System.out.print("Do you want to add pet now? yes/no: ");
                String answerClient = Main.SCANNER.nextLine();
                if(answerClient.equals("yes")){
                    System.out.println("Adding a new pet.");
                    Pet pet = petService.registerNewPet();
                    client.setPet(pet);
                    pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                    System.out.println("Pet has been added.");
                } else if (!answerClient.equals("no")) {
                    System.out.println("Select yes or no.");
                }
            }
        }
    }

}
