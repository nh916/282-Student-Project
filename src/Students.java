// Navid Hariri
// Arrah Enaw
// Tony Tong
//3/11/19

public class Students implements DataItem{

    private String name;
    private long idNumber;
    private boolean[] ingroup;

// the variables needed to make a group
    public Students(long idNumber, String name, boolean[] ingroup){
        this.idNumber = idNumber;
        this.name = name;

//        this.ingroup = new boolean[4];
        this.ingroup = ingroup;

    }


/*    public Students(){

    }*/




    @Override
//    if the student is in that group thats given return true and otherwise return false
    public boolean memberOfGroup(int n){
        if (ingroup[n]){
            return true;
        }
        else {
            return false;
        }
    }




    @Override
    public int compareTo(Object n){

//        casts the student object to a student and then uses the ID to compare them
//        uses the standard compareTo outputs

        Students temp = (Students) n;
//        ((Students) n).idNumber < idNumber
        if (idNumber < ((Students) n).idNumber){
            return - 1;
        }
        else if (((Students) n).idNumber < idNumber){
            return 1;
        }
        else {
//            if theyre equal
            return 0;
        }




    }




// toString to print out the student
    @Override
    public String toString() {
        String groupToString = "";
//        return "Student Name: " + name + "ID Number " + idNumber + "in groups " + Arrays.toString(ingroup);

//        for each loop that takes all the trues and puts them into one string and then prints out it out with other student stuff
        for (boolean var : ingroup) {
            if (var) {

                groupToString = groupToString + "T";

            } else {
                groupToString = groupToString + "F";

            }
        }
        return idNumber + ", " + name + ", " + groupToString;
    }
}