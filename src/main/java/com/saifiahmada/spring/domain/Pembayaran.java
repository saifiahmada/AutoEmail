package com.saifiahmada.spring.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pembayaran {
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	@Column(length=40, nullable=false)
	private String id;
	
	private String nama;
	
	private String program;
	
	private Date tglBayar;
	
	private String biayaDaftar;
	
	private BigDecimal dpp;
	
	private BigDecimal spp;
	
	private BigDecimal pkl;
	
	private BigDecimal kemahasiswaaan;
	
	private BigDecimal total;
	
	private String penerima;
	
	private String gelombang;
	
	private String jalur;

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public Date getTglBayar() {
		return tglBayar;
	}

	public void setTglBayar(Date tglBayar) {
		this.tglBayar = tglBayar;
	}

	public String getBiayaDaftar() {
		return biayaDaftar;
	}

	public void setBiayaDaftar(String biayaDaftar) {
		this.biayaDaftar = biayaDaftar;
	}

	public BigDecimal getDpp() {
		return dpp;
	}

	public void setDpp(BigDecimal dpp) {
		this.dpp = dpp;
	}

	public BigDecimal getSpp() {
		return spp;
	}

	public void setSpp(BigDecimal spp) {
		this.spp = spp;
	}

	public BigDecimal getPkl() {
		return pkl;
	}

	public void setPkl(BigDecimal pkl) {
		this.pkl = pkl;
	}

	public BigDecimal getKemahasiswaaan() {
		return kemahasiswaaan;
	}

	public void setKemahasiswaaan(BigDecimal kemahasiswaaan) {
		this.kemahasiswaaan = kemahasiswaaan;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getPenerima() {
		return penerima;
	}

	public void setPenerima(String penerima) {
		this.penerima = penerima;
	}

	public String getGelombang() {
		return gelombang;
	}

	public void setGelombang(String gelombang) {
		this.gelombang = gelombang;
	}

	public String getJalur() {
		return jalur;
	}

	public void setJalur(String jalur) {
		this.jalur = jalur;
	}
	
}
