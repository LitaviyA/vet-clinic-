package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[A-Z]{1}[a-z-]{2,23}$";

    public Client registerNewClient(){
        Client client = null;

        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        if(isEmailValid(email)){

            System.out.print("First name: ");
            String firstName = Main.SCANNER.nextLine();
            if(isNameValid(firstName)) {

                System.out.print("Last name: ");
                String lastName = Main.SCANNER.nextLine();
                if(isNameValid(lastName)) {

                    System.out.print("Location: ");
                    String location = Main.SCANNER.nextLine();

                    client = buildClient(email, firstName, lastName, location);
                    System.out.println("New client: "
                            + client.getFirstName() + " "
                            + client.getLastName() + " "
                            + client.getLocation() + " ("
                            + client.getEmail() + ")");
                } else {
                    System.out.println("Provided last name is invalid.");
                }
            } else {
                System.out.println("Provided first name is invalid.");
            }
        } else {
            System.out.println("Provided email is invalid.");
        }
        return client;
    }
    private static Client buildClient(String email, String firstName, String lastName, String locationInput) {
        Client client = new Client();

        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        Client.Location location;

        try {
            location = Client.Location.valueOf(locationInput);
        } catch ( IllegalArgumentException e) {
            location = Client.Location.UNKNOWN;
            System.out.println("Unable to parse value '" + locationInput
                    + "'. Using default value: " + Client.Location.UNKNOWN);
        }

        client.setLocation(location);

        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static boolean isNameValid(String name){
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();

    }

}
