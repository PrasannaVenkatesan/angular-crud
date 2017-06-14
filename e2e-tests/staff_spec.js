'use strict';

/* https://github.com/angular/protractor/blob/master/docs/toc.md */

describe('my app', function() {
it('should automatically redirect to index page when location hash/fragment is empty', function() {
    browser.get('index.html');
    expect(browser.getLocationAbsUrl()).toMatch("/");
  });
  
it('should automatically redirect to index page when location hash/fragment is empty', function() {
    browser.get('index.html#/create');
    //expect(browser.getLocationAbsUrl()).toMatch("/create");
    element(by.model('Staff.name')).sendKeys('Baraneetharan');
    element(by.model('Staff.depart')).sendKeys('Developer');
    element(by.model('Staff.subject')).sendKeys('baraneetharan.ramasamy@kgfsl.com');
    element(by.model('Staff.age')).sendKeys(9790597065);

    element(by.id('create')).click();
    //browser.switchTo().alert().accept();
    //expect(browser.getCurrentUrl()).toEqual('http://localhost:8000/#/create');
    //expect(browser.getCurrentUrl()).toEqual('http://localhost:8000/wwwroot/api/StaffMasters');
    //browser.pause();
  });  

it('should open update page and fill details', function() {
    browser.get('index.html#/update');
    //expect(browser.getLocationAbsUrl()).toMatch("/update");
    element(by.model('Staff.id')).sendKeys(1);
    element(by.model('Staff.empname')).sendKeys('Baraneetharan');
    element(by.model('Staff.designation')).sendKeys('Developer');
    element(by.model('Staff.email')).sendKeys('baraneetharan.ramasamy@kgfsl.com');
    element(by.model('Staff.phone')).sendKeys(9790597065);
   
    element(by.id('update')).click();
    //browser.switchTo().alert().accept();
    //expect(browser.getCurrentUrl()).toEqual('http://localhost:8000/wwwroot/index.html#/update');
    //expect(browser.getCurrentUrl()).toEqual('http://localhost:8000/wwwroot/api/StaffMasters');
    //browser.pause();
  });
  
  it('should open delete page and enter Staff ID', function() {
    browser.get('index.html#/delete');
    //expect(browser.getLocationAbsUrl()).toMatch("/delete");
    element(by.model('Staff.id')).sendKeys(1);
    element(by.id('delete')).click();
    //browser.switchTo().alert().accept();
    //expect(browser.getCurrentUrl()).toEqual('http://localhost:8000/wwwroot/index.html#/delete');
    //expect(browser.getCurrentUrl()).toEqual('http://localhost:8000/wwwroot/api/StaffMasters');
    //browser.pause();
  });
});