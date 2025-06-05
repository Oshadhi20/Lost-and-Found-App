package lk.ijse.cmjd108.Lost_and_Found.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @OneToMany(mappedBy = "item")
    private List<Request> requests;
}
