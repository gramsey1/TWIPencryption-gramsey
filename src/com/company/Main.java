package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User superUser;
        User users[] = new User[10];
        int count = 1;

        System.out.println("Welcome to a secure communication environment");
        System.out.println("By default the first user will be a super user");
        superUser = new User();
        users[0] = superUser;

        System.out.println("Please create more users to communicate with (up to 10)");

        String answer;

        while(true){
            System.out.println("Create user " + (count+1) + "(y/n)");
            answer = sc.next();
            if(answer.equalsIgnoreCase("n")){
                break;
            }else if(count > 9){
                System.out.println("Sorry, user limit reached");
                break;
            }
            users[count] = new User();
            users[0].grant(users[count]);
            count++;
        }

        int userId, userId2;
        String say;

        while(true){
            System.out.println("Pick a user to be (0-" + count + ")");
            userId = sc.nextInt();
            System.out.println("Say something, grant access(grant), revoke access(revoke), or exit: ");
            say = sc.nextLine();
            say = sc.nextLine();
            if(say.equalsIgnoreCase("grant")){
                System.out.println("Grant who access to user " + userId + "?");
                userId2 = sc.nextInt();
                users[userId2].grant(users[userId]);
            }else if(say.equalsIgnoreCase("revoke")){
                System.out.println("Revoke who's access?");
                userId2 = sc.nextInt();
                users[userId2].revoke(users[userId]);
            }else if(say.equalsIgnoreCase("exit")){
                break;
            }else{
                users[userId].say(say, userId, users, count);
            }
        }
    }

}
