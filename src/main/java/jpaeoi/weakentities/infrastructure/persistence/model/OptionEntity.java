package jpaeoi.weakentities.infrastructure.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "options", schema = "weak_entities")
public class OptionEntity {

    @EmbeddedId
    private OptionEntityId id;

    @Column(name = "question")
    private String question;



    public OptionEntityId getId() {
        return id;
    }

    public void setId(OptionEntityId id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
