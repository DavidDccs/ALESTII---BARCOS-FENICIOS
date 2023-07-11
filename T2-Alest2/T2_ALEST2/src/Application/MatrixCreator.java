package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class MatrixCreator {
    public static int[][] creator(String fileName2){
        int[][] failed = new int[1][1];
        try  {
            int[][] matrix = new int[1][1];
            String current = "";
            String line = "";
            Scanner in = null;
            in = new Scanner(new BufferedReader(
                    new FileReader(fileName2)));
            BufferedReader br = new BufferedReader(
                    new FileReader(fileName2));
            int currentLine = 0;
            while ((current = br.readLine()) != null) {
                int currentBlock = 0;
                if(currentLine == 0){
                   String now[] = current.split(" ");
                    matrix = new int[Integer.parseInt(now[0])][Integer.parseInt(now[1])];
                } else {
                    char now[] = current.toCharArray();
                    for (char test :
                         now) {
                        if(test == '.'){
                            matrix[currentLine-1][currentBlock] = -1;
                            currentBlock = currentBlock +1;
                        }
                        else if(test == '*'){
                            matrix[currentLine-1][currentBlock] = 0;
                            currentBlock = currentBlock +1;}
                        else{
                            int porto = Integer.parseInt(String.valueOf(test));
                            matrix[currentLine-1][currentBlock] = porto;
                            int x = currentLine -1;
                            int y = currentBlock;
                            MapHandler.assignPorto(porto,x,y);
                            currentBlock = currentBlock +1;
                        }
                    }
                }
                currentLine = currentLine +1;
            }
            return matrix;
        }
        catch (Exception e)
        {System.out.println(e); return failed;}
    }
}