package schoolchild;

public interface PrimarySchoolChild {
    static PrimarySchoolChild of(int age) {
        if (age>6 && age<10)
            return new LowerClassSchoolChild("Pistike", age);
        if (age>11 && age<14)
            return new UpperClassSchoolChild("Józsi", age);
        throw new IllegalArgumentException("Wrong");
    }
}
