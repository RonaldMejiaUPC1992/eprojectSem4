package org.group2.entity;
// Generated Nov 14, 2013 6:33:44 PM by Hibernate Tools 3.2.1.GA



/**
 * Administrator generated by hbm2java
 */
public class Administrator  implements java.io.Serializable {


     private int adminId;
     private String email;
     private String password;
     private int role;

    public Administrator() {
    }

    public Administrator(int adminId, String email, String password, int role) {
       this.adminId = adminId;
       this.email = email;
       this.password = password;
       this.role = role;
    }
   
    public int getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public int getRole() {
        return this.role;
    }
    
    public void setRole(int role) {
        this.role = role;
    }




}


