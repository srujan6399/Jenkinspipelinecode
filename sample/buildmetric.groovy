@NonCPS
def jsonParse(def json) {
 new groovy.json.JsonSlurperClassic().parseText(json)
}
node{

    def response = httpRequest ignoreSslErrors:true, authentication: 'jenkins', url:env.JOB_URL+'/api/json'
    def re= jsonParse(response.content);   
    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+re.healthReport[0].score); 
    
    def scr = re.healthReport[0].score;
  
    def response1 = httpRequest ignoreSslErrors:true, httpMode:'POST', authentication: 'sonar',  url: 'http://localhost:9000/api/custom_measures/update?value='+scr+'&id=1'
    def re1= jsonParse(response1.content);   
    println("re1111111"+re1); 

  
  
}