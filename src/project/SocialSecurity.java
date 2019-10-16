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
public class SocialSecurity{
    
    private String ssType;
    
  
    public SocialSecurity(long ssn)
    {
        if(ssn>=499999999)
            this.ssType="Government";
        else
            this.ssType="Special";
    }
    
    public String getSocialSecurityType()
    {
        return ssType;
    }
    
    @Override
    public String toString()
    {
        return "";
    }
   
}
