public class WaitingList {
    protected Node head;
    protected int numNodes;

    public WaitingList(){
        this.head = null;
        this.numNodes = 0;
    }

    /**
     * This method will pop the first patient from the waiting list
     * @return the patient popped from the waiting list
     */
    public Patient popPatient() {
        //TODO: Implement this method
        if(head == null)
        {   
            //if head is null which means that the list is empty, then return null
            return null;
        }
        else
        {   //just return head is enough
            Node tempH = head;
            head = head.getNext();
            numNodes--;
            return tempH.getPatient();
        }
    }
    /**
     * This method will add patient into the waiting list according to the triage level
     * @param patient patient's data
     */
    public void addToList(Patient patient) {
        //TODO: Implement this method
        Node temp = new Node(patient);//create temporary node
        if(head == null)
        {
            head = temp;
        }
        else if(patient.getTriageLevel() > head.getPatient().getTriageLevel())
        {   //if the new patient triage level is greater then that of head, then the head becomes the new patient
            temp.setNext(head);
            head = temp;
        }
        //else if(patient.getTriageLevel() < head.getPatient().getTriageLevel())//if the new patient triage level is less than that of head, then move in 
        else
        {
            Node nex = head.getNext();
            Node nodeT = head;
            if(head.getNext() == null)
            {
                head.setNext(temp);
                numNodes++;
                return;
            }
            while(patient.getTriageLevel() != nodeT.getPatient().getTriageLevel())
            {   //the case that if two patients have exactly the same triage level, then record it into nodeT
                nodeT = nodeT.getNext();
                if(nodeT == null)
                {
                    break;
                }
            }
            if(nodeT == null)//the case that the triage level of the new patient is different from every exsiting patient
            {
                if(patient.getTriageLevel() > head.getNext().getPatient().getTriageLevel() && patient.getTriageLevel() < head.getPatient().getTriageLevel())//the case that the triage level of new patient is only less than head.
                {
                    temp.setNext(head.getNext());
                    head.setNext(temp);
                }
                else// the case that the triage level of new patient is less than second serious patient in the waiting list
                {    
                    if(nex.getNext() == null)
                    {
                        temp.setNext(nex.getNext());
                        nex.setNext(temp);
                        numNodes++;
                        return;
                    }
                    while(patient.getTriageLevel() < nex.getNext().getPatient().getTriageLevel())
                    {
                        nex = nex.getNext();
                        if(nex.getNext() == null)
                        {
                            break;
                        }
                    }
                    temp.setNext(nex.getNext());
                    nex.setNext(temp);
                }
            }
            else //if(patient.getTriageLevel() == nodeT.getPatient().getTriageLevel())//the case when the triage level of new patient is the same as the other patient but the new patient should be arranged behind the other patient because that guy came earlier
            {
                if(nodeT.getNext() == null)
                {
                    temp.setNext(nodeT.getNext());
                    nodeT.setNext(temp);
                    numNodes++;
                    return;
                }
                while(patient.getTriageLevel() == nodeT.getNext().getPatient().getTriageLevel())//the case when there is more than two patient who have the same triage level
                {
                    nodeT = nodeT.getNext();
                    if(nodeT.getNext() == null)
                    {
                        break;
                    }
                }
                temp.setNext(nodeT.getNext());
                nodeT.setNext(temp);
            }
        }
        //else if(patient.getTriageLevel() == head.getPatient().getTriageLevel())//final case when the new patient triage level is the same as head
        //{
            //temp.setNext(head.getNext());
            //head.setNext(temp);
        //}
        numNodes++;//count the number of patient in the waiting list
    }

    /**
     * print out the information for each patient in waiting list
     */
    public void printList() {
        //TODO: Implement this method
        System.out.printf( "%-15s%15s%15s%n","ID", "Name", "triageLevel");//use printf() to create a table in left aligned
        Node temp = head;//store head in a temporary node
        for(int i=0; i<numNodes; i++)
        {
            head.printNode();//print elements of each patient who is in the waiting list
            head = head.getNext();
        }
        head = temp;//make head back to the begining top one to prevent the disappearance of waiting list in secondary click 
    }
    public Patient peekPatient()
    {   //new method which just returns the head without any deleting
        if(head == null)
        {
            System.out.println("Waiting list is empty");
            return null;
        }
        return head.getPatient();
    }

    /**
     * Check whether the patient is in this list or not
     * @return
     */
    public boolean isInList(Patient patient) {
        if (this.head == null) {
            return false;
        }
        Node temp = this.head;
        while(temp != null) {
            if(temp.getPatient().getName().equals(patient.getName())
                    && temp.getPatient().getPhoneNumber().equals(patient.getPhoneNumber())){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
}
