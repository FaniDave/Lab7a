import java.time.LocalDate;

public class MyStudentMgmtApp {

    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student(110001, "Dave", LocalDate.of(1951, 11, 18));
        students[1] = new Student(110002, "Anna", LocalDate.of(1990, 12, 7));
        students[2] = new Student(110003, "Erica", LocalDate.of(1974, 1, 31));
        students[3] = new Student(110004, "Carlos", LocalDate.of(2009, 8, 11));
        students[4] = new Student(110005, "Bob", LocalDate.of(1994, 5, 8));

        printListOfStudents(students);

        System.out.println("*".repeat(50));

        getListOfPlatinumAlumniStudents(students);

        System.out.println("*".repeat(50));

        int [] numbers = {1, 2, 4, 5, 7, 10, 15, 21, 35};
        printHelloWorld(numbers);

        System.out.println("*".repeat(50));

        System.out.println(findSecondBiggest(numbers));
    }

    public static void printListOfStudents(Student[] students) {
       for (int i = 0; i < students.length; i++) {
           for(int j = 0; j < students.length; j++) {
               if(students[i].getName().compareTo(students[j].getName()) > 0 && i < j) {
                   Student tempStudent = students[i];
                   students[i] = students[j];
                   students[j] = tempStudent;
               }
           }
       }

        for(Student tempStudent : students) {
            System.out.println(tempStudent.getStudentId() + ", " + tempStudent.getName() + ", " + tempStudent.getDateOfAdmission());
        }
    }

    public static void getListOfPlatinumAlumniStudents(Student[] students) {
         for(Student tempStudent : students) {
             if(LocalDate.now().getYear() - tempStudent.getDateOfAdmission().getYear() >= 30)
                 System.out.println(tempStudent.getStudentId() + ", " + tempStudent.getName() + ", " + tempStudent.getDateOfAdmission());
         }
    }

    public static void printHelloWorld (int [] numbers) {
         for(int number: numbers) {
             if(number >= 5) {
                 if(number % 5 == 0 && number % 7 == 0) {
                     System.out.println("Hello World");
                 } else if(number % 7 == 0) {
                     System.out.println("World");
                 } else if(number % 5 == 0) {
                     System.out.println("Hello");
                 }

             }
         }
    }

    public static int findSecondBiggest(int [] numbers) {
        int max = Integer.MIN_VALUE, maxSecond = Integer.MIN_VALUE;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] >= max) {
                max = numbers[i];
            }
        }

        for(int i = 0; i < numbers.length; i++) {
             if(numbers[i] >= maxSecond && max != numbers[i]) {
                 maxSecond = numbers[i];
             }
        }

        return maxSecond;
    }
}
