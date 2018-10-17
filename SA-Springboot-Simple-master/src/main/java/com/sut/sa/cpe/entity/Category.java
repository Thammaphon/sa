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
 @ToString @EqualsAndHashCode
public class  Category{
    @Id 
    @SequenceGenerator(name="category_seq",sequenceName="category_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_seq")
    @Column(name="CATEGORY_ID",unique = true, nullable = false)
    private @NonNull Long categoryid;
    private @NonNull String categoryname;
	// public void setCategoryname(Category newCategory) {
    //     this.categoryname=newCategory;
	// }
	public void setCategoryname(String categoryname) {
        this.categoryname=categoryname;
    }
    /**
     * @param categoryid the categoryid to set
     */
    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }
/**
 * @return the categoryname
 */
public String getCategoryname() {
    return categoryname;
}
/**
 * @return the categoryid
 */
public Long getCategoryid() {
    return categoryid;
}


}

