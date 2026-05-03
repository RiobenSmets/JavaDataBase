public class Student {
    private String studentId, lname, fname, mi;

    public Student(String studentId, String lname, String fname, String mi) {
        this.studentId = studentId;
        this.lname = lname;
        this.fname = fname;
        this.mi = mi;
    }

    public String getStudentId() { 
        return studentId; 
    }

    public String getLname() { 
        return lname;
    }

    public String getFname() { 
        return fname; 
    }

    public String getMi() { 
        return mi; 
    }
}