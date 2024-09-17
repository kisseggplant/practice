import java.util.Scanner;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.InputStreamReader;
public class Main{
public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    double sum = 0;
    double result;
    int n = scanner.nextInt();
    scanner.nextLine();
    String line = scanner.nextLine();
    String[] parts = line.split("\\s+");
    double[] arr = new double[n];
    for (int i = 0; i < n; i++){
        arr[i] = Double.parseDouble(parts[i].trim());
    }

    Arrays.sort(arr);
    for(int i=1;i<n-1;i++){
        // arr[i] = scanner.nextDouble();
        sum += arr[i];      
    }
    

    result = (sum) / (n-2);
    System.out.printf("%.2f",result);
}
    
}
