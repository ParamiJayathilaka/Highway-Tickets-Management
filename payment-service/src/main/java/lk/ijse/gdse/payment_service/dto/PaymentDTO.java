package lk.ijse.gdse.payment_service.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDTO {
    private String id;
    private String ticketId;
    private String date;
    private double price;
    private String type;
}
