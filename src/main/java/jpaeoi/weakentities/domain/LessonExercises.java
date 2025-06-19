package jpaeoi.weakentities.domain;

import java.util.Set;

public class LessonExercises {

    private Lesson lesson;
    private Set<Exercise> exercises;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}
