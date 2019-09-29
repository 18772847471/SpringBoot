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
}
