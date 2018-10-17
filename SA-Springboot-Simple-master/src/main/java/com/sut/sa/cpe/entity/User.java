package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;



import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;

@Entity
@Data

@Getter @Setter


// @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
	@Id
    @SequenceGenerator(name="user_seq",sequenceName="user_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    @Column(name="USER_ID",unique = true, nullable = false)
	private @NonNull Long userid;
	private @NonNull String username;

	public User() {}
    public User(Long userid, String username) { //constructor
        this.userid = userid;
        this.username = username;

    }
	public void setUsername(String username) {
		this.username = username;
	}
	// public String getUsername(){
	// 	return username;
	// }
}
