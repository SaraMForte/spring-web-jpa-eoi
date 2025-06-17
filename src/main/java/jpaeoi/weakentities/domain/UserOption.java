package jpaeoi.weakentities.domain;

public class UserOption {

    private User user;
    private Option option;
    private Difficulty difficulty;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public enum Difficulty {
        EASY, MEDIUM, HARD, VERY_HARD
    }
}
