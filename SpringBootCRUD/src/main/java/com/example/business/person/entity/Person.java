package com.example.business.person.entity;

import java.util.Date;

public class Person {

  private String  personguid;
  private Integer historyid;
  private String  processinstanceid;
  private Date  processinstancecreatedate;
  private String  name;
  private String  certcode;
  private String  mobile;
  private Integer  culture;
  private Date birthday;
  private Integer valid;
  private String remark;

    public String getPersonguid() {
        return personguid;
    }

    public void setPersonguid(String personguid) {
        this.personguid = personguid;
    }

  public Integer getHistoryid() {
    return historyid;
  }

  public void setHistoryid(Integer historyid) {
    this.historyid = historyid;
  }

  public String getProcessinstanceid() {
    return processinstanceid;
  }

  public void setProcessinstanceid(String processinstanceid) {
    this.processinstanceid = processinstanceid;
  }

  public Date getProcessinstancecreatedate() {
    return processinstancecreatedate;
  }

  public void setProcessinstancecreatedate(Date processinstancecreatedate) {
    this.processinstancecreatedate = processinstancecreatedate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCertcode() {
    return certcode;
  }

  public void setCertcode(String certcode) {
    this.certcode = certcode;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Integer getCulture() {
    return culture;
  }

  public void setCulture(Integer culture) {
    this.culture = culture;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Integer getValid() {
    return valid;
  }

  public void setValid(Integer valid) {
    this.valid = valid;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}
