package com.example.bankify.models;

import com.example.bankify.enums.TipoCartao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_cartao", nullable = false, unique = true, length = 16)
    private String numeroCartao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoCartao tipo; // CREDITO, DEBITO

    @Column(name = "limite", precision = 19, scale = 2)
    private BigDecimal limite;

    @Column(name = "saldo_disponivel", precision = 19, scale = 2)
    private BigDecimal saldoDisponivel;

    @Column(name = "data_validade", nullable = false)
    private LocalDate dataValidade;

    @Column(name = "cvv", nullable = false, length = 4)
    private String cvv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id", nullable = false)
    private Account conta;

    @Column(name = "status", nullable = false)
    private boolean status;

    @CreationTimestamp
    @Column(name = "data_emissao", nullable = false, updatable = false)
    private LocalDateTime dataEmissao;
}
