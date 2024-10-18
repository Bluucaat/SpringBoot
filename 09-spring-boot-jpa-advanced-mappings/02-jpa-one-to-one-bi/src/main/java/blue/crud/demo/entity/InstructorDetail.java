package blue.crud.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "instructor_detail")
public @Data class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String channelLink;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)

    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String channelLink, String hobby) {
        this.channelLink = channelLink;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", channelLink='" + channelLink + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
