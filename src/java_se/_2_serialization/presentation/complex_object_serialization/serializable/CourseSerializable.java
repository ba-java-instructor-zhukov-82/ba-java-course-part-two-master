package java_se._2_serialization.presentation.complex_object_serialization.serializable;

import java.io.Serializable;

public class CourseSerializable implements Serializable {

    private long id;
    private String name;

    public CourseSerializable(long id, String name) {
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
