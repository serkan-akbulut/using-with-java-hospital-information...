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
abstract class Person {
    
    protected String firstName, lastName, sex;
    protected int age;
    
    
    abstract double calculate();
    public Person()
    {
        this.firstName="No Name";
        this.lastName="No Last Name";
        this.sex="No sex";
        this.age=0;
    }
    public Person(String fullName, int age, String sex)
    {
        String[] name = fullName.split(" ");
        this.firstName=name[0];
        this.lastName=name[1];
        this.age=age;
        this.sex=sex;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getSex()
    {
        return sex;
    }
    @Override
    public String toString()
    {
        return "\nFirst Name: "+firstName+"\nLast Name: "+lastName+"\nAge: "+age+"\nSex: "+sex;
    }
}
