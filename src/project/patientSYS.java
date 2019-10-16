/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static project.doctorSYS.doctors;

/**
 *
 * @author hakankocak
 */
public class patientSYS {
    
    public static ArrayList<Patient> patients= new ArrayList<Patient>();
    private static String PATIENT_FILENAME = "Patients.txt";
    
    public static void readPatientsFromFile()
    {
        File fileCourse = new File(PATIENT_FILENAME);
        Scanner inputPatient = null;
        try{
           inputPatient = new Scanner(fileCourse);
           while(inputPatient.hasNext())
           {
               String line = inputPatient.nextLine();
               String[] patientData = line.split(", ");
               String[] service = patientData[8].split("-");

               Patient p = new Patient(patientData[0], Integer.parseInt(patientData[1]), patientData[2], Integer.parseInt(patientData[3]), patientData[4], patientData[5], patientData[6], patientData[7]);
               
               for(int i=0; i<service.length-1; i++) {
                   service[0] = service[0].substring(1);
                   String[] temp = service[i].split(",");
                   p.addServices(new Services(temp[0], Double.parseDouble(temp[1])));
               }
                   
               
               patients.add(p);
           }
        }catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        finally{
            if(inputPatient != null)
                inputPatient.close();
        }
    }
    public static boolean addPatient(Patient p)
    {
     
        for(int i=0; i<patients.size(); i++)
            if(p.getSsn() == patients.get(i).getSsn())
                return false;
        
       patients.add(p);
                        
        return true;
    }
   
    public static ArrayList<Patient> getAllPatients()
    {
        if(patients.isEmpty())
            return null;
        
        return patients;
    }
  
    public static Patient getPatient(int ssn)
    {
        for(int i=0; i<patients.size(); i++)
            if(patients.get(i).getSsn()==ssn)
                return patients.get(i);
        
        return null;
    }
    
    public static boolean dischargePatient(int ssn)
    {
        
        for(int i=0 ; i<patients.size(); i++)
            if(patients.get(i).getSsn() == ssn)
            {
                patients.get(i).setExitDate();
                return true;
            }
        
        return false;
    }
    
    public static void updateFile()
    {
        File f = new File(PATIENT_FILENAME);
        PrintWriter pw = null;
        String strWriteToFile="";
        try {
            pw = new PrintWriter(f);
            
            for(int i=0; i<patients.size();i++)
                strWriteToFile += patients.get(i).getFileInput()+"\n";
            
            pw.println(strWriteToFile.substring(0, strWriteToFile.length() - 1));

        }catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }   
    }
    
    public static String displayPatients()
    {
        String output="\nPatient List\n------------------\n";
        
        for(int i=0; i<patients.size(); i++)
            output += patients.get(i).toString();
        
        return output;
    }
    
}
