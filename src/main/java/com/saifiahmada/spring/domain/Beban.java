package com.saifiahmada.spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Beban implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	@Column(length=40, nullable=false)
	private String id;
	
	private String kodeMk;
	private String mataKuliah;
	private int jumlahSks;
	private int teoriDistribusi;
	private int praktikDistribusi;
	private String dosenPengampu;
	private String nama;
	private Double teoriBeban;
	private Double praktikBeban;
	private Double praktikLapanganBeban;
	private String kodeProdi;
	
	public Beban() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKodeMk() {
		return kodeMk;
	}

	public void setKodeMk(String kodeMk) {
		this.kodeMk = kodeMk;
	}

	public String getMataKuliah() {
		return mataKuliah;
	}

	public void setMataKuliah(String mataKuliah) {
		this.mataKuliah = mataKuliah;
	}

	public int getJumlahSks() {
		return jumlahSks;
	}

	public void setJumlahSks(int jumlahSks) {
		this.jumlahSks = jumlahSks;
	}

	public int getTeoriDistribusi() {
		return teoriDistribusi;
	}

	public void setTeoriDistribusi(int teoriDistribusi) {
		this.teoriDistribusi = teoriDistribusi;
	}

	public int getPraktikDistribusi() {
		return praktikDistribusi;
	}

	public void setPraktikDistribusi(int praktikDistribusi) {
		this.praktikDistribusi = praktikDistribusi;
	}

	public String getDosenPengampu() {
		return dosenPengampu;
	}

	public void setDosenPengampu(String dosenPengampu) {
		this.dosenPengampu = dosenPengampu;
	}

	public Double getTeoriBeban() {
		return teoriBeban;
	}

	public void setTeoriBeban(Double teoriBeban) {
		this.teoriBeban = teoriBeban;
	}

	public Double getPraktikBeban() {
		return praktikBeban;
	}

	public void setPraktikBeban(Double praktikBeban) {
		this.praktikBeban = praktikBeban;
	}

	public Double getPraktikLapanganBeban() {
		return praktikLapanganBeban;
	}

	public void setPraktikLapanganBeban(Double praktikLapanganBeban) {
		this.praktikLapanganBeban = praktikLapanganBeban;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getKodeProdi() {
		return kodeProdi;
	}

	public void setKodeProdi(String kodeProdi) {
		this.kodeProdi = kodeProdi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beban other = (Beban) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Beban [id=" + id + "]";
	}
	
}
