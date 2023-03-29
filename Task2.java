package HW5;
//Пусть дан список сотрудников:

//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
//        Отсортировать по убыванию популярности Имени.


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:/Users/Виктор Егоров/IdeaProjects/GB/src/main/java/HW5/employees.txt");
        ArrayList<String> list = fileRead(file);
        fillMap(list);
        System.out.println(sortedMap(employees));
    }

    public static HashMap<String, Integer> employees = new HashMap<>();


    public static ArrayList<String> fileRead(File file) throws FileNotFoundException {
        ArrayList<String> readedFile = new ArrayList<>();
        String line = null;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        try {

            while ((line = br.readLine()) != null) {
                readedFile.add(line);
            }

        } catch (Exception ex) {
            System.out.println("Exception");
        }
        return readedFile;
    }

    public static void fillMap(ArrayList<String> employeesList) {
        for (int i = 0; i < employeesList.size(); i++) {
            if (!employees.containsKey(getName(employeesList.get(i)))) {
                employees.put(getName(employeesList.get(i)), 1);
            } else {
                employees.put(getName(employeesList.get(i)), employees.get(getName(employeesList.get(i))) + 1);
            }
        }
    }

    public static int namesCount(String employeeLastNames) {
        String[] names = employeeLastNames.split(" ");
        return names.length;
    }

    public static String getName(String employee) {
        String[] emp = employee.split(" ");
        return emp[0];
    }

    public static LinkedHashMap sortedMap(HashMap<String, Integer> employees) {
        LinkedHashMap newEmployees = new LinkedHashMap<>();
        ArrayList<String> fromMap = new ArrayList<>();
        int max = 0;
        for (Map.Entry<String, Integer> entry : employees.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) max = value;
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : employees.entrySet()) {
                Integer value = entry.getValue();
                String key = entry.getKey();
                if (value == i) {
                    newEmployees.put(key, value);
                }
            }
        }
        return newEmployees;
    }
}
