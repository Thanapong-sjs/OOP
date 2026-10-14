public class Student {
    private String name;
    private String grades;

    public Student(String name, String grades) {
        this.name = name;
        this.grades = grades;
    }

    public void show() {
        try {
            // 1. ตรวจสอบชื่อ (เช็คตัวเลขก่อน ตามด้วยช่องว่าง)
            if (name.matches(".*\\d.*")) {
                throw new DigitException();
            }
            if (name.contains(" ")) {
                throw new SpaceException();
            }

            // 2. ตรวจสอบเกรด (ความถูกต้องก่อนค่า I)
            for (int i = 0; i < grades.length(); i++) {
                char g = grades.charAt(i);
                if (g != 'A' && g != 'B' && g != 'C' && g != 'D' && g != 'E' && g != 'F' && g != 'I') {
                    throw new GradeException();
                }
            }
            if (grades.contains("I")) {
                throw new IncompleteException();
            }

            // 3. คำนวณ GPA
            double totalPoints = 0;
            for (int i = 0; i < grades.length(); i++) {
                char g = grades.charAt(i);
                if (g == 'A') totalPoints += 4.0;
                else if (g == 'B') totalPoints += 3.0;
                else if (g == 'C') totalPoints += 2.0;
                else if (g == 'D') totalPoints += 1.0;
            }
            
            int subjectCount = grades.length();
            double gpa = totalPoints / subjectCount; 

            System.out.println(name + " registered " + subjectCount + " subjects and got GPA " + gpa);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}