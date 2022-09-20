package GoogleKickStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RoundFProblem1 {
    public static void main(String[] args) throws FileNotFoundException {

        //100% on this one

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleKickStart\\testing.txt");

        Scanner scanner = new Scanner(file);
//        Scanner scanner = new Scanner(System.in);

        //Ada sorts by color
        //charles sorts by durability

        int numTestCases = Integer.valueOf(scanner.nextLine());
        int caseNumber = 1;

        for (int i = 0; i < numTestCases; i++) {
            int numOfFabrics = Integer.valueOf(scanner.nextLine());
            PriorityQueue<AdaFabric> AdaQ = new PriorityQueue<>();
            PriorityQueue<CharlesFabric> CharesQ = new PriorityQueue<>();
            for (int j = 0; j < numOfFabrics; j++) {
                String line = scanner.nextLine();
                String[] arr = line.split("\\s+");
                String color = arr[0];
                int durability = Integer.valueOf(arr[1]);
                int id = Integer.valueOf(arr[2]);
                AdaFabric adaFabric = new AdaFabric(color, durability, id);
                CharlesFabric charlesFabric = new CharlesFabric(color, durability, id);
                AdaQ.add(adaFabric);
                CharesQ.add(charlesFabric);
            }

            //now we have them all in a queue
            int counter = 0;
            while (AdaQ.size() > 0) {
                AdaFabric a = AdaQ.poll();
                CharlesFabric c = CharesQ.poll();
                if (a.color.equals(c.color) && a.durability == c.durability && a.id == c.id) {
                    counter++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + counter);
            caseNumber++;
        }

    }

    private static class AdaFabric implements Comparable {

        String color;
        int durability;
        int id;

        public AdaFabric(String color, int durability, int id) {
            this.color = color;
            this.durability = durability;
            this.id = id;
        }


        @Override
        public int compareTo(Object o) {
            AdaFabric b = (AdaFabric) o;
            int c = this.color.compareTo(b.color);
            if (c > 0) {
                return 1;
            } else if (c < 0) {
                return -1;
            }

            if (this.id < b.id) {
                return -1;
            } else if (this.id > b.id) {
                return 1;

            }

            return 0;
        }
    }

    private static class CharlesFabric implements Comparable{

        String color;
        int durability;
        int id;

        public CharlesFabric (String color, int durability, int id) {
            this.color = color;
            this.durability = durability;
            this.id = id;
        }

        @Override
        public int compareTo(Object o) {
            CharlesFabric b = (CharlesFabric) o;

            if (this.durability < b.durability) {
                return -1;

            } else if (this.durability > b.durability) {
                return 1;
            }

            if (this.id < b.id) {
                return -1;
            } else if (this.id > b.id) {
                return 1;

            }

            return 0;

        }
    }

}
