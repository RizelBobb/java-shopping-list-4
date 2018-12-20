package com.company;

import java.util.Scanner;

//shop is an interface that uses 3 methods
//abstract class can't be initiated
abstract class ShoppingList implements Shop {
    //num of items constant in the array
    private final int NUM_ITEMS = 7;
    public ShoppingListItem[] items;
    //the random prices have to be at least $15 for the total to equal 100+
    private double sum = 0;

    public ShoppingListItem[] getShoppingListItems() {
        return items;
    }


    private void setItems(ShoppingListItem[] items) {
        this.items = items;
    }


    public void askUserForItems() {
        System.out.println("List name, comma, priority");
        ShoppingListItem[] shoppingList = new ShoppingListItem[NUM_ITEMS];

        Scanner scan = new Scanner(System.in);
        //the user will input an item name and a priority number..that will be added to the shopping list object
        for (int i = 0; i < shoppingList.length; i++) {
            String line = scan.nextLine();
            String input[] = line.split("\\s*,\\s*");
            //if the user's input begins with a space or is only a space, throw an exception
            //accept input if letters, some symbols and spaces in between
            if (!input[0].matches("^[a-zA-Z_'&-]+( [a-zA-Z_'&-]+)*$")) {
                throw new IllegalArgumentException("enter only letters and symbols");
            }
            //if the user input's less than 2 items, throw an exception
            if (input.length < 2) {
                throw new IllegalArgumentException("Missing commas or items. Only inserted:" + input.length + " items");

            }
            //if the user inputs more than 2 items, throw an exception
            if (input.length > 2) {
                throw new IllegalArgumentException("Too many items");
            }
            String itemName = input[0];
            for (int j = 0; j < i; j++) {
                //if item name is a duplicate, throw an exception

                if (itemName.equalsIgnoreCase(shoppingList[j].getName())) {
                    throw new IllegalArgumentException(itemName + " item name already exists in the list");
                }

            }

            int priorityInput = Integer.parseInt(input[1]);
            for (int k = 0; k < i; k++) {
                //if priority is a duplicate, throw an exception..I think it would be easier to only have one priority
                if (priorityInput == shoppingList[k].getPriority()) {
                    throw new IllegalArgumentException(priorityInput + " priority num already exists in the list");
                }

            }

            System.out.println("just added to the list: " + itemName + " priority :" + priorityInput);

            double priceInput = Math.random() * 100;
            double formattedPrice = Math.floor(priceInput * 100) / 100;
            //if the total is less than 100, find out the difference between the sum and 100
            if (sum < 100) {
                //divide the remainder by the number of items
                double remainder = (100 - sum) / NUM_ITEMS;
                //add it to each item
                formattedPrice += remainder;
            }
            sum += Math.floor(formattedPrice);
            ShoppingListItem listItem = new ShoppingListItem(itemName, priorityInput, formattedPrice, sum);

            shoppingList[i] = listItem;
        }

        setItems(shoppingList);
        for (int f = 0; f < items.length; f++) {
            System.out.println("\nInitial Shopping List");
            System.out.println(items[f].getName() + " $" + Math.floor(items[f].getPrice()) + " priority " + items[f].getPriority());
            System.out.println("the total is " + items[f].getTotal());
        }

    }

}