public class ServiceCenter {
    private WaitingList awl;

    public ServiceCenter() {
        this.awl = new WaitingList();
    }

    /**
     * Record patient's data and add the patient into waiting list
     * @param name
     * @param phoneNumber
     * @param triageLevel
     * @param location
     */
    public void addPatientIntoList(String name, String phoneNumber, int triageLevel, String location) {
        Patient patient = new Patient(name, phoneNumber, triageLevel, location);
        if(this.awl.isInList(patient)){
            System.out.println(patient.getName() + " is in waiting list. ");
        }else{
            this.awl.addToList(patient);
            System.out.println("Add " + patient.getName() + " into waiting list. ");
        }
    }

    /**
     * Pop out the first patient in the waiting list and assign an Ambulance for him/her
     * @return the patient object
     */
    public Patient assignAmbulanceForPatient() {
        // TODO: The tester report that the system will crash when waiting list is empty
        Patient patient = this.awl.popPatient();
        if(patient == null)
        {
            System.out.println("Error! The waiting list is empty.");//if the waiting list is empty, then print out the message in the screen to handle the exception and return null
            return null;
        }
        System.out.println("Assigned an ambulance for patient: " + patient.getName());
        return patient;
    }
    public int assignAmbulanceForPatientById() {
        // TODO: The tester report that the system will crash when waiting list is empty
        Patient patient = this.awl.popPatient();
        if(patient == null)
        {
            System.out.println("Error! The waiting list is empty.");//if the waiting list is empty, then print out the message in the screen to handle the exception and return null
            return -99;
        }
        System.out.println("Success! An ambulance as assigned for patient " + patient.getId());//use getID() method to assign ambulance for unique patient
        return patient.getId();
    }
    public void checkPositionById()
    {
        int number = this.awl.numNodes - 1;
        Patient patient = this.awl.peekPatient();
        System.out.println("There are " + number + " patients before patient " + patient.getId());
    }
    /**
     * Print out the waiting list
     */
    public void printWaitingList(){
        this.awl.printList();
    }
}
