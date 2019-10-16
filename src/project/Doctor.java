/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author hakankocak
 */
public class Doctor extends Person implements WriteInterface {
    private int doctorId;
    private static int id=100;
    private int departmentId;
    private double salary;
    private int[] workDays;
    String department;

    @Override
    public void writeToFile()
    {
        File f = new File(doctorSYS.DOCTOR_FILENAME);
        PrintWriter pw = null;
        try {
            FileWriter fw = new FileWriter(f, true);
            pw = new PrintWriter(fw);

            String strWriteToFile = getFileInput();
            pw.println(strWriteToFile.substring(0, strWriteToFile.length() - 1));

        }catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }   
    }
    
    public String getFileInput()
    {
       String strWriteToFile = super.getFirstName() + " " + super.getLastName() + ", "
                    +age+", "+sex+", "+departmentId+", "+(int)getSalary()+", ";
            for(int i=0; i<workDays.length;i++)
                if(workDays[i]>-1)
                    strWriteToFile+=workDays[i]+"-";
            
            return strWriteToFile;
    }
   
    public Doctor(String fullname, int age, String sex,int departmentId, int[] workDays) {
            super(fullname, age, sex);
            this.doctorId = id++;
            this.departmentId = departmentId;
            this.salary = Math.random()*8000+7000;
            this.workDays = workDays;
    }
    
    public String getDepartment()
    {   
        if(departmentId==0)
            department="Neurology";
        else if(departmentId==1)
            department="Cosmetic Surgery";
        else if(departmentId==2)
            department="General Surgery";
        else if(departmentId==3)
            department="Gynaecology";
        else if(departmentId==4)
            department= "Oncology";
        else if(departmentId==5)
            department = "Physiotherapy";
        else if(departmentId==6)
            department= "Urology";
        else if(departmentId==7)
            department="Cardiology";
        else
            department="Ophthalmology";
        return department;
    }
    
    public Doctor(String fullname, int age, String sex,int departmentId, double salary, int[] workDays) {
            super(fullname, age, sex);
            this.doctorId = id++;
            this.departmentId = departmentId;
            this.salary = salary;
            this.workDays = workDays;
    }
    
    public String getWorkDays()
    {
        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        String out="";
        for(int i=0; i<workDays.length; i++)
        {
            int a=workDays[i];
            if(a>-1 && i != workDays.length-1)
                out+=days[a]+"\n";
          
        }
        return out;
    }
    
    public double getSalary()
    {
        return salary;
    }
    
    public void setSalary(double standardSalary)
    {
        this.salary=standardSalary;
    }
    @Override
    public double calculate() {
    
        
        
        return salary;
    }

    public int getId() {
        return doctorId;
    }

    public int getDepartmentId() {
	return departmentId;
    }

    @Override
    public String toString() {
        
        return "\nDoctor:\nDoctor id: "+doctorId+super.toString() +"\nSalary: "+(int)this.calculate()+"\nWork Days: \n"+getWorkDays()+"\n---------";
    }
   
}
