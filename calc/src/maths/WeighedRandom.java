package maths;
//UNFINISHED!!!
//Do the object?
// make a method able to be called from ouside

import java.util.Arrays;
import java.util.Random;
import static myapps.Basics.addSpacesFront;

public class WeighedRandom {

    static Random rng = new Random();

//creates a random with a scale of 1 to "scale" (+1 in order to not have a scale of 0)
    WeighedRandom() {

    }

    /**
     * Create a standard (classic random) weighted random number
     *
     * @param scale Randomize between "1" and "scale"
     * @return Standard weighted random number
     */
    public static int standard(int scale) {
        //Create a normal random number from the whole pot
        return rng.nextInt(scale);
    }

    /**
     * Create a right (higher number) weighted random number
     *
     * @param scale Randomize between "1" and "scale"
     * @return Right weighted random number
     */
    public static int right(int scale) {
        //Draw a number from the pot and add one to get it in the "normal numbers" number space
        int rand_scale = rng.nextInt(scale) + 1;
        //Create number to incease the final number with to throw the number to the left side
        int x = scale - rand_scale;

        //Do the thing
        return x + rng.nextInt(rand_scale);
    }

    /**
     * Create a left (lower number) weighted random number
     *
     * @param scale Randomize between "1" and "scale"
     * @return Left weighted random number
     */
    public static int left(int scale) {
        //Draw a number from the pot and add one to get it in the "normal numbers" number space
        int sc_rand = rng.nextInt(scale) + 1;

        //Draw a number from the new pot to go farther into the small number space
        return rng.nextInt(sc_rand);
    }

    /**
     * Testing method for the random functions
     *
     * @param type Type of test to execute. "standard" for a normal
     * randomization, "left" for a left (lower Numbers) weighted randomization
     * and "right" for a right (higher numbers) weighted randomization. Will
     * automatically output graphs for every randomization iteration.
     *
     * @param scale Randomize between "1" and "scale"
     * @param iterations How many times should the randomization be tested?
     */
    public static void randTester(String type, int scale, int iterations) {
        int[] graph = new int[scale];

        switch (type) {
            case "standard":
                for (int i = 0; i < iterations; i++) {
                    graph[standard(scale)]++;
                }
                break;
            case "right":
                for (int i = 0; i < iterations; i++) {
                    graph[right(scale)]++;
                }
                break;
            case "left":
                for (int i = 0; i < iterations; i++) {
                    graph[left(scale)]++;
                }
                break;
            default:
                break;
        }

        makeGraph(graph); //Draw a graph with symbols
    }

    /**
     * Searches for the position of the biggest number in the array
     *
     * @param graph
     * @return Position of biggest number in array
     */
    static int findMaximaPosition(int[] graph) {
        int gr_num = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] > graph[gr_num]) {
                gr_num = i;
            }
        }
        return gr_num;
    }

    static void makeGraph(int[] graph) {

        System.out.println(Arrays.toString(graph));
        int maxima_pos = findMaximaPosition(graph); //Position of biggest number
        int maxima = graph[maxima_pos]; //Biggest number

        System.out.println();
        for (int j = graph[maxima_pos]; j > 0; j--) {
            System.out.print(addFormatingSpacesToNumber(j, maxima) + "|");
            for (int i = 0; i < graph.length; i++) {
                if (graph[i] == j) {
                    System.out.print("#-");
                    graph[i]--;
                } else {
                    System.out.print("--");
                }
            }
            System.out.println("|");
        }

        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static String addFormatingSpacesToNumber(int j, int maxima) {
        //Add spaces in front of the String to give it the needed length
        return addSpacesFront(String.valueOf(j), String.valueOf(maxima).length());
    }

}
