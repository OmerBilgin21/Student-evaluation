package evaluate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RegisterClass {
	
	public void register(){
		
	    Scanner input = new Scanner(System.in);
	    
	    float[] midTermEx = new float[100];
	    float[] fin = new float[100];
	    String[] num=new String[100];
	    String[] name=new String[100];
	    String[] surname=new String[100];
	    int i=0;
	    int personCounter=0;
	    double[] succesTotal = new double[100];
	    String[] letterGrade=new String[100];
	    double maximum=0;
        double minimum=101;
        int max=0;
        int min=0;
        maximum=succesTotal[i];
        double total=0;
        double midtermExAvg=0;
        double finalAvg=0;
        double succesAvg=0;
        double counter=0;
	    System.out.print("How many student's are you going to write?");
	    personCounter=input.nextInt();
	        for(i=0;i<personCounter;i++){
	            System.out.printf("%d 'th student's number: ", i+1);
	            num[i] = input.next();

	            System.out.printf("%d 'th student's name: ", i+1);
	            name[i] = input.next();

	            System.out.printf("%d 'th student's surname: ", i+1);
	            surname[i] = input.next();

	            System.out.printf("%d 'th student's midterm exam grade: ", i+1);
	            midTermEx[i] = input.nextFloat();

	            System.out.printf("%d 'th student's final exam grade: ", i+1);
	            fin[i] = input.nextFloat();
	            
	            succesTotal[i]=midTermEx[i]*0.4+fin[i]*0.6;
	            
	            if(75<succesTotal[i] && succesTotal[i]<=100) {
	            	
	            	letterGrade[i]="A";
	            	
	            }
	            
	            else if(50<succesTotal[i] && 75>=succesTotal[i]) {
	            	
	            	letterGrade[i]="B";
	            	
	            }
	            
	            else if(25<succesTotal[i] && 50>=succesTotal[i]) {
	            	
	            	letterGrade[i]="C";
	            	
	            }
	            
	            else if(0<=succesTotal[i] && 25>=succesTotal[i]) {
	            	
	            	letterGrade[i]="D";
	            	
	            }
	            
	        }
	       
	        
	        for(i=0;i<personCounter;i++){
	        	
	        	if(maximum<succesTotal[i]) {
	        		
	        		maximum=succesTotal[i];
	        		max=i;
	        	}
	        	
	        	if(minimum>succesTotal[i]) {
	        		
	        		minimum=succesTotal[i];
	        		min=i;
	        		
	        	}
	        	
	        }
	        
	        
	        for(i=0;i<personCounter;i++) {
	        	
	        	total=midTermEx[i]+total;
	        	counter++;
	        }
	        
	        midtermExAvg=total/counter;
	        counter=0;
	        total=0;
	        for(i=0;i<personCounter;i++) {
	        	
	        	total=fin[i]+total;
	        	counter++;
	        }
	        finalAvg=total/counter;
	        total=0;
	        counter=0;
	        for(i=0;i<personCounter;i++) {
	        	
	        	total=succesTotal[i]+total;
	        	counter++;
	        }
	        
	        succesAvg=total/counter;

	        File file = new File("C:\\Users\\ömer\\Desktop\\dosya.txt");
	        try {
				FileWriter yaz = new FileWriter(file);

		        for(i=0;i<personCounter;i++) {
		        	
		        	yaz.write(name[i]+" "+surname[i] +" " +num[i]+" "+midTermEx[i]+" "+fin[i]+" "+succesTotal[i]+" "+letterGrade[i]+"\n");
		        	
		        }
		        yaz.write("midTermEx average: "+midtermExAvg+"\n");
		        yaz.write("final average: "+finalAvg+"\n");
		        yaz.write("genel average: "+succesAvg+"\n");
		        yaz.write("highest grade: "+name[max]+" "+surname[max]+" "+maximum+"\n");
		        yaz.write("lowest grade: "+name[min]+" "+surname[min]+" "+minimum+"\n");
		        yaz.write("frequency grap: "+"\n");
		        yaz.write("A");
		        for(i=0;i<personCounter;i++) {
		        	
		        	if(75<succesTotal[i] && succesTotal[i]<=100) {
		            	
		        		yaz.write(" *");
		            	
		            }
	
		        }
		        yaz.write("\n");
		        yaz.write("B");
		        for(i=0;i<personCounter;i++) {
		        	
		        	 if(50<succesTotal[i] && 75>=succesTotal[i]) {
			            	
		        		 yaz.write(" *");
			            	
			            }
		        	
		        }
		        yaz.write("\n");
		        yaz.write("C");
		        for(i=0;i<personCounter;i++) {
		        	
		        	if(25<succesTotal[i] && 50>=succesTotal[i]) {
		            	
		        		yaz.write(" *");
		            	
		            }
		        	
		        }
		        yaz.write("\n");
		        yaz.write("D");
		        for(i=0;i<personCounter;i++) {
		        	
		        	if(0<=succesTotal[i] && 25>=succesTotal[i]) {
		            	
		            	yaz.write(" *");
		            	
		            }

		        	
		        }
		        yaz.close();
			} catch (IOException e) {
				System.out.print("file couldn't be created");
				e.printStackTrace();
			}


}
	
}
