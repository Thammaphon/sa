package com.sut.sa.cpe.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.CascadeType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;

@Entity
@Data

@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Item {
    @Id
    @SequenceGenerator(name="item_seq",sequenceName="item_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_seq")
    @Column(name="ITEM_ID",unique = true, nullable = false)
    private @NonNull Long itemid;
    private @NonNull String itemname;
    private @NonNull String descrition;
   

    // @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
 
    //     private Collection<Hashtag> hashtag;
    @ManyToOne
    @JoinColumn(name="HASHTAG_ID")
    private Hashtag hashtag;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;


	public void setItemname(String itemname) {
            this.itemname=itemname;
    }
    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }/**
     * @return the descrition
     */
    public String getDescrition() {
        return descrition;
    }/**
     * @return the hashtag
     */
    public Hashtag getHashtag() {
        return hashtag;
    }/**
     * @return the itemid
     */
    public Long getItemid() {
        return itemid;
    }/**
     * @return the itemname
     */
    public String getItemname() {
        return itemname;
    }/**
     * @return the user
     */
    public User getUser() {
        return user;
    }/**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }/**
     * @param descrition the descrition to set
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }/**
     * @param hashtag the hashtag to set
     */
    public void setHashtag(Hashtag hashtag) {
        this.hashtag = hashtag;
    }/**
     * @param itemid the itemid to set
     */
    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }/**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }


}
