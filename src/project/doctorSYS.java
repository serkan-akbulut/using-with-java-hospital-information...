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

/**
 *
 * @author hakankocak
 */
public class doctorSYS {
    
    public static ArrayList<Doctor> doctors= new ArrayList<Doctor>();
    public static String DOCTOR_FILENAME = "Doctors.txt";
    private static String[] departments = {"Neurology", "Cosmetic Surgery","General Surgery","Gynaecology","Oncology","Physiotherapy","Urology","Cardiology","Ophthalmology"};
    public static void readDoctorsFromFile()
    {
        File fileCourse = new File(DOCTOR_FILENAME);
        Scanner inputDoctor = null;
        try{
           inputDoctor = new Scanner(fileCourse);
           while(inputDoctor.hasNext())
           {
               String line = inputDoctor.nextLine();
               String[] doctorData = line.split(", ");
               String[] work= doctorData[5].split("-");
               Doctor d = new Doctor(doctorData[0], Integer.parseInt(doctorData[1]), doctorData[2], Integer.parseInt(doctorData[3]), Double.parseDouble(doctorData[4]),Arrays.asList(work).stream().mapToInt(Integer::parseInt).toArray());
               doctors.add(d);
           }
        }catch(FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        finally{
            if(inputDoctor != null)
                inputDoctor.close();
        }
    }
    
     public static void updateFile()
    {
        File f = new File(DOCTOR_FILENAME);
        PrintWriter pw = null;
        String strWriteToFile="";
        try {
            pw = new PrintWriter(f);
            
            for(int i=0; i<doctors.size();i++)
                strWriteToFile += doctors.get(i).getFileInput()+"\n";
            
            pw.println(strWriteToFile.substring(0, strWriteToFile.length() - 1));

        }catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }   
    }
    
    public static String[] getDepartmentNames()
    {
        return departments;
    }
    public static void displayWorkDays(int[] workDays)
    {
        
    }
    public static boolean removeDoctor(int id)
    {
        
        for(int i=0 ; i<doctors.size(); i++)
            if(doctors.get(i).getId() == id)
            {
                doctors.remove(doctors.get(i));
                return true;
            }
        
        return false;
    }
    
    
    public static void addDoctor(Doctor d)
    {
       doctors.add(d);
       d.writeToFile();
    }
    
    public static ArrayList<Doctor> getAllDoctors()
    {
        if(doctors.isEmpty())
            return null;
        
        return doctors;
    }
    
    
    public static Doctor getDoctor(String name)
    {
        String[] check = name.split(" ");
        for(int i=0; i<doctors.size(); i++)
            if(doctors.get(i).firstName.equalsIgnoreCase(check[0]) && doctors.get(i).lastName.equalsIgnoreCase(check[1]) )
                return doctors.get(i);
        
        return null;
    }
    
    public static String displayDoctors()
    {
        String output="\nDoctor List\n-----------------\n";
        
        for(int i=0; i<doctors.size(); i++)
            output += doctors.get(i).toString();
        
        return output;
    }
  
}
