package org.group2.entity;
// Generated Nov 14, 2013 6:33:44 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * FeedbackType generated by hbm2java
 */
public class FeedbackType  implements java.io.Serializable {


     private int feedbackTypeId;
     private String feedbackTypeName;
     private Set<Feedback> feedbacks = new HashSet<Feedback>(0);

    public FeedbackType() {
    }

	
    public FeedbackType(int feedbackTypeId, String feedbackTypeName) {
        this.feedbackTypeId = feedbackTypeId;
        this.feedbackTypeName = feedbackTypeName;
    }
    public FeedbackType(int feedbackTypeId, String feedbackTypeName, Set<Feedback> feedbacks) {
       this.feedbackTypeId = feedbackTypeId;
       this.feedbackTypeName = feedbackTypeName;
       this.feedbacks = feedbacks;
    }
   
    public int getFeedbackTypeId() {
        return this.feedbackTypeId;
    }
    
    public void setFeedbackTypeId(int feedbackTypeId) {
        this.feedbackTypeId = feedbackTypeId;
    }
    public String getFeedbackTypeName() {
        return this.feedbackTypeName;
    }
    
    public void setFeedbackTypeName(String feedbackTypeName) {
        this.feedbackTypeName = feedbackTypeName;
    }
    public Set<Feedback> getFeedbacks() {
        return this.feedbacks;
    }
    
    public void setFeedbacks(Set<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }




}

