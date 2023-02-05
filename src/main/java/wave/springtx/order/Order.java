package wave.springtx.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private String username; //정상, 예외, 잔고부족

    private String payStatus; //대기, 완료
}
