import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualizer {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String title;
        String column1;
        String column2;
        String input = " ";
        String split;
        int up = 0;
        ArrayList<String> dps = new ArrayList<String>();
        ArrayList<Integer> dpi = new ArrayList<Integer>();

        System.out.println("Enter a title for the data:");
        title = scnr.nextLine();
        System.out.println("You entered: " + title);
        System.out.println();

        System.out.println("Enter the column 1 header:");
        column1 = scnr.nextLine();
        System.out.println("You entered: " + column1);
        System.out.println();

        System.out.println("Enter the column 2 header:");
        column2 = scnr.nextLine();
        System.out.println("You entered: " + column2);
        System.out.println();


        while (true)
        {
            System.out.println("Enter a data point (-1 to stop input):");
            input = scnr.nextLine();
            if (input.equals("-1"))
            {
                System.out.println();
                break;
            }
            String[] dataValues = input.split(",");

            if(dataValues.length == 1)
            {
                System.out.println("Error: No comma in string.\n");
            }
            else if(dataValues.length == 2)
            {
                try
                {
                    dpi.add(Integer.parseInt(dataValues[1].trim()));
                    dps.add(dataValues[0].trim());
                    System.out.println("Data string: " + dps.get(up));
                    System.out.println("Data integer: " + dpi.get(up) + "\n");
                    up++;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Error: Comma not followed by an integer.\n");
                }
            }
            else if(dataValues.length > 2)
            {
                System.out.println("Error: Too many commas in input.\n");
            }
        }

        System.out.printf("%33s%n",title);
        System.out.printf("%-20s|%23s%n", column1, column2);
        System.out.println("--------------------------------------------");
        for(int i = 0; i < dps.size(); i++)
        {
            System.out.printf("%-20s|%23d%n", dps.get(i),dpi.get(i));
        }
        System.out.println();
        for(int i = 0; i<dps.size(); i++)
        {
            System.out.printf("%20s", dps.get(i));
            System.out.print(" ");
            for(int j = 0; j < dpi.get(i); j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
