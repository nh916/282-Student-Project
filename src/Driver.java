// Navid Hariri
// Arrah Enaw
// Tony Tong
//3/11/19


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Driver{
// file name so that we can pass in any file as a String and it can read any file
    String fileName;
    GroupData option;
//    int booleanSize;

//    boolean [] ingroup;


//    put the file name in the constructor so it knows what to use and set it equal to the instance name for fileName
    public Driver(String fileName){
        this.fileName = fileName;

//        new GroupData to use for the class
        option = new GroupData();
    }



//    check
    public void loadData() {

//        GroupData dictionary = new GroupData(); //Create a new instance of Groupdata called dictionary
        Scanner scan = null;


            try {
                scan = new Scanner(new FileInputStream(fileName)); //read in the file



//                while there are lines in the text it will keep reading
                while(scan.hasNext()) {
                    String theList = scan.nextLine();
//                    regular expression that will take the newly read line and split it into 3 parts and place it into this array called Split result
//                    first part being ID, then Name, then boolean group value
                    String[] splitResult = theList.split("\\s*,\\s*");// array list.

//                    taking the ID that was just split and placing them IdNumber
                    long IdNumber = Long.parseLong(splitResult[0]);
//                    takes the names just read in and places them in name
                    String name = splitResult[1];
//                    takes the true false values and places them in an array called ingroup
                    boolean [] ingroup = new boolean[splitResult[2].length()];
//                    booleanSize = splitResult[2].length();
//                    option.setGroupArray(booleanSize);

//                    iterates over every single character in the String and converts the T into true and F into false
                    for (int i = 0; i < splitResult[2].length(); i++){
                        if (splitResult[2].charAt(i) == 'T' || splitResult[2].charAt(i) == 't'){
                            ingroup[i] = true;
                        }
                        else{
                            ingroup[i] = false;
                        }
                    }

//                    puts the fresh new student info in the student object
                    Students info = new Students(IdNumber, name, ingroup);
//                    puts the student in the Arraylist
                    option.insert(info);

                }
                /*System.out.println(option.data); //print it out*/

            }
//            in case of a file error it will catch and report the exception

            catch (FileNotFoundException e) {
//                e.printStackTrace();
                System.out.println("File not found");
            }
            catch (NullPointerException e){
                System.out.println("file error");
            }

//will close the file regardless
            finally {
                try {
                    scan.close();
                }
                catch (NullPointerException e){
                    System.out.println("file was never opened or closed");
                }

            }


    }



//    done
//    a function with a bunch of print statements saying what can and cannot happen
    private void help(){
        System.out.println("Your options are:");
        System.out.println("add \t \t (adds a student)");
        System.out.println("drop \t \t (drops a student)");
        System.out.println("find \t \t (outputs a student)");
        System.out.println("size \t \t (outputs the size of a group)");
        System.out.println("members \t (outputs the members of a group)");
        System.out.println("largest \t (outputs the largest size of any group)");
        System.out.println("smallest \t (outputs the smallest size of any group)");
        System.out.println("cover \t \t (outputs the minimum number of groups which cover all students)");
        System.out.println("quit \t \t (ends the program)");
        options();
    }



//
//    switch statement saying the choices for the menu
    private void options() {

        boolean incorrect = false;
        boolean flag = true;

        while (flag) {
            Scanner input = new Scanner(System.in);
            switch (userChoice()) {
                case ("help"): {
                    help();
                    break;
                }

//            check
                case ("add"): {
                    try {

                        System.out.println("Name?");
                        String name = input.nextLine();

                        System.out.println("ID Number?");
                        long id = input.nextLong();
//                        used to fix the problem that the compiler has with carriage return at the end of id
                        input.nextLine();

                        boolean[] groups = new boolean[4];
                        System.out.println("Groups?");
                        String groupGiven = input.nextLine();

                        if (groupGiven.length() < 4){
                            System.out.println("incorrect input. too few inputs for group. student not recorded. please try again");
                            incorrect = true;
                        }

                        for (int i = 0; i < groupGiven.length(); i++) {
                            if (groupGiven.charAt(i) == 'T' || groupGiven.charAt(i) == 't') {
                                groups[i] = true;
                            }
                            else if (groupGiven.charAt(i) == 'F' || groupGiven.charAt(i) == 'f'){
                                groups[i] = false;
                            }
                            else {
                                System.out.println("Incorrect input. The groups are either T or F. Student not recorded");
                                incorrect = true;
                                break;
                            }
                        }
                        if (incorrect == false){
                            Students student = new Students(id, name, groups);
                            option.insert(student);
                        }
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("incorrect inputs");
                        break;
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("too many inputs");
                        break;
                    }
                }

//            check
                case ("drop"): {
                    try {

                        System.out.println("ID Number?");
                        long id = input.nextLong();
                        Students studentToFind = new Students(id, null, null);

                        option.delete(option.find(studentToFind));
//                        System.out.println(option.data);
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("incorrect input");
                        break;
                    }
                }

                case ("find"): {
                    try {
                        System.out.println("ID Number?");
                        long id = input.nextLong();
                        Students studentToFind = new Students(id, null, null);

                        System.out.println(option.find(studentToFind));
                        /*option.find(studentToFind);*/
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("incorrect input");
                        break;
                    }
                }

//            check
                case ("size"): {

                    try {
                        System.out.println("Group?");
                        int groupNumber = input.nextInt();
                        option.numInGroup(groupNumber);
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("incorrect input");
                        break;
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("incorrect input. Unknown group. The groups are between 0 and 3");
                        break;
                    }
                }

//            check
                case ("members"): {
                    try {
                        System.out.println("Group?");
                        int groupNumber = input.nextInt();
//                        option.members(groupNumber);
                        System.out.println(option.members(groupNumber));
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("incorrect input");
                        break;
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("incorrect input. Unknown group. The groups are between 0 and 3");
                        break;
                    }
                }

                case ("largest"): {
                    System.out.println(option.sizeLargest());
                    break;
                }

                case ("smallest"): {
                    System.out.println(option.sizeSmallest());
                    break;
                }

                case ("cover"): {
                    System.out.println(option.numToReachAll());
                    break;
                }

                case ("quit"): {
//                    System.exit(0);
//                    break;
//                    return;
                    flag = false;
                    break;
                }

//                here for testing purposes
/*                case ("show me"): {
                    System.out.println(option.data);
                    break;
                }*/

                default: {
                    System.out.println("Not a valid choice. Please try again.");
                    break;
                }
            }
        }
    }


    private String userChoice(){
        Scanner input = new Scanner(System.in);
        String choice = null;

        System.out.println("What would you like to do?");
        choice = input.nextLine();
        return choice;

    }


    public static void main(String[] args){
        Driver d = new Driver("data.txt");
        d.loadData();


//        Goodluck!
        d.options();
    }


}
