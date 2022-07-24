package com.dll.interfaceAndSuperclass;

public class Main {

    public static void main(String[] args) {
        //        home1
        Home home1 = new Home();

        home1.addSpace(getHome1Spaces());

        System.out.println(home1.getHouseSpacesDescription());
    }

    private static Space[] getHome1Spaces() {
        Space terrace = new Terrace(10, "Beautiful place to relax.");
        Space saloon = new Saloon(20, "Nice place with TV and sofas.");

        Space[] spaces = { terrace, saloon };
        return spaces;
    }
}
