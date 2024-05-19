package BehavioralDesignPattern.ObserverDP;

import java.beans.PropertyChangeSupport;

public class UserOb {
    private String status;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setStatus(String status) {
        propertyChangeSupport.firePropertyChange("status",this.status,status);
        this.status = status;
    }

    public void addPropertyChangeListener(NewsFeed newsFeed){
        propertyChangeSupport.addPropertyChangeListener(newsFeed);
    }

}
