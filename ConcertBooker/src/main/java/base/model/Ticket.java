package base.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TICKET")
public class Ticket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "BALANCE")
	private int balance;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BOOK_START")
	private Date bookStart;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BOOK_END")
	private Date bookEnd;


    @ManyToOne
    @JoinColumn(name = "CONCERT_ID")
    private Concert concert;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getBookStart() {
		return bookStart;
	}

	public void setBookStart(Date bookStart) {
		this.bookStart = bookStart;
	}

	public Date getBookEnd() {
		return bookEnd;
	}

	public void setBookEnd(Date bookEnd) {
		this.bookEnd = bookEnd;
	}

	public Concert getConcert() {
		return concert;
	}

	public void setConcert(Concert concert) {
		this.concert = concert;
	}

}
