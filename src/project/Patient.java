/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author hakankocak
 */
public class Patient extends Person implements WriteInterface {
    
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    private long ssn;
    private String illness;
    private String doctor;
    private String entryDate;
    private String exitDate=null;
    private ArrayList<Services> services = new ArrayList<Services>();
    private SocialSecurity s = new SocialSecurity(ssn);
    
    @Override
    public void writeToFile()
    {
        
    }
    
    public boolean addServices(Services s)
    {
                services.add(s);
                return true;
    }
    
    public Patient(String fullname,int age, String sex, long ssn, String illness, String doctor, String entryDate, String exitDate)
    {
            super(fullname,age,sex);
             this.ssn=ssn;
             this.illness=illness;
             this.doctor=doctor;
             this.entryDate=entryDate;
             this.exitDate=exitDate;
    }

    public String getEntryDate()
    {
        return entryDate;
    }
    
    public void setExitDate()
    {
        this.exitDate = dateFormat.format(date);
    }
    
    public String getExitDate()
    {
        return exitDate;
    }
    
    public String getIllness()
    {
        return illness;
    }
    
    @Override
    public double calculate(){
        double bill=0;
        
        for(int i=0; i<services.size(); i++)
            bill += services.get(i).getServicePrice();
        
        if(s.getSocialSecurityType().equalsIgnoreCase("Government"))
            bill*=0.7;
        else
            bill*=0.5;
        
        return bill;
    }

     
    public long getSsn(){
        return ssn;
    }
    
    public String getFileInput()
    {
       String strWriteToFile = super.getFirstName() + " " + super.getLastName() + ", "
                    +age+", "+sex+", "+ssn+", "+illness+", "+doctor+", "+entryDate+", "+(String)exitDate+", (";
       
       for(int i=0; i<services.size();i++)
            strWriteToFile+=services.get(i).getServiceName()+","+services.get(i).getServicePrice()+"-";

       strWriteToFile+=")";
       
            return strWriteToFile;
    }

    @Override
    public String toString(){
        String ssn="";
        
        if(getSsn() > 499999999)
            ssn="Special";
        else
            ssn="Government";
        String out= "\nPatient:\nPatient SSN: "+getSsn()+super.toString()+"\nIlness: "+illness+"\nDoctor Name: "+doctor+"\nEntry Date: "+entryDate+"\nExit Date: "+exitDate+"\nServices:\n";
        
        for(int i=0; i<services.size();i++)
            out+=services.get(i).toString();
        
            out+="\nBill: "+this.calculate()+"(Social Security: "+ssn+")\n";
            return out;
    }
}
