import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Collection<Long> col = null;
		
		
		col = new ArrayList<Long>();
		col.add(11111111111111L);
		col.add(22222222222222L);
		col.add(33333333333333L);
		col.add(44444444444444L);
		
		/*Iterator<Long> it = col.iterator();*/
		
		/*while(it.hasNext()){
			System.out.println(it.next().toString());
		}*/
		
		Object [] arr = col.toArray();
		String tempStr = "";
		for(int i=0;i<arr.length;i++){
			if(i == 0){
				tempStr +="'"+ arr[i].toString()+ "'";
				//System.out.println("'"+ arr[i].toString()+ "'");
			}else{
				tempStr +=",'"+ arr[i].toString()+ "'";
				//System.out.println(",'"+ arr[i].toString()+ "'");
			}
			
		}
		System.out.println(tempStr);
		
		
		

	}
	
	
	/*public String[]*/

}
