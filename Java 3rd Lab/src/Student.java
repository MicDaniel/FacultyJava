public class Student {
    private String name;
    private int year;
    private int section;
    private double gradeFirstSem;
    private double gradeSecondSem;

    public Student(String name, int year, int section, double gradeFirstSem, double gradeSecondSem) {
        this.name = name;
        this.year = year;
        this.section = section;
        this.gradeFirstSem = gradeFirstSem;
        this.gradeSecondSem = gradeSecondSem;
    }

    public String getName() {
        return this.name;
    }

    public int getSection() {
        return this.section;
    }

    public double getGradeFirstSem() {
        return this.gradeFirstSem;
    }

    public int getYear() {
        return this.year;
    }

    public double getGradeSecondSem() {
        return this.gradeSecondSem;
    }

    public double meanOfGrades() {
        return (this.gradeFirstSem + this.gradeSecondSem)/2;
    }

    public void print() {
        System.out.println("Student's name: " + this.getName());
        System.out.println("Study year: " + this.getYear());
        System.out.println("Section: " + this.getSection());
        System.out.println("Mean of grades: " + this.meanOfGrades() + '\n');
    }
}
