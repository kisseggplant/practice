import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
                String choice = scanner.nextLine();
                if(choice.equals("double")){
                    String line = scanner.nextLine();
                    String [] parts = line.split("\\s+");
                    double [] arrd = new double[3];
                    for (int i = 0; i < 3; i++){
                        arrd[i] = Double.parseDouble(parts[i].trim());
                    }
                    System.out.println("choice="+choice);
                    System.out.printf("%-5.2f,%5.2f,%.2f\n",arrd[0],arrd[1],arrd[2]);
                }
    
                else if(choice.equals("int")){
                        String line = scanner.nextLine();
                        String [] parts = line.split("\\s+");
                        int [] arrd = new int[3];
                        for (int i = 0; i < 3; i++){
                            arrd[i] = Integer.parseInt(parts[i].trim());
                        }
                        System.out.println("choice="+choice);
                        System.out.printf("%d\n",arrd[0]+arrd[1]+arrd[2]);
                }
                else if(choice.equals("str")){
                        String line = scanner.nextLine();
                        String [] parts = line.split("\\s+");
                        System.out.println("choice="+choice);
                        System.out.printf("%s%s%s\n",parts[2],parts[1],parts[0]);
                }
                else if(choice.equals("line")){
                        String line = scanner.nextLine();
                        System.out.println("choice="+choice);
                        System.out.printf("%s\n",line.toUpperCase());
                }
                else{
                    System.out.println("choice="+choice);
                    System.out.println("other");
                }
        }
        scanner.close();
    }
}
