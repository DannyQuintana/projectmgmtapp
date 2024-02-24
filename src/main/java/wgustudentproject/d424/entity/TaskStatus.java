package wgustudentproject.d424.entity;

public enum TaskStatus {
    COMPLETE("Complete"),
    IN_PROGRESS("In Progress"),
    DELAYED("Delayed"),
    HELP_REQUESTED("Help Requested");

    private final String status;

    TaskStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

}
