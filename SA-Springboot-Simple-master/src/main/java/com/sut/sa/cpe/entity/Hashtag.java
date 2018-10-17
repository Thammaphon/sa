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

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString 
@EqualsAndHashCode
public class  Hashtag{
    @Id 
    @SequenceGenerator(name="hashtag_seq",sequenceName="hashtag_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hashtag_seq")
    @Column(name="HASHTAG_ID",unique = true, nullable = false)
    private @NonNull Long hashtagid;
    private @NonNull String hashtagname;
	public void setHashtagname(String hashtagname) {
            this.hashtagname=hashtagname;
	}

/**
 * @return the hashtagid
 */
public Long getHashtagid() {
    return hashtagid;
}
/**
 * @return the hashtagname
 */
public String getHashtagname() {
    return hashtagname;
}
/**
 * @param hashtagid the hashtagid to set
 */
public void setHashtagid(Long hashtagid) {
    this.hashtagid = hashtagid;
}
}

