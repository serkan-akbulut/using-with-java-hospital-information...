/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author hakankocak
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        doctorSYS.readDoctorsFromFile();
        patientSYS.readPatientsFromFile();
        
        HospitalFrame hf = new HospitalFrame();
        hf.setVisible(true);
    }
    
}
