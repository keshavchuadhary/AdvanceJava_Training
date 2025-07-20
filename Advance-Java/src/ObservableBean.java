import java.beans.*;

public class ObservableBean {
    private String status;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        String oldStatus = this.status;
        this.status = newStatus;
        // Notify listeners about property change
        pcs.firePropertyChange("status", oldStatus, newStatus);
    }

    // Methods to manage listeners
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public static void main(String[] args) {
        ObservableBean bean = new ObservableBean();
        
        // Add listener
        bean.addPropertyChangeListener(evt -> {
            System.out.println("Property changed: " + evt.getPropertyName());
            System.out.println("Old value: " + evt.getOldValue());
            System.out.println("New value: " + evt.getNewValue());
        });
        
        // Trigger change
        bean.setStatus("Active");
        bean.setStatus("Inactive");
    }
}