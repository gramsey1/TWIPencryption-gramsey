package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //new scanner system
        User superUser;
        User users[] = new User[10]; //creating array
        int count = 1; //used for while loop

        System.out.println("Welcome to a secure communication environment");
        System.out.println("By default the first user will be a super user");
        superUser = new User(); //new object
        users[0] = superUser; //stating what the array of 0 will be while equalling the super user

        System.out.println("Please create more users to communicate with (up to 10)");

        String answer; //used for while loop

        while(true){
            System.out.println("Create user " + (count+1) + "(y/n)");
            answer = sc.next(); //getting answer
            if(answer.equalsIgnoreCase("n")){ //if answer equals 1, break
                break;
            }else if(count > 9){  //break if less than 9
                System.out.println("Sorry, user limit reached");
                break;
            }
            users[count] = new User(); //new array
            users[0].grant(users[count]);
            count++;
        }

        int userId, userId2; //used for while loop
        String say;

        while(true){
            System.out.println("Pick a user to be (0-" + count + ")"); //asking the user to pick a number between 1-2
            userId = sc.nextInt(); //getting answer
            System.out.println("Say something, grant access(grant), revoke access(revoke), or exit: ");
            say = sc.nextLine();
            say = sc.nextLine(); //getting their answer
            if(say.equalsIgnoreCase("grant")){ //if they say grant, go through this
                System.out.println("Grant who access to user " + userId + "?"); //asking who to give access to user 1
                userId2 = sc.nextInt(); //getting answer
                users[userId2].grant(users[userId]); //giving access
            }else if(say.equalsIgnoreCase("revoke")){ //if they say revoke, go through this
                System.out.println("Revoke who's access?");
                userId2 = sc.nextInt(); //getting answer
                users[userId2].revoke(users[userId]); //revoking access
            }else if(say.equalsIgnoreCase("exit")){ //if they say exit, break
                break;
            }else{
                users[userId].say(say, userId, users, count); //copying the data
            }
        }
    }

}
