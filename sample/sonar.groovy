@NonCPS
def jsonParse(def json) {
 new groovy.json.JsonSlurperClassic().parseText(json)
}
node{
    stage("test"){
        
      def response = httpRequest ignoreSslErrors:true, authentication: 'sonar',  url: 'http://localhost:9000/api/issues/search'
      def re= jsonParse(response.content);   
      println(re.issues);
      String rows="";
      for (int i=0; i<re.issues.size(); i++) {
          rows=rows+"<tr><td style='background-color:violet'><b>Line Number:</b>"+re.issues[i].textRange.startLine+"</td></tr><tr><td><b>severity:</b>"+re.issues[i].severity+"</td></tr><tr><td><b>Type:</b>"+re.issues[i].type+"</td></tr><tr><td><b>Resolution:</b>"+re.issues[i].resolution+"</td></tr><tr><td><b>Status:</b>"+re.issues[i].status+"</td></tr><tr><td style='color:crimson'><b>Message:</b>"+re.issues[i].message+"</td></tr>"
      }
      writeFile file: 'report.html', text: '<html><style>div{text-align:center; background-color:black; color:white}table{font-family:arial;border-collapse:collapse;width:100%}tr{border:1px solid #dddddd; text-align: left; padding: 8px; background-color: powderblue}</style><body><div><h3>Isuue Report</h3></div><table>'+rows+'</table></body></html>'
    }
}