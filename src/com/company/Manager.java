package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Manager {
    private ArrayList<InvestigationGroup> groups;
    private ArrayList<EffectiveMember> effMembers;
    private ArrayList<Student> students;
    private ArrayList<Publication> pubs;
    private final int currentYear = 2020;

    public Manager() {
        groups = new ArrayList<>();
        effMembers = new ArrayList<>();
        students = new ArrayList<>();
        pubs = new ArrayList<>();
    }

    /**
     * Method that allows the information extraction of txt files. The information is related to the members.
     */
    public void readStudents() {
        File f = new File("membros.txt");
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] div = line.split("#");
                    if (div[0].equals("EM")) {
                        EffectiveMember x = new EffectiveMember(div[1], div[2], div[3], Integer.parseInt(div[4]), Integer.parseInt(div[5]));
                        effMembers.add(x);
                        for (InvestigationGroup group : groups) {
                            if (group.getAcronym().equals(div[3])) {
                                group.addList(x);
                            }
                        }
                    } else if (div[0].equals("S")) {
                        for (Investigator w : effMembers) {
                            if (w.getInvName().equals(div[6]) && w.getInvestigationGroup().equals(div[3])) {
                                Student y = new Student(div[1], div[2], div[3], div[4], div[5], div[6]);
                                students.add(y);
                                for (InvestigationGroup group : groups) {
                                    if (group.getAcronym().equals(div[3])) {
                                        group.addList(y);
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
    }

    /**
     * Method that allows the information extraction of txt files. The information is related to the groups.
     */
    public void readFile() {
        File f = new File("grupos.txt");
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] div = line.split("#");
                    InvestigationGroup x = new InvestigationGroup(div[0], div[1], div[2]);
                    groups.add(x);
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
    }

    /**
     * Method that allows the information extraction of txt files. The information is related to the publications.
     * Besides that, the publications are added to the respective ArrayList.
     */
    public void addPub() {
        File f = new File("pubs.txt");
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] div = line.split("#");

                    switch (div[0]) {
                        case "CA" -> {
                            Publication x = new ConfArticle(div[1], div[2], div[3], Integer.parseInt(div[4]), Integer.parseInt(div[5]), div[6], div[7], div[8], div[9]);
                            pubs.add(x);
                        }
                        case "MA" -> {
                            Publication x = new MagArticle(div[1], div[2], div[3], Integer.parseInt(div[4]), Integer.parseInt(div[5]), div[6], div[7], div[8], Integer.parseInt(div[9]));
                            pubs.add(x);
                        }
                        case "B" -> {
                            Publication x = new Book(div[1], div[2], div[3], Integer.parseInt(div[4]), Integer.parseInt(div[5]), div[6], div[7], div[8]);
                            pubs.add(x);
                        }
                        case "BC" -> {
                            Publication x = new BookChapters(div[1], div[2], div[3], Integer.parseInt(div[4]), Integer.parseInt(div[5]), div[6], div[7], div[8], div[9], Integer.parseInt(div[10]), Integer.parseInt(div[11]));
                            pubs.add(x);
                        }
                        case "CAB" -> {
                            Publication x = new ConfArticleBook(div[1], div[2], div[3], Integer.parseInt(div[4]), Integer.parseInt(div[5]), div[6], div[7], div[8], div[9], Integer.parseInt(div[10]));
                            pubs.add(x);
                        }
                    }

                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
    }

    /**
     * Method that shows the total members as well as their personal details.
     */
    public void totalMembers() {
        System.out.println("\n  == EFFECTIVE MEMBERS == \n");
        for (EffectiveMember ef : effMembers) System.out.println(ef);

        System.out.println("\n  == STUDENTS == \n");
        for (Student student : students) System.out.println(student);
    }

    /**
     * Method that shows the number of members.
     */
    public void membersNum() {
        System.out.print("\n\n== == == == == == == == ==\n>> Total Members Count:\n\n>> Effective Members: ");
        int count = 0;
        for (EffectiveMember ignored : effMembers) count++;
        System.out.println(count);
        count = 0;

        System.out.print(">> Students: ");
        for (Student ignored : students) count++;
        System.out.println(count);
        System.out.println("== == == == == == == == ==\n");

    }


    /**
     * Method that sorts publications by their Impact Factor. The publications shown are dated back to a max of 5 years.
     */
    public void impactSort() {
        System.out.print("\n>> Investigation Group's Acronym: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for(InvestigationGroup iG : groups){
            if(iG.getAcronym().equals(name)){
                Collections.sort(pubs, new ImpactSort());
                System.out.println("\n\t - - " + iG.getName() + " Publications (Last 5 years) sorted by impact - -\n");
                invGroupPubs(iG);
                break;
            }
        }
    }

    /**
     * Method that sorts publications by their Type. The publications shown are dated back to a max of 5 years.
     */
    public void typeSort() {
        System.out.print("\n>> Investigation Group's Acronym: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for(InvestigationGroup iG : groups){
            if(iG.getAcronym().equals(name)){
                Collections.sort(pubs, new TypeSort());
                System.out.println("\n\t - - " + iG.getName() + " Publications (Last 5 years) sorted by type - -\n");
                invGroupPubs(iG);
                break;
            }
        }
    }

    /**
     * Method that sorts publications by their Date. The publications shown are dated back to a max of 5 years.
     */
    public void dateSort() {
        System.out.print("\n>> Investigation Group's Acronym: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for(InvestigationGroup iG : groups){
            if(iG.getAcronym().equals(name)){
                Collections.sort(pubs, new DateSort());
                System.out.println("\n\t - - " + iG.getName() + " Publications (Last 5 years) sorted by date - -\n");
                invGroupPubs(iG);
                break;
            }
        }
    }

    /**
     * Method that sorts publications of a certain investigator by their Impact Factor.
     */
    public void impactSorted() {
        System.out.print("\n>> Investigator's Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int count = 0;
        for (EffectiveMember effectiveMember : effMembers) {
            if(effectiveMember.getInvName().equals(name)){
                count++;
                Collections.sort(pubs, new ImpactSort());
                System.out.println("\n\t - - Publications by " + effectiveMember.getInvName() + " (sorted by impact) - -\n");
                invPubs(effectiveMember);
            }
        }
        if(count == 0){ // checks if the investigator was or was not an effective member and runs it if it was not.
            for (Student student : students) {
                if(student.getInvName().equals(name)){
                    Collections.sort(pubs, new ImpactSort());
                    System.out.println("\n\t - - Publications by " + student.getInvName() + " (sorted by impact) - -\n");
                    invPubs(student);
                }
            }
        }

    }

    /**
     * Method that sorts publications of a certain investigator by their Type.
     */
    public void typeSorted() {
        System.out.print("\n>> Investigator's Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int count = 0;
        for (EffectiveMember effectiveMember : effMembers) {
            if(effectiveMember.getInvName().equals(name)){
                count++;
                Collections.sort(pubs, new TypeSort());
                System.out.println("\n\t - - Publications by " + effectiveMember.getInvName() + " (sorted by type) - -\n");
                invPubs(effectiveMember);
            }
        }
        if(count == 0){ // checks if the investigator was or was not an effective member and runs it if it was not.
            for (Student student : students) {
                if(student.getInvName().equals(name)){
                    Collections.sort(pubs, new TypeSort());
                    System.out.println("\n\t - - Publications by " + student.getInvName() + " (sorted by type) - -\n");
                    invPubs(student);
                }
            }
        }
    }

    /**
     * Method that sorts publications of a certain investigator by their Date.
     */
    public void dateSorted() {
        System.out.print("\n>> Investigator's Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int count = 0;
        for (EffectiveMember effectiveMember : effMembers) {
            if(effectiveMember.getInvName().equals(name)){
                count++;
                Collections.sort(pubs, new DateSort());
                System.out.println("\n\t - - Publications by " + effectiveMember.getInvName() + " (sorted by date) - -\n");
                invPubs(effectiveMember);
            }
        }
        if(count == 0){ // checks if the investigator was or was not an effective member and runs it if it was not.
            for (Student student : students) {
                if(student.getInvName().equals(name)){
                    Collections.sort(pubs, new DateSort());
                    System.out.println("\n\t - - Publications by " + student.getInvName() + " (sorted by date) - -\n");
                    invPubs(student);
                }
            }
        }
    }

    /**
     * Method that shows publications dated back to a maximum of 5 years.
     */
    public void recentPubs() {
        System.out.println("\n>> Publications within the last 5 years\n\n");
        for (Publication pub : pubs) {
            if (currentYear - pub.getPublishedIn() <= 5)
                System.out.println(pub);
        }
    }


    /**
     * Method that shows the number of publications of each type.
     */
    public void typePubs() {
        System.out.println("\n>> Types of Publications:\n");
        String[] array = {"Conference Articles", "Magazine Articles", "Books", "Book Chapters", "Conference Article Books"};
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (Publication pub : pubs) {
                if (pub.getType() == i + 1)
                    count++;
            }
            System.out.println("Number of " + array[i] + ": " + count+"\n");
        }
    }

    /**
     * Method that shows the publications of a certain investigator passed on as a parameter.
     * @param inv Investigator whose publications will be shown.
     */
    public void invPubs(Investigator inv) {
        for (Publication pub : pubs) {
            ArrayList<String> x = pub.individualAuthors();
            for (String s : x) {
                if (s.equals(inv.getInvName())) System.out.println(pub);
            }
        }
    }

    /**
     * Shows the publications by a certain investigation group as well as the number of publications of that same
     * investigation group.
     * @param iG Investigation Group
     */
    public void invGroupPubs(InvestigationGroup iG) {
        System.out.println("\n\t - - " + iG.getName() + " Pubs - -\n");
        int counter = 0;
        ArrayList<Publication> f = new ArrayList<>();
        for (Publication pub : pubs) {
            ArrayList<String> x = pub.individualAuthors();
            for (String s : x) {
                for (EffectiveMember effectiveMember : effMembers) {
                    if (!f.contains(pub) && currentYear - pub.getPublishedIn() <= 5) {
                        if (s.equals(effectiveMember.getInvName()) && iG.getAcronym().equals(effectiveMember.getInvestigationGroup())){
                            f.add(pub);
                            counter++;
                        }
                    }
                }
                for (Student student : students) {
                    if (!f.contains(pub) && currentYear - pub.getPublishedIn() <= 5) {
                        if (s.equals(student.getInvName()) && iG.getAcronym().equals(student.getInvestigationGroup())){
                            f.add(pub);
                            counter++;
                        }
                    }
                }
            }
        }
        for (Publication pub : f) System.out.println(pub);
        System.out.println("Number of Publications: " + counter);
    }

    /**
     * Executes the "invGroupPubs(group)" method for every investigation group.
     */
    public void allInvGroupPubs(){
        for(InvestigationGroup group : groups) invGroupPubs(group);
    }

    /**
     * Executes the "catSort(String st)" method for every investigation group.
     */
    public void allCatSort(){
        for(InvestigationGroup group : groups) catSort(group.getAcronym());
    }

    /**
     * Shows the total members of a specific investigation group as well as the number of members
     * in that certain investigation group.
     * @param st Investigation Group's Acronym.
     */
    public void catSort(String st) {
        for(InvestigationGroup iG : groups){
            if(st.equals(iG.getAcronym())){
                System.out.println("\n\t - - " + iG.getName() + " Investigators (grouped by category) - -\n");
                ArrayList<Investigator> f = new ArrayList<>();
                int counter = 0;
                int counter2 = 0;
                for (EffectiveMember eff : effMembers) {
                    if(iG.getAcronym().equals(eff.getInvestigationGroup())){
                        f.add(eff);
                        counter++;
                    }
                }
                for (Student s : students) {
                    if(iG.getAcronym().equals(s.getInvestigationGroup())){
                        f.add(s);
                        counter2++;
                    }
                }
                for (Investigator i : f) System.out.println(i);
                System.out.println("\n>> Number of Effective Members: "+counter);
                System.out.println(">> Number of Students: "+counter2);

                //grouping effective members first and then students doesn't require any type of sort since I've used 2 different
                //array lists.
            }
        }
    }


    /**
     * Method that creates an obj file containing the publications information.
     */
    public void createPubsOBJ(){
        File f = new File("PubsFile.obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pubs);
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }

    /**
     * Method that creates an obj file containing the investigation groups information.
     */
    public void createGroupsOBJ(){
        File f = new File("GroupsFile.obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(groups);
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }


    /**
     * Method that creates an obj file containing the effective members information.
     */
    public void createEffMembersOBJ(){
        File f = new File("EffMemFile.obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(effMembers);
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }

    /**
     * Method that creates an obj file containing the students information.
     */
    public void createStudentsOBJ(){
        File f = new File("StudentsFile.obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }

    /**
     * Method that reads an obj file containing the publications information and stores said info in the
     * respective ArrayList.
     */
    public void readPubsOBJ(){
        String file_name = "PubsFile.obj";
        File f = new File(file_name);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            pubs = (ArrayList<Publication>) ois.readObject();

            ois.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro Objeto não encontrado... A informação irá ser lida do Ficheiro Texto");
            addPub();
        } catch (IOException ex) {
            System.out.println("Erro a ler o ficheiro "+file_name);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }

    /**
     * Method that reads an obj file containing the Investigation Group's information and stores said info in the
     * respective ArrayList.
     */
    public void readGroupsOBJ(){
        String file_name = "GroupsFile.obj";
        File f = new File(file_name);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            groups = (ArrayList<InvestigationGroup>) ois.readObject();

            ois.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro Objeto não encontrado... A informação irá ser lida do Ficheiro Texto");
            readFile();
        } catch (IOException ex) {
            System.out.println("Erro a ler o ficheiro "+file_name);
            ex.printStackTrace();
            ex.getCause();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }

    /**
     * Method that reads an obj file containing the Effective Members information and stores said info in the
     * respective ArrayList.
     */
    public void readEffMembersOBJ(){
        String file_name = "EffMemFile.obj";
        File f = new File(file_name);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            effMembers = (ArrayList<EffectiveMember>) ois.readObject();
            ois.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro Objeto não encontrado... A informação irá ser lida do Ficheiro Texto");
            readStudents();
        } catch (IOException ex) {
            System.out.println("Erro a ler o ficheiro "+file_name);
            ex.printStackTrace();
            ex.getCause();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }

    /**
     * Method that reads an obj file containing the Students' information and stores said info in the
     * respective ArrayList.
     */
    public void readStudentsOBJ(){
        String file_name = "StudentsFile.obj";
        File f = new File(file_name);
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();
            ois.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro Objeto não encontrado... A informação irá ser lida do Ficheiro Texto");
        } catch (IOException ex) {
            System.out.println("Erro a ler o ficheiro "+file_name);
            ex.printStackTrace();
            ex.getCause();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
    }

}
