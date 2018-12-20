package com.company;

public class Main {

    public static void main(String[] args) {
        //can't initiate shopping list because it's abstract. initiate targeSum
        ShoppingList list = new TargetSumShoppingList();
        //calling methods from class
        list.askUserForItems();
        list.sortItems();
        list.goShopping();
    }
}
