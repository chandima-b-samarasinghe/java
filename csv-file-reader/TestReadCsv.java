public class TestReadCsv{
	public static void main(String[] args){
		try{
			ReadCsv csv=new ReadCsv("contacts.csv");
			int num_headers=csv.getNumberOfHeaders();
				
			for(String s: csv.getHeaders()) System.out.print(s+"\t");
			System.out.println();

			for(String[] c:csv.getData()){
				for(int i=0;i<num_headers;i++){
					System.out.print(c[i]+"\t");	
				}
				System.out.println();
			}	
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
}