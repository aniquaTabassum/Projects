
import java.util.ArrayList;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class Users implements Comparable<Users> {

    public String name;
    String country;
    public String sex;
    public String department;
    public String marriedS;
    String cgpa;

    public Users(String name, String country, String department, String sex, String marriedS, String cgpa) {
        this.country = country;
        this.sex = sex;
        this.name = name;
        this.department = department;
        this.marriedS = marriedS;
        this.cgpa = cgpa;
    }

    public String getName() {
        return this.name;
    }

    public String getDept() {
        return this.department;
    }

    public String getCGPA() {
        return this.cgpa;
    }

    public int compareTo(Users compareUsers) {
        return 0;
    }

    /**
     *
     */
    public static Comparator<Users> UsersNameComparator = new Comparator<Users>() {
        @Override
        public int compare(Users user1, Users user2) {
            String userName1 = user1.getName();
            String userName2 = user2.getName();
            return userName1.compareTo(userName2);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }

    };

    public static Comparator<Users> UsersDepartmentComparator = new Comparator<Users>() {
        @Override
        public int compare(Users user1, Users user2) {
            String userCGPA1 = user1.getDept();
            String userCGPA2 = user2.getDept();
            return userCGPA1.compareTo(userCGPA2);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }

    };
    public static Comparator<Users> UsersCGPAComparator = new Comparator<Users>() {
        @Override
        public int compare(Users user1, Users user2) {
            String userDept1 = user1.getCGPA();
            String userDept2 = user2.getCGPA();
            return userDept1.compareTo(userDept2);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }

    };

    public static int searchName(ArrayList list,ArrayList listNew, String searchNameString) {
       // ArrayList<Users> listNew = new ArrayList<Users>();
       int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            String nameInList = ((Users) list.get(i)).name;
            System.out.println("in users " + nameInList + " searching for" + searchNameString);
            if (nameInList.equalsIgnoreCase(searchNameString)) {
                flag = 1;
                System.out.println("entered");
                String deptInList = ((Users) list.get(i)).department;
                String countryInList = ((Users) list.get(i)).country;
                String sexInList = ((Users) list.get(i)).sex;
                String cgpaInList = ((Users) list.get(i)).cgpa;
                String marriedInList = ((Users) list.get(i)).marriedS;
                Users user = new Users(nameInList, countryInList, deptInList, sexInList, marriedInList, cgpaInList);
                listNew.add(user);
            } else {
                System.err.println("what?");
            }
        }

        return flag;
    }

    public static int searchDept(ArrayList list, ArrayList listNew,String searchDeptString) {
        //ArrayList<Users> listNew = new ArrayList<Users>();
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            String deptInList = ((Users) list.get(i)).department;
            //System.out.println("in users " + nameInList + " searching for" + searchDeptString);
            if (deptInList.equalsIgnoreCase(searchDeptString)) {
                flag = 1;
                System.out.println("entered");
                String nameInList = ((Users) list.get(i)).name;
                String countryInList = ((Users) list.get(i)).country;
                String sexInList = ((Users) list.get(i)).sex;
                String cgpaInList = ((Users) list.get(i)).cgpa;
                String marriedInList = ((Users) list.get(i)).marriedS;
                Users user = new Users(nameInList, countryInList, deptInList, sexInList, marriedInList, cgpaInList);
                listNew.add(user);
            } else {
                System.err.println("what?");
            }
        }

        return flag;
    }
   public static int searchCountry(ArrayList list,ArrayList listNew,String searchCountryString){
       
         //ArrayList<Users> listNew = new ArrayList<Users>();
       
         int flag =0;
        for (int i = 0; i < list.size(); i++) {
            String countryInList = ((Users) list.get(i)).country;
            //System.out.println("in users " + nameInList + " searching for" + searchDeptString);
            if (countryInList.equalsIgnoreCase(searchCountryString)) {
                System.out.println("entered");
                flag = 1;
                String nameInList = ((Users) list.get(i)).name;
                String deptInList = ((Users) list.get(i)).department;
                String sexInList = ((Users) list.get(i)).sex;
                String cgpaInList = ((Users) list.get(i)).cgpa;
                String marriedInList = ((Users) list.get(i)).marriedS;
                Users user = new Users(nameInList, countryInList, deptInList, sexInList, marriedInList, cgpaInList);
                listNew.add(user);
            } else {
                System.err.println("what?");
            }
        }

        return flag;
   }
   public static int searchCGPA(ArrayList list,ArrayList listNew,String searchCGPAString){
      
         //ArrayList<Users> listNew = new ArrayList<Users>();
           System.out.println(list.size());
         int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            String cgpaInList = ((Users) list.get(i)).cgpa;
            //System.out.println("in users " + nameInList + " searching for" + searchDeptString);
            System.out.println("searching for "+cgpaInList+" and found "+searchCGPAString);
            if (cgpaInList.equalsIgnoreCase(searchCGPAString)) {
                flag = 1;
                System.out.println("entered");
                String nameInList = ((Users) list.get(i)).name;
                String deptInList = ((Users) list.get(i)).department;
                String sexInList = ((Users) list.get(i)).sex;
                String countryInList = ((Users) list.get(i)).country;
                String marriedInList = ((Users) list.get(i)).marriedS;
                Users user = new Users(nameInList, countryInList, deptInList, sexInList, marriedInList, cgpaInList);
                listNew.add(user);
            } else {
                System.err.println("what?");
            }
        }

        return flag;
   }
}
