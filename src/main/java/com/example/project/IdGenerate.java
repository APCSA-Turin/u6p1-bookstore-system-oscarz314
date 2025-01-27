package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.

    // //requires 1 private attribute String currentId. You must initialize it to 99
    private static String currentID = "99";

    // //requires one empty constructor
    public IdGenerate(){}

    // public  getCurrentId(){}
    public static String getCurrentId(){
        return currentID;
    }

    // public  reset(){} //must reset the currentId back to 99
    public static void reset(){
        currentID = "99";
    }


    // public generateID(){} //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
    public static void generateID(){
        currentID =  "" + (Integer.parseInt(currentID) + 1);
    }

    // public static void main(String[] args) {
    //     IdGenerate test = new IdGenerate();
    //     test.generateID
    // }
}