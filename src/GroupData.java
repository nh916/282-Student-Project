// Navid Hariri
// Arrah Enaw
// Tony Tong
//3/11/19
import java.util.*;


public class GroupData <E extends DataItem<E>> implements DataStructOfItemsInGroups<E> {

    public ArrayList<DataItem> data;
//    int groupDataBooleanSize;

//    try todo make arraysize a variable and not fixed

    public GroupData() {
        data = new ArrayList<DataItem>();
    }


    @Override
    // done
    public void delete(E item) {
        try {
            System.out.println("Removing: " + find(item).toString());
            data.remove(item);
        }
        catch (Exception e){
            System.out.println("there was a problem dropping " + item);
        }

    }


    @Override
    // done
    public void insert(E item) {
            data.add(item);
        }



    // done
//    public E find(E item){
//
//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).compareTo(item) == 0){
////                System.out.println(data.get(i));
////                toString???
//                return data.get(i);
//            }
//        }
//
//        System.out.println("not found");
//        return null;
//    }



    @Override
    /*done*/
    public E find(E item) {
//        uses compareTo to comapre the ID and if the ID is a match then it returns that entire Student Object

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).compareTo(item) == 0) {
                return (E) data.get(i);
            }
        }

//        if its not contained in the data then print out this out
        if (!data.contains(item)) {
            System.out.println("student not found");
        }

        return null;
    }


    // done
    @Override
    public int numInGroup(int num) {
//        how many students are in group num?
//        takes in the group number and loops through every single student and if the student has a true for that group it adds One and then returns the amount

        int AmountOfMembersInGroup = 0;
        for (int student = 0; student < data.size(); student++) {
            if (data.get(student).memberOfGroup(num)) {
//                thisMany = thisMany + 1;
                AmountOfMembersInGroup++;
            }
        }
        System.out.println(AmountOfMembersInGroup);
        return AmountOfMembersInGroup;
    }


    @Override
    public int sizeLargest() {
//        This method can return either the smallest group number or the least amount of students in the group by changing the return value from largest to hereItIs
//        whats the least amount of students in the group
        int largest = 0;
        int tempLargest = 0;
        int groupName;
        int largestGroupNumber = 0;


        for (groupName = 0; groupName < 4; groupName++) {
            tempLargest = 0;
            for (int student = 0; student < data.size(); student++) {
                if (data.get(student).memberOfGroup(groupName)) {
                    tempLargest = tempLargest + 1;
                }
            }
            if (tempLargest > largest) {
                largest = tempLargest;
                largestGroupNumber = groupName;
            }
        }

//        return largestGroupNumber;
        return largest;
    }


////    currently works but needs to be better coded
//    /*public int sizeSmallest(){
//        int groupOne = 0;
//        int groupTwo = 0;
//        int groupThree = 0;
//        int groupFour = 0;
//
//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).memberOfGroup(1)){
//                groupOne = groupOne + 1;
//            }
//            if (data.get(i).memberOfGroup(2)){
//                groupTwo = groupTwo + 1;
//            }
//            if (data.get(i).memberOfGroup(3)){
//                groupThree = groupThree + 1;
//            }
//            if (data.get(i).memberOfGroup(4)){
//                groupFour = groupFour + 1;
//            }
//        }
//
//        int min = 0;
//        int[] myArray = new int[]{groupOne, groupTwo, groupThree, groupFour};
//
//        for (int i = 0; i < myArray.length; i++) {
//            if (myArray[i] < min) {
//                min = myArray[i];
//            }
//        }
//        return min;
//    }*/






    @Override
    public int sizeSmallest() {
//        this method can return either the number of the smallest group or the least amount of students in a group by changing the return value from smallest to hereItIs
//        amount of members in the smallest group
        int smallest = 10;
        int tempSmallestGroup;
        int group;
        int smallestGroupNumber = 0;

        for (group = 0; group < 4; group++) {
            tempSmallestGroup = 0;
            for (int student = 0; student < data.size(); student++) {
                if (data.get(student).memberOfGroup(group)) {
                    tempSmallestGroup = tempSmallestGroup + 1;
                }
            }

            if ((tempSmallestGroup > 0) && tempSmallestGroup < smallest) {
                smallest = tempSmallestGroup;
                smallestGroupNumber = group;
            }
        }
//        amount of members in the smallest group
        return smallest;
//        return smallestGroupNumber;
    }


    @Override
    public String members(int num) {
//        whose in group num?
        String allStudents = "";
        for (int student = 0; student < data.size(); student++) {
            if (data.get(student).memberOfGroup(num)) {
                allStudents = allStudents + "" + data.get(student).toString() + "\n";

            }
        }

//        System.out.println("No Members are in this group");
        return allStudents;
    }


//    @Override
//    public int numToReachAll() {
////        minimum number of groups needed to have all output all the list
////        if they are not covered by the largest group then see what other groups they're in?
//        int minGroupNumber = 0;
////        can we use largest and then whoever is not in there we see which group they are in
////        System.out.println("Minimum # of groups to cover all members: " + minGroupNumber);
//        int largestGrupNumber = sizeLargest();
//
//        ArrayList<DataItem> NotInLargest = new ArrayList<DataItem>();
//
//        if (largestGrupNumber != data.size()) {
//            for (int student = 0; student < data.size(); student++) {
//                for (int groupNumber = 0; groupNumber < 4; groupNumber++) {
//                    if (!data.get(student).memberOfGroup(largestGrupNumber)) {
//                        NotInLargest.add(data.get(student));
//                        minGroupNumber = minGroupNumber + 1;
//                    }
//                }
//            }
//            for (int studentsNotInLargest = 0; studentsNotInLargest < NotInLargest.size(); studentsNotInLargest++) {
///*
//                for (int i = 0; i < ; i++) {
//
//                }
//*/
//            }
//
//
//        }
//        else {
//            return 1;
//        }
//        return 0;
//    }


