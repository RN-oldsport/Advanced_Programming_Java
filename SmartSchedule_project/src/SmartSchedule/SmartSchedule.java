package SmartSchedule;

import java.util.HashMap;

class ScheduleNode {
    String task_name;
    String day;
    String time;
    ScheduleNode next;

    public ScheduleNode(String task_name, String day, String time) {
        this.task_name = task_name;
        this.day = day;
        this.time = time;
        this.next = null;
    }
}

class WeeklySchedule {

    private ScheduleNode head;

    private static final HashMap<String, Integer> dayOrder = new HashMap<>();
    static {
        dayOrder.put("Saturday", 0);
        dayOrder.put("Sunday", 1);
        dayOrder.put("Monday", 2);
        dayOrder.put("Tuesday", 3);
        dayOrder.put("Wednesday", 4);
        dayOrder.put("Thursday", 5);
        dayOrder.put("Friday", 6);
    }
    public WeeklySchedule() {
        head = null;
    }

    private int compare(ScheduleNode a, ScheduleNode b) {
        int dayA = dayOrder.get(a.day);
        int dayB = dayOrder.get(b.day);

        if (dayA != dayB) {
            return dayA - dayB;
        }
        return a.time.compareTo(b.time);
    }

    public void add_task(String task_name, String day, String time) {
        ScheduleNode newNode = new ScheduleNode(task_name, day, time);

        if (head == null || compare(newNode, head) < 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        ScheduleNode prev = head;
        ScheduleNode curr = head.next;

        while (curr != null && compare(newNode, curr) > 0) {
            prev = curr;
            curr = curr.next;
        }

        newNode.next = curr;
        prev.next = newNode;
    }

    public void display_schedule() {
        ScheduleNode curr = head;
        while (curr != null) {
            System.out.println(curr.day + ", " + curr.time + ": " + curr.task_name);
            curr = curr.next;
        }
    }

}

public class SmartSchedule {
        public static void main(String[] args) {
    WeeklySchedule scheduler = new WeeklySchedule();

    scheduler.add_task("Team Meeting", "Monday", "11:00");
    scheduler.add_task("Study Session", "Saturday", "09:30");
    scheduler.add_task("Workout", "Monday", "08:00");
    scheduler.add_task("Project Submission", "Saturday", "14:00");
    scheduler.add_task("Grocery Shopping", "Saturday", "09:30");
    scheduler.add_task("Dentist Appointment", "Wednesday", "16:00");

    System.out.println("Sorted Weekly Schedule:");
    scheduler.display_schedule();
}

}
