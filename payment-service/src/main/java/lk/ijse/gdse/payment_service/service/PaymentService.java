package lk.ijse.gdse.payment_service.service;

import lk.ijse.gdse.payment_service.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    PaymentDTO savePayment(PaymentDTO dto);
    PaymentDTO updatePayment(PaymentDTO dto);
    List<PaymentDTO> getAllPayment();
}
