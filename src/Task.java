public class Task {

    String title;
    String priority;
    String deadline;
    long startTime;
    long duration;
    boolean isCompleted;

    // Constructor
    public Task(String title, String priority, String deadline, long duration) {
        this.title = title;
        this.priority = priority;
        this.deadline = deadline;
        this.duration = duration;
        this.startTime = System.currentTimeMillis(); // when task is created
        this.isCompleted = false;
    }

    // Method to check remaining time
    public long getRemainingTime() {
        long currentTime = System.currentTimeMillis();
        long elapsed = currentTime - startTime;
        return duration - elapsed;
    }

    // Method to check if time is up
    public boolean isTimeUp() {
        return getRemainingTime() <= 0;
    }

    // Display task nicely
    @Override
    public String toString() {
        String status;

        if (isCompleted) {
            status = "[DONE]";
        } else if (isTimeUp()) {
            status = "[TIME UP]";
        } else {
            long seconds = getRemainingTime() / 1000;
            status = "[PENDING " + seconds + "s left]";
        }

        return status + " " + title + " | " + priority + " | " + deadline;
    }
}