package com.saifiahmada.spring.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="kas_keluar")
public class KasKeluar implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String noTransaksi;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date tgl;
	
	private String penerima;
	
	private BigDecimal jumlah;
	
	private String keterangan;
	
	private String giver;
	
	private String approver;
	
	public KasKeluar() {
	
	}

	public String getNoTransaksi() {
		return noTransaksi;
	}

	public void setNoTransaksi(String noTransaksi) {
		this.noTransaksi = noTransaksi;
	}

	public Date getTgl() {
		return tgl;
	}

	public void setTgl(Date tgl) {
		this.tgl = tgl;
	}

	public String getPenerima() {
		return penerima;
	}

	public void setPenerima(String penerima) {
		this.penerima = penerima;
	}

	public BigDecimal getJumlah() {
		return jumlah;
	}

	public void setJumlah(BigDecimal jumlah) {
		this.jumlah = jumlah;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public String getGiver() {
		return giver;
	}

	public void setGiver(String giver) {
		this.giver = giver;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((noTransaksi == null) ? 0 : noTransaksi.hashCode());
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
		KasKeluar other = (KasKeluar) obj;
		if (noTransaksi == null) {
			if (other.noTransaksi != null)
				return false;
		} else if (!noTransaksi.equals(other.noTransaksi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KasMasuk [noTransaksi=" + noTransaksi + "]";
	}

}
