import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class ReadCsv{
    ArrayList<String[]> filedata;
    String[] header=null;

    public int getNumberOfHeaders(){return header.length;}
    public String getHeader(int index) throws Exception{
    	return header[index];
    }
    public String[] getHeaders(){return this.header;}
    public ReadCsv(String filename) throws Exception{
        filename=ReadCsv.class.getProtectionDomain().
        	getCodeSource().getLocation().getPath().replace("%20"," ")+"/"+filename;
        
        filedata=new ArrayList<String[]>();
        
        BufferedReader br=null;
        FileReader fr=null;

        try{
            fr=new FileReader(filename);
            br=new BufferedReader(fr);

            String currentRecord;
            
            if((currentRecord=br.readLine())!=null){
            	header=currentRecord.trim().split(",");
            }

            while((currentRecord=br.readLine())!=null){
            	filedata.add(currentRecord.trim().split(","));
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<String[]> getData(){return this.filedata;}
    public int getSize(){return filedata.size();}

}