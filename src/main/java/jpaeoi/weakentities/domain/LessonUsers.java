package jpaeoi.weakentities.domain;

import java.util.Set;

public class LessonUsers {

    private Lesson lesson;
    private Set<User> users;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
