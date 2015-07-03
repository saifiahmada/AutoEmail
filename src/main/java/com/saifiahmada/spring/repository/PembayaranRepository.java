package com.saifiahmada.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Pembayaran;

public interface PembayaranRepository extends JpaRepository<Pembayaran, String> { 

}
