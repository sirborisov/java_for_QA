package ru.qa.borisov.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "addressbook")

public class ContactData {

  @Column(name = "firstname")
  @Expose
  private String firstname;

  @Column(name = "lastname")
  @Expose
  private String lastname;

  @Column(name = "nickname")
  @Expose
  private String nickname;

  @Column(name = "address")
  @Type(type = "text")
  @Expose
  private String address;

  @Column(name = "mobile")
  @Type(type = "text")
  @Expose
  private String mobile;

  @Column(name = "work")
  @Type(type = "text")
  @Expose
  private String work;

  @Column(name = "home")
  @Type(type = "text")
  @Expose
  private String home;

  @Transient
  private String allPhones;

  @Column(name = "email")
  @Type(type = "text")
  @Expose
  private String email;

  @Column(name = "email2")
  @Type(type = "text")
  @Expose
  private String email2;

  @Column(name = "email3")
  @Type(type = "text")
  @Expose
  private String email3;

  @Transient
  private String allEmails;

  @Transient
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public File getPhoto() {
    if (photo == null) {
      return null;
    } else {
      return new File(photo);
    }
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", address='" + address + '\'' +
            ", mobile='" + mobile + '\'' +
            ", work='" + work + '\'' +
            ", home='" + home + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", allEmails='" + allEmails + '\'' +
//            ", group='" + group + '\'' +
            ", photo='" + photo + '\'' +
            ", id=" + id +
            '}';
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getHome() {
    return home;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public Groups getGroups() {
    return new Groups(groups);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
    if (work != null ? !work.equals(that.work) : that.work != null) return false;
    if (home != null ? !home.equals(that.home) : that.home != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    return email3 != null ? email3.equals(that.email3) : that.email3 == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    result = 31 * result + (work != null ? work.hashCode() : 0);
    result = 31 * result + (home != null ? home.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + id;
    return result;
  }

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}
