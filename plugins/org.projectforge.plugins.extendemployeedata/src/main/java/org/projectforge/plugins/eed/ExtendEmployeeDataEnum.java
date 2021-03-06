package org.projectforge.plugins.eed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.projectforge.export.AttrColumnDescription;

/**
 * If you change enum entries here, you have to change EmployeeBillingExcelRow accordingly.
 */
public enum ExtendEmployeeDataEnum
{
  /*
  MOBILECONTRACT("plugins.eed.listcare.optionDropDown.costmobilecontract",
      Collections.singletonList(new AttrColumnDescription("mobilecontract", "mobilecontract", "fibu.employee.mobilecontract.title"))), //
  MOBILECHECK("plugins.eed.listcare.optionDropDown.costmobiledevice",
      Collections.singletonList(new AttrColumnDescription("mobilecheck", "mobilecheck", "fibu.employee.mobilecheck.title"))),*/ //
  COSTTRAVEL("plugins.eed.listcare.optionDropDown.costtravel",
      Collections.singletonList(new AttrColumnDescription("costtravel", "costtravel", "fibu.employee.costtravel.title"))), //
  EXPENSES("plugins.eed.listcare.optionDropDown.expenses",
      Collections.singletonList(new AttrColumnDescription("expenses", "expenses", "fibu.employee.expenses.title"))), //
  OVERTIME("plugins.eed.listcare.optionDropDown.overtime",
      Collections.singletonList(new AttrColumnDescription("overtime", "overtime", "fibu.employee.overtime.title"))), //
  BONUS("plugins.eed.listcare.optionDropDown.bonus",
      Collections.singletonList(new AttrColumnDescription("bonus", "bonus", "fibu.employee.bonus.title"))), //
  SPECIALPAYMENT("plugins.eed.listcare.optionDropDown.specialpayment",
      Collections.singletonList(new AttrColumnDescription("specialpayment", "specialpayment", "fibu.employee.specialpayment.title"))), //
  TARGETAGREEMENTS("plugins.eed.listcare.optionDropDown.targetagreements", Collections.singletonList(
      new AttrColumnDescription("targetagreements", "targetagreements", "fibu.employee.targetagreements.title"))), //
  COSTSHOP("plugins.eed.listcare.optionDropDown.costshop",
      Arrays.asList(new AttrColumnDescription("costshop", "costshop", "fibu.employee.costshop.title"),new AttrColumnDescription("costshop","contents","fibu.employee.costshop.contents"))), //
  WEEKENDWORK("plugins.eed.listcare.optionDropDown.weekendwork",
      Arrays.asList(
          new AttrColumnDescription("weekendwork", "workinghourssaturday", "fibu.employee.weekendwork.saturday"),
          new AttrColumnDescription("weekendwork", "workinghourssunday", "fibu.employee.weekendwork.sunday"),
          new AttrColumnDescription("weekendwork", "workinghoursholiday", "fibu.employee.weekendwork.holiday"))), //
  OTHERS("plugins.eed.listcare.optionDropDown.others",
      Collections.singletonList(new AttrColumnDescription("others", "others", "fibu.employee.others.title"))); //

  private final String i18nKeyDropDown;

  private final List<AttrColumnDescription> attrColumnDescriptions;

  ExtendEmployeeDataEnum(String i18nKeyDropDown, List<AttrColumnDescription> attrColumnDescriptions)
  {
    this.i18nKeyDropDown = i18nKeyDropDown;
    this.attrColumnDescriptions = attrColumnDescriptions;
  }

  public String getI18nKeyDropDown()
  {
    return i18nKeyDropDown;
  }

  public List<AttrColumnDescription> getAttrColumnDescriptions()
  {
    return attrColumnDescriptions;
  }

  public static List<AttrColumnDescription> getAllAttrColumnDescriptions()
  {
    List<AttrColumnDescription> resultList = new ArrayList<>();
    for (ExtendEmployeeDataEnum eede : values()) {
      resultList.addAll(eede.getAttrColumnDescriptions());
    }
    return resultList;
  }
}