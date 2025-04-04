//Изучение TreeSet
//Реализация класса, который, используя TreeSet находит список учеников, сдавших экзамен на оценку выше заданного числа.
//Для решения задачи реализован собственный класс Student, реализующий интерфейс Comparable.

import java.util.TreeSet;
import java.util.Scanner;
class Student implements Comparable<Student>{
    private int point;
    private String name;
    public Student(String name,int point){
        this.name = name;
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.point,o.point);
    }

    public String toString(){
        return "Имя: " + name + ", Баллы: " + point;
    }
}

public class ExamRes{
    private TreeSet<Student> students;
    public ExamRes(){
        this.students = new TreeSet<>();
    }
    public void addStudent(Student student){
        this.students.add(student);
    }
    public TreeSet<Student> ResultExam(int score){
        TreeSet<Student> result = new TreeSet<>();
        for(Student student:students){
            if(student.getPoint() > score){
                result.add(student);
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите кол-во студентов: ");
        int m = scan.nextInt();
        ExamRes examres = new ExamRes();
        for (int i = 0;i < m;i++){
            System.out.print("Введите баллы студента: ");
            int score = scan.nextInt();
            scan.nextLine();
            System.out.print("Введите имя студента: ");
            String name = scan.nextLine();
            System.out.println();
            examres.addStudent(new Student(name,score));
        }
        System.out.print("Введите минимальное кол-во баллов: ");
        int n = scan.nextInt();
        TreeSet<Student> studentList = examres.ResultExam(n);
        for(Student student:studentList){
            System.out.println(student);
        }
    }
}









