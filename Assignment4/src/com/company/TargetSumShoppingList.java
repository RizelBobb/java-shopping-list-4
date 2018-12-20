package com.company;

import java.util.Scanner;

//inheriting properties from the ShoppingList Class
public class TargetSumShoppingList extends ShoppingList {

    //selection sort

    public void sortItems() {

        //using selection sort algo to sort java items
        System.out.print("Press Y to sort list (Y): ");
        Scanner scan = new Scanner(System.in);
        String userResponse = scan.nextLine();
        if (userResponse.equalsIgnoreCase("Y")) {
            int arraySize = items.length;
            for (int i = 0; i < arraySize - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < arraySize; j++) {
                    if (items[j].getPriority() < items[min_idx].getPriority())
                        min_idx = j;
                }
                ShoppingListItem temp = items[min_idx];
                items[min_idx] = items[i];
                items[i] = temp;
            }
            System.out.println("\nSorted by priority");
            for (int y = 0; y < arraySize; ++y) {
                System.out.println(items[y].getName() + " $" + Math.floor(items[y].getPrice()) + " priority " + items[y].getPriority());
                System.out.println("the total is " + items[y].getTotal());
            }
        } else if (!userResponse.equalsIgnoreCase("Y")) {
            throw new IllegalArgumentException("you are required to respond yes (Y) to sort");
        }
    }

    public void goShopping() {
        double newSum = 0;
        double targetSum = 59;

        System.out.println("\nthe list we are choosing from for prices");
        for (int j = 0; j < items.length; j++) {
            System.out.println(items[j].getName() + " $" + Math.floor(items[j].getPrice()) + " priority " + items[j].getPriority());
        }

        for (int i = 0; i < 7; i++) {
            //if the item price is less than 59, add them together
            if (items[i].getPrice() < targetSum) {
                newSum += items[i].getPrice();

            } else if (items[i].getPrice() > targetSum) {
                //if the item price is greater than 59, don't add them together. These items are rejected
                System.out.println("Today, you cannot afford " + items[i].getName() + " $" + Math.floor(items[i].getPrice()) + " priority " + items[i].getPriority());
                continue;
            }
            if (newSum <= targetSum) {
                //if the new added items are less than 59, then print the items
                System.out.println("You can afford " + items[i].getName() + " for  $" + Math.floor(items[i].getPrice()) + " priority " + items[i].getPriority());

            } else if (newSum > targetSum) {
                //if the new added items are greater than 59, then print the items
                newSum -= items[i].getPrice();
                System.out.println("Today, you cannot afford " + items[i].getName() + " $" + Math.floor(items[i].getPrice()) + " priority " + items[i].getPriority());


            }
        }


    }

}