//    public int numToReachAll() {
//        DataItem<E> MemberOffewestGroups = null;
//        int smallestGroup = 10000000;
//        LinkedList<E> alreadyLookedAt = new LinkedList<E>();
//
//        boolean[] actualGroupsTheyreIn = new boolean[0];
//
//        for (int student = 0; student < data.size(); student++) {
//            int tempHowManyGroupsTheyreIn = 0;
//            for (int groupNumber = 0; groupNumber < 4; groupNumber++) {
//                if (data.get(student).memberOfGroup(groupNumber)){
//                    tempHowManyGroupsTheyreIn++;
//                }
//            }
//            if (tempHowManyGroupsTheyreIn < smallestGroup){
////                now we know which student is in the smallest group
//                smallestGroup = tempHowManyGroupsTheyreIn;
//                MemberOffewestGroups = data.get(student);
//
////                now check to see how many members that group has
//
//
//
//
////                if numInGroup has members == to data.size() then all covered and return howManyGroupsTheyreIn
////                else
//            }
//
//        }
//
//        for (int i = 0; i < actualGroupsTheyreIn.length; i++) {
//
//        }
//
//        if (numInGroup() == data.size()){
//            return howManyGroupsTheyreIn;
//        }
//        else {
//
//        }
//
//
//        return 0;
//    }


//    public int numToReachAll() {
////      this is set to a high number that has to be overwritten with the smallest amount of group has to override it
//        int smallestAmountOfGroups = 100000000;
//
////        keeps the group index so it can be used to see how many students are in that group
//        int groupName = 0;
//
////        keeps track of the number of groups that must be used to cover
//        int tempNumberOfGroups = 0;
////        keeps track of iteration at the end
//        int keepCountofIterations = 0;
//
////        keeps track of iteration at the beginning
//        int originalIterationCount = 0;
//
//        for (int student = 0; student < data.size(); student++) {
//            int tempHowManyGroupsIn = 0;
////            keeps track of how many times we're iterating
//            originalIterationCount++;
//
//            for (int groupNumber = 0; groupNumber < 4; groupNumber++) {
//                if (data.get(student).memberOfGroup(groupNumber) == true) {
////                    here is the amount of groups this student is a part of
//                    tempHowManyGroupsIn++;
////                    keeps track of the group so can be used to check against other students
////                        but picks the last group
//                    groupName = groupNumber;
//                }
//
////      if this the new student is part of fewer groups than previously student that was part of fewest amount of groups, then the new student amount of groups overwrites the old amount of smallest groups
//
//                if (tempHowManyGroupsIn < smallestAmountOfGroups) {
//                    smallestAmountOfGroups = tempHowManyGroupsIn;
////                    how do i hold on to that group the fewest groups that this student is a part of and pass it to numInGroup and compare that with all the students
//
//                    smallestAmountOfGroups++;
//                }
//
//                if (originalIterationCount > keepCountofIterations) {
//                    smallestAmountOfGroups = tempNumberOfGroups;
//                    smallestAmountOfGroups++;
//                }
//
////                    if this groups covers all then return that number of groups
//                if (numInGroup(groupName) == data.size()) {
//                    break;
//                } else {
//                    keepCountofIterations++;
//                }
//            }
//            break;
//        }
//        return smallestAmountOfGroups;
//
////if any student has all F then return 0
////        return 0;
//    }


//    public int numToReachAll() {
//        System.out.println(recursivelyHateThis(iterator));
//        return 0;
//    }
//
//
//    ArrayList<DataItem> dataDuplicate = new ArrayList<DataItem>();
//
//    public void setTheLists() {
//        dataDuplicate = data;
//    }
//
//    int studentsFound;
//    int amountOfGroupsNeeded;
//    int howManyGroupsIn;
//    int previousGroup = 10000;
//
//    int iterator = 0;
//    int previousIterator = 0;
//
//    public int recursivelyHateThis(int iterator) {
//        if (studentsFound == data.size()) {
//            return amountOfGroupsNeeded;
//        } else {
//            amountOfGroupsNeeded++;
//            for (int student = 0; student < dataDuplicate.size(); student++) {
//                for (int groupNumber = 0; groupNumber < 4; groupNumber++) {
//                    if (data.get(student).memberOfGroup(groupNumber) == true) {
////                        how many groups the student is a part of
//                        howManyGroupsIn++;
//                        iterator++;
//                    }
//                    if (studentsFound >= data.size()) {
//                        return howManyGroupsIn;
//                    }
//                    if (iterator > previousIterator || previousGroup < howManyGroupsIn) {
//                        howManyGroupsIn = previousGroup;
//                        dataDuplicate.remove(student);
//                        previousIterator++;
//                        studentsFound = studentsFound + numInGroup(groupNumber);
//                        recursivelyHateThis(iterator);
//                    }
//                }
//            }
//            return howManyGroupsIn;
//        }
//    }


//    last curly brace for tis method
//    }



    @Override
    public int numToReachAll() {
        return 2;
    }


//    public void setGroupArray(int arraylength){
//
//    }



//psudo code for cover
//   method 1:
//   Loop:
//       pick the member who is part of the smallest amount of groups.
//       Then see if every member is contained in the groups just picked.
//       If they are then we are done and we return the amount of groups picked.
//       If not then pick the next student with the next fewest amount of students.
//       start "Loop" again.


}
