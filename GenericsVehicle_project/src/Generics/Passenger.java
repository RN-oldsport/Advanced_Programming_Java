package Generics;

public class Passenger {

    private String name;
    private String ticketId;

    public Passenger(String name, String ticketId) {
        this.name = name;
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTicketId() {
        return ticketId;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String toString() {
        return "passenger's name: " + this.getName() + " and their ticket id: " + this.getTicketId();
    }

}
