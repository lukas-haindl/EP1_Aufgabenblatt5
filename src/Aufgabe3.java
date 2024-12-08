/*
    Aufgabe 3) Zweidimensionale Arrays
*/

import java.util.Random;

public class Aufgabe3 {

    private static boolean[][] genAnimalCompound(int compoundSize, float probability) {

        Random myRand = new Random(5); // Diese Zeile nicht verändern!
        boolean[][] array = new boolean[compoundSize][compoundSize];
        for (int i = 0; i < compoundSize; i++) {
            for (int j = 0; j < compoundSize; j++) {
                array[i][j] = myRand.nextFloat() < probability;
            }
        }
        return array; //Zeile kann geändert oder entfernt werden.
    }

    private static int[][] calcAnimalDensity(boolean[][] animalCompound) {
        int[][] array = new int[animalCompound.length][animalCompound[0].length];
        for (int i = 0; i < animalCompound.length; i++) {
            for (int j = 0; j < animalCompound[0].length; j++) {
                int neighbours = 0;
                for (int k = i - 1; k <= i + 1 ; k++) {
                    for (int l = j - 1; l <= j + 1 ; l++) {
                        if ((!(l < 0 || l >= animalCompound.length)) && (!(k < 0 || k >= animalCompound.length))) {
                            neighbours += animalCompound[k][l] ? 1 : 0;
                        }
                    }
                }
                array[i][j] = neighbours;
            }
        }
        return array; //Zeile kann geändert oder entfernt werden.
    }

    // helping method for printing the animal compound
    private static void printCompound(boolean[][] animalCompound) {
        for (int y = 0; y < animalCompound.length; y++) {
            for (int x = 0; x < animalCompound[y].length; x++) {
                if (animalCompound[y][x]) {
                    System.out.print("* ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    // helping method for printing the number of animals
    private static void printDensity(int[][] animalCompound) {
        for (int y = 0; y < animalCompound.length; y++) {
            for (int x = 0; x < animalCompound[y].length; x++) {
                System.out.print(animalCompound[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // variables
        int compoundSize = 8;
        float probability = 0.2f;
        System.out.println("--compoundSize= " + compoundSize + ", probability= " + probability + " ----");
        boolean[][] animalCompound = genAnimalCompound(compoundSize, probability);
        printCompound(animalCompound);
        System.out.println();
        int[][] animalDensity = calcAnimalDensity(animalCompound);
        printDensity(animalDensity);

        System.out.println("--compoundSize= " + compoundSize + ", probability= " + probability + " ----");
        probability = 0.5f;
        animalCompound = genAnimalCompound(compoundSize, probability);
        printCompound(animalCompound);
        System.out.println();
        animalDensity = calcAnimalDensity(animalCompound);
        printDensity(animalDensity);

        System.out.println("--compoundSize= " + compoundSize + ", probability= " + probability + " ----");
        probability = 0.8f;
        animalCompound = genAnimalCompound(compoundSize, probability);
        printCompound(animalCompound);
        System.out.println();
        animalDensity = calcAnimalDensity(animalCompound);
        printDensity(animalDensity);

    }
}
