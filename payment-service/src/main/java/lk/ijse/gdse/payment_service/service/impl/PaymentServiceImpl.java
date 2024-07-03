package lk.ijse.gdse.payment_service.service.impl;

import lk.ijse.gdse.payment_service.dto.PaymentDTO;
import lk.ijse.gdse.payment_service.entity.Payment;
import lk.ijse.gdse.payment_service.repo.PaymentRepo;
import lk.ijse.gdse.payment_service.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PaymentDTO savePayment(PaymentDTO dto) {
        if (repo.existsById(dto.getId())){
            new RuntimeException("all ready exits");
        }
        return mapper.map(repo.save(mapper.map(dto, Payment.class)),PaymentDTO.class);
    }

    @Override
    public PaymentDTO updatePayment(PaymentDTO dto) {
        if (repo.existsById(dto.getId())){
            new RuntimeException("all ready exits");
        }
        return mapper.map(repo.save(mapper.map(dto, Payment.class)),PaymentDTO.class);
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<PaymentDTO>>() {
        }.getType());
    }
}
