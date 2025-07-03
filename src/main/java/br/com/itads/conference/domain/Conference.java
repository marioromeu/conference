package br.com.itads.conference.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conference")
public class Conference {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false, unique = false)	
	private String name;
	
	@Column(name = "address", nullable = false, unique = false)
	private String address;
	
	@Column(name = "end_date", nullable = false, unique = false)
	private LocalDateTime endDate;
	
	public Conference() {
		super();
	}
	
	public Conference(Long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public Boolean isOpen() {
		if (endDate != null) {
			return LocalDateTime.now().isBefore(endDate);
		}
		return Boolean.FALSE;
	}
	
}
