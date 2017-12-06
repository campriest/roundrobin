package robin;

import java.io.BufferedReader;
import java.util.Queue;
import java.io.IOException;
import java.io.FileReader;

import java.io.FileNotFoundException;
import java.util.*;

public class Round {
	
	static String arrive[];
	static List<String>lines       = new ArrayList<String>();
	static List<Que>process        = new LinkedList<Que>();
	//static List<Scheduler>piority  = new ArrayList<Scheduler>();
	
	
	
	static int arrivalTime[] = null;
	static int burstTime[] = null;
	static int pID[] = null;
	static int temp[] = null;
	static int count = 0;
	static int total = 0;
	
	public static void run(List<String> list, int qTime){
		
		int q = qTime; //remember to add this to method
		int burst;
		int arrival;
		int id;
		
		int averageWait = 0;
		int averageTurn = 0;
		
		
		
		//Que one = new Que(arrival, burst, q);
		
		Que one = null;
		
		for(int i = 1; i <= list.size() - 1; i++){
			
		
			
			arrive = list.get(i).split(",");
			
			String p = arrive[0];
			String a = arrive[1];
			String b = arrive[2];
			
			 id      = Integer.parseInt(p);
			 arrival = Integer.parseInt(a);
			 burst   = Integer.parseInt(b);
			 
			 	 arrivalTime = new int[list.size()];
			 	 burstTime   = new int[list.size()];
			 	 pID         = new int[list.size()];
			 	 temp        = new int[list.size()];
			 	 
			 for(int j =0; j <= list.size()-1; j++){
				 
				 arrivalTime[j] = arrival;
			 	 burstTime[j]   = burst;
			 	 pID[j]         = id;
			 }
			 	
		 	
			 	 
			 	 

	 	 		 	
			 	
			 
			 process.add(new Que(id, arrival, burst)); 
			 
			 //piority.add(new Scheduler(arrival))
			
			//System.out.println(arrival);
			//System.out.println(burst);
			// one = new Que(arrival, burst, q);
			//one(arrival, burst, q);
			// System.out.println(one.getArrive());
		}
		
		//System.out.println(burstTime[3]);
		//System.out.println(process.get(2).getArrive());
		
		
		 for(int x = 0; x <= list.size()- 1; x++){
	 		 
			 temp[x]   = burstTime[x];
			 
		 		 
		 	 
		 	 
		 	 //System.out.println("copy: " + temp[1]);
		 	 
		 	 
		 	 
		for(int j = 0; j <= list.size() - 1; j++) 	{ 
		 if(temp[j] <= q && temp[j] > 0){
			 total = total + temp[j];
			 temp[j] = 0;
			 count = 1;
			 //System.out.println("total: " + total);
		 }else if( temp[j] > 0){
			 
			 temp[j] = temp[j] - q;
			 total   = total + q;
		 }
		 
		 if(temp[j] == 0 && count == 1){
			 
			 System.out.print("turnaround: " + (total - arrivalTime[j]));
			 System.out.println(" Waiting time: " + ((total - arrivalTime[j]) - burstTime[j]));
//			 System.out.println("average wait: " + (averageWait = averageWait + total - (arrivalTime[j] - burstTime[j])));
//			 System.out.println("average turn: " + (averageTurn = averageTurn + total - arrivalTime[j]));
		 }
		 	 
		}
		
	}
		
		
		
		//one.operation();
		//one.getAll();
	}
	
	
	
	public static void nextIn(int qTime){
		int quantum = qTime; //pass this in paramenters
		int timer   = 0;
		int on = process.size();
		System.out.println("size of que: " + on);
		
		
		while(process.isEmpty() != true){
		
		int nextUp = process.get(0).getArrive();
		
		//sorting to find next up in Que
			for(int i = 1; i < process.size(); i++){
		
				if(process.get(i).getArrive() < nextUp){
						nextUp = process.get(i).getArrive();
				}	
			}
				System.out.println("next (time arrival/piority): " + nextUp);
				
				
				
				//burst time 
					for(int i = 0; i <= process.size() - 1; i++){
						
						if(process.get(i).getArrive() == nextUp){
							
							System.out.println("ID: " + process.get(i).getId());
							int newBurst = 0;
								while(timer <= quantum){
									timer++;
									System.out.println("Processing job: " + process.get(i).getId() + " Quantum Timer: " + timer);
									
									
								}
								on++;
								process.get(i).setArrive(on);
								 newBurst = (process.get(i).getBurst() - timer);
								 process.get(i).setBurst(newBurst);
								 System.out.println("Burst Time left: " + newBurst);
								
								 if(newBurst < 0){
									 
									 process.remove(process.get(i)); 
								 }
								System.out.println("Closing. Next process" );
								timer = 0;
						}
//							while(timer <= quantum){
//								
//									process.get(i).next();
//								
//									
//							}
				
				
				
				
				
					}
				
		}
				
	}
	

	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String csvFile    = args[0];
		//String quantumIn  = args[1];
		String practice   = "src/robin/round.csv";
		//int quantum       = Integer.parseInt(quantumIn);
		String line       = "";
		String comma      = ",";
		BufferedReader read = null;
		//String arrive[];
//		String burst[];
//		int arrive[];
		int p = 0;
		
		
			
		
		try {
			
			read = new BufferedReader(new FileReader(practice));
			
			
					while((line = read.readLine()) != null){
						lines.add(line);		
						
				//		p++;
						//System.out.println(p);
						
								///System.out.println(lines.get(p-1));
								
								//System.out.println("string one: " + lineOne[0]);
					}
					
					//System.out.println("LINES: " + lines.get(1));
					run(lines, 2);
					//schd();
					nextIn(2);
//					for(int i = 1; i <=lines.size()-1; i++){
//						
//							arrive = lines.get(i).split(",");
//							
//					}
					
					
					
					
//					for(int i =0; i < lines.size(); i++){
//						
//						arrive = lines.get(i).split(",");
//					}
//					
//					 System.out.println("arrive" + arrive[3]);
//					 
					 
					
					
					
			}catch (FileNotFoundException e){
				
					e.printStackTrace();
				
			} catch(IOException e){
				
					e.printStackTrace();
				
			} finally {
				
				if(read != null){
					
					try{
						
						read.close();
						
					}catch(IOException e){
						
						e.printStackTrace();
						
					}
				}
				
			}
	
		
		
		
	
		
		

		

	}
		
}
