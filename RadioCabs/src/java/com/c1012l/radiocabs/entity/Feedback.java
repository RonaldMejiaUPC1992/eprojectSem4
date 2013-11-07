package com.c1012l.radiocabs.entity;
// Generated Nov 7, 2013 1:20:29 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;

/**
 * Feedback generated by hbm2java
 */
public class Feedback  implements java.io.Serializable {


     private int feedbackId;
     private FeedbackType feedbackType;
     private Serializable name;
     private String moblie;
     private String email;
     private Serializable city;
     private Serializable description;

    public Feedback() {
    }

	
    public Feedback(int feedbackId, FeedbackType feedbackType, Serializable name) {
        this.feedbackId = feedbackId;
        this.feedbackType = feedbackType;
        this.name = name;
    }
    public Feedback(int feedbackId, FeedbackType feedbackType, Serializable name, String moblie, String email, Serializable city, Serializable description) {
       this.feedbackId = feedbackId;
       this.feedbackType = feedbackType;
       this.name = name;
       this.moblie = moblie;
       this.email = email;
       this.city = city;
       this.description = description;
    }
   
    public int getFeedbackId() {
        return this.feedbackId;
    }
    
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }
    public FeedbackType getFeedbackType() {
        return this.feedbackType;
    }
    
    public void setFeedbackType(FeedbackType feedbackType) {
        this.feedbackType = feedbackType;
    }
    public Serializable getName() {
        return this.name;
    }
    
    public void setName(Serializable name) {
        this.name = name;
    }
    public String getMoblie() {
        return this.moblie;
    }
    
    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Serializable getCity() {
        return this.city;
    }
    
    public void setCity(Serializable city) {
        this.city = city;
    }
    public Serializable getDescription() {
        return this.description;
    }
    
    public void setDescription(Serializable description) {
        this.description = description;
    }




}

