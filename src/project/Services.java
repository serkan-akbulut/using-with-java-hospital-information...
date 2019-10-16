/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author hakankocak
 */
public class Services {
    
    private String serviceName;
    private double servicePrice;
    
    public Services(String serviceName, double servicePrice)
    {
        this.serviceName=serviceName;
        this.servicePrice=servicePrice;
    }
    
    
    public String getServiceName()
    {
        return serviceName;
    }
    
    
    public double getServicePrice()
    {
        return servicePrice;
    }
    @Override
    public String toString()
    {
        return "Service Name: "+this.getServiceName()+"\nService Price: "+this.getServicePrice()+"\n";
    }
}
