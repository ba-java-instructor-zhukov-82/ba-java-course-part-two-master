package java_se._2_serialization.presentation.complex_object_serialization.non_serializable;

public class CourseNotSerializable {

    private long id;
    private String name;

    public CourseNotSerializable(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
