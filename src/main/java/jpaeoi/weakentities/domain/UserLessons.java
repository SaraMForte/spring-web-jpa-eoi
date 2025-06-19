package jpaeoi.weakentities.domain;

import java.util.Set;

public class UserLessons {

    private User user;
    private Set<Lesson> lessons;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
