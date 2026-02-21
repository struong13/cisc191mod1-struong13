package edu.sdccd.cisc191;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Module 1 - Part C
 * Utility methods for working with Student[].
 *
 * IMPORTANT:
 * - Methods that return Student[] must return NEW arrays (defensive copy).
 * - For sorting, use a Comparator created with a lambda or method references.
 */
public class StudentArrayToolkit {

    /**
     * Returns a NEW array sorted by:
     * 1) GPA descending
     * 2) name ascending (tie-breaker)
     *
     * Must not modify the original array.
     */
    public static Student[] copySortedByGpaDesc(Student[] students) {
///  though it is not asked, it would be good to check that the student array is not empty
        Student[] copy = students.clone();  // defensive copy

        Arrays.sort(copy, (a, b) -> {
            int gpaCompare = Double.compare(b.getGpa(), a.getGpa());
            if (gpaCompare != 0) {
                return gpaCompare;
            }
            return a.getName().compareTo(b.getName());
        });

        return copy;
    }


        /**
         * Linear search for a student by id.
         * Returns the Student if found, otherwise null.
         */
        public static Student findByIdLinear(Student[] students, int id) {
///  though it is not asked, it would be good to check that the student array is not empty here too
            for (Student s : students) {
                if (s.getId() == id) {
                    return s;
                }
            }

            return null;
        }

    /**
     * Returns a NEW array containing the top N students by GPA desc (ties: name asc).
     * If n > students.length, return all students (sorted).
     * If n == 0, return an empty array.
     * @throws IllegalArgumentException if n < 0
     */
    public static Student[] topNByGpa(Student[] students, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
            /// i would suggest you to write a message here when throwing the exception
        }

        Student[] sorted = copySortedByGpaDesc(students);

        if (n == 0) {
            return new Student[0];
        }

        if (n >= sorted.length) {
            return sorted;
        }

        return Arrays.copyOf(sorted, n);
    }
}
