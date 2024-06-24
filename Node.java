public class Node {
    protected Node next;
    protected Patient patient;

    public Node(Patient patient) {
        this.patient = patient;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void printNode() {
        //TODO: Implement this method
        System.out.printf( "%-15d%15s%15d%n", patient.getId(), patient.getName(), patient.getTriageLevel());//use printf() to print elements of patient in left aligned
    }
}
