package blue.crud.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="review")
public @Data class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="comment")
    private String comment;

    public Review(){
    }

    public Review(String comment) {
        this.comment = comment;
    }
}
