package esmaa;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registersinifi {
	
	public void kayitlar(){
		
	    Scanner girdi = new Scanner(System.in);
	    
	    float[] vize = new float[100];
	    float[] fin = new float[100];
	    String[] numara=new String[100];
	    String[] ad=new String[100];
	    String[] soyad=new String[100];
	    int i=0;
	    int kisisay=0;
	    double[] basaritop = new double[100];
	    String[] harfnotu=new String[100];
	    double maximum=0;
        double minimum=101;
        int max=0;
        int min=0;
        maximum=basaritop[i];
        double toplam=0;
        double vizeort=0;
        double finalort=0;
        double basariort=0;
        double sayac=0;
	    System.out.print("kac ogrenci gireceksin");
	    kisisay=girdi.nextInt();
	        for(i=0;i<kisisay;i++){
	            System.out.printf("%d. Ögrenci Numarasýný gir: ", i+1);
	            numara[i] = girdi.next();

	            System.out.printf("%d. Ögrenci Adý gir: ", i+1);
	            ad[i] = girdi.next();

	            System.out.printf("%d. Ögrenci Soyadý gir: ", i+1);
	            soyad[i] = girdi.next();

	            System.out.printf("%d. Öðrenci Vize Notu gir: ", i+1);
	            vize[i] = girdi.nextFloat();

	            System.out.printf("%d. Öðrenci Final Notu gir: ", i+1);
	            fin[i] = girdi.nextFloat();
	            
	            basaritop[i]=vize[i]*0.4+fin[i]*0.6;
	            
	            if(75<basaritop[i] && basaritop[i]<=100) {
	            	
	            	harfnotu[i]="A";
	            	
	            }
	            
	            else if(50<basaritop[i] && 75>=basaritop[i]) {
	            	
	            	harfnotu[i]="B";
	            	
	            }
	            
	            else if(25<basaritop[i] && 50>=basaritop[i]) {
	            	
	            	harfnotu[i]="C";
	            	
	            }
	            
	            else if(0<=basaritop[i] && 25>=basaritop[i]) {
	            	
	            	harfnotu[i]="D";
	            	
	            }
	            
	        }
	       
	        
	        for(i=0;i<kisisay;i++){
	        	
	        	if(maximum<basaritop[i]) {
	        		
	        		maximum=basaritop[i];
	        		max=i;
	        	}
	        	
	        	if(minimum>basaritop[i]) {
	        		
	        		minimum=basaritop[i];
	        		min=i;
	        		
	        	}
	        	
	        }
	        
	        
	        for(i=0;i<kisisay;i++) {
	        	
	        	toplam=vize[i]+toplam;
	        	sayac++;
	        }
	        
	        vizeort=toplam/sayac;
	        sayac=0;
	        toplam=0;
	        for(i=0;i<kisisay;i++) {
	        	
	        	toplam=fin[i]+toplam;
	        	sayac++;
	        }
	        finalort=toplam/sayac;
	        toplam=0;
	        sayac=0;
	        for(i=0;i<kisisay;i++) {
	        	
	        	toplam=basaritop[i]+toplam;
	        	sayac++;
	        }
	        
	        basariort=toplam/sayac;

	        File file = new File("C:\\Users\\ömer\\Desktop\\Yeni klasör\\dosya.txt");
	        try {
				FileWriter yaz = new FileWriter(file);

		        for(i=0;i<kisisay;i++) {
		        	
		        	yaz.write(ad[i]+" "+soyad[i] +" " +numara[i]+" "+vize[i]+" "+fin[i]+" "+basaritop[i]+" "+harfnotu[i]+"\n");
		        	
		        }
		        yaz.write("vize ortalamasi: "+vizeort+"\n");
		        yaz.write("final ortalamasi: "+finalort+"\n");
		        yaz.write("genel ortalamasi: "+basariort+"\n");
		        yaz.write("en yuksek not: "+ad[max]+" "+soyad[max]+" "+maximum+"\n");
		        yaz.write("en dusuk not: "+ad[min]+" "+soyad[min]+" "+minimum+"\n");
		        yaz.write("frekans grafigi: "+"\n");
		        yaz.write("A");
		        for(i=0;i<kisisay;i++) {
		        	
		        	if(75<basaritop[i] && basaritop[i]<=100) {
		            	
		        		yaz.write(" *");
		            	
		            }
	
		        }
		        yaz.write("\n");
		        yaz.write("B");
		        for(i=0;i<kisisay;i++) {
		        	
		        	 if(50<basaritop[i] && 75>=basaritop[i]) {
			            	
		        		 yaz.write(" *");
			            	
			            }
		        	
		        }
		        yaz.write("\n");
		        yaz.write("C");
		        for(i=0;i<kisisay;i++) {
		        	
		        	if(25<basaritop[i] && 50>=basaritop[i]) {
		            	
		        		yaz.write(" *");
		            	
		            }
		        	
		        }
		        yaz.write("\n");
		        yaz.write("D");
		        for(i=0;i<kisisay;i++) {
		        	
		        	if(0<=basaritop[i] && 25>=basaritop[i]) {
		            	
		            	yaz.write(" *");
		            	
		            }

		        	
		        }
		        yaz.close();
			} catch (IOException e) {
				System.out.print("dosya olusturulamadi");
				e.printStackTrace();
			}


}
}
