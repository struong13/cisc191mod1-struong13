package edu.sdccd.cisc191;

/**
 * Module 1 - Demo runner.
 * This is primarily for your video demo.
 */
public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Lexie", 3.8, 1),
                new Student("Emily", 2.0, 2),
                new Student("Ivy", 3.5, 3),
                new Student("Sarahi", 3.2, 4),
                new Student("Jolene", 4.0, 5),
                new Student("Emilee", 3.9, 6)
        };
/**
 * you can make this printing code more compact and readable by using short for-loops and reusing methods
 * here is an example
 * System.out.println("--- Original Order ---");
 * for (Student s : students) System.out.println(s);
 *
 * i would also suggest that you could make the print statements single lined so as to make it more readable
 */
        // Original order
        System.out.printf(
                "Original Order of Students:\n%s\n\n",
    getStudentsAsLines(students)
        ); /// for-loop here

    // Sorted by GPA
    Student[] sortedStudents =
            StudentArrayToolkit.copySortedByGpaDesc(students);

        System.out.printf(
                "Students Sorted by GPA:\n%s\n\n",
    getStudentsAsLines(sortedStudents)
        ); /// combination of copySortedByGpaDesc() and a for-loop

    // Top 3 students
    Student[] topThreeStudents =
            StudentArrayToolkit.topNByGpa(students, 3);

        System.out.printf(
                "Top 3 Students by GPA:\n%s\n\n",
    getStudentsAsLines(topThreeStudents)
        ); /// combination of topNByGpa() and a for-loop

    // Find existing ID
        System.out.printf(
                "Student with ID 1: %s\n",
                StudentArrayToolkit.findByIdLinear(students, 1)
            );

    // Find non-existing ID
    Student result =
            StudentArrayToolkit.findByIdLinear(students, 7);

        System.out.printf(
                "Student with non-existent ID 7: %s\n",
    result == null ? "Not Found" : result
        );

        System.out.println("\nModule 1 Demo Complete!");
}
///  this function is not really needed since it makes it loop complex than it actually is
// Helper method for formatting output
private static String getStudentsAsLines(Student[] students) {
    StringBuilder sb = new StringBuilder();
    for (Student s : students) {
        sb.append(s).append("\n");
    }
    return sb.toString();
}
}
