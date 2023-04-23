package com.dashboard.autodashboard;
/* 
COP 3530 PROJECT
ENTERTAINMENT SYSTEM CAR FEATURE
CONTRIBUTOR AJ CARDOZA
*/

import java.util.*;

public class Entertainment extends Navigation {

    public static void main(String[] args) {
        System.out.println("Ford Entertainment System Activated");

        Queue<String> entertainmentQueue = new LinkedList<>();
        entertainmentQueue.offer("CarPlay");
        entertainmentQueue.offer("Radio");
        entertainmentQueue.offer("Bluetooth");
        entertainmentQueue.offer("Phone");

        try (Scanner scanner = new Scanner(System.in)) {

        while (!entertainmentQueue.isEmpty()) {
            String option = entertainmentQueue.poll();
            System.out.println("Select entertainment option");
            String response = scanner.nextLine();

            switch (response.toLowerCase()) {
                case "carplay":
                    activateCarPlay();
                    break;
                case "radio":
                    activateRadio();
                    break;
                case "bluetooth":
                    activateBluetooth();
                    break;
                case "phone":
                    activatePhone();
                    break;
                default:
                    System.out.println("Invalid option.");
                    entertainmentQueue.offer(option);
                    break;
                }
            }
        }
    }

    private static void activateCarPlay() {
        System.out.println("Activating CarPlay...");

        try (Scanner scanner = new Scanner(System.in)) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Select Option: ");
            System.out.println("1. Phone");
            System.out.println("2. Music");
            System.out.println("3. Maps");
            System.out.println("4. Return to dashboard");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Opening Phone...");
                    activatePhone();
                    break;
                case 2:
                    System.out.println("Opening Music...");
                    activateMusic();
                    break;
                case 3:
                    System.out.println("Opening Maps...");
                    activateMaps();
                    break;
                case 4:
                    System.out.println("Returning to dashboard...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
                }
            }
        }
    }

    private static void activateRadio() {
        System.out.println("Activating Radio...");

        boolean isRunning = true;
        String radioType = "AM";
        int radioFrequency = 530;
        int[] presetFrequencies = new int[] { 630, 790, 920, 1110, 1180, 1240, 1290, 1590 };

        while (isRunning) {
            System.out.println("Select Option: ");
            System.out.println("1. Change radio type (AM/FM)");
            System.out.println("2. Tune frequency");
            System.out.println("3. Select preset");
            System.out.println("4. Scan for stations");
            System.out.println("5. Return to dashboard");

            try (Scanner scanner = new Scanner(System.in)) {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (radioType.equals("AM")) {
                        radioType = "FM";
                    } else {
                        radioType = "AM";
                    }
                    System.out.println("Radio type changed to " + radioType);
                    break;
                case 2:
                    System.out.println("Enter frequency (in kHz):");
                    int newFrequency = scanner.nextInt();
                    if (radioType.equals("AM") && newFrequency >= 630 && newFrequency <= 1590) {
                        radioFrequency = newFrequency;
                        System.out.println("Tuned to " + radioFrequency + " kHz");
                    } else if (radioType.equals("FM") && newFrequency >= 88 && newFrequency <= 108) {
                        radioFrequency = newFrequency;
                        System.out.println("Tuned to " + radioFrequency + " MHz");
                    } else {
                        System.out.println("Invalid frequency for " + radioType + " radio.");
                    }
                    break;
                case 3:
                    System.out.println("Select preset (1-6):");
                    int presetIndex = scanner.nextInt() - 1;
                    if (presetIndex >= 0 && presetIndex < presetFrequencies.length) {
                        radioFrequency = presetFrequencies[presetIndex];
                        System.out.println("Tuned to preset " + (presetIndex + 1) + " (" + radioFrequency + " kHz)");
                    } else {
                        System.out.println("Invalid preset selection.");
                    }
                    break;
                case 4:
                    System.out.println("Scanning for stations...");
                    int scanStart;
                    int scanEnd;
                    if (radioType.equals("AM")) {
                        scanStart = 630;
                        scanEnd = 1590;
                    } else {
                        scanStart = 88;
                        scanEnd = 108;
                    }
                    for (int i = scanStart; i <= scanEnd; i += 10) {
                        if (i != radioFrequency) {
                            System.out.println("Found station at " + i + (radioType.equals("AM") ? " kHz" : " MHz"));
                        }
                    }
                    System.out.println("Scan complete.");
                    break;
                case 5:
                    System.out.println("Returning to dashboard...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
                }
            }
        }
    }

    private static void activateMusic() {
        System.out.println("Activating Music...");
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Select Option: ");
            System.out.println("1. Playlist");
            System.out.println("2. Library");
            System.out.println("3. Browse");
            System.out.println("4. Listen Now");
            System.out.println("5. Return to dashboard");

            try (Scanner scanner = new Scanner(System.in)) {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Retrieving Playlists...");
                    break;
                case 2:
                    System.out.println("Retrieving Library...");
                    break;
                case 3:
                    System.out.println("Browsing Music...");
                    break;
                case 4:
                    System.out.println("Listening Now...");
                    break;
                case 5:
                    System.out.println("Returning to dashboard...");
                    isRunning = false;
                    break;
                default:
                    break;
                }
            }
        }
    }

    private static void activateMaps() {
        System.out.println("Activating Maps...");

        try (Scanner scanner = new Scanner(System.in)) {
        Navigation navigation = new Navigation();

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Set destination");
            System.out.println("2. Find nearby places");
            System.out.println("3. Favorites");
            System.out.println("4. Return to dashboard");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter destination:");
                    String destination = scanner.next();
                    navigation.setCurrentLocation("Your current location");
                    navigation.setDestination(destination);
                    System.out.println("Calculating route to " + destination + "...");
                    List<String> directions = navigation.getDirections();
                    for (String direction : directions) {
                        System.out.println(direction);
                    }
                    break;
                case 2:
                    System.out.println("Please update software to activate feature...");
                    break;
                case 3:
                    System.out.println("Please update software to activate feature...");
                    break;
                case 4:
                    System.out.println("Returning to dashboard...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
                }
            }
        }
    }

    private static void activateBluetooth() {
        System.out.println("Activating Bluetooth...");
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Select Option: ");
            System.out.println("1. Music");
            System.out.println("2. Phone");
            System.out.println("3. Return to dashboard");

            try (Scanner scanner = new Scanner(System.in)) {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Music Selected");
                    activateMusic();
                    break;
                case 2:
                    System.out.println("Phone Selected");
                    activatePhone();
                    break;
                case 3:
                    System.out.println("Returning to dashboard...");
                    isRunning = false;
                    break;
                default:
                    break;
                }
            }
        }
    }

    private static void activatePhone() {
        boolean isRunning = true;
        String phoneNumber = "";
        boolean isDialing = false;
        boolean isConnected = false;

        System.out.println("Activating phone");

        while (isRunning) {
            System.out.println("Select Option: ");
            System.out.println("1. Favorites");
            System.out.println("2. Recent");
            System.out.println("3. Contacts");
            System.out.println("4. Keypad");
            System.out.println("5. Return to dashboard");

            try (Scanner scanner = new Scanner(System.in)) {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Retrieving Favorites...");
                    System.out.println("No contacts in Favorits");
                    break;
                case 2:
                    System.out.println("Retrieving Recent Calls...");
                    System.out.println("No recent calls in history");
                    break;
                case 3:
                    System.out.println("Retrieving Contacts");
                    System.out.println("No contacts found.");
                    break;
                case 4:
                    System.out.println("Keypad Selected");
                    System.out.println("Enter phone number: ");
                    phoneNumber = scanner.next();
                    isDialing = true;
                    break;
                case 5:
                    System.out.println("Returning to dashboard...");
                    isRunning = false;
                    isDialing = false;
                    isConnected = false;
                    break;
                default:
                    break;
            }

            if (isDialing) {
                System.out.println("Dialing " + phoneNumber);
                System.out.println("Connected...");
                isConnected = true;

                while (isConnected) {
                    System.out.println("Select Option: ");
                    System.out.println("1. Hold");
                    System.out.println("2. Mute");
                    System.out.println("3. End Call");

                    int dialOption = scanner.nextInt();

                    switch (dialOption) {
                        case 1:
                            System.out.println("Call has been placed on hold");
                            System.out.println("Resume Call (Y/N)");
                            String resumeOption = scanner.next();
                            if (resumeOption.equalsIgnoreCase("Y")) {
                                System.out.println("Resuming Call");
                            } else {
                                System.out.println("Call disconnected");
                                isConnected = false;
                            }
                            break;
                        case 2:
                            System.out.println("Call has been muted");
                            System.out.println("Unmute Call (Y/N)");
                            String unmuteOption = scanner.next();
                            if (unmuteOption.equalsIgnoreCase("Y")) {
                                System.out.println("Call has been unmuted");
                            } else {
                                System.out.println("Call disconnected");
                                isConnected = false;
                            }
                            break;
                        case 3:
                            System.out.println("Call disconnected");
                            isConnected = false;
                            isDialing = false;
                            break;
                        default:
                            break;
                        }
                    }

                }
            }
        }
    }
}
