package com.saifiahmada.spring.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mahasiswa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	@Column(length=40, nullable=false)
	private String id;
	
	private String noPeserta;
	
	//@Column(unique=true)
	private String nim;
	
	private String nama;
	
	private String wali;
	
	private String alamat;
	
	private String noTelp;
	
	private String waktuWawancara;
	
	private String gelombang;
	
	private String jalur;
	
	private String imageFoto;
	
	private String tempatLahir;
	
	private Date tglLahir;
	
	private String agama;
	
	private String pilihan1;
	
	private String pilihan2;
	
	private String asalSekolah;
	
	private String jurusanSekolah;
	
	private String informasi;
	
	private String status;
	
	public Mahasiswa() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoPeserta() {
		return noPeserta;
	}

	public void setNoPeserta(String noPeserta) {
		this.noPeserta = noPeserta;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getWali() {
		return wali;
	}

	public void setWali(String wali) {
		this.wali = wali;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getNoTelp() {
		return noTelp;
	}

	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}

	public String getWaktuWawancara() {
		return waktuWawancara;
	}

	public void setWaktuWawancara(String waktuWawancara) {
		this.waktuWawancara = waktuWawancara;
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

	public String getImageFoto() {
		return imageFoto;
	}

	public void setImageFoto(String imageFoto) {
		this.imageFoto = imageFoto;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Date getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(Date tglLahir) {
		this.tglLahir = tglLahir;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getPilihan1() {
		return pilihan1;
	}

	public void setPilihan1(String pilihan1) {
		this.pilihan1 = pilihan1;
	}

	public String getPilihan2() {
		return pilihan2;
	}

	public void setPilihan2(String pilihan2) {
		this.pilihan2 = pilihan2;
	}

	public String getAsalSekolah() {
		return asalSekolah;
	}

	public void setAsalSekolah(String asalSekolah) {
		this.asalSekolah = asalSekolah;
	}

	public String getJurusanSekolah() {
		return jurusanSekolah;
	}

	public void setJurusanSekolah(String jurusanSekolah) {
		this.jurusanSekolah = jurusanSekolah;
	}

	public String getInformasi() {
		return informasi;
	}

	public void setInformasi(String informasi) {
		this.informasi = informasi;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		Mahasiswa other = (Mahasiswa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mahasiswa [id=" + id + "]";
	}
	
	
	
}
