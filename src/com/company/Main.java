package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n>> Initializing... please wait...\n");
        Scanner sc = new Scanner(System.in);
        int op, decision = 0;
        Manager action = new Manager();


        action.readGroupsOBJ();
        action.readPubsOBJ();
        action.readEffMembersOBJ();
        action.readStudentsOBJ();


        while(true) {
            System.out.print("\n>> Choose a valid operation\n(1) TOTAL MEMBERS\n(2) NUMBER OF MEMBERS (TYPED)" +
                    "\n(3) PUBLICATIONS WITHIN THE LAST 5 YEARS\n(4) NUMBER OF PUBLICATIONS (TYPED)" +
                    "\n(5) PUBLICATIONS WITHIN THE LAST 5 YEARS (SORTED BY...)\n(6) GROUP MEMBERS SORTED BY CATEGORY" +
                    "\n(7) INVESTIGATOR PUBLICATIONS' SORTED BY...\n(8) GROUP MEMBERS/GROUP'S MEMBER COUNT" +
                    "\n(9) PUBLICATIONS WITHIN THE LAST 5 YEARS (SHOWN BY GROUP)\n(10) EXIT\n>> Option Number: ");
            op = sc.nextInt();

            if (op == 1)
                action.totalMembers();
            else if (op == 2)
                action.membersNum();
            else if (op == 3)
                action.recentPubs();
            else if (op == 4)
                action.typePubs();
            else if (op == 5){
                while(true){
                    System.out.print("\n>> Sort by:\n(1) Impact\n(2) Publication Type\n(3) Date\nAnswer: ");
                    decision = sc.nextInt();
                    if(decision == 1){
                        action.impactSort();
                        break;
                    }
                    else if (decision == 2) {
                        action.typeSort();
                        break;
                    }
                    else if (decision == 3) {
                        action.dateSort();
                        break;
                    }
                    else System.out.println("\n>> Invalid Input. Please try again.");
                }
            }
            else if (op == 6){
                System.out.print("\n>> Investigation Group Acronym: ");
                String x = sc.next();
                action.catSort(x);
            }
            else if (op == 7){
                while(true){
                    System.out.print("\n>> Sort by:\n(1) Impact\n(2) Publication Type\n(3) Date\nAnswer: ");
                    decision = sc.nextInt();
                    if(decision == 1){
                        action.impactSorted();
                        break;
                    }
                    else if (decision == 2) {
                        action.typeSorted();
                        break;
                    }
                    else if (decision == 3) {
                        action.dateSorted();
                        break;
                    }
                    else System.out.println("\n>> Invalid Input. Please try again.");
                }
            }
            else if (op == 8)
                action.allCatSort();
            else if (op == 9)
                action.allInvGroupPubs();
            else if (op == 10){ // save
                //Creating obj files
                action.createGroupsOBJ();
                action.createEffMembersOBJ();
                action.createStudentsOBJ();
                action.createPubsOBJ();
                System.out.println("\n>> Shutting down...");
                break;
            }
            else System.out.println("\n>> Invalid input");

        }
    }
}