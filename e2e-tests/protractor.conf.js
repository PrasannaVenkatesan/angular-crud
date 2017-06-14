var HtmlReporter = require('protractor-html-screenshot-reporter');
//var ScreenShotReporter = require('protractor-screenshot-reporter');

var reporter=new HtmlReporter({
    baseDirectory: './protractor-result', // a location to store screen shots.
    docTitle: 'Protractor Demo Reporter',
    docName:    'protractor-demo-tests-report.html'
});
      
exports.config = {
  allScriptsTimeout: 11000,

//seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: [
    '*.js'
  ],

  capabilities: {
    'browserName': 'chrome'
  },

  baseUrl: 'http://localhost:8080/',

  framework: 'jasmine',
  directConnect: true,
 seleniumServerJar: 'C:/Users/prasanna.v/Desktop/demoSpringBoot/node_modules/protractor1/node_modules/webdriver-manager/selenium/selenium-server-standalone-2.53.1.jar',
  jasmineNodeOpts: {
    defaultTimeoutInterval: 30000,
     showColors: true
    
  },
  
 
   onPrepare: function() {
	   jasmine.getEnv().addReporter(reporter);      
   }
};
