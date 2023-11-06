package com.reis.paquimetro.service.impl;

import com.reis.paquimetro.mapper.PaymentInformationMapper;
import com.reis.paquimetro.model.DTO.PaymentInformationDTO;
import com.reis.paquimetro.model.PaymentInformation;
import com.reis.paquimetro.model.PaymentType;
import com.reis.paquimetro.model.User;
import com.reis.paquimetro.repository.PaymentInformationRepository;
import com.reis.paquimetro.service.PaymentInformationService;
import com.reis.paquimetro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentInformationServiceImpl implements PaymentInformationService {

    @Autowired
    private PaymentInformationMapper mapper;

    @Autowired
    private PaymentInformationRepository paymentInformationRepository;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity createPaymentInformation(PaymentInformationDTO paymentInformationDTO) {

        User user = userService.findById(paymentInformationDTO.getUserId());

        if(paymentInformationDTO.getPaymentType().equals(PaymentType.PIX)){
            PaymentInformation paymentInformation = new PaymentInformation();
            paymentInformation.setPaymentType(paymentInformationDTO.getPaymentType());
            paymentInformation.setUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(paymentInformationRepository.save(paymentInformation));
        }
        PaymentInformation paymentInformation = mapper.dtoToEntity(paymentInformationDTO);
        paymentInformation.setUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentInformationRepository.save(paymentInformation));
    }


    @Override
    public ResponseEntity<List<PaymentInformation>> findPaymentInformationByUserId(Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(paymentInformationRepository.findAllByUser(user));
    }

    @Override
    public ResponseEntity deletePaymentInformation(Long id) {
        
        if (paymentInformationRepository.findById(id).isPresent()) {
            paymentInformationRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("veiculo deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    public ResponseEntity editPaymentInformation(Long id, PaymentInformationDTO paymentInformationDTO) {
        Optional<PaymentInformation> paymentInformationOptional = paymentInformationRepository.findById(id);
        if (paymentInformationOptional.isPresent()) {
            PaymentInformation paymentInformation = mapper.dtoToEntity(paymentInformationDTO);
            paymentInformation.setId(id);
            return ResponseEntity.ok().body(paymentInformationRepository.save(paymentInformation));
        }else{
            return ResponseEntity.badRequest().body("Numero de id inválido");
        }
    }
}
