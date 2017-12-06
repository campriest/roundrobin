package robin;
import java.util.*;

public class Que {
	private int burst;
	private int id;
	private int arrive;
	
	
 
	public Que(int id, int arrive, int burst){
		
		this.arrive = arrive; 
		this.burst  = burst;
		this.id     = id;
		
	}
	
	
	
		
		
		
		
		

	public Integer getBurst(){
		
		return burst;
			
	}
	
	public void setBurst(int burst){
		
		this.burst = burst;
	}
	
	public Integer getId(){
		
		
		return id;
	}
	
	
	
	public Integer getArrive(){
		
		return arrive ;
		
	}
	
	public void setArrive(int arrive){
		
		this.arrive = arrive;
	}
	
	
}
