package wgustudentproject.d424.entity;

public enum ProjectStatus {
    COMPLETE("Complete"),
    IN_PROGRESS("In Progress"),
    DELAYED("Delayed"),
    HELP_REQUESTED("Help Requested");

    private final String status;

    ProjectStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
