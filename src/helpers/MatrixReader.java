package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by david on 06/12/17.
 */
public class MatrixReader {

    public static Integer[][] readMatrix(Class classRepo) {
        Scanner input = getScanner(classRepo);
        int numberOfRows = 0;
        int numberOfColumns = 0;
        while(input.hasNextLine())
        {
            int numberOfColumnsDiff = 0;
            numberOfRows++;
            Scanner colReader = new Scanner(input.nextLine());
            while(colReader.hasNext()){
                colReader.next();
                numberOfColumnsDiff++;
            }
            if(numberOfColumnsDiff > numberOfColumns){
                numberOfColumns = numberOfColumnsDiff;
            }
        }
        Integer[][] output = new Integer[numberOfRows][numberOfColumns];
        input = getScanner(classRepo);

        for(int i = 0; i < numberOfRows; i++)
        {
            for(int j = 0; j < numberOfColumns; j++)
            {
                if(input.hasNextInt())
                {
                    output[i][j] = input.nextInt();
                }
            }
        }
        return output;
    }

    public static Scanner getScanner(Class classRepo){
        URL path = classRepo.getResource("input.txt");
        File inputFile = new File(path.getFile());
        try {
            return new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
